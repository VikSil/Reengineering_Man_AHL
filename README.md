# Reengineering_Man_AHL

## Architecture Components

| Component | Source | Description | Logo| Notes |
|--|--|--|--|--|
| ||__ENVIRONMENT__| |
| Bare Metal | 2. | Hardware | <p align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/8/86/Server_tower_icon.jpg" title="Server"  alt="Server" width="55" height="55"/></p> |  |
| Linux | 5. | OS | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/linux/linux-original.svg" title="Linux"  alt="Linux" width="55" height="55"/></p> |  |
| OpenStack | 5. | Cloud IaaS. Basically, soft for provisioning bare metal into cloud resources | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/openstack/openstack-original.svg" title="openstack"  alt="openstack" width="55" height="55"/></p> |  |
| Prometheus | 5. | Server monitoring soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/prometheus/prometheus-original.svg" title="prometheus"  alt="prometheus" width="55" height="55"/></p> | Mentioned in close association with Grafana in source 1. |
| Grafana | 5. | Data visualisation soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/grafana/grafana-original.svg" title="grafana"  alt="grafana" width="55" height="55"/></p> | Mentioned in close association with Prometheus in source 1. Probably used to visualise output from Prometheus for continuous server monitoring |
| ||__INFRASTRUCTURE__|  |
| Docker | 5. | Containerisation soft, allows to deploy standardised images of other softs hardware agnostically | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/docker/docker-original.svg" title="docker"  alt="docker" width="55" height="55"/></p> | |
| Kubernetes | 5. | Container management soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/kubernetes/kubernetes-original.svg" title="kubernetes"  alt="kubernetes" width="55" height="55"/></p> |  |
| Ansible | 5. | Infra as code, provisioning soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/ansible/ansible-original.svg" title="ansible"  alt="ansible" width="55" height="55"/></p>  |  |
| ||__DATASOURCE__|  |
| RMDS/TREP | 1. | Reuters |  | Mentioned in close association with Kafka in source 1. |
| Kafka | 5. | Event logger | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/apachekafka/apachekafka-original.svg" title="apachekafka"  alt="apachekafka" width="55" height="55"/></p> | Mentioned in close association with RMDS/TREP in source 1. Probably used to log tick data into files|
| ||__STORAGE__|  |
| ArcticDB | 4. | Man's in-house open source data storage solution | <p align="center"><img src="https://github.com/man-group/ArcticDB/raw/master/static/ArcticDBCropped.png" title="arcticdb"  alt="arcticdb" width="55" height="55"/></p> | Mentioned in close association with MongoDB in source 1. |
| MongoDB | 5. | File based DB | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/mongodb/mongodb-original.svg" title="mongodb"  alt="mongodb" width="55" height="55"/></p> | Mentioned in close association with ArcticDB in source 1. |
| Oracle | 5. | Relational DB | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/oracle/oracle-original.svg" title="oracle"  alt="oracle" width="55" height="55"/></p> |  |
| ||__MINING__|  |
| Elasticsearch | | Indexing/search engine | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/elasticsearch/elasticsearch-original.svg" title="elasticsearch"  alt="elasticsearch" width="55" height="55"/></p> | Infering that Man uses this from ELKDocker, as it looks like a fitting solution to index datafiles in Mongo |
| Spark | 1. | Analytics engine for large-scale data | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/apachespark/apachespark-original.svg" title="apachespark"  alt="apachespark" width="55" height="55"/></p> | Probably both Apache Spark and PySpark|
| Airflow | 5. | Workflow management soft for data engineering pipelines | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/apacheairflow/apacheairflow-original.svg" title="apacheairflow"  alt="apacheairflow" width="55" height="55"/></p> |  |
| ||__PROGRAMMING__|  |
| Python3 - numpy | 5. | Array maths library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/numpy/numpy-original.svg" title="numpy"  alt="numpy" width="55" height="55"/></p> |  |
| Python3 - scipy | 5. | Scientific computing library | <p align="center"><img src="https://raw.githubusercontent.com/scipy/scipy/main/doc/source/_static/logo.svg" title="scipy"  alt="scipy" width="55" height="55"/></p> |  |
| Python3 - pandas | 5. | Dataframe manipulation library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/pandas/pandas-original.svg" title="pandas"  alt="pandas" width="55" height="55"/></p> |  |
| Python3 - scikit-learn | 5. | Machine learning library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/scikitlearn/scikitlearn-original.svg" title="scikitlearn"  alt="scikitlearn" width="55" height="55"/></p> |  |
| Python3 - TensorFlow | 5. | Machine learning library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/tensorflow/tensorflow-original.svg" title="tensorflow"  alt="tensorflow" width="55" height="55"/></p> |  |
| Java | 5. | General purpose programming language | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg" title="java"  alt="java" width="55" height="55"/></p> |  |
| C/C++ | 1. | General purpose programming languages | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/cplusplus/cplusplus-original.svg" title="cplusplus"  alt="cplusplus" width="55" height="55"/></p> |  |
| Bash |  | General purpose scripting languages | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/bash/bash-original.svg" title="bash"  alt="bash" width="55" height="55"/></p> | Unconfirmed, but Airfow uses bash to integrate with non-python scripts and source 4. mentions scirpting |
| ||__CI/CD__|  |
| Jenkins | 5. | Development pipeline automation soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/jenkins/jenkins-original.svg" title="jenkins"  alt="jenkins" width="55" height="55"/></p> |  |
| Bitbucket | 5. | Repository | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/bitbucket/bitbucket-original.svg" title="bitbucket"  alt="bitbucket" width="55" height="55"/></p> |  |
| Jira |  | Issue management soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/jira/jira-original.svg" title="jira"  alt="jira" width="55" height="55"/></p> | Unconfirmed, but BitBucket has tight integration with Jira and source 4. mentions agile |
| ||__TBD__|  |
| ELKDocker | 1. |  |  | Is this deviantony/docker-elk ? |


## Speculative Architecture Diagram

<p align = "center">
<img height= "680" src="https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/diagrams/architecture/Speculative_Architecture_latest.png" alt="Architecture Diagram"/>
</p>


## Sources

1. JD – Python Engineer – Market Data Platform.pdf (non-public)
2. PyData: James Blackburn - Python and MongoDB as a Platform for Financial Market Data, last accessed 2024-06-15, https://www.youtube.com/watch?v=FVyIxdxsyok
3. LinedIn_Ad_15-06-2024 14-09-47.png
4. ArcticDB homepage, last accessed 2024-06-15, https://arcticdb.io/
5. LinedIn_Ad_19-06-2024 20-39-27.png



