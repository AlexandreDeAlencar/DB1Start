package com.db1.db1start;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

Application application = new Application();

	@Test
	public void showSoma5() {
		Integer expected=5;
		Integer response = application.soma(2,3);
		assertEquals(expected, response);
	}

	@Test
	public void showSubtracao5() {
		double expected=4.0;
		double response;
		response = application.subtracao(5, 1);
		assertEquals(expected, response, 0.0);
	}


	@Test
	public void showMultiplica8() {
		double expected=8.0;
		double response;
		response = application.multiplica(2, 4);
		assertEquals(expected, response, 0.0);
	}

	@Test
	public void showDivide8() {
		double expected=8.0;
		double response;
		response = application.divide(16, 2);
		assertEquals(expected, response, 0.0);
	}

	@Test
	public void showPar() {
		String expected= "Par";
		String response;
		response = application.par(16);
		assertEquals(expected, response);
	}

	@Test
	public void showMaiorValor8() {
		double expected=8.0;
		double response;
		response = application.maiorValor(1, 8);
		assertEquals(expected, response, 0.0);
	}

	@Test
	public void showQuantidadeNImpares8() {
		double expected=8;
		double response;
		response = application.quantidadeNImpares(15);
		assertEquals(expected, response, 0.0);
	}

	@Test
	public void showMaiusculaALEX() {
		String expected= "ALEX";
		String response;
		response = application.maiuscula("AleX");
		assertEquals(expected, response);
	}

	@Test
	public void showMinusculaAlex() {
		String expected= "alex";
		String response;
		response = application.minuscula("AleX");
		assertEquals(expected, response);
	}

	@Test
	public void showContaCaracteresDB1START() {
		int expected= 8;
		int response;
		response = application.contaCaracteres("DB1START");
		assertEquals(expected, response, 0.0);
	}

	@Test
	public void showContaLetrasDB1START() {
		int expected= 8;
		int response;
		response = application.contaLetras(" DB1START ");
		assertEquals(expected, response, 0.0);
	}

	@Test
	public void showExibe4PrimeirasLetrasDB1S() {
		String expected= "DB1S";
		String response;
		response = application.exibe4PrimeirasLetras(" DB1 START ");
		assertEquals(expected, response);

	}

	@Test
	public void showExibeAPartirda3PrimeiraLetra1START() {
		String expected= "1START";
		String response;
		response = application.exibeAPartirda3PrimeiraLetra(" DB1 START ");
		assertEquals(expected, response);
	}

	@Test
	public void showExibe4UltimasLetrasTART() {
		String expected= "TART";
		String response;
		response = application.exibe4UltimasLetras(" DB1 START ");
		assertEquals(expected, response);
	}

	@Test
	public void showsubstituiPrimeiroNome() {
		String expected= "ALUNO/ALUNA DE ALENCAR FERREIRA";
		String response;
		response = application.substituiPrimeiroNome("ALEXANDRE DE ALENCAR FERREIRA");
		assertEquals(expected, response);

	}

	@Test
	public void showExibeTextoSeparadamenteMelancia() {
		String expected = "melancia";
		String[] response;
		response = application.exibeTextoSeparadamente("banana, maçã, melancia");
		assertEquals(expected, response[2]);

	}

    @Test
    public void showQuantidadeVogais() {
        int expected = 4;
        int response;
        response = application.quantidadeVogais("melancia");
        assertEquals(expected, response);

    }

    @Test
    public void showInverteStringAicalem() {
        String  expected = "aicnalem";
        String response;
        response = application.inverteString("melancia");
        assertEquals(expected, response);

    }

    @Test
    public void showMenorValorEntre2Doubles() {
        double expected = 2;
        double  response;
        response = application.menorValor(5,2);
        assertEquals(expected, response, 0.0);
    }

    @Test
    public void showMenorValorEntre3Doubles() {
        double expected = 2;
        double  response;
        response = application.menorValor(5,2,4);
        assertEquals(expected, response, 0.0);
    }

    @Test
    public void showMediaEntre3Doubles() {
        double expected = 4;
        double  response;
        response = application.media3Valores(6,2,4);
        assertEquals(expected, response, 0.0);
    }

    @Test
    public void showAreaTriangulo() {
        double expected = 6;
        double  response;
        response = application.areaTriangulo(6,2);
        assertEquals(expected, response, 0.0);
    }
}
