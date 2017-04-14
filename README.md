# MVPSample

## MVP architecture in Android

This app basically follows MVP architecture. So, there are models which handle the database or the template that data being obtained from the internet shoud follow. The views handle all the UI related components, whereas the presenter is the link between the model and the ui.

I've used the following libraries - 
Rx Java 2 - mainly for creating background threads to handle the network calls
Butter Knife - bindings for views
Green Dao's Event Bus.
Google's GSON


## Brief Description of how the app works

Once the MainActivity's onCreate method is created, the MainActivity's presenter is also created, which in turn creates an Rx Java 
observable/observer pair to handle the network call. This result is then parsed by GSON and converted to the PostsModel POJO class which 
basically is the model for this app. This result is then sent out by the event bus from the presenter which is then "caught" by the main
activity which subscribes to the event. 
