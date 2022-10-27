package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Senti message = getSentiment("めっちゃ楽しい！！");
		if (message != null) {
			System.out.println(message.documents[0].confidenceScores.negative);
			System.out.println(message.documents[0].confidenceScores.neutral);
			System.out.println(message.documents[0].confidenceScores.positive);
		}
	}

	static Senti getSentiment(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3b02-text.cognitiveservices.azure.com/" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "1972eec13da44eeab9008796a956a6f6");

		Docs doc = new Docs();
		doc.id = "1";
		doc.text = s;

		Src src = new Src();
		src.documents = new Docs[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		//InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		//JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		JsonReader reader = WebApiConnector.postJsonReader(url,map,jsonData);
		Senti message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Senti.class);
			reader.close();
		}
		return message;
	}

}

class Senti {
	Document[] documents;
	String[] errors;
	String modelVersion;
}

class Document {
	confidenceScores confidenceScores;
	String id ;
	//String[] sentences;
	String sentiment;
	//String[] warnings;
}

class confidenceScores {
	double negative;
	double neutral;
	double positive;
}

//class sentence {
//	targets[] targets;
//	confidenceScores confidenceScores;
//	int length;
//	int offset;
//	assessments[] assessments;
//	String sentiment;
//	String text;
//}

//class confidenceScoressentence{
//	double negative;
//	double neutral;
//	double positive;
//}

//class targets {
//	confidenceScores confidenceScores;
//	int length;
//	int offset;
//	relations[] relations;	
//	String sentiment;
//	String text;
//}

//class confidenceScorestarget{
//	double negative;
//	double positive;
//}

//class assessments{
//	confidenceScores confidenceScores;
//	boolean isNegated;
//	int length;
//	int offset;
//	String sentiment;
//	String text;
//}

//class confidenceScoresassessments{
//	double negative;
//	double positive;
//}

//class relations{
//	String ref;
//	String relationType;
//}

class Src {
	Docs[] documents;
}

class Doc {
	String id;
	String text;
}