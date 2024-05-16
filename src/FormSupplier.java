import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class FormSupplier extends JFrame{
    private JPanel mainPanel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable viewTable;
    private JButton addButton;
    private JButton resetButton;
    private JButton deleteButton;
    private JButton updateButton;

    public FormSupplier(){
        searchSupplier();
        deleteSupplier();
        updateSupplier();
        addSupplier();
        resetButton.addActionListener(e -> {
            searchTextField.setText("");
            initTable();
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
//                super.windowActivated(e);
                initTable();
            }
        });
        initTable();
        init();
    }
    public void init(){
        setContentPane(mainPanel);
        setTitle("Data Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void addSupplier(){
        addButton.addActionListener(e -> {
            AddSupplierForm inputFrame = new AddSupplierForm();
            inputFrame.setVisible(true);
        });
    }
    public void searchSupplier()
    {
        searchButton.addActionListener(e -> {
            try{
                Connection conn = DatabaseConnection.getConnection();

                String keyword  = searchTextField.getText();
                if(keyword.equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Mohon Isi Kata Kunci Untuk Pencarian!","Warning!",JOptionPane.WARNING_MESSAGE);
                    searchTextField.requestFocus();
                    return;
                }

                keyword  = "%" +  searchTextField.getText() + "%";
                String searchSupplierQuery = "SELECT * FROM r_supplier WHERE nama LIKE ?";

                PreparedStatement statement = conn.prepareStatement(searchSupplierQuery);
                statement.setString(1,keyword);
                ResultSet rs = statement.executeQuery();

                DefaultTableModel dtm = (DefaultTableModel) viewTable.getModel();
                dtm.setRowCount(0);


                Object[] row = new Object[14];
                while(rs.next()){
                    row[0] = rs.getInt("id");
                    row[1] = rs.getString("nama");
                    row[2] = rs.getString("alamat");
                    row[3] = rs.getString("cp");
                    row[4] = rs.getString("telp");
                    row[5] = rs.getString("kota");
                    row[6] = rs.getString("fax");
                    row[7] = rs.getString("email");
                    row[8] = rs.getString("jt");
                    row[9] = rs.getString("disc");
                    row[10] = rs.getString("awal");
                    row[11] = rs.getString("hutang");
                    row[12] = rs.getString("bayar");
                    row[13] = rs.getString("akhir");
                    dtm.addRow(row);
                }

            }catch(Exception err){
                err.printStackTrace();
            };
        });

    }
    public void deleteSupplier()
    {
        deleteButton.addActionListener(e->{
            int chosenRow = viewTable.getSelectedRow();
//            JOptionPane.showMessageDialog(null,String.valueOf(chosenRow));
            if(chosenRow<0){
                JOptionPane.showMessageDialog(null,
                        "Mohon pilih salah satu Data!","Warning!",JOptionPane.WARNING_MESSAGE);
                return;
            }

            TableModel tm = viewTable.getModel();
            String nama = tm.getValueAt(chosenRow,1).toString();
            int choice = JOptionPane.showConfirmDialog(null,
                    "Hapus Data dengan nama  " + nama + "?",
                    "Warning!",
                    JOptionPane.YES_NO_OPTION);

            if (choice == 0 ){
                Global.id  = Integer.parseInt(tm.getValueAt(chosenRow,0).toString());
                Boolean result = Supplier.delSupplier(Global.id);
                if (result) {
                    JOptionPane.showMessageDialog(null,
                            "Delete Berhasil!","Sukses!",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Error!","Warning!",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    public void updateSupplier(){
        updateButton.addActionListener(e -> {
            int chosenRow = viewTable.getSelectedRow();
            if(chosenRow<0){
                JOptionPane.showMessageDialog(null,
                        "Mohon pilih salah satu Data untuk Update!","Warning!",JOptionPane.WARNING_MESSAGE);
                return;
            }
            TableModel tm = viewTable.getModel();
            Global.id  = Integer.parseInt(tm.getValueAt(chosenRow,0).toString());

            UpdateSupplierForm updateFrame = new UpdateSupplierForm();
            updateFrame.setId(Global.id);
            updateFrame.fillUpdateForm();
            updateFrame.setVisible(true);
        });
    }
    public void initTable(){
        try{
            String select_all_query = "SELECT * FROM r_supplier ORDER BY id";
            String [] header = {"Id","Nama","Alamat","CP","Telepon","Kota","Fax","Email","Jt","Disc","Awal","Hutang","Bayar","Akhir"};
            DefaultTableModel dtm = new DefaultTableModel(header,0);
            viewTable.setModel(dtm);

            viewTable.getColumnModel().getColumn(0).setMaxWidth(32);
            viewTable.getColumnModel().getColumn(8).setMaxWidth(32);
            viewTable.getColumnModel().getColumn(9).setMaxWidth(64);
            viewTable.getColumnModel().getColumn(10).setMaxWidth(64);
            viewTable.getColumnModel().getColumn(11).setMaxWidth(64);
            viewTable.getColumnModel().getColumn(12).setMaxWidth(64);
            viewTable.getColumnModel().getColumn(13).setMaxWidth(64);
            viewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            Supplier.baca_data(dtm, select_all_query);

        }catch(Exception e){
            e.printStackTrace();
        };
    }
}
