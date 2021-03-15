# Introduction
- Pipelines exist. They are executed by build systems.
- They take a long time to execute, which is not efficient. Solution: incremental building: only rebuild the things that changed. Requires dependency tracking.
- Basically no build system supports precise dynamic dependencies.
  - Explain what precise means
  - explain what dynamic means
- To solve this: PIE
- PIE keeps precise track of dependencies. This can then be reused on next run. (caching of dependencies pending?)
- PIE is implemented in Java. This leads to a lot of boilerplate and is poor for expressing domain specific concepts.
- To solve this: PIE DSL. Removes the boilerplate, which saves time, improves maintainability and prevents bugs.
- PIE DSL code can be compiles to Java with the PIE compiler.

- problems with PIE DSL:
```
While the DSL and the compiler did work, they also had several shortcomings:
\begin{enumerate}
  \item Existing compilers were not maintainable.
  \item Does not scale to larger projects, e.g. projects that consist of multiple language projects.
  \item Implemented in NaBL2, which has a few limitations in expressiveness.
  \item Limitations in expressiveness of the PIE DSL.
  \begin{enumerate}
    \item No way to express core concepts of PIE, e.g. Suppliers and Results.
    \item No way to declare injected values for tasks.
  \end{enumerate}
\end{enumerate}
```

We wanted to improve the DSL. To do this, we used the following objectives:

```
\begin{itemize}
  \item Solve these problems
  \item Keep the PIE DSL general
  \begin{itemize}
    \item It could also compile to another language if another compiler and PIE framework were written in that language.
    \item It should work for pipelines in general, not just Spoofax pipelines.
  \end{itemize}
  \item Since PIE is meant to give realtime feedback in Spoofax, it should be reasonably performant
  \item Keep the PIE DSL extendable. Do not add features that are incompatible with future extensions of the language where this is reasonably possible.
\end{itemize}
```

In the end, we made the following contributions:
```
\begin{itemize}
  \item new compiler
  \item implemented static semantics in Statix
  \item Add modules, context parameters (and generics?) to the PIE DSL
  \item Evaluate the new DSL in three case studies:
  \begin{itemize}
    \item simple transformation from Tiger
    \item database pipelines at Oracle
    \item testing pipelines at Oracle
  \end{itemize}
\end{itemize}
```

# Problem analysis

- Use case: Spoofax pipelines
  - What is Spoofax?
  - What is language development?
  - What are pipelines that we want to express with the PIE DSL?
- 