package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Musica;
import negocio.Usuario;

public class MusicaDao {

public static List<Musica> obterListaPorUsuario(Usuario usuario){
		
		List<Musica> lista = new ArrayList<Musica>();		

		PreparedStatement ps = null;
		
		try {
			ps = Conexao.obterConexao().prepareStatement("SELECT * FROM musica where id_user = ? order by genero");
			ps.setInt(1, usuario.getId());
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				lista.add(new Musica(
						rs.getInt("id_musica"),
						rs.getString("musica"), 
						rs.getString("genero"),
						rs.getInt("id_user")));												
			}
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}



	
}
