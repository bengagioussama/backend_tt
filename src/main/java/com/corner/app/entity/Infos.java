package com.corner.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Infos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String debit;
    private String volume;
    private String PH;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    private String categorie;
}