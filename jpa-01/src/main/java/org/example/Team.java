package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "team", // if not mapped, join table is created.
//            fetch = FetchType.LAZY)
//    private List<Member> members = new ArrayList<>();

    public void changeName(String name) {
        this.name = name;
    }
}
