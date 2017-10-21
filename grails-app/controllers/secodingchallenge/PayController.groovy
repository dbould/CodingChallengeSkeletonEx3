package secodingchallenge

class PayController {

    def index() {
        def accounts = Account.list()

        render view: "pay", model: [accounts: accounts]
    }

    def transfer() {
        def accounts = Account.list()

        new Transaction(
                fromAccount: params.fromAccount,
                toAccount: params.toAccount,
                amount: params.amount
        ).save()

        def fromName = Account.get(params.fromAccount).name
        def toName = Account.get(params.toAccount).name
        def amount = params.amount

        render view: "pay", model: [accounts: accounts, fromName: fromName, toName: toName, amount: amount]
    }
}
