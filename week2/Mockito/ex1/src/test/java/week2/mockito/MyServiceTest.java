package week2.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Create mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub method to return predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Use mock in service under test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }
}
