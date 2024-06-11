package io.dennismasinde.services;

import io.dennismasinde.entities.Member;
import io.dennismasinde.exceptions.EntityNotFoundException;
import io.dennismasinde.repositories.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() ->
                new EntityNotFoundException("Member not found with id " + memberId));
    }

    public List<Member> searchMembersByName(String name) {
        return memberRepository.findByName(name);
    }

    @Transactional
    public void deleteInactiveMembers(LocalDate oneYearAgo) {
        memberRepository.deleteInactiveMembers(oneYearAgo);
    }
}
