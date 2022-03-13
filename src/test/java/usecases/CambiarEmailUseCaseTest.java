package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.usuario.commands.CambiarEmail;
import domain.usuario.events.EmailCambiado;
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
class CambiarEmailUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarEmail() {
        System.out.println("Test: Cambiar email");

        //ARRANGE
        UsuarioId usuarioId = UsuarioId.of("xxx789xxx");
        Email email = new Email("myke.steven@gmail.com");

        var command = new CambiarEmail(usuarioId, email);
        var usecase = new CambiarEmailUseCase();

        Mockito.when(repository.getEventsBy(usuarioId.value())).thenReturn(historyEvents());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(usuarioId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (EmailCambiado) events.get(0);

        Assertions.assertEquals("bookapp.usuario.emailcambiado", event.type);
        Assertions.assertEquals(usuarioId.value(), event.aggregateRootId());
        Assertions.assertEquals(email.value(), event.getEmail().value());


    }

    private List<DomainEvent> historyEvents() {

        return List.of(
                new UsuarioCreado(new Username("MykeStv"), new Nombre("Myke Steven"), new Email("myke@gmail.com"))
        );
    }

}