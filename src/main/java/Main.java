import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.io.IOUtils;

import javax.lang.model.util.Types;
import java.io.IOException;
import java.net.InetAddress;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;
import com.fasterxml.jackson.databind.*;

public class Main {
    private static  final String os = System.getProperty("os.name").toLowerCase();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Write a ip address");
        Scanner scanner = new Scanner(System.in);
        String address_input = scanner.nextLine();
        scanner.close();
        String traceRt = (traceRoute(address_input));
        List<String> addresses = getAddressesFromTR(traceRt);
        addresses.remove(0);
        for (String address: addresses) {
            System.out.println(parseJsonInfo(getInfoAboutAddress(address)));
        }
    }

    public static String getInfoAboutAddress(String address) throws IOException, InterruptedException {
        String url_str = "https://ipinfo.io/"+address+"/json";
        URI url = URI.create(url_str);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(url).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String parseJsonInfo(String jsonResponse) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Post post = objectMapper.readValue(jsonResponse,new TypeReference<Post>(){});
        return post.toString();
    }

    public static List<String> getAddressesFromTR(String addresses){
        Pattern pattern = Pattern.compile("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}");
        Matcher matcher = pattern.matcher(addresses);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.group());
        }
        return list;
    }

    public static String traceRoute(String address) {
        String route = "";
        try {
            Process traceRt;
            if (os.contains("win")) traceRt = Runtime.getRuntime().exec("tracert -w 150 -h 15 " + address);
            else traceRt = Runtime.getRuntime().exec("traceroute " + address);
            route = IOUtils.toString(traceRt.getInputStream(), Charset.defaultCharset());
            String errors = IOUtils.toString(traceRt.getErrorStream(), Charset.defaultCharset());
            if (!errors.equals("")) System.out.println(errors);
        } catch (IOException e) {
            System.out.println(e);
        }
        return route;
    }
}
