/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Out;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MI HP
 */
public class FuncionesTest {

    /**
     * Test of Ganancia method, of class Funciones.
     */
    @Test
    public void testGanancia() {
        String num = "2400";
        Funciones instance = new Funciones();
        int expResult = 480;
        int result = instance.Ganancia(num);
        String cad1 = "" + expResult;
        String cad2 = "" + result;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }

    }

    @Test
    public void testGanancia1() {
        String num = "2400";
        Funciones instance = new Funciones();
        int expResult = 480;
        int result = instance.Ganancia(num);
        String cad1 = "" + expResult;
        String cad2 = "" + result;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }

    }

    @Test(expected = NumberFormatException.class)
    public void testGanancia2() {
        String num = "240HUI";
        Funciones instance = new Funciones();
        int expResult = 0;
        int result = instance.Ganancia(num);
    }

    @Test
    public void testGanancia3() {
        String num = "2400";
        Funciones instance = new Funciones();
        int expResult = 480;
        int result = instance.Ganancia(num);
        String cad1 = "" + expResult;
        String cad2 = "" + result;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEsNumero() {
        String cad = "2400";
        Funciones instance = new Funciones();
        assertTrue(instance.esNumero(cad));
    }
            
    
    
}
