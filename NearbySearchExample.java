/*
  Exemple de requête de recherche de lieu
  * de type 'restaurant'
  * dans un rayon de 500 m
  * autour de la Place de la Bastille (coordonnées GPS décimales: 48.855218,2.368622)
  * contenant 'burger' dans le nom de l'enseigne
 */

/*
  Pour compiler et exécuter ce programme:
  > make
  > make run
 */

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.*;

class NearbySearchExample{

    // METTEZ ICI VOTRE CLE D'API DE GOOGLE PLACES
    private static String GooglePlacesKey = "AIzaSyBk44t10OMuQAhNhb9syvHraPrIkux3iAc";
    
    public static void main(String[] args) throws Exception{
	 // Lire une URL
	 URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=48.855218,2.368622&radius=500&type=restaurant&name=macaron&key=" + GooglePlacesKey);
	 Scanner scan = new Scanner(url.openStream());
	 String html_output = new String();
	 while (scan.hasNext())
	     html_output += scan.nextLine();
	 scan.close();

	 // Construire l'objet JSON
	 // Toute la documentation de la bibliothèque org.json est disponible sur https://stleary.github.io/JSON-java/index.html
	 JSONObject j = new JSONObject(html_output);

	 // Afficher
	 /*System.out.println ("J'ai envie d'un bon burger autour de Bastille !");
	 for (int i = 0 ; i < j.length() ; i++){
	     JSONObject lieu = (j.getJSONArray("results")).getJSONObject (i);
	     System.out.println ("  -> " + lieu.getString ("name") + ", " + lieu.getString ("vicinity"));
	 }
	 */
	 System.out.println ("I need to travel from Paris to Orsay !");
	     JSONObject dist = (j.getJSONArray("rows").getJSONObject (0));
	     for (int k = 0; k < dist.length(); k++) {
		 JSONObject arr = (dist.getJSONArray("elements").getJSONObject(k));
		 System.out.println (" -> " + arr.getJgetString ("distance") + ", " + arr.getString ("duration"));
	 }
	     
    }
}
