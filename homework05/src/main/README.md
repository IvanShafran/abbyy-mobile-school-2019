# homework 06

Нужно реализовать делегирование класса Storage. https://kotlinlang.ru/docs/reference/delegated-properties.html

1. Создать класс StorageDelegate
2. Добавить поддержку всех функций Storage
3. Добавить файл с функцией вызова свойства, вида 
```
val id: Int by StorageDelegate("id", 20)
```
        