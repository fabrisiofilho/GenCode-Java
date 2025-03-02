package br.com.ff.structure.read;

import br.com.ff.models.Entity;
import br.com.ff.structure.write.GeneratorText;
import br.com.ff.structure.write.ImportMap;
import br.com.ff.structure.write.template.Template;
import br.com.ff.structure.write.template.child.JpaRepositoryTemplate;
import br.com.ff.utils.CreateClassGenerator;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JpaRepositoryReading {

    public void create(File outputDirectory, String basePackage, List<Entity> entities) {
        for (Entity entity : entities) {
            JpaRepositoryTemplate template = new JpaRepositoryTemplate();
            String repositoryClass = generateRepository(template, basePackage, entity);
            CreateClassGenerator.writeToFile(
                repositoryClass,
                outputDirectory.getAbsolutePath(),
                basePackage,
                entity.getName(),
                template.getClassTemplate(entity.getName())
            );
        }
    }

    private String generateRepository(Template template, String basePackage, Entity entity) {
        String imports = String.join("\n", ImportMap.getImportsByKeys(List.of("repository", "jpaRepository")));

        Map<String, String> values = Map.of(
            "PACKAGE", basePackage,
            "IMPORTS", imports,
            "CLASS_NAME", template.getClassTemplate(entity.getName()),
            "ENTITY_CLASS", entity.getName(),
            "ENTITY_KEY_TYPE", "Long"
        );

        return GeneratorText.processTemplate(template, values);
    }
}

