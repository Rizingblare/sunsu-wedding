package com.kakao.sunsuwedding.match.Quotation;

import com.kakao.sunsuwedding.match.Match;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    private Long id;

    @ManyToOne
    private Match match;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long price;

    @Column
    private String company;

    @Column
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuotationStatus status;

    @Column
    private LocalDateTime modified_at;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private Boolean is_active;

    @Builder
    public Quotation(long id, Match match, String title, long price, String company, String description, QuotationStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.match = match;
        this.title = title;
        this.price = price;
        this.company = company;
        this.description = description;
        this.status = (status == null? QuotationStatus.UNCONFIRMED : status);
        this.created_at = (createdAt == null? LocalDateTime.now() : createdAt);
        this.is_active = true;
    }

    public void updateTitle(String title) {
        this.title = title;
        this.modified_at = LocalDateTime.now();
    }

    public void updatePrice(long price) {
        this.price = price;
        this.modified_at = LocalDateTime.now();
    }

    public void updateCompany(String company) {
        this.company = company;
        this.modified_at = LocalDateTime.now();
    }

    public void updateDescription(String description) {
        this.description = description;
        this.modified_at = LocalDateTime.now();
    }

    public void updateStatus(QuotationStatus status) {
        this.status = status;
        this.modified_at = LocalDateTime.now();
    }

    public void updateIsActive(Boolean is_active) {
        this.is_active = is_active;
        this.modified_at = LocalDateTime.now();
    }
}
