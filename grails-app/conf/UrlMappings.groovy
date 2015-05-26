class UrlMappings {

	static mappings = {

        "/"(controller: "user", action: "list")
        "/user/show/${id}"(controller: "user", action: "show")
        "/user/${userId}/startUsingComputer/${computerId}"(controller: "user", action: "addComputerToUser")
        "500"(view:'/error')
        "404"(controller: "user", action: "list")
	}
}
