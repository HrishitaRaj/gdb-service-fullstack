# Branching Strategy

## Main Branch

* Production-ready code.
* Protected branch.
* Direct commits are not allowed.

## Dev Branch

* Integration branch for development.
* All completed features are merged into dev before moving to main.

## Workflow

1. Developers work on feature branches.
2. Feature branches are merged into dev through Pull Requests.
3. After testing, dev is merged into main.
4. Main always contains stable code.
