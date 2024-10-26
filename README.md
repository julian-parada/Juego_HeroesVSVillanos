# Análisis SDLC del Juego de Combate

## 1. Fase de Planificación
### Objetivo del Proyecto
- Crear un juego de combate por turnos con héroes y villanos
- Permitir la selección de personajes
- Implementar un sistema básico de combate

### Requisitos Principales
- Sistema de selección de personajes
- Mecánicas de combate
- Interfaz por consola
- Sistema de victoria/derrota

## 2. Fase de Análisis
### Estructura del Sistema
- Clase abstracta base (MiJuego)
- Clases derivadas (opcion para héroes, opcion2 para villanos)
- Clase principal (Mio) para la ejecución del juego

### Características de los Personajes
- Atributos básicos: nombre, vida, poder, velocidad
- Atributos especiales: nivelBondad (héroes), nivelMaldad (villanos)
- Habilidades especiales para cada tipo de personaje

## 3. Fase de Diseño
### Arquitectura del Sistema
```
MiJuego (Clase abstracta)
├── opcion (Clase Héroe)
└── opcion2 (Clase Villano)
```

### Flujo del Juego
1. Inicio del programa
2. Selección de héroe
3. Selección de villano
4. Desarrollo del combate
5. Determinación del ganador

## 4. Fase de Implementación
### Componentes Principales
- Sistema de atributos y estadísticas
- Mecánica de combate por turnos
- Sistema de selección de personajes
- Lógica de poderes especiales

### Áreas de Mejora Potencial
- Implementar sistema de niveles
- Agregar más variedad de ataques
- Mejorar el sistema de turnos
- Añadir elementos visuales

## 5. Fase de Pruebas
### Casos de Prueba
- Selección de personajes
- Cálculo correcto de daño
- Funcionamiento de poderes especiales
- Determinación correcta del ganador

### Escenarios de Prueba
- Todas las combinaciones de héroes vs villanos
- Validación de entrada de usuario
- Verificación de cálculos de combate

## 6. Fase de Mantenimiento
### Mejoras Sugeridas
1. Refactorización:
   - Renombrar clases siguiendo convenciones
   - Mejorar la estructura del código
   - Optimizar la lógica de combate

2. Nuevas Características:
   - Sistema de inventario
   - Más personajes
   - Habilidades adicionales
   - Interfaz gráfica

3. Optimizaciones:
   - Mejor manejo de excepciones
   - Validación de entrada mejorada
   - Sistema de guardado
