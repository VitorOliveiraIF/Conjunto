import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho do conjunto: ");
        int tamConj1 = scanner.nextInt();

        System.out.print("Agora digite o menor número desse conjunto: ");
        int menNumConj = scanner.nextInt();

        System.out.print("Agora digite o maior número desse conjunto: ");
        int maiNumConj = scanner.nextInt();

        Conjunto conj1 = new Conjunto(tamConj1, menNumConj, maiNumConj);

        int []vetorMain = conj1.preencherVetor();

        System.out.print("Ordenando e tirando as repetições teremos o conjunto:\n");
        int []vetorSemRepMain = Conjunto.removerRepeticoes(vetorMain, tamConj1);
        int []vetorFinalMain1 = Conjunto.ordenarVetor(vetorSemRepMain);
        Conjunto.exibirVetor(vetorFinalMain1);


        System.out.print("\nDigite o tamanho do segundo conjunto: ");
        int tamConj2 = scanner.nextInt();

        System.out.print("Agora digite o menor número desse conjunto: ");
        menNumConj = scanner.nextInt();

        System.out.print("Agora digite o maior número desse conjunto: ");
        maiNumConj = scanner.nextInt();

        Conjunto conj2 = new Conjunto(tamConj2, menNumConj, maiNumConj);

        vetorMain = conj2.preencherVetor();
        Conjunto.exibirVetor(vetorMain);

        System.out.print("\nAgora teremos os 2 conjuntos em ordem e sem repetições\n");

        vetorSemRepMain = Conjunto.removerRepeticoes(vetorMain, tamConj2);
        int[] vetorFinalMain2 = Conjunto.ordenarVetor(vetorSemRepMain);

        System.out.print("\nConjunto 1: ");
        Conjunto.exibirVetor(vetorFinalMain1);
        System.out.print("Conjunto 2: ");
        Conjunto.exibirVetor(vetorFinalMain2);

        Conjunto.interseccao(vetorFinalMain1, tamConj1, vetorFinalMain2, tamConj2);
        Conjunto.uniao(vetorFinalMain1, tamConj1, vetorFinalMain2, tamConj2);
        Conjunto.diferenca(vetorFinalMain1, vetorFinalMain2);



        scanner.close();
    }
}
