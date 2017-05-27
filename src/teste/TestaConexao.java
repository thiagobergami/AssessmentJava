package teste;

import conexao.Conexao;
import dao.UsuarioDao;
import negocio.Usuario;

public class TestaConexao {

	public static void main(String[] args) {
		
		if (Conexao.obterConexao() != null){
			System.out.println("Conectou!!!");
			
//			Usuario u = new Usuario("Jose", "ze", "ze");			
//			UsuarioDao.incluir(u);
//			
//			Usuario u1 = new Usuario("Adriana", "ana", "ana");			
//			UsuarioDao.incluir(u1);
//
//			Usuario u2 = new Usuario("Elberth", "elberth", "moraes");			
//			UsuarioDao.incluir(u2);
			
//			if (UsuarioDao.valida(u)){
//				System.out.println(u.getNome());
//			} else {
//				System.out.println("Não achei!!!");
//			}
		} else {
			System.out.println("Erro!!!");
		}
	}
}
