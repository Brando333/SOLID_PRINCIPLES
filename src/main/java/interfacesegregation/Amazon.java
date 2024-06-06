package interfacesegregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon implements CloudProvider {

    private Map<String, byte[]> storage = new HashMap<>();
    private List<String> servers = new ArrayList<>();
    private String cdnAddress = "https://amazon-cdn.example.com";

    @Override
    public void almacenarArchivo(String name, byte[] data) throws CloudProviderException {
        if (name == null || name.isEmpty()) {
            throw new CloudProviderException("Invalid file name.");
        }
        if (data == null || data.length == 0) {
            throw new CloudProviderException("Invalid file data.");
        }
        storage.put(name, data);
        System.out.println("File " + name + " stored in Amazon.");
    }

    @Override
    public byte[] conseguirArchivo(String name) throws CloudProviderException {
        if (name == null || name.isEmpty()) {
            throw new CloudProviderException("Invalid file name.");
        }
        byte[] data = storage.get(name);
        if (data == null) {
            throw new CloudProviderException("File not found in Amazon.");
        }
        System.out.println("Getting file " + name + " from Amazon.");
        return data;
    }

    @Override
    public void crearServidor(String region) throws CloudProviderException {
        if (region == null || region.isEmpty()) {
            throw new CloudProviderException("Invalid region.");
        }
        servers.add(region);
        System.out.println("Server created in region " + region + " in Amazon.");
    }

    @Override
    public List<String> listarServidores(String region) throws CloudProviderException {
        if (region == null || region.isEmpty()) {
            throw new CloudProviderException("Invalid region.");
        }
        List<String> regionServers = new ArrayList<>();
        for (String server : servers) {
            if (server.equals(region)) {
                regionServers.add(server);
            }
        }
        System.out.println("Listing servers in region " + region + " in Amazon.");
        return regionServers;
    }

    @Override
    public String obtenerDireccionCDN() throws CloudProviderException {
        System.out.println("Getting CDN address from Amazon.");
        return cdnAddress;
    }
}
