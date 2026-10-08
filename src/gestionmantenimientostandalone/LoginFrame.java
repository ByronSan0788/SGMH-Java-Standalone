package gestionmantenimientostandalone;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase que representa la ventana de inicio de sesión del
 * Sistema de Gestión de Mantenimiento Hospitalario.
 */
public class LoginFrame extends JFrame {

    // Panel principal donde se agregan todos los componentes del formulario
    private JPanel panel;

    // Etiquetas de texto para título y campos del formulario
    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblContrasena;

    // Campos de entrada para capturar usuario y contraseña
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    // Botón principal para acceder al sistema
    private JButton btnIngresar;

    /**
     * Constructor de la ventana LoginFrame.
     * Al ejecutarse, llama al método que inicializa todos los componentes.
     */
    public LoginFrame() {
        inicializarComponentes();
    }

    /**
     * Método encargado de configurar la ventana
     * y crear todos los componentes visuales del login.
     */
    private void inicializarComponentes() {

        // Configuración general de la ventana
        setTitle("Iniciar Sesión - Gestión de Mantenimiento");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); // Evita que el usuario cambie el tamaño

        // Creación del panel principal
        panel = new JPanel();
        panel.setLayout(null); // Se usa posicionamiento manual de componentes
        panel.setBackground(new Color(245, 247, 250));
        add(panel);

        // Título principal del formulario
        lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setBounds(140, 40, 220, 40);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitulo);

        // Etiqueta para el campo de usuario
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(90, 120, 100, 25);
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(lblUsuario);

        // Campo de texto para escribir el nombre de usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(90, 150, 300, 35);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(txtUsuario);

        // Etiqueta para el campo de contraseña
        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(90, 200, 120, 25);
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(lblContrasena);

        // Campo de contraseña para ocultar los caracteres ingresados
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(90, 230, 300, 35);
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(txtContrasena);

        // Botón de acceso al sistema
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(170, 300, 140, 40);
        btnIngresar.setBackground(new Color(255, 107, 0));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(btnIngresar);

        // Evento del botón para validar el inicio de sesión
        btnIngresar.addActionListener(e -> validarLogin());
    }

    /**
     * Método que valida las credenciales ingresadas por el usuario.
     */
    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        // Verifica que los campos no estén vacíos
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos.",
                    "Campos vacíos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación básica de acceso con credenciales de prueba
        if (usuario.equals("admin") && contrasena.equals("1234")) {
            JOptionPane.showMessageDialog(this,
                    "Inicio de sesión exitoso.",
                    "Acceso permitido",
                    JOptionPane.INFORMATION_MESSAGE);

            // Abre la ventana principal del sistema
            DashboardFrame dashboard = new DashboardFrame();
            dashboard.setVisible(true);

            // Cierra la ventana de login después del acceso correcto
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.",
                    "Error de acceso",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método principal que ejecuta la ventana LoginFrame.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}