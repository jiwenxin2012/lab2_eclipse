import java.sql.*;
import java.util.*;
public class DBConnector {
	public Connection cnt;
	public DBConnector(String url, String user, String pwd) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cnt=DriverManager.getConnection(url, user, pwd);
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	public ArrayList<Book> OnSearchForAuthor(String author_name) {
		String query = "select AuthorID, Name from Author where Name like\"%"+author_name+"%\";";
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			Statement state = cnt.createStatement();
			ResultSet rs = state.executeQuery(query);
			query = "select Title, ISBN from Book where AuthorID=";
			while(rs.next()) 
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				Statement statecopy = cnt.createStatement();
				ResultSet bookset = statecopy.executeQuery(query+id+";");
				
				while(bookset.next()) 
				{
					Book book = new Book();
					book.isbn = bookset.getString(2);
					book.author = new Author();
					book.title = bookset.getString(1);
					book.author.authorID = id;
					book.author.name = name;
					list.add(book);
				}
				statecopy.close();
			}
			state.close();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}
	public Book OnSearchForBook(String ISBN) {
		Book book = null;
		try{
			Statement state = cnt.createStatement();
			ResultSet bookrst = state.executeQuery("select * from Book where ISBN=\""+ISBN+"\";");
			if(bookrst.next()) {
				book = new Book();
				book.isbn = bookrst.getString(1);
				book.title = bookrst.getString(2);
				book.publisher = bookrst.getString(4);
				book.publish_date = bookrst.getString(5);
				book.price = bookrst.getString(6);
				ResultSet authorrst = state.executeQuery("select * from Author where AuthorID="+bookrst.getString(3)+";");
				if(authorrst.next()) 
				{
					book.author = new Author();
					book.author.authorID = authorrst.getString(1);
					book.author.name = authorrst.getString(2);
					book.author.age = authorrst.getString(3);
					book.author.country = authorrst.getString(4);
				}
			}
			state.close();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		return book;
	}
	public void OnDeleteBook(String ISBN) 
	{
		try{
			Statement state = cnt.createStatement();
			state.executeUpdate("delete from Book where ISBN=\""+ISBN+"\";");
			state.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	public void close() {
		try{cnt.close();}
		catch(Exception e) {}
	}
}
