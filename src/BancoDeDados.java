import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		
		String servidor = "jbdc:mysql://localhost:3306/dicionario";
		String usuario = "root";
		String senha = "joao2293";
		String driver = "com.mysql.jbdc.Driver";
		
		try {
			
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		
		}catch(Exception e) {
			
			System.out.println("Erro: " + e.getMessage());
			
		}
		
	}
	
	public boolean estaConectado() {
		
		if(this.connection != null) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public void listarPalavras() {
		
		try {
			
			String query = "SELECT * FROM words";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				System.out.println("id: " + this.resultset.getString("word_id") + "Palavra: " + this.resultset.getString("word"));
			}
			
		}catch(Exception e) {
			
			System.out.println("Erro: " + e.getMessage());
			
		}
		
	}
	
	public void desconectar() {
		
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

}
