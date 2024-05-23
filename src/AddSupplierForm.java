import javax.swing.*;
import java.sql.SQLException;

public class AddSupplierForm extends JFrame {
    private JPanel mainPanel;
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField teleponField;
    private JButton cancelButton;
    private JButton addButton;

//    Add Form Constructor
    public AddSupplierForm(){
//        Calling Event Listener
        createSupplier();
//        Cancel Button Listener
        cancelButton.addActionListener(e->{
            dispose();
        });
//        Init Form
        init();
    }

//    Init Form
    public void init(){
        setContentPane(mainPanel);
        setTitle("Tambah Data Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

//    Add Button Event Listener
    public void createSupplier(){
        addButton.addActionListener(e->{
            String nama = namaField.getText();
            String telp = teleponField.getText();
            String alamat = alamatField.getText();

//            Validation
            if (nama.isEmpty() || telp.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi.", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!telp.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Nomor telepon harus berupa angka.", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }

//            Input to Database
            try {
                DatabaseManager.Add(new DatabaseManager(nama, alamat, telp));
                dispose();
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.", "Sukses",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException evt) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan data: " + evt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
