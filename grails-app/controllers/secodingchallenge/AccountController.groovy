package secodingchallenge

class AccountController {

    def index() {
        def accountId = params.id
        render view: "account", model: [account: Account.get(accountId)]
    }
}
