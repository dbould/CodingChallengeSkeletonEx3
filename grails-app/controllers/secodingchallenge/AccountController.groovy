package secodingchallenge

class AccountController {

    def index() {
        def accountId = params.id

        def query = Transaction.where {
            fromAccount == accountId
        }

        def transactions = query.find()

        render view: "account", model: [account: Account.get(accountId), transactions: transactions]
    }
}
