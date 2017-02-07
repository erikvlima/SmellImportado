package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cdc.model.Promocao;
import cdc.model.PromocaoDAO;
import javax.websocket.SessionException;
import cdc.model.Produto;
import cdc.model.ListaImagemProduto;
import cdc.model.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;

public final class TelaPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"sistemCSS_1.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\"><span>Smell Importados</span><br></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\">\n");
      out.write("                    <i class=\"fa fa-3x fa-car fa-fw pull-right text-muted\"></i>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");

                            HttpSession sessao = request.getSession(true);
                            String tipoUsuario = "c";
                            boolean ehNova = false;
                            if (sessao.isNew()) {

                                sessao.invalidate();
                                ehNova = true;
                            } else {
                                sessao.setMaxInactiveInterval(300);
                                try {
                                    tipoUsuario = sessao.getAttribute("tipoUsuario").toString();
                                } catch (Exception e) {
                                    tipoUsuario = "c";
                                    ehNova = true;
                                    //out.print(e);
                                }
                            }
                        
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"TelaPrincipal.jsp\">Home</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
 if (tipoUsuario.equalsIgnoreCase("a") || tipoUsuario.equalsIgnoreCase("v")) {
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"clientes?cmd=listar\">Gerenciar Clientes</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        ");

                            if (tipoUsuario.equalsIgnoreCase("a")) {
                        
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"usuarios?cmd=listar\">Gerenciar Usuarios</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            if (tipoUsuario.equalsIgnoreCase("g")) {
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"promocao?cmd=listar\">Gerenciar Promoções</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            if (tipoUsuario.equalsIgnoreCase("e")) {
                        
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"produtos?cmd=listar\">Gerenciar Produtos</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        ");
}
                            if (tipoUsuario.equalsIgnoreCase("c") && !ehNova) {
                                String idCliente = sessao.getAttribute("idUsuarioLogin").toString();
                        
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"clientes?cmd=update&id=");
out.println(idCliente);
      out.write("\">Alterar meus Dados</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <form action=\"Carrinho\" method=\"get\"> \n");
      out.write("                                <input type=\"submit\" class=\"btn btn-lg\" value=\"Meu Carrinho\"/>  \n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"Login.jsp\">Login</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        ");
if (!ehNova) {
      out.write("<li>\n");
      out.write("                            <a href=\"login?cmd=logout\">Sair</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <footer class=\"section section-primary\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        ");
 PromocaoDAO prom = new PromocaoDAO();
                            List<Promocao> listProm = prom.listaTodos();
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("                            ");
for (Promocao promo : listProm) {
      out.write("\n");
      out.write("                            <li><a href=\"promocao?cmd=mostraProCliente&id=");
out.print(promo.getIdPromocao());
      out.write("\"><font color=\"white\" size=\"3\">");
out.print(promo.getNomePromocao());
      out.write("</font></a> </li>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                        </ul></div> \n");
      out.write("                    <div class=\"col-xs-6\">\n");
      out.write("                        <p class=\"text-info text-right\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"row\"> \n");
      out.write("                                    <form action=\"PesquisaProduto\" method=\"post\">          \n");
      out.write("                                        <input type=\"hidden\" name=\"cmd\" value=\"pesquisa\"/>\n");
      out.write("                                        <input type=\"text\" class=\"form form-control-static col-lg-6 col-md-6 col-sm-5 col-xs-2\" name=\"palavraPesquisa\" placeholder=\"Pesquise por um produto aqui ...\" />\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-success col-lg-1 col-md-1 col-sm-2 col-xs-1\" value=\"Pesquisar\" />  \n");
      out.write("                                    </form>\n");
      out.write("                                    <fieldset class=\"col-lg-2 alinhado-direita top-right\" >\n");
      out.write("                                        <legend style=\"color: white\">Categorias</legend>\n");
      out.write("                                        <a href=\"TelaDeProdutosMasculinos.jsp\" ><button class=\"btn alinhado-direita\">Masculino</button></a><br>\n");
      out.write("                                        <br><a href=\"TelaDeProdutosFemininos.jsp\" ><button class=\"btn alinhado-direita\">Feminino</button></a>   \n");
      out.write("                                    </fieldset>\n");
      out.write("                                    \n");
      out.write("                                </div>   \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12 hidden-lg hidden-md hidden-sm text-left\">\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-3x fa-fw fa-instagram text-inverse\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-3x fa-fw fa-twitter text-inverse\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-3x fa-fw fa-facebook text-inverse\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-3x fa-fw fa-github text-inverse\"></i></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("                        \n");
      out.write("        ");
 List<ListaImagemProduto> list = new ArrayList<ListaImagemProduto>();
            ProdutoDAO produto = new ProdutoDAO();
            String pesquisa = request.getParameter("palavraPesquisa");

            if (pesquisa != null) {
                list = produto.buscaProdutoPesquisado(pesquisa);
            } else {
                list = produto.listaTodos();
            }

            if (list.isEmpty()) {
                response.sendRedirect("TelaPrincipalVazia.jsp");
            }
        
      out.write("\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <div class=\"background-image background-image-fixed\"></div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">       \n");
      out.write("\n");
      out.write("                    ");
 for (ListaImagemProduto proIm : list) { 
      out.write("\n");
      out.write("                    <form action=\"MontaCompra\" method=\"get\">                        \n");
      out.write("                        <div class=\"col-md-3 col-sm-5\" >   \n");
      out.write("                            <input type=\"hidden\" name=\"idProduto\" value=\"");
out.print(proIm.getIdProduto());
      out.write("\"/>      \n");
      out.write("                            <a href=\"MostraProdutoCompra.jsp\"><h2>");
out.print(proIm.getNomeProduto()); 
      out.write("</h2></a>\n");
      out.write("                            <a href=\"MostraProdutoCompra.jsp\"><img src=\"");
out.print(proIm.getImagem1());
      out.write("\" class=\"img-responsive img-thumbnail\"></a>\n");
      out.write("\n");
      out.write("                            <br><br>\n");
      out.write("                            <p>");
out.print(proIm.getDescricaoProduto());
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                            <h3> R$ ");
out.print(proIm.getPrecoProduto());
      out.write("</h3>\n");
      out.write("                            <input type=\"submit\" value=\"Comprar\"> \n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12 text-center\">\n");
      out.write("                        <ul class=\"pagination\">\n");
      out.write("                            <li class=\"\">\n");
      out.write("                                <a href=\"#\">Prev</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"\">\n");
      out.write("                                <a href=\"#\">1</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">2</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">3</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">4</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">5</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Next</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row text-center\">\n");
      out.write("                    <div class=\"col-xs-3 text-center\">\n");
      out.write("                        <a><i class=\"fa fa-5x fa-fw fa-instagram\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-3\">\n");
      out.write("                        <a><i class=\"fa fa-5x fa-fw fa-twitter\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-3\">\n");
      out.write("                        <a><i class=\"fa fa-5x fa-fw fa-facebook\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-3 text-center\">\n");
      out.write("                        <a><i class=\"fa fa-5x fa-fw fa-github\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
