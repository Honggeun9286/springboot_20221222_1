package com.globalit.account;

import com.globalit.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface AccourtRepository extends JpaRepository<Account,Long> {
  boolean existsByEmail(String email);
  boolean existsByNickname(String Nickname);
}
