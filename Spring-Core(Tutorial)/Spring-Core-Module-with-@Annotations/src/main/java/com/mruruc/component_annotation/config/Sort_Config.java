package com.mruruc.component_annotation.config;

import com.mruruc.component_annotation.sort_algorithms.BubbleSort;
import com.mruruc.component_annotation.sort_algorithms.MergeSort;
import com.mruruc.component_annotation.sort_algorithms.QuickSort;
import com.mruruc.component_annotation.sort_algorithms.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Sort_Config {
    @Bean
    @Qualifier(value = "bubbleSort")
    public SortingAlgorithm bubbleSort(){
        return new BubbleSort();
    }

    @Bean
    @Primary
    public SortingAlgorithm quickSort(){
        return new QuickSort();
    }

    @Bean
    @Qualifier(value = "mergeSort")
    public SortingAlgorithm mergeSort(){
        return new MergeSort();
    }

}
