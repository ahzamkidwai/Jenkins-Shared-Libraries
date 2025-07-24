# Jenkins Shared Library

This repository hosts a Jenkins Shared Library containing reusable pipeline code written in Groovy. It allows teams to centralize and modularize their Jenkinsfile logic, promoting reuse and consistency across CI/CD workflows.

---

## 📁 Directory Structure

(root)
├── vars/ # Global accessible pipeline steps (as functions)
│ └── exampleStep.groovy


---

## ✅ Usage

To use this shared library in your Jenkins pipeline:

1. Add this library in **Jenkins → Manage Jenkins → Configure System → Global Pipeline Libraries**

   - **Name**: `your-shared-library-name`
   - **Default Version**: `main` (or your default branch)
   - **Retrieval Method**: Modern SCM → Git
   - **Project Repository**: `<your-repo-url>`

2. In your Jenkinsfile:

```groovy
@Library('your-shared-library-name') _

pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                exampleStep()
            }
        }
    }
}
