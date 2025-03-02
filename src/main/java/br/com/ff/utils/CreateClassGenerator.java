package br.com.ff.utils;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateClassGenerator {

    public static void writeToFile(String content, String absolutePath, String basePackage, String domain, String className) {
        try {
            if (!isValidFileName(className)) {
                throw new IllegalArgumentException("Nome de arquivo contém caracteres inválidos.");
            }

            String packagePath = basePackage.replace(".", "/");
            Path path = Paths.get(absolutePath, packagePath, domain.trim().toLowerCase());

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Path filePath = path.resolve(className.trim() + ".java");

            try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE)) {
                writer.write(content);
            }

            System.out.println("Classe gerada em: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidFileName(String fileName) {
        String regex = "[^<>:\"/\\|?*]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileName);
        return matcher.matches();
    }

}
