plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.openapi.generator") version "7.4.0"
}

group = "com.leokenzley"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Swagger UI opcional (para testes com frontend)
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
}

openApiGenerate {
	generatorName.set("kotlin-spring")
	inputSpec.set("$rootDir/openapi/openapi.yaml")
	outputDir.set("$buildDir/generated") // TODO - mudar
	apiPackage.set("com.leokenzley.kotlinapi.api")
	modelPackage.set("com.leokenzley.kotlinapi.model")
	invokerPackage.set("com.leokenzley.invoker")
	configOptions.set(
		mapOf(
			"library"               to  "spring-boot",
			"basePackage"           to  "${project.group}",
			"apiPackage"            to  "${project.group}.api",
			"modelPackage"          to  "${project.group}.dto",
			"booleanGetterPrefix"   to  "is",
			"skipDefaultInterface"  to  "true",
			"interfaceOnly"         to  "true",
			"requestMappingMode"    to  "api_interface",
			"delegatePattern"       to  "false",
			"openApiNullable"       to  "false",
			"generateBuilders"      to  "true",
			"serializableModel"     to  "true",
			"useSpringBoot3"        to  "true",
			"useBeanValidation"     to  "true",
			"performBeanValidation" to  "true"
		)
	)
}

sourceSets["main"].java {
	srcDir("$buildDir/generated/src/main/kotlin")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.named("compileKotlin") {
	dependsOn("openApiGenerate")
}