package com.pfe.ecredit.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmailAccountCreation(String email, String name, String password) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Demande de credit");
		mail.setText("Bonjour Monsieur/Madame "+name+", \n\n"
				+ "Votre compte E-credit à été créé avec succées.\n"
				+ "Vous pouvez se connecter à travers votre cin et le mot de passe suivant:\n"
				+ "Mot de passe: "+ password +"\n\n"
				+ "Application E-credit GTI - 2022");

		
		javaMailSender.send(mail);
	}
	
	public void sendEmailInsertion(String email, String name, Integer idDemande) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Demande de credit");
		mail.setText("Bonjour Monsieur/Madame "+name+", \n\n"
				+ "Nous vous informons que votre dossier du numero "+idDemande+" a été déposé avec succées. \n"
				+ "Vous recevrez un mail dés que votre demande sera traité\n"
				+ "A bientôt. \n"
				+ "\n"
				+ "Application E-credit GTI - 2022");

		
		javaMailSender.send(mail);
	}
	

	public void sendEmailComplement(String email, String name, String complement, Integer idDemande) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Demande de complément : Dossier credit");
		mail.setText("Bonjour Monsieur/Madame "+name+", \n\n"
				+ "Nous vous informons que votre dossier du numero "+idDemande+" requiert un complément. \n"
				+ "Les documents nécessaires sont les suivants : \""+complement+"\"\n"
				+ "Merci pour votre comprehension. \n"
				+ "\n"
				+ "Application E-credit GTI - 2022");

		
		javaMailSender.send(mail);
	}
	
	public void sendEmailRejection(String email,String name, Integer idDemande) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Dossier rejeté : Demande credit");
		mail.setText("Bonjour Monsieur/Madame "+name+", \n\n"
				+ "Nous regrettons de vous informer que votre dossier du numero "+idDemande+" a été rejeté. \n"
				+ "Vous pouvez nous contacter pour plus de détails concernant votre demande.\n"
				+ "Merci pour votre comprehension. \n"
				+ "\n"
				+ "Application E-credit GTI - 2022");

		
		javaMailSender.send(mail);
	}
	
	public void sendEmailRDV(String email, String name,LocalDateTime rdv, Integer idDemande) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String date = rdv.format(formatter);
		mail.setTo(email);
		mail.setSubject("Demande de credit : Rendez-vous");
		mail.setText("Bonjour Monsieur/Madame "+name+", \n\n"
				+ "Nous vous informons que votre dossier du numero "+idDemande+" a été validé. \n"
				+ "Rendez-vous le : "+date+" chez notre agence pour finir les procedures de votre demandes\n"
				+ "Merci pour votre service. \n"
				+ "\n"
				+ "Application E-credit GTI - 2022");

		
		javaMailSender.send(mail);
	}

}
