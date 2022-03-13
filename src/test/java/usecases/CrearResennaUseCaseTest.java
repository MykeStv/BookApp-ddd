package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.reseña.commands.CrearResenna;
import domain.reseña.events.ResennaCreada;
import domain.reseña.values.Critica;
import domain.reseña.values.ResennaId;
import domain.usuario.values.UsuarioId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearResennaUseCaseTest {

    @Test
    void crearResenna() {
        System.out.println("Test: Crear resenna");

        //ARRANGE
        ResennaId resennaId = new ResennaId();
        Critica critica = new Critica("The witcher books is a dark fantasy series, it has a dark vibe and every story it tells is enjoyed a lot");
        UsuarioId usuarioId = UsuarioId.of("xxx123xxx");

        var command = new CrearResenna(resennaId, critica, usuarioId);
        var usecase = new CrearResennaUseCase();

        //ACT
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (ResennaCreada) events.get(0);

        Assertions.assertEquals("bookapp.resenna.resennacreada", event.type);
        Assertions.assertEquals(resennaId.value(), event.aggregateRootId());
        Assertions.assertEquals(critica.value(), event.getCritica().value());
        Assertions.assertEquals("xxx123xxx", event.getUsuarioId().value());

    }
}