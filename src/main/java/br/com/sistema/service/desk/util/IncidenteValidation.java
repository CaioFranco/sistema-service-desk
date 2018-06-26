package br.com.sistema.service.desk.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.sistema.service.desk.models.Incidente;

public class IncidenteValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Incidente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "cliente", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "atendente", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
	}

}
