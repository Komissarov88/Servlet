package org.learning.komissarov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyServlet", urlPatterns = "/products")
public class MyServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(MyServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return "MyServlet";
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        logger.info("New request");

        List<Product> productList = new ArrayList<>(10);
        productList.add(new Product(1, "memory", 15));
        productList.add(new Product(2, "clothes", 5));
        productList.add(new Product(3, "video", 4));
        productList.add(new Product(4, "phone", 55));
        productList.add(new Product(5, "piano", 155));
        productList.add(new Product(6, "protection", 1000));
        productList.add(new Product(7, "pie", 3));
        productList.add(new Product(8, "honey", 1));
        productList.add(new Product(9, "tooth", 1));
        productList.add(new Product(10, "tea", 66));

        res.getWriter().print("<html><body><h1>Products:</h1><ul>");
        for (Product product : productList) {
            res.getWriter().print("<li>"+ product +"</li>");
        }
        res.getWriter().print("</ul></body></html>");
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
