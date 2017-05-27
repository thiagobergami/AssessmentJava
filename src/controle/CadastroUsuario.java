package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicaDao;
import dao.UsuarioDao;
import negocio.Musica;
import negocio.Usuario;


public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CadastroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String meuLogin = request.getParameter("login");
		
		if(UsuarioDao.obterPorLogin(meuLogin) == null){

			String meuNome = request.getParameter("nome");
			String minhaSenha = request.getParameter("senha");
			
			
			Usuario novoUsuario = new Usuario(meuNome, meuLogin, minhaSenha);
			
			if(UsuarioDao.incluir(novoUsuario)){

				request.getRequestDispatcher("index.html").forward(request, response);
			}
		} else {
			request.setAttribute("oLogin", meuLogin);
			
			request.getRequestDispatcher("index.html").forward(request, response);
		}		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String meuLogin = request.getParameter("login");
		String minhaSenha = request.getParameter("senha");
					
		Usuario user = UsuarioDao.obterPorLogin(meuLogin);
		
		if(user != null){
			
			if(minhaSenha.equals(user.getSenha()) && meuLogin.equals(user.getLogin())){
				request.setAttribute("oNome", user.getNome());
				request.setAttribute("oId", user.getId());
				List<Musica> musicas = MusicaDao.obterListaPorUsuario(user);
				request.setAttribute("minhasMusicas", musicas);
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("index.html").forward(request,response);
			}
							
		}
	}

}
