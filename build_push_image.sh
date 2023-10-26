#!/bin/bash

# membuat docker image dari Dockerfile
docker build -t tetanggaku/nlp-chat-service:v1 .

# menyesuaikan nama image dengan format GitHub Packages
docker tag tetanggaku/nlp-chat-service:v1 ghcr.io/dummyheaad/tetanggaku/nlp-chat-service:v1

# login ke GitHub Packages dengan Personal Access Token
echo $CR_PAT | docker login ghcr.io -u dummyheaad --password-stdin

# unggah image ke GitHub Packages
docker push ghcr.io/dummyheaad/tetanggaku/nlp-chat-service:v1
