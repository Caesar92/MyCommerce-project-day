package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/admin/remove-category")
public class RemoveCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("categoryId");
        try {
            Long id = Long.parseLong(idStr);
            CategoryDao dao = DaoFactory.getCategoryDao();
            dao.remove(id);

            resp.sendRedirect(ListCategoryServlet.URL);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
