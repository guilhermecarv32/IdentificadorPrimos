package questao2;

import java.util.Scanner;

public class NumerosPrimosUtil {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		final int MAX = 5;
		Thread[] threads = new Thread[MAX];
		
		System.out.print("Informe o limite inferior: ");
		int a = scanner.nextInt();
		System.out.print("Informe o limite superior: ");
		int b = scanner.nextInt();
		
		int qtd = b - a + 1;
		int qtdPorSub = qtd / MAX;
		
		for(int i = 0; i < MAX; i++) {
			int botLimit = a + qtdPorSub * i + 1;
			
			int topLimit = botLimit + qtdPorSub - 1;
			
			if(i == 0)
				botLimit = a;
			
			if(i == MAX - 1)
				topLimit = b;
			
			Runnable executavel = new NumerosPrimos(botLimit, topLimit);
			threads[i] = new Thread(executavel);
		}
		
		for(int i = 0; i < MAX; i ++) {
			threads[i].start();
		}
		
		scanner.close();
	}

}
