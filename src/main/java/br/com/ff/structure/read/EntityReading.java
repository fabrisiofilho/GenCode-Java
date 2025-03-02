package br.com.ff.structure.read;

import br.com.ff.models.Entity;
import br.com.ff.models.Field;
import br.com.ff.structure.write.GeneratorText;
import br.com.ff.structure.write.ImportMap;
import br.com.ff.structure.write.template.Template;
import br.com.ff.structure.write.template.child.EntityTemplate;
import br.com.ff.utils.CreateClassGenerator;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityReading {

    public void create(File outputDirectory, String basePackage, List<Entity> entities) {
        for (Entity entity : entities) {
            EntityTemplate template =new EntityTemplate();
            String entityClass = generateEntity(template, basePackage, entity);
            CreateClassGenerator.writeToFile(
                entityClass,
                outputDirectory.getAbsolutePath(),
                basePackage,
                entity.getName(),
                template.getClassTemplate(entity.getName())
            );
        }
    }
    private String generateEntity(Template template, String basePackage, Entity entity) {
        String imports = String.join(
            "\n",
            ImportMap.getImportsByKeys(List.of("lombok", "jakartaPersistence", "serializable"))
        );

        String className = entity.getName();

        String fields = entity.getFields().stream()
                .map(field -> generateField(field, template))
                .collect(Collectors.joining("\n    "));

        Map<String, String> values = Map.of(
            "PACKAGE", basePackage,
            "IMPORTS", imports,
            "CLASS_NAME", template.getClassTemplate(className),
            "TABLE_NAME", entity.getTableName(),
            "SCHEMA", entity.getSchema(),
            "FIELDS", fields
        );

        return GeneratorText.processTemplate(template, values);
    }

    private String generateField(Field field, Template template) {
        StringBuilder fieldBuilder = new StringBuilder();

        String type = field.getType();
        String name = field.getName();

        if (Boolean.TRUE.equals(field.getPrimaryKey())) {
            fieldBuilder.append("    @Id\n");
            fieldBuilder.append("    @GeneratedValue(strategy = GenerationType.IDENTITY)\n");
        }

        if (field.getRelationship() != null) {
            switch (field.getRelationship()) {
                case "OneToMany":
                    fieldBuilder.append("    @OneToMany(mappedBy = \"" + field.getRelationshipMappedBy() + "\")\n");
                    break;
                case "ManyToOne":
                    fieldBuilder.append("    @ManyToOne\n");
                    fieldBuilder.append("    @JoinColumn(name = \"" + field.getRelationshipJoinColumn() + "\")\n");
                    break;
                case "OneToOne":
                    fieldBuilder.append("    @OneToOne\n");
                    fieldBuilder.append("    @JoinColumn(name = \"" + field.getRelationshipJoinColumn() + "\")\n");
                    break;
                case "ManyToMany":
                    fieldBuilder.append("    @ManyToMany\n");
                    fieldBuilder.append("    @JoinTable(\n");
                    fieldBuilder.append("        name = \"" + field.getRelationshipJoinColumn() + "\",\n");
                    fieldBuilder.append("        joinColumns = @JoinColumn(name = \"" + field.getRelationshipInverseJoinColumn() + "\"),\n");
                    fieldBuilder.append("        inverseJoinColumns = @JoinColumn(name = \"" + field.getRelationshipJoinColumn() + "\")\n");
                    fieldBuilder.append("    )\n");
                    break;
            }
        }

        fieldBuilder.append("    private ").append(type).append(" ").append(template.toCamelCase(name)).append(";");

        return fieldBuilder.toString();
    }

}
