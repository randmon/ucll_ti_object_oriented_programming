package RekenenTest.ui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import RekenenTest.domain.ParticipantGroup;
import RekenenTest.domain.Quiz;
import RekenenTest.domain.Test;

public class QuizTestApp {

	public static void main(String[] args) {
		// Make a quiz with n random questions from the database
		String nQuestions = JOptionPane.showInputDialog(null,
				"Amount of questions in the quiz",
				"New Quiz",
				JOptionPane.QUESTION_MESSAGE);
		Quiz quiz = new Quiz(Integer.parseInt(nQuestions));

		// Show the quiz
		JOptionPane.showMessageDialog(null, quiz, "This is the quiz:", JOptionPane.INFORMATION_MESSAGE);

		// Input the name of the participants
		String deelnemers = JOptionPane.showInputDialog(null,
				"Type the name of the participants, separated by a comma (,)",
				"Participant group",
				JOptionPane.QUESTION_MESSAGE);
		List <String> participants =  Arrays.asList(deelnemers.split(","));

		// Make a group
		ParticipantGroup group = new ParticipantGroup(participants);

		// Make a test
		Test test = new Test(group, quiz);

		// Show the test
		while (!test.isFinished()){
			String currentQuestion = test.getNextQuestion();

			for (int i = 0; i < test.countParticipants(); i++) {
				String currentParticipant = test.getCurrentParticipant();
				String answer = JOptionPane.showInputDialog(null,
						currentQuestion,
						"Type answer for participant " + currentParticipant,
						JOptionPane.QUESTION_MESSAGE);
				test.play(answer);
			}
		}

		// Show the results
		JOptionPane.showMessageDialog(null,
				test.getParticipantAnswers(),
				"Answer overview per participant",
				JOptionPane.INFORMATION_MESSAGE);

		// Show the winners
		JOptionPane.showMessageDialog(null,
				test.getWinners(),
				"Winners:",
				JOptionPane.INFORMATION_MESSAGE);

		// The total score per participant is shown, ordered from the participant with the highest score to the participant with the lowest score
		JOptionPane.showMessageDialog(null,
				group.overviewPoints(),
				"Overview of total points per participant",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
