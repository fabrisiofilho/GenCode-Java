package br.com.ff.models;

import br.com.ff.utils.Required;

import java.util.List;
import java.util.Objects;

public class Entity {

    private String schema;
    private String tableName;
    private String sequenceName;
    @Required
    private String name;
    @Required
    private List<Field> fields;

    public String getSchema() {
        if (Objects.isNull(schema)) {
            return name.toLowerCase();
        }
        return schema;
    }

    public String getTableName() {
        if (Objects.isNull(tableName)) {
            return name.toLowerCase();
        }
        return tableName;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public String getName() {
        return name;
    }

    public List<Field> getFields() {
        return fields;
    }
}
