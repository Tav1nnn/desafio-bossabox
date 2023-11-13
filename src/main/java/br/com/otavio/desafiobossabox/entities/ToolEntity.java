package br.com.otavio.desafiobossabox.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity(name = "tools")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tag_tools",
            joinColumns = {@JoinColumn(name = "tool_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private List<TagEntity> tag;
}
