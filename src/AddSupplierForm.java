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
            String alamat = alamatField.getText();
            String cp = cpField.getText();
            String telp = teleponField.getText();
            String kota = kotaField.getText();
            String fax = faxField.getText();
            String email = emailField.getText();
            if(nama.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Mohon Isi Nama!","Warning!",JOptionPane.WARNING_MESSAGE);
                return;
            }
            try{
                Connection conn = DatabaseConnection.getConnection();

                String INSERT_QUERY = "INSERT INTO r_supplier (nama,alamat,cp,telp,kota,fax,email) VALUES (?, ?, ?, ?, ?, ?, ?) ";

                PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);

                statement.setString(1, nama);
                statement.setString(2, alamat);
                statement.setString(3, cp);
                statement.setString(4, telp);
                statement.setString(5, kota);
                statement.setString(6, fax);
                statement.setString(7, email);
                statement.executeUpdate();
                dispose();
            }catch (SQLException err){
                throw new RuntimeException();
            }
        });
    }
}
