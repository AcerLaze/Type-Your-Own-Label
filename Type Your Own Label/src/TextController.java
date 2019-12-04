
public class TextController {

	private String text;
	
	public TextController() {
		
		text = "Type your label [Backspace to delete]";
		
	}
	
	public void addText(char c) {
		
		text += c;
		
	}
	
	public String getText() {
		
		return text;
		
	}
	
	public void emptyText() {
		
		text = "";
		
		
	}
	
	
}
