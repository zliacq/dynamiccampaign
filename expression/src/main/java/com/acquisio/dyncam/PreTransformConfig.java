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
public class PreTransformConfig {

    private List<Formula> rowTransforms;
    private List<Formula> filterOutRules;
}