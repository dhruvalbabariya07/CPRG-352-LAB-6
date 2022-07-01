package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        
         String username = request.getParameter("username");
         String action = (String) request.getParameter("action");
        if (action!=null && action.equals("logout")) {
            session = request.getSession(false);
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }        
        if((username == null||username.equals(""))&&session==null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
         if(session!=null&&session.getAttribute("username")!=null){
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response); 
            request.setAttribute("username",username);
            return;}
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response); 
    }
     // adding an item in the arraylist
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        String username = request.getParameter("username");
           
        if (action.equals("register")) {
            HttpSession session=request.getSession();
            session.setAttribute("username",request.getParameter("username"));
            request.setAttribute("username",session.getAttribute("username"));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response); 
            return;
        }
        if(action.equals("Add")) {
            String addItem = (String) request.getParameter("itemName");
            HttpSession session=request.getSession(false);
            ArrayList<String> items = (ArrayList) session.getAttribute("items");
            if(items == null) {
           items = (ArrayList) new ArrayList<>();
            }
                items.add(addItem);
                session.setAttribute("items", items);
                request.setAttribute("List",items);
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response); 
          return;
        }
      if(action.equals("Delete")) {
            String deleteItem = request.getParameter("item");
            HttpSession session=request.getSession(false);
            ArrayList<String> items = (ArrayList) session.getAttribute("items");
            if(items != null){
                for(int i=0; i<items.size(); i++) {
                    if(items.get(i).equals(deleteItem)) 
                    {
                        items.remove(i);
                }  
            }
          session.setAttribute("items", items);
          request.setAttribute("List",items);
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp") .forward(request,response); 
        }
        }
    }
}
