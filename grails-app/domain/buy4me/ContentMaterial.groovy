package buy4me

class ContentMaterial implements java.io.Serializable {

    String content
    static hasMany = [questionsAndAnswers: QuestionAndAnswer]

    static constraints = {
        content(size:1..1000000000, blank:true, nullable:false, unique:false)

    }

}