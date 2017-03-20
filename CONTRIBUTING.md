# Contributing

The goal of this project is to be contributed to. Therefore you are strongly encouraged to do so.
This is also why we tried to make it as easy as possible.

## Howto

To contribute, it is necessary to first fork the repository.

Then, `git clone` the forked repository to your computer and modify it.

After that, push the code up to your fork and use the web UI to create a pull request.
Please describe what the modifications were in the pull request title and body.

### Adding a new operation

To add a new operation, create a new class in the `matrixmath.calculations` package and implement
`matrixmath.calculations.IMathOperation`. For examples, see `matrixmath.calculations.DeterminantOperation`.