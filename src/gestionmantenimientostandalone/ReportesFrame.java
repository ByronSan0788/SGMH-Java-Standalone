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
 * Clase que representa la ventana del módulo de reportes
 * del Sistema de Gestión de Mantenimiento Hospitalario.
 */
public class ReportesFrame extends JFrame {

    // Paneles principales de la ventana
    private JPanel panelPrincipal;
    private JPanel panelSidebar;
    private JPanel panelContenido;

    /**
     * Constructor de la ventana ReportesFrame.
     */
    public ReportesFrame() {
        inicializarComponentes();
    }

    /**
     * Método encargado de construir la interfaz del módulo.
     */
    private void inicializarComponentes() {
        // Configuración general de la ventana
        setTitle("Reportes - Gestión de Mantenimiento");
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

        // Inventario de Equipos
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

        // Opción activa
        panelSidebar.add(crearItemActivo("Reportes", 368));

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

        JLabel lblTitulo = new JLabel("Reportes");
        lblTitulo.setBounds(28, 18, 300, 35);
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
        panelContenido.add(crearTarjetaResumen("Reportes Generados", "14", 28, 80, 250));
        panelContenido.add(crearTarjetaResumen("Órdenes Cerradas", "27", 288, 80, 250));
        panelContenido.add(crearTarjetaResumen("Equipos Atendidos", "52", 548, 80, 250));
        panelContenido.add(crearTarjetaResumen("Técnicos Evaluados", "7", 808, 80, 245));

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

        JLabel lblSubtitulo = new JLabel("Resumen de reportes");
        lblSubtitulo.setBounds(22, 18, 280, 30);
        lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblSubtitulo.setForeground(new Color(10, 21, 47));
        panelTabla.add(lblSubtitulo);

        // Encabezados
        panelTabla.add(crearEncabezadoTabla("Código", 35, 72, 100));
        panelTabla.add(crearEncabezadoTabla("Tipo de reporte", 180, 72, 260));
        panelTabla.add(crearEncabezadoTabla("Fecha", 500, 72, 140));
        panelTabla.add(crearEncabezadoTabla("Generado por", 660, 72, 160));
        panelTabla.add(crearEncabezadoTabla("Estado", 850, 72, 100));

        JLabel linea1 = new JLabel();
        linea1.setBounds(25, 98, 970, 1);
        linea1.setOpaque(true);
        linea1.setBackground(new Color(220, 220, 220));
        panelTabla.add(linea1);

        // Filas de ejemplo
        agregarFilaReporte(panelTabla, "REP-001", "Reporte de órdenes", "30/03/2026", "Administrador", "Disponible", 112);
        agregarFilaReporte(panelTabla, "REP-002", "Reporte de inventario", "30/03/2026", "Administrador", "Disponible", 160);
        agregarFilaReporte(panelTabla, "REP-003", "Reporte de mantenimiento", "29/03/2026", "Jefe técnico", "Disponible", 208);
        agregarFilaReporte(panelTabla, "REP-004", "Reporte de personal", "28/03/2026", "Administrador", "Pendiente", 256);
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
        lblTexto.setBounds(14, 8, 180, 25);
        lblTexto.setForeground(Color.WHITE);
        lblTexto.setFont(new Font("Arial", Font.PLAIN, 18));
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
        lblValor.setBounds(18, 44, 100, 30);
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
     * Agrega una fila de datos al listado de reportes.
     */
    private void agregarFilaReporte(JPanel panel, String codigo, String tipo, String fecha,
                                    String generadoPor, String estado, int y) {

        JLabel lblCodigo = new JLabel(codigo);
        lblCodigo.setBounds(35, y, 100, 22);
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblCodigo);

        JLabel lblTipo = new JLabel(tipo);
        lblTipo.setBounds(180, y, 280, 22);
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblTipo);

        JLabel lblFecha = new JLabel(fecha);
        lblFecha.setBounds(500, y, 120, 22);
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblFecha);

        JLabel lblGeneradoPor = new JLabel(generadoPor);
        lblGeneradoPor.setBounds(660, y, 170, 22);
        lblGeneradoPor.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblGeneradoPor);

        JLabel badgeEstado = new JLabel(estado, SwingConstants.CENTER);
        badgeEstado.setBounds(835, y - 2, 130, 24);
        badgeEstado.setFont(new Font("Arial", Font.BOLD, 12));
        badgeEstado.setOpaque(true);

        if (estado.equals("Disponible")) {
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
            new ReportesFrame().setVisible(true);
        });
    }
}