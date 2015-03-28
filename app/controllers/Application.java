package controllers;

import models.Doctor;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static class Login{
        String username , password;
        public String validate() {return  null;}
    }
    public static class SignUp {
        public String name, username, password, degree, clinic, bio;

        public String validate() {
            return null;
        }
    }
    private static Form<Login> loginForm = Form.form(Login.class);
    private static Form<SignUp> signForm = Form.form(SignUp.class);

    public static Result index() {
        return ok(index.render("AskHere"));
    }

    public static Result Enter() {
        return ok(enter.render(loginForm,signForm));
    }

    public static Result authenticateLogin() {
        Form<Login> filledForm = loginForm.bindFromRequest();
        if (filledForm.hasErrors())
            return badRequest(enter.render(filledForm,signForm));

        session().clear();
        session("handle","doctor");
        return redirect(controllers.routes.Application.index());
    }

    public static Result logout() {
        session().clear();
        return redirect(routes.Application.index());
    }

    public static Result authenticateSignUp() {
        Form<SignUp> filledForm = signForm.bindFromRequest();
        if (filledForm.hasErrors())
            return badRequest(enter.render(loginForm,filledForm));
        session().clear();
        session("handle","doctor");
        return redirect(controllers.routes.Application.index());
    }
}
