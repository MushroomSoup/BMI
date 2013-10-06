import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** Shows all the parameters sent to the servlet via either
 *  GET or POST. Specially marks parameters that have
 *  no values or multiple values.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class calculateBMI extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    
  }

  @Override
  protected void doPost(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {
    
    String weight = request.getParameter("weight");
    double w = Double.parseDouble(weight);
    String height = request.getParameter("height");
    double h = Double.parseDouble(height);
    
    double b;
    b = (w/(h*h));
    DecimalFormat df = new DecimalFormat("0.00");
    
    PrintWriter out = response.getWriter();
    out.println("<HTML>\n" +
                "<HEAD><TITLE></TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1 ALIGN=CENTER>Your BMI:</H1> \n"+ 
                "<h2> Your weight: " + request.getParameter("weight") + "kg</h2>\n" +
                "<h2> Your height:" + request.getParameter("height") + "m</h2>\n" +
                "<h2> BMI : " + df.format(b)+ "</h2>" +
                "<table border='1'><td>BMI</td>\n"+
                       "<td>Weight Status</td>\n"+
                "<tr>\n"+
                "<td>Below 18.5</td><td>Underweight</td>\n"+
                "<tr>\n"+
                "<td>18.5 - 24.9</td><td>Normal</td>\n"+
                "<tr>\n"+
                "<td>25.0 - 29.9</td><td>Overweight</td>\n"+
                "<tr>\n"+
                "<td>30.0 and above</td><td>Obese</td>\n"+
                "</table></BODY></HTML>");
    
  }
}
  
