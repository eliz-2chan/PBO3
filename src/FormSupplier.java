import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.sql.SQLException;
import javax.swing.table.TableRowSorter;

import com.stripbandunk.jwidget.JPagination;
import com.stripbandunk.jwidget.model.DefaultPaginationModel;

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
//    private JComboBox filter;
//    private JButton backButton;
//    private JButton nextButton;
    private JPagination Halaman;
    private JButton btntampil;
    private JComboBox cbtampil;
    private JComboBox cbkol;
    private JButton btndesc;
    private JButton btnasc;
    private DefaultPaginationModel paginationModel;
//    private String filterCriteria = "Terbaru";
//    private int currentPage = 1;
//    private int totalRows;
//    private int totalPages;
//    private TableRowSorter<DefaultTableModel> sorter;
//    private List<DatabaseManager> allData;

    private DefaultTableModel tb = new DefaultTableModel();

    int baris;
    int kol;

    String order;
    String ascdes;


    public FormSupplier(){
        ascdes = " ASC";
//        viewTable.setModel(tb);
        searchSupplier();
        deleteSupplier();
        updateSupplier();
        addSupplier();
        resetButton.addActionListener(e -> {
//            searchTextField.setText("");
//            currentPage = 1;
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
//            currentPage = 1;
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

            int option = JOptionPane.showConfirmDialog(FormSupplier.this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
                int modelRow = viewTable.convertRowIndexToModel(selectedRow);
                String id = model.getValueAt(modelRow, 0).toString();
                try {
                    boolean deleted = DatabaseManager.Del(id);
                    if (deleted) {
                        model.removeRow(modelRow);
                        JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                        initTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void updateSupplier(){
        updateButton.addActionListener(e -> {
            int chosenRow = viewTable.getSelectedRow();
            System.out.println(chosenRow);
            if(chosenRow<0){
                JOptionPane.showMessageDialog(null,
                        "Mohon pilih salah satu Data untuk diupdate!","Warning!",JOptionPane.WARNING_MESSAGE);
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

//        filter.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                FilterActionPerformed(evt);
//            }
//        });
//
//        nextButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                nextActionPerformed(evt);
//            }
//        });
//
//        backButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                backActionPerformed(evt);
//            }
//        });

        Halaman.addPaginationListener(new com.stripbandunk.jwidget.listener.PaginationListener() {
              public void onPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
                  HalamanOnPageChange(evt);
              }
        });

        btntampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntampilActionPerformed(evt);
            }
        });


        btnasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnascActionPerformed(evt);
            }
        });

        btndesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescActionPerformed(evt);
            }
        });
    }

//    public void initTable(){
//        try {
//            String[] header = {"Id", "Nama", "Alamat", "Telp"};
//            DefaultTableModel dtm = new DefaultTableModel(header, 0) {
//                public boolean isCellEditable(int row, int column) {
//                    return false; // All cells non-editable
//                }
//            };
//            viewTable.setModel(dtm);
//            viewTable.getColumnModel().getColumn(0).setMaxWidth(64);
//            viewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//            String tampil = (String)cbtampil.getSelectedItem();
//            paginationModel = new DefaultPaginationModel();
//            //Kita misalkan ada 500 record, disini bisa lakukan count di DB
//            paginationModel.setTotalItem(Global.JmlRec(Global.sql));
//            //Mengeset jumlah record untuk satu halaman
//            int n = Integer.parseInt(tampil);
//            paginationModel.setPageSize(n);
//            Halaman.setModel(paginationModel);
//
//            Connection conn = DatabaseConnection.getConnection();
//            String keyword = searchTextField.getText().trim();
//            String searchQuery = "SELECT * FROM r_supplier";
//            if (!keyword.isEmpty()) {
//                keyword = "%" + keyword + "%";
//                searchQuery += " WHERE nama LIKE ?";
//            }
//
//            PreparedStatement statement = conn.prepareStatement(searchQuery);
//            if (!keyword.isEmpty()) {
//                statement.setString(1, keyword);
//            }
//            ResultSet rs = statement.executeQuery();
//
//            List<DatabaseManager> data = new ArrayList<>();
//            while (rs.next()) {
//                DatabaseManager record = new DatabaseManager();
//                record.setId(rs.getString("id"));
//                record.setNama(rs.getString("nama"));
//                record.setAlamat(rs.getString("alamat"));
//                record.setTelp(rs.getString("telp"));
//                data.add(record);
//            }
//
//            switch (filterCriteria) {
//                case "Terbaru" -> {}
//                case "Terlama" -> Collections.reverse(data);
//                case "A-Z" -> Collections.sort(data, Comparator.comparing(DatabaseManager::getNama));
//                case "A-Z Alamat" -> Collections.sort(data, Comparator.comparing(DatabaseManager::getAlamat));
//                default -> {}
//            }
//
//            allData = data;
//            totalRows = data.size();
//            int visibleRows = (viewTable.getHeight() - 20) / 20;
//            int pageSize = Math.max(20, visibleRows);
//
//            totalPages = (int) Math.ceil((double) totalRows / pageSize);
//
//            int start = (currentPage - 1) * pageSize;
//            int end = Math.min(start + pageSize, totalRows);
//
//            for (int i = start; i < end; i++) {
//                DatabaseManager record = data.get(i);
//                Object[] row = {
//                        String.valueOf(record.getId()),
//                        record.getNama(),
//                        record.getAlamat(),
//                        record.getTelp()
//                };
//                dtm.addRow(row);
//            }
//            paginationField.setText(String.valueOf(currentPage));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
            dtm.addTableModelListener(e -> {
                viewTable.revalidate();
                viewTable.repaint();
            });

            String tampil = (String) cbtampil.getSelectedItem();
            String f = (String) cbkol.getSelectedItem();
            order = " ORDER BY " + f + ascdes ;
            Global.sql="Select * FROM r_supplier WHERE id <> '' ";
            emptyTable(dtm);
            String cari = searchTextField.getText();
            String sql = Global.sql;
            if (!cari.isEmpty()) {
                sql = sql + " AND id like '%" + cari + "%' ";
                sql = sql + " OR nama like '%" + cari + "%' ";
                sql = sql + " OR alamat like '%" + cari + "%' ";
                sql = sql + " OR telp like '%" + cari + "%' ";
            }
            System.out.println(sql);
            Global.sql = sql + order;
            paginationModel = new DefaultPaginationModel();

            //Kita misalkan ada 500 record, disini bisa lakukan count di DB
            paginationModel.setTotalItem(Global.JmlRec(Global.sql));

            //Mengeset jumlah record untuk satu halaman
            int n = Integer.parseInt(tampil);
            paginationModel.setPageSize(n);
            Halaman.setModel(paginationModel);
            sql = Global.sql + " limit " + n;

            DatabaseManager.baca_data(dtm,sql);
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void emptyTable(DefaultTableModel dtm){
        int rowCount = dtm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

//    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {
//        filterCriteria = (String) filter.getSelectedItem();
//        initTable();
//    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = viewTable.rowAtPoint(evt.getPoint());
        if (evt.getButton() == MouseEvent.BUTTON3 && row != -1) {
            viewTable.setRowSelectionInterval(row, row);
            popupMenu.show(viewTable, evt.getX(), evt.getY());
        }
    }

//    private void backActionPerformed(java.awt.event.ActionEvent evt) {
//        if (currentPage > 1) {
//            currentPage--;
//            initTable();
//        }
//    }
//
//    private void nextActionPerformed(java.awt.event.ActionEvent evt) {
//        if (currentPage < totalPages) {
//            currentPage++;
//            initTable();
//        }
//    }

    public void createPopupMenu() {
        popupMenu = new JPopupMenu();
        editMenuItem = new JMenuItem("Update");
        deleteMenuItem = new JMenuItem("Delete");

        editMenuItem.addActionListener(e -> {
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow != -1) {
                int chosenRow = viewTable.getSelectedRow();
                if(chosenRow<0){
                    JOptionPane.showMessageDialog(null,
                            "Mohon pilih salah satu Data untuk diupdate!","Warning!",JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk diupdate!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });

        deleteMenuItem.addActionListener(e -> {
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow != -1) {
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk Hapus!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int option = JOptionPane.showConfirmDialog(FormSupplier.this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
                    int modelRow = viewTable.convertRowIndexToModel(selectedRow);
                    String id = model.getValueAt(modelRow, 0).toString();
                    try {
                        boolean deleted = DatabaseManager.Del(id);
                        if (deleted) {
                            model.removeRow(modelRow);
                            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        popupMenu.add(editMenuItem);
        popupMenu.add(deleteMenuItem);
    }

    private void HalamanOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
        DefaultTableModel dtm = (DefaultTableModel) viewTable.getModel();
        // digunakan untuk mengeset limit pada query DB
        int limit = (evt.getCurrentPage() - 1) * evt.getPageSize();
        //contoh query
        String sql = Global.sql + " Limit " + limit + ", " + evt.getPageSize();
        System.out.println(sql);
        try {
            emptyTable(dtm);
            DatabaseManager.baca_data(dtm,sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    private void btntampilActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            initTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void btnascActionPerformed(java.awt.event.ActionEvent evt)
    {
        ascdes = " ASC";
        try {
            initTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    private void btndescActionPerformed(java.awt.event.ActionEvent evt)
    {
        ascdes = " DESC";
        try {
            initTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
