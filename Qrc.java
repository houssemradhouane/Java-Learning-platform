
public class Qrc implements Question {
	String question,
	reponse;
	Qrc(String question, String reponse){
		this.question = question;
		this.reponse = reponse;
	}
	public String getQuestion() {
		return question;
	};
	public String getReponse() {
		return reponse;
	}
}
