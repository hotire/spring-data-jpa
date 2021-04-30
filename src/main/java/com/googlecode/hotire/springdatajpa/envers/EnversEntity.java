package com.googlecode.hotire.springdatajpa.envers;

import static javax.persistence.FetchType.EAGER;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * https://github.com/hibernate/hibernate-orm/blob/master/hibernate-envers/src/main/java/org/hibernate/envers/DefaultRevisionEntity.java
 */
@Accessors(chain = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Audited
public class EnversEntity {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

//    @NotAudited
//    @OneToMany(fetch = EAGER)
//    @AuditJoinTable(name = "envers_entity_aud")

    @NotAudited
    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "id")
    @AuditJoinTable(name = "envers_entity_aud")
    private List<EnversEntity> enversEntity;
}
