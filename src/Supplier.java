public class Supplier extends Person{
    private String cp;
    private String telp;
    private String kota;
    private String fax;
    private String email;
    private Integer jt;
    private Double disc;
    private Double awal;
    private Double hutang;
    private Double bayar;
    private Double akhir;

    // Constructor
    public Supplier(String nama, String alamat, String cp, String telp, String kota, String fax, String email,
                    Integer jt, Double disc, Double awal, Double hutang, Double bayar, Double akhir)
    {
        super(nama, alamat);
        this.cp = cp;
        this.telp = telp;
        this.kota = kota;
        this.fax = fax;
        this.email = email;
        this.jt = jt;
        this.disc = disc;
        this.awal = awal;
        this.hutang = hutang;
        this.bayar = bayar;
        this.akhir = akhir;
    }

    //    CP Get and Setter
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }

    //    Telepon Get and Setter
    public String getTelp() {
        return telp;
    }
    public void setTelp(String telp) {
        this.telp = telp;
    }

    //    Kota Get and Setter
    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }

    //    Fax Get and Setter
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }

    //    Email Get and Setter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //    Jt Get and Setter
    public Integer getJt() {
        return jt;
    }
    public void setJt(Integer jt) {
        this.jt = jt;
    }

    //  Discount Get and Setter
    public Double getDisc(){
        return disc;
    }
    public void setDisc(Double disc){
        this.disc =  disc;
    }

    //  Awal Get and Setter
    public Double getAwal(){
        return awal;
    }
    public void setAwal(Double awal){
        this.awal =  awal;
    }

    //  Hutang Get and Setter
    public Double getHutang(){
        return hutang;
    }
    public void setHutang(Double hutang){
        this.hutang =  hutang;
    }

    //  Bayar Get and Setter
    public Double getBayar(){
        return bayar;
    }
    public void setBayar(Double bayar){
        this.bayar =  bayar;
    }

    //  Akhir Get and Setter
    public Double getAkhir(){
        return akhir;
    }
    public void setAkhir(Double akhir){
        this.akhir =  akhir;
    }

//    public Boolean addSuplier()
//    {
//        try{
//            Connection conn = DatabaseConnection.getConnection();
//
//            String INSERT_QUERY = "INSERT INTO r_supplier (nama,alamat,cp,telp,kota,fax,email, jt, disc, awal, hutang, bayar,akhir) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
//
//            PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);
//
//            statement.setString(1, this.getNama());
//            statement.setString(2, this.getAlamat());
//            statement.setString(3, this.getCp());
//            statement.setString(4, this.getTelp());
//            statement.setString(5, this.getKota());
//            statement.setString(6, this.getFax());
//            statement.setString(7, this.getEmail());
//            statement.setInt(8, this.getJt());
//            statement.setDouble(9, this.getDisc());
//            statement.setDouble(10, this.getAwal());
//            statement.setDouble(11, this.getHutang());
//            statement.setDouble(12, this.getBayar());
//            statement.setDouble(13, this.getAkhir());
//
//            statement.executeUpdate();
//            return true;
//        }catch (SQLException err){
//            throw new RuntimeException();
//        }
//    }
//
//    public Boolean updSupplier(Integer id){
//        try{
//            Connection conn = DatabaseConnection.getConnection();
//
//            String UPDATE_QUERY = "UPDATE r_supplier SET nama=?, alamat=?, cp=?, telp=?, kota=?, fax=?, email=?,jt=?,disc=?,awal=?,hutang=?,bayar=?,akhir=? WHERE id = ?";
//
//            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
//
//            statement.setString(1, this.getNama());
//            statement.setString(2, this.getAlamat());
//            statement.setString(3, this.getCp());
//            statement.setString(4, this.getTelp());
//            statement.setString(5, this.getKota());
//            statement.setString(6, this.getFax());
//            statement.setString(7, this.getEmail());
//            statement.setInt(8, this.getJt());
//            statement.setDouble(9, this.getDisc());
//            statement.setDouble(10, this.getAwal());
//            statement.setDouble(11, this.getHutang());
//            statement.setDouble(12, this.getBayar());
//            statement.setDouble(13, this.getAkhir());
//            statement.setInt(14, id);
//            statement.execute();
//            return true;
//        }catch (SQLException err){
//            throw new RuntimeException();
//        }
//    }
//
//    public static Boolean delSupplier(Integer id){
//        try
//        {
//            Connection conn = DatabaseConnection.getConnection();
//
//            String DELETE_QUERY = "DELETE FROM r_supplier WHERE id=?";
//
//            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
//
//            statement.setInt(1, Global.id);
//            statement.executeUpdate();
//            return true;
//        } catch (SQLException err) {
//            throw new RuntimeException(err);
//        }
//    }
//
//    public static void baca_data(DefaultTableModel tb, String sql) throws SQLException {
//        Connection db = DatabaseConnection.getConnection();
//        ;
//        try (PreparedStatement q = db.prepareStatement(sql)) {
//            ResultSet rs = q.executeQuery();
//            while (rs.next()) {
//                tb.addRow(new Object[]{
//                        rs.getString("id"),
//                        rs.getString("nama"),
//                        rs.getString("alamat"),
//                        rs.getString("cp"),
//                        rs.getString("telp"),
//                        rs.getString("kota"),
//                        rs.getString("fax"),
//                        rs.getString("email"),
//                        rs.getString("jt"),
//                        rs.getString("disc"),
//                        rs.getString("awal"),
//                        rs.getString("hutang"),
//                        rs.getString("bayar"),
//                        rs.getString("akhir")
//                });
//            }
//        }
//    }
    public static void main(String[] args) {
//        Contoh penggunaan
        Supplier supplier = new Supplier(
                "John Doe",
                "Jl. Contoh No.123",
                "John Doe",
                "0821000000",
                "Semarang",
                "024351",
                "john@gmail.com",
                5,
                0.5,
                2.0,
                3.0,
                1.0,
                5.0);
        System.out.println(supplier);
    }
}
