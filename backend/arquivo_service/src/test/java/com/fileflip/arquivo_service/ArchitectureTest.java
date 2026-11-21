package com.fileflip.arquivo_service;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.fileflip.arquivo_service", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

    public ArchitectureTest() {
        super();
    }

    // 1. Garante que cada tipo de classe esteja no seu respectivo pacote/camada
    @ArchTest
    static final ArchRule controllers_devem_estar_no_pacote_controller =
            classes().that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("..controller..");

    @ArchTest
    static final ArchRule services_devem_estar_no_pacote_service =
            classes().that().haveSimpleNameEndingWith("Service")
                    .or().haveSimpleNameEndingWith("Mapper")
                    .should().resideInAPackage("..service..");

    @ArchTest
    static final ArchRule repositories_devem_estar_no_pacote_repository =
            classes().that().haveSimpleNameEndingWith("Repository")
                    .should().resideInAPackage("..repository..");

    @ArchTest
    static final ArchRule models_devem_estar_no_pacote_model =
            classes().that().haveSimpleName("Arquivo")
                    .or().haveSimpleName("ArquivoType")
                    .should().resideInAPackage("..model..");

    // 2. Garante a hierarquia de dependências entre as camadas
    @ArchTest
    static final ArchRule dependencias_entre_camadas_devem_ser_respeitadas =
            layeredArchitecture()
                    .consideringAllDependencies()
                    .optionalLayer("Controller").definedBy("..controller..")
                    .optionalLayer("Service").definedBy("..service..")
                    .optionalLayer("Repository").definedBy("..repository..")
                    .optionalLayer("Model").definedBy("..model..")

                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                    .whereLayer("Model").mayOnlyBeAccessedByLayers("Repository", "Service", "Controller");
}
