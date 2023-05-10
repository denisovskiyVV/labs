
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
// Получаем параметры запроса
        String name = request.getParameter("name");
        String email = request.getParameter("email");

// Создаем экземпляр класса, который будет обрабатывать параметры запроса
        Forma formProcessor = new Forma();

// Обрабатываем параметры запроса и получаем результат
        String result = formProcessor.formmm(name, email);

// Отправляем ответ клиенту
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Form Submit Result:</h1>");
        out.println(result);
        out.println("</body></html>");
    }
    }
