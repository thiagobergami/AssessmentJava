package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicaDao;
import negocio.Musica;

public class CadastroMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CadastroMusic() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicaNome = request.getParameter("musica");
		String generoMusica = request.getParameter("genero");
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		
		Musica musica = new Musica(musicaNome, generoMusica, idUser);
		
		if(MusicaDao.incluir(musica)){

			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}
		
	}

}
