package br.com.ff.structure.read;

import br.com.ff.models.Entity;
import br.com.ff.structure.write.GeneratorText;
import br.com.ff.structure.write.template.Template;
import br.com.ff.structure.write.template.child.InterfaceServiceTemplate;
import br.com.ff.utils.CreateClassGenerator;

import java.io.File;
import java.util.List;
import java.util.Map;

public class InterfaceServiceReading {

    public void create(File outputDirectory, String basePackage, List<Entity> entities) {
        for (Entity entity : entities) {
            InterfaceServiceTemplate template = new InterfaceServiceTemplate();
            String interfaceServiceClass = generateInterfaceService(template, basePackage, entity);
            CreateClassGenerator.writeToFile(
                interfaceServiceClass,
                outputDirectory.getAbsolutePath(),
                basePackage,
                entity.getName(),
                template.getClassTemplate(entity.getName())
            );
        }
    }

    private String generateInterfaceService(Template template, String basePackage, Entity entity) {
        Map<String, String> values = Map.of(
            "PACKAGE", basePackage,
            "IMPORTS", "",
            "CLASS_NAME", template.getClassTemplate(entity.getName())
        );

        return GeneratorText.processTemplate(template, values);
    }
}