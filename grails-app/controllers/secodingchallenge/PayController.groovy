package secodingchallenge

class PayController {
    def accountService
    def payService

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

        def fromAccount = Account.get(params.fromAccount)
        Double amount = params.double('amount')

        def approveTransaction = payService.approveTransaction(fromAccount.balance, amount)

        if (approveTransaction == true) {
            accountService.updateAccountBalances(params.int('fromAccount'),
                                                 params.int('toAccount'),
                                                 amount)
        }

        render view: "pay", model: [accounts: accounts,
                                    message: payService.getUserMessage(approveTransaction, fromAccount.name)]
    }
}
