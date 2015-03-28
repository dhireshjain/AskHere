package controllers;

import models.Doctor;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result anonymousUserChat() {
        session().put("username", "anonymous");
        return ok(views.html.chat.render("aa"));
    }

    public static Result doctorChat() {
        session().put("username", "doctor");
        return TODO;
    }

}
