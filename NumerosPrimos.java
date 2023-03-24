package questao2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NumerosPrimos implements Runnable{
	
	private int botLimit, topLimit;
	
	public NumerosPrimos(int botLimit, int topLimit) {
		this.botLimit = botLimit;
		this.topLimit = topLimit;
	}
	
	public void run() {
		LocalTime inicio = LocalTime.now();
		
		for(int i = botLimit; i <= topLimit; i++) {
			if(ehPrimo(i)) {
				System.out.println(i + " é um número primo!");
			}
		}
		
		LocalTime termino = LocalTime.now();
		
		long tempo = inicio.until(termino, ChronoUnit.MICROS);
		
		System.out.println("Tempo total em microssegundos de " + Thread.currentThread().getName() + ": " + tempo);
	}
	
	public boolean ehPrimo(int n) {
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
