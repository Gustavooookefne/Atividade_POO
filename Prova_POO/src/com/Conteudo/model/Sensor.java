package com.Conteudo.model;

public abstract class Sensor {
    private String codigo;
    private String nomeEquipamento;
    private String tipo;
    protected int qtdAlerta = 0; 

    public Sensor(String codigo, String nomeEquipamento, String tipo) {
        this.codigo = codigo;
        this.nomeEquipamento = nomeEquipamento;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdAlerta() {
        return qtdAlerta;
    }

    public void setQtdAlerta(int qtdAlerta) {
        this.qtdAlerta = qtdAlerta;
    }

    public abstract boolean verificarAlerta(Medicao medicao);

    @Override
    public String toString() {
        return "Código: " + codigo + " | Tipo: " + tipo + " | Equipamento: " + nomeEquipamento;
    }
}
