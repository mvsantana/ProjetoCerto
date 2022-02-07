package com.livrariacorreta.livrariaapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling //agendamento de tarefas
public class LivrariaApiApplication {


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@Scheduled(cron = "0 8 12 1/1 * ?")
	public void testAgendamentoTarefas() {
		System.out.println("AGENDAMENTO DE TAREFAS FUNCIONANDO COM SUCESSO!");
	}

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApiApplication.class, args);

	}

}
