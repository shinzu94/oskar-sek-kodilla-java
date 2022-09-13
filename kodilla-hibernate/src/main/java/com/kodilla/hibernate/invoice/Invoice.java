package com.kodilla.hibernate.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private String number;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;
}
