package com.Conteudo.model;

public class SensorVibracao extends Sensor {
    public SensorVibracao(String codigo, String nomeEquipamento) {
        super(codigo, nomeEquipamento, "Vibração");
    }

    @Override
    public boolean verificarAlerta(Medicao medicao) {
        if (medicao.getValor() != 60.0) {
            qtdAlerta++;
            System.out.println("⚠️ ALERTA: Medição de Vibração fora do limite técnico! (" + medicao.getValor() + " ≠ 60.0Hz)");
            return true;
        }
        return false;
    }
}
