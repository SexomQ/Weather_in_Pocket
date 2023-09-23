package model.userValidation

class PasswordValidator : IValidator<User> {
    override fun validate(input: User): Boolean {
        // Simple validation: password is at least 8 characters long
        return input.password.length >= 8
    }
}