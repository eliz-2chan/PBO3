import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAO {
    private static final String INSERT_QUERY = "INSERT INTO r_supplier (nama,alamat,cp,telp,kota,fax,email,jt,disc,awal,hutang,bayar,akhir) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM r_supplier";
    public static void tambahSupplier(Supplier supplier) throws SQLException
    {
        Connection conn = DatabaseConnection.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(INSERT_QUERY))
        {
            statement.setString(1, supplier.getNama());
            statement.setString(2, supplier.getAlamat());
            statement.setString(3, supplier.getCp());
            statement.setString(4, supplier.getTelp());
            statement.setString(5, supplier.getKota());
            statement.setString(6, supplier.getFax());
            statement.setString(7, supplier.getEmail());
            statement.setInt(8, supplier.getJt());
            statement.setDouble(9, supplier.getDisc());
            statement.setDouble(10, supplier.getAwal());
            statement.setDouble(11, supplier.getHutang());
            statement.setDouble(12, supplier.getBayar());
            statement.setDouble(13, supplier.getAkhir());
            statement.executeUpdate();
        }
    }
    public static void tampilkanSupplier() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String cp = resultSet.getString("cp");
                String telp = resultSet.getString("telp");
                String kota = resultSet.getString("kota");
                String fax = resultSet.getString("fax");
                String email = resultSet.getString("email");
                Integer jt = resultSet.getInt("jt");
                Double disc = resultSet.getDouble("disc");
                Double awal = resultSet.getDouble("awal");
                Double hutang = resultSet.getDouble("hutang");
                Double bayar = resultSet.getDouble("bayar");
                Double akhir = resultSet.getDouble("akhir");
                System.out.println(
                    "Nama: " + nama +
                    ",Alamat: " + alamat +
                    ",CP: " + cp +
                    ",Telp: " + telp +
                    ",kota: " + kota +
                    ",fax: " + fax +
                    ",email: " + email +
                    ",jt: " + jt +
                    ",disc: " + disc +
                    ",awal: " + awal +
                    ",hutang: " + hutang +
                    ",bayar: " + bayar +
                    ",akhir: " + akhir
                );
            }
        }
    }
    public static void editSupplier(Supplier supplier) throws SQLException{

    }
    public static void hapusSupplier(Supplier supplier) throws SQLException{

    }
    public static void main(String[] args) {
        // Contoh penggunaan
        Supplier supplier1 = new Supplier(
                "John Doe",
                "Jl. Contoh No. 123",
                "12345",
                "08123456",
                "Semarang",
                "024123",
                "john@gmail.com",
                1,
                0.5,
                2.0,
                3.0,
                2.0,
                4.0
        );
        Supplier supplier2 = new Supplier(
                "Anna Doe",
                "Jl. Contoh No. 123",
                "12345",
                "08123456",
                "Semarang",
                "024123",
                "john@gmail.com",
                1,
                0.5,
                2.0,
                3.0,
                2.0,
                4.0
        );
        try {
            SupplierDAO.tambahSupplier(supplier1);
            SupplierDAO.tambahSupplier(supplier2);
            System.out.println("Data Supplier yang tersimpan di database:");
            SupplierDAO.tampilkanSupplier();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    //Changing My Credential
}
