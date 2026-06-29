package week2.mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Call method on service (which uses the mock)
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Verify interaction with mock
        verify(mockApi).getData();
    }
}
