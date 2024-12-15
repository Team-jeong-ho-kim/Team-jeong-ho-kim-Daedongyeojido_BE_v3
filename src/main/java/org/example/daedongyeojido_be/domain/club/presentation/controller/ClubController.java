package org.example.daedongyeojido_be.domain.club.presentation.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.club.presentation.dto.request.ModifyClubRequest;
import org.example.daedongyeojido_be.domain.club.presentation.dto.response.AllClubResponse;
import org.example.daedongyeojido_be.domain.club.presentation.dto.response.ClubInfoResponse;
import org.example.daedongyeojido_be.domain.club.service.ClubAllInfoService;
import org.example.daedongyeojido_be.domain.club.service.ClubInfoService;
import org.example.daedongyeojido_be.domain.club.service.ClubModifyService;
import org.example.daedongyeojido_be.global.annotation.OnlyTeacher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubInfoService clubInfoService;
    private final ClubModifyService clubModifyService;
    private final ClubAllInfoService clubAllInfoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info/{id}")
    public ClubInfoResponse clubInfo(@PathVariable String clubName){
        return clubInfoService.getClubInfo(clubName);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify")
    public void modifyClub(@RequestBody @Valid ModifyClubRequest request){
        clubModifyService.modifyClub(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<AllClubResponse> getAllClub(){
        return clubAllInfoService.getAllClubs();
    }

}
