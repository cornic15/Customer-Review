from django.db import models

# Create your models here.
class Review(models.Model):
    rating = models.IntegerField()
    staff = models.CharField(max_length = 5)
    prompt_service = models.CharField(max_length = 5)
    price = models.CharField(max_length = 5)
    recommend =  models.CharField(max_length = 5)
    text_review = models.TextField()






 

def __str__(self):
    return self.name