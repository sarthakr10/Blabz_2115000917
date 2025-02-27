import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class Handlers {
    // Root Handler
    public static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Server started successfully</h1>" +
                    "<h1>Port: " + SimpleHttpServer.port + "</h1>";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // Handler to print request headers
    public static class EchoHeaderHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder response = new StringBuilder("<h1>Headers:</h1><ul>");
            for (Map.Entry<String, List<String>> entry : exchange.getRequestHeaders().entrySet()) {
                response.append("<li><b>").append(entry.getKey()).append(":</b> ")
                        .append(entry.getValue()).append("</li>");
            }
            response.append("</ul>");

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    // Handler to print query parameters
    public static class EchoGetHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String response = (query != null) ? "<h1>Query Parameters:</h1><p>" + query + "</p>" :
                    "<h1>No Query Parameters</h1>";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // Handler to print body parameters
    public static class EchoPostHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            byte[] requestBody = exchange.getRequestBody().readAllBytes();
            String response = "<h1>Request Body:</h1><p>" + new String(requestBody) + "</p>";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
