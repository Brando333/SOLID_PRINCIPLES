package interfacesegregation;

import java.util.List;

public interface CloudProvider {
    void storeFile(String name, byte[] data) throws CloudProviderException;

    byte[] getFile(String name) throws CloudProviderException;

    void createServer(String region) throws CloudProviderException;

    List<String> listServers(String region) throws CloudProviderException;

    String getCDNAddress() throws CloudProviderException;

}
