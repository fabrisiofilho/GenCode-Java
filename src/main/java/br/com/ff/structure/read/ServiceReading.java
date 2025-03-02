package br.com.ff.structure.read;

import br.com.ff.models.Entity;
import br.com.ff.structure.write.GeneratorText;
import br.com.ff.structure.write.ImportMap;
import br.com.ff.structure.write.template.Template;
import br.com.ff.structure.write.template.child.ServiceTemplate;
import br.com.ff.utils.CreateClassGenerator;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ServiceReading {

    public void create(File outputDirectory, String basePackage, List<Entity> entities) {
        for (Entity entity : entities) {
            ServiceTemplate template = new ServiceTemplate();
            String serviceClass = generateService(template, basePackage, entity);
            CreateClassGenerator.writeToFile(
                serviceClass,
                outputDirectory.getAbsolutePath(),
                basePackage,
                entity.getName(),
                template.getClassTemplate(entity.getName())
            );
        }
    }

    private String generateService(Template template, String basePackage, Entity entity) {
        String imports = String.join("\n", ImportMap.getImportsByKeys(List.of("service", "requiredArgsConstructor")));

        Map<String, String> values = Map.of(
                "PACKAGE", basePackage,
                "IMPORTS", imports,
                "CLASS_NAME", template.getClassTemplate(entity.getName()),
                "INTERFACE_CLASS", entity.getName() + "Service"
        );

        return GeneratorText.processTemplate(template, values);
    }
}

