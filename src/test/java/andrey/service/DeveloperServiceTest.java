package andrey.service;

import andrey.model.Developer;
import andrey.repository.jdbc.JdbcDeveloperRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class DeveloperServiceTest {

    private JdbcDeveloperRepositoryImpl developerRepository = mock(JdbcDeveloperRepositoryImpl.class);
    private DeveloperService developerService = spy(DeveloperService.class);
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
       when(developerRepository.getById(anyLong())).thenReturn(developer);
      developerRepository.getById(anyLong());
       verify(developerRepository,times(1)).getById(anyLong());
       assertNotNull(developerRepository.getById(anyLong()));
     }
     @Test
     public void testMethodGetAllDeveloperService(){
           doReturn(IntStream.range(0,3).mapToObj(o -> new Developer()).collect(Collectors.toList()))
                   .when(developerRepository).getAll();
         List<Developer> developerList = developerRepository.getAll();
         verify(developerRepository).getAll();
         assertNotNull(developerList);
         assertEquals(3l,developerList.size());
     }
     @Test
    public void testMethodSaveDeveloper(){
          developerService.createDeveloper(developer);
          verify(developerService).createDeveloper(developer);
          assertEquals(developer.getFirstName(), "Ivan");
          assertEquals(developer.getLastName(), "Ivanov");

     }
     @Test
     public void testMethodUpdateDeveloper(){

     }
     @Test
    public void testMethodDeleteDeveloperService(){

     }

}


