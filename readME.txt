This is an algorithm that implements kNN.

The dataset takes in different patients’ information and is primarily used to determine
the presence of diabetes.

There are nine attributes in total for each tuple (9 columns including weather the patient
has diabetes).

There are 768 tuples in total (recorded at the time the report was made).

A brief description about each of the 9 attributes (taken from comp3308 , Usyd
assignment scaffold):
 1 Number of times pregnant
 2 Plasma glucose concentration a 2 hours in an oral glucose tolerance test
 3 Diastolic blood pressure (mm Hg)
 4 Triceps skin fold thickness (mm)
 5 2-Hour serum insulin (mu U/ml)
 6 Body mass index (weight in kg/(height in m)^2)
 7 Diabetes pedigree function
 8 Age (years)
 9 Class variable ("yes" or "no")

Correlation based feature selection (CFS) method has been implemented on the dataset(on pima-CFS.csv, the one
without CFS implementation is pima.csv).

The CFS method has been implemented using Weka and it has been found out the attributes with
the highest correlation to the patient having diabetes (9th attribute) are attributes: 2,5,6,7 and 8
(attribute names can be found above).