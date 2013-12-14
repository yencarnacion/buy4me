import buy4me.Answer
import buy4me.ContentMaterial
import buy4me.QuestionAndAnswer
import buy4me.auth.B4mUser
import buy4me.auth.User
import buy4me.auth.Role
import buy4me.auth.UserRole

class BootStrap {

    def init = { servletContext ->

        switch (grails.util.Environment.current.name){
            case "development":

                def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
                def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)
                def b4mRole = Role.findByAuthority("ROLE_B4M") ?: new Role(authority: "ROLE_B4M").save(flush: true)

                def admin = User.get(1);
                if(!admin){
                    admin = new User(
                            id: 1,
                            username: "admin",
                            password: "password",
                            enabled: true,
                    ).save(flush: true, failOnError: true)
                    UserRole.create admin, adminRole
                }

                def b4mUser = B4mUser.get(1);
                if(!b4mUser){
                    b4mUser = new B4mUser(
                            username: "b4muser",
                            password: "password",
                            enabled: true,
                    ).save(flush: true, failOnError: true)
                    UserRole.create b4mUser, b4mRole
                }

                def answer0 = Answer.get(1)
                if(!answer0){
                    def answer01 = new Answer(answer: "He was the first President of the United States of America").save(flush: true, failOnError: true)
                    def answer02 = new Answer(answer: "He was a General").save(flush: true, failOnError: true)
                    def possibleAnswer01 = new Answer(answer: "He was a Lawyer").save(flush: true, failOnError: true)
                    String georgeWashington = """
George Washington (February 22, 1732 [O.S. February 11, 1731][Note 1][Note 2] – December 14, 1799) was one of the Founding Fathers of the United States, serving as the commander-in-chief of the Continental Army during the American Revolutionary War. He also presided over the convention that drafted the Constitution, which replaced the Articles of Confederation. The Constitution established the position of President of the republic, which Washington was the first to hold.
Washington was elected President as the unanimous choice of the 69 electors in 1788, and he served two terms in office. He oversaw the creation of a strong, well-financed national government that maintained neutrality in the wars raging in Europe, suppressed rebellion, and won acceptance among Americans of all types. His leadership style established many forms and rituals of government that have been used since, such as using a cabinet system and delivering an inaugural address. Further, the peaceful transition from his presidency to the presidency of John Adams established a tradition that continues into the 21st century. Historically, Washington has been widely regarded as the "father of his country".[4]
"""
                    def qANDa01 = new QuestionAndAnswer(question: "Who was George Washington?",
                            possibleAnswers: [answer01,answer02,possibleAnswer01],
                            correctAnswers: [answer01,answer02]).save(flush:true, failOnError:true)

                    def contentMaterial = new ContentMaterial(content: georgeWashington, questionsAndAnswers:[qANDa01]).save(flush: true, failOnError: true)
                }

                break;

            case "test":

                def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
                def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)

                def admin = User.get(1);
                if(!admin){
                    admin = new User(
                            id: 1,
                            username: "admin",
                            password: "password",
                            enabled: true,
                    ).save(flush: true, failOnError: true)
                    UserRole.create admin, adminRole
                }

                break;

            case "production":

                def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)
                def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)

                def admin = User.get(1);
                if(!admin){
                    admin = new User(
                            id: 1,
                            username: "admin",
                            password: "password",
                            enabled: true,
                    ).save(flush: true)
                    UserRole.create admin, adminRole
                }

                break;
        }

    }
    def destroy = {
    }
}
