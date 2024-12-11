package com.ecommerceFICR.Model.pagamentos;

import com.ecommerceFICR.Interface.Pagamento;

public class PagamentoPix implements Pagamento {
    private int idPix;
    private String chavePix;
    private String nome;

    public PagamentoPix(int idPix, String chavePix, String nome) {
        this.idPix = idPix;
        this.chavePix = chavePix;
        this.nome = nome;
    }

    public int getidPix() {
        return idPix;
    }

    public void setidPix(int idPix) {
        this.idPix = idPix;
    }

    public String getchavePix() {
        return chavePix;
    }

    public void setchavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    @Override
    public void processarPagamento(double valor) {
        // Implementação da lógica de pagamento com PIX
        System.out.println("Processando pagamento com PIX: R$ " + valor);
        System.out.println("Chave PIX: " + chavePix + ", nome: " + nome + ", Codigo Identificador: " + idPix);
    }
}