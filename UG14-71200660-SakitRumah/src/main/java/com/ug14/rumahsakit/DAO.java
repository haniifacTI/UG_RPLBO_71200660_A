package com.ug14.rumahsakit;

import java.sql.*;


public class DAO {
    private String url = "jdbc:sqlite:rumahsakit.db";

    public Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
//            System.out.println("Koneksi berhasil.");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Nama: " + meta.getDriverName());
                System.out.println("Database tercipta");
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pasien (" + "rm INT PRIMARY KEY," + " nama text NOT NULL," + "usia INT NOT NULL," + "alamat text NOT NULL" + ");";
        String sql1 = "CREATE TABLE IF NOT EXISTS jadwal (" + " idPemeriksa INT PRIMARY KEY," + "rm INT NOT NULL," + "idDokter int NOT NULL," + "idSuster int NOT NULL," + "idPelayanan int NOT NULL," + " status text NOT NULL"  + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Tabel pasien tercipta!");
            stmt.execute(sql1);
            System.out.println("Tabel jadwal tercipta!");
        }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        public void showAllTables(){
            try (Connection conn = DriverManager.getConnection(url)){
                ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
                while (rs.next()) {
                    System.out.println(rs.getString("TABLE_NAME"));
                }
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }



//    public Dokter getDokterById(int idDokter){
//
//    }
//
//    public Suster getSusterById(int idSuster){
//
//    }
//
    public void inputPasien(Pasien pasien){
        String sql = "INSERT INTO pasien values" + "(" + pasien.getRm()+ "," + pasien.getNama() + "," + pasien.getUsia() + "," + pasien.getAlamat() + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Data pasien berhasil disimpan!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

//
    public static void getPasienSembuh(){
        String sql = "SELECT rm FROM jadwal WHERE status = 1";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement S = conn.createStatement()) {
             ResultSet rs = null;
             rs = S.executeQuery(sql);
             while(rs.next()){
                 System.out.println(rs.getInt("rm"));
             }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
//
//    public void updateStatusPasien(){
//
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DAO data = new DAO();
//        data.createNewDatabase();
        data.connect();
//        data.createNewTable();
//        data.showAllTables();
    }

}
