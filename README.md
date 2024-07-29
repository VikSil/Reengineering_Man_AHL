# Reengineering_Man_AHL

## Background

In July 2024 I was contacted by a headhunter looking to hire a Python Engineer for the Man Group. In order to prepare for an interview I spent a few days studying the tech stack that was listed in the [job description](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_15-06-2024%2014-09-47.png) \[3\]. Nothing really came of the interview, but I did come up with a possible overall architecture diagram (see below) and found out that [Man AHL](https://github.com/man-group) are largely open source. This repo is a place to put *stuff* as I learn more about their tech stack.

## Architecture Components

The folowing technologies have been mentioned in connection to Man Group in various open sources: 

| Component | Source | Description | Logo| Notes |
|--|--|--|--|--|
| ||__ENVIRONMENT__| |
| Bare Metal | 2. | Hardware | <p align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/8/86/Server_tower_icon.jpg" title="Server"  alt="Server" width="55" height="55"/></p> |  |
| Linux | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png). | OS | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/linux/linux-original.svg" title="Linux"  alt="Linux" width="55" height="55"/></p> |  |
| OpenStack | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Cloud IaaS. Basically, soft for provisioning bare metal into cloud resources | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/openstack/openstack-original.svg" title="openstack"  alt="openstack" width="55" height="55"/></p> |  |
| Prometheus | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Server monitoring soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/prometheus/prometheus-original.svg" title="prometheus"  alt="prometheus" width="55" height="55"/></p> | Mentioned in close association with Grafana in source 1. |
| Grafana | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Data visualisation soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/grafana/grafana-original.svg" title="grafana"  alt="grafana" width="55" height="55"/></p> | Mentioned in close association with Prometheus in source 1. Probably used to visualise output from Prometheus for continuous server monitoring |
| ||__INFRASTRUCTURE__|  |
| Docker | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Containerisation soft, allows to deploy standardised images of other softs hardware agnostically | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/docker/docker-original.svg" title="docker"  alt="docker" width="55" height="55"/></p> | |
| Kubernetes | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Container management soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/kubernetes/kubernetes-original.svg" title="kubernetes"  alt="kubernetes" width="55" height="55"/></p> |  |
| Ansible | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Infra as code, provisioning soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/ansible/ansible-original.svg" title="ansible"  alt="ansible" width="55" height="55"/></p>  |  |
| ||__DATASOURCE__|  |
| RMDS/TREP | 1. | Reuters |  | Mentioned in close association with Kafka in source 1. |
| Kafka | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Event logger | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/apachekafka/apachekafka-original.svg" title="apachekafka"  alt="apachekafka" width="55" height="55"/></p> | Mentioned in close association with RMDS/TREP in source 1. Probably used to log tick data into files|
| ||__STORAGE__|  |
| ArcticDB | 4. | Man's in-house open source data storage solution | <p align="center"><img src="https://github.com/man-group/ArcticDB/raw/master/static/ArcticDBCropped.png" title="arcticdb"  alt="arcticdb" width="55" height="55"/></p> | Mentioned in close association with MongoDB in source 1. |
| MongoDB | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | File based DB | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/mongodb/mongodb-original.svg" title="mongodb"  alt="mongodb" width="55" height="55"/></p> | Mentioned in close association with ArcticDB in source 1. |
| Oracle | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Relational DB | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/oracle/oracle-original.svg" title="oracle"  alt="oracle" width="55" height="55"/></p> |  |
| ||__MINING__|  |
| Elasticsearch | | Indexing/search engine | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/elasticsearch/elasticsearch-original.svg" title="elasticsearch"  alt="elasticsearch" width="55" height="55"/></p> | Infering that Man uses this from ELKDocker, as it looks like a fitting solution to index datafiles in Mongo |
| Spark | 1. | Analytics engine for large-scale data | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/apachespark/apachespark-original.svg" title="apachespark"  alt="apachespark" width="55" height="55"/></p> | Probably both Apache Spark and PySpark|
| Airflow | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Workflow management soft for data engineering pipelines | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/apacheairflow/apacheairflow-original.svg" title="apacheairflow"  alt="apacheairflow" width="55" height="55"/></p> |  |
| ||__PROGRAMMING__|  |
| Python3 - numpy | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Array maths library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/numpy/numpy-original.svg" title="numpy"  alt="numpy" width="55" height="55"/></p> |  |
| Python3 - scipy | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Scientific computing library | <p align="center"><img src="https://raw.githubusercontent.com/scipy/scipy/main/doc/source/_static/logo.svg" title="scipy"  alt="scipy" width="55" height="55"/></p> |  |
| Python3 - pandas | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Dataframe manipulation library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/pandas/pandas-original.svg" title="pandas"  alt="pandas" width="55" height="55"/></p> |  |
| Python3 - scikit-learn | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Machine learning library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/scikitlearn/scikitlearn-original.svg" title="scikitlearn"  alt="scikitlearn" width="55" height="55"/></p> |  |
| Python3 - TensorFlow | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Machine learning library | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/tensorflow/tensorflow-original.svg" title="tensorflow"  alt="tensorflow" width="55" height="55"/></p> |  |
| Java | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | General purpose programming language | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg" title="java"  alt="java" width="55" height="55"/></p> |  |
| C/C++ | 1. | General purpose programming languages | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/cplusplus/cplusplus-original.svg" title="cplusplus"  alt="cplusplus" width="55" height="55"/></p> |  |
| Bash |  | General purpose scripting languages | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/bash/bash-original.svg" title="bash"  alt="bash" width="55" height="55"/></p> | Unconfirmed, but Airfow uses bash to integrate with non-python scripts and source 4. mentions scirpting |
| ||__CI/CD__|  |
| Jenkins | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Development pipeline automation soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/jenkins/jenkins-original.svg" title="jenkins"  alt="jenkins" width="55" height="55"/></p> |  |
| Bitbucket | [5](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/sources/LinkedIn_Ad_19-06-2024%2020-39-27.png).  | Repository | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/bitbucket/bitbucket-original.svg" title="bitbucket"  alt="bitbucket" width="55" height="55"/></p> |  |
| Jira |  | Issue management soft | <p align="center"><img src="https://github.com/devicons/devicon/blob/master/icons/jira/jira-original.svg" title="jira"  alt="jira" width="55" height="55"/></p> | Unconfirmed, but BitBucket has tight integration with Jira and source 4. mentions agile |
| ||__TBD__|  |
| ELKDocker | 1. |  |  | Is this deviantony/docker-elk ? |


## Speculative Architecture Diagram

<p align = "center">
<img height= "680" src="https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/diagrams/architecture/Speculative_Architecture_latest.png" alt="Architecture Diagram"/>
</p>


## Learning Resources

In order to get a better grasp on the technologies listed above, I have compiled a list of learning resources, available [here](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/Learning_Resources.md).

## Sources

1. JD – Python Engineer – Market Data Platform.pdf (non-public)
2. PyData: James Blackburn - Python and MongoDB as a Platform for Financial Market Data, last accessed 2024-06-15, https://www.youtube.com/watch?v=FVyIxdxsyok
3. LinedIn_Ad_15-06-2024 14-09-47.png
4. ArcticDB homepage, last accessed 2024-06-15, https://arcticdb.io/
5. LinedIn_Ad_19-06-2024 20-39-27.png



