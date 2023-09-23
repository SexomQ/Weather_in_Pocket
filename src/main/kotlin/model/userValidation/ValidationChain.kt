package model.userValidation

class ValidationChain {
    private val validators = mutableListOf<IValidator<User>>()

    fun addValidator(validator: IValidator<User>): ValidationChain {
        validators.add(validator)
        return this
    }

    fun validate(user: User): Boolean {
        return validators.all { it.validate(user) }
    }
}