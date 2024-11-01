package com.curso.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.curso.hexagonal")
public class NamingConventionTest {
    
    @ArchTest
    public static final ArchRule controller_classes_must_be_into_controller_package = classes()
        .that()
        .haveNameMatching(".*Controller")
        .should()
        .resideInAPackage("..adapters.in.controller")
        .as("controller classes reside in adapter.in.controller package");
        
    @ArchTest
    public static final ArchRule mapper_classes_must_be_into_mapper_packages = classes()
        .that()
        .haveNameMatching(".*Mapper")
        .should()
        .resideInAnyPackage("..adapters.in.consumer.mapper", "adapters.in.controller.dto.mapper", "adapters.out.mapper")
        .as("controller classes reside in adapters.in.consumer.mapper, adapters.in.controller.dto.mapper, adapters.out.mapper package");
        
    @ArchTest
    public static final ArchRule should_be_suffixed_controller = classes()
        .that()
        .resideInAPackage("..controller")
        .should()
        .haveSimpleNameEndingWith("Controller");

}
