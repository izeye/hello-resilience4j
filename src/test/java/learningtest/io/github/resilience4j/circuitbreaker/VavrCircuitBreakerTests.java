package learningtest.io.github.resilience4j.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.VavrCircuitBreaker;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link VavrCircuitBreaker}.
 *
 * @author Johnny Lim
 */
class VavrCircuitBreakerTests {

    @Test
    void decorateCheckedSupplier() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("test");

        Try<String> result = Try.of(VavrCircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> "This can be any method which returns: 'Hello"))
                .map(v -> v + " world'");

        assertThat(result.isSuccess()).isTrue();
        assertThat(result.get()).isEqualTo("This can be any method which returns: 'Hello world'");
    }

}
