/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Out;

import Out.ConexionBD;
import Out.InterfazVistas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author rodrigo
 */
public class PanelEstadoAsistencia extends JPanel {

    private JLabel titulo;
    private JScrollPane scroll;
    private JTable asistenciaEmpleados;
    private JPanel filtroDepartamento;
    private JComboBox departamentosCB;
    private ConexionBD con = new ConexionBD();
    private Connection cn = con.conexion();

    public PanelEstadoAsistencia(Consultas  Consultas ) {
        init(Consultas);
        fillTable();
        load();
        
    }

    private void init(Consultas Consultas) {
        titulo = new JLabel("Estado De Asistencia De Empleados");
        filtroDepartamento = new JPanel(new GridLayout(1, 3));
        departamentosCB = new JComboBox(Consultas.departementos().toArray());
        filtroDepartamento.add(departamentosCB);
    }

    private void load() {
        add(Box.createRigidArea(new Dimension(200, 40)));
        add(titulo, BorderLayout.PAGE_START);
        add(filtroDepartamento);
        add(Box.createRigidArea(new Dimension(200, 40)));
        add(scroll, BorderLayout.CENTER);
    }

    private void fillTable() {
        String[] columnNames = {"Nombre",
            "CI",
            "Cargo",
            "Estado Asistencia",};

        Object[][] data = {{"Miler", "123456",
            "Scrum Team", "Puntual"},
        {"German", "234567",
            "Scrum Team", "Atrasado"},
        {"Javier", "345678",
            "Scrum Team", "Puntual"},
        {"Luis", "456789",
            "Product Owner", "Atrasado"},
        {"Miguel", "246810",
            "Scrum Team", "Puntual"},
        {"Rodrigo", "135790",
            "Scrum Master", "Puntual"}};
        asistenciaEmpleados = new JTable(data, columnNames);
        asistenciaEmpleados.setFillsViewportHeight(true);
        scroll = new JScrollPane(asistenciaEmpleados);
        scroll.setPreferredSize(new Dimension(500, 150));
    }

    
}
