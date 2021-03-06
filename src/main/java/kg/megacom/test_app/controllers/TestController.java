package kg.megacom.test_app.controllers;

import kg.megacom.test_app.models.dto.TestDto;
import kg.megacom.test_app.models.dto.json.get.PreparedTest;
import kg.megacom.test_app.models.dto.json.create.TestCreateJson;
import kg.megacom.test_app.models.dto.json.create.TestResultJson;
import kg.megacom.test_app.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/save")
    public TestDto save(@RequestBody TestDto testDto){
        return testService.save(testDto);
    }

    @GetMapping("/get")
    public TestDto findById(@RequestParam Long id){
        return testService.findById(id);
    }

    @PutMapping("/update")
    public TestDto update(@RequestBody TestDto testDto){
        return testService.update(testDto);
    }
    @PutMapping("/delete")
    public TestDto delete(@RequestBody TestDto testDto){
        return testService.delete(testDto);
    }

    @GetMapping("/findAllByActive")
    public List<TestDto> findAllByActive(){
        return testService.findAllByActive();
    }

    @PostMapping("/create")
    public TestResultJson createTest(@RequestBody TestCreateJson testCreateJson){
        return testService.createNewTest(testCreateJson);
    }

    @GetMapping("/getById")
    public PreparedTest getById(@RequestParam Long id){
        return testService.getById(id);
    }
}

