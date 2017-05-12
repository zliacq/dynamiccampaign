/*
 * Software property of Acquisio. Copyright 2003-2017.
 */
package com.acquisio.dyncam;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhong Li (zli@acquisio.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formula {

    private String expression;
    private List<Column> sourceColumns;
    private Column calculatedColumn;

}