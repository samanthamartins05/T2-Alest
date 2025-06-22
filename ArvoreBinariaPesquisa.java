import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreBinariaPesquisa {
    private class Nodo {
        private int chave;
        private Nodo filhoEsquerda;
        private Nodo filhoDireita;

        public Nodo(int chave) {
            this.chave = chave;
        }
    }

    Nodo raiz;
    private int tamanho;
    private List<Integer> caminhoPesquisa;

    public ArvoreBinariaPesquisa() {
        this.caminhoPesquisa = new ArrayList<>();
        this.raiz = null;
        tamanho = 0;
    }

    public void adicionar(int chave) {
        Nodo n = new Nodo(chave);
        if (raiz == null) raiz = n;
        else adicionarRecursivamente(n, raiz);
        tamanho++;
    }

    private void adicionarRecursivamente(Nodo n, Nodo pai) {
        if (n.chave < pai.chave) {
            if (pai.filhoEsquerda == null) {
                pai.filhoEsquerda = n;
            } else {
                adicionarRecursivamente(n, pai.filhoEsquerda);
            }
        } else if (n.chave > pai.chave) {
            if (pai.filhoDireita == null) {
                pai.filhoDireita = n;
            } else {
                adicionarRecursivamente(n, pai.filhoDireita);
            }
        }

    }

    public boolean existe(int chave) {
        this.caminhoPesquisa.clear();
        Nodo aux = this.raiz;

        while (aux != null) {
            caminhoPesquisa.add(aux.chave);

            if (chave == aux.chave) {
                return true;
            }

            if (chave < aux.chave) {
                aux = aux.filhoEsquerda;
            } else {
                aux = aux.filhoDireita;
            }
        }

        return false;
    }

    public int acharNivel(int chave) {
        return encontrarNivel(raiz, chave, 0);
    }

    private int encontrarNivel(Nodo nodo, int chave, int nivel) {
        if (nodo == null) {
            return -1;
        }
        if (chave == nodo.chave) {
            return nivel;
        }
        if (chave < nodo.chave) {
            return encontrarNivel(nodo.filhoEsquerda, chave, nivel + 1);
        } else {
            return encontrarNivel(nodo.filhoDireita, chave, nivel + 1);
        }
    }

    public void imprimirArvore() {
        imprimirArvoreRecusivamente(this.raiz, 0);
    }

    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.filhoDireita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.chave + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.filhoEsquerda, nivel);
    }

    public int getAltura() {
        return altura(raiz);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int esquerdaAltura = altura(nodo.filhoEsquerda);
        int direitaAltura = altura(nodo.filhoDireita);
        return Math.max(esquerdaAltura, direitaAltura) + 1;
    }

    public void preOrdem(Nodo n, FileWriter fw) throws IOException {
        if (n != null) {
            fw.write(n.chave + "\n");
            preOrdem(n.filhoEsquerda, fw);
            preOrdem(n.filhoDireita, fw);
        }
    }

    public void posOrdem(Nodo n, FileWriter fw) throws IOException {
        if (n != null) {
            posOrdem(n.filhoEsquerda, fw);
            posOrdem(n.filhoDireita, fw);
            fw.write(n.chave + "\n");
        }
    }

    public void ordemCentral(Nodo n, FileWriter fw) throws IOException {
        if (n != null) {
            ordemCentral(n.filhoEsquerda, fw);
            fw.write(n.chave + "\n");
            ordemCentral(n.filhoDireita, fw);
        }
    }

    public void largura(FileWriter fw) throws IOException {
        if (raiz == null) {
            return;
        }

        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Nodo atual = fila.poll();
            fw.write(atual.chave + "\n");

            if (atual.filhoEsquerda != null) {
                fila.add(atual.filhoEsquerda);
            }

            if (atual.filhoDireita != null) {
                fila.add(atual.filhoDireita);
            }
        }
    }

    public List<Integer> getCaminhoPesquisa() {
        return caminhoPesquisa;
    }

    public int getQuantidadeNodosVisitados() {
        return caminhoPesquisa.size();
    }
}

