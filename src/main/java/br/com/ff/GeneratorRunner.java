package br.com.ff;

import br.com.ff.utils.parser.GeneratorJsonParser;
import br.com.ff.utils.parser.ParsedData;
import br.com.ff.structure.GeneratorStarting;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.nio.file.Files;

@Mojo(name = "touch", defaultPhase = LifecyclePhase.NONE)
public class GeneratorRunner
    extends AbstractMojo
{
    @Parameter(defaultValue = "${project.basedir}/generator.json", readonly = true)
    private File jsonFile;

    @Parameter(defaultValue = "${project.basedir}/generate/src/main/java", readonly = true)
    private File outputDirectory;

    @Parameter(defaultValue = "${project.groupId}", readonly = true)
    private String basePackage;

    @Override
    public void execute()
        throws MojoExecutionException
    {
        System.out.println("MOJO touch executado com sucesso!");

        if (!jsonFile.exists()) {
            throw new MojoExecutionException("Arquivo generator.json não encontrado!");
        }

        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        try {
            String jsonContent = new String(Files.readAllBytes(jsonFile.toPath()));
            ParsedData parsedData = GeneratorJsonParser.parseJson(jsonContent);
            GeneratorStarting.generate(outputDirectory, basePackage, parsedData);
        } catch (Exception e) {
            throw new MojoExecutionException("Erro ao ler generator.json", e);
        }

    }
}
