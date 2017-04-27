package com.wipro.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.util.DBUtil;

public class ScheduleDAO {
	public String createSchedule(ScheduleBean scheduleBean) throws SQLException
	{
		Connection conn=DBUtil.getDBConnection();
		PreparedStatement p=conn.prepareStatement("insert into schedule_tb values(?,?,?,?,?)");
	    p.setString(1,scheduleBean.getScheduleId());
	    p.setString(2,scheduleBean.getSource());
	    p.setString(3,scheduleBean.getDestination());
	    p.setString(4,scheduleBean.getStartTime());
	    p.setString(5,scheduleBean.getArrivalTime());
	    p.executeUpdate();
		return  "SUCCESS";
	}
	public String generateID(String source, String destination) throws SQLException
	{
		String str="";
		Connection conn=DBUtil.getDBConnection();
		Statement s=conn.createStatement();
		ResultSet rs=s.executeQuery("select schedule_seq from dual"); 
		if(rs.next())
		{
			int a=rs.getInt(1);
			String s1=source.substring(0,2);
			String s2=destination.substring(0,2);
			str=str+s1.toUpperCase()+s2.toUpperCase()+a;
		}
		return str;
	}
	public  ArrayList<ScheduleBean> viewSchedule(String source,String destination) throws SQLException
	{
		ArrayList<ScheduleBean> list=new ArrayList<ScheduleBean>();
		Connection conn=DBUtil.getDBConnection();
		Statement s=conn.createStatement();
		ScheduleBean sb=new ScheduleBean();
		ResultSet rs=s.executeQuery("select * from schedule_tb where source='"+source+"' and destination='"+destination+"'"); 
		while(rs.next())
		{
			sb.setScheduleId(rs.getString(1));
			sb.setSource(rs.getString(2));
			sb.setDestination(rs.getString(3));
			sb.setStartTime(rs.getString(4));
			sb.setArrivalTime(rs.getString(5));
			list.add(sb);
		}
		list.add(sb);
		return list;
	}
}
