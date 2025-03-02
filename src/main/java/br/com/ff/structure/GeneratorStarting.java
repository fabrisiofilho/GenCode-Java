package br.com.ff.structure;

import br.com.ff.utils.parser.ParsedData;
import br.com.ff.structure.read.*;

import java.io.File;

public class GeneratorStarting {

    public static void generate(File outputDirectory, String basePackage, ParsedData parsedData) {
        EntityReading entityReading = new EntityReading();
        entityReading.create(outputDirectory, basePackage, parsedData.getEntities());

        ControllerReading controllerReading = new ControllerReading();
        controllerReading.create(outputDirectory, basePackage, parsedData.getEntities());

        DtoReading dtoReading = new DtoReading();
        dtoReading.create(outputDirectory, basePackage, parsedData.getEntities());

        InterfaceServiceReading interfaceServiceReading = new InterfaceServiceReading();
        interfaceServiceReading.create(outputDirectory, basePackage, parsedData.getEntities());

        ServiceReading serviceReading = new ServiceReading();
        serviceReading.create(outputDirectory, basePackage, parsedData.getEntities());

        JpaRepositoryReading jpaRepositoryReading = new JpaRepositoryReading();
        jpaRepositoryReading.create(outputDirectory, basePackage, parsedData.getEntities());
    }

}
