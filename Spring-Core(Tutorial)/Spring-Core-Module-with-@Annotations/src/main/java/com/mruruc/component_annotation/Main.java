package com.mruruc.component_annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    ////================Traditional Way==============

//        SortingAlgorithm bubbleSort=new BubbleSort();
//        SortingAlgorithm quickSort=new QuickSort();
//        SortingAlgorithm mergeSort=new MergeSort();




//           bubbleSort.sort();
//           quickSort.sort();
//           mergeSort.sort();

     //=================== With Spring Ban ===========================


     // var context=new AnnotationConfigApplicationContext(Sort_Config.class,Sort_Config2.class);
//
//        BubbleSort bubbleSort = (BubbleSort) context.getBean("bubbleSort");
//        bubbleSort.sort();
//
//        QuickSort quickSort=(QuickSort)context.getBean("quickSort");
//        quickSort.sort();
//
//        MergeSort mergeSort= (MergeSort) context.getBean("mergeSort");
//
//        mergeSort.sort();

    //===============With Loose Coupling=================

       // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

      //  context.getBean( "sort");


      //==============With Spring Component Annotation Call the beans With specified name =================
/*        var context=new AnnotationConfigApplicationContext(Sort_Config3.class);

    // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        SortingAlgorithm bubbleSort = (SortingAlgorithm) context.getBean("bubbleSort");

        bubbleSort.sort();

        SortingAlgorithm mergeSort = (SortingAlgorithm) context.getBean("mergeSort");
        mergeSort.sort();

        var quickSort = (SortingAlgorithm) context.getBean("quickSort");
        quickSort.sort();*/


    //======================Calling the Beans with Specified class Name ===============

        var context = new AnnotationConfigApplicationContext(Sort_Config3.class);

   //     Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        SortingAlgorithm bean = context.getBean(SortingAlgorithm.class);
        bean.sort();


    }
}
