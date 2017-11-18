package fbd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fbd.dao.VillanoDAO;
import fbd.dao.VillanoDAOlmpl;
import fbd.model.Villano;

/**
 * Servlet implementation class VillanoController
 */
@WebServlet("/VillanoController")
public class VillanoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Villano villano;
     private List<Villano> villanos;
   	private VillanoDAO villanoDAO;
   	private List<String> ids = new ArrayList<String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VillanoController() {
        super();
        villano = new Villano();
        villanos = new ArrayList<Villano>();
        villanoDAO = new VillanoDAOlmpl();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save") != null) {
			villano.setColorBigote(request.getParameter("colorbigote"));
			villano.setColorSombrero(request.getParameter("colorsombrero"));
			villano.setAspecto(request.getParameter("aspecto"));
		
			
			System.out.println("save");
			if (villano.getId()==0) {
				System.out.println("save");
				villanoDAO.createVillano(villano);
			} else {
				System.out.println("save");
				villanoDAO.updateVillano(villano);
			}
			villanos = villanoDAO.readAllVillanos();
			request.setAttribute("villanos", villanos);
			request.getRequestDispatcher("villano_list.jsp").forward(request, response);
		}else if(request.getParameter("btn_new")!=null) {
			villano = new Villano();
			request.getRequestDispatcher("villano_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				villano = villanoDAO.readVillano(id);	
			}catch (IndexOutOfBoundsException e) {
				villano = new Villano();
			}
		 request.setAttribute("villano", villano);
		 request.getRequestDispatcher("villano_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				villanoDAO.deleteVillano(id);
				villanos = villanoDAO.readAllVillanos();
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("villanos", villanos);
			request.getRequestDispatcher("villano_list.jsp").forward(request, response);
		}else {
			villanos = villanoDAO.readAllVillanos();
			request.setAttribute("villanos", villanos);
			request.getRequestDispatcher("villano_list.jsp").forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
