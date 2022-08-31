<?php

class Clothes extends Controller{

    public function insert(){
        $clothesModel = $this->model('cloth');

        $_POST=json_decode(file_get_contents("php://input"),true);

        $clothdata=[
            "name"=>$_POST["name"],
            "gender"=>$_POST["gender"],
            "category"=>$_POST["category"],
            "image"=>$_POST["image"],
            "price"=>$_POST["price"],
            "description"=>$_POST["description"],
            "color"=>$_POST["color"]
        ];
        $insertsqlstring=InsertQueryGenerator("clothes",json_encode($clothdata));
        $response = $clothesModel->Add($insertsqlstring);
        $id=$response["result"];
        $getquerystring="select * from clothes where id=".$id;
         $getresponse=$clothesModel->getquery($getquerystring);
         echo json_encode($getresponse);
         exit;

    }
    
    public function getClothes(){

        $clothesModel = $this->model('cloth');

        $getquerystring="select * from clothes";
        $getresponse=$clothesModel->getquery($getquerystring);
        echo json_encode($getresponse);
        exit;

    }

    public function getbyid($id){

        $clothesModel = $this->model('cloth');

        $getquerystring="select * from clothes where id=".$id;
        $getresponse=$clothesModel->getquery($getquerystring);
        echo json_encode($getresponse);
        exit;

    }

    public function post(){
        print_r($_POST);
    }
}