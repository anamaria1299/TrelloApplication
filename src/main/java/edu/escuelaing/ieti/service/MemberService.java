package edu.escuelaing.ieti.service;

import edu.escuelaing.ieti.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface MemberService {

    List<Member> getAllMembers();

    Member getMemberById(UUID id);

    Member getMemberByEmail(String email) throws Exception;

    Member createMember(Member member);
}
