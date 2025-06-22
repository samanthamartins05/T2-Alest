import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {

        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();

        Path path1 = Paths.get("frutas.txt");
        try (BufferedReader reader = Files.newBufferedReader(path1,
                Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                arvore.adicionar(line);
            }

        } catch (IOException e) {
            System.err.format("Erro de leitura: %s%n", e);
        }

        arvore.imprimirArvore();
        if (arvore.existe("abacate")) {
            System.out.println("\nNível: " + arvore.acharNivel("abacate"));
        } else {
            System.out.println("Não existe na árvore.");
        }

        System.out.println("\nTamanho da árvore: " + arvore.getTamanho());

    }
}