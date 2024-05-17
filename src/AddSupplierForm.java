import javax.swing.*;
import java.sql.SQLException;

public class AddSupplierForm extends JFrame {
    private JPanel mainPanel;
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField teleponField;
    private JButton cancelButton;
    private JButton addButton;

    public AddSupplierForm(){
        createSupplier();
        cancelButton.addActionListener(e->{
            dispose();
        });
        init();
    }
    public void init(){
        setContentPane(mainPanel);
        setTitle("Tambah Data Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void createSupplier(){
        addButton.addActionListener(e->{
            String nama = namaField.getText();
            String telp = teleponField.getText();
            String alamat = alamatField.getText();

            if (nama.isEmpty() || telp.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!telp.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Nomor telepon harus berupa angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                DatabaseManager.Add(new DatabaseManager(nama, alamat, telp));
                dispose();
            } catch (SQLException evt) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan data: " + evt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
//            String nama = namaField.getText();
//            if(nama.isEmpty()){
//                JOptionPane.showMessageDialog(null,
//                        "Mohon Isi Nama!","Warning!",JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//            String alamat = alamatField.getText();
//            String cp = cpField.getText();
//            String telp = teleponField.getText();
//            String kota = kotaField.getText();
//            String fax = faxField.getText();
//            String email = emailField.getText();
//            Integer jt = Integer.parseInt(jtField.getText());
//            Double disc = Double.parseDouble(discField.getText());
//            Double awal = Double.parseDouble(awalField.getText());
//            Double hutang = Double.parseDouble(hutangField.getText());
//            Double bayar = Double.parseDouble(bayarField.getText());
//            Double akhir = Double.parseDouble(akhirField.getText());
//
//            Supplier supplier = new Supplier(
//                    nama,
//                    alamat,
//                    cp,
//                    telp,
//                    kota,
//                    fax,
//                    email,
//                    jt,
//                    disc,
//                    awal,
//                    hutang,
//                    bayar,
//                    akhir
//            );
//            Boolean result = supplier.addSuplier();
//            if (result) {
//                JOptionPane.showMessageDialog(null,
//                        "Add Berhasil!","Sukses!",JOptionPane.INFORMATION_MESSAGE);
//                dispose();
//            }else{
//                JOptionPane.showMessageDialog(null,
//                        "Error!","Warning!",JOptionPane.WARNING_MESSAGE);
//            }
        });
    }
}
