package author;

public class Bookbean {
	private int bookId;
	public Bookbean(int bookId, String title, String genre) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.genre = genre;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	private String title;
	private String genre;

}
