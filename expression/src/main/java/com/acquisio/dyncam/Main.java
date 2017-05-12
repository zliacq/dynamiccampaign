package com.acquisio.dyncam;/*
 * Software property of Acquisio. Copyright 2003-2017.
 */

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.yaml.snakeyaml.Yaml;

/**
 * @author Zhong Li (zli@acquisio.com)
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        ExpressionParser parser = new SpelExpressionParser();
//        StandardEvaluationContext context = new StandardEvaluationContext();
//        try {
//            context.registerFunction("titleCase", WordUtils.class.getDeclaredMethod("capitalize", new Class[] {String.class}));
//            context.registerFunction("lowerCase", StringUtils.class.getDeclaredMethod("lowerCase", String.class));
//            context.registerFunction("endsWith", StringUtils.class.getDeclaredMethod("endsWith", CharSequence.class, CharSequence.class));
//            context.registerFunction("replaceString", StringUtils.class.getDeclaredMethod("replace", String.class, String.class, String.class));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        String helloWorldReversed = parser.parseExpression(
//                "#replaceString(#lowerCase(#titleCase('it is a lovely day?')),'a', 'b') == null ? 'empty' : 'not empty'").getValue(context, String.class);
//        System.out.println(helloWorldReversed);
//
//        CsvReader csvReader = new CsvReader("E:\\ABC\\vauto\\chellaul_20170504_073832.csv");
//
//        CsvWriter csvWriter = new CsvWriter("E:\\ABC\\vauto\\bbb.csv", ',', Charset.forName("UTF-8"));
//
//        csvReader.readHeaders();
//        String[] sourceHeaders = csvReader.getHeaders();
//        csvWriter.writeRecord(sourceHeaders);
//        csvReader.readRecord();
//        String[]  values = csvReader.getValues();
//
//
//        csvWriter.flush();
//
//        csvWriter.close();

        // load the configuration
//        Yaml yaml = new Yaml();
//        PreTransformConfig config;
//        try (InputStream in = Files.newInputStream(Paths.get("pre_transform_BTP.yaml"))) {
//            config = yaml.loadAs(in, PreTransformConfig.class);
//
//            String sourceFile = "E:\\ABC\\vauto\\BTPDigitalGroup_20170510_2308.csv";
//            String targetFile = "E:\\ABC\\vauto\\bbb.csv";
//
//            FormulaParser formulaParser = new FormulaParser();
//            formulaParser.parse(config, sourceFile, targetFile);
//
//
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }

        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
    }
}