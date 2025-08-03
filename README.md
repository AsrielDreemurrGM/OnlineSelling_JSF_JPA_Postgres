<h1>OnlineSelling_JSF_JPA_Postgres</h1>
<p>
  This README is also available in <a href="./README.pt-br.md">Português</a>
</p>
<p>
  A full-stack Java web application built with JSF (Jakarta Faces), JPA (Jakarta Persistence), and PostgreSQL. The project uses WildFly 30 as the deployment server and follows Jakarta EE standards. It demonstrates how to implement a functional product management system with JSF forms, PrimeFaces components, AJAX interactions, and a layered MVC structure using CDI.
</p>
<h2>🖼️ Demo Screenshot</h2>
<p>
  Below is a preview of the application UI showing the product form interface:
</p>
<p>
  <img src="https://servidor-host-imagens.vercel.app/Online_Selling_Fullstack_Demo.jpg" alt="Online Selling Fullstack Demo Screenshot" width="100%" />
</p>
<h2>🚀 Technologies Used</h2>
<ul>
  <li>Java 11</li>
  <li>Maven</li>
  <li>JSF (Jakarta Faces)</li>
  <li>JPA (Hibernate)</li>
  <li>PostgreSQL</li>
  <li>Jakarta EE</li>
  <li>CDI (Contexts and Dependency Injection)</li>
  <li>PrimeFaces with Dark Vela Theme</li>
  <li>WildFly 30</li>
  <li>AJAX (via PrimeFaces)</li>
</ul>
<h2>📁 Project Structure</h2>
<ul>
  <li><strong>model</strong>: Contains the JPA entity class (Product).</li>
  <li><strong>controller</strong>: Managed beans for JSF, handles UI logic.</li>
  <li><strong>service</strong>: Business logic and validations.</li>
  <li><strong>repository</strong>: Handles persistence operations via JPA.</li>
  <li><strong>resources/META-INF</strong>: Configuration files like <code>persistence.xml</code>.</li>
  <li><strong>webapp</strong>: JSF views (XHTML), including the product form.</li>
</ul>
<h2>🛠️ How to Run</h2>
<ol>
  <li>Ensure PostgreSQL is running and a database is created.</li>
  <li>Configure your <code>persistence.xml</code> to match your database settings and WildFly JNDI name.</li>
  <li>Deploy the project on WildFly 30.</li>
  <li>Access the app at: <code>localhost:8080/online-selling-1.0.0/productForm.xhtml</code></li>
</ol>
<h2>📌 Notes</h2>
<ul>
  <li>JSF pages use <code>&lt;h:form&gt;</code> and <code>p:inputText</code>, <code>p:commandButton</code>, and other PrimeFaces components.</li>
  <li>CDI is enabled via <code>beans.xml</code> for injection support.</li>
  <li>The form supports AJAX interaction for smooth validation and update experience.</li>
</ul>

