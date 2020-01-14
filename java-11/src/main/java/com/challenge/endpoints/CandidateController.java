package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable("userId") Long userId,
                                   @PathVariable("companyId") Long companyId,
                                   @PathVariable("accelerationId") Long accelerationId) {
        return candidateMapper.map(candidateService.findById(userId, companyId, accelerationId).get());
    }

    @GetMapping(params = "companyId")
    public List<CandidateDTO> findByCompanyId(@RequestParam("companyId") Long companyId) {
        return candidateMapper.map(candidateService.findByCompanyId(companyId));
    }

    @GetMapping(params = "accelerationId")
    public List<CandidateDTO> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
        return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
    }
}
