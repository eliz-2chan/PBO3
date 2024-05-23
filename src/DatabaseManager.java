import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends Person{
    private String telp;
    private String id;

    // No Argument Constructor
    public DatabaseManager() {
        super("", "");
        this.telp = "";
        this.id = "";
    }
//    Normal Constructor
    public DatabaseManager(String nama, String alamat, String telp)
    {
        super(nama, alamat);
        this.telp = telp;
    }

    //    Telepon Get and Setter
    public String getTelp() {
        return telp;
    }
    public void setTelp(String telp) {
        this.telp = telp;
    }

    //    ID
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

//  Read Data to Table Method
    public static void baca_data(DefaultTableModel tb, String sql) throws SQLException {
        java.sql.Connection db = (Connection) DatabaseConnection.getConnection();
        try (PreparedStatement q = db.prepareStatement(sql)) {
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                tb.addRow(new Object[]{
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("telp"),
                });
            }
        }
    }

//    Add Method
    public static void Add(DatabaseManager supplier) throws SQLException {
        Connection db = DatabaseConnection.getConnection();
        String sql = "INSERT INTO r_supplier (nama, alamat, telp) VALUES (?, ?, ?)";
        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, supplier.getNama());
            q.setString(2, supplier.getAlamat());
            q.setString(3, supplier.getTelp());
            q.executeUpdate();
        }
    }

//    Edit Method
    public static void Edit(DatabaseManager supplier, String id) throws SQLException {
        Connection db = DatabaseConnection.getConnection();
        String sqledit = "UPDATE r_supplier SET nama = ?, alamat = ?, telp = ? WHERE id = ?";
        try (PreparedStatement q = db.prepareStatement(sqledit)) {
            q.setString(1, supplier.getNama());
            q.setString(2, supplier.getAlamat());
            q.setString(3, supplier.getTelp());
            q.setString(4, Global.id);
            q.executeUpdate();
        }
    }

//      Delete Method
    public static boolean Del(String id) throws SQLException {
        Connection db = DatabaseConnection.getConnection();
        String sql = "DELETE FROM r_supplier WHERE id = ?";
        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, id);
            int effect = q.executeUpdate();
            return effect > 0;
        }
    }
}
