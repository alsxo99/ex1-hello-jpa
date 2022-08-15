package hellojpa;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private String createdBy;
    private LocalDateTime createdAt;

    private String lastModifiedBy;
    private LocalDateTime lastModifiedAt;

}
