package model.userValidation

class LoginValidator : IValidator<User> {
    override fun validate(input: User): Boolean {
        // Simple validation: login is not empty
        return input.username.isNotEmpty()
    }
}