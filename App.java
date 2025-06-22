import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();
        List<Integer> todasChaves = new ArrayList<>();
        int chavePesquisa = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                todasChaves.add(Integer.parseInt(linha.trim()));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato de número no arquivo: " + e.getMessage());
            return;
        }

        if (todasChaves.isEmpty()) {
            System.out.println("O arquivo.txt está vazio.");
            return;
        }

        chavePesquisa = todasChaves.remove(todasChaves.size() - 1);

        for (int chave : todasChaves) {
            arvore.adicionar(chave);
        }

        try {
            FileWriter preOrdemWriter = new FileWriter("preordem.txt");
            arvore.preOrdem(arvore.raiz, preOrdemWriter);
            preOrdemWriter.close();
            System.out.println("Arquivo preordem.txt gerado com sucesso.");

            FileWriter posOrdemWriter = new FileWriter("posordem.txt");
            arvore.posOrdem(arvore.raiz, posOrdemWriter);
            posOrdemWriter.close();
            System.out.println("Arquivo posordem.txt gerado com sucesso.");

            FileWriter centralWriter = new FileWriter("central.txt");
            arvore.ordemCentral(arvore.raiz, centralWriter);
            centralWriter.close();
            System.out.println("Arquivo central.txt gerado com sucesso.");


            FileWriter larguraWriter = new FileWriter("largura.txt");
            arvore.largura(larguraWriter);
            larguraWriter.close();
            System.out.println("Arquivo largura.txt gerado com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao escrever nos arquivos de caminhamento: " + e.getMessage());
        }

        try {
            FileWriter resultadoWriter = new FileWriter("resultado.txt");
            boolean encontrou = arvore.existe(chavePesquisa);

            List<Integer> caminho = arvore.getCaminhoPesquisa();

            for (int chaveVisitada : caminho) {
                resultadoWriter.write(chaveVisitada + "\n");
            }

            resultadoWriter.write("Quantidade de nodos visitados: " + arvore.getQuantidadeNodosVisitados() + "\n");

            if (encontrou) {
                resultadoWriter.write("Resultado: Achou");
            } else {
                resultadoWriter.write("Resultado: Não achou");
            }

            resultadoWriter.close();
            System.out.println("Arquivo resultado.txt gerado com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo resultado.txt: " + e.getMessage());
        }
    }
}


