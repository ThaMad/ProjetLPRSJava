package manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import model.Classe;
import model.DemandeStockFournisseur;
import model.Eleve;
import model.Rdv;
import model.Stock;
import model.User;
import view.accueil;
import view.actionStock;
import view.gestionAdministrative;
import view.gestionClasseAdmin;
import view.gestionEleveAdmin;
import view.gestionprofil;
import view.gestionstock;
import view.inscription;
import view.mdpOublier;
import view.profiladministratif;
import view.profilprof;
import view.rendezvous;

public class manager_thomas {
	
	private Connection dbh;
	
	public Connection bdd(){
	 	 this.dbh = null;
	 	     String url="jdbc:mysql://localhost/lprs_java?serverTimezone=UTC";
	 	 	 String user="root";
	 	 	 String password="";
			

	 	 	 try {
			

	 	 	 this.dbh = DriverManager.getConnection(url,user, password);
	 	 	 System.out.println(this.dbh.isClosed()?"ferme":"ouverte");
	 	 	 }
			

	 	 	 catch (SQLException e) {
	 	 	 System.out.println("Une erreur est survenue lors de la connexion la base de donnes");
	 	 	 e.printStackTrace();
	 	 	 }
			

	 	 	 return this.dbh;
}
	
	public static void sendMessage(String subject, String text, String destinataire) throws Exception {
	    // 1 -> Création de la session
	    Properties properties = new Properties();
	    properties.setProperty("mail.smtp.auth", "true");
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	    properties.setProperty("mail.smtp.port", "587");

	    String emailSender = "projet.php.lprs@gmail.com";
	    String mdpSender = "wrgeauzunuomxpvo";

	    Session session = Session.getInstance(properties, new Authenticator() {
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(emailSender, mdpSender);
	    }
	    });

	    Message message = prepareMessage(session, emailSender, destinataire, subject,text);

	    Transport.send(message);
	    }

	    private static Message prepareMessage(Session session, String email, String destinataire, String subject, String text) {
	    try {
	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(email));
	    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
	    message.setSubject(subject);
	    message.setText(text);
	    return message;
	    } catch (Exception e) {
	    e.printStackTrace();
	    }
	    return null;
	    }

	
	public void inscription(User a) throws Exception {
   		this.dbh=  bdd();
   		StringBuffer sb = null;
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT idUser FROM user ORDER BY idUser ASC");
  			     int id = 0;
				   while(resultat.next()) {
  				       id=resultat.getInt("idUser");
  					   id++;
  			   }
				   String mdp = a.getMdp();
				   MessageDigest md = null;
				try {
				md = MessageDigest.getInstance("MD5");
			       md.update(mdp.getBytes());
			       byte byteData[] = md.digest();

			        //convertir le tableau de bits en une format hexadï¿½cimal - mï¿½thode 1
			        sb = new StringBuffer();
			        for (int i = 0; i < byteData.length; i++) {
			         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			        }
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int insert =stm.executeUpdate("INSERT INTO user VALUES('"+id+"','"+a.getNom()+"','"+a.getPrenom()+"','"+a.getMail()+"','"+sb.toString()+"','"+a.getProfil()+"','"+0+"')");
			if(insert == 1) {
				accueil accueil = new accueil();
				accueil.run();
				sendMessage("Inscription", "Bienvenue au Lycee LPRS", a.getMail());
			}
			else {
				inscription inscription = new inscription();
				inscription.run();
			}
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void connexion(User a) {
   		this.dbh=  bdd();
   		String co = null;
   		StringBuffer sb = null;
   		try {
  		java.sql.Statement stm= this.dbh.createStatement();
  		String mdp = a.getMdp();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
	       md.update(mdp.getBytes());
	       byte byteData[] = md.digest();

	        //convertir le tableau de bits en une format hexadï¿½cimal - mï¿½thode 1
	        sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultat= stm.executeQuery("SELECT mail,profil FROM user WHERE mail =('"+a.getMail()+"') AND mdp =('"+sb.toString()+"')");
		if (resultat.next()) {
			co = "reussi";
			if(resultat.getString("profil").equals("Professeur") ){
				profilprof profilprof = new profilprof();
				profilprof.run();
			}
			if(resultat.getString("profil").equals("Administratif")) {
				profiladministratif profiladministratif = new profiladministratif();
				profiladministratif.run();
			}
		}
	}
   		catch(SQLException e1) {
  			e1.printStackTrace();
  			accueil accueil = new accueil();
			accueil.run();
  		}
   		if(co=="reussi") {
   			System.out.println("vous etes connecte");
   		}
	}
	
	public void modifProfil(User a, String mail) {
   		this.dbh=  bdd();
		 try {
      			java.sql.Statement stm= this.dbh.createStatement();
				   // je recupere id_film de la classe film en fonction du nom film choisi 
      			 ResultSet result= stm.executeQuery("SELECT idUser FROM user WHERE mail='"+mail+"'");
				   int id1 = 0;
				   if(result.next()) {
					    id1 = result.getInt("idUser");
				   }
				   // je modifie ma table client dans ma base de donnï¿½es en fonction du mail recuperer
  			
  		int update =stm.executeUpdate("UPDATE user SET idUser='"+id1+"', nom='"+a.getNom()+"', prenom='"+a.getPrenom()+"', mail='"+a.getMail()+"' WHERE idUser=('"+id1+"')");
  		if(update == 1) {
  			gestionprofil gestionprofil = new gestionprofil();
  			gestionprofil.run();
  		} else {
  			profiladministratif profiladministratif = new profiladministratif();
  			profiladministratif.run();
  		}
      		}
  		catch(SQLException e1) {
  			e1.printStackTrace();
  		}
	}	

	
	public void addStock(Stock s) {
   		this.dbh=  bdd();
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT idStock FROM stock ORDER BY idStock ASC");
  			     int id = 0;
				   while(resultat.next()) {
  				       id=resultat.getInt("idStock");
  					   id++;
  			   }
			int insert =stm.executeUpdate("INSERT INTO stock VALUES('"+id+"','"+s.getLibelle()+"','"+s.getNbrStock()+"')");
			if(insert == 1) {
				gestionstock gestionstock = new gestionstock();
				gestionstock.run();
			}
			else {
				actionStock actionStock = new actionStock();
				actionStock.run();
			}
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void modifStock(Stock s, int idStock) {
   		this.dbh=  bdd();
		 try {
      			java.sql.Statement stm= this.dbh.createStatement();
      			
				   // je modifie ma table client dans ma base de donnï¿½es en fonction du mail recuperer
  			
  		int update =stm.executeUpdate("UPDATE stock SET libelle='"+s.getLibelle()+"', nbrStock='"+s.getNbrStock()+"' WHERE idStock=('"+idStock+"')");
  		if(update == 1) {
  			gestionstock gestionstock = new gestionstock();
			gestionstock.run();
  		} else {
  			actionStock actionStock = new actionStock();
			actionStock.run();
  		}
      		}
  		catch(SQLException e1) {
  			e1.printStackTrace();
  		}
	}
	
	public void sendDemande(DemandeStockFournisseur d) {
   		this.dbh=  bdd();
		 try {
      			java.sql.Statement stm= this.dbh.createStatement();
      			ResultSet resultat= stm.executeQuery("SELECT idDemande FROM demande_fournisseur");
 			     int id = 0;
				   while(resultat.next()) {
 				       id=resultat.getInt("idDemande");
 					   id++;
 			   }
      			
				   // je modifie ma table client dans ma base de donnï¿½es en fonction du mail recuperer

    	int insert =stm.executeUpdate("INSERT INTO demande_fournisseur VALUES('"+id+"','"+d.getIdFourni()+"','"+d.getIdUser()+"','"+d.getNbrStock()+"','"+0+"','"+d.getIdStock()+"')");

  		if(insert == 1) {
  			gestionstock gestionstock = new gestionstock();
			gestionstock.run();
  		} else {
  			actionStock actionStock = new actionStock();
			actionStock.run();
  		}
      		}
  		catch(SQLException e1) {
  			e1.printStackTrace();
  		}
	}
	
	public void addEleve(Eleve a) {
   		this.dbh=  bdd();
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT idEleve FROM eleve ORDER BY idEleve ASC");
  			     int id = 0;
				   while(resultat.next()) {
  				       id=resultat.getInt("idEleve");
  					   id++;
  			   }
		    ResultSet resultat1= stm.executeQuery("SELECT idClasse FROM classe WHERE libelle =('"+a.getClasse()+"')"); 
		    if(resultat1.next()) {
			int idClasse = resultat1.getInt("idClasse");
			int insert =stm.executeUpdate("INSERT INTO eleve VALUES('"+id+"','"+a.getNom()+"','"+a.getPrenom()+"','"+idClasse+"')");
			if(insert == 1) {
				gestionAdministrative gestionAdministrative = new gestionAdministrative();
				gestionAdministrative.run();
			}
			else {
				gestionEleveAdmin gestionEleveAdmin = new gestionEleveAdmin();
				gestionEleveAdmin.run();
			}
		    }
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void suppEleve(Eleve a) {
   		this.dbh=  bdd();
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
		    int resultat = stm.executeUpdate("DELETE FROM eleve WHERE nom =('"+a.getNom()+"')"); 
		    if(resultat == 1) {
				gestionAdministrative gestionAdministrative = new gestionAdministrative();
				gestionAdministrative.run();
			} else {
				gestionEleveAdmin gestionEleveAdmin = new gestionEleveAdmin();
				gestionEleveAdmin.run();
			}
		    } catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void modifEleve(Eleve s, int idEleve) {
   		this.dbh=  bdd();
		 try {
      			java.sql.Statement stm= this.dbh.createStatement();
      			
				   // je modifie ma table client dans ma base de donnï¿½es en fonction du mail recuperer
      			ResultSet resultat1= stm.executeQuery("SELECT idClasse FROM classe WHERE libelle =('"+s.getClasse()+"')"); 
    		    if(resultat1.next()) {
    			int idClasse = resultat1.getInt("idClasse");
    			int update =stm.executeUpdate("UPDATE eleve SET nom='"+s.getNom()+"', prenom='"+s.getPrenom()+"',  classe='"+idClasse+"' WHERE idEleve=('"+idEleve+"')");
    			if(update == 1) {
    				gestionAdministrative gestionAdministrative = new gestionAdministrative();
    				gestionAdministrative.run();
    				} else {
    					gestionEleveAdmin gestionEleveAdmin = new gestionEleveAdmin();
    					gestionEleveAdmin.run();
    					}
  		}
      		}
  		catch(SQLException e1) {
  			e1.printStackTrace();
  		}
	}
	
	public void addNewClasse(Classe a) {
   		this.dbh=  bdd();
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT idClasse FROM classe ORDER BY idClasse ASC");
  			     int id = 0;
				   while(resultat.next()) {
  				       id=resultat.getInt("idClasse");
  					   id++;
  			   }
		    ResultSet resultat1= stm.executeQuery("SELECT idUser FROM user WHERE nom =('"+a.getProfPrincipale()+"')"); 
		    if(resultat1.next()) {
			int idUser = resultat1.getInt("idUser");
			int insert =stm.executeUpdate("INSERT INTO classe VALUES('"+id+"','"+a.getLibelle()+"','"+idUser+"')");
			if(insert == 1) {
				gestionAdministrative gestionAdministrative = new gestionAdministrative();
				gestionAdministrative.run();
			}
			else {
				gestionClasseAdmin gestionClasseAdmin = new gestionClasseAdmin();
				gestionClasseAdmin.run();
			}
		    }
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void suppClasse(Classe a) {
   		this.dbh=  bdd();
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
  			int update = stm.executeUpdate("UPDATE eleve INNER JOIN classe ON classe.idClasse = eleve.classe set classe = null WHERE libelle = ('"+a.getLibelle()+"')");
		    ResultSet resultat1= stm.executeQuery("SELECT idClasse FROM classe WHERE libelle =('"+a.getLibelle()+"')"); 
		    if(resultat1.next()) {
  			int update2 = stm.executeUpdate("DELETE FROM profclasse WHERE Classe = ('"+resultat1.getInt("idClasse")+"')");
		    }
		    int resultat = stm.executeUpdate("DELETE FROM classe WHERE libelle =('"+a.getLibelle()+"')"); 
		    if(resultat == 1) {
				gestionAdministrative gestionAdministrative = new gestionAdministrative();
				gestionAdministrative.run();
			} else {
				gestionClasseAdmin gestionClasseAdmin = new gestionClasseAdmin();
				gestionClasseAdmin.run();
			}
		    } catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void modifClasse(Classe s, int idClasse) {
   		this.dbh=  bdd();
		 try {
      			java.sql.Statement stm= this.dbh.createStatement();
      			
				   // je modifie ma table client dans ma base de données en fonction du mail recuperer
      			ResultSet resultat1= stm.executeQuery("SELECT idUser FROM user WHERE nom =('"+s.getProfPrincipale()+"')"); 
    		    if(resultat1.next()) {
    			int idUser = resultat1.getInt("idUser");
    			int update =stm.executeUpdate("UPDATE classe SET libelle='"+s.getLibelle()+"', id_prof_principale='"+idUser+"' WHERE idClasse=('"+idClasse+"')");
    			if(update == 1) {
    				gestionAdministrative gestionAdministrative = new gestionAdministrative();
    				gestionAdministrative.run();
    				} else {
    					gestionClasseAdmin gestionClasseAdmin = new gestionClasseAdmin();
    					gestionClasseAdmin.run();
    					}
  		}
      		}
  		catch(SQLException e1) {
  			e1.printStackTrace();
  		}
	}
	
	public void newMdp(User u) throws Exception {
		this.dbh=  bdd();
   		StringBuffer sb = null;
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  		
				   String mdp = u.getMdp();
				   MessageDigest md = null;
				try {
				md = MessageDigest.getInstance("MD5");
			       md.update(mdp.getBytes());
			       byte byteData[] = md.digest();

			        //convertir le tableau de bits en une format hexadï¿½cimal - mï¿½thode 1
			        sb = new StringBuffer();
			        for (int i = 0; i < byteData.length; i++) {
			         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			        }
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int update =stm.executeUpdate("UPDATE user SET mdp = ('"+sb.toString()+"') WHERE mail = ('"+u.getMail()+"') ");
			if(update == 1) {
				accueil accueil = new accueil();
				accueil.run();
				sendMessage("Nouveau Mail", "Vous avez changez de mail votre nouveau mail est :"+u.getMdp(), u.getMail());
			}
			else {
				mdpOublier mdpOublier = new mdpOublier();
				mdpOublier.run();
			}
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public void addRdv(Rdv rdv) throws Exception {
		this.dbh=  bdd();
		int idProf = 0;
		int idPadre = 0;
		int idHoraire = 0;
		String mailPadre = null;
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			ResultSet result= stm.executeQuery("SELECT idRdv FROM rdv ORDER BY idRdv ASC");
			     int id = 0;
			   while(result.next()) {
				       id=result.getInt("idRdv");
					   id++;
			   }
  			ResultSet resultat= stm.executeQuery("SELECT idUser FROM user WHERE mail =('"+rdv.getProf_principale()+"')"); 
  			if(resultat.next()){
  				idProf = resultat.getInt("idUser");
  			}
  			ResultSet resultat1= stm.executeQuery("SELECT idParent,mail FROM parent WHERE nom =('"+rdv.getParent()+"')"); 
  			if(resultat1.next()) {
  				idPadre = resultat1.getInt("idParent");
  				mailPadre = resultat1.getString("mail");
  			}
  			ResultSet resultat2= stm.executeQuery("SELECT idHoraire FROM horaire WHERE heure =('"+rdv.getHoraire()+"')"); 
  			if(resultat2.next()) {
  				idHoraire = resultat2.getInt("idHoraire");
  			}

			int insert =stm.executeUpdate("INSERT INTO rdv VALUES('"+id+"','"+rdv.getLibelle()+"','"+rdv.getDate()+"','"+idPadre+"','"+idProf+"','"+idHoraire+"')");
  		
			if(insert == 1) {
				profilprof profilprof = new profilprof();
				profilprof.run();
				sendMessage(rdv.getLibelle(), "Bonjour nous vous proposons une rendez vous pour le :"+rdv.getDate()+" à "+rdv.getHoraire()+" merci de nous repondre au plus vite de votre disponibilité.", mailPadre );
			}
			else {
				rendezvous rendezvous = new rendezvous();
				rendezvous.run();
			}
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	
}
