package com.dominic.book_club.controllers;

import com.dominic.book_club.models.LoginUser;
import com.dominic.book_club.models.User;
import com.dominic.book_club.services.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// .. don't forget to inlcude all your imports! ..

@Controller
public class MainController {
  // Add once service is implemented:
  @Autowired
  private UserService userServ;
  @GetMapping("/")
  public String index(Model model) {
    // Bind empty User and LoginUser objects to the JSP
    // to capture the form input
    model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
    return "index.jsp";
  }

  @PostMapping("/register")
  public String register(
    @Valid @ModelAttribute("newUser") User newUser,
    BindingResult result,
    Model model,
    HttpSession session) {
    //Login a user via service
    User user = userServ.register(newUser, result);
    // TO-DO Later -- call a register method in the service
    // to do some extra validations and create a new user!
    if (result.hasErrors()) {
      // Be sure to send in the empty LoginUser before
      // re-rendering the page.
      model.addAttribute("newLogin", new LoginUser());
      return "index.jsp";
    }
    // No errors!
    // TO-DO Later: Store their ID from the DB in session,
    session.setAttribute("userId", user.getId());
    // in other words, log them in.
    return "redirect:/books";
  }

  @PostMapping("/login")
  public String login(
    @Valid @ModelAttribute("newLogin") LoginUser newLogin,
    BindingResult result,
    Model model,
    HttpSession session
  ) {
    // Add once service is implemented:
    User user = userServ.login(newLogin, result);

    if (result.hasErrors()) {
      model.addAttribute("newUser", new User());
      return "index.jsp";
    }
    // No errors!
    // TO-DO Later: Store their ID from the DB in session,
    // in other words, log them in.
    session.setAttribute("userId", user.getId());
    return "redirect:/books";
  }

  @GetMapping("/dashboard")
  public String dashboard() {
    return "dashboard.jsp";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    // clear session to logout
    // session.setAttribute("userId", null);
    session.invalidate();
    return "redirect:/";
  }
}