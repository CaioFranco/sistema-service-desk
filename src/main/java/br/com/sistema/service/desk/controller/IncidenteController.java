package br.com.sistema.service.desk.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sistema.service.desk.dao.AtendenteDao;
import br.com.sistema.service.desk.dao.ClienteDao;
import br.com.sistema.service.desk.dao.IncidenteDao;
import br.com.sistema.service.desk.models.Incidente;
import br.com.sistema.service.desk.models.Status;
import br.com.sistema.service.desk.util.IncidenteValidation;

@Controller
@RequestMapping("/incidentes")
public class IncidenteController {

	private IncidenteDao dao = new IncidenteDao();
	private ClienteDao clienteDao = new ClienteDao();
	private AtendenteDao atendenteDao = new AtendenteDao();
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(new IncidenteValidation());
	}

	 @RequestMapping("/add")
	 public ModelAndView form(Incidente incidente){
		 ModelAndView mv = new ModelAndView( "incidentes/add");
		 mv.addObject("clientes", clienteDao.listar());
		 mv.addObject("atendentes", atendenteDao.listar());
		 return mv;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView gravar(Incidente incidente, BindingResult result, RedirectAttributes redirectAttributes){
		 if(result.hasErrors()){
		        return form(incidente);
		 }
	     incidente.setStatus(Status.ABERTO.getDescricao());
	     dao.gravar(incidente);
	     redirectAttributes.addFlashAttribute("sucesso","Incidente Registrado com sucesso!");
	     return new ModelAndView("redirect:incidentes");
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView listar() {
		 List<Incidente> listar = dao.listar();
		 ModelAndView mv = new ModelAndView("incidentes/listar");
		 mv.addObject("incidentes", listar);
		 return mv;
	 }
	 
	 @RequestMapping("/encerrar/{id}")
	 public ModelAndView encerrar(@PathVariable("id") Long id) {
		 ModelAndView mv = new ModelAndView("/incidentes/encerrar");
		 dao.encerrar(id);
		 return mv;
	 }

}
