package service;

import model.Usuario;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import dao.UsuarioDAO;

public class UsuarioService {
	
	public boolean validar(Usuario usuario) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, ClassNotFoundException, CertificateException, KeyStoreException, IOException{
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}
}
