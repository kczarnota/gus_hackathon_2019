# World Explorers - GUS Hackahon 2019

# Opis

Aplikacja łączy się za bazami danych Eurostat oraz Bankiem Danych Lokanlnych (BDL)
i na podstawie uzyskanych danych dopasowuje wykresy do obiektów. Zastosowana
została sieć neuronowa YOLOv2tiny, która pozwala na detekcję klas przedmiotów
za pomocą obrazu z kamery telefonu. Aplikacja zawiera elementy grywalizacji,
takie jak osiągnięcia po rozpoznaniu ciekawych obiektów oraz ranking.
Użytkownicy mogą dzielić się zdjęciami z których uzsyskali ciekawe dane statystyczne
poprzez publikowanie statusów na Facebook.

# Zastosowane technologie

- Android / Java
- biblioteka Tensorflow Lite wykorzystywana do detekcji obietków na obrazie z kamery
- Json Rest API przy łączeniu się do baz Eurostat i BDL

# Środowisko programistyczne

- Android API Level 23 (Android 6.0 Marshallow)
- Android Studio 3.3.2

# Aplikacja została przestowana na następujących telefonach
- Xiaomi Redmi Note 4
- HTC 820
- Xiaomi Mi 8 Lite
- Samsung Galaxy S8
