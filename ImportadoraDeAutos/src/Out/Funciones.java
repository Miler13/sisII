/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Out;

/**
 *
 * @author MI HP
 */
public class Funciones {

    public int Ganancia(String num) {
        int res = Integer.parseInt(num);
        boolean esContado = true;
        if (esNumero(num)) {
            if (res > 2000) {
                res = (int) (res * 0.4);
            } else {
                res = (int) (res * 0.2);
            }
        } else {
            JOptionPane("Ingrese Un Numero Valido");
        }

        return res;

    }

    public boolean esNumero(String n) {
        try {
            int numero = Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    

    private void JOptionPane(String ingrese_Un_Numero_Valido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
