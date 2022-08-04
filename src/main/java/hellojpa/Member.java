package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator
        (name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 50)
public class Member {

    @Id
    @GeneratedValue
            (strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name")
    private String username;

    public Member() {}

    public void setUsername(String username) {
        this.username = username;
    }
}
