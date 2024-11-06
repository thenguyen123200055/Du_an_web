/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;
import model.Hoa;

/**
 *
 * @author ADMIN
 */
public class AccountDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public Account KtraTTTKhoan (String tendangnhap,String matkhau){
        Account kq=null;
        String sql = "select * from TaiKhoan where tendangnhap=? and matkhau=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tendangnhap);
            ps.setString(2, matkhau);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq=new Account(rs.getString(1),rs.getString(2));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return kq;
    }
    
    
    public boolean Update(Account acc){
         String sql = "update TaiKhoan set matkhau=? where tendangnhap=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getMatkhau());
            ps.setString(2, acc.getTendangnhap());
            
            int kq=ps.executeUpdate();
            if(kq>0){
                return true;
            }
          
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        
         return false;
    }
    
    public static void main(String[] args) {
        AccountDAO tkDAO = new AccountDAO();
        Account Acc = tkDAO.KtraTTTKhoan("shopbanhoa", "hoadep");
        if(Acc!=null){
            System.out.println("Thanh cong");
        }
        else {
            System.out.println("That bai");
        }
    }
}


