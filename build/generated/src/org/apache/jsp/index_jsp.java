package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import herramientas.Paginacion;
import java.sql.ResultSet;
import java.sql.Connection;
import herramientas.Conector;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h1>Consulta de Vehiculos</h1>\n");
      out.write("\n");
      out.write("        ");

            Conector c = new Conector();
            Connection cn = c.conectar();
            String pagina = request.getParameter("pagina");
            int numeroRegistrosPorPagina = 5;
            int numeroRegistros = c.filas(cn, "SELECT * FROM AUTOMOVIL");
            int i = 1;
            int numerodePaginas = 10;

            Paginacion p = new Paginacion();

            int numerodepaginas = p.NumeroDePaginas(numeroRegistros, numeroRegistrosPorPagina);
            
            
            

            if (pagina == null) {
                pagina = "1";
            }

            int mypage = Integer.parseInt(pagina);
            int finpage = mypage * numeroRegistrosPorPagina;
            int iniciopage = finpage - (numeroRegistrosPorPagina-1);

            
            
            out.println("<nav aria-label='Page navigation example'>");
            out.println("<ul class='pagination'>");
            if (mypage > 1) {
                int ante = mypage - 1;
                out.println("<li class='page-item'><a class='page-link' href='http://localhost:8080/Paginacion/index.jsp?pagina=" + (ante) + "'>Anterior</a></li>");
                out.println("<li class='page-item'><a class='page-link' href='http://localhost:8080/Paginacion/index.jsp?pagina=" + (1) + "'><<</a></li>");
            }

            
            String numpaginaciones = p.cantidadDePaginas(mypage,6);
            
            String numpaginacionessplit [] = numpaginaciones.split("-");
            
            int initpag = Integer.parseInt(numpaginacionessplit[0]);
            int finpag = Integer.parseInt(numpaginacionessplit[1]);
            
           
            
            
            for(int j = initpag;j<=finpag;j++){
                
                if(j<=numerodepaginas){
                
                if(mypage == j){    
                out.println("<li class='page-item active'><a class='page-link' href='http://localhost:8080/Paginacion/index.jsp?pagina=" + j + "'>" + j + "</a></li>");
                }else{
                out.println("<li class='page-item'><a class='page-link' href='http://localhost:8080/Paginacion/index.jsp?pagina=" + j + "'>" + j + "</a></li>");
                }
                
                }
            }
            

            
            
            
            if (mypage < numerodepaginas) {
                int sigui = mypage + 1;
                out.println("<li class='page-item'><a class='page-link' href='http://localhost:8080/Paginacion/index.jsp?pagina=" + (numerodepaginas) + "'>>></a></li>");
                out.println("<li class='page-item'><a class='page-link' href='http://localhost:8080/Paginacion/index.jsp?pagina=" + (sigui) + "'>Siguiente</a></li>");
            }

            out.println("</ul>");
            out.println("</nav>");
            
            
            ResultSet rs = c.consultas(cn, "SELECT * FROM AUTOMOVIL WHERE ID_AUTOMOVIL BETWEEN " + iniciopage + " AND " + finpage + "ORDER BY ID_AUTOMOVIL ASC");


        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table class=\"table\">\n");
      out.write("\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID_AUTOMOVIL</th>\n");
      out.write("                    <th>COLOR</th>\n");
      out.write("                    <th>MARCA</th>\n");
      out.write("                    <th>MODELO</th>\n");
      out.write("                    <th>ID_PERSONA</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("\n");
      out.write("            <tbody>\n");
      out.write("\n");
      out.write("                ");
 while (rs.next()) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs.getInt("ID_AUTOMOVIL"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("COLOR"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("MARCA"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("MODELO"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getInt("ID_PERSONA"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </tbody>    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
