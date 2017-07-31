package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neu.util.DBManager;


public class Test_new {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String sql="insert into user_info(user_id,user_name,user_pwd)"
//				+ " values(seq_user_id.nextval,?,?)";
//		save(sql,"ÐÞ´ºÓÂ","666666");
		//delete();
		String sql="delete from user_info "
				+ "where user_id=22";
		save(sql);
	}
	public static void save(String sql,Object...args){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rst=null;
		try {
			conn=DBManager.getConnection();
			
			stmt=conn.prepareStatement(sql);
			if(args!=null){
				for(int i=0;i<args.length;i++){
					stmt.setObject(i+1, args[i]);
				}
			}
			int i=stmt.executeUpdate();
			if(i>0){
				System.out.println("³É¹¦");
			}else{
				System.out.println("Ê§°Ü");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rst);
		}
	}
	
	public static void delete(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rst=null;
		try {
			conn=DBManager.getConnection();
			String sql="delete from user_info "
					+ "where user_id=?";
			stmt=conn.prepareStatement(sql);
			stmt.setObject(1, 21);
			int i=stmt.executeUpdate();
			if(i>0){
				System.out.println("³É¹¦");
			}else{
				System.out.println("Ê§°Ü");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rst);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
