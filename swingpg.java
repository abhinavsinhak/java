private JTable table;
    
public DisplayReportForm() {
    super("Display Report Form");
    Container container = getContentPane();
    container.setLayout(new BorderLayout());
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Sushant@12");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        table = new JTable(buildTableModel(rs));
        JScrollPane scrollPane = new JScrollPane(table);
        container.add(scrollPane, BorderLayout.CENTER);
        con.close();
    } catch(Exception ex) {
        System.out.println(ex);
    }
    setSize(400,300);
    setVisible(true);
}

public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();
    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }
    return new DefaultTableModel(data, columnNames);
}

public static void main(String[] args) {
    DisplayReportForm displayReportForm = new DisplayReportForm();
    displayReportForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
