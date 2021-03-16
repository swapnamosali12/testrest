
import com.spock.springspock.resource.UserController
import com.spock.springspock.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.is
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = UserController)
@AutoConfigureMockMvc
class UserControllerTest extends Specification {
    @Autowired
    private MockMvc mockMvc
    @Autowired
    ApplicationContext context
    @Autowired
    UserService userService1
    UserService userService = new UserService()
    UserController controller = new UserController(userService)
    UserController controller2 = new UserController()
    def "call webcontoller sample method"() {
        given:
        0 * userService.findByUsername("test") >> null
        when:
        def response = mockMvc.perform(
                get("/test"))

        then:
        response.andExpect(status().isOk())
    }
}

