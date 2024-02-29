package com.ms.user.producer;

import com.ms.user.model.UserEntity;
import com.ms.user.pojo.EmailPojo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessage(UserEntity user) {
        var emailPojo = new EmailPojo();
        emailPojo.setUserId(user.getId());
        emailPojo.setEmailTo(user.getEmail());
        emailPojo.setSubject("Cadastro realizado com sucesso!!");
        emailPojo.setText(String.format("Olá %s. Seja muito bem-vindo à nossa plataforma! \n Seu cadastro foi concluído com sucesso. Aproveite ao máximo todas as funcionalidades disponíveis.", user.getName()));

        rabbitTemplate.convertAndSend("", routingKey, emailPojo);
    }
}
