package RekenenTest.db;

import RekenenTest.domain.Question;

import java.util.*;

public class QuestionDB {
		
	private final List<Question> questions;
	
	public QuestionDB() {
		Question[] o ={
			new Question("3+2=","5","optellen"),
			new Question("3+12=","15","optellen"),
			new Question("13+12=","25","optellen"),
			new Question("13-2=","11","aftrekken"),
			new Question("1-2=","-1","aftrekken"),
			new Question("13-13=","0","aftrekken"),
			new Question("1*2=","2","vermenigvuldigen"),
			new Question("11*2=","22","vermenigvuldigen"),
			new Question("10*20=","200","vermenigvuldigen"),
			new Question("20/10=","2","delen")
		};
	
		questions = new ArrayList<>(Arrays.asList(o));
	}
		
	public List<Question> getQuestions() {
		return questions;
	}
				
	public Question getRandomQuestion(){
		Random random = new Random();
		int index = random.nextInt(questions.size());
		return questions.get(index);
	}
}
