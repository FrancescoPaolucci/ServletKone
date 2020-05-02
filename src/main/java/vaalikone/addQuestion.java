package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.PreparedStatement;

/**
 * Servlet implementation class addQuestion
 */
@WebServlet("/addQuestion")
public class addQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public static int numberOfQuestions = 20;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try { 
			  
            // Initialize the database 
            java.sql.Connection con = DatabaseConnection.initializeDatabase(); 
  
            // Create a SQL query to insert data into demo table 
            // kysymykset table consists of two columns, so two '?' is used 
            java.sql.PreparedStatement st = con 
                   .prepareStatement("insert into kysymykset values(?, ?)"); 
            ResultSet rs = st.executeQuery("SELECT KYSYMYS_ID FROM kysymykset ORDER BY KYSYMYS_ID DESC LIMIT 1");
            java.sql.PreparedStatement addQ = con.prepareStatement("INSERT INTO VASTAUKSET VALUES  (1," + Vaalikone.numberOfQuestions + ", 3, \"ehdokkaan 1 vastaus kysymykseen " +Vaalikone.numberOfQuestions+ "\")");
            
            if (rs.next())
            {
              String placeOne = rs.getString("KYSYMYS_ID");
              st.setInt(1, Integer.valueOf(placeOne)+1);
              System.out.println(placeOne);
              Vaalikone.numberOfQuestions = Integer.valueOf(placeOne)+1;
            }
            Vaalikone.numberOfQuestions++;
            // Same for second parameter 
            st.setString(2, request.getParameter("question")); 
  
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate(); 
            addQ.executeUpdate();
            // Close all the connections 
            addQ.close();
            st.close(); 
            con.close(); 
  
            // Get a writer pointer  
            // to display the successful result 
            PrintWriter out = response.getWriter(); 
            out.println("<html><head><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"></head><body><div id=\"container\"><b>Successfully Inserted, we will review your question and it will then be added to the quiz"
                        + "</b>     <form action=\"Vaalikone\">  	\r\n" + 
                        "	<input type=\"submit\" id=\"submitnappi\" value=\"REDO QUIZ\" />\r\n" + 
                        "	</form></div></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}

}
