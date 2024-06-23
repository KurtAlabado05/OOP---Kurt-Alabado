import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ItemManager {

    private static final String ID_PREFIX = "ITM";
    private static final int ID_LENGTH = 6; // Adjust as needed

    // Method to generate a custom item ID
    public static String generateItemId(Connection sqlConn) throws SQLException {
        String lastId = null;

        // Fetch the last generated ID
        String query = "SELECT custom_id FROM itemlist ORDER BY custom_id DESC LIMIT 1";
        try (PreparedStatement pst = sqlConn.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    lastId = rs.getString("custom_id");
                }
            }
        }

        // Generate new ID
        String newId = generateRandomId();

        // Ensure uniqueness
        while (lastId != null && lastId.equals(newId)) {
            newId = generateRandomId();
        }

        return newId;
    }

    // Helper method to generate a random ID
    private static String generateRandomId() {
        StringBuilder sb = new StringBuilder();
        sb.append(ID_PREFIX);

        Random random = new Random();
        for (int i = 0; i < ID_LENGTH - ID_PREFIX.length(); i++) {
            sb.append(random.nextInt(10)); // Append random digits (0-9)
        }

        return sb.toString();
    }
    
    private static final String RESERVATION_ID_PREFIX = "RSRV";
    private static final int RESERVATION_ID_LENGTH = 8; // Adjust as needed

    // Method to generate a custom reservation ID
    public static String generateReservationId(Connection sqlConn) throws SQLException {
        String lastId = null;

        // Fetch the last generated reservation ID
        String query = "SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1";
        try (PreparedStatement pst = sqlConn.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    lastId = rs.getString("reservation_id");
                }
            }
        }

        // Generate new reservation ID
        String newId = generateRandomReservationId();

        // Ensure uniqueness
        while (lastId != null && lastId.equals(newId)) {
            newId = generateRandomReservationId();
        }

        return newId;
    }

    // Helper method to generate a random reservation ID
    private static String generateRandomReservationId() {
        StringBuilder sb = new StringBuilder();
        sb.append(RESERVATION_ID_PREFIX);

        Random random = new Random();
        for (int i = 0; i < RESERVATION_ID_LENGTH - RESERVATION_ID_PREFIX.length(); i++) {
            sb.append(random.nextInt(10)); // Append random digits (0-9)
        }

        return sb.toString();
    }
}
