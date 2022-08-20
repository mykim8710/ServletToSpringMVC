package com.example.servlet.web.springmvc.v3;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


// 마치 frontcontroller V3 -> V4로 개선하듯이 ModelAndView객체를 직접 생성하여 리런하는것이 아니라 Model 객체에 싫어서 리턴한다.
// return type : viewName(논리)
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")  //= @RequestMapping("/new-form", method = RequestMethod.GET), get으로 요청시에만 실행
    public String newFrom() {
        return "new-form";  // 뷰의 논리 이름을 반환
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,// @RequestParam 사용, @RequestParam("username")은 request.getParameter("username") 거의 같음
                       @RequestParam("age") int age,
                       Model model) {
        // 비지니스 로직
        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 비지니스 로직
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }
}
