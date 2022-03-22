package andrey.service;

import andrey.model.Developer;
import andrey.repository.jdbc.JdbcDeveloperRepositoryImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.Optional;
import java.util.UUID;

import static java.lang.Math.random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class DeveloperServiceTest {
    public ExpectedException expectedException = ExpectedException.none();
    @Mock
    private JdbcDeveloperRepositoryImpl developerRepository ;
    @Spy
    private DeveloperService developerService ;
    Developer developer = new Developer();
    @Before
    public void setUp() {
        developer.setId(1l);
        developer.setFirstName("Ivan");
        developer.setLastName("Ivanov");
        developer.setTeamId(1);
    }
    @Test
    public void shouldCreatedDeveloperInstanceTest(){
           assertEquals("Ivan", developer.getFirstName());
           assertEquals("Ivanov", developer.getLastName());
           assertEquals(1,developer.getTeamId());
        }

     @Test
    public void testMethodGetDeveloperService(){
       Long id = 1l;
       Mockito.doReturn(Optional.of(new Developer())).when(developerRepository).getById(ArgumentMatchers.any());
       developer = developerService.get(id);
       Mockito.verify(developerRepository).getById(ArgumentMatchers.eq(id));
        assertNotNull(developer);
     }
     @Test
     public void testMethodGetAllDeveloperService(){

     }
     @Test
    public void testMethodRedirectSavedDeveloper(){
        assertNotNull(developer);
     }
     @Test
    public void testMethodDeleteDeveloperService(){

     }

}


