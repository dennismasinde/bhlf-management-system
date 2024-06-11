package io.dennismasinde.services;

import io.dennismasinde.entities.Lead;
import io.dennismasinde.entities.Member;
import io.dennismasinde.exceptions.EntityNotFoundException;
import io.dennismasinde.exceptions.InvalidOperationException;
import io.dennismasinde.repositories.LeadRepository;
import io.dennismasinde.repositories.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;
    private final MemberRepository memberRepository;

    public Lead addNewLead(Lead lead) {
        return leadRepository.save(lead);
    }

    @Transactional
    public void convertLeadToMember(Long leadId, Member member) {
        Lead lead = leadRepository.findById(leadId).orElseThrow(() ->
                new EntityNotFoundException("Lead not found with id " + leadId));
        if (lead.getConverted() != null) {
            throw new InvalidOperationException("Lead is already converted to a member");
        }
        memberRepository.save(member);
        lead.setConverted(member);
        leadRepository.save(lead);
    }

    public List<Lead> getLeadsByUserId(Long userId) {
        return leadRepository.findByUserUserId(userId);
    }
}
