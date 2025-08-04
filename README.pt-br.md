<h1>OnlineSelling_JSF_JPA_Postgres</h1>
<p>
  This README is also available in <a href="./README.md">English</a>
</p>
<p>
  Uma aplicação web full-stack em Java, construída com JSF (Jakarta Faces), JPA (Jakarta Persistence) e PostgreSQL. O projeto utiliza o WildFly 30 como servidor de aplicação e segue os padrões do Jakarta EE. Ele demonstra como implementar um sistema funcional de gerenciamento de produtos com formulários JSF, componentes do PrimeFaces, interações AJAX e uma estrutura MVC em camadas usando CDI.
</p>
<h2>🖼️ Captura de Tela da Aplicação</h2>
<p>
  Abaixo está uma prévia da interface da aplicação exibindo o formulário de produto:
</p>
<p>
  <img src="https://servidor-host-imagens.vercel.app/Online_Selling_Fullstack_Demo.jpg" alt="Captura de Tela da Aplicação Online Selling" width="100%" />
</p>
<h2>🚀 Tecnologias Utilizadas</h2>
<ul>
  <li>Java 11</li>
  <li>Maven</li>
  <li>JSF (Jakarta Faces)</li>
  <li>JPA (Hibernate)</li>
  <li>PostgreSQL</li>
  <li>Jakarta EE</li>
  <li>CDI (Contexts and Dependency Injection)</li>
  <li>PrimeFaces com Tema Escuro Vela</li>
  <li>WildFly 30</li>
  <li>AJAX (via PrimeFaces)</li>
</ul>
<h2>📁 Estrutura do Projeto</h2>
<ul>
  <li><strong>model</strong>: Contém a classe de entidade JPA (Product).</li>
  <li><strong>controller</strong>: Beans gerenciados pelo JSF, responsáveis pela lógica da interface.</li>
  <li><strong>service</strong>: Lógica de negócios e validações.</li>
  <li><strong>repository</strong>: Responsável pelas operações de persistência via JPA.</li>
  <li><strong>resources/META-INF</strong>: Arquivos de configuração como <code>persistence.xml</code>.</li>
  <li><strong>webapp</strong>: Páginas JSF (XHTML), incluindo o formulário de produto.</li>
</ul>
<h2>🛠️ Como Executar</h2>
<ol>
  <li>Certifique-se de que o PostgreSQL está em execução e que o banco de dados foi criado.</li>
  <li>Configure seu <code>persistence.xml</code> com os dados corretos do banco e nome JNDI do WildFly.</li>
  <li>Faça o deploy do projeto no WildFly 30.</li>
  <li>Acesse a aplicação em: <code>localhost:8080/online-selling-1.0.0/productForm.xhtml</code></li>
</ol>
<h2>📌 Observações</h2>
<ul>
  <li>As páginas JSF utilizam <code>&lt;h:form&gt;</code>, <code>p:inputText</code>, <code>p:commandButton</code> e outros componentes do PrimeFaces.</li>
  <li>O CDI está habilitado via <code>beans.xml</code> para suporte à injeção de dependência.</li>
  <li>O formulário possui interação via AJAX para uma experiência de validação e atualização mais fluida.</li>
</ul>
<h2>🗂️ Branches Adicionais</h2>
<ul>
  <li>
    <strong><code>tomcat-deploy-version</code></strong>: Versão alternativa do projeto adaptada para deploy manual com Apache Tomcat.
    <ul>
      <li>Criada para cumprir uma atividade prática do curso.</li>
      <li>Utiliza uma estratégia de deploy diferente, sem configurações específicas do WildFly.</li>
      <li>Essa branch não deve ser mesclada com a <code>main</code>.</li>
    </ul>
  </li>
</ul>
