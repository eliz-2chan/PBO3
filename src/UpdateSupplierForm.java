import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateSupplierForm extends JFrame{
    private JPanel mainPanel;
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField teleponField;
    private JButton cancelButton;
    private JTextField cpField;
    private JTextField kotaField;
    private JTextField faxField;
    private JTextField emailField;
    private JButton updateButton;
    private int id;
    public void setId(int id){
        this.id = id;
    }
    public UpdateSupplierForm(){
        updateSupplier();
        cancelButton.addActionListener(e->{
            dispose();
        });
        init();
    }
    public void init(){
        setContentPane(mainPanel);
        setTitle("Update Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void updateSupplier(){
        updateButton.addActionListener(e->{
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

                String UPDATE_QUERY = "UPDATE r_supplier SET nama=?, alamat=?, cp=?, telp=?, kota=?, fax=?, email=? WHERE id = ?";

                PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);

                statement.setString(1, nama);
                statement.setString(2, alamat);
                statement.setString(3, cp);
                statement.setString(4, telp);
                statement.setString(5, kota);
                statement.setString(6, fax);
                statement.setString(7, email);
                statement.setInt(8, id);
                statement.execute();
                dispose();
            }catch (SQLException err){
                throw new RuntimeException();
            }
        });
    }
    public void fillUpdateForm(){
        try{
            Connection conn = DatabaseConnection.getConnection();

            String SEARCH_BY_ID_QUERY = "SELECT * FROM r_supplier WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(SEARCH_BY_ID_QUERY);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                namaField.setText(rs.getString("nama"));
                alamatField.setText(rs.getString("alamat"));
                cpField.setText(rs.getString("cp"));
                teleponField.setText(rs.getString("telp"));
                kotaField.setText(rs.getString("kota"));
                faxField.setText(rs.getString("fax"));
                emailField.setText(rs.getString("email"));
            }
        }catch (SQLException err){
            throw new RuntimeException();
        }
    }
}
