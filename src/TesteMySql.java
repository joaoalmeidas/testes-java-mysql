
public class TesteMySql {

	public static void main(String[] args) {
		
		BancoDeDados banco = new BancoDeDados();
		
		banco.conectar();
		
		if(banco.estaConectado()) {
			
			banco.listarPalavras();
			
		}else {
			
			System.out.println("N�o foi poss�vel conectar com o banco.");
			
		}
	}

}
