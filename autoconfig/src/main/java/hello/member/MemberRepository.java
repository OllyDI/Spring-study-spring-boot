package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate template;

    public MemberRepository(JdbcTemplate template) {
        this.template = template;
    }

    // 예시를 보여주기 위해 생성 -> 이렇게 쓰면 안됨
    public void initTable() {
        template.execute("drop table if exists member");
        template.execute("create table member(member_id varchar(20) primary key, name varchar(20))");
    }

    public void save(Member member) {
        template.update("insert into member(member_id, name) values(?, ?)",
                member.getMemberId(), member.getName());
    }

    public Member find(String memberId) {
        return template.queryForObject("select * from member where member_id=?",
                BeanPropertyRowMapper.newInstance(Member.class), memberId);
    }

    public List<Member> findAll() {
        return template.query("select * from member", BeanPropertyRowMapper.newInstance(Member.class));
    }
}
