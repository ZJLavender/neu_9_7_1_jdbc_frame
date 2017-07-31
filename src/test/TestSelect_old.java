package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import com.neu.util.DBManager;

public class TestSelect_old {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkLogin("zhangsan","123456");
		
		String sql="select count(empno) c,"
				+ "max(sal)  m,min(sal) mi from emp";
//		String[] colNames={"ename"};
//		findBySql(sql, colNames);
		List<HashMap<String , String>> list=
				findBySQL(sql);
		System.out.println(list);
	}

	public static List<HashMap<String, String>> findBySql(String sql,String[] colNames,
			Object...params){
//		<>表示 泛型 
//		保存所有行中的数据
		List<HashMap<String, String>> list=
				new ArrayList<HashMap<String,String>>();
//		保存每一行中的每一列数据
		HashMap<String, String> item=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rst=null;
		try {
			conn=DBManager.getConnection();
			stmt=conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			rst=stmt.executeQuery();
			while(rst.next()){
				item=new HashMap<String, String>();
				for(int i=0;i<colNames.length;i++){
					String value=rst.getString(colNames[i]);
					item.put(colNames[i].toLowerCase(), value);
				}
				list.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rst);
		}
		return list;
	}
	
	//不需要提供列名，只需要sql语句和参数即可
	public static List<HashMap<String, String>> findBySQL(String sql,
			Object...params){
//		<>表示 泛型 
//		保存所有行中的数据
		List<HashMap<String, String>> list=
				new ArrayList<HashMap<String,String>>();
//		保存每一行中的每一列数据
		HashMap<String, String> item=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rst=null;
		try {
			conn=DBManager.getConnection();
			stmt=conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			rst=stmt.executeQuery();
			//可以获取查询的列数目
			ResultSetMetaData meta=rst.getMetaData();
			int count=meta.getColumnCount();
			String[] colNames=new String[count];
			for(int i=0;i<count;i++){
				colNames[i]=meta.getColumnName(i+1);
			}
			//System.out.println(Arrays.toString(colNames));
			while(rst.next()){
				item=new HashMap<String, String>();
				for(int i=0;i<count;i++){
					String value=rst.getString(colNames[i]);
					item.put(colNames[i].toLowerCase(), value);
				}
				list.add(item);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rst);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
