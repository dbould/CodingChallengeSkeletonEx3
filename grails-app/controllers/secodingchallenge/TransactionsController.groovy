package secodingchallenge

class TransactionsController {

    def index() {
        def accounts = Account.list()
        render view: "transactions", model: [accounts: accounts]
    }
}
