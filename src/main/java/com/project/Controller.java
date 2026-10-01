package com.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label pantalla;

    private double numero1 = 0;
    private double numero2 = 0;
    private String operacion = "";
    private boolean nuevoNumero = true;

    @FXML
    public void pulsarNumero(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String numero = boton.getText();

        if (nuevoNumero == true) {
            pantalla.setText(numero);
            nuevoNumero = false;
        } else {
            pantalla.setText(pantalla.getText() + numero);
        }
    }

    @FXML
    public void pulsarOperacion(ActionEvent event) {
        Button boton = (Button) event.getSource();
        operacion = boton.getText();
        numero1 = Double.parseDouble(pantalla.getText());
        nuevoNumero = true;
    }

    @FXML
    public void calcular(ActionEvent event) {
        if (operacion.equals("")) {
            return;
        }

        numero2 = Double.parseDouble(pantalla.getText());
        double resultado = 0;

        if (operacion.equals("+")) {
            resultado = numero1 + numero2;
        }
        if (operacion.equals("-")) {
            resultado = numero1 - numero2;
        }
        if (operacion.equals("*")) {
            resultado = numero1 * numero2;
        }
        if (operacion.equals("/")) {
            if (numero2 == 0) {
                pantalla.setText("Error");
                operacion = "";
                nuevoNumero = true;
                return;
            } else {
                resultado = numero1 / numero2;
            }
        }

        if (resultado % 1 == 0) {
            int resultadoEntero = (int) resultado;
            pantalla.setText("" + resultadoEntero);
        } else {
            pantalla.setText("" + resultado);
        }

        operacion = "";
        nuevoNumero = true;
    }

    @FXML
    public void borrar(ActionEvent event) {
        pantalla.setText("0");
        numero1 = 0;
        numero2 = 0;
        operacion = "";
        nuevoNumero = true;
    }
}