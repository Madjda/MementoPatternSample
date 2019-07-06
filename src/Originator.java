
public class Originator {
	private String article ;
	
	public void set(String s)
	{
		article= s ;
		System.out.println("From Originator : Current version or article " + s);
	}

	public Memento storeInMemento()
	{
		System.out.println("From Originator : Saving into Memento");
		return new Memento(article);
	}
	public String restoreFromMemento (Memento m)
	{
		article= m.getSavedArticle() ;
		System.out.println("From Originator : Restoring from Memento");
		return article ;
	}
}
