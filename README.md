# Revolut

Application Test for Revolut

The solutions implements an MvvM architecture created from scratch to satisfy the requirements for this test.

The MvvM app uses a layer of Services to perform the Network request, with RxKotlin

The Git project includes to branches with two different approaches

 - feature/linear-layout
    - In this branch we have use a linear layout as container for the views created for each currency
    - We have use Reflections methods and properties to extract the different currencies from the Revolut API Response
    - We have not use the Custom Adapter developed in the other branch, that the reason we have used the reflection

 - feature/rv-observables
    - In this branch we have develop a solution using a recycler view as container for the currency views
    - We have created a custom adapter with gson to grant us more flexibility with the currencies response.
      Allowing the API to include a new currency without no worries
    - This branch need an improvement, commented in its own Readme, but is working as expected


Thanks for the time reading.

Kind regards

Delfín Hernandez, Android Architect, Mobile Expert
