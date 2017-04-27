package com.wipro.bus.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;
import com.wipro.bus.util.InvalidInputException;

public class Administrator {
	public String addSchedule(ScheduleBean scheduleBean) throws SQLException
	{
		if(scheduleBean.getSource().equals(scheduleBean.getDestination()))
			return "Source and Destination Same";
		if(scheduleBean==null||scheduleBean.getSource()==""||scheduleBean.getDestination()==""||scheduleBean.getSource().length()<2||scheduleBean.getDestination().length()<2)
		{
			try
			{
				throw new InvalidInputException();
			}
			catch(InvalidInputException wde)
			{
				wde.printStackTrace();;
			}
		}
		else
		{
			ScheduleDAO sd=new ScheduleDAO();
			if(sd.generateID(scheduleBean.getSource(),scheduleBean.getDestination())!="")
			{
				return scheduleBean.getScheduleId();
			}
			String str1=sd.createSchedule(scheduleBean);
			return str1;
		}
		return "success";
		
	}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination)
	{
		ScheduleDAO sd=new ScheduleDAO();
		if(source==""&&destination=="")
			return null;
		return null;
	}
}
