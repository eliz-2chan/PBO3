import java.sql.SQLException;
import java.util.Random;

public class DatabaseFactory {
    private static final String[] NAMES = {
            "Budi","Siti","Agus","Dewi","Ayu","Rini","Toni","Maya","Rudi","Dedi","Wati","Rina","Fajar","Eka","Rama","Dian","Tina","Hadi","Asep","Iwan","Yuli","Indra","Ari","Lina","Tari","Bambang","Susi","Joko","Desi","Yanti","Yudi","Yanto","Rizki","Mira","Dimas","Nina","Putri","Dodi","Ratna","Yusuf","Lilis","Bayu","Sari","Vina","Amin","Umi","Anto","Novi","Adis","Alya",
            "Danu","Zara","Citra","Roni","Nana","Galih","Eris","Miko","Acha","Zaki","Lia","Rani","Euis","Hana","Rosa","Mega","Wawan","Yoga","Anis","Asep","Rendy","Heri","Ujang","Tomi","Feri","Bima","Mia","Intan","Gita","Vira","Ika","Kiki","Oki","Anwar","Alda","Nia","Taufik","Nina","Edi","Maman","Dewi","Tina","Hilda","Rio","Dini","Ari","Reza","Fina","Bona","Sani","Hendra","Irma","Dodo",
            "Adi Putra","Ani Dewi","Budi Santoso","Dina Sari","Eka Rini","Feri Yana","Gita Anin","Hadi Wira","Indra Arya","Joko Wati","Kiki Tania","Lina Putri","Maya Sari","Nina Rina","Oki Dina","Putu Sari","Rian Dito","Siti Rini","Tari Ani","Udin Aji","Vina Lest","Wati Rina","Yana Sari","Zara Nia","Aldi Budi","Beni Wira","Dodi Rani","Euis Rani","Fina Rini","Gita Rani","Hana Sari","Irma Lest","Jaka Dina","Kara Sari","Lani Rina","Mila Putri","Nuri Wati","Oni Dewi","Pina Sari","Rani Tania",
            "Sari Yana","Tina Sari","Ulia Dewi","Vino Aris","Weni Lest","Yani Rani","Zani Dina","Asep Budi","Bani Wira","Dila Rani","Echa Wati","Fira Tini","Gani Sari","Hani Putri","Icha Rani","Jani Dina","Kori Lest","Lora Wati","Maya Rina","Nina Dewi","Olin Sari","Pita Rina","Rima Sari","Sami Wira","Tami Lest","Ulin Rani","Vidi Dina","Wina Sari","Yani Dina","Zefa Wati","Aris Wira","Bima Sari","Deni Rina","Elia Lest","Fira Tani","Gana Wati","Hana Dina","Inda Sari","Jeni Wati","Kiko Lest","Lilo Sari","Miki Rina","Nisa Dewi","Oma Rani","Pina Wati","Rana Dina","Sani Wira","Tika Rani","Uta Sari","Vini Lest","Wida Rani","Yona Sari","Zula Dewi","Ajeng Wati","Bayu Rina","Deni Sari","Echa Rani","Fika Wati","Gina Lest"
    };

    private static final String[] ADDRESSES = {
            "Jl. Sudirman", "Jl. Thamrin", "Jl. Gatot Subroto", "Jl. Ahmad Yani", "Jl. Sisingamangaraja", "Jl. Diponegoro", "Jl. Panglima Polim", "Jl. Kebon Jeruk", "Jl. Casablanca", "Jl. Rasuna Said",
            "Jl. H.R. Rasuna Said", "Jl. Senopati", "Jl. Dr. Sutomo", "Jl. Imam Bonjol", "Jl. Cikini", "Jl. Kramat Raya", "Jl. Jend. Sudirman", "Jl. Merdeka Barat", "Jl. Merdeka Timur", "Jl. Merdeka Utara",
            "Jl. K.H. Wahid Hasyim", "Jl. Prof. Dr. Satrio", "Jl. Letjen S. Parman", "Jl. Mangga Besar", "Jl. Hayam Wuruk", "Jl. Gajah Mada", "Jl. Gunung Sahari", "Jl. Pangeran Jayakarta", "Jl. Gunung Sahari Raya",
            "Jl. Sukarjo Wiryopranoto", "Jl. Mangga Dua", "Jl. Pintu Besar Selatan", "Jl. Pintu Besar Utara", "Jl. Kali Besar", "Jl. Bank", "Jl. Lada", "Jl. Kunir", "Jl. Pinangsia", "Jl. Hayam Wuruk",
            "Jl. Medan Merdeka Selatan", "Jl. Abdul Muis", "Jl. Tanah Abang", "Jl. Kebon Sirih", "Jl. Sabang", "Jl. Teuku Umar", "Jl. Diponegoro", "Jl. Pegangsaan Timur", "Jl. Proklamasi", "Jl. Salemba Raya",
            "Jl. Percetakan Negara", "Jl. Kramat", "Jl. Matraman", "Jl. Pramuka", "Jl. Pemuda", "Jl. Balai Pustaka", "Jl. Pramuka Raya", "Jl. Taman Mini", "Jl. Raya Bogor", "Jl. Condet", "Jl. Dewi Sartika",
            "Jl. Kalibata", "Jl. Pasar Minggu", "Jl. Warung Buncit", "Jl. Mampang Prapatan", "Jl. Gatot Subroto", "Jl. Jenderal Sudirman", "Jl. MT Haryono", "Jl. D.I. Panjaitan", "Jl. Mayjen Sutoyo",
            "Jl. Letjen Suprapto", "Jl. Pramuka", "Jl. Ahmad Yani", "Jl. Perintis Kemerdekaan", "Jl. Yos Sudarso", "Jl. R.E. Martadinata", "Jl. Gunung Sahari", "Jl. Lodan", "Jl. Mangga Dua", "Jl. Gunung Sahari",
            "Jl. Kemayoran", "Jl. Rajawali", "Jl. Benyamin Sueb", "Jl. Garuda", "Jl. Bungur", "Jl. Tanah Tinggi", "Jl. Senen", "Jl. Kramat Raya", "Jl. Salemba Raya", "Jl. Matraman Raya", "Jl. Pramuka",
            "Jl. Pemuda", "Jl. Bekasi Timur", "Jl. Bekasi Barat", "Jl. I Gusti Ngurah Rai", "Jl. Raya Kalimalang", "Jl. Inspeksi Kalimalang", "Jl. KH Noer Ali", "Jl. Kemang", "Jl. Wolter Monginsidi",
            "Jl. Trunojoyo", "Jl. Pattimura", "Jl. Cipete Raya", "Jl. Ampera", "Jl. Antasari", "Jl. Fatmawati", "Jl. Radio Dalam", "Jl. Wijaya", "Jl. Benda", "Jl. Bangka", "Jl. Melawai",
            "Jl. Barito", "Jl. Tirtayasa", "Jl. Pakubuwono", "Jl. Hang Lekir", "Jl. Hang Tuah", "Jl. Hang Jebat", "Jl. Wijaya Kusuma", "Jl. Senayan", "Jl. Raden Patah", "Jl. Prapanca",
            "Jl. Gunawarman", "Jl. Suryo", "Jl. Surabaya", "Jl. Dipati Ukur", "Jl. Surapati", "Jl. Dago"
    };

    public static void main(String[] args) {
        int numData = 200;
        try {
            for (int i = 0; i < numData; i++) {
                String nama = getRandomName();
                String telp = "08" + getRandomTenDigitNumber();
                String alamat = getRandomCity();
                DatabaseManager.Add(new DatabaseManager(nama, alamat, telp));
                System.out.println("Data berhasil ditambahkan: " + nama + ", " + telp + ", " + alamat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomName() {
        Random random = new Random();
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
    }

    private static String getRandomTenDigitNumber() {
        Random random = new Random();
        long number = (long) (random.nextDouble() * 9_000_000_000L) + 1_000_000_000L;
        return String.valueOf(number);
    }

    private static String getRandomCity() {
        Random random = new Random();
        int index = random.nextInt(ADDRESSES.length);
        return ADDRESSES[index];
    }

}
