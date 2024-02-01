package com.mruruc.understanding_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Primary;

@Configuration
public class Employee_Config {

    @Bean(
            name = "Security"

    )
    public Employee out_Door_Security(){
        return new Employee("Nello");
    }

    //init attribute=
    /**
    * The init-method attribute specifies a method that is to be called on the bean
    * immediately after it is instantiated and dependency-injected by the Spring container.
    * This method is typically used to set up resources or to perform any setup that is required before the bean can be used.
    * The method specified for init-method should have no parameters and a void return type.
    * */

    //destroy attribute=
    /**
    *  The destroyMethod attribute specifies a method that is to be called on
    *  the bean just before the Spring container removes the bean from its context
    *  (i.e., when the container is shut down or the context is refreshed).
    *  This method is typically used to clean up resources that the bean has been holding.
    *  Just like the initMethod, the destroyMethod should also have no parameters and a void return type.
    *  */

    @Bean(
          //  initMethod = "init",
           // destroyMethod = "destroy"
    )
    public Employee manager(){
        return new Employee("Mr Copper");
    }



    //Bean Aliasing

    /**
     * This allows a bean to be accessed through multiple names.
     * An alias is simply an alternative name given to a bean,
     * which can be handy when a bean needs to be referred by a different name in certain contexts or for certain configurations.
     * In the XML configuration,we can define aliases using the <alias> tag or the alias attribute in the <bean> tag.
     * In Java configuration, we can use @Bean(name={"name1","name2"}) to define aliases.
     */

    @Bean(name = {"gardener","garden","Mr_Atolos"})
    public Employee gardener(){
        return new Employee("Mr Atolos");
    }

    //Bean Description

    /**
     *The textual description to associate with the bean definition.
     *
     */
    @Bean
    @Description("Mr Zig_Zag is an new Employee!")
    public Employee teacher(){
        return new Employee("Mr Zig_Zak");
    }

}
