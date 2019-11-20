package com.db1.algoritimoscomjava;
import java.util.Arrays;
import java.util.List;

public class Application {
	
	public Integer soma( Integer numero1, Integer numero2) {

		return numero1+numero2;
	}
	
	public Integer menorValor(Integer valor1, Integer valor2) {
		if (valor1 < valor2) {
			return valor1;
		}
			return valor2;
	}
	
	public Integer subtracao(Integer valor1, Integer valor2) {
			return valor1 - valor2;
	}
	public Integer multiplica(Integer valor1, Integer valor2) {
		return valor1*valor2;
	}

	public Integer divide(Integer valor1, Integer valor2) {
		return valor1/valor2;
	}
	
	public String par(Integer valor) {
		if (valor%2==0) {
			return "Par";
		}
		return "Impar";
	}
	
	public Integer maiorValor(Integer valor1, Integer valor2) {
		if (valor1 > valor2) {
			return valor1;
		}
			return valor2;
	}
	
	public Integer quantidadeNImpares(Integer valor) {
		Integer resto = valor%2;
		return resto + valor/2;
	}
	
	public String maiuscula( String texto_normal) {
		return texto_normal.toUpperCase();
	}
	
	public String minuscula( String texto_normal) {
		String texto_minusculo = texto_normal.toLowerCase();
		return texto_minusculo;
	}
	
	public int contaCaracteres (String palavra) {
		return palavra.length();
	}
	
	public int contaLetras (String palavra) {
		palavra = palavra.replaceAll("\\s+","");
		return palavra.length();
	}
	
	public String limpaEspacoEmBranco (String palavra) {
			palavra = palavra.replaceAll("\\s+","");
			return palavra;
	}
	
	public String exibe4PrimeirasLetras (String palavra) {
		palavra = palavra.replaceAll("\\s+","");
		String quatro_primeiras_letras="" ;
		    for(int i =0; i < 4; i++){
		        quatro_primeiras_letras = quatro_primeiras_letras + palavra.charAt(i);      
		    }
		return quatro_primeiras_letras;
	}
	
	public String exibeAPartirda3PrimeiraLetra (String palavra) {
		palavra = palavra.replaceAll("\\s+","");
		String resultado="" ;
		    for(int i =2; i < palavra.length(); i++){
		        resultado = resultado + palavra.charAt(i);      
		    }
		return resultado;
	}
	
	public String exibe4UltimasLetras (String palavra) {
		palavra = palavra.replaceAll("\\s+","");
		String quatro_ultimas_letras="" ;
		    for(int i = 3; i >= 0; i--){
		    	int indx=palavra.length()-i-1;
		        quatro_ultimas_letras = quatro_ultimas_letras + palavra.charAt(indx);      
		    }
		return quatro_ultimas_letras;
	}
	
	public String substituiPrimeiroNome(String palavra) {
		int count=0;
		String sobrenome ="";
		while (palavra.charAt(count) != ' '){
			count++;
	    }
		
		for(int i = count; i < palavra.length(); i++){
	        sobrenome = sobrenome + palavra.charAt(i);      
	    }
		
		String aluno = "ALUNO/ALUNA" + sobrenome;
		return aluno;
	}

	public String[] exibeTextoSeparadamente(String palavra) {
		return palavra.split(", ");
	}
	
	public int quantidadeVogais(String palavra) {
		String[] vogais = new String[] {"a","e","i","o","u"};
		
		// Convert String Array to List
        List<String> list = Arrays.asList(vogais);
       
		int count=0;
		for(int i = 0; i < palavra.length(); i++){
			if (list.contains(Character.toString(palavra.charAt(i)))) {
	        count++;      
	    }
		}
		
		return count;
	}
	public String inverteString(String palavra) {
		String resultado = "";
		int count=0;
		for(int i = palavra.length()-1; i >=0 ; i--){
			resultado= resultado + palavra.charAt(i);
	    }
		return resultado;
	}
	public double menorValor(double valor1, double valor2) {
		if (valor1 < valor2) {
			return valor1;
		}
			return valor2;
	}
	
	public double menorValor(double valor1, double valor2, double valor3) {
		return menorValor(menorValor(valor1,valor2),valor3);
	}
	
	public double media3Valores(double valor1, double valor2, double valor3) {
		return (valor1+valor2+valor3)/3;
	}
	
	public double areaTriangulo(double base, double altura) {

		return (base*altura)/2;
	}
}
