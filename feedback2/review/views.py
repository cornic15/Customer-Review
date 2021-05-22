from django.views.generic import ListView
from .models import Review

# Create your views here.
class ReviewListViews(ListView):
    model = Review
    template_name = 'review-table.html'