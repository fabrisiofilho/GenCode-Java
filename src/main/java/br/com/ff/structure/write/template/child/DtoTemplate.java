package br.com.ff.structure.write.template.child;

import br.com.ff.structure.write.template.Template;

public class DtoTemplate extends Template {

    private static final String TEMPLATE =
        """
        package {{PACKAGE}};
    
        {{IMPORTS}}
        
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public class {{CLASS_NAME}} {
        
        {{FIELDS}}
        
        }
        """;

    private static final String SUFFIX =
        """
        DTO
        """;

    public DtoTemplate() {
        super(TEMPLATE, null, SUFFIX);
    }
}
