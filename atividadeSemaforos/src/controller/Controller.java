package controller;
/*
 * 4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor �
escuro, tem 2 km e em 500 m, h� uma �nica tocha. O cavaleiro que pegar a tocha, aumenta sua
velocidade, somando mais 2 m por 50 ms ao valor que j� fazia. Em 1,5 km, existe uma pedra
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50 ms
ao valor que j� fazia (O cavaleiro que j� det�m a tocha n�o poder� pegar a pedra). Ao final dos 2
km,, os cavaleiros se deparam com 4 portas e, um por vez pega uma porta aleat�ria (que n�o pode
repetir) e entra nela. Apenas uma porta leva � sa�da. As outras 3 tem monstros que os devoram.
 */
public class Controller {
	private static int tocha;
	private static int pedra;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 4 ; i++) {
			ThreadSoldado thread = new ThreadSoldado();
			thread.start();
		}
		
	}
	
	public static boolean tocha() {
		if (tocha == 0) {
			tocha++;
			return true;
		}
		return false;
	}
	
	public static boolean pedra() {
		if (pedra == 0) {
			pedra++;
			return true;
		}
		return false;
	}

}
