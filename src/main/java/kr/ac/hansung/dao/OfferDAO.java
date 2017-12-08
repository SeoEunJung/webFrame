package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount(){
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	
	public Offer getOffer(int year){
		String sqlStatement = "select * from offers where year=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[]{year}, 
				new RowMapper<Offer>(){
					
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Offer offer = new Offer();
						offer.setYear(rs.getInt("year"));
						offer.setSemester(rs.getInt("semester"));
						offer.setCode(rs.getString("code"));
						offer.setClassname(rs.getString("classname"));
						offer.setDivision(rs.getString("division"));
						offer.setGrade(rs.getInt("grade"));
						
						return offer;
					}
			
		});
	}
	//multiple
	public List<Offer> getOffers(){
		String sqlStatement = "select * from offers";
		
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Offer>(){
					
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Offer offer = new Offer();
						offer.setYear(rs.getInt("year"));
						offer.setSemester(rs.getInt("semester"));
						offer.setCode(rs.getString("code"));
						offer.setClassname(rs.getString("classname"));
						offer.setDivision(rs.getString("division"));
						offer.setGrade(rs.getInt("grade"));
						
						return offer;
					}
			
		});
	}
	
	public boolean insert(Offer offer){
		int year =offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String classname = offer.getClassname();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		
		String sqlStatement = "insert into offers(year, semester, code, classname, division, grade) values (?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester,code, classname, division, grade}) ==1);
	}
	
	public boolean update(Offer offer){
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String classname = offer.getClassname();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		
		String sqlStatement = "update offers set year=?, semester=?, code=?, classname=?, division=?, grade=? ";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester,code,classname, division, grade}) ==1);
	}
	
	public boolean delete(){
		String sqlStatement = "delete from offers";
		return (jdbcTemplate.update(sqlStatement, new Object[] {}) ==1);
	}
}

