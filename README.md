# Revolut

Application Test for Revolut

The solutions implements an MvvM architecture created from scratch to satisfy the requirements for this test.

The MvvM app uses a layer of Services to perform the Network request, with RxKotlin

The application is not 100% working due to a lack of time, but works as example 

The TODO's to finish the app are:
  - Update the data of the adapter, so we can work with two levels of index
    - The first level will be for the different currencies. This level will be cached, and won't be updated every second
    - The second level will contain the refs to the rates of the different currencies. This level will be implemente with LiveData's so the observers declared in the adapter will be aware in every moment of the currency's rate
    
Thanks for the time reading!

Kind Regards

Delfín Hernandez, Android Architect, Mobile Expert
