from django.db import models

# Create your models here.
class Review(models.Models):
    title = models.CharField(max_length=200)
def __str__(self):
    return self.title