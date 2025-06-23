# Fight of Faith

**Fight of Faith** é um projeto em desenvolvimento que visa criar uma plataforma digital para ajudar usuários a interagir com conteúdo relacionado à fé cristã. A plataforma permitirá que os usuários personalizem seu perfil, compartilhem versículos favoritos, interesses e orações, além de poderem editar suas informações pessoais e imagem de perfil.

## Funcionalidades

- **Perfil do Usuário**: Os usuários podem editar e visualizar informações como nome, versículo favorito, igreja, ministério, interesses, e orações.
- **Edição de Imagem de Perfil**: Os usuários podem alterar sua imagem de perfil, utilizando o modal de edição.
- **Menu Lateral**: Um menu lateral facilita a navegação entre as seções da plataforma, incluindo a visualização de conteúdos relacionados à fé e ao estudo bíblico.
- **Interface Responsiva**: A interface é construída para ser intuitiva e funcional em dispositivos móveis e desktops.

## Telas do Projeto

Aqui estão algumas capturas de tela do desenvolvimento atual do site:

### Tela Inicial de Perfil
A tela inicial exibe as informações principais do usuário, como nome, versículo favorito, igreja, ministério, interesses e oração.

![Tela de Perfil](https://i.postimg.cc/pdjZxHjV/1.png)

### Biblioteca da fé
Na seção da biblioteca, você pode escolher um livro para ler.
![Seção de Edição de Perfil](https://i.postimg.cc/FH7pWcsL/2.png)

### Seção de leitura, livro escolhido: A Existência da vida sem Deus
Os usuários podem ler, grifar versos que chamem atenção própria.

![Modal de Edição de Imagem](https://i.postimg.cc/7YBXnXD4/3.png)

### Menu Lateral
O menu lateral permite fácil navegação entre diferentes seções do site, como estudos bíblicos, versículos favoritos e mais.

![Menu Lateral](https://i.postimg.cc/MpNDhTvr/4.png)

## Tecnologias Utilizadas

- **HTML**: Para estruturação do conteúdo.
- **CSS (Bootstrap)**: Para estilização e layout responsivo.
- **JavaScript**: Para funcionalidades interativas, como a troca de imagens e edição de informações.
- **Bootstrap Offcanvas**: Para implementar o menu lateral.

## Melhorias Futuras

Este projeto está em desenvolvimento e, no futuro, diversas melhorias serão implementadas para aprimorar a experiência do usuário e a escalabilidade do sistema. Algumas das principais melhorias planejadas incluem:

### 1. **Separação do Backend e Frontend**
Atualmente, o frontend e o backend estão integrados na mesma aplicação. Uma das melhorias futuras será a separação completa entre o frontend (interface do usuário) e o backend (lógica de negócios e banco de dados). Isso permitirá maior flexibilidade, escalabilidade e uma arquitetura mais limpa.

- **Frontend**: O frontend será desenvolvido utilizando tecnologias como HTML, CSS (Bootstrap), JavaScript (ou frameworks como React ou Vue.js), para uma experiência de usuário mais interativa e dinâmica.
  
- **Backend**: O backend será implementado utilizando **Java Spring Boot**, o que permitirá a criação de uma API RESTful robusta, além de facilitar a integração com outras aplicações e sistemas.

### 2. **Integração com Banco de Dados (MySQL)**
Para armazenar as informações de usuários, versículos favoritos, orações, etc., o projeto será integrado com um banco de dados relacional. O **MySQL** será utilizado para gerenciar esses dados, proporcionando persistência e escalabilidade.

- **Estrutura de Banco de Dados**: O banco de dados será projetado para armazenar informações de usuários, como nome, versículo favorito, ministério, interesses e orações, além das imagens de perfil e outras informações relevantes.
  
- **Spring Data JPA**: O uso do Spring Data JPA facilitará a integração entre o Java Spring e o banco de dados, permitindo a execução de consultas SQL através de métodos em repositórios, sem a necessidade de escrever código SQL manualmente.

### 3. **Autenticação e Autorização de Usuários**
Uma funcionalidade importante que será adicionada no futuro é a implementação de autenticação e autorização de usuários. Utilizando o **Spring Security**, será possível:

- **Login e Cadastro de Usuários**: Os usuários poderão se cadastrar e fazer login no sistema utilizando credenciais seguras (por exemplo, autenticação via email e senha).
  
- **Controle de Acesso**: Apenas usuários autenticados poderão acessar certas funcionalidades, como editar seu perfil e acessar conteúdo exclusivo.

### 4. **Melhoria na Interface de Usuário**
Com a separação do backend e frontend, a interface de usuário será ainda mais dinâmica e responsiva. Algumas melhorias possíveis incluem:

- **Personalização de Perfil**: Adicionar mais opções de personalização de perfil, como alterar o tema da interface ou adicionar informações adicionais (exemplo: adicionar foto de capa).
  
- **Interatividade**: Implementação de interatividade com o usuário utilizando frameworks de frontend como **React**, **Vue.js** ou **Angular**.

### 5. **Deploy em Nuvem**
O projeto será configurado para deploy em nuvem, permitindo que a plataforma seja acessada por qualquer usuário, de qualquer lugar. As opções de nuvem que serão consideradas incluem:

- **Heroku**: Para o deploy de backends Spring Boot e frontend estático.

### 6. **Funcionalidades Avançadas**
Algumas funcionalidades avançadas que serão adicionadas no futuro incluem:

- **Notificações Push**: Notificações para manter os usuários atualizados sobre novos conteúdos, como versículos ou eventos.
  
- **Histórico de Orações**: Armazenamento e exibição do histórico de orações, permitindo que os usuários revisitem suas orações passadas.
  
- **Integração com Redes Sociais**: Permitir que os usuários compartilhem versículos e orações em suas redes sociais diretamente da plataforma.

### 7. **Testes Automatizados**
O sistema passará a contar com uma suíte de testes automatizados, garantindo maior confiabilidade e segurança. Alguns testes planejados incluem:

- **Testes Unitários**: Para garantir que as funcionalidades do backend e frontend funcionem corretamente.
  
- **Testes de Integração**: Para garantir que a comunicação entre o backend e o banco de dados seja feita corretamente.

---

Essas melhorias visam não apenas aumentar a performance e a segurança do sistema, mas também proporcionar uma melhor experiência para os usuários e facilitar a manutenção do projeto a longo prazo. Fique atento às atualizações e contribua com sugestões!


## Como Executar o Projeto

1. Clone o repositório para o seu computador:

    ```bash
    git clone https://github.com/shakalinux/luta-da-fe.git
    ```

2. Abra o arquivo `index.html` no seu navegador para visualizar o projeto.

## Contribuição

Contribuições para o projeto são bem-vindas! Caso tenha ideias de melhorias ou correções, fique à vontade para abrir uma *pull request*.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais informações.
