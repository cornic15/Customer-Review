from django.urls import path
from .views import ReviewListViews

urlpatterns = [
    path('', ReviewListViews.as_view(),name='review-list'),
]
