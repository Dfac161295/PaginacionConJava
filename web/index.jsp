<%-- 
    Document   : index
    Created on : Mar 18, 2019, 7:18:33 PM
    Author     : DanielAC
--%>

<%@page import="herramientas.Paginacion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="herramientas.Conector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>

        <h1>Consulta de Vehiculos</h1>

        <%
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


        %>



        <table class="table">

            <thead>
                <tr>
                    <th>ID_AUTOMOVIL</th>
                    <th>COLOR</th>
                    <th>MARCA</th>
                    <th>MODELO</th>
                    <th>ID_PERSONA</th>
                </tr>
            </thead>

            <tbody>

                <% while (rs.next()) {%>
                <tr>
                    <td><%= rs.getInt("ID_AUTOMOVIL")%></td>
                    <td><%= rs.getString("COLOR")%></td>
                    <td><%= rs.getString("MARCA")%></td>
                    <td><%= rs.getString("MODELO")%></td>
                    <td><%= rs.getInt("ID_PERSONA")%></td>
                </tr>
                <% }%>
            </tbody>    






        </table>







    </body>
</html>
