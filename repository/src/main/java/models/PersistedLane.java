package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersistedLane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private PersistedBoard board;

    private int ordinal;
    private String title;
    private int maxNumberOfItems;

    @ManyToMany
    @JoinTable(
            name = "lane_successors",
            joinColumns        = @JoinColumn(name = "lane_id"),
            inverseJoinColumns = @JoinColumn(name = "successor_id")
    )
    private List<PersistedLane> nextLanes;

    @ManyToMany(mappedBy = "nextLanes")
    private List<PersistedLane> previousLanes;
}
