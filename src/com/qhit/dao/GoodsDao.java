package com.qhit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.beans.Goods;
import com.qhit.util.DBHelper;

public class GoodsDao extends DBHelper {
	
	public List<Goods> queuryAll(){
		List<Goods> list = new ArrayList<Goods>();
		conn=getConn();
		 try {
			ps = conn.prepareStatement("select * from goods");
			 rs = ps.executeQuery();
			 while(rs.next()){
				 Goods  g = new Goods(rs.getInt("id"),rs.getString("name"),rs.getDouble("blance"));
				 list.add(g);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		 return list;
		
	}

	public Goods getGoodsById(int parseInt) {
		 Goods  g = new Goods();
		conn=getConn();
		 try {
			ps = conn.prepareStatement("select * from goods where id = ?");
			ps.setInt(1, parseInt);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 g = new Goods(rs.getInt("id"),rs.getString("name"),rs.getDouble("blance"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		 return g;
		
	}
public static void main(String[] args) {
	System.out.println(String.format(11.998888+"", "%D2"));
}
}
