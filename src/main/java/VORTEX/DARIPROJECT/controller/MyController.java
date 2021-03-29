package VORTEX.DARIPROJECT.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import VORTEX.DARIPROJECT.ENTITY.City;
import VORTEX.DARIPROJECT.ENTITY.Contract;
import VORTEX.DARIPROJECT.Repository.contractRepository;
import VORTEX.DARIPROJECT.service.ICityService;
import VORTEX.DARIPROJECT.service.contractService;
import VORTEX.DARIPROJECT.util.GeneratePdfReport;


@Controller
@RequestMapping("api")
public class MyController {

    @Autowired
    private contractRepository contractServe;

    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ContractsReport() {

    	List<Contract> Contracts = (List<Contract>) contractServe.findAll();

        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(Contracts);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
