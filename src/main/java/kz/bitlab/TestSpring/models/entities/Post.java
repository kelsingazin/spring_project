package kz.bitlab.TestSpring.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
@Data
@Entity
@Builder
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Column
    private boolean active;

    @PrePersist
    public void prePersist() {
        this.active = true;
    }
}
