package com.db1.contacorrentepoo;

public class CampoNaoPodeSerNull extends RuntimeException  {

    public CampoNaoPodeSerNull(String frase) {
        super(frase);
    }
}