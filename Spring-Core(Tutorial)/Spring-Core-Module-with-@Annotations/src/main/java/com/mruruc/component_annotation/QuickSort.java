package com.mruruc.component_annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "quickSort")
@Primary
public class QuickSort implements SortingAlgorithm{
    @Override
    public void sort() {
        System.out.println("Quick Sort :) ");
    }
}
