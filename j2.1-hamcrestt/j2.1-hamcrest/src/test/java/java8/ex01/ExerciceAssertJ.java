package java8.ex01;

import java8.data.Data;
import java8.data.domain.Pizza;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExerciceAssertJ {

    @Test
    public void test_is() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        Boolean result = pizzas.stream().anyMatch(p -> p.getPrice() >= 1300);

        // TODO vérifier que result vaut true
        assertThat(result, is(true));
    }

    @Test
    public void test_hasSize() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        List<Pizza> result = pizzas.stream()
                .filter(p -> p.getPrice() >= 1300)
                .collect(toList());

        // TODO valider que result a 3 éléments
        assertThat(result, hasSize(3));
    }

    @Test
    public void test_hasProperty() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        Pizza result = pizzas.stream().max(Comparator.comparing(Pizza::getPrice)).orElseThrow();

        // TODO valider que result a la propriété name qui vaut "La Cannibale"
        assertThat(result, hasProperty("name", is("La Cannibale")));
    }

    @Test
    public void test_everyItem() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        List<Pizza> result = pizzas.stream()
                .filter(p -> p.getPrice() >= 1300)
                .collect(toList());

        // TODO valider que tous les objets Pizza de la liste result ont un prix >= 1300
        assertThat(result, everyItem(hasProperty("price", greaterThanOrEqualTo(1300))));
    }
}

