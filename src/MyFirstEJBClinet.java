import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MyFirstEJBClinet {

    public static void main(String[] args) {
        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext initialContext = new InitialContext(jndiProperties);
            IMyFirstEJB ejb = (IMyFirstEJB)initialContext
                    .lookup("ejb:/my_ejb_project_war_exploded//MyFirstEJB!IMyFirstEJB");
            System.out.print(ejb.saySomething("Kris"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
