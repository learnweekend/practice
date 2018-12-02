import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * #55 : This problem was asked by Microsoft.

Implement a URL shortener with the following methods:

shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
restore(short), which expands the shortened string into the original url. 
If no such shortened string exists, return null.

Hint: What if we enter the same URL twice?
 *
 */
public class URLShortener {

	private String letters = null;  // all possible letter combinations
	private Map<String, String> cache = null;  // to store shortUrl and longUrl mapping
	private Random random = null;
	private int urlLength;  // max number of characters

	public URLShortener() {
		letters = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWZYZ";
		cache = new HashMap<>();
		random = new Random();
		urlLength = 6;  
	} 
	/*
	 *  Generate a random number and get the corresponding character from all possible letters
	 *  Repeat this 6 times and append the each character.
	 */
	public String encode(String longUrl) {
		
		if (longUrl == null || longUrl.length() == 0)
			throw new IllegalArgumentException("Long URL cannot be null or empty!");

		String shortUrl = null;
		do {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < urlLength; i++) {
				int rand = random.nextInt(62);
				sb.append(letters.charAt(rand));
			}
			shortUrl = sb.toString();
		} while (cache.containsKey(shortUrl));

		cache.put(shortUrl, longUrl);
		return shortUrl;
	}

	public String decode(String shortUrl) {
		
		if (shortUrl == null || shortUrl.length() == 0)
			throw new IllegalArgumentException("shortUrl cannot be null or empty!");

		if (shortUrl == null || shortUrl.length() == 0)
			return null;

		if (cache.containsKey(shortUrl))
			return cache.get(shortUrl);

		return null;
	}

	public static void main(String[] args) {
		String longUrl = "http://www.google.com";
		URLShortener obj = new URLShortener();
		String shortUrl = obj.encode(longUrl);
		System.out.println(shortUrl);
		System.out.println(obj.decode(shortUrl));
	}
}
