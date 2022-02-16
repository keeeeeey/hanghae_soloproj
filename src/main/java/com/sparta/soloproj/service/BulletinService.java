package com.sparta.soloproj.service;

import com.sparta.soloproj.dto.BulletinRequestDto;
import com.sparta.soloproj.model.Bulletin;
import com.sparta.soloproj.repository.BulletinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BulletinService {

    private BulletinRepository bulletinRepository;

    @Autowired
    public BulletinService(BulletinRepository bulletinRepository) {
        this.bulletinRepository = bulletinRepository;
    }

    public Bulletin posting(BulletinRequestDto requestDto) {
        Bulletin bulletin = new Bulletin(requestDto);

        bulletinRepository.save(bulletin);

        return bulletin;
    }

    public List<Bulletin> getAllBulletin() {
        return bulletinRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Optional<Bulletin> getBulletin(Long bulletinId) {
        return bulletinRepository.findById(bulletinId);
    }

    public void deleteBulletin(Long bulletinId) {
        bulletinRepository.deleteById(bulletinId);
    }

    public Bulletin updating(Long bulletinId, BulletinRequestDto requestDto) {
        Bulletin bulletin = bulletinRepository.findById(bulletinId)
                .orElseThrow(() -> new NullPointerException("해당 글이 존재하지 않습니다."));

        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String writer = requestDto.getWriter();
        bulletin.setTitle(title);
        bulletin.setContent(content);
        bulletin.setWriter(writer);

        bulletinRepository.save(bulletin);

        return bulletin;
    }
}
