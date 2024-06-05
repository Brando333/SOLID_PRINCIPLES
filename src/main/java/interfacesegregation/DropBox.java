package interfacesegregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropBox implements CloudProvider {
    private Map<String, byte[]> storage = new HashMap<>();
    private List<String> servers = new ArrayList<>();
    private String cdnAddress = "https://dropbox-cdn.example.com";

    @Override
    public void storeFile(String name, byte[] data) throws CloudProviderException {
        if (name == null || name.isEmpty()) {
            throw new CloudProviderException("Invalid file name.");
        }
        if (data == null || data.length == 0) {
            throw new CloudProviderException("Invalid file data.");
        }
        storage.put(name, data);
        System.out.println("File " + name + " stored in Dropbox.");
    }

    @Override
    public byte[] getFile(String name) throws CloudProviderException {
        if (name == null || name.isEmpty()) {
            throw new CloudProviderException("Invalid file name.");
        }
        byte[] data = storage.get(name);
        if (data == null) {
            throw new CloudProviderException("File not found in Dropbox.");
        }
        System.out.println("Getting file " + name + " from Dropbox.");
        return data;
    }

    @Override
    public void createServer(String region) throws CloudProviderException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> listServers(String region) throws CloudProviderException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCDNAddress() throws CloudProviderException {
        throw new UnsupportedOperationException();
    }

}
