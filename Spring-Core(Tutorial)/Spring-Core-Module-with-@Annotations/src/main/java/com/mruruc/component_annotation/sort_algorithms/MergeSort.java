package com.mruruc.component_annotation.sort_algorithms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value ="mergeSort")
@Qualifier(value = "mergeSort")
public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort() {
        System.out.println("Merge Sort :(");
    }
}
