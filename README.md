# Система управления аптекой

## Обзор

Система управления аптекой — это проект на основе микросервисной архитектуры, разработанный для эффективного управления операциями аптеки. Он включает такие функции, как проектирование базы данных, операции CRUD, генерация отчетов и многое другое, все это реализовано с использованием Spring Boot и PostgreSQL. Проект следует лучшим практикам проектирования REST API, обработки ошибок и валидации данных.

## Микросервисная архитектура

Проект разделен на три микросервиса:
1. **Pharmacy Service**: Управляет операциями, связанными с аптекой.
2. **Report Service**: Генерирует отчеты на основе данных.
3. **Eureka Server**: Обеспечивает обнаружение сервисов для управления и нахождения микросервисов.

## Функции

1. **Проектирование базы данных**:
    - База данных PostgreSQL с хорошо определенной схемой.
    - Структура поддерживает различные сущности, такие как Медикаменты, Заказы, Клиенты и т.д.

2. **CRUD операции**:
    - Стандартные операции CRUD для всех сущностей.
    - Конечные точки для действий Создания, Чтения, Обновления и Удаления.

3. **Отчетность**:
    - Кастомные запросы для генерации различных отчетов:
        - Список всех доступных товаров в конкретной аптеке.
        - Общее количество и стоимость всех заказов за определенный период.
        - Список всех заказов для конкретного клиента по номеру телефона.
        - Информация о товарах, которые закончились на складе (quantity = 0).

4. **Интеграция с Spring Boot**:
    - REST API, построенное на Spring Boot.
    - Валидация данных на уровне API.
    - Обработка ошибок с соответствующими HTTP статусами.
    - Документация API с использованием Swagger.

5. **Тестирование**:
    - Юнит и интеграционные тесты с использованием JUnit и Mockito.

## Инструкции по установке

### Предварительные требования

- JDK 21
- Maven
- PostgreSQL
- IntelliJ IDEA (или любой другой предпочтительный IDE)

## Дополнительные функции
**Планировщик:**

Планировщик, который запускается каждую ночь для проверки уровня запасов и отправки уведомлений о низком уровне запасов.

**Метрики:**

Отслеживание количества запросов каждого отчета и сохранение результатов в базе данных.

**Экспорт отчетов:**

Генерация отчетов в форматах Excel и PDF.

**Поддержка Docker:**

Конфигурации Docker и Docker Compose для легкой настройки и развертывания.

**Безопасность:**

Интеграция с Keycloak для аутентификации и авторизации.

## Запуск микросервисов
### Порядок запуска
**Eureka Server:**

```bash
docker-compose -f eureka-server/docker-compose-eureka-server.yml up
```
**Report Service::**

```bash
docker-compose -f report-service/docker-compose-report-service.yml up
```

**Keycloak:**

```bash
docker-compose -f pharmacy-service/docker-compose-keycloak.yml up
```

**Pharmacy Service:**

```bash
docker-compose -f pharmacy-service/docker-compose-pharmacy-service.yml up
```

Запустите сервер обнаружения, чтобы остальные сервисы могли зарегистрироваться.

## Контакты
По любым вопросам или проблемам обращайтесь **[TELEGRAM](https://t.me/bakht_2003).**