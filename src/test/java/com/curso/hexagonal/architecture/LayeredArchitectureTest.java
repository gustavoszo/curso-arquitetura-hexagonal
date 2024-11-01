package com.curso.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.curso.hexagonal")
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layered_architecture_test = layeredArchitecture()
        .consideringAllDependencies()
        .layer("AdaptersIn").definedBy("..adapters.in..")
        .layer("AdaptersOut").definedBy("..adapters.out..")
        .layer("UseCase").definedBy("..application.core.usecases..")
        .layer("PortsIn").definedBy("..application.core.ports.in..")
        .layer("PortsOut").definedBy("..application.core.ports.out..")
        .layer("Config").definedBy("..configuration..")
        .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
        .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
        .whereLayer("Config").mayNotBeAccessedByAnyLayer();
    
}
