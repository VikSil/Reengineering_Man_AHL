# Reengineering_Man_AHL

## Architecture Components

| Component | Source | Description | Notes |
|--|--|--|--|
| ||__ENVIRONMENT__|
| Linux | 1. | OS |  |
| OpenStack | 1. | Cloud IaaS. Basically, soft for provisioning bare metal into cloud resources |  |
| Prometheus | 1. | Server monitoring soft | Mentioned in close association with Grafana in source 1. |
| Grafana | 1. | Data visualisation soft | Mentioned in close association with Prometheus in source 1. Probably used to visualise output from Prometheus for continuous server monitoring |
| ||__INFRASTRUCTURE__|
| Docker | | Containerisation soft, allows to deploy standardised images of other softs hardware agnostically | |
| Kubernetes | 1. | Container management soft |  |
| Ansimble | 1. | Infra as code, provisioning soft |  |
| ||__DATASOURCE__|
| RMDS/TREP | 1. | Reuters | Mentioned in close association with Kafka in source 1. |
| Kafka | 1. | Event logger | Mentioned in close association with RMDS/TREP in source 1. Probably used to log tick data into files|
| ||__STORAGE__|
| ArcticDB | 4. | Man's in-house open source data storage solution | Mentioned in close association with MongoDB in source 1. |
| MongoDB | 1. | File based DB | Mentioned in close association with ArcticDB in source 1. |
| Oracle | 1. | SQL DB |  |
| ||__MINING__|
| Elasticsearch | | Indexing/search engine | Infering that Man uses this from ELKDocker, as it looks like a fitting solution to index datafiles in Mongo |
| Spark | 1. | Analytics engine for large-scale data | Probably both Apache Spark and PySpark|
| Airflow | 1. | Workflow management soft for data engineering pipelines |  |
| ||__PROGRAMMING__|
| Python3 - numpy | 1. | Array maths library |  |
| Python3 - scipy | 1. | Scientific computing library |  |
| Python3 - pandas | 1. | Dataframe manipulation library |  |
| Python3 - scikit-learn | 1. | Machine learning library |  |
| Java | 1. | General purpose programming language |  |
| C/C++ | 1. | General purpose programming languages |  |
| ||__CI/CD__|
| Jenkins | 1. | Development pipeline automation soft |  |
| Bitbucket | 1. | Repository |  |
| Jira |  | Issue management soft | Unconfirmed, but BitBucket has tight integration with Jira and source 2. mentions agile |
| ||__TBD__|
| ELKDocker | 1. |  | Is this deviantony/docker-elk ? |





## Sources

1. JD – Python Engineer – Market Data Platform.pdf (non-public)
2. PyData: James Blackburn - Python and MongoDB as a Platform for Financial Market Data, last accessed 2024-06-15, https://www.youtube.com/watch?v=FVyIxdxsyok
3. LinedIn_Ad_15-06-2024 14-09-47.png
4. ArcticDB homepage, last accessed 2024-06-15, https://arcticdb.io/



