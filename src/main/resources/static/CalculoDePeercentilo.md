# Cálculo de percentiles biométricos según Hadlock 1984

Referencia original:

Hadlock FP, Harrist RB, Deter RL, Park SK. "Estimating fetal age: Computer-assisted analysis of multiple fetal growth parameters." Radiology. 1984;152(2):497-501.

---

## 1. Circunferencia cefálica (HC)

Ecuación de media esperada (en cm):

HC_media = -11.48 + 1.562 × MA - 0.0002548 × MA³

Donde:
- MA = edad menstrual en semanas (semanas + días/7).
- Multiplicar el resultado por 10 para obtener milímetros.

Desviación estándar: 9.56 mm

Cálculo del z-score:
z = (HC_medido_mm - HC_media_mm) / SD

Percentil:
percentil = CDF_normal(z) × 100

Ejemplo:
20 semanas + 1 día, HC = 180 mm
- MA = 20.142857
- HC_media_cm = 17.90 cm → HC_media_mm = 179.01 mm
- z = (180 - 179.01) / 9.56 ≈ 0.104
- Percentil ≈ 54.1

---

## 2. Diámetro biparietal (BPD)

Ecuación de media esperada (en cm):

BPD_media = -19.61 + 0.7565 × MA - 0.000111 × MA³

Desviación estándar: 2.32 mm

z = (BPD_medido_mm - BPD_media_mm) / SD  
percentil = CDF_normal(z) × 100

Ejemplo:
20 semanas + 1 día, BPD = 48 mm
- BPD_media ≈ 49 mm
- z ≈ -0.43
- Percentil ≈ 33.4

---

## 3. Circunferencia abdominal (AC)

Ecuación de media esperada (en cm):

AC_media = -174.5 + 5.608 × MA - 0.000217 × MA³

Desviación estándar: 14.57 mm

z = (AC_medido_mm - AC_media_mm) / SD  
percentil = CDF_normal(z) × 100

Ejemplo:
20 semanas + 1 día, AC = 150 mm
- AC_media ≈ 153 mm
- z ≈ -0.21
- Percentil ≈ 41.6

---

## 4. Longitud femoral (FL)

Ecuación de media esperada (en cm):

FL_media = -12.12 + 0.2467 × MA - 0.00000337 × MA³

Desviación estándar: 1.75 mm

z = (FL_medido_mm - FL_media_mm) / SD  
percentil = CDF_normal(z) × 100

Ejemplo:
20 semanas + 1 día, FL = 33 mm
- FL_media ≈ 34 mm
- z ≈ -0.57
- Percentil ≈ 28.4

---

## Interpretación clínica general

- Percentil 50: medida promedio para la edad gestacional.
- Percentil <10: posible restricción de crecimiento (corroborar con contexto clínico y otras mediciones).
- Percentil >90: posible crecimiento acelerado o alteración estructural (corroborar con contexto clínico).
- Estas fórmulas están validadas para 14–42 semanas de gestación.

---

## Implementación en software

1. Convertir semanas y días a MA decimal.
2. Calcular media esperada según la ecuación.
3. Convertir a mm (multiplicar por 10).
4. Calcular z-score.
5. Obtener percentil usando la CDF de la normal estándar.
