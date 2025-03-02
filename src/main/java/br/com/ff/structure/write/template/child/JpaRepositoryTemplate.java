package br.com.ff.structure.write.template.child;

import br.com.ff.structure.write.template.Template;

public class JpaRepositoryTemplate extends Template {

    private static final String TEMPLATE =
        """
        package {{PACKAGE}};
    
        {{IMPORTS}}
        
        @Repository
        public interface {{CLASS_NAME}} extends JpaRepository<{{ENTITY_CLASS}}, {{ENTITY_KEY_TYPE}}> {
        
        {{METHODS}}
        
        }
        """;

    private static final String SUFFIX =
        """
        Repository
        """;

    public JpaRepositoryTemplate() {
        super(TEMPLATE, null, SUFFIX);
    }

}
