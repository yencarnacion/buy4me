class UrlMappings {

	static mappings = {

        "/home/loginSuccess" (controller: "loginSuccess")
        "/login/$action" (controller: "login")
        "/logout/$action" (controller:  "logout")

        "/"(controller: "index")
        "/index2"(view:"/index2")
        "500"(view:'/error')

        "/home/dashboard" (view: "/dashboard")
        "/b4m/needItem/$action?/$id?(.${format})?"   (controller: "needItem")

        "/home/webflow/$action?/$id?(.${format})?" (controller: "webflow")

        "/secure/dashboard" (view: "/dashboard")

        "/secure/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }


	}
}
