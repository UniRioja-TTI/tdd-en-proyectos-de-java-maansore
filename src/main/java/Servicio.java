import com.tt1.test.IDBStub;
import com.tt1.test.IMailerStub;
import com.tt1.test.IRepositorio;
import com.tt1.test.IServicio;

import java.io.Serializable;
import java.time.LocalDate;

public class Servicio implements IServicio {

    private IRepositorio repositorio;
    private IMailerStub mailer;

    public Servicio(IRepositorio repositorio, IMailerStub mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    @Override
    public void agnadirToDo(String nombre, LocalDate fechaLimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void agnadirEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void actualizarEstado(Integer id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void consultarToDosNoCompletados() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
