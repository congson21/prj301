package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("       \n");
      out.write("            <meta charset=\"UTF-8\">\n");
      out.write("            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("            <link href=\"public/css/form.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("            <title>Update Product</title>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"title-header\">Update Product</div>\n");
      out.write("                <div class=\"form-add\">\n");
      out.write("                    <form action=\"update\" method=\"post\" id=\"updateForm\">\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>ID: </td>\n");
      out.write("                                <td class=\"right\"><input readonly=\"\" type=\"text\" name=\"pid\" id=\"upID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"background: #cdcdcd\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Name: </td>\n");
      out.write("                            <td class=\"right\"><input type=\"text\" name=\"name\" id=\"upName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"\" ></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Image: </td>\n");
      out.write("                            <td class=\"right\"><input type=\"text\" name=\"image\" id=\"upImg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"\" > </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Price: </td>\n");
      out.write("                            <td class=\"right\"><input type=\"number\" name=\"price\" id=\"upPrice\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"\" > VND</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <button type=\"submit\" class=\"add-btn\">SAVE</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            <div class=\"link\">\n");
      out.write("                <a href=\"home\">Back</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("    min-height: 100vh;\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("    background: grey;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("    width: 300px;\n");
      out.write("    background: white;\n");
      out.write("    border-radius: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".title-header {\n");
      out.write("    padding: 15px;\n");
      out.write("    background: rgb(41, 69, 69);\n");
      out.write("    color: white;\n");
      out.write("    text-align: center;\n");
      out.write("    border-radius: 10px 10px 0 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-add {\n");
      out.write("    padding: 15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table {\n");
      out.write("    margin: 10px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#addName,#addImg,#addPrice {\n");
      out.write("    width: 99%;\n");
      out.write("    height: 20px;\n");
      out.write("    padding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#upID,#upName,#upImg{\n");
      out.write("    width: 99%;\n");
      out.write("    height: 20px;\n");
      out.write("    padding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#upPrice{\n");
      out.write("    width: 50%;\n");
      out.write("    height: 20px;\n");
      out.write("    padding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".right {\n");
      out.write("    width: 100%;\n");
      out.write("    padding: 10px 0;\n");
      out.write("    font-size: 18px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".mess{\n");
      out.write("    color: red;\n");
      out.write("    padding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".add-btn {\n");
      out.write("    width: 100%;\n");
      out.write("    background-color: rgb(41, 69, 69);\n");
      out.write("    color: white;\n");
      out.write("    padding: 10px;\n");
      out.write("    border: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".link {\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a {\n");
      out.write("    text-decoration: none;\n");
      out.write("    color: black;\n");
      out.write("    padding: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a:hover {\n");
      out.write("    color: blue;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
