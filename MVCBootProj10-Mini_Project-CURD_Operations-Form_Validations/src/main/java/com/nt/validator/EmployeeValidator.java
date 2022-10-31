package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {//To check wheather current model class taken or not
		return clazz.isAssignableFrom(Employee.class);//if True the next validate(-) method executes else it will not execute.
	}

	@Override
	public void validate(Object target, Errors errors) {//Place the Form validation logic here
		// Type casting with Model calss
		Employee emp = (Employee) target;

		//Form validation logic(Server Side) and place the Errors in Errors object
		if (emp.getEname() == null || emp.getEname().isBlank()) {//required rule
			errors.rejectValue("ename", "emp.name.required");
		} else if (emp.getEname().length() < 5 || emp.getEname().length() >= 20) {//length rule
			errors.rejectValue("ename", "emp.name.length");
		}

		if (emp.getJob() == null || emp.getJob().isBlank()) {//required rule
			errors.rejectValue("job", "emp.job.required");
		} else if (emp.getJob().length() < 5 || emp.getJob().length() >= 15) {//length rule
			errors.rejectValue("job", "emp.job.length");
		}

		if (!errors.hasFieldErrors("sal")) {
			if (emp.getSal() == null) //required rule
				errors.rejectValue("sal", "emp.salary.required");
			else if (emp.getSal() < 1000.0 || emp.getSal() >10000.0) //range rule
				errors.rejectValue("sal", "emp.salary.range");
		}

		if (emp.getDeptno() == null) {//required rule
			errors.rejectValue("deptno", "emp.deptno.required");
		}
	}

}
