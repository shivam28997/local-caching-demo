# Restaurant Finder application

* The Nearest Restaurant Finder application allows users to find the 10 nearest restaurants 
* based on their current geographical location (latitude and longitude). The application caches 
* the user’s location and the nearest restaurants to improve performance by reducing the need 
* to recalculate distances frequently. When a user's location changes, the cache is updated 
* to reflect the new nearest restaurants.

# Actors:
## User:

* A customer who wants to find nearby restaurants.
* Provides their current location (latitude and longitude) to get a list of the nearest restaurants.
* Can update their location, triggering a cache refresh for their nearest restaurants.

## System:
* Provides the functionality of calculating and caching the nearest restaurants based on the user’s location.
* Uses a HashMap to store restaurant data in memory.
* Uses Spring Cache to store the nearest restaurants in memory and updates the cache when the user's location changes.

## Restaurant:
* A physical location that provides food services.
* Each restaurant has a name, geographical coordinates (latitude and longitude), and a calculated distance from the user.
* The system stores the restaurant data in a HashMap with randomly assigned coordinates to simulate real restaurant data.