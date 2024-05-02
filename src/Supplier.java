import java.util.Date;

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
    // private Date tgl;
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

    public static void main(String[] args) {
        // Contoh penggunaan
        Supplier supplier = new Supplier("John Doe", "Jl. Contoh No.123", "John Doe", "0821000000","Semarang","024351","john@gmail.com",5,0.5,2.0,3.0,1.0,5.0);
        System.out.println(supplier);
    }
}
