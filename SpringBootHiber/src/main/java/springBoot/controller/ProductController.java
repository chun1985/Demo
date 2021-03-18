
package springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springBoot.entity.Product;
import springBoot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView listProducts(ModelMap model) {
		List<Product> products = service.getProducts();
		model.addAttribute("products", products);
		return new ModelAndView("homePage");
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public ModelAndView newProduct(ModelMap model) {
		Product products = new Product();
		model.addAttribute("products", products);
		model.addAttribute("edit", false);
		return new ModelAndView("registration");
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public ModelAndView saveProduct(@Validated Product products, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return new ModelAndView("registration");
		}
		service.saveProduct(products);
		model.addAttribute("success", "Product " + products.getName() + " registered successfully");
		return new ModelAndView("success");
	}

	@RequestMapping(value = { "/edit/{name}" }, method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable String name, ModelMap model) {
		Product product = service.getProductByName(name);
		model.addAttribute("products", product);
		model.addAttribute("edit", true);
		return new ModelAndView("registration");
	}

	@RequestMapping(value = { "/edit/{name}" }, method = RequestMethod.POST)
	public ModelAndView updateProduct(@Validated Product product, BindingResult result, ModelMap model,
			@PathVariable String name) {
		if (result.hasErrors()) {
			return new ModelAndView("registration");
		}
		service.updateProduct(product);
		model.addAttribute("success", "Product " + product.getName() + " updated successfully");
		return new ModelAndView("success");
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public ModelAndView deleteProduct(ModelMap model, @PathVariable int id) {
		model.addAttribute("success", service.deleteProduct(id));
		return new ModelAndView("success");
	}
}
