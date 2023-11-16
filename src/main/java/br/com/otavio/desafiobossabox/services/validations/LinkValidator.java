package br.com.otavio.desafiobossabox.services.validations;


import br.com.otavio.desafiobossabox.services.exceptions.InvalidLinkException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class LinkValidator {
    public static boolean isValid (String link) throws IOException {

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(link);
            HttpResponse response = client.execute(request);

            return response.getStatusLine().getStatusCode() == 200;
    }
}
