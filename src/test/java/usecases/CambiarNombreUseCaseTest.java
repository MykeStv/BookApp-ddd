package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.usuario.commands.CambiarNombre;
import domain.usuario.events.NombreCambiado;
import domain.usuario.events.UsuarioCreado;
import domain.usuario.values.Email;
import domain.usuario.values.Nombre;
import domain.usuario.values.Username;
import domain.usuario.values.UsuarioId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarNombreUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarNombre() {
        System.out.println("Test: Cambiar nombre");

        //ARRANGE
        UsuarioId usuarioId = UsuarioId.of("xxx456xxx");
        Nombre nombreUsuario = new Nombre("Jennifer Connelly");

        var command = new CambiarNombre(usuarioId, nombreUsuario);
        var usecase = new CambiarNombreUseCase();

        Mockito.when(repository.getEventsBy(usuarioId.value())).thenReturn(historyEvents());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(usuarioId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (NombreCambiado) events.get(0);

        Assertions.assertEquals("bookapp.usuario.nombrecambiado", event.type);
        Assertions.assertEquals("xxx456xxx", event.aggregateRootId());
        Assertions.assertEquals("Jennifer Connelly", event.getNombre().value());

    }

    private List<DomainEvent> historyEvents() {

        return List.of(
                new UsuarioCreado(new Username("jennyconn"), new Nombre("Jenni Con"), new Email("jenny@mail.com"))
        );
    }

}