package br.com.ff.structure.read;

public enum RelationshipTypeEnum {
    ONE_TO_MANY("OneToMany"),
    MANY_TO_ONE("ManyToOne"),
    ONE_TO_ONE("OneToOne"),
    MANY_TO_MANY("ManyToMany");

    private final String value;

    RelationshipTypeEnum(String value) {
        this.value = value;
    }

    public static RelationshipTypeEnum fromString(String value) {
        for (RelationshipTypeEnum type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Relacionamento inválido: " + value);
    }
}
