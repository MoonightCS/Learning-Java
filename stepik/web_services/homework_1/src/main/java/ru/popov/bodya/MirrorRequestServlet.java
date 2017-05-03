package ru.popov.bodya;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Написать сервлет, который будет обрабатывать запросы на /mirror
При получении GET запроса с параметром key=value сервлет должен вернуть в response строку содержащую value.
Например, при GET запросе /mirror?key=hello сервер должен вернуть страницу, на которой есть слово "hello".
 */

public class MirrorRequestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        String value = request.getParameter("key");
        if (value != null) {
            response.getWriter().println(value);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }

    }


}
