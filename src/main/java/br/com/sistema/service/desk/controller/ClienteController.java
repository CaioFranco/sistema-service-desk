package br.com.sistema.service.desk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sistema.service.desk.dao.ClienteDao;
import br.com.sistema.service.desk.models.Cliente;
import br.com.sistema.service.desk.util.ClienteValidation;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteDao dao = new ClienteDao();
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(new ClienteValidation());
	}
	
	 @RequestMapping("/add")
	 public ModelAndView form(Cliente cliente){
         return new ModelAndView("clientes/add");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView gravar(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirectAttributes){
		 if(result.hasErrors()){
		        return form(cliente);
		 }
		 dao.gravar(cliente);
	     redirectAttributes.addFlashAttribute("sucesso","Cliente cadastrado com sucesso!");
	     return new ModelAndView("redirect:clientes");
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView listar() {
		 List<Cliente> listar = dao.listar();
		 ModelAndView mv = new ModelAndView("clientes/listar");
		 mv.addObject("clientes", listar);
		 return mv;
	 }
	 

}
