package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {
	public static boolean incluir(Usuario usuario){
		PreparedStatement ps = null;
			
		try {
			ps = Conexao.obterConexao().prepareStatement("INSERT INTO user(nome, login, senha) VALUES (?,?,?)");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	public static boolean alterar(Usuario usuario){
		return true;
	}
	
	public static boolean excluir(int id){
		return true;
	}

	public static Usuario obterPorLogin(String login){
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.obterConexao().prepareStatement("SELECT * FROM user where login = ?");
			ps.setString(1, login);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if (rs.next()){
				return new Usuario(
						rs.getInt("id_user"),
						rs.getString("nome"), 
						rs.getString("login"), 
						rs.getString("senha"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Usuario obterPorId(int id){
		Usuario usuario = new Usuario();
		return usuario;
	}
	
}