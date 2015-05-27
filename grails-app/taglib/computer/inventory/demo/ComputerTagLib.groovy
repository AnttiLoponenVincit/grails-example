package computer.inventory.demo

class ComputerTagLib {
    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def formatComputerInformation = {attrs, body ->
        Computer computer = attrs.computer
        out << "<u>${computer.model.manufacturer.name} ${computer.model.name}</u><br/>"
        out << "<b>${g.message(code:'OperatingSystemType.' + computer.operatingSystem.type)}</b> "
        out << computer.operatingSystem.versionName
    }
}
