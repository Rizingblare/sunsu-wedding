package com.kakao.sunsuwedding.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentJPARepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByUserId(Long userId);

}

