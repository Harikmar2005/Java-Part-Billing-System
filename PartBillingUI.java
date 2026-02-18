import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import javax.swing.*;

public class PartBillingUI extends JFrame {

    private JTextField partField, rateField;
    private HashMap<String, Double> parts = new HashMap<>();
    static final String DB_URL = "festo valves.db";

    public PartBillingUI() {

        // Sample part data
        parts.put("0.020.2610", 2.00);
        parts.put("0.012.7591", 5.00);
        parts.put("0.015.3957", 12.00);
        parts.put("0.016.3958", 12.00);

        createTable();

        setTitle("Part Rate Finder");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // UI Layout
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Enter Part No:"));
        partField = new JTextField();
        add(partField);

        add(new JLabel("Rate:"));
        rateField = new JTextField();
        rateField.setEditable(false);
        add(rateField);

        JButton clearBtn = new JButton("Clear");
        add(clearBtn);

        JButton exitBtn = new JButton("Exit");
        add(exitBtn);

        // 🔹 Auto fetch when Enter key pressed
        partField.addActionListener(e -> fetchRate());

        clearBtn.addActionListener(e -> {
            partField.setText("");
            rateField.setText("");
            partField.requestFocus();
        });

        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void fetchRate() {
        String part = partField.getText().trim();

        if (parts.containsKey(part)) {
            double rate = parts.get(part);
            rateField.setText("₹ " + rate);
            saveSearch(part, rate);
        } else {
            rateField.setText("Not Found");
        }
    }

    private void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS search_history (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                partno TEXT,
                rate REAL,
                searched_at DATETIME DEFAULT CURRENT_TIMESTAMP
            );
        """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveSearch(String partno, double rate) {
        String sql = "INSERT INTO search_history(partno, rate) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, partno);
            pstmt.setDouble(2, rate);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PartBillingUI();
    }
}