package com.arseniisemenov.springbootsecurity.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.arseniisemenov.model.Author;
import com.arseniisemenov.model.Category;
import com.arseniisemenov.model.Verse;

@Controller
public class MainController {
    ArrayList<Author> authors;
    ArrayList<Category> categories;
    ArrayList<Verse> verses;

    public MainController() {
        authors = new ArrayList<Author>();
        authors.add(new Author(1, "Author 1", "Ukraine", "Biography 1"));
        authors.add(new Author(2, "Author 2", "Poland", "Biography 2"));

        categories = new ArrayList<Category>();
        categories.add(new Category(1, "Категория 1"));
        categories.add(new Category(2, "Категория 2"));

        verses = new ArrayList<Verse>();
        verses.add(new Verse(
            1,
            "Test line 1\nTest line 2\nTest line 3\nTest line 4",
            1,
            2));
        verses.add(new Verse(
            2,
            "Оставь, и я была как все,\nИ хуже всех была,\nКупалась я в чужой росе,\nИ пряталась в чужом овсе,\nВ чужой траве спала.",
            1,
            2));
        verses.add(new Verse(
            3,
            "Жизнь проходит,— вечен сон.\nХорошо мне,— я влюблен.\nЖизнь проходит,— сказка — нет.\nХорошо мне,— я поэт.\nДушен мир,— в душе свежо.\nХорошо мне, хорошо.",
            1,
            2));
        verses.add(new Verse(
            4,
            "Полуразрушенный, я сам себе не нужен,\nИ с девой в сладкий бой вступаю безоружен.",
            1,
            1));
        verses.add(new Verse(
            5,
            "— Ну, как тебе на ветке? —\nСпросила птица в клетке.\n— На ветке, как и в клетке,\nТолько прутья редки.",
            2,
            1));
    }


    @GetMapping(value = {"/", "/index"})
    public String Index(Map<String, Object> model) {
        model.put("verses", verses);
        return "/index";
    }
    @GetMapping(value = "/index/random")
    public String Random(Map<String, Object> model) {
        int index = new Random().nextInt(verses.size());
        ArrayList<Verse> buf = new ArrayList<Verse>();
        buf.add(verses.get(index));
        model.put("verses", buf);
        return "/index";
    }

    @GetMapping(value = "/authors")
    public String Authors(Map<String, Object> model) {
        model.put("authors", authors);
        return "/authors";
    }

    @GetMapping(value = "/categories")
    public String Categories(Map<String, Object> model, @RequestParam(value = "search", required = false) String search) {
        ArrayList<Category> buf = new ArrayList<Category>();
        if(search != null) {
            for(Category category : categories) {
                if(category.getName().contains(search)) {
                    buf.add(category);
                }
            }
        } else {
            buf = categories;
        }
        model.put("categories", buf);
        return "/categories";
    }
    @GetMapping(value = "/admin/addcategory")
    public String AddCategoryView() {
        return "/admin/create";
    }
    @PostMapping(value = "/admin/addcategory")
    public RedirectView AddCategory(@RequestParam(value = "name") String name) {
        categories.add(new Category(categories.size() + 1, name));
        return new RedirectView("/categories");
    }

    @GetMapping(value = "/admin/editcategory/{id}")
    public String EditCategoryView(Map<String, Object> model, @PathVariable(value = "id") int id) {
        Category category = categories.get(id - 1);
        System.out.println(category.getName());
        model.put("category", category);
        return "/admin/edit";
    }
    @PostMapping(value = "/admin/editcategory/{id}")
    public RedirectView EditCategory(@PathVariable(value = "id") int id, @RequestParam(value = "name") String newName) {
        Category buf = categories.get(id - 1);
        buf.setName(newName);
        categories.set(id - 1, buf);
        return new RedirectView("/categories");
    }
    @GetMapping(value = "/admin/deletecategory/{id}")
    public RedirectView DeleteCategory(@PathVariable(value = "id") int id) {
        categories.remove(id - 1);
        return new RedirectView("/categories");
    }

    @GetMapping(value = "/about")
    public String About() {
        return "/about";
    }

    @GetMapping(value = "/login")
    public String Login() {
        return "/login";
    }

    @GetMapping(value = "/error")
    public String Error() {
        return "/error/error";
    }

    @GetMapping(value = "/403")
    public String Error403() {
        return "/error/403";
    }
}
