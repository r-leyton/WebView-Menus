🏀 App S9 - MenuWebView

Aplicación Android de ejemplo que demuestra el uso combinado de WebView y los tres tipos de menús en Android: Options Menu, Context Menu y Popup Menu, aplicada al tema de equipos de la NBA.

📱 Descripción

Esta aplicación permite explorar contenido de equipos de básquet directamente desde la web oficial de la NBA. Además, incorpora distintos tipos de menús para interactuar con la WebView de forma dinámica.

🚀 Características

-WebView integrado: Carga contenido en vivo desde nba.com

-Options Menu: Permite cambiar entre los equipos Lakers, Warriors y Celtics

-Context Menu: Al hacer un long click sobre la WebView puedes:

-Recargar la página

-Abrir la URL actual en el navegador

-Popup Menu: Al presionar el botón, puedes:

-Compartir la URL actual

-Abrirla directamente en un navegador externo

-Interfaz sencilla y responsiva

-so de Material Design 3

📋 Requisitos
Android Studio Giraffe o superior

SDK mínimo: API 21 (Android 5.0)

SDK objetivo: API 34 (Android 14)

Kotlin 1.9.0 o superior


🛠️ Instalación
Clona el repositorio:
bash
Copiar
Editar
git clone https://github.com/tu-usuario/menuwebview.git
Abre el proyecto en Android Studio

Sincroniza con Gradle

Ejecuta la aplicación en un emulador o dispositivo real


💻 Uso
Cambia de equipo desde el menú superior (Options Menu)

Haz long click sobre la WebView para mostrar el menú contextual

Haz clic en "Mostrar Popup Menu" para ver acciones rápidas

Navega directamente al sitio web del equipo seleccionado


📖 Documentación
Para más detalles sobre la implementación de menús y WebView en Android con Kotlin, puedes revisar la clase MainActivity.kt y el uso de registerForContextMenu, PopupMenu y menuInflater.

![image](https://github.com/user-attachments/assets/b328c959-3ec1-40c9-abfb-1fe606e8a5ee)
![image](https://github.com/user-attachments/assets/f49c4a03-3ffc-495d-b280-232a37a5d0b7)
![image](https://github.com/user-attachments/assets/44398270-cf39-4b2e-9800-0134bce97db8)



