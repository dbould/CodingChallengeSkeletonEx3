package secodingchallenge

//import grails.plugin.mail.GrailsMailException

class PayController {
    def accountService
    def payService
    //def mailService

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

            accountService.updateBalances(params.int('fromAccount'),
                                                 params.int('toAccount'),
                                                 amount)

//            def toAccount = Account.get(params.toAccount)
//            try {
//                mailService.sendMail {
//                    to fromAccount.email, toAccount.email
//                    from "my@bank.com"
//                    subject "Account Transfer Complete"
//                    text "£" + amount + " has been transferred from " + fromAccount.name + " to " + toAccount.name
//                }
//            } catch (GrailsMailException e) {
//
//            }

        }

        render view: "pay", model: [accounts: accounts,
                                    message: payService.getUserMessage(approveTransaction, fromAccount.name)]
    }
}
