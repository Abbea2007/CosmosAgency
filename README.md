📦 Sistema de Gestión Aduanera – Agencia Aduanera Cosmos S.A.

Optimización operativa mediante una base de datos relacional centralizada

📘 Descripción General

Agencia Aduanera Cosmos S.A. es una empresa nicaragüense fundada el 04 de febrero de 1994, dedicada al agenciamiento aduanero bajo el marco normativo CAUCA/RECAUCA. Durante más de 21 años, la agencia ha acompañado a importadores y exportadores aplicando estrictos controles, cumpliendo con los procedimientos exigidos a los auxiliares de la función pública aduanera.

Sin embargo, al carecer de un repositorio único de información, la empresa ha enfrentado problemas críticos como:

❌ Duplicidad e inconsistencia de datos (clientes, expedientes, variaciones no controladas).

❌ Facturación manual, con alto riesgo de errores.

❌ Clasificación arancelaria incorrecta por falta de catálogos centralizados.

❌ Cálculos manuales de tributos, propensos a fallos y rectificaciones.

❌ Riesgo de sanciones, retrasos operativos y pérdida de satisfacción del cliente.

Esta situación ha derivado en incumplimientos de SLA, decisiones gerenciales sin datos confiables y reprocesos constantes.
Como lo describe uno de los digitadores, Guillermo Díaz Hernández (2025):

“Por no contar con una base de datos única y confiable, traspapelé documentos de dos embarques y terminé liquidando uno con papeles del otro… detectaron la partida mal asociada y nos aplicaron una multa. Perdí horas corrigiendo todo y tuve que rehacer la liquidación.”

🎯 Objetivo del Proyecto

Desarrollar una base de datos relacional robusta, centralizada y confiable que permita gestionar de punta a punta todos los procesos operativos, documentales, tributarios y financieros de la Agencia Aduanera Cosmos.

Este sistema servirá como pilar para:

✔️ Optimizar tiempos operativos.

✔️ Reducir reprocesos, sanciones y errores humanos.

✔️ Estandarizar catálogos y validaciones.

✔️ Garantizar integridad referencial.

✔️ Facilitar análisis gerenciales y toma de decisiones.

✔️ Mejorar la satisfacción del cliente y cumplimiento de SLA.

🗃️ Alcance del Sistema

El diseño incluye cuatro grandes grupos de tablas, cada una cumpliendo una función clave:

1️⃣ Tablas de Catálogo (Base del Sistema)

Sirven para estandarización, validación de dominio y consistencia de datos.
Incluyen:

País

Moneda

Incoterms

Aduana

Unidad de Medida

Partida HS (Catálogo Arancelario)

2️⃣ Tablas Operativas

Modelan el flujo real del despacho aduanero:

Expediente

Declaración

Item de Declaración

Documento Soporte

Hito de Trazabilidad

3️⃣ Tablas Financieras

Automatizan cálculos tributarios y cobranza:

Liquidación de Tributos

Factura

Pago

4️⃣ Tablas de Configuración

Para control, seguridad y auditoría del sistema:

Usuario

Rol

UsuarioRol

Auditoría de Cambios

Todas las tablas están diseñadas con:

🔒 Integridad referencial.

📌 Índices esenciales.

🧪 Datos de prueba.

📏 Validaciones de dominio.

🛠️ Tecnologías y Herramientas

Modelado relacional

Gestión de catálogos

Normalización de datos

Diagramas UML

SQL (gestor a elección del proyecto)

Buenas prácticas de diseño de bases de datos

🚀 Impacto Esperado

Con la implementación de esta base de datos, la Agencia Aduanera Cosmos podrá:

📉 Reducir sanciones y errores en declaraciones.

⏱️ Mejorar tiempos de respuesta y cumplimiento de SLA.

📊 Tomar decisiones con datos confiables y oportunos.

💼 Profesionalizar la gestión interna.

🤝 Aumentar la satisfacción del cliente.

Este proyecto sienta las bases para futuras aplicaciones de escritorio o web que se apoyen en un backend sólido y bien estructurado.

📍 Ubicación y Atención

La agencia se encuentra ubicada de TransNica, cuadra y media al norte, módulo No. 7, atendiendo de lunes a sábado y extendiendo horarios según lo requiera la operación aduanera.

👤 Equipo Actual de Cosmos

2 agentes aduaneros

3 digitadores/aforadores

5 gestores

1 facturadora

1 conductor/mensajero

📌 Autor del Proyecto

Carlos Alfredo Abea Martínez
Estudiante de Ingeniería, apasionado por el análisis de datos, diseño de sistemas y desarrollo de soluciones empresariales.  


