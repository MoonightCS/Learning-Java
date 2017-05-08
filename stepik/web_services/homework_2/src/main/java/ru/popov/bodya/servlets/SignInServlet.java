package ru.popov.bodya.servlets;

import ru.popov.bodya.accounts.AccountService;
import ru.popov.bodya.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

При получении POST запроса на signin, после регистрации, SignInServlet проверяет,
логин/пароль пользователя. Если пользователь уже зарегистрирован, север отвечает

Status code (200)
и текст страницы:
Authorized: login

если нет:
Status code (401)
текст страницы:
Unauthorized

 */

public class SignInServlet extends HttpServlet {

    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");

        if (login == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile = accountService.getUserByLogin(login);
        if (profile == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Authorized: " + profile.getLogin());
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
