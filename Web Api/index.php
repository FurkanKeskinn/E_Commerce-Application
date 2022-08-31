<?php

require __DIR__ . '/database.php';
require __DIR__ . '/route.php';
require __DIR__ . '/controller.php';
require __DIR__ . '/model.php';
require __DIR__ . '/helper.php';

Route::run('/urun/ekle', 'clothes@insert','post');
Route::run('/urun/{url}', 'clothes@getbyid');
Route::run('/urunler', 'clothes@getClothes');
Route::run('/register', 'users@insert','post');
Route::run('/login', 'users@login','post');