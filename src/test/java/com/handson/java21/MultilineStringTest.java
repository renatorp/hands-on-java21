package com.handson.java21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MultilineStringTest {

  @Test
  void multilineStringTest() {
    var bigText = """
        Primeiro eu queria cumprimentar os internautas. -Oi Internautas! Depois dizer que o meio 
        ambiente é sem dúvida nenhuma uma ameaça ao desenvolvimento sustentável. E isso significa 
        que é uma ameaça pro futuro do nosso planeta e dos nossos países. O desemprego beira 20%, 
        ou seja, 1 em cada 4 portugueses.
                
        A população ela precisa da Zona Franca de Manaus, porque na Zona franca de Manaus, não é 
        uma zona de exportação, é uma zona para o Brasil. Portanto ela tem um objetivo, ela evita o 
        desmatamento, que é altamente lucravito. Derrubar arvores da natureza é muito lucrativo!
    """;

    assertThat(bigText.stripLeading().charAt(0)).isEqualTo('P');
  }
}
