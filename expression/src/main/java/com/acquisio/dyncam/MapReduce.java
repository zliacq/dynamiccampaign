///*
// * Software property of Acquisio. Copyright 2003-2017.
// */
//package com.acquisio.dyncam;
//
//import com.csvreader.CsvReader;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.StringReader;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @author Zhong Li (zli@acquisio.com)
// */
//public class MapReduce {
//
//    public HashMap<String, Integer[]> getCsvMap(String csvFile, List<String> columnNames) {
//        // <K,V> := <Company, [Downloaded, Watched, Subscribed]>
//        HashMap<String, Integer[]> csvMap = new HashMap<String, Integer[]>();
//
//        try {
//            CsvReader csvReader = new CsvReader(csvFile);
//
//            String csvLine;
//            // Create map
//            try {
//                while (csvReader.readRecord()) {
//                    try {
//                        String company = csvColumns[0].trim();
//                        String actionsType = csvColumns[1].trim();
//                        Integer[] columnValues = csvMap.get(company);
//
//                        if (columnValues == null) {
//                            columnValues = new Integer[3];
//                            columnValues[0] = columnValues[1] = columnValues[2] = 0;
//                        }
//                        columnValues[0] = columnValues[0] + (actionsType.equals("Downloaded") ? 1 : 0);
//                        columnValues[1] = columnValues[1] + (actionsType.equals("Watched") ? 1 : 0);
//                        columnValues[2] = columnValues[2] + (actionsType.equals("Subscribed") ? 1 : 0);
//
//                        if (!company.equals("Company")) {
//                            csvMap.put(company, columnValues);
//                        }
//                    } catch (Exception nfe) {
//                        //TODO: handle NumberFormatException
//                    }
//                }
//            } catch (Exception e) {
//                //TODO: handle IOException
//            }
//        } catch (FileNotFoundException e) {
//            //TODO: handle NumberFormatException
//        }
//        return csvMap;
//    }
//}