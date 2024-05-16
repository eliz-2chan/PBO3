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
    private JTextField jtField;
    private JTextField awalField;
    private JTextField hutangField;
    private JTextField discField;
    private JTextField bayarField;
    private JTextField akhirField;
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
            Boolean result = supplier.updSupplier(this.id);
            if (result) {
                JOptionPane.showMessageDialog(null,
                        "Edit Berhasil!","Sukses!",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else {
                JOptionPane.showMessageDialog(null,
                        "Error!", "Warning!", JOptionPane.WARNING_MESSAGE);
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

                jtField.setText(rs.getString("jt"));
                discField.setText(rs.getString("disc"));
                awalField.setText(rs.getString("awal"));
                hutangField.setText(rs.getString("hutang"));
                bayarField.setText(rs.getString("bayar"));
                akhirField.setText(rs.getString("akhir"));
            }
        }catch (SQLException err){
            throw new RuntimeException();
        }
    }
}
