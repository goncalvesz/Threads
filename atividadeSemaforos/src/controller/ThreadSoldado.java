package controller;

import java.util.Random;

public class ThreadSoldado extends Thread {
	
	static int PosicaoChegada = 0;
	static int[] Portas = {0,0,0,0};
	static int PortaCerta = (int) (Math.random()*4);
	
	ThreadSoldado () {
		
	}
	
	public void run() {
		andando();
	}
	
	public void andando() {
		
		Random random = new Random();
		
		int Velocidade = random.nextInt(4);
		int DistanciaPercorrida = 0;
		int DistanciaMaxima = 2500;
		int PossuiTocha = 0;
		int PortaEscolhida = random.nextInt(4);
		
		if (Velocidade < 2) {
			Velocidade = 2;
		}
		if (Controller.tocha() == true) {
			Velocidade += 2;
			PossuiTocha=1;
			System.out.println("O cavaleiro " + Thread.currentThread().getId() + " Pegou a tocha");
		}
		
		while (DistanciaPercorrida < DistanciaMaxima) {
			DistanciaPercorrida += Velocidade;
			
			if (DistanciaPercorrida == 1500 && PossuiTocha==0) {
				if (Controller.pedra() == true) {
					Velocidade += 2;
					System.out.println("O cavaleiro " + Thread.currentThread().getId() + " Pegou a pedra");
				}
			}
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		while (Portas[PortaEscolhida] != 0) {
			PortaEscolhida = random.nextInt(4);
		}	
		
		Portas[PortaEscolhida] = 1;
		if (PortaEscolhida == PortaCerta) {
			System.out.println("O cavaleiro " + Thread.currentThread().getId() + " escolheu a porta "  + (PortaEscolhida+1) + " e venceu");
		} else {
			System.out.println("O cavaleiro " + Thread.currentThread().getId() + " escolheu a porta "  + (PortaEscolhida+1) + " e morreu");
		}
		
		PosicaoChegada++;
	}
	
}
