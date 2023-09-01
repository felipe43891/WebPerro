package CalculadoraServlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/CalculadoraServlet"})
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int pG = Integer.parseInt(request.getParameter("perro-grande"));
        int pM = Integer.parseInt(request.getParameter("perro-mediano"));
        int pP = Integer.parseInt(request.getParameter("perro-pequeno"));
        
        int perroGrandeHoras = Integer.parseInt(request.getParameter("perro-grande-horas"));
        int perroMedianoHoras = Integer.parseInt(request.getParameter("perro-mediano-horas"));
        int perroPequenoHoras = Integer.parseInt(request.getParameter("perro-pequeno-horas"));
        
        int perroGrandePrecio = 10000;
        int perroMedianoPrecio = 5000;
        int perroPequenoPrecio = 3000;
        double descuentoPorcentaje = 0.10; 

        int totalSinDescuento =
            (int) (pG * perroGrandePrecio * perroGrandeHoras) +
            (pM * perroMedianoPrecio * perroMedianoHoras) +
            (pP * perroPequenoPrecio * perroPequenoHoras);

        int total = totalSinDescuento;

        if ((pG + pM + pP) > 1) {
            total -= (int) (totalSinDescuento * descuentoPorcentaje); // Aplicamos el descuento
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<link rel=\"stylesheet\" href=\"Style.css\">");
            out.print("</head>");
            out.print("<body>");
            
            out.print("<h1>Resultado</h1>");
            out.print("<p>El costo total a pagar es: " + total + "</p>");
            
            out.print("</body>");
            out.print("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "CalculadoraServlet";
    }
}
