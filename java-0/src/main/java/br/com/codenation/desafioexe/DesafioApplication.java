package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.TestadorFibonacci;
import br.com.codenation.annotation.Desafio;

public class DesafioApplication {

	public static void main(String[] args) {
		new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	}

	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {
		List<Integer> sequenciaFibo = new ArrayList<Integer>();
		
		for (int i = 0; i < 14; i++) {
			if (i == 0) {
				sequenciaFibo.add(0);			
			} else if (i == 1) {
				sequenciaFibo.add(1);
			} else {
				sequenciaFibo.add(sequenciaFibo.get(i-1) + sequenciaFibo.get(i-2));
			}

			System.out.println(sequenciaFibo[i]);
		}
		
		return sequenciaFibo;
	}

	@Desafio("isFibonacci")
	public static Boolean isFibonacci(Integer a) {
		List<Integer> sequenciaFibo = fibonacci();
		if(sequenciaFibo.contains(a)) {
			return true;
		} else {
			return false;
		}		
	}
}
