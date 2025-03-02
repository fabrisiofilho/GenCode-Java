package br.com.ff.utils;

import java.lang.reflect.Field;
import java.util.Collection;

public class RequiredValidation {

    public static void validateRequiredFields(Object obj) {
        if (obj == null) {
            return;
        }

        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.trySetAccessible();
                Object value = getObject(obj, field);

                if (value != null) {
                    if (value instanceof Collection<?>) {
                        for (Object item : (Collection<?>) value) {
                            validateRequiredFields(item);
                        }
                    } else if (!value.getClass().isPrimitive() && !value.getClass().getName().startsWith("java.")) {
                        validateRequiredFields(value);
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao validar campos obrigatórios.", e);
        }
    }

    private static Object getObject(Object obj, Field field) throws IllegalAccessException {
        Object value = field.get(obj);

        if (field.isAnnotationPresent(Required.class)) {
            if (value == null ||
                    (value instanceof String && ((String) value).isEmpty()) ||
                    (value instanceof Collection && ((Collection<?>) value).isEmpty())) {
                throw new IllegalArgumentException("O campo " + field.getName() + " é obrigatório e não pode ser nulo ou vazio.");
            }
        }
        return value;
    }

}
