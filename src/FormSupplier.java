import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.TableRowSorter;

public class FormSupplier extends JFrame{
//    Main Panel
    private JPanel mainPanel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable viewTable;
    private JButton addButton;
    private JButton resetButton;
    private JButton deleteButton;
    private JButton updateButton;

//    Popup Menu
    private JPopupMenu popupMenu;
    private JMenuItem editMenuItem;
    private JMenuItem deleteMenuItem;

// Filter and Pagination
    private JComboBox filter;
    private JButton backButton;
    private JTextField paginationField;
    private JButton nextButton;
    private String filterCriteria = "Terbaru";
    private int currentPage = 1;
    private int totalRows;
    private int totalPages;
    private TableRowSorter<DefaultTableModel> sorter;
    private List<DatabaseManager> allData;

    public FormSupplier(){
        searchSupplier();
        deleteSupplier();
        updateSupplier();
        addSupplier();
        resetButton.addActionListener(e -> {
            searchTextField.setText("");
            currentPage = 1;
            initTable();
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
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
        initComponents();
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
            currentPage = 1;
            initTable();
        });
    }

    public void deleteSupplier()
    {
        deleteButton.addActionListener(e->{
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk Hapus!", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int option = JOptionPane.showConfirmDialog(FormSupplier.this, "Apakah Anda yakin ingin menghapus item ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
                int modelRow = viewTable.convertRowIndexToModel(selectedRow);
                String id = model.getValueAt(modelRow, 0).toString();
                try {
                    boolean deleted = DatabaseManager.Del(id);
                    if (deleted) {
                        model.removeRow(modelRow);
                        JOptionPane.showMessageDialog(this, "Item berhasil dihapus.");
                        initTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus item.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus item: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

            int modelRow = viewTable.convertRowIndexToModel(chosenRow);

            TableModel tm = viewTable.getModel();
            Global.id = tm.getValueAt(modelRow, 0).toString();
            String nama = tm.getValueAt(modelRow, 1).toString();
            String alamat = tm.getValueAt(modelRow, 2).toString();
            String telp = tm.getValueAt(modelRow, 3).toString();

            UpdateSupplierForm updateFrame = new UpdateSupplierForm(nama,alamat,telp);
            updateFrame.setId(Global.id);
            updateFrame.setVisible(true);
        });
    }
//
    public void initComponents(){
        createPopupMenu();
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });


    }

    public void initTable(){
        try {
            String[] header = {"Id", "Nama", "Alamat", "Telp"};
            DefaultTableModel dtm = new DefaultTableModel(header, 0) {
                public boolean isCellEditable(int row, int column) {
                    return false; // All cells non-editable
                }
            };
            viewTable.setModel(dtm);
            viewTable.getColumnModel().getColumn(0).setMaxWidth(64);
            viewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            Connection conn = DatabaseConnection.getConnection();
            String keyword = searchTextField.getText().trim();
            String searchQuery = "SELECT * FROM r_supplier";
            if (!keyword.isEmpty()) {
                keyword = "%" + keyword + "%";
                searchQuery += " WHERE nama LIKE ?";
            }

            PreparedStatement statement = conn.prepareStatement(searchQuery);
            if (!keyword.isEmpty()) {
                statement.setString(1, keyword);
            }
            ResultSet rs = statement.executeQuery();

            List<DatabaseManager> data = new ArrayList<>();
            while (rs.next()) {
                DatabaseManager record = new DatabaseManager();
                record.setId(rs.getString("id"));
                record.setNama(rs.getString("nama"));
                record.setAlamat(rs.getString("alamat"));
                record.setTelp(rs.getString("telp"));
                data.add(record);
            }

            switch (filterCriteria) {
                case "Terbaru" -> {}
                case "Terlama" -> Collections.reverse(data);
                case "A-Z" -> Collections.sort(data, Comparator.comparing(DatabaseManager::getNama));
                default -> {}
            }

            allData = data;
            totalRows = data.size();
            int visibleRows = (viewTable.getHeight() - 20) / 20;
            int pageSize = Math.max(20, visibleRows);

            totalPages = (int) Math.ceil((double) totalRows / pageSize);

            int start = (currentPage - 1) * pageSize;
            int end = Math.min(start + pageSize, totalRows);

            for (int i = start; i < end; i++) {
                DatabaseManager record = data.get(i);
                Object[] row = {
                        String.valueOf(record.getId()),
                        record.getNama(),
                        record.getAlamat(),
                        record.getTelp()
                };
                dtm.addRow(row);
            }
            paginationField.setText(String.valueOf(currentPage));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {
        filterCriteria = (String) filter.getSelectedItem();
        initTable();
    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = viewTable.rowAtPoint(evt.getPoint());
        if (evt.getButton() == MouseEvent.BUTTON3 && row != -1) {
            viewTable.setRowSelectionInterval(row, row);
            popupMenu.show(viewTable, evt.getX(), evt.getY());
        }
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentPage > 1) {
            currentPage--;
            initTable();
        }
    }

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentPage < totalPages) {
            currentPage++;
            initTable();
        }
    }

    public void createPopupMenu() {
        popupMenu = new JPopupMenu();
        editMenuItem = new JMenuItem("Edit");
        deleteMenuItem = new JMenuItem("Delete");

        editMenuItem.addActionListener(e -> {
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow != -1) {
                int chosenRow = viewTable.getSelectedRow();
                if(chosenRow<0){
                    JOptionPane.showMessageDialog(null,
                            "Mohon pilih salah satu Data untuk Update!","Warning!",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int modelRow = viewTable.convertRowIndexToModel(chosenRow);

                TableModel tm = viewTable.getModel();
                Global.id = tm.getValueAt(modelRow, 0).toString();
                String nama = tm.getValueAt(modelRow, 1).toString();
                String alamat = tm.getValueAt(modelRow, 2).toString();
                String telp = tm.getValueAt(modelRow, 3).toString();

                UpdateSupplierForm updateFrame = new UpdateSupplierForm(nama,alamat,telp);
                updateFrame.setId(Global.id);
                updateFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diperbarui terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        deleteMenuItem.addActionListener(e -> {
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow != -1) {
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk Hapus!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int option = JOptionPane.showConfirmDialog(FormSupplier.this, "Apakah Anda yakin ingin menghapus item ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
                    int modelRow = viewTable.convertRowIndexToModel(selectedRow);
                    String id = model.getValueAt(modelRow, 0).toString();
                    try {
                        boolean deleted = DatabaseManager.Del(id);
                        if (deleted) {
                            model.removeRow(modelRow);
                            JOptionPane.showMessageDialog(this, "Item berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Gagal menghapus item.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus item: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        popupMenu.add(editMenuItem);
        popupMenu.add(deleteMenuItem);
    }

}
