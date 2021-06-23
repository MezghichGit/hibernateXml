package main;

import java.util.List;
import java.util.Scanner;

import dao.DaoClient;
import entities.Client;

public class Principale {

	public static void main(String[] args) {
		/*
		
		//STEP 1 : On va lire les données depuis le clavier
		
		Scanner lect = new Scanner(System.in);
		
		//Saisi de l'id du client
		System.out.println("Donner un ID");
		int idC = lect.nextInt();
		
		//Saisi du nom du client
		System.out.println("Donner le nom");
		String nom = lect.next();
		
		//Saisi du prenom du client
		System.out.println("Donner le prenom");
		String prenom = lect.next();
		
		//STEP 2 : On va créer un Objet Client avec ces données saisi
		Client c = new Client(idC,nom,prenom);
		
		//STEP 3 : Appeler l'objet DAO
		
		DaoClient daoclient = new DaoClient();
		
		
		//STEP 4 : On persist
		daoclient.addClient(c);
		
		*/
		
		//Recherche d'un Client par son code
		DaoClient daoclient = new DaoClient();
		//Client res = daoclient.getClient(400);
		//Client res = daoclient.deleteClient(2000);
		//Client res = daoclient.updateClient(500,"François");
		//List<Client> res = daoclient.getAllClient();
		//System.out.println(res.size());
		
		List<Client> res = daoclient.getAllClientDesc();
		for(Client c : res)
		{
			System.out.println(c);
		}
		System.out.println(daoclient.getCountClient());
		//System.out.println(res.toString());
		//System.out.println(res);

	}

}
