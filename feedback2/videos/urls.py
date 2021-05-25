from django.urls import path

from .views import index

from . import views

from django.contrib.staticfiles.urls import staticfiles_urlpatterns

urlpatterns = [
    path('', index)

]

urlpatterns += staticfiles_urlpatterns()