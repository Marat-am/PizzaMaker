package com.example.pizzamakerservice.controler;

import com.example.pizzamakerservice.model.Order;
import com.example.pizzamakerservice.service.OrderService;
import com.example.pizzamakerservice.service.impl.OrderServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderController extends HttpServlet {
    private final OrderService orderService = new OrderServiceImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");

        switch (url) {
            case "read-all":
                resp.getWriter().println(gson.toJson(orderService.readAll()));
                break;
            case "read-by-table-id":
                int table_id = Integer.parseInt(req.getParameter("table_id"));
                resp.getWriter().println(gson.toJson(orderService.read(table_id)));
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = mapper(req);
        orderService.create(order);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = mapper(req);
        orderService.update(order);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        orderService.delete(id);
    }


    private Order mapper(HttpServletRequest req) {
        boolean in_process = Boolean.parseBoolean(req.getParameter("in_process"));
        int id = 0;
        int table_id = 0;
        int product_id = 0;
        int quantity = 0;
        float amount = 0;


        try {
            id = Integer.parseInt(req.getParameter("id"));
            table_id = Integer.parseInt(req.getParameter("table_id"));
            product_id = Integer.parseInt(req.getParameter("product_id"));
            quantity = Integer.parseInt(req.getParameter("quantity"));
            amount = Float.parseFloat(req.getParameter("amount"));
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }

        return new Order(id, table_id, in_process, product_id, quantity, amount);
    }


}
