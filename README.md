# Car Parking-Slot Management System

## Overview

The Car Parking Management System is a Spring Boot application designed to manage and monitor a car parking facility. The system includes functionalities for vehicle entry, and exit, and provides real-time monitoring of parking space availability. Additionally, it utilizes the ELK stack for efficient log ingestion, storage, and visualization.

## Features

- Vehicle Entry and Exit Management
- Real-time Parking Space Availability
- ELK Stack Integration for Logging

## Technologies Used

- Spring Boot
- ELK Stack
  - Elasticsearch
  - Logstash
  - Kibana

## Setup
1. **Access the Application:**

    Open a web browser and go to [http://localhost:3000]

2. **ELK Stack Configuration:**
    - Install and configure Elasticsearch, Logstash, and Kibana.
    - Ensure Logstash is configured to ingest logs from the Spring Boot application.

## ELK Stack Integration

### Elastic Search Dashboard
  - Download Elastic Search by using this link for Windows system [https://www.elastic.co/downloads/elasticsearch]
  - Extract the contents of the downloaded ZIP file to a directory.
  - Run the elastic search using this command "bin\elasticsearch.bat" in cmd.
  - Elasticsearch will start, and you'll see log messages indicating that the server is running.
  - Open a web browser and navigate to [http://localhost:9200] provide the username and password provided in the cmd.
  - If Elasticsearch is running correctly, you should see a JSON response indicating the cluster and node information.

### Kibana Dashboard
  - Download Kibana by using this link for Windows system [https://www.elastic.co/downloads/kibana]
  - Extract the contents of the downloaded ZIP file to a directory.
  - Run the elastic search using this command "bin\bin\kibana.bat" in cmd.
  - Open a web browser and navigate to http://localhost:5601.
  - Provide the token given in the cmd and also the elastic search login credentials from the previous elastic search cmd.
  - If Kibana is running correctly, you should see the Kibana login screen.
  - This dashboard provides visualizations and insights into the application logs.

### Logstash Configuration
  - Download Logstash by using this link for Windows system [https://www.elastic.co/downloads/logstash]
  - Extract the contents of the downloaded ZIP file to a directory.
  - Edit the "logstash-simple.conf" file and give the path of the file and start position in the input section and in the output section give the elasticseacrh credentials, hosts, and index.
  - Save the conf file and start the logstash by using this command "bin\logstash -f logstash-simple.conf"

## Acknowledgments
  - Thanks for giving me this opportunity. 
