package com.Conteudo.main;

import com.Conteudo.service.SensorService;
import com.Conteudo.view.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        
    	SensorService sensor = new SensorService();
        InterfaceUsuario face = new InterfaceUsuario();
        
        face.exibirMenu();
    }
}
