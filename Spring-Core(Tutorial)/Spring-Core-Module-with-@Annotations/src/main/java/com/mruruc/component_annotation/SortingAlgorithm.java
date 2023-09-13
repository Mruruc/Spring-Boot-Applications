package com.mruruc.component_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public interface SortingAlgorithm {
    void sort();
}
