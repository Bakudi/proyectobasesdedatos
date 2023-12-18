import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.sql.*;
import java.util.Map;
import java.util.stream.Collectors;

public class ejemplo {
    public static Connection connection;

    public ejemplo() {
        try {
            connection = Databasemanager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarUsuario(String id, String nombre) {
        String sql = "INSERT INTO ejemplo (id, nombre) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.setString(2, nombre);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        insertarUsuario("ab","ab");
}}
