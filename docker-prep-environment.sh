#!/bin/bash


# Setup the docker bank platform network

check_network(){

  NETWORK_NAME="bp-network"
  echo "Checking network"
  # Check if network exists
  if docker network inspect $NETWORK_NAME >/dev/null 2>&1 ; then
    echo "Network exists"
  else
    echo "Network does not exist. Creating..."
    docker network create --driver=bridge --subnet=192.168.201.0/24 --gateway=192.168.201.1 bp-network
    echo "Done creating network"
  fi

}


check_network



