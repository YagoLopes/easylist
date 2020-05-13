package br.com.easylist.entidades;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yago
 */
public class Arquivo {
 public void upload(String pasta, String nomeDoArquivo,
  InputStream arquivoCarregado) throws FileNotFoundException {
    String caminhoArquivo = pasta + "/" + nomeDoArquivo;
    File novoArquivo = new File(caminhoArquivo);
    FileOutputStream saida = new FileOutputStream(novoArquivo);
    copiar(arquivoCarregado, saida);
}
  
  private void copiar(InputStream origem, OutputStream destino){
int bite = 0;
byte[] tamanhoMaximo = new byte[1024 * 8]; // 8KB
    try {
      // enquanto bytes forem sendo lidos
      while((bite = origem.read(tamanhoMaximo)) >= 0) {
          // pegue o byte lido e escreva no destino
          destino.write(tamanhoMaximo, 0, bite);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
}
}
