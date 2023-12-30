package boot.smp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.smp.helper.Message;
import boot.smp.model.User;
import boot.smp.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("page", "This is my Home Page .....Running ..");
		model.addAttribute("title", "HOME-Student Management");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("page", "This is my About Page .....Running ..");
		model.addAttribute("title", "ABOUT-Student Management");
		return "about";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("page", "This is my Login Page .....Running ..");
		model.addAttribute("title", "LOGIN-Student Management");
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("page", "Register here !!");
		model.addAttribute("title", "SIGNUP-Student Management");
		model.addAttribute("user", new User());

		return "signup";
	}

	@PostMapping("/do_register")
	public String doSubmit(@Valid @ModelAttribute User user, BindingResult bindingResult,
			@RequestParam(value = "CheckBox", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {

		model.addAttribute("page", "Register here !!");
		model.addAttribute("title", "SIGNUP-Student Management");

		System.out.println("agreement =" + agreement);
		System.out.println("user =" + user);

		try {
			if (!agreement)
				throw new Exception("You have not agreed the terms and conditions !!");
		} catch (Exception e) {

			e.printStackTrace();

			model.addAttribute("user", user);

			session.setAttribute("message", new Message("" + e.getMessage(), "alert-danger"));

			return "signup";
		}

		try {

			try {

				String idCheck = userService.getUserByID(user.getUserId());

				System.out.println("Checking existing userId" + idCheck);

				if (idCheck != null)
					bindingResult.addError(new FieldError("user", "userId", "User Id is already taken."));

			} catch (Exception e) {

				throw new Exception(e.getMessage());
			}

			if (bindingResult.hasErrors()) {

				System.out.println("Error-------------- : " + bindingResult.toString());
				model.addAttribute("user", user);

				return "signup";
			}

			User result = userService.saveUser(user);

			model.addAttribute("user", new User());

			session.setAttribute("message", new Message("You have registered successfully !!", "alert-success"));

			return "signup";

		} catch (Exception e) {

			e.printStackTrace();

			model.addAttribute("user", user);

			session.setAttribute("message", new Message("SOmething went wrong. It's not you , It's US." , "alert-danger"));

			return "signup";
		}

	}

}
