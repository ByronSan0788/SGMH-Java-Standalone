package gestionmantenimientostandalone;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Clase que representa la ventana del módulo de inventario de equipos
 * del Sistema de Gestión de Mantenimiento Hospitalario.
 */
public class InventarioEquiposFrame extends JFrame {

    // Paneles principales de la ventana
    private JPanel panelPrincipal;
    private JPanel panelSidebar;
    private JPanel panelContenido;

    /**
     * Constructor de la ventana InventarioEquiposFrame.
     */
    public InventarioEquiposFrame() {
        inicializarComponentes();
    }

    /**
     * Método encargado de construir la interfaz del módulo.
     */
    private void inicializarComponentes() {
        // Configuración general de la ventana
        setTitle("Inventario de Equipos - Gestión de Mantenimiento");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(new Color(243, 244, 246));
        add(panelPrincipal);

        // =========================
        // SIDEBAR IZQUIERDO
        // =========================
        panelSidebar = new JPanel();
        panelSidebar.setLayout(null);
        panelSidebar.setBounds(0, 0, 235, 768);
        panelSidebar.setBackground(new Color(10, 21, 47));
        panelPrincipal.add(panelSidebar);

        JLabel lblGestion = new JLabel("Gestión de");
        lblGestion.setBounds(12, 18, 150, 30);
        lblGestion.setForeground(Color.WHITE);
        lblGestion.setFont(new Font("Arial", Font.BOLD, 24));
        panelSidebar.add(lblGestion);

        JLabel lblMantenimiento = new JLabel("Mantenimiento");
        lblMantenimiento.setBounds(12, 48, 190, 32);
        lblMantenimiento.setForeground(new Color(255, 107, 0));
        lblMantenimiento.setFont(new Font("Arial", Font.BOLD, 24));
        panelSidebar.add(lblMantenimiento);

        // Dashboard
        JLabel lblDashboard = crearItemMenu("Dashboard", 108);
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                DashboardFrame ventana = new DashboardFrame();
                ventana.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblDashboard);

        // Órdenes de Trabajo
        JLabel lblOrdenes = crearItemMenu("Órdenes de Trabajo", 160);
        lblOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                OrdenesTrabajoFrame ventana = new OrdenesTrabajoFrame();
                ventana.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblOrdenes);

        // Mantenimiento Preventivo
        JLabel lblMantenimientoPreventivo = crearItemMenu("Mantenimiento Preventivo", 212);
        lblMantenimientoPreventivo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                MantenimientoPreventivoFrame ventana = new MantenimientoPreventivoFrame();
                ventana.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblMantenimientoPreventivo);

        // Opción activa
        panelSidebar.add(crearItemActivo("Inventario de Equipos", 264));

        // Personal Técnico
        JLabel lblPersonal = crearItemMenu("Personal Técnico", 316);
        lblPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                PersonalTecnicoFrame ventana = new PersonalTecnicoFrame();
                ventana.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblPersonal);

        // Reportes
        JLabel lblReportes = crearItemMenu("Reportes", 368);
        lblReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                ReportesFrame ventana = new ReportesFrame();
                ventana.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblReportes);

        // Cerrar Sesión
        JLabel lblCerrarSesion = crearItemMenu("Cerrar Sesión", 420);
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblCerrarSesion);

        // =========================
        // CONTENIDO DERECHO
        // =========================
        panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(235, 0, 1131, 768);
        panelContenido.setBackground(new Color(243, 244, 246));
        panelPrincipal.add(panelContenido);

        JLabel lblTitulo = new JLabel("Inventario de Equipos");
        lblTitulo.setBounds(28, 18, 350, 35);
        lblTitulo.setForeground(new Color(10, 21, 47));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        panelContenido.add(lblTitulo);

        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(null);
        panelUsuario.setBounds(850, 20, 210, 34);
        panelUsuario.setBackground(Color.WHITE);
        panelUsuario.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1, true));
        panelContenido.add(panelUsuario);

        JLabel lblUsuario = new JLabel("Usuario: Administrador");
        lblUsuario.setBounds(12, 6, 190, 20);
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        panelUsuario.add(lblUsuario);

        // Tarjetas resumen del módulo
        panelContenido.add(crearTarjetaResumen("Equipos Totales", "56", 28, 80, 250));
        panelContenido.add(crearTarjetaResumen("Biomédicos", "31", 288, 80, 250));
        panelContenido.add(crearTarjetaResumen("Operativos", "48", 548, 80, 250));
        panelContenido.add(crearTarjetaResumen("En revisión", "8", 808, 80, 245));

        // Panel principal de la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(null);
        panelTabla.setBounds(28, 200, 1025, 300);
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panelContenido.add(panelTabla);

        JLabel lblSubtitulo = new JLabel("Listado de equipos");
        lblSubtitulo.setBounds(22, 18, 250, 30);
        lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblSubtitulo.setForeground(new Color(10, 21, 47));
        panelTabla.add(lblSubtitulo);

        // Encabezados
        panelTabla.add(crearEncabezadoTabla("Código", 35, 72, 100));
        panelTabla.add(crearEncabezadoTabla("Equipo", 160, 72, 260));
        panelTabla.add(crearEncabezadoTabla("Área", 470, 72, 170));
        panelTabla.add(crearEncabezadoTabla("Tipo", 700, 72, 100));
        panelTabla.add(crearEncabezadoTabla("Estado", 850, 72, 100));

        JLabel linea1 = new JLabel();
        linea1.setBounds(25, 98, 970, 1);
        linea1.setOpaque(true);
        linea1.setBackground(new Color(220, 220, 220));
        panelTabla.add(linea1);

        // Filas de ejemplo
        agregarFilaEquipo(panelTabla, "EQ-001", "Monitor de signos vitales", "UCI", "Biomédico", "Operativo", 112);
        agregarFilaEquipo(panelTabla, "EQ-002", "Ventilador mecánico", "Urgencias", "Biomédico", "En revisión", 160);
        agregarFilaEquipo(panelTabla, "EQ-003", "Electrocardiógrafo", "Consulta externa", "Biomédico", "Operativo", 208);
        agregarFilaEquipo(panelTabla, "EQ-004", "Bomba de infusión", "Hospitalización", "Biomédico", "Operativo", 256);
    }

    /**
     * Crea una opción normal del menú lateral.
     */
    private JLabel crearItemMenu(String texto, int y) {
        JLabel item = new JLabel(texto);
        item.setBounds(24, y, 190, 28);
        item.setForeground(Color.WHITE);
        item.setFont(new Font("Arial", Font.PLAIN, 16));
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return item;
    }

    /**
     * Crea la opción activa del menú lateral.
     */
    private JPanel crearItemActivo(String texto, int y) {
        JPanel itemActivo = new JPanel();
        itemActivo.setLayout(null);
        itemActivo.setBounds(10, y, 206, 42);
        itemActivo.setBackground(new Color(255, 107, 0));
        itemActivo.setBorder(BorderFactory.createEmptyBorder());

        JLabel lblTexto = new JLabel(texto);
        lblTexto.setBounds(14, 8, 190, 25);
        lblTexto.setForeground(Color.WHITE);
        lblTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        itemActivo.add(lblTexto);

        return itemActivo;
    }

    /**
     * Crea una tarjeta de resumen.
     */
    private JPanel crearTarjetaResumen(String titulo, String valor, int x, int y, int ancho) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(null);
        tarjeta.setBounds(x, y, ancho, 95);
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setBounds(18, 16, ancho - 30, 22);
        lblTitulo.setForeground(new Color(96, 105, 122));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 12));
        tarjeta.add(lblTitulo);

        JLabel lblValor = new JLabel(valor);
        lblValor.setBounds(18, 44, 80, 30);
        lblValor.setForeground(new Color(10, 21, 47));
        lblValor.setFont(new Font("Arial", Font.BOLD, 24));
        tarjeta.add(lblValor);

        return tarjeta;
    }

    /**
     * Crea un encabezado de tabla.
     */
    private JLabel crearEncabezadoTabla(String texto, int x, int y, int ancho) {
        JLabel encabezado = new JLabel(texto);
        encabezado.setBounds(x, y, ancho, 20);
        encabezado.setFont(new Font("Arial", Font.PLAIN, 16));
        encabezado.setForeground(new Color(10, 21, 47));
        return encabezado;
    }

    /**
     * Agrega una fila de datos al listado de equipos.
     */
    private void agregarFilaEquipo(JPanel panel, String codigo, String equipo, String area,
                                   String tipo, String estado, int y) {

        JLabel lblCodigo = new JLabel(codigo);
        lblCodigo.setBounds(35, y, 100, 22);
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblCodigo);

        JLabel lblEquipo = new JLabel(equipo);
        lblEquipo.setBounds(160, y, 290, 22);
        lblEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblEquipo);

        JLabel lblArea = new JLabel(area);
        lblArea.setBounds(470, y, 190, 22);
        lblArea.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblArea);

        JLabel lblTipo = new JLabel(tipo);
        lblTipo.setBounds(700, y, 110, 22);
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblTipo);

        JLabel badgeEstado = new JLabel(estado, SwingConstants.CENTER);
        badgeEstado.setBounds(835, y - 2, 130, 24);
        badgeEstado.setFont(new Font("Arial", Font.BOLD, 12));
        badgeEstado.setOpaque(true);

        if (estado.equals("Operativo")) {
            badgeEstado.setBackground(new Color(213, 245, 227));
            badgeEstado.setForeground(new Color(0, 102, 51));
        } else {
            badgeEstado.setBackground(new Color(252, 243, 207));
            badgeEstado.setForeground(new Color(180, 120, 0));
        }

        panel.add(badgeEstado);

        JLabel linea = new JLabel();
        linea.setBounds(25, y + 28, 970, 1);
        linea.setOpaque(true);
        linea.setBackground(new Color(220, 220, 220));
        panel.add(linea);
    }

    /**
     * Método principal para ejecutar la ventana de forma independiente.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new InventarioEquiposFrame().setVisible(true);
        });
    }
}