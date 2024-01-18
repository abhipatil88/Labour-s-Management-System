package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Worker;

public class WorkerDao {
	private Connection conn;

	public WorkerDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean registerWorker(Worker w)
	{
		boolean f = false;
		try {
			String sql = "insert into worker (full_name , dob , qualification, specialist , email , mobno , password) values (?,?, ?, ?, ?, ? ,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,w.getFullName());
			ps.setString(2,w.getDob());
			ps.setString(3,w.getQualification());
			ps.setString(4,w.getSpecialist());
			ps.setString(5,w.getEmail());
			ps.setString(6,w.getMobno());
			ps.setString(7,w.getPassword());
			
			int i=ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<Worker> getAllWorker()
	{
		List<Worker> list = new ArrayList<Worker>();
		Worker w = null;
		try {
			String sql = "select * from worker order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				w=new Worker();
				w.setId(rs.getInt(1));
				w.setFullName(rs.getString(2));
				w.setDob(rs.getString(3));
				w.setQualification(rs.getString(4));
				w.setSpecialist(rs.getString(5));
				w.setEmail(rs.getString(6));
				w.setMobno(rs.getString(7));
				w.setPassword(rs.getString(8));
				list.add(w);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		{
			
		
	}

		}
		return list;
	}

	public Worker getWorkerById(int id)
	{
		List<Worker> list = new ArrayList<Worker>();
		Worker w = null;
		try {
			String sql = "select * from worker where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				w=new Worker();
				w.setId(rs.getInt(1));
				w.setFullName(rs.getString(2));
				w.setDob(rs.getString(3));
				w.setQualification(rs.getString(4));
				w.setSpecialist(rs.getString(5));
				w.setEmail(rs.getString(6));
				w.setMobno(rs.getString(7));
				w.setPassword(rs.getString(8));
				list.add(w);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		{
			
		
	}

		}
		return w;
	}


public boolean updateWorker(Worker w)
{
	boolean f = false;
	try {
		String sql = "update worker set  full_name=? , dob=? , qualification=?, specialist=? , email=? , mobno=? , password=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,w.getFullName());
		ps.setString(2,w.getDob());
		ps.setString(3,w.getQualification());
		ps.setString(4,w.getSpecialist());
		ps.setString(5,w.getEmail());
		ps.setString(6,w.getMobno());
		ps.setString(7,w.getPassword());
		ps.setInt(8,w.getId());
		int i=ps.executeUpdate();
		if(i == 1)
		{
			f = true;
		}
		
		} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}

public boolean deleteWorker(int id) {
	
	boolean f = false;
	try {
		String sql = "delete from worker where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		if(i == 1) {
			f = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return f;
	
}

public Worker login(String email,String psw)
{
	Worker w = null;
	try {
		String sql = "SELECT * FROM worker WHERE email = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, psw);
		
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			w=new Worker();
			w.setId(rs.getInt(1));
			w.setFullName(rs.getString(2));
			w.setDob(rs.getString(3));
			w.setQualification(rs.getString(4));
			w.setSpecialist(rs.getString(5));
			w.setEmail(rs.getString(6));
			w.setMobno(rs.getString(7));
			w.setPassword(rs.getString(8));
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return w;
}

public int countWorker()
{
	int i = 0;
	try {
		String sql="select * from worker";
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public int countAppointment()
{
	int i = 0;
	try {
		String sql="select * from appointment";
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public int countAppointmentByWorkerId(int wid)
{
	int i = 0;
	try {
		String sql="select * from appointment where worker_id=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1, wid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}
public int countUser()
{
	int i = 0;
	try {
		String sql="select * from user_details";
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public int countSpecialist()
{
	int i = 0;
	try {
		String sql="select * from specialist";
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

}

