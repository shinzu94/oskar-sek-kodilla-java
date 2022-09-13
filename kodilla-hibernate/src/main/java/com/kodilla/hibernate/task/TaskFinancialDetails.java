package com.kodilla.hibernate.task;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TASKS_FINANCIALS")
public class TaskFinancialDetails {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    private BigDecimal price;
    private boolean paid;

    public TaskFinancialDetails(BigDecimal price, boolean paid) {
        this.price = price;
        this.paid = paid;
    }
}