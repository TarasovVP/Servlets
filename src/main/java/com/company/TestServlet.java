package com.company;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by java on 17.11.2018.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest hsreq, HttpServletResponse hsresp){
        try {
            PrintWriter out = hsresp.getWriter();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
