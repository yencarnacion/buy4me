package buy4me



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class NeedItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NeedItem.list(params), model: [needItemInstanceCount: NeedItem.count()]
    }

    def show(NeedItem needItemInstance) {
        respond needItemInstance
    }

    def create() {
        respond new NeedItem(params)
    }

    @Transactional
    def save(NeedItem needItemInstance) {
        if (needItemInstance == null) {
            notFound()
            return
        }

        if (needItemInstance.hasErrors()) {
            respond needItemInstance.errors, view: 'create'
            return
        }

        needItemInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'needItemInstance.label', default: 'NeedItem'), needItemInstance.id])
                redirect needItemInstance
            }
            '*' { respond needItemInstance, [status: CREATED] }
        }
    }

    def edit(NeedItem needItemInstance) {
        respond needItemInstance
    }

    @Transactional
    def update(NeedItem needItemInstance) {
        if (needItemInstance == null) {
            notFound()
            return
        }

        if (needItemInstance.hasErrors()) {
            respond needItemInstance.errors, view: 'edit'
            return
        }

        needItemInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'NeedItem.label', default: 'NeedItem'), needItemInstance.id])
                redirect needItemInstance
            }
            '*' { respond needItemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(NeedItem needItemInstance) {

        if (needItemInstance == null) {
            notFound()
            return
        }

        needItemInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'NeedItem.label', default: 'NeedItem'), needItemInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'needItemInstance.label', default: 'NeedItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
