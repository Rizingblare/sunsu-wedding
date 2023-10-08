package com.kakao.sunsuwedding.match.Quotation;

import com.kakao.sunsuwedding.match.Match;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="quotation_tb")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Match match;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long price;

    @Column
    private String company;

    @Column
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
