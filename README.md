# Debouncable
[![](https://jitpack.io/v/RudolfHladik/debouncable.svg)](https://jitpack.io/#RudolfHladik/debouncable)

Debouncable action interface - to debounce user input actions

debouncing is good to prevent multiple clicks at the same time, double clicks and misclicks

# Usage

- add `Debouncable` interface to your class e.g. your `ViewModel` 
```
class MyViewModel : ViewModel() , Debouncable
```

- use `debounceAction` 

// MyViewModel.kt

```
fun onClick() {
  debounceAction {
    // this code will be debounced
  }
}
```

or more kotlin way

```
fun onClick() = debounceAction {
    // this code will be debounced
}
```

- method in lambda body will be debounced

Default debounce time limit is 200ms
 - you can modify it by overriding `defaultDebounceLimit` or pass a value to the `debounceAction`
   like this -> `debounceAction(400L) { /* block to be debounced */ }`
   
Explore the example to see it in full action

# Installation

- add jitpack url to project build.gradle
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```
  
- add library as dependency

```
dependencies {
	        implementation 'com.github.RudolfHladik:debouncable:1.0.0'
}
```
  

https://jitpack.io/#RudolfHladik/debouncable/1.0.0
