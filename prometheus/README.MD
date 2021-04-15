## Build config


from basedir
```bash
kubectl create configmap prometheus-config --from-file=prometheus/config/prometheus.yml --dry-run=client -o yaml > prometheus/prometheus-configmap.yaml
```