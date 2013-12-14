package buy4me

class Answer implements java.io.Serializable {

    String answer
    static constraints = {
        answer(size:1..256, blank:false, nullable:false, unique:false)

    }
}