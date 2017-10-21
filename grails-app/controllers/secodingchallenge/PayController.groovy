package secodingchallenge

class PayController {

    def index() {
        def accounts = Account.list()

        render view: "pay", model: [accounts: accounts]
    }
}
