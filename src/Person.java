public class Person {
    private String nama;
    private String alamat;

    //Constructor
    public Person(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
    // Getter dan setter
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    // Method toString untuk representasi String dari objek
    @Override
    public String toString() {
        return "Person{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}
