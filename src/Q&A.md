What am I doing?
> Improving the DSL (includes the PIE compiler)  
Why am I doing that?
> So that the case studies (and hopefully other things) will run
Why do we want the case studies to run?
> To prove that the PIE DSL (and PIE in general) works
> Because we want to do these things with PIE
What are "these things"?
> Execute pipelines. In our case, mostly Spoofax pipelines
What is Spoofax?
> A language workbench, including meta-DSLs for common language engineering aspects.
What is a language workbench?
> IDE for implementing (and designing?) programming languages
What is a meta-DSL?
> DSL for specifying some aspect of programming languages (e.g. SDF3 to specify the grammar of a language)
What are Spoofax pipelines?
> Building languages
> Updating editor windows
   - from meta-DSLs
   - from user DSL
Why do we want to do these things with PIE?
> Because the existing build systems do not support everything we need (expressiveness, conciseness, precision, dynamic dependencies, incremental builds, automatic persistence)
Why do we need those properties?
> Expressiveness and conciseness to make the code easier to write, easier to iterate, more maintainable and less likely to contain bugs
> Precision to avoid overapproximation and underapproximation
  > underapproximation: avoid errors from using outdated outputs
  > overapproximation: save time by only building the things that are outdated
> Dynamic dependencies because not all dependencies are known statically (e.g. file extension for example files is defined in esv file, language under test is defined within SPT file, project dependencies are declared in .yaml file)
> Incremental builds to save time (don't rebuild things that are still up to date)
> Automatic persistence
   > Persistence: don't rebuild on restart, persist the results to disk.
   > Automatic: don't burden the pipeline developer with persistence, it is error prone, tedious and verbose.
