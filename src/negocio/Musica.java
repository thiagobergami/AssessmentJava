package negocio;

public class Musica {
	
	private int idMusica;
	private String musica;
	private String genero;
	private int idUser;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Musica(){
	
		
	}	
	public Musica(String musica,String genero, int idUser) {
		this.setMusica(musica);
		this.setGenero(genero);
		this.setIdUser(idUser);
			}
	
	public Musica(int idMusica, String musica, String genero, int idUser) {
		this(musica,genero, idUser);
		this.setIdMusica(idMusica);
	}
	
	public int getIdMusica() {
		return idMusica;
	}
	public void setIdMusica(int idMusica) {
		this.idMusica = idMusica;
	}
	public String getMusica() {
		return musica;
	}
	public void setMusica(String musica) {
		this.musica = musica;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
