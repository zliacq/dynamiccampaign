/*
 * Software property of Acquisio. Copyright 2003-2017.
 */
package com.acquisio.dyncam;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author Zhong Li (zli@acquisio.com)
 */
public class FormulaParser {

    private ExpressionParser expressionParser = new SpelExpressionParser();
    private StandardEvaluationContext context = new StandardEvaluationContext();

    public FormulaParser() {
        initial();
    }

    private void initial() {
        try {
            context.registerFunction("titleCase", WordUtils.class.getDeclaredMethod("capitalize", String.class));
            context.registerFunction("lowerCase", StringUtils.class.getDeclaredMethod("lowerCase", String.class));

            context.registerFunction("endsWith", StringUtils.class.getDeclaredMethod("endsWith", CharSequence.class, CharSequence.class));
            context.registerFunction("replaceString", StringUtils.class.getDeclaredMethod("replace", String.class, String.class, String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static final Character CSV_DELIMITER = 'c';

    public void parse(PreTransformConfig preTransformConfig, String sourceFile, String targetFile) {

        try {
            CsvReader csvReader = new CsvReader(sourceFile);
            CsvWriter csvWriter = new CsvWriter(targetFile, CSV_DELIMITER, Charset.forName("UTF-8"));
            csvWriter.setDelimiter(',');
            csvReader.readHeaders();

            // write headers
            for (Formula formula : preTransformConfig.getRowTransforms()) {
                csvWriter.write(formula.getCalculatedColumn().getName());
            }
            csvWriter.endRecord();

            // transform rows
            while (csvReader.readRecord()) {
                Boolean filterOut = false;
                // filter out rows
                for (Formula filterOutRule : preTransformConfig.getFilterOutRules()) {
                    for (Column column : filterOutRule.getSourceColumns()) {
                        context.setVariable(column.getName(), csvReader.get(column.getName()));
                    }
                    filterOut = expressionParser.parseExpression(filterOutRule.getExpression()).getValue(context, Boolean.class);
                }

                // transform rows
                if (!filterOut) {
                    for (Formula formula : preTransformConfig.getRowTransforms()) {
                        if (formula.getSourceColumns() != null) {
                            for (Column column : formula.getSourceColumns()) {
                                context.setVariable(column.getName(), csvReader.get(column.getName()));
                            }
                        }

                        String result = expressionParser.parseExpression(formula.getExpression()).getValue(context, String.class);
                        csvWriter.write(result);
                    }
                    csvWriter.endRecord();
                }
            }

            csvReader.close();
            csvWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}