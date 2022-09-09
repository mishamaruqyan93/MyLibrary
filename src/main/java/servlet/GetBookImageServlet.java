package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/getBookImage")
public class GetBookImageServlet extends HttpServlet {

    private static final String BOOK_IMAGE_PATH = "C:\\Users\\SmartS\\IdeaProjects\\MyLibrary\\authorImages\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String profilePic = req.getParameter("profilePic");
        String filePath = BOOK_IMAGE_PATH + profilePic;
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            try (FileInputStream inputStream = new FileInputStream(imageFile)) {
                resp.setContentType("image/jpeg");
                resp.setContentLength((int) imageFile.length());
                OutputStream outputStream = resp.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
