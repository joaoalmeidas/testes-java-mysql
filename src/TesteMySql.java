
public class TesteMySql {

	public static void main(String[] args) {
		
		BancoDeDados banco = new BancoDeDados();
		
		banco.conectar();
		
		if(banco.estaConectado()) {
			
			banco.corrigeColunaXml();
			
			banco.desconectar();
			
		}else {
			
			System.out.println("N�o foi poss�vel conectar com o banco.");
			
		}
		
		
	}

}
