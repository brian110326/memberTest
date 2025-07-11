package hello.aws_practice.controller;

import hello.aws_practice.entity.Member;
import hello.aws_practice.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;

    // 전체 팀 조회
    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // 특정 팀의 멤버 목록 조회
    @GetMapping("/{id}/members")
    public ResponseEntity<List<Member>> getTeamMembers(@PathVariable Long id) {
        return teamRepository.findById(id)
                .map(team -> ResponseEntity.ok(team.getMembers()))
                .orElse(ResponseEntity.notFound().build());
    }

}
