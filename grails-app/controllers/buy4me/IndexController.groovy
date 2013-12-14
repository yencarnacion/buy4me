package buy4me

class IndexController {

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NeedItem.list(params), model: [needItemInstanceCount: NeedItem.count()]
    }
    }
