package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specialist;

public class specialistDao {
	
	private Connection  conn;

	public specialistDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addspecialist(String spec)
	{
		boolean f=false;
		try {
			String sql="insert into specialist(spec_namel) values(?)";
			PreparedStatement pS=conn.prepareStatement(sql);
			pS.setString(1, spec);
			
			int i=pS.executeUpdate();
			if(i == 1) {
				f = true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<Specialist> getAllSpecialists()
	{
		List<Specialist> list=new ArrayList<Specialist>();
		Specialist s =null;
		
		try {
			String sql="select * from specialist";
			PreparedStatement pStatement=conn.prepareStatement(sql);
			
			ResultSet rs=pStatement.executeQuery();
			
			while(rs.next()) {
				s = new Specialist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		}
}
