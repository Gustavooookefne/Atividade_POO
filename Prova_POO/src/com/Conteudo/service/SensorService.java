package com.Conteudo.service;

import java.util.List;
import java.util.ArrayList;
import com.Conteudo.model.Sensor;
import com.Conteudo.model.SensorTemperatura;
import com.Conteudo.model.Medicao;

public class SensorService {
    private List<Sensor> sensores = new ArrayList<>();

    
    public void cadastrarSensor(Sensor sensor) {
        sensores.add(sensor);
        System.out.println("✅ Sensor cadastrado com sucesso! Tipo: " + sensor.getTipo() + " | Limite de alerta: " + (sensor instanceof SensorTemperatura ? "80.0°C" : "60.0Hz"));
    }

    
    public void listarSensores() {
        if (sensores.isEmpty()) {
            System.out.println("Nenhum sensor cadastrado.");
        } else {
            for (Sensor sensor : sensores) {
                System.out.println(sensor);
            }
        }
    }

    
    public void registrarMedicao(String codigo, Medicao medicao) {
        for (Sensor s : sensores) {
            if (s.getCodigo().equals(codigo)) {
                if (s.verificarAlerta(medicao)) {
                    System.out.println("⚠️ ALERTA: Medição fora do limite técnico!");
                }
                return;
            }
        }
        System.out.println("Sensor não encontrado!");
    }

  
    public void verificarAlertas() {
        for (Sensor s : sensores) {
            System.out.println(s.getCodigo() + " - " + s.getNomeEquipamento() + ": " + s.getQtdAlerta() + " alerta(s)");
        }
    }

    
    public void listarSensoresCriticos() {
        for (Sensor s : sensores) {
            if (s.getQtdAlerta() > 3) {
                System.out.println("Sensor Crítico: " + s + " | Alertas: " + s.getQtdAlerta());
            }
        }
    }
}
