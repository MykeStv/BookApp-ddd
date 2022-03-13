package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.usuario.commands.CrearUsuario;
import domain.usuario.events.UsuarioCreado;
import domain.usuario.values.Email;
import domain.usuario.values.Nombre;
import domain.usuario.values.Username;
import domain.usuario.values.UsuarioId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearUsuarioUseCaseTest {

    @Test
    void crearUsuario() {
        System.out.println("Test: Crear usuario");

        //ARRANGE
        UsuarioId usuarioId = new UsuarioId();
        Username username = new Username("mykestv");
        Nombre nombre = new Nombre("Myke Steven");
        Email email = new Email("myke.s@gmail.com");

        var command = new CrearUsuario(usuarioId, username, nombre, email);
        var usecase = new CrearUsuarioUseCase();

        //ACT
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (UsuarioCreado) events.get(0);
        Assertions.assertEquals("bookapp.usuario.usuariocreado", event.type);
        Assertions.assertEquals(usuarioId.value(), event.aggregateRootId());
        Assertions.assertEquals("mykestv", event.getUsername().value());
        Assertions.assertEquals("Myke Steven", event.getNombre().value());
        Assertions.assertEquals("myke.s@gmail.com", event.getEmail().value());

    }

}