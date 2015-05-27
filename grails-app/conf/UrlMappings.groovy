class UrlMappings {

	static mappings = {

        "/${max}?/${offset}?"(controller: "computer", action: "list")
        //"/"(controller: "computer", action: "list")

        "/user/show/${id}"(controller: "user", action: "show")
        "/user/list" (controller:"user", action: "list")
        "/user/create" (controller: "user", action: "create")
        "/user/save" (controller: "user", action: "save")
        "/user/${userId}/startUsingComputer/${computerId}"(controller: "user", action: "addComputerToUser")

        "/computer/show/${id}" (controller: "computer", action: "show")
        "/computer/save" (controller:"computer", action: "save")
        "/computer/create" (controller:"computer", action: "create")

        "/500"(view:'/error')
        //"/404"(controller: "user", action: "list")
	}
}
