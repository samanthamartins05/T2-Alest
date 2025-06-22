# T2-Alest
Árvore Binária de Pesquisa – Trabalho de Estrutura de Dados

# Descrição

Esta aplicação Java implementa uma **árvore binária de pesquisa (BST)** a partir de valores inteiros lidos de um arquivo `.txt`. O programa realiza:

- Inserção dos valores na árvore na ordem em que aparecem.
- Quatro tipos de caminhamento:
  - Pré-ordem
  - Pós-ordem
  - Central (in-ordem)
  - Por largura (nível)
- Busca de uma chave fornecida na última linha do arquivo.
- Geração de arquivos com os resultados de cada caminhamento e da busca.

---

# Estrutura de Arquivos

| Arquivo                  | Descrição                                               

| `App.java`               | Classe principal com a lógica da aplicação             |
| `Main.java`              | Ponto de entrada do programa                           |
| `ArvoreBinariaPesquisa.java` | Implementação da árvore binária de pesquisa        |
| `entrada.txt`            | Arquivo de entrada com os valores e a chave de busca   |
| `preordem.txt`           | Saída com os valores em pré-ordem                      |
| `posordem.txt`           | Saída com os valores em pós-ordem                      |
| `central.txt`            | Saída com os valores em ordem central (in-ordem)       |
| `largura.txt`            | Saída com os valores em nível/largura                  |
| `resultado.txt`          | Caminho seguido na busca e se a chave foi encontrada   |

---

# Como Executar

1. **Clonar o repositório:**

   ```bash
   git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
   cd SEU_REPOSITORIO
   ```

2. **Adicionar o arquivo `entrada.txt` no mesmo diretório do projeto.**  
   Exemplo do conteúdo:

   ```
   50
   30
   70
   20
   40
   60
   80
   40
   ```

   A última linha (`40`) é a chave a ser buscada.

3. **Compilar e executar:**

   ```bash
   javac Main.java App.java ArvoreBinariaPesquisa.java
   java Main
   ```

4. **Verificar os arquivos de saída gerados no diretório:**

   - `preordem.txt`
   - `posordem.txt`
   - `central.txt`
   - `largura.txt`
   - `resultado.txt`

---

#  Detalhes da Implementação

- A árvore binária de pesquisa foi construída do zero.
- Os métodos implementados incluem:
  - Inserção de elementos
  - Caminhamentos: pré-ordem, pós-ordem, in-ordem e por largura
  - Busca com rastreamento dos nós visitados
- Arquivos `.txt` são gerados com base nos resultados de cada operação.

---


- **Nomes:** Samantha Martins,Júnior Fernando Stahl e Maria Melloni
- **Curso:** Alest I
- **Professor:** Leonardo Heredia 
- **GitHub:** [github.com/SEU_USUARIO](https://github.com/samanthamartins05)
