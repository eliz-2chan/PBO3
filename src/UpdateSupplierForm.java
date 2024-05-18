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
    private JButton updateButton;
    private String id;
    public void setId(String id){
        this.id = id;
    }

    public UpdateSupplierForm(String nama, String alamat, String telp)
    {
        this.namaField.setText(nama);
        this.alamatField.setText(alamat);
        this.teleponField.setText(telp);

        updateSupplier();
        cancelButton.addActionListener(e->{
            dispose();
        });
        init();
    }
    public void init()
    {
        setContentPane(mainPanel);
        setTitle("Update Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void updateSupplier()
    {
        updateButton.addActionListener(e-> {
            String nama = namaField.getText();
            String telp = teleponField.getText();
            String alamat = alamatField.getText();
            String id = this.id;

            if (nama.isEmpty() || telp.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi.", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!telp.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Nomor telepon harus berupa angka.", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Global.id = id;

            try {
                DatabaseManager.Edit(new DatabaseManager(nama, alamat, telp), Global.id);
                dispose();
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.", "Sukses",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException evt) {
                evt.printStackTrace();
            }
        });
    }

}
