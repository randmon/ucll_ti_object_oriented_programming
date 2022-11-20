package RekenenTest.domain;

public record Question(String question, String answer, String topic) {

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Question q) {
            return question.equals(q.question) && answer.equals(q.answer) && topic.equals(q.topic);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n\t\tAnswer: " + answer + "\n\t\tTopic: " + topic;
    }

    public boolean isCorrectAnswer(String answer) {
        if (answer == null) throw new IllegalArgumentException("Answer is null");
        return this.answer.equals(answer);
    }
}
