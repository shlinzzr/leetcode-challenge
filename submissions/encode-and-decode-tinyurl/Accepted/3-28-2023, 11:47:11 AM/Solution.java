// https://leetcode.com/problems/encode-and-decode-tinyurl

public class Codec {
    Map<String, String> tinyToLong = new HashMap<String, String>();
    Map<String, String> longToTiny = new HashMap<String, String>();
    static String BASE_HOST = "http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToTiny.containsKey(longUrl)) return BASE_HOST + longToTiny.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (tinyToLong.containsKey(key));
        tinyToLong.put(key, longUrl);
        longToTiny.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyToLong.get(shortUrl.replace(BASE_HOST, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));