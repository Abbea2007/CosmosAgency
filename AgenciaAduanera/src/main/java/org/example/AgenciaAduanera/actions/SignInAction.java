package org.example.AgenciaAduanera.actions;

import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import com.openxava.naviox.impl.SignInHelper;
import org.example.AgenciaAduanera.modelo.Seguridad.Usuario;
//import org.example.AgenciaAduanera.modelo.util.CurrentSucursal;
import org.example.AgenciaAduanera.modelo.util.Encriptar;
import org.hibernate.Session;
import org.openxava.jpa.XPersistence;
import org.openxava.util.Is;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SignInAction extends ForwardToOriginalURIBaseAction {

    public void execute() throws Exception {

        SignInHelper.initRequest(getRequest(), getView());
        if (getErrors().contains()) return;

        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");

        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }

        // Buscar usuario solo por username
        /*Query query = XPersistence.getManager()
                .createQuery("SELECT u FROM Usuario u WHERE u.username = :username");
        query.setParameter("username", userName);

        Usuario usuario;
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            addError("unauthorized_user");
            return;
        }

        // Comparar contraseña con BCrypt
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(password, usuario.getPassword())) {
            addError("unauthorized_user");
            return;
        }*/

        //CurrentSucursal.set(usuario.getSucursal());

        SignInHelper.signIn(getRequest(), userName);
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }

}