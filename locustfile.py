import time
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(10, 30)
    
    @task(4)
    def index(self):
        self.client.get("/products")

