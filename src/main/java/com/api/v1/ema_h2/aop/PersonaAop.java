/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.v1.ema_h2.aop;

import com.api.v1.ema_h2.model.Log;
import com.api.v1.ema_h2.repo.LogRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class PersonaAop {

	private final LogRepository LR;

	@Before("execution(* com.api.v1.ema_h2.repo.PersonaRepository.findAll(..))")
	public void logBefore(JoinPoint joinpoint) {
		log.info("Verificacion: {}", joinpoint.getSignature().getName());
		LR.save(new Log(null, joinpoint.getSignature().getName(), LocalDateTime.now().toString()));
	}

	@Before("execution(* com.api.v1.ema_h2.repo.PersonaRepository.findByNombre(..))")
	public void logBefore2(JoinPoint joinpoint) {
		log.info("Verificacion: {}", joinpoint.getSignature().getName());
		LR.save(new Log(null, joinpoint.getSignature().getName(), LocalDateTime.now().toString()));
	}

	@Before("execution(* com.api.v1.ema_h2.repo.PersonaRepository.deleteById(..))")
	public void logBefore3(JoinPoint joinpoint) {
		log.info("Verificacion: {}", joinpoint.getSignature().getName());
		LR.save(new Log(null, joinpoint.getSignature().getName(), LocalDateTime.now().toString()));
	}

	@Before("execution(* com.api.v1.ema_h2.repo.PersonaRepository.save(..))")
	public void logBefore4(JoinPoint joinpoint) {
		log.info("Verificacion: {}", joinpoint.getSignature().getName());
		LR.save(new Log(null, joinpoint.getSignature().getName(), LocalDateTime.now().toString()));
	}

}
