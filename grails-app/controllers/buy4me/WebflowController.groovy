package buy4me

class WebflowController {

    def index() {
        redirect(action: 'webflow', params: params)
    }

    def webflowFlow = {

        decideCreateOrEdit {
            action {
                if(params.id){
                    flow.contentMaterialList = new ArrayList<ContentMaterial>()
                    flow.contentMaterialList << ContentMaterial.get(params.id)
                } else {
                    flow.contentMaterialList = new ArrayList<ContentMaterial>()
                    def cm = new ContentMaterial()
                    cm.content = "seedData"
                    flow.contentMaterialList << cm
                }
                [contentMaterialInstance: flow.contentMaterialList[0] ]
            }
            on("success").to "enterContent01"
            on(Exception).to "handleError"
        }

        enterContent01{
            on("back") {
                if (!flow.contentMaterialList[0].content) return error()
                [contentMaterialInstance: flow.contentMaterialList[0] ]
            }.to "enterContent01"
            on("next") {
                //log.debug("params:"+ params)
                flow.contentMaterialList.get(0).content = params.contentMaterialInstance.content
                if (!flow.contentMaterialList[0].content) return error()
            }.to "prepareContent02"
        }

        prepareContent02 {
            action{
                def cm = new ContentMaterial()
                cm.content = "seedData"
                if(flow.contentMaterialList[1]){
                    //flow.contentMaterialList.get(1).content = cm.content
                } else {
                    flow.contentMaterialList << cm
                }
                [contentMaterialInstance: flow.contentMaterialList[1] ]
            }
            on("success").to "enterContent02"
            on(Exception).to "handleError"
        }

        enterContent02{
            on("back") {
                if (!flow.contentMaterialList.get(1).content) return error()
                [contentMaterialInstance: flow.contentMaterialList[0] ]
            }.to "enterContent01"
            on("next") {
                //log.debug("params:"+ params)
                flow.contentMaterialList.get(1).content = params.contentMaterialInstance.content
                if (!flow.contentMaterialList.get(1).content) return error()
                [contentMaterialList: flow.contentMaterialList]
            }.to "displayContentMaterial"
        }

        displayContentMaterial{
            on("back") {
            }.to "enterContent02"
            on("cancel").to "beforeExit"
            on("save") {
                for(int i=0; i<2; i++){
                    def cm = flow.contentMaterialList[i]
                    cm.save(flush: true)
                }
            }.to "beforeExit"
        }

        beforeExit {
            action {
                redirect(uri: "/")
            }
            on("success").to "exit"

        }

        exit ()

        handleError()
    }
}