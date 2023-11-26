# PhotographersApp with DDD and MVVM

Project to learn how to implement SOLID principles in Android development using DDD (Domain, Driven, Design) architecture. Consume an API Rest, save data locally and show it 👓

* Retrofit
* Room
* MVVM, LiveData, Coroutines
* Picasso for images
* Android Navigation


## Libraries 📚

* 📚 Kotlin Coroutines - For asynchronous programming
* 📚 Retrofit - For networking and API communication
* 📚 Room - To use an abstraction layer over SQLite
* 📚 Navigation component - For implement the navigation resource
* 📚 JUnit and MockK - For testing
* 📚 Picasso - For handling images
* 📚 Shimmer - To add a shimmer effect to any view like loading indicator


## Architecture ✏
The project follows the Clean DDD architecture using MVVM design pattern, which consists of the following layers:

* ✏ Presentation Layer: Contains the UI components, ViewModels, and XML files.
* ✏ Domain Layer: Contains the business logic and use cases.
* ✏ Data Layer: Contains the repositories, data sources, API communication.


## Folder Structure 📁
The project is structured as follows:

 📁 app/📁 src/📁 main  
&nbsp;&nbsp;📁 java/com/example/myapp  
&nbsp;&nbsp;&nbsp;&nbsp;📁 data -> Contains repository implementations and data sources  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📁 local repo -> Use for local data fetch  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📁 remote repo -> Use for remote data fetch  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📁 repo -> Use repo domain interface  
&nbsp;&nbsp;&nbsp;&nbsp;📁 domain -> Contains use cases and business logic  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📁 models -> Contains model classes  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📁 repo interface -> Interface of domain repository  
&nbsp;&nbsp;&nbsp;&nbsp;📁 ui -> Contains ViewModels and UI components  

## Getting Started

To run the application in your local machine you need to download this project and execute it in Android Studio or another IDE compatible with Android developments.

### Technologies

* Android Studio → Kotlin ✔
* Kotlin Coroutines ✔
* Retrofit ✔
* Room ✔
