package me.devhardy.jpabulkinsert.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Table(name = "dummy")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dummy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public static List<Dummy> createDummies(Long startId) {
        return IntStream.range(1, 100)
                .mapToObj(i -> Dummy.builder()
                        .id(startId + i)
                        .title("title " + i)
                        .build())
                .collect(Collectors.toList());
    }
}
