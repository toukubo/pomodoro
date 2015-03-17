package com.toukubo.pomodoro;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.toukubo.sqlite.BasicEntity;

@Entity
//@NamedQueries({
//	@NamedQuery(name = Pomodoro.FIND_ALL, query = "SELECT p FROM Pomodoro p")
//})
public class Pomodoro extends BasicEntity{
	
	
	@Transient 
	private String sqlitedbid =  "pomodoro";
	
	@Transient 
	@Override
	public String getSqlitedbid(){
		return this.sqlitedbid;
	}


	long startedTime = 0;
	String project = "";

	public Pomodoro(){
		super();
	}
	public long getStartedTime() {
		return startedTime;
	}
	public void setStartedTime(long startedTime) {
		this.startedTime = startedTime;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	@Transient 
	@Override
	public Class getClazz() {
		return Pomodoro.class;
	}
	@Transient 
	@Override
	public String getClassName() {
		return "Pomodoro";
	}
	
	@Transient 
	public static void main(String[] args) {
		
    	Pomodoro pomodoro = new Pomodoro();
    	pomodoro.setProject("hogehoge");
    	pomodoro.setStartedTime(0);
    	pomodoro.setVersion(0L);
    	pomodoro.save();
    	Long id = Long.valueOf("1");
    	Pomodoro found = (Pomodoro)pomodoro.find(id);
    	System.err.println(found.getProject());
	}
}
