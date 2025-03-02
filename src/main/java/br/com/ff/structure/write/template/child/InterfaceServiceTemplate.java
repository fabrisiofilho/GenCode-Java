package br.com.ff.structure.write.template.child;

import br.com.ff.structure.write.template.Template;

public class InterfaceServiceTemplate extends Template {

    private static final String TEMPLATE =
        """
        package {{PACKAGE}};
    
        {{IMPORTS}}
        
        public interface {{CLASS_NAME}} {
        
        {{DTO_CLASS}} findById({{ID_TYPE}} id);
        
        List<{{DTO_CLASS}}> findAll();
        
        {{DTO_CLASS}} create({{DTO_CLASS}} dto);
        
        {{DTO_CLASS}} update({{ID_TYPE}} id, {{DTO_CLASS}} dto);
        
        void delete({{ID_TYPE}} id);
        
        {{DTO_CLASS}} alterStatus({{ID_TYPE}} id, String status);
        
        }
        """;


    private static final String SUFFIX =
        """
        Service
        """;

    public InterfaceServiceTemplate() {
        super(TEMPLATE, null, SUFFIX);
    }

}
