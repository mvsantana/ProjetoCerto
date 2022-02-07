package com.livrariacorreta.livrariaapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnedLoanDTO {
    private boolean returned;

    public Boolean getReturned() {
        return returned;
    }
}
