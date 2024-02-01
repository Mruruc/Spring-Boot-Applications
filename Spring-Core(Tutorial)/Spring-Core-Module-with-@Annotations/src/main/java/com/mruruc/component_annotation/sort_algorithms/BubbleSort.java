package com.mruruc.component_annotation.sort_algorithms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "bubbleSort")
@Qualifier(value = "bubbleSort")
public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort() {
        System.out.println("Bubble Sort :) ");
    }
}
