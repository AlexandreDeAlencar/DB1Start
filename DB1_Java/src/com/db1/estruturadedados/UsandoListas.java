package com.db1.estruturadedados;

import java.util.*;
import java.util.stream.Collectors;

public class UsandoListas {

    private static void imprimir(List<String> frutas) {
        System.out.println(frutas);
    }

    private static ArrayList coresFavoritas() {
       ArrayList<String> cores_favoritas = new ArrayList<>();
       cores_favoritas.addAll(Arrays.asList("Azul", "Vermelho","Laranja", "Verde"));
       return cores_favoritas;
    }
    private static int quantidadeDeItens(List<?> lista){
        return lista.size();
    }

    private static ArrayList adicionaItens(String valor1, String valor2, String valor3){
        ArrayList<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(valor1, valor2, valor3));
        lista.remove(1);
        return lista;
    }
    private static void  imprimeListaDeCoresFavoritas() {
        //coresFavoritas().forEach(s -> System.out.println(s));
        coresFavoritas().forEach(System.out :: println);
    }

    private static void  imprimeListaDeCoresFavoritasEmOrdemAlfabetica(ArrayList<String> coresFavorita) {
        ArrayList<String> lista = new ArrayList<>();
        lista=coresFavoritas();
        Collections.sort(lista);
        System.out.println(lista);
    }

    private static ArrayList<String>  removerDaListaDeCoresFavoritas( ArrayList<String> coresFavoritas, String cor) {
        coresFavoritas.remove(cor);
        return coresFavoritas;
    }

    private static void  imprimeCoresFavoritasDesc() {
        ArrayList<String> lista = new ArrayList<>();
        lista=coresFavoritas();
        Collections.sort(lista, Collections.reverseOrder());
        System.out.println(lista);
    }

    private static Map<String, List<Integer>> separar(
            List<Integer> numeros) {
        Map<String, List<Integer>> mapa = new HashMap<>();
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> impares = numeros.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        mapa.put("PAR", pares);
        mapa.put("IMPAR", impares);
        return mapa;
    }

    public static void main(String[] args) {
        System.out.println(adicionaItens("ALex","ABf","AGf"));
       ArrayList<String> coresFavorita = new ArrayList<String> (Arrays.asList("Laranja", "Vermelho", "Azul"));
       System.out.println(removerDaListaDeCoresFavoritas(coresFavorita, "Laranja"));
        imprimeCoresFavoritasDesc();
    }
}
