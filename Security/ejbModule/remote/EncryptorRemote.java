package remote;

import javax.ejb.Remote;

@Remote
public interface EncryptorRemote {

    public String encrypt( String password );

    public String byteToHex( final byte[] hash );

}