package hu.charmanthere.ease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestCicaController {

    private TestCicaRepositoryInterface testCicaRepositoryInterface;

    @Autowired
    public TestCicaController(TestCicaRepositoryInterface testCicaRepositoryInterface) {
        this.testCicaRepositoryInterface = testCicaRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/testcica/delete/{id}")
    public ResponseEntity<?> deleteCicaById(@PathVariable Long id) {
        testCicaRepositoryInterface.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/createcica")
    public ResponseEntity<?> createCica(@RequestBody TestCica testCica) {
        testCicaRepositoryInterface.save(testCica);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/cicas")
    public ResponseEntity<?> findAllCica() {
        return new ResponseEntity<>(testCicaRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/testcica/update/{id}")
    public ResponseEntity<?> updateCicaById(@PathVariable Long id,@RequestBody TestCica testCica) {
        TestCica oldcica = testCicaRepositoryInterface.findById(id).orElse(null);
        if(oldcica == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        oldcica.setName(testCica.getName());
        oldcica.setBirthDay(testCica.getBirthDay());
        testCicaRepositoryInterface.save(oldcica);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
