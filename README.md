# Date Range Annotator

UIMA ruta analysis engine annotating dates. This artifact is meant to be used as a component on the OpenMinted platform, it can however be used in any UIMA Fit pipeline.

Example of dates:
```
 2165±30 BP
 5840 +/- 30 BP
 BC 1400
 Cal BC 4280
 5500 B.P.
 between 8000 and 7000 yr BP
 10 000-11 450 cal. yr BP
 Cal BC 4135 to 40
```
Annotation type:
 - com.github.ewoij.openminted.components.date_range_annotator.Dates.DateRange
    - properties:
        - from: begin of date interval
        - to: end of date interval
    - note: the date are normalize to BP (before present)
    - example:
        - text: '2165 ± 30 BC' -> DateRange(from=4195, to=4135)
