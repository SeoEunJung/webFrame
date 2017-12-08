package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer2;

@Repository
public class Offer2DAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount(){
		String sqlStatement = "select count(*) from offers2";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	
	public Offer2 getOffer2(int necessary){
		String sqlStatement = "select * from offers2 where necessary=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[]{necessary}, 
				new RowMapper<Offer2>(){
					
					public Offer2 mapRow(ResultSet rs, int rowNum) throws SQLException {
						Offer2 offer2 = new Offer2();
						offer2.setNecessary(rs.getInt("necessary"));
						offer2.setMainpointA(rs.getInt("mainpointA"));
						offer2.setMainpointB(rs.getInt("mainpointB"));
						offer2.setMajor_appointed(rs.getInt("major_appointed"));
						offer2.setMajor_foundation(rs.getInt("major_foundation"));
						offer2.setMajor_select(rs.getInt("major_select"));
						offer2.setTotal_grade(rs.getInt("total_grade"));
						
						return offer2;
					}
			
		});
	}
	//multiple
	public List<Offer2> getOffers2(){
		String sqlStatement = "select * from offers2";
		
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Offer2>(){
					
					public Offer2 mapRow(ResultSet rs, int rowNum) throws SQLException {
						Offer2 offer2 = new Offer2();
						offer2.setNecessary(rs.getInt("necessary"));
						offer2.setMainpointA(rs.getInt("mainpointA"));
						offer2.setMainpointB(rs.getInt("mainpointB"));
						offer2.setMajor_appointed(rs.getInt("major_appointed"));
						offer2.setMajor_foundation(rs.getInt("major_foundation"));
						offer2.setMajor_select(rs.getInt("major_select"));
						offer2.setTotal_grade(rs.getInt("total_grade"));
						
						return offer2;
					}
			
		});
	}
	
	public boolean insert(Offer2 offer2){
		int necessary =offer2.getNecessary();
		int mainpointA = offer2.getMainpointA();
		int mainpointB = offer2.getMainpointB();
		int major_appointed = offer2.getMajor_appointed();
		int major_foundation = offer2.getMajor_foundation();
		int major_select = offer2.getMajor_select();
		int total_grade = offer2.getTotal_grade();
		
		String sqlStatement = "insert into offers2(necessary, mainpointA, mainpointB, major_appointed,major_foundation,major_select,total_grade) values (?,?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {necessary, mainpointA, mainpointB, major_appointed,major_foundation,major_select,total_grade}) ==1);
	}
	
	public boolean update(Offer2 offer2){
		int necessary =offer2.getNecessary();
		int mainpointA = offer2.getMainpointA();
		int mainpointB = offer2.getMainpointB();
		int major_appointed = offer2.getMajor_appointed();
		int major_foundation = offer2.getMajor_foundation();
		int major_select = offer2.getMajor_select();
		int total_grade = offer2.getTotal_grade();
		
		String sqlStatement = "update offers2 set necessary=?, mainpointA=?, mainpointB=?, major_appointed=?, major_foundation=?, major_select=?, total_grade=? ";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {necessary, mainpointA, mainpointB, major_appointed,major_foundation,major_select,total_grade}) ==1);
	}
	
	public boolean delete(){
		String sqlStatement = "delete from offers2";
		return (jdbcTemplate.update(sqlStatement, new Object[] {}) ==1);
	}
}
