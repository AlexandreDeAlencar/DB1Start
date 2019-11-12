package com.db1.db1start;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer numero1, resultado;
		Integer numero2;
		String texto_normal;
	
		System.out.println("Digite um numero");
		Scanner scan_numero1 = new Scanner(System.in);
		numero1 = scan_numero1.nextInt();
		
		System.out.println("Digite um outro numero");
		Scanner scan_numero2 = new Scanner(System.in);
		numero2 = scan_numero2.nextInt();
		
		resultado = numero1 + numero2;
		System.out.println("O resultado da soma é: " + resultado);
		
		System.out.println("Digite um texto");
		Scanner scan_texto = new Scanner(System.in);
		texto_normal = scan_texto.next();
		String texto_maiusculo = texto_normal.toUpperCase();
		String texto_minusculo = texto_normal.toLowerCase();
		
		System.out.println("Texto Minusculo: " + texto_minusculo);
		System.out.println("Texto Maiusculo: " + texto_maiusculo);
		
		System.out.println("Digite o valor 1");
		Scanner scan_valor1 = new Scanner(System.in);
		double valor1 = scan_valor1.nextInt();
	
		System.out.println("Digite o valor 2");
		Scanner scan_valor2 = new Scanner(System.in);
		double valor2 = scan_valor2.nextInt();
		
		System.out.println("Digite o valor 3");
		Scanner scan_valor3 = new Scanner(System.in);
		double valor3 = scan_valor3.nextInt();
		
		if (valor1 < valor2 && valor1 < valor3) {
			System.out.println("valor 1 é o menor");
		}else if (valor2 < valor3 && valor2 < valor1) {
			System.out.println("valor 2 é o menor");
		}else System.out.println("valor 3 é o menor");
	}

}
