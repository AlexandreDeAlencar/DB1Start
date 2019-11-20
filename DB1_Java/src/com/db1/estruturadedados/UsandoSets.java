package com.db1.estruturadedados;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsandoSets {

    public static void main(String[] args){
        System.out.println(getSuzete());
    }

    public static Set<String> criaSetNomes() {
        Set<String> personagens = new HashSet<>();
        personagens.addAll(Arrays.asList("Suzete", "Romualdo", "Fernando", "Alexandre", "Romunaldo"));
        return personagens;
    }

    public static Set<String> removeNomes() {
        Set<String> personagens = new HashSet<>();
        personagens= criaSetNomes();
        personagens.removeIf(n->(n == "Suzete") || n.startsWith("F") || n.contains("naldo"));
        return personagens;
    }

    public static Optional<String> getSuzete() {
        Set<String> personagens = new HashSet<>();
        personagens= criaSetNomes();
        Optional<String> maybeSuzete =  personagens.stream().filter(item->item.equals("Suzete")).findFirst();
        return maybeSuzete;
    }
}
