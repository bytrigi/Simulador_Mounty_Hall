# 🎯 Simulador del Problema de Monty Hall

Este proyecto implementa una **simulación completa del famoso problema de las tres puertas (Monty Hall)**.  
El programa permite analizar y comparar diferentes estrategias del concursante en este juego de probabilidad.

---

## 🧩 Descripción del problema

El juego consiste en tres puertas cerradas, de las cuales **solo una contiene un premio**.  
El concursante elige una puerta, y a continuación el presentador abre una de las otras dos, **mostrando una puerta sin premio**.  
En ese momento, el concursante debe decidir si **mantiene su elección original** o **cambia a la otra puerta cerrada**.

El objetivo del simulador es determinar **qué estrategia resulta más efectiva** a través de un gran número de partidas simuladas automáticamente.

---

## ⚙️ Funcionamiento del programa

El simulador ejecuta **N partidas** (por ejemplo, 100) del juego, generando resultados de manera totalmente aleatoria.  
En cada iteración, el programa:

1. **Genera aleatoriamente** la puerta con el premio (`0`, `1` o `2`).
2. **Simula la elección inicial** del concursante.
3. **Determina la puerta abierta por el presentador**, que siempre es diferente de la elegida y no contiene premio.
4. **Identifica la otra puerta cerrada**, que representa la opción alternativa para el concursante.

Después de esto, se calculan los resultados para dos estrategias:

- 🅰️ **Mantener la puerta elegida inicialmente.**
- 🅱️ **Cambiar a la otra puerta cerrada.**

El simulador cuenta cuántas veces el concursante gana con cada estrategia, permitiendo calcular las tasas de éxito.

---

## 📊 Resultados

Tras completar todas las partidas, el programa muestra un resumen estadístico con el número total de partidas y los porcentajes de éxito de cada estrategia:

