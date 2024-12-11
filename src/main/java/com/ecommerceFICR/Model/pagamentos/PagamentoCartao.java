package com.ecommerceFICR.Model.pagamentos;

import com.ecommerceFICR.Interface.Pagamento;
;

public class PagamentoCartao implements Pagamento {
    private int idCartao;
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String cvv;

    public PagamentoCartao(int idCartao,String numeroCartao, String nomeTitular, String dataValidade, String cvv) {
        this.idCartao = idCartao;
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    public int getidCartao() {
        return idCartao;
    }
    public void setidCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getnumeroCartao() {
        return numeroCartao;
    }

    public void setnumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getnomeTitular() {
        return nomeTitular;
    }

    public void setnomeTitular (String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getdataValidade() {
        return dataValidade;
    }

    public void setdataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getcvv() {
        return cvv;
    }

    public void setcvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento com cartão de crédito: R$ " + valor);
        System.out.println("Cartão: " + numeroCartao + ", Titular: " + nomeTitular + ", Código Identificador: " + idCartao);
    }
}
