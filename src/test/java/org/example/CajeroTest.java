package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

class CajeroTest {

    private Cajero cajero;

    @BeforeEach
    void setUp() {
        cajero = new Cajero();
        cajero.reiniciarSaldo();
    }

    @Test
    void testRetiroValido() {
        boolean result = cajero.retirar(1000);
        Assertions.assertTrue(result);
    }

    @Test
    void testRetiroExcedeSaldo() {
        boolean result = cajero.retirar(200000);
        Assertions.assertFalse(result);
    }

    @Test
    void testRetiroNoMultiploDeMil() {
        boolean result = cajero.retirar(7);
        Assertions.assertFalse(result);
    }

    @Test
    void testRetiroMontoNegativo() {
        boolean result = cajero.retirar(-12);
        Assertions.assertFalse(result);
    }
    @Test
    void testRetiroExactoTotalDisponible() {
        boolean result = cajero.retirar(100000);
        Assertions.assertTrue(result);
    }

    @Test
    void testConsultarSaldo() {
        int result = cajero.obtenerSaldo();
        Assertions.assertEquals(100000,result);
        boolean result2 = cajero.retirar(1000);
        Assertions.assertTrue(result2);
        int result3 = cajero.obtenerSaldo();
        Assertions.assertEquals(99000,result3);
    }

    @Test
    void testDepositoValido() {
        int result = cajero.depositar(1000);
        Assertions.assertEquals(101000,result);
    }

    @Test
    void testDepositoNegativo() {
        int result = cajero.depositar(-1000);
        Assertions.assertEquals(100000,result);
    }

    @Test
    void testDepositoNoMultiplo() {
        int result = cajero.depositar(100);
        Assertions.assertEquals(100000,result);
    }

}