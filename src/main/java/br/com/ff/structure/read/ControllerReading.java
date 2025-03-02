package br.com.ff.structure.read;

import br.com.ff.models.Entity;
import br.com.ff.structure.write.GeneratorText;
import br.com.ff.structure.write.ImportMap;
import br.com.ff.structure.write.template.Template;
import br.com.ff.structure.write.template.child.ControllerTemplate;
import br.com.ff.utils.CreateClassGenerator;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ControllerReading {

    public void create(File outputDirectory, String basePackage, List<Entity> entities) {
        for (Entity entity : entities) {
            ControllerTemplate template = new ControllerTemplate();
            String controllerClass = generateController(template, basePackage, entity);
            CreateClassGenerator.writeToFile(
                controllerClass,
                outputDirectory.getAbsolutePath(),
                basePackage,
                entity.getName(),
                template.getClassTemplate(entity.getName())
            );
        }
    }

    private String generateController(Template template, String basePackage, Entity entity) {

        String imports = String.join("\n", ImportMap.getImportsByKeys(List.of("restController", "requestMapping", "requiredArgsConstructor")));

        Map<String, String> values = Map.of(
            "PACKAGE", basePackage,
            "IMPORTS", imports,
            "CLASS_NAME", template.getClassTemplate(entity.getName()),
            "PATH", entity.getName().toLowerCase()
        );

        return GeneratorText.processTemplate(template, values);
    }
}
