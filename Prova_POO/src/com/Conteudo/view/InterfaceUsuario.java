package com.Conteudo.view;

import java.util.Scanner;
import com.Conteudo.service.SensorService;
import com.Conteudo.model.*;

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);
    private SensorService sensorService = new SensorService();

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=========================================");
            System.out.println(" Sistema de Monitoramento WEG – Versão 1.0");
            System.out.println("=========================================");
            System.out.println("1 - Cadastrar Sensor");
            System.out.println("2 - Listar Sensores");
            System.out.println("3 - Registrar Medição");
            System.out.println("4 - Exibir Histórico de Medições");
            System.out.println("5 - Verificar Alertas");
            System.out.println("6 - Listar Sensores Críticos");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarSensor();
                    break;
                case 2:
                    sensorService.listarSensores();
                    break;
                case 3:
                    registrarMedicao();
                    break;
                case 4:
                    break;
                case 5:
                    sensorService.verificarAlertas();
                    break;
                case 6:
                    sensorService.listarSensoresCriticos();
                    break;
                case 0:
                    System.out.println("Encerrando sistema... Obrigado por usar o Monitoramento WEG!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarSensor() {
        System.out.print("Digite o código do sensor: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o nome do equipamento: ");
        String nomeEquipamento = scanner.nextLine();
        System.out.println("Escolha o tipo de sensor:");
        System.out.println("1 - Temperatura");
        System.out.println("2 - Vibração");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Sensor sensor = tipo == 1 ? new SensorTemperatura(codigo, nomeEquipamento) : new SensorVibracao(codigo, nomeEquipamento);
        sensorService.cadastrarSensor(sensor);
    }

    private void registrarMedicao() {
        System.out.print("Digite o código do sensor: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o valor da medição: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Digite a data e hora (formato dd/MM/yyyy HH:mm): ");
        String dataHora = scanner.nextLine();

        Medicao medicao = new Medicao(valor, dataHora);
        sensorService.registrarMedicao(codigo, medicao);
    }
}
