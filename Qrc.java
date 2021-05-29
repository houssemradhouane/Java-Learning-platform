
public class Qrc implements Question {
	String question,
	reponse,
	theme;
	Qrc(String question, String reponse, String theme){
		this.question = question;
		this.reponse = reponse;
		this.theme = theme;
	}
	public String getQuestion() {
		return question;
	};
	public String getReponse() {
		return reponse;
	}
	public String getTheme() {
		return theme;
	}

}
