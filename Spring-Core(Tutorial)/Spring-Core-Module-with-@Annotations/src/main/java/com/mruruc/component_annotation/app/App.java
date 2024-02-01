package com.mruruc.component_annotation.app;

import com.mruruc.component_annotation.config.Sort_Config;
import com.mruruc.component_annotation.config.Sort_Config3;
import com.mruruc.component_annotation.sort_algorithms.SortingAlgorithm;
import com.mruruc.component_annotation.sort_algorithms.BubbleSort;
import com.mruruc.component_annotation.sort_algorithms.MergeSort;
import com.mruruc.component_annotation.sort_algorithms.QuickSort;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
    ////================Traditional Way==============

      /*  SortingAlgorithm bubbleSort=new BubbleSort();
        SortingAlgorithm quickSort=new QuickSort();
        SortingAlgorithm mergeSort=new MergeSort();




           bubbleSort.sort();
           quickSort.sort();
           mergeSort.sort();*/

     //=================== With Spring Ban ===========================


//      var context=new AnnotationConfigApplicationContext(Sort_Config.class);
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
//
//        context.close();

    //===============With Loose Coupling=================

       // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

      //  context.getBean( "sort");


      //==============With Spring Component Annotation Call the beans With specified name =================
//        var context=new AnnotationConfigApplicationContext(Sort_Config3.class);
//
//    // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//
//        SortingAlgorithm bubbleSort = (SortingAlgorithm) context.getBean("bubbleSort");
//
//        bubbleSort.sort();
//
//        SortingAlgorithm mergeSort = (SortingAlgorithm) context.getBean("mergeSort");
//        mergeSort.sort();
//
//        var quickSort = (SortingAlgorithm) context.getBean("quickSort");
//        quickSort.sort();
//
//        context.close();


    //======================Calling the Beans with Specified class Name ===============

        var context = new AnnotationConfigApplicationContext(Sort_Config3.class);

   //     Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        SortingAlgorithm bean = context.getBean(SortingAlgorithm.class);
        bean.sort();

        context.close();

    }
}
