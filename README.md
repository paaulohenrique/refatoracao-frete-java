
# 🧾 Refatoração: Cálculo de Frete com Strategy Pattern

## Objetivo
Melhorar a legibilidade, testabilidade e flexibilidade do cálculo de frete, eliminando condicionais complexas e seguindo o **Open/Closed Principle**.

---

## Problemas no Código Original
O código original usava vários `if/else` aninhados para tratar cada região:

```java
if (regiao.equals("SP")) {
    ...
} else if (regiao.equals("Exterior")) {
    ...
} else {
    ...
}
```

### Bad Smells Identificados
1. **Nested Conditionals** – Condicionais dentro de condicionais, dificultando leitura e manutenção.  
2. **Repeated Switches / Ifs** – O comportamento dependia de um parâmetro (`regiao`), repetindo o mesmo padrão.  
3. **Violação do Open/Closed Principle** – Para adicionar uma nova região, era preciso alterar a classe principal.

---

## Técnicas de Refatoração Aplicadas

### 1. Decompose Conditional
As condições foram extraídas para métodos nomeados, como:
```java
private boolean isPesoMaiorQue5kg(double peso)
private boolean isValorMaiorQue100(double valor)
```
Isso aumenta a **clareza** e **testabilidade**.

### 2. Replace Conditional with Polymorphism (Strategy Pattern)
- Criamos a **interface** `EstrategiaFrete` com o método `calcularFrete`.
- Cada tipo de frete (`FreteSP`, `FreteExterior`, `FreteNacional`) implementa sua própria lógica.
- A classe `CalculadoraFrete` apenas delega a execução à estratégia correta, **sem usar `if-else`**.

---

## Benefícios da Refatoração
- Diminui a **complexidade ciclomática** (menos caminhos de decisão).  
- Facilita **testes unitários** (cada estratégia é independente).  
- Segue o **princípio aberto/fechado**: novas regras não exigem alterar código existente.  
- Código mais **legível**, **modular** e **extensível**.

---

## Testes

| Região     | Peso (kg) | Valor (R$) | Resultado Esperado |
|-------------|-----------|-------------|--------------------|
| SP          | 3         | 50          | 5.0                |
| Exterior    | 2         | 150         | 60.0               |
| Nacional    | 4         | 80          | 15.0               |

---

## Resultado Esperado
```
Frete SP (3kg, R$50): 5.0
Frete Exterior (2kg, R$150): 60.0
Frete Nacional (4kg, R$80): 15.0
```
