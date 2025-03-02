package br.com.ff.structure.read;

import br.com.ff.models.Entity;
import br.com.ff.structure.write.template.Template;
import br.com.ff.structure.write.template.child.InterfaceServiceTemplate;
import br.com.ff.utils.generator.CreateClassGenerator;
import br.com.ff.utils.generator.GeneratorText;
import br.com.ff.utils.imports.ImportMap;

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
        String imports = String.join("\n", ImportMap.getImportsByKeys(List.of("list")));

        String dtoClass = entity.getName() + "DTO";
        String idType = "Long";

        Map<String, String> values = Map.of(
            "PACKAGE", basePackage,
            "IMPORTS", imports,
            "CLASS_NAME", template.getClassTemplate(entity.getName()),
            "DTO_CLASS", dtoClass,
            "ID_TYPE", idType
        );

        return GeneratorText.processTemplate(template, values);
    }
}