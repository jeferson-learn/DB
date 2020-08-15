# PROVA_API

Prática da automação de API

### Lista conteudo
- Consulta CEP
	- Consulta CEP válido
		- Imprimir o que consultou CEP
	- Consulta CEP inexistente
		- Imprimir "erro = true"
	- Consulta CEP inválido
		- Imprimir erro 400
	
### Pré-requisitos

- Linguagem de programação: JAVA
- IDE (Intellij 2020.1)
- Java versão: 1.8
- Allure

### Build
```
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<configuration>
				<source>8</source>
				<target>8</target>
			</configuration>
		</plugin>
		<plugin>
			<groupId>io.qameta.allure</groupId>
			<artifactId>allure-maven</artifactId>
			<version>2.10.0</version>
		</plugin>
	</plugins>
</build>
```

### Dependências

- Junit 5.6.2 
- Rest assured 4.3.1
- Qameta allure (maven) 2.10.0
- Qameta allure (junit5) 2.13.2

### Reporting
```
<reporting>
	<excludeDefaults>true</excludeDefaults>
	<plugins>
		<plugin>
			<groupId>io.qameta.allure</groupId>
			<artifactId>allure-maven</artifactId>
			<version>2.10.0</version>
		</plugin>
	</plugins>
</reporting>
```

### Instalar ALLURE
#### Segue passos a passo
- Abrir PowerShell, segue comando ``Set-ExecutionPolicy RemoteSigned -Scope CurrentUser``
- Vai aparecer alguns opções, vai digitir [S] 'SIM = portugues' ou [Y] 'YES = ingles'
- Seguida comando ``iex (new-object net.webclient).downloadstring('https://get.scoop.sh')`` e realizado instalação
- Proximo que deve instalar os programas 'OPENSSH e GIT'
- Segue PowerShell, comando ``scoop install openssh`` depois comando ``scoop install git`` e utlimo ``scoop install allure``
- (Quando após execução, abrir pasta do projeto e botão direita abrir "git bash" comando ``allure serve allure-results``)