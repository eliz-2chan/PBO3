import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddSupplierForm extends JFrame {
    private JPanel mainPanel;
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField teleponField;
    private JButton cancelButton;
    private JButton addButton;
    private JTextField cpField;
    private JTextField kotaField;
    private JTextField faxField;
    private JTextField emailField;
    private JTextField discField;
    private JTextField awalField;
    private JTextField hutangField;
    private JTextField bayarField;
    private JTextField jtField;
    private JTextField akhirField;

    public AddSupplierForm(){
        createSupplier();
        cancelButton.addActionListener(e->{
            dispose();
        });
        init();
    }
    public void init(){
        setContentPane(mainPanel);
        setTitle("Tambah Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void createSupplier(){
        addButton.addActionListener(e->{
            String nama = namaField.getText();
            if(nama.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Mohon Isi Nama!","Warning!",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String alamat = alamatField.getText();
            String cp = cpField.getText();
            String telp = teleponField.getText();
            String kota = kotaField.getText();
            String fax = faxField.getText();
            String email = emailField.getText();
            Integer jt = Integer.parseInt(jtField.getText());
            Double disc = Double.parseDouble(discField.getText());
            Double awal = Double.parseDouble(awalField.getText());
            Double hutang = Double.parseDouble(hutangField.getText());
            Double bayar = Double.parseDouble(bayarField.getText());
            Double akhir = Double.parseDouble(akhirField.getText());

            Supplier supplier = new Supplier(
                    nama,
                    alamat,
                    cp,
                    telp,
                    kota,
                    fax,
                    email,
                    jt,
                    disc,
                    awal,
                    hutang,
                    bayar,
                    akhir
            );
            Boolean result = supplier.addSuplier();
            if (result) {
                JOptionPane.showMessageDialog(null,
                        "Add Berhasil!","Sukses!",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,
                        "Error!","Warning!",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
