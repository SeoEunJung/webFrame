package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.NewOffer;

@Repository
public class NewOfferDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount(){
		String sqlStatement = "select count(*) from newoffers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	
	public NewOffer getNewOffer(int year){
		String sqlStatement = "select * from newoffers where year=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[]{year}, 
				new RowMapper<NewOffer>(){
					
					public NewOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
						NewOffer newoffer = new NewOffer();
						newoffer.setYear(rs.getInt("year"));
						newoffer.setSemester(rs.getInt("semester"));
						newoffer.setClassname(rs.getString("classname"));
						
						return newoffer;
					}
			
		});
	}
	//multiple
	public List<NewOffer> getNewOffers(){
		String sqlStatement = "select * from newoffers";
		
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<NewOffer>(){
					
					public NewOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
						NewOffer newoffer = new NewOffer();
						newoffer.setYear(rs.getInt("year"));
						newoffer.setSemester(rs.getInt("semester"));
						newoffer.setClassname(rs.getString("classname"));
		
						return newoffer;
					}
			
		});
	}
	
	public boolean insert(NewOffer newoffer){
		int year =newoffer.getYear();
		int semester = newoffer.getSemester();
		String classname = newoffer.getClassname();
		
		String sqlStatement = "insert into newoffers(year, semester, classname) values (?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, classname}) ==1);
	}
	
	public boolean update(NewOffer newoffer){
		int year = newoffer.getYear();
		int semester = newoffer.getSemester();
		String classname = newoffer.getClassname();
	
		String sqlStatement = "update newoffers set year=?, semester=?,classname=? ";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester,classname}) ==1);
	}
	
	public boolean delete(){
		String sqlStatement = "delete from newoffers";
		return (jdbcTemplate.update(sqlStatement, new Object[] {}) ==1);
	}
}
