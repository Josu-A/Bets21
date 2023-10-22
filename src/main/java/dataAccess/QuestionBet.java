package dataAccess;

public class QuestionBet {
	private String question;

	private float betMinimum;
	
	public QuestionBet(String question, float betMinimum) {
		this.question = question;
		this.betMinimum = betMinimum;
	}
	
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public float getBetMinimum() {
		return this.betMinimum;
	}

	public void setBetMinimum(float betMinimum) {
		this.betMinimum = betMinimum;
	}
}
