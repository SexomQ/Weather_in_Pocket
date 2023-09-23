package model.userValidation

interface IValidator<T> {
    fun validate(input: T): Boolean
}