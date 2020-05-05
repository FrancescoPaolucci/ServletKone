package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.Kysymykset;



public class daoQuest extends HttpServlet {
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		List<Kysymykset> kysymys=null;
		//take collection from DataBase
				EntityManagerFactory emf=null;
			        EntityManager em = null;
			        try {
			  	      emf=Persistence.createEntityManagerFactory("vaalikones");
			  	      em = emf.createEntityManager();
			        }
			        catch(Exception e) {
			          	response.getWriter().println("EMF+EM EI Onnistu");
			          	
			          	e.printStackTrace(response.getWriter());
			          	
			          	return;
			        }
			        
			        try {
		               
		                Query q = em.createQuery(
		                		"SELECT k FROM Kysymykset k");
		       
		                kysymys = q.getResultList();
		                //giving collection to send
		               

		            } finally {
		                // Sulje tietokantayhteys
		                if (em.getTransaction().isActive()) {
		                   //em.getTransaction().commit();
		                }
		               
		            }
			        
			        
		if( request.getParameter("Edit")!=null) {
			Integer id=Integer.parseInt(request.getParameter("kysymysId"));
			String kysymyss =request.getParameter("kysymys");
			Kysymykset k = new Kysymykset(id);
			for(Kysymykset eh: kysymys) {
				if(eh.getKysymysId().equals(id)) {k=eh;}
			}
		
			if(request.getParameter("kysymys")!=null) {
				k.setKysymys(kysymyss);
			
			
			//e.setEhdokasId(51);
			em.getTransaction().begin();
			//em.persist(kysy);
			em.merge(k);
			
			
			em.getTransaction().commit();
			
			System.out.println("Edit edit");	
		}
		}
	
		
		
		if( request.getParameter("Del")!=null) {
			System.out.println("Delete delete");
			Integer id=Integer.parseInt(request.getParameter("kysymysId"));
			String kysymyss =request.getParameter("kysymys");
			Kysymykset k = new Kysymykset(id);
			for(Kysymykset eh: kysymys) {
				if(eh.getKysymysId().equals(id)) {k=eh;}
			}
	
			em.getTransaction().begin();
			em.remove(k);
			em.getTransaction().commit();
		}
		
		if( request.getParameter("Add")!=null) {
			
			Kysymykset k = new Kysymykset(Integer.parseInt(request.getParameter("kysymysId")));
			k.setKysymys(request.getParameter("kysymys"));
			
			if(request.getParameter("kysymys")!=null&&!request.getParameter("kysymys").equals("")) {
				k.setKysymys(request.getParameter("kysymys"));
				
			em.getTransaction().begin();
			boolean b=true;
			for(Kysymykset eh: kysymys) {
				if(eh.getKysymysId().equals(eh.getKysymysId())) {b=false;}
			}
			
			if(b) {
			em.persist(k);}
			else {em.merge(k);}
			
			
			
			em.getTransaction().commit();
			System.out.println("Add");

	        } 
	     
				
		
		 try {
             //Hae haluttu kysymys tietokannasta
             Query q = em.createQuery(
            		 "SELECT k FROM Kysymykset k");
            // q.setParameter(1, kysymys_id);
             //Lue haluttu kysymys listaan
             kysymys = q.getResultList();
             //передаем коолекцию в запрос
            

         } finally {
             // Sulje tietokantayhteys
             if (em.getTransaction().isActive()) {
                // em.getTransaction().commit();
             }}
            
		}
	       request.setAttribute("Kysymykset", kysymys);
            //пеердаем запрос в страницу jsp
            request.getRequestDispatcher("ManageQuestions.jsp")
                    .forward(request, response);
		
	        
		
		
	}
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fol
    
    
    

}
