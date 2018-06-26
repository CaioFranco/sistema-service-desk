package br.com.sistema.service.desk.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.sistema.service.desk.models.Atendente;

public class AtendenteValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Atendente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
	}

}
