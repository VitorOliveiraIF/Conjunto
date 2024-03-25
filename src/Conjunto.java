import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;


public class Conjunto {
    private final int Tamanho;
    private final int MenorNumero;
    private final int MaiorNumero;

    public Conjunto(int tamanho, int menorNumero, int maiorNumero) {
        Tamanho = tamanho;
        MenorNumero = menorNumero;
        MaiorNumero = maiorNumero;
    }

    public int[] preencherVetor() {
        int[] vetor = new int[Tamanho];
        Random random = new Random();
        for (int i = 0; i < Tamanho; i++) {
            vetor[i] = random.nextInt(MaiorNumero - MenorNumero + 1) + MenorNumero;
        }
        return vetor;
    }
    public static void exibirVetor(int[] vetor) {
        for (int j : vetor) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static int[] removerRepeticoes(int[] vetor, int tamanho) {
        Set<Integer> conjunto = new HashSet<>();
        int[] vetorFinal = new int[tamanho];
        int index = 0;

        for (int i = 0; i < tamanho; i++) {
            if (!conjunto.contains(vetor[i])) {
                vetorFinal[index++] = vetor[i];
                conjunto.add(vetor[i]);
            }
        }
        return Arrays.copyOf(vetorFinal, index);
    }
    public static int[] ordenarVetor(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {

                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        return vetor;
    }
    public static int[] removerUltimoZero(int[] vetor) {
        // Encontra o índice do último elemento não zero
        int lastIndex = vetor.length - 1;
        while (lastIndex >= 0 && vetor[lastIndex] == 0) {
            lastIndex--;
        }

        // Se o último elemento não zero for encontrado, cria um novo vetor sem os zeros finais
        if (lastIndex >= 0) {
            int[] novoVetor = new int[lastIndex + 1];
            System.arraycopy(vetor, 0, novoVetor, 0, lastIndex + 1);
            return novoVetor;
        } else {
            // Se todos os elementos forem zero, retorna um vetor vazio
            return new int[0];
        }
    }


    public static void interseccao(int[] vetor1, int tamanho1, int[] vetor2, int tamanho2) {
        int[] conjInter = new int[tamanho1 + tamanho2];
        int i;

        System.out.print("\nA intersecção dos conjuntos é: ");
        for (i = 0; i < vetor1.length; i++) {
            for (int j = 0; j < vetor2.length; j++) {
                if (vetor1[i] == vetor2[j]) {
                    conjInter[j] = vetor1[i];
                    System.out.print(conjInter[j] + " ");
                }
            }
        }
    }
    public static void uniao(int[] vetor1, int tamanho1, int[] vetor2, int tamanho2){
    int tamConjUni = tamanho1 + tamanho2;
    int[] conjUni = new int[tamConjUni];

    System.out.print("\nA união dos conjuntos é: ");
    System.arraycopy(vetor1, 0, conjUni, 0, vetor1.length);
    System.arraycopy(vetor2, 0, conjUni, vetor1.length, vetor2.length);

        int[] uniSR = Conjunto.removerRepeticoes(conjUni, tamConjUni);
        int[] uniSZR = Conjunto.removerUltimoZero(uniSR);
        int[] uniFinal = Conjunto.ordenarVetor(uniSZR);
        Conjunto.exibirVetor(uniFinal);
    }
    public static void diferenca(int[] vetor1, int[] vetor2) {
        int[] conjDif = Arrays.copyOf(vetor1, vetor1.length); // Cria uma cópia de vetor1

        System.out.print("A diferença do conjunto 1 pro 2 é: ");
        int k = 0; // índice para o vetor conjDif
        for (int i = 0; i < vetor1.length; i++) {
            boolean encontrou = false;
            for (int j = 0; j < vetor2.length; j++) {
                if (vetor1[i] == vetor2[j]) {
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou) {
                conjDif[k++] = vetor1[i];
            }
        }
        int[] difIntermed = Arrays.copyOf(conjDif, k);

        int[] difFinal = Conjunto.ordenarVetor(difIntermed);
        Conjunto.exibirVetor(difFinal);

        System.out.print("A diferença do conjunto 1 pro 2 é: ");
        k = 0; // índice para o vetor conjDif
        for (int i = 0; i < vetor2.length; i++) {
            boolean encontrou = false;
            for (int j = 0; j < vetor1.length; j++) {
                if (vetor2[i] == vetor1[j]) {
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou) {
                conjDif[k++] = vetor2[i];
            }
        }
        int[] difIntermed2 = Arrays.copyOf(conjDif, k);

        difFinal = Conjunto.ordenarVetor(difIntermed2);
        Conjunto.exibirVetor(difFinal);
    }

}



