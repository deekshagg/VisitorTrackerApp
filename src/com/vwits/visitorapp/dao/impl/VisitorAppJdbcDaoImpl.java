package com.vwits.visitorapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.vwits.visitorapp.dao.VisitorAppDao;
import com.vwits.visitorapp.model.Visitor;

public class VisitorAppJdbcDaoImpl implements VisitorAppDao {
	Connection connection;
	public VisitorAppJdbcDaoImpl (){
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:derby:C:\\Users\\diksha\\Documents\\Derby\\visitorappdb");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addVisitor(Visitor visitor) {
		try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tbl_visitorbook VALUES(?, ?, ?, ?, ?, ?)");) {
			int id = visitor.getId();
			String name = visitor.getName();
			String emailid = visitor.getEmailId();
			java.util.Date visitDate = visitor.getVisitDate();
			String purpose = visitor.getPurposeOfVisit();
			String whomtomeet = visitor.getWhomToMeet();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, emailid);
			preparedStatement.setDate(4, new Date(visitDate.getTime()));
			preparedStatement.setString(5, purpose);
			preparedStatement.setString(6, whomtomeet);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Visitor> showAllVisitor() {
		List<Visitor> visitorBook = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_visitorbook");) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Visitor visitor = new Visitor(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getString(5),
						resultSet.getString(6)						
						);
				visitorBook.add(visitor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitorBook;
	}

	@Override
	public Visitor showVisitor(int id) {
		Visitor visitor = null;
		try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_visitorbook WHERE id = ?")) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
				visitor = new Visitor(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getString(5),
						resultSet.getString(6)	
						);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return visitor;

	}

	@Override
	public void updatePurposeOfMeet(int id, String purpose) {
		try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tbl_visitorbook SET purpose = ? WHERE id = ?");) {
			preparedStatement.setString(1, purpose);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteVisitor(int id) {
		try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tbl_visitorbook WHERE id = ?");) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
