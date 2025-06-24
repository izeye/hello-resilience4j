package learningtest.io.github.resilience4j.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link CircuitBreaker}.
 *
 * @author Johnny Lim
 */
class CircuitBreakerTests {

    @Test
    void decorateCheckedSupplierWithVavr() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("test");

        Try<String> result = Try.of(() -> circuitBreaker.decorateCheckedSupplier(() -> "This can be any method which returns: 'Hello").get())
                .map(v -> v + " world'");

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.get()).isEqualTo("This can be any method which returns: 'Hello world'");
    }

}
