package com.example.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach  // test를 마치면 수행
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원저장소의 save() 테스트한다.")
    void saveTest() {
        // given : ~것이 주어졌을때
        Member member = new Member("kim", 36);

        // when : ~것을 실행했을 때
        Member savedMember = memberRepository.save(member);

        // then : 결과가 이러해야함
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    @DisplayName("회원저장소의 findAll() 테스트한다.")
    void findAllTest() {
        // given
        Member member1 = new Member("kim", 36);
        Member member2 = new Member("lee", 20);

        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}