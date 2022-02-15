package com.sparta.soloproj.controller;

import com.sparta.soloproj.dto.BulletinRequestDto;
import com.sparta.soloproj.model.Bulletin;
import com.sparta.soloproj.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BulletinController {

    private final BulletinService bulletinService;

    @Autowired
    public BulletinController(BulletinService bulletinService) {
        this.bulletinService = bulletinService;
    }

    @PostMapping("/api/post")
    public Bulletin posting(@RequestBody BulletinRequestDto requestDto) {
        return bulletinService.posting(requestDto);
    }

    @GetMapping("/api/post")
    public List<Bulletin> getAllBulletin() {
        return bulletinService.getAllBulletin();
    }

    @GetMapping("/api/post/{id}")
    public List<Bulletin> getBulletin(@PathVariable Long id) {
        return bulletinService.getBulletin(id);
    }

    @DeleteMapping("/api/post/{id}")
    public void deleteBulletin(@PathVariable Long id) {
        bulletinService.deleteBulletin(id);
    }

    @PatchMapping("/api/post/{id}")
    public Bulletin updating(@PathVariable Long id, @RequestBody BulletinRequestDto requestDto) {
        return bulletinService.updating(id, requestDto);
    }

}
