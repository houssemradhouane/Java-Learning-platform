/**
 * 
 * @author Youssef MINYARI et Othmane MOKRANE
 *
 */
public class RemplirCode {
	
	private String question;
	private Object reponse;
	
	public RemplirCode(String q, Object r) {
		this.question = q;
		this.reponse = r;
	}
	
	public String getQuestion() {
		return this.question;
	}

	public Object getReponse() {
		return this.reponse;
	}
}
