package it.formarete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value = "/{who}", method = RequestMethod.GET)
	public String printHello(Model model, @PathVariable(value = "who") String who) {
		model.addAttribute("message", "Hello " + who + "!");
		return "hello";
	}
}
