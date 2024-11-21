package com.papeleriawww.leobor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
@Builder(toBuilder = true)
public class Message {

    private  String message;
    private Object data;
}
