#!/bin/bash
kubectl delete -f mysql/k8s
kubectl delete -f k8s
kubectl delete -f prometheus