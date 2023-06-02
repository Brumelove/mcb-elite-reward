FROM docker.digitalfactory.mcb.local/mcb-dtp/openjdk:10.0-jdk-ojdbc8

ENV SERVER_PORT=8080
EXPOSE 8080

COPY target/mcb-wealth-workflow*.jar mcb-wealth-workflow.jar

ENTRYPOINT ["java",\
"-Dloader.main=mu.mcb.wealth.bpm.engine.WealthBpmEngineApplication",\
"-classpath","mcb-wealth-workflow.jar",\
"org.springframework.boot.loader.PropertiesLauncher"]
