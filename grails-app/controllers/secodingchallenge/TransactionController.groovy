package secodingchallenge

class TransactionController {

    def index() {
        def accounts = Account.list()
        render view: "transactions", model: [accounts: accounts]
    }

    def accountTransactions() {
        def accountId = params.accountId

        def query = Transaction.where {
            fromAccount == accountId
        }

        def transactions = query.list()

        render view: "account", model: [account: Account.get(accountId), transactions: transactions]
    }
}
