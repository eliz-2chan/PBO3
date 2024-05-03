import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SupplierDAO {
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    private static final String INSERT_QUERY = "INSERT INTO r_supplier (nama,alamat,cp,telp,kota,fax,email,jt,disc,awal,hutang,bayar,akhir) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE r_supplier SET nama=?, alamat=?, cp=?, telp=?, kota=?, fax=?, email=?, jt=?, disc=?, awal=?, hutang=?, bayar=?, akhir=? WHERE id=?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM r_supplier";
    private static final String SELECT_ONE = "SELECT * FROM r_supplier WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM r_supplier WHERE id=?";
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
                Integer id = resultSet.getInt("id");
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
                System.out.println("Data Supplier yang tersimpan di database:");
                System.out.println(
                    "id :" + id +
                    ", Nama: " + nama +
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
    public static void tampilkanSatuSupplier(Integer id_query) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(SELECT_ONE)) {
            statement.setInt(1, id_query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
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
                System.out.println("Data Supplier yang dengan id " + id_query + ":");
                System.out.println(
                        "id :" + id +
                                ", Nama: " + nama +
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

    public static void editSupplier() throws SQLException{
        Connection conn = DatabaseConnection.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY)) {
            SupplierDAO.tampilkanSupplier();
            System.out.print("Pilih ID yang mau diedit dengan data di atas: ");
            Integer id = Integer.parseInt(input.readLine());

            System.out.print("nama: ");
            String nama = input.readLine().trim();

            System.out.print("alamat: ");
            String alamat = input.readLine().trim();

            System.out.print("cp: ");
            String cp = input.readLine().trim();

            System.out.print("telp: ");
            String telp = input.readLine().trim();

            System.out.print("kota: ");
            String kota = input.readLine().trim();

            System.out.print("fax: ");
            String fax = input.readLine().trim();

            System.out.print("email: ");
            String email = input.readLine().trim();

            System.out.print("jt: ");
            Integer jt = Integer.parseInt(input.readLine().trim());

            System.out.print("disc: ");
            Double disc = Double.parseDouble(input.readLine().trim());

            System.out.print("awal: ");
            Double awal = Double.parseDouble(input.readLine().trim());

            System.out.print("hutang: ");
            Double hutang = Double.parseDouble(input.readLine().trim());

            System.out.print("bayar: ");
            Double bayar = Double.parseDouble(input.readLine().trim());

            System.out.print("akhir: ");
            Double akhir = Double.parseDouble(input.readLine().trim());


            statement.setString(1, nama);
            statement.setString(2, alamat);
            statement.setString(3, cp);
            statement.setString(4, telp);
            statement.setString(5, kota);
            statement.setString(6, fax);
            statement.setString(7, email);
            statement.setInt(8, jt);
            statement.setDouble(9, disc);
            statement.setDouble(10, awal);
            statement.setDouble(11, hutang);
            statement.setDouble(12, bayar);
            statement.setDouble(13, akhir);
            statement.setInt(14, id);
            statement.execute();
            System.out.println("Data Supplier dengan id : " + id + " berhasil di update!");
            SupplierDAO.tampilkanSatuSupplier(id);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void hapusSupplier() throws SQLException{
        Connection conn = DatabaseConnection.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(DELETE_QUERY))
        {
            SupplierDAO.tampilkanSupplier();
            System.out.print("ID yang mau dihapus: ");
            Integer id = Integer.parseInt(input.readLine());
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Contoh penggunaan
        Supplier supplier1 = new Supplier(
                "Fyodor Dostoevsky",
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
//        Supplier supplier2 = new Supplier(
//                "Anna Doe",
//                "Jl. Contoh No. 123",
//                "12345",
//                "08123456",
//                "Semarang",
//                "024123",
//                "john@gmail.com",
//                1,
//                0.5,
//                2.0,
//                3.0,
//                2.0,
//                4.0
//        );
        try {
            System.out.println("Hello World!");
//            SupplierDAO.tampilkanSupplier();
            SupplierDAO.tambahSupplier(supplier1);
//            SupplierDAO.tambahSupplier(supplier2);
//            System.out.println("Data Supplier yang tersimpan di database:");
//            SupplierDAO.tampilkanSupplier();
//            SupplierDAO.editSupplier();
//            SupplierDAO.hapusSupplier();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
