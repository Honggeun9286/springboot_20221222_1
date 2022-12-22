package com.globalit.account;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

  private final AccourtRepository accourtRepository;
  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom((SignUpForm.class));
  }

  @Override
  public void validate(Object target, Errors errors) {
   // DB를 조회해서 email 이나 nickname 이 중복되는지 검사함
    SignUpForm signUpForm = (SignUpForm)errors;
    if(accourtRepository.existsByEmail(signUpForm.getEmail())){
      errors.rejectValue("email","invalid.email",
                              new Object[]{signUpForm.getEmail()},
                              "이미사용중인 이메일입니다."
                                            );
      if(accourtRepository.existsByNickname(signUpForm.getNickname())){
        errors.rejectValue("nickname","invalid.nickname",
          new Object[]{signUpForm.getNickname()},
          "이미사용중인 닉네임입니다."
        );
    }
  }
}
}
