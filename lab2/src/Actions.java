import java.util.*;
public class Actions
{
	//private static DBConnector DBC = new DBConnector("jdbc:mysql://localhost:3306/book_db", "root", "983652");//local
	private static String isbn = new String("");
	private static Book book_info=new Book();
	private static String author_name=new String("");//null
	private static List<Book> books = new ArrayList<Book>();
	public String getIsbn() 
	{
		return isbn;
	}
	public void setIsbn(String isbn) 
	{
		Actions.isbn = isbn;
	}
	public Book getBook_info() 
	{
		return book_info;
	}
	public void setBook_info(Book book_info) 
	{
		Actions.book_info = book_info;
	}
	public String getAuthor_name() 
	{
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		Actions.author_name = author_name;
	}
	public List<Book> getBooks() 
	{
		return books;
	}
	public void setBooks(List<Book> books) {
		Actions.books = books;
	}
	public String findAuthorInfo() 
	{
		//private static DBConnector DBC = new DBConnector("jdbc:mysql://localhost:3306/book_db", "root", "983652");//local
		DBConnector DBC = new DBConnector("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_bookjwx", "y3wn2yw451", "0kk3hzmz1w0yhxmy0k33i4llz531xj45w410mh1l");//Saas
		ArrayList<Book> list = DBC.OnSearchForAuthor(author_name);
		books.clear();//clear information
		for(int i=0; i<list.size();i++) books.add(list.get(i));
		DBC.close();//close
		return "booklist";
	}
	public String deleteABook() 
	{
		DBConnector DBC = new DBConnector("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_bookjwx", "y3wn2yw451", "0kk3hzmz1w0yhxmy0k33i4llz531xj45w410mh1l");
		DBC.OnDeleteBook(isbn);
		DBC.close();
		return "SearchAuthor";
	}
	public String findBookInfo() 
	{
		DBConnector DBC = new DBConnector("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_bookjwx", "y3wn2yw451", "0kk3hzmz1w0yhxmy0k33i4llz531xj45w410mh1l");
		book_info = DBC.OnSearchForBook(isbn);
		DBC.close();
		return "bookinfo";
	}
	public String returnTo() 
	{
		return "SearchAuthor";//Reback to last page
	}
}
