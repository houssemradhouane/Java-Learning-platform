/**
 * 
 * @author Salahdine Ouhmmiali v 1.0
 *
 */
public class Qcm implements Question {
	String question,
	       option1,
	       option2,
	       option3,
	       option4,
	       reponse_correcte;
	 Qcm(String question , String op1 , String op2 ,String op3, String op4 , String reponse_correcte) {
	        this.question = question ;
	        this.option1 = op1;
	        this.option2= op2;
	        this.option3 = op3 ;
	        this.option4 = op4 ;
	        this.reponse_correcte = reponse_correcte ;
	    }
	public String getQuestion() {
		return question;
	};
	public String getReponse() {
		return reponse_correcte;
	}

	

}
