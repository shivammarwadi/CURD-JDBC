package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.utility.DBUtility;

public class BookDao 
{
	
	public static int addBook(Book b) throws ClassNotFoundException, SQLException 
	{
		Connection con = DBUtility.getDBConnection();
		PreparedStatement ps = con.prepareStatement("insert into book_info value(?,?,?)");
		ps.setInt(1, b.getId());
		ps.setString(2, b.getBokName());
		ps.setDouble(3, b.getBokPrice());
		return ps.executeUpdate();
	}
	
	
	public static List<Book> DisplayBook() throws ClassNotFoundException, SQLException
	{
		List<Book> ls=new ArrayList<Book>();
		Connection con=DBUtility.getDBConnection();
		PreparedStatement ps=con.prepareStatement("Select * from book_info");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Book b=new Book();
			b.setId(rs.getInt(1));
			b.setBokName(rs.getString(2));
			b.setBokPrice(rs.getDouble(3));
			ls.add(b);
		}
		return ls;
	}
	
	public static int updateBook(Book b) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtility.getDBConnection();
		PreparedStatement ps=con.prepareStatement("update book_info set bkName=?,bkPrice=? where id=?");
		ps.setString(1,b.getBokName());
		ps.setDouble(2,b.getBokPrice());
		ps.setInt(3,b.getId());
			return ps.executeUpdate();
	}

	
	public static Book getBookById(int id) throws SQLException, ClassNotFoundException
	{
		Connection con=DBUtility.getDBConnection();
		PreparedStatement ps=con.prepareStatement("select * from book_info where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			Book b=new Book();
			while(rs.next())
			{
				b.setId(rs.getInt(1));
				b.setBokName(rs.getString(2));
				b.setBokPrice(rs.getDouble(3));
			}
			return b;
	}
	public static int deleteBook(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtility.getDBConnection();
		PreparedStatement ps=con.prepareStatement("delete from book_info where id=?");
			ps.setInt(1,id);
			return ps.executeUpdate();
	}

}

