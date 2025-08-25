package com.Conteudo.model;

public class SensorTemperatura extends Sensor {
    public SensorTemperatura(String codigo, String nomeEquipamento) {
        super(codigo, nomeEquipamento, "Temperatura");
    }

    @Override
    public boolean verificarAlerta(Medicao medicao) {
        if (medicao.getValor() > 80.0) {
            qtdAlerta++;
            System.out.println("⚠️ ALERTA: Medição de Temperatura fora do limite técnico! (" + medicao.getValor() + " > 80.0°C)");
            return true;
        }
        return false;
    }
}
