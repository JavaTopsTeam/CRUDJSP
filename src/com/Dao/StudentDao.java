package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.StudentBean;
import com.Util.StudentUtil;


public class StudentDao {

	public static void doinsert(StudentBean s) {
		
		try {
			Connection conn = StudentUtil.createConnection();
			String sql = "insert into student1(fname,lname,email,contact)values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getContact());
			pst.executeUpdate();
			System.out.println("Data Inserted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static List<StudentBean> getAllStudent(){
		
		System.out.println("Show method Called");
		List<StudentBean> list = new ArrayList<>();
		
		try {
			Connection conn = StudentUtil.createConnection();
			String sql = "select * from student1";
			PreparedStatement pst =  conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				StudentBean s = new StudentBean();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));
				s.setContact(rs.getString("contact"));
				list.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public static StudentBean getStudentById(int id) {
		
		StudentBean s = null;
		try {
			Connection conn =  StudentUtil.createConnection();
			String sql = "select * from student1 where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				s = new StudentBean();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));
				s.setContact(rs.getString("contact"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}
	
	public static void updateStudent(StudentBean s) {
		
		try {
			Connection conn = StudentUtil.createConnection();
			String sql = "update student1 set fname=?,lname=?,email=?,contact=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getContact());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			
			System.out.println("Update done Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	public static void deleteStudent(int id) {
		try {
			Connection conn = StudentUtil.createConnection();
			String sql = "delete from student1 where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
			System.out.println("Delete successfully");
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
}
