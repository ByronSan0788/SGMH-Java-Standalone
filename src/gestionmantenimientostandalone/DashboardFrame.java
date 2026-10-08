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
 * Clase que representa el panel principal del
 * Sistema de Gestión de Mantenimiento Hospitalario.
 */
public class DashboardFrame extends JFrame {

    // Paneles principales de la ventana
    private JPanel panelPrincipal;
    private JPanel panelSidebar;
    private JPanel panelContenido;

    /**
     * Constructor de la ventana DashboardFrame.
     */
    public DashboardFrame() {
        inicializarComponentes();
    }

    /**
     * Método que construye la interfaz principal del dashboard.
     */
    private void inicializarComponentes() {
        // Configuración general de la ventana
        setTitle("Panel Principal - Gestión de Mantenimiento");
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

        // Título del sistema en la barra lateral
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

        // Opción activa Dashboard
        JPanel itemActivo = new JPanel();
        itemActivo.setLayout(null);
        itemActivo.setBounds(10, 100, 206, 42);
        itemActivo.setBackground(new Color(255, 107, 0));
        itemActivo.setBorder(BorderFactory.createEmptyBorder());
        panelSidebar.add(itemActivo);

        JLabel lblDashboard = new JLabel("Dashboard");
        lblDashboard.setBounds(14, 8, 120, 25);
        lblDashboard.setForeground(Color.WHITE);
        lblDashboard.setFont(new Font("Arial", Font.PLAIN, 18));
        itemActivo.add(lblDashboard);

        // Opciones del menú con navegación
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

        JLabel lblInventario = crearItemMenu("Inventario de Equipos", 264);
        lblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                InventarioEquiposFrame ventana = new InventarioEquiposFrame();
                ventana.setVisible(true);
                dispose();
            }
        });
        panelSidebar.add(lblInventario);

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

        // Título principal del contenido
        JLabel lblTitulo = new JLabel("Panel Principal");
        lblTitulo.setBounds(28, 18, 300, 35);
        lblTitulo.setForeground(new Color(10, 21, 47));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        panelContenido.add(lblTitulo);

        // Panel superior con el usuario autenticado
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

        // Tarjetas resumen del sistema
        panelContenido.add(crearTarjetaResumen("Órdenes Pendientes", "12", 28, 80, 250));
        panelContenido.add(crearTarjetaResumen("Mantenimientos Programados", "8", 288, 80, 250));
        panelContenido.add(crearTarjetaResumen("Equipos Registrados", "56", 548, 80, 250));
        panelContenido.add(crearTarjetaResumen("Técnicos Activos", "7", 808, 80, 245));

        // Panel de órdenes recientes
        JPanel panelOrdenes = new JPanel();
        panelOrdenes.setLayout(null);
        panelOrdenes.setBounds(28, 200, 1025, 272);
        panelOrdenes.setBackground(Color.WHITE);
        panelOrdenes.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panelContenido.add(panelOrdenes);

        JLabel lblOrdenesRecientes = new JLabel("Órdenes recientes");
        lblOrdenesRecientes.setBounds(22, 18, 250, 30);
        lblOrdenesRecientes.setFont(new Font("Arial", Font.BOLD, 22));
        lblOrdenesRecientes.setForeground(new Color(10, 21, 47));
        panelOrdenes.add(lblOrdenesRecientes);

        // Encabezados de la tabla
        panelOrdenes.add(crearEncabezadoTabla("Código", 35, 72, 100));
        panelOrdenes.add(crearEncabezadoTabla("Equipo", 275, 72, 250));
        panelOrdenes.add(crearEncabezadoTabla("Área", 685, 72, 100));
        panelOrdenes.add(crearEncabezadoTabla("Estado", 900, 72, 100));

        // Línea separadora superior
        JLabel linea1 = new JLabel();
        linea1.setBounds(25, 98, 970, 1);
        linea1.setOpaque(true);
        linea1.setBackground(new Color(220, 220, 220));
        panelOrdenes.add(linea1);

        // Filas de ejemplo para órdenes recientes
        agregarFilaOrden(panelOrdenes, "OT-001", "Monitor de signos vitales", "UCI", "Pendiente", 112);
        agregarFilaOrden(panelOrdenes, "OT-002", "Ventilador mecánico", "Urgencias", "En proceso", 160);
        agregarFilaOrden(panelOrdenes, "OT-003", "Bomba de infusión", "Hospitalización", "Completado", 208);
    }

    /**
     * Crea una opción del menú lateral con formato uniforme.
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
     * Crea una tarjeta resumen para el panel principal.
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
     * Crea un encabezado para la tabla de órdenes recientes.
     */
    private JLabel crearEncabezadoTabla(String texto, int x, int y, int ancho) {
        JLabel encabezado = new JLabel(texto);
        encabezado.setBounds(x, y, ancho, 20);
        encabezado.setFont(new Font("Arial", Font.PLAIN, 16));
        encabezado.setForeground(new Color(10, 21, 47));
        return encabezado;
    }

    /**
     * Agrega una fila de información al panel de órdenes recientes.
     */
    private void agregarFilaOrden(JPanel panel, String codigo, String equipo, String area, String estado, int y) {
        JLabel lblCodigo = new JLabel(codigo);
        lblCodigo.setBounds(35, y, 100, 22);
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblCodigo);

        JLabel lblEquipo = new JLabel(equipo);
        lblEquipo.setBounds(275, y, 320, 22);
        lblEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblEquipo);

        JLabel lblArea = new JLabel(area);
        lblArea.setBounds(685, y, 160, 22);
        lblArea.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblArea);

        JLabel badgeEstado = new JLabel(estado, SwingConstants.CENTER);
        badgeEstado.setBounds(885, y - 2, 95, 24);
        badgeEstado.setFont(new Font("Arial", Font.BOLD, 12));
        badgeEstado.setOpaque(true);

        // Asignación de color según el estado de la orden
        if (estado.equals("Pendiente")) {
            badgeEstado.setBackground(new Color(252, 243, 207));
            badgeEstado.setForeground(new Color(180, 120, 0));
        } else if (estado.equals("En proceso")) {
            badgeEstado.setBackground(new Color(214, 234, 248));
            badgeEstado.setForeground(new Color(0, 51, 204));
        } else {
            badgeEstado.setBackground(new Color(213, 245, 227));
            badgeEstado.setForeground(new Color(0, 102, 51));
        }

        panel.add(badgeEstado);

        JLabel linea = new JLabel();
        linea.setBounds(25, y + 28, 970, 1);
        linea.setOpaque(true);
        linea.setBackground(new Color(220, 220, 220));
        panel.add(linea);
    }

    /**
     * Método principal para ejecutar la ventana de manera independiente.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new DashboardFrame().setVisible(true);
        });
    }
}