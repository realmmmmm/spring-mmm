package com.note.modules.service;

import java.util.Map;

public interface SendSmsService {

	public boolean send(String phone, String template, Map<String,Object> code);

}
