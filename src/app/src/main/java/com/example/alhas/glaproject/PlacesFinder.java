package com.example.alhas.glaproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.SupportMapFragment;

import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class PlacesFinder extends Activity {

    private static final String PLACE_URL_API ="https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
    private static final String GOOGLE_API_KEY = "AIzaSyDoPAIAMVrM_b4WxeQSS0j1KalXcf8S58o";
    private String origin;

    String recupAdresse1;
    String recupAdresse2;
    String recupAdresse3;

    private String createUrlForRestaurant() throws Exception {
        String[] str = getLatLongPositions(recupAdresse1);
        String lat = str[0];
        String lng = str[1];
        String loc = lat+","+lng;
        long rayon = 20000; // 20km
        return PLACE_URL_API + "location=" + loc + "&radius=" + rayon + "&type=restaurant" + "&keyword=halal" + "&key=" + GOOGLE_API_KEY;
    }

    private String createUrlForBar() throws Exception {
        String[] str = getLatLongPositions(recupAdresse1);
        String lat = str[0];
        String lng = str[1];
        String loc = lat+","+lng;
        long rayon = 20000; // 20km
        return PLACE_URL_API + "location=" + loc + "&radius=" + rayon + "&type=bar" + "&key=" + GOOGLE_API_KEY;
    }

    private String createUrlForNight_club() throws Exception {
        String[] str = getLatLongPositions(recupAdresse1);
        String lat = str[0];
        String lng = str[1];
        String loc = lat+","+lng;
        long rayon = 20000; // 20km
        return PLACE_URL_API + "location=" + loc + "&radius=" + rayon + "&type=night_club" + "&key=" + GOOGLE_API_KEY;
    }

    public void getRestaurantAddress() throws Exception {
        String getUrl = createUrlForRestaurant();
        URL url = new URL(getUrl);
        Scanner scan = new Scanner(url.openStream());
        String html_output = new String();
        while (scan.hasNext())
            html_output += scan.nextLine();
        scan.close();

        JSONObject jsonFile = new JSONObject(html_output);
        for (int i = 0 ; i < jsonFile.length() ; i++){
            JSONObject lieu = (jsonFile.getJSONArray("results")).getJSONObject (i);
            String res = lieu.getString ("name") + ", " + lieu.getString ("vicinity");
        }
    }

    public void getBarAddress() throws Exception {
        String getUrl = createUrlForBar();
        URL url = new URL(getUrl);
        Scanner scan = new Scanner(url.openStream());
        String html_output = new String();
        while (scan.hasNext())
            html_output += scan.nextLine();
        scan.close();

        JSONObject jsonFile = new JSONObject(html_output);
        for (int i = 0 ; i < jsonFile.length() ; i++){
            JSONObject lieu = (jsonFile.getJSONArray("results")).getJSONObject (i);
            String res = lieu.getString ("name") + ", " + lieu.getString ("vicinity");
        }
    }

    public void getNight_clubAddress() throws Exception {
        String getUrl = createUrlForNight_club();
        URL url = new URL(getUrl);
        Scanner scan = new Scanner(url.openStream());
        String html_output = new String();
        while (scan.hasNext())
            html_output += scan.nextLine();
        scan.close();

        JSONObject jsonFile = new JSONObject(html_output);
        for (int i = 0 ; i < jsonFile.length() ; i++){
            JSONObject lieu = (jsonFile.getJSONArray("results")).getJSONObject (i);
            String res = lieu.getString ("name") + ", " + lieu.getString ("vicinity");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des adresses
        Bundle extras = getIntent().getExtras();
        recupAdresse1 = extras.getString("send1");
        recupAdresse2 = extras.getString("send2");
        recupAdresse3 = extras.getString("send3");
    }

        public  String[] getLatLongPositions(String address) throws Exception
    {
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
        if(responseCode == 200)
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
            Document document = builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String)expr.evaluate(document, XPathConstants.STRING);
            if(status.equals("OK"))
            {
                expr = xpath.compile("//geometry/location/lat");
                String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
                return new String[] {latitude, longitude};
            }
            else
            {
                throw new Exception("Error from the API - response status: "+status);
            }
        }
        return null;
    }
}
