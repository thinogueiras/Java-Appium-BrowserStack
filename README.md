# Automação de Testes para Android utilizando Java, JUnit 5 e Appium 9.2.0, com integração com o BrowserStack.

[![BrowserStack Tests](https://github.com/thinogueiras/Java-Appium-BrowserStack/actions/workflows/continuous-testing.yml/badge.svg?branch=main)](https://github.com/thinogueiras/Java-Appium-BrowserStack/actions/workflows/continuous-testing.yml)

## Pré-requisitos mínimos de ambiente:

* [Java](https://www.oracle.com/br/java/technologies/downloads/#java11) 11.0.x.

* [Android Studio](https://developer.android.com/studio).

```
npm install -g appium@2.1.3
```

```
npm install -g appium-doctor
```

```
appium driver install uiautomator2@2.29.4
```

### Necessário configurar o **`ANDROID_HOME`** e **`JAVA_HOME`** no **`PATH`** do S.O.

### Pelo ***Virtual Device Manager*** do ***Android Studio***, crie um device.

## Comandos extras para checagem do ambiente:

* Se o ambiente está OK: **`appium-doctor --android`**

* Verificar drivers instalados: **`appium driver list --installed`**

* Se o virtual device está ativo / online: **`adb devices`**


## IDE de desenvolvimento:

* [Eclipse](https://eclipseide.org).


## Clone do repositório:

```
git clone https://github.com/thinogueiras/Java-Appium-BrowserStack.git
```

## Abrir o projeto no Eclipse:

* Abra o Eclipse >> Menu File >> Import >> Maven >> Existing Maven Projects.
* Navegar até o repositório clonado >> Selecionar a pasta >> Finish.


## Execução dos testes:

### JUnit:

* Após importar o projeto com sucesso no Eclipse, clique para expandir o Source Folder: `src/test/java`, clique com o botão `direito` do mouse sobre o package: `qa.thinogueiras.appium.suite` >> Run As >> JUnit Test.

### Terminal:

``` 
mvn test
```

## Relatório:
#### No terminal, digite:

```
allure serve allure-results
```

---

<a href="https://www.linkedin.com/in/thinogueiras"><img alt="Linkedin" src="https://img.shields.io/badge/-LinkedIn-blue?style=for-the-badge&logo=Linkedin&logoColor=white"></a>

<strong>Thiago Nogueira dos Santos</strong> 🤓 ✌🏻

QA Automation Engineer 🔎 🐞
