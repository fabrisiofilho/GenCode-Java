package br.com.ff.models;

import br.com.ff.utils.Required;

import java.util.List;

public class Field {

    @Required
    private Boolean primaryKey = false;
    private String columnName;
    @Required
    private String name;
    @Required
    private String type;
    private String defaultValue;
    private String relationship;
    private String relationshipMappedBy;
    private String relationshipJoinColumn;
    private String relationshipInverseJoinColumn;
    public List<Validation> validations;

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getRelationshipMappedBy() {
        return relationshipMappedBy;
    }

    public String getRelationshipJoinColumn() {
        return relationshipJoinColumn;
    }

    public String getRelationshipInverseJoinColumn() {
        return relationshipInverseJoinColumn;
    }

    public List<Validation> getValidations() {
        return validations;
    }
}
