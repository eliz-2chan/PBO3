// Super Class

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

    // Method toString to represent the Object with String
    @Override
    public String toString() {
        return "Person{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        Method Testing
        Person person1 = new Person("Eliz","US");
    }
}
