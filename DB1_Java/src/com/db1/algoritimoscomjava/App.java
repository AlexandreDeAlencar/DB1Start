package com.db1.algoritimoscomjava;
import java.util.Scanner;

public class App {
	
	public static String soma( Integer numero1, Integer numero2) {
		Integer resultado = numero1 + numero2;
		return "O resultado da soma � " + resultado;
	}
	
	public static String maiuscula( String texto_normal) {
		String texto_maiusculo = texto_normal.toUpperCase();
		return "Texto Maiusculo: " + texto_maiusculo;
	}
	
	public static String minuscula( String texto_normal) {
		String texto_minusculo = texto_normal.toLowerCase();
		return "Texto Minusculo: " + texto_minusculo;
	}
	
	public static double menorValor(double valor1, double valor2) {
		if (valor1 < valor2) {
			return valor1;
		}
			return valor2;
	}
	
	public static double menorValor(double valor1, double valor2, double valor3) {
		return menorValor(menorValor(valor1,valor2),valor3);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer numero1, numero2;
		String texto_normal;
		
		System.out.println("Digite um numero");
		Scanner scan_numero1 = new Scanner(System.in);
		numero1 = scan_numero1.nextInt();
		
		System.out.println("Digite um outro numero");
		Scanner scan_numero2 = new Scanner(System.in);
		numero2 = scan_numero2.nextInt();
		
		System.out.println(soma(numero1,numero2));
		
		System.out.println("Digite um texto");
		Scanner scan_texto = new Scanner(System.in);
		texto_normal = scan_texto.next();
	
		System.out.println( maiuscula(texto_normal));
		System.out.println(minuscula(texto_normal));
		
		System.out.println("Digite o valor 1");
		Scanner scan_valor1 = new Scanner(System.in);
		double valor1 = scan_valor1.nextInt();
	
		System.out.println("Digite o valor 2");
		Scanner scan_valor2 = new Scanner(System.in);
		double valor2 = scan_valor2.nextInt();
		
		System.out.println("Digite o valor 3");
		Scanner scan_valor3 = new Scanner(System.in);
		double valor3 = scan_valor3.nextInt();
		
		System.out.println("O menor valor � o: " + menorValor(valor1,valor2,valor3));
	}

}
