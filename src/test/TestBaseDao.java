package test;

import com.neu.dao.BaseDao;

public class TestBaseDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id="2";
		String name="";
		String sql="delete from user_info "
				+ "where user_id=? and user_name=?";
		BaseDao dao=new BaseDao();
		int i=dao.exeuteUpdate(sql,id,name);
		System.out.println(i);
	}
}
