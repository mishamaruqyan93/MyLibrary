package servlet;

import manager.AuthorManager;
import manager.BookManager;
import model.Author;
import model.Book;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100)

public class AddBookServlet extends HttpServlet {
    private static final AuthorManager authorManager = new AuthorManager();
    private static final BookManager bookManager = new BookManager();
    private static final String BOOK_IMAGE_PATH = "C:\\Users\\SmartS\\IdeaProjects\\MyLibrary\\authorImages\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authorList = authorManager.getAll();
        req.setAttribute("authors", authorList);
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));

        Part profilePic = req.getPart("profilePic");
        String fileName = null;
        if (profilePic.getSubmittedFileName().length() != 0) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + profilePic.getSubmittedFileName();
            profilePic.write(BOOK_IMAGE_PATH + fileName);
        }

        Book book = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getById(authorId))
                .profilePic(fileName)
                .build();
        bookManager.addBook(book);
        resp.sendRedirect("/books");
    }
}
