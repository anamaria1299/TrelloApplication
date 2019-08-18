package edu.escuelaing.ieti.service.Imp;

import edu.escuelaing.ieti.model.Member;
import edu.escuelaing.ieti.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemberServiceImp implements MemberService {

    @Autowired
    Member member;

    private HashMap<UUID, Member> members = new HashMap<>();

    @Override
    public List<Member> getAllMembers() {

        List<Member> memberList = new ArrayList<>();
        Set<UUID> keys = members.keySet();

        for(UUID id: keys) {

            memberList.add(members.get(id));
        }

        return memberList;
    }

    @Override
    public Member getMemberById(UUID id) {

        return members.get(id);
    }

    @Override
    public Member createMember(Member member) {

        // TODO validate UUID or generate it
        members.put(member.getId(), member);
        return member;
    }
}
