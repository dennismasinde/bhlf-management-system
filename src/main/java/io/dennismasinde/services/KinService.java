package io.dennismasinde.services;

import io.dennismasinde.entities.Kin;
import io.dennismasinde.exceptions.EntityNotFoundException;
import io.dennismasinde.repositories.KinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KinService {

    private final KinRepository kinRepository;

    public List<Kin> getKinByMemberId(Long memberId) {
        return kinRepository.findByMemberMemberId(memberId);
    }

    public Kin getKinById(Long kinId) {
        return kinRepository.findById(kinId).orElseThrow(() ->
                new EntityNotFoundException("Kin not found with id " + kinId));
    }
}
