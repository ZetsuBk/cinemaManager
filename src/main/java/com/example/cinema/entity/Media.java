package com.example.cinema.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media extends AbstractModel<Long>{
    private static final long serialVersionUID = 3132573891761750069L;

    public enum TypeMedia {IMAGE, VIDEO, DOCUMENT}

    @Column(nullable = false, length = 100)
    private String media;

    @Column(nullable = true, length = 50)
    @Enumerated(EnumType.STRING)
    private TypeMedia typeMedia;

    @Column(name = "added_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date addedDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="FILM_ID")
    private Film film;
}
