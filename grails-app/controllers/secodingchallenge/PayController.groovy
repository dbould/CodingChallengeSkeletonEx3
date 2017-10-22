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
        Double amount = params.double('amount')

        def fromAccount = Account.get(params.fromAccount)
        Double fromAccountBalance = fromAccount.balance
        Double newFromBalance = fromAccountBalance - amount

        def message = ''

        if (newFromBalance >= 0) {
            fromAccount.balance = newFromBalance
            fromAccount.save(flush: true)

            def toAccount = Account.get(params.toAccount)
            Double toAccountBalance = toAccount.balance
            Double newToBalance = toAccountBalance + amount
            toAccount.balance = newToBalance
            toAccount.save(flush: true)

            message = 'Transfer complete.';
        } else {
            message = 'Not enough funds in ' + fromName + '\'s account.  Transfer was unsuccessful.';
        }

        render view: "pay", model: [accounts: accounts,
                                    fromName: fromName,
                                    toName: toName,
                                    amount: amount,
                                    message: message]
    }
}
