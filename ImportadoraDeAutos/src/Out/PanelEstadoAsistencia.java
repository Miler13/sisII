/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Out;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    private final Consultas consultas;
    private DefaultTableModel modelo;

    public PanelEstadoAsistencia(Consultas consultas) {
        init(consultas);
        initTable();
        load();
        this.consultas = consultas;
    }

    private void init(Consultas Consultas) {
        setLayout(new GridLayout(3, 1));
        titulo = new JLabel("Estado De Asistencia De Empleados");
        filtroDepartamento = new JPanel(new GridLayout(1, 3));
        filtroDepartamento.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        departamentosCB = new JComboBox(Consultas.departementos().toArray());
        departamentosCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTable(departamentosCB.getSelectedItem().toString());
                System.out.println(departamentosCB.getSelectedItem().toString());
            }

        });
        filtroDepartamento.add(titulo);
        filtroDepartamento.add(departamentosCB);
    }

    private void load() {
        add(filtroDepartamento);
//        add(new RigidArea());
//        add(filtroDepartamento, BorderLayout.PAGE_START);
        add(scroll, BorderLayout.CENTER);
//        add(scroll, BorderLayout.CENTER);
    }

    private void fillTable(String departamento) {
        modelo = consultas.estadoAsistencia(departamento);
        modelo.fireTableStructureChanged();
        asistenciaEmpleados.repaint();
        asistenciaEmpleados.setModel(modelo);
    }
    
    private void initTable() {
        asistenciaEmpleados = new JTable(modelo);
        asistenciaEmpleados.setFillsViewportHeight(true);
        scroll = new JScrollPane(asistenciaEmpleados);
        scroll.setPreferredSize(new Dimension(200, 150));
    }

}
