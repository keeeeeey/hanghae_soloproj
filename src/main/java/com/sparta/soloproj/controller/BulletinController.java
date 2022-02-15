package com.sparta.soloproj.controller;

import com.sparta.soloproj.dto.BulletinRequestDto;
import com.sparta.soloproj.model.Bulletin;
import com.sparta.soloproj.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/post/{bulletinId}")
    public Optional<Bulletin> getBulletin(@PathVariable Long bulletinId) {
        return bulletinService.getBulletin(bulletinId);
    }

    @DeleteMapping("/api/post/{bulletinId}")
    public void deleteBulletin(@PathVariable Long bulletinId) {
        bulletinService.deleteBulletin(bulletinId);
    }

    @PatchMapping("/api/post/{bulletinId}")
    public Bulletin updating(@PathVariable Long bulletinId, @RequestBody BulletinRequestDto requestDto) {
        return bulletinService.updating(bulletinId, requestDto);
    }

}
