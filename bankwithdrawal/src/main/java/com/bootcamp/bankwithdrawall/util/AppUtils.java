package com.bootcamp.bankwithdrawall.util;

import com.bootcamp.bankwithdrawall.bean.Withdrawall;
import com.bootcamp.bankwithdrawall.dto.WithdrawallDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static WithdrawallDto entityToDto(Withdrawall withdrawall){
        WithdrawallDto accDto=new WithdrawallDto();
        BeanUtils.copyProperties(withdrawall,accDto);
        return accDto;
    }

    public static Withdrawall dtoToEntity(WithdrawallDto accDto){
        Withdrawall withdrawall=new Withdrawall();
        BeanUtils.copyProperties(accDto,withdrawall);
        return withdrawall;
    }
}
