package workingWithImages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FindBrokenImageWithoutBrowser {

	public static void main(String[] args) throws IOException {
        //Using Jsoup jar...
		Document doc = Jsoup.connect("https://test-store-es.vmware.com/").get();
		Elements images = doc.select("img");
		System.out.println(images.size());
		for (Element image : images) {
			String imageSrc = image.attr("src");

			URL url = new URL(imageSrc);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.connect();

			if (connection.getResponseCode() >= 400 || image.getElementsByAttribute("naturalWidth").equals("0")) {

				System.err.println(
						imageSrc + " >>" + connection.getResponseCode() + ">>" + connection.getResponseMessage());
			} else {
				System.out.println(
						imageSrc + " >>" + connection.getResponseCode() + ">>" + connection.getResponseMessage());
			}

		}

	}

}
