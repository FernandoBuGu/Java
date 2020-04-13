A simulation of random generation of human individuals from different races or ethnic 
subgroups. The individuals could have genomic differences according to biological distance. 
Germline and somatic mutations can be simulated in the created individuals from the 
corresponding reference genome. This could be applied to cancer studies, for instance, to
take into account the occurrence of benign mutations in different clinical subgroups.

The example is based on typeinfo/pets/PetCreator.java (page 406) Think in Java
4th Edition - Bruce Eckel.

The Registered Factories programming method defines a factory class
within each main class. In this case, a main class is defined for each human 
subgroup. Each factory can create objects from its corresponding subgroup.

- In "HumanSubgroupsFactories.java" the main classes with corresponding Factory
internal classes are defined.
- In "RegisteredFactories.java" a List is created with one factory of each time
and factories are randomly sampled to create individuals. 
- In "TypeCounter.java" a map class is defined that has as key Class objects 
of any kind and as value the number of occurrences of that key. 
- Finally, in "HumansCount.java" a map is defined with TypeCounter that takes
as key class objects of Human extensions (human subgroups). Using 
RegisteredFactories, individuals are randomly generated and the number of
individuals from each subgroup is reflected in the map.


Details:
Individuals are randomly generated from the different subgroups according to 
division hierarchy. For instance, if a mutation was simulated in the genome of 
an AsianFemale individual, that mutations will translate in the corresponding
mutation in the Asian and Human reference genomes.  
