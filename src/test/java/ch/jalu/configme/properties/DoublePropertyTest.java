package ch.jalu.configme.properties;

import ch.jalu.configme.resource.PropertyReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Test for {@link DoubleProperty}.
 */
@RunWith(MockitoJUnitRunner.class)
public class DoublePropertyTest {

    @Mock
    private PropertyReader reader;

    @Test
    public void shouldReturnDoubleFromResource() {
        // given
        Property<Double> property = new DoubleProperty("test.path", 3.4);
        given(reader.getDouble("test.path")).willReturn(-2508.346);

        // when
        double result = property.determineValue(reader);

        // then
        assertThat(result, equalTo(-2508.346));
    }

    @Test
    public void shouldReturnDefaultValue() {
        // given
        Property<Double> property = new DoubleProperty("property.path", 5.9);
        given(reader.getDouble("property.path")).willReturn(null);

        // when
        double result = property.determineValue(reader);

        // then
        assertThat(result, equalTo(5.9));
    }

    @Test
    public void shouldReturnValueAsExportValue() {
        // given
        Property<Double> property = new DoubleProperty("property.path", 4);
        double givenValue = 4.3456;

        // when
        Object exportValue = property.toExportValue(givenValue);

        // then
        assertThat(exportValue, equalTo(givenValue));
    }
}