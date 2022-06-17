Stos technologiczny projektu:
Java, Spring, Angular, Android(java)

Diagram klas:

![img.png](img.png)
Diagram bazy danych:

![img_1.png](img_1.png)

REST API:

NoteController:

1. Get mapping  "<host>/api/notes/" - Pobierz wszystkie notatki.
2. Get mapping  "<host>/api/notes/{aId}" - Pobierz notatkę o zadanym numerze id.
3. Post mapping "<host>/api/notes/addNote" - Dodaj nową notatkę.
4. Put mapping "<host>/api/notes/editNote" - Edytuj notatkę.
5. Delete mapping "<host>/api/notes/deleteNote" - Usuń notatkę o zadanym numerze id.

RegisterController:
1. Post mapping "<host>/register" - Dodaj nowego użytkownika.



Klient Android:
Wykorzystane biblioteki:
1. ReactiveX
2. Retrofit2
3. Okhttp3

Obsługa podstawowych operacji CRUD notatek poprzez aktywności:
1. Pobieranie wielu notatek w oparciu o kontroler API [1]
2. Pobieranie jednej notatki w oparciu o kontroler API [2]
3. Dodawanie notatki w oparciu o kontroler API [3]
4. Aktualizowanie/edycja notatki w oparciu o kontroler API [4]
5. Usuwanie notatki w oparciu o kontroler API [5]

Do połączeń z API wykorzystywana jest klasa Request z biblioteki okhttp3.
Dane są wysyłane i odbierane korzystając z JSON.

Wykorzystywane są 2 modele:
1. Content - zawiera zawartość notatki
2. Note - notatka zawierająca tytuł i zawartość
