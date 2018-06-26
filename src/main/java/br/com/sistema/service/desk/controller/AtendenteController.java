package br.com.sistema.service.desk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sistema.service.desk.dao.AtendenteDao;
import br.com.sistema.service.desk.models.Atendente;
import br.com.sistema.service.desk.util.AtendenteValidation;

@Controller
@RequestMapping("/atendentes")
public class AtendenteController {

	private AtendenteDao dao = new AtendenteDao();
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(new AtendenteValidation());
	}
	
	 @RequestMapping("/add")
	 public ModelAndView form(Atendente atendente){
	        return new ModelAndView("atendentes/add");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView gravar(@Valid Atendente atendente, BindingResult result, RedirectAttributes redirectAttributes){
		 if(result.hasErrors()){
		        return form(atendente);
		 }
	     dao.gravar(atendente);
	     redirectAttributes.addFlashAttribute("sucesso","Atendente cadastrado com sucesso!");
	     return new ModelAndView("redirect:atendentes");
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView listar() {
		 List<Atendente> listar = dao.listar();
		 ModelAndView mv = new ModelAndView("atendentes/listar");
		 mv.addObject("atendentes", listar);
		 return mv;
	 }
}
