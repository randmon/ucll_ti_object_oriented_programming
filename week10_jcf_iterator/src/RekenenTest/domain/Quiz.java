package RekenenTest.domain;

import java.util.LinkedList;
import java.util.List;

import RekenenTest.db.QuestionDB;

public class Quiz {
	
	private final List<Question> questions;
	
	//aanmaken van een quiz met een aantal unieke random geselecteerde opdrachten uit de opdrachtenDatabase
	public Quiz(int aantalOpdrachten){	
		QuestionDB db = new QuestionDB();
		int amountOfQuestions = db.getQuestions().size();
		this.questions = new LinkedList<>();
		int i = 0;
		while (i < Math.min(aantalOpdrachten,amountOfQuestions)){
			Question question = db.getRandomQuestion();
			if (!questions.contains(question)){
				questions.add(question);
				i++;
			}
		}
	}
	
	public Quiz(List<Question> questions) {
		this.questions = questions;
	}

	public List<Question> getQuestions(){
		return questions;
	}
	
	public Question getQuestion(int index) {
		return questions.get(index);
	}

	public int getAmountOfQuestions(){
		return questions.size();
	}	
		
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Question o : questions) {
			result.append(o.toString()).append("\n");
		}
		return result.toString();
	}
}
