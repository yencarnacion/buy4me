package buy4me

class QuestionAndAnswer implements java.io.Serializable {

    String question

    static hasMany =[possibleAnswers: Answer, correctAnswers: Answer]

    static constraints = {
        question(size:1..256, blank:false, nullable:false, unique:false)

    }
}