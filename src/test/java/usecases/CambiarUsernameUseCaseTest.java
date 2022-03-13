package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.usuario.commands.CambiarUsername;
import domain.usuario.events.UsernameCambiado;
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
class CambiarUsernameUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarUsername() {
        System.out.println("Test: Cambiar username");

        //ARRANGE
        UsuarioId usuarioId = UsuarioId.of("xxx123xxx");
        Username username = new Username("DanteTheCat");

        var command = new CambiarUsername(usuarioId, username);
        var usecase = new CambiarUsernameUseCase();

        Mockito.when(repository.getEventsBy(usuarioId.value())).thenReturn(historyEvents());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(usuarioId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (UsernameCambiado) events.get(0);

        Assertions.assertEquals("bookapp.usuario.usernamecambiado", event.type);
        Assertions.assertEquals("xxx123xxx", event.aggregateRootId());
        Assertions.assertEquals("DanteTheCat", event.getUsername().value());
        

    }

    private List<DomainEvent> historyEvents() {

        return List.of(
                new UsuarioCreado(new Username("Dante"), new Nombre("Dante Emilio"), new Email("dante@mail.com"))
        );
    }

}