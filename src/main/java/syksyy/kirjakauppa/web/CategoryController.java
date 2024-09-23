package syksyy.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import syksyy.kirjakauppa.domain.Category;
import syksyy.kirjakauppa.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = { "/categorylist" })
    public String getCategoryList(Model model) {
        model.addAttribute("listOfCategories", categoryRepository.findAll());
        return "categorylist";
    }

    @GetMapping(value = { "/addcategory" })
    public String getAddBook(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping(value = { "/savecategory" })
    public String postMethodName(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }

}
