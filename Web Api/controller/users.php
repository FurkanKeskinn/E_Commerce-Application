<?php

class Users extends Controller
{
    private $methodresult = [];

    public function insert()
    {


        $usersModel = $this->model('user');
        $_POST = json_decode(file_get_contents("php://input"), true);
        $userdata = [

            "username" => $_POST["username"],
            "mail" => $_POST["mail"],
            "password" => $_POST["password"],
            "phone" => $_POST["phone"]
        ];

        /*$insertsqlstring = InsertQueryGenerator("users", json_encode($userdata));
        $response = $usersModel->Add($insertsqlstring);

        //$result = $response["result"];
        $username = $_POST["username"];
        $mail = $_POST["mail"];

        $getquerystring = "select * from users where username='$username' or mail='$mail';";
        $getresponse = $usersModel->getdata($getquerystring);
        echo json_encode($getresponse);
        //exit;*/

        /* $username = $_POST["username"];
         $mail = $_POST["mail"];

         $getquery = "select * from users where username='$username' or mail='$mail';";
         $getresponsequery = $usersModel->getdata($getquery);

         if (!empty($username) && !empty($mail) && strlen($username)>0 && strlen($mail)>0){
             if ($getresponsequery["success"] && sizeof($getresponsequery["result"]) == 0){

                 $insertsqlstring = InsertQueryGenerator("users", json_encode($userdata));
                 $response = $usersModel->Add($insertsqlstring);

                 echo json_encode($response);

                 if ($response["success"]){

                     $getquerystring = "select * from users where username='$username' or mail='$mail';";
                     $getresponse = $usersModel->getdata($getquerystring);
                     echo json_encode($getresponse);
                     exit;
                 }else{
                     echo "kayıt edilemedi";

                 }
             }else{
                 echo "kullanıcı zaten kayıtlı farklı bir kullanıcı adı giriniz";
             }
         }else{
             echo "boş kalamaz";
             exit;
         }*/

        $username = $_POST["username"];
        $mail = $_POST["mail"];
        $phone = $_POST["phone"];

        //$getqueryusername = "select * from users where username='$username';";
        $getquery = "select * from users where username='$username' or mail='$mail' or phone='$phone';";
        $getresult = $usersModel->getdata($getquery);

        //$getresponseusername = $usersModel->getdata($getqueryusername);
      /*  $getquerymail = "select * from users where mail='$mail';";
        $getresponsemail = $usersModel->getdata($getquerymail);
        $getqueryphone = "select * from users where phonr='$phone';";
        $getresponsephone = $usersModel->getdata($getqueryphone);*/

       // $userget = $getresult["result"]["username"];
        $userdata["username"] = $username;

   // $mailget =  $getresult["result"]["mail"];
        $userdata["mail"] = $mail;
    //$phoneget =  $getresult["result"]["phone"];
        $userdata["phone"] = $phone;
        $getresult["result"]["username"] = $userdata["username"];
        $getresult["result"]["mail"] = $userdata["mail"];
        $getresult["result"]["phone"] = $userdata["phone"];

        if (!empty($username) && !empty($mail) && strlen($username) > 0 && strlen($mail) > 0){
            if ($getresult["success"] && sizeof($getresult["result"]) == 0
                && sizeof($getresult["result"]["username"])== 0
                && sizeof($getresult["result"]["mail"]) ==0
                && sizeof($getresult["result"]["phone"]) == 0
            ){

                $insertsqlstring = InsertQueryGenerator("users", json_encode($userdata));
                $response = $usersModel->Add($insertsqlstring);

                echo "geldi";
                if ($response["success"]) {
                    $getquerystring = "select * from users where username='$username' or mail='$mail';";
                    $getresponse = $usersModel->getdata($getquerystring);
                    echo json_encode($getresponse);
                    exit;
                } else {

                    echo "Kayıt işlemi başarısız.";
                    $this->methodresult = [
                        "success" => false,
                        "message" => "Kayıt Işlemi Başarısız."
                    ];
                }
            } else {

                echo "Kullanıcı zaten kayıtlı.";
                $this->methodresult = [
                    "success" => false,
                    "message" => "Kayıt Işlemi Başarısız."
                ];
            }
        }

        /*if (!empty($username) && !empty($mail) && strlen($username) > 0 && strlen($mail) > 0) {
            if ($getresponseusername["success"] && sizeof($getresponseusername["result"]) == 0) {
                if ($getresponsemail["success"] && sizeof($getresponsemail["result"]) == 0) {
                    if ($getresponsephone["success"] && sizeof($getresponsephone["result"]) == 0) {

                        $insertsqlstring = InsertQueryGenerator("users", json_encode($userdata));
                        $response = $usersModel->Add($insertsqlstring);
                        if ($response["success"]) {
                            $getquerystring = "select * from users where username='$username' or mail='$mail';";
                            $getresponse = $usersModel->getdata($getquerystring);
                            echo json_encode($getresponse);
                            exit;
                        } else {

                            //echo "Kayıt işlemi başarısız.";
                            $this->methodresult = [
                                "success" => false,
                                "message" => "Kayıt Işlemi Başarısız."
                            ];
                        }
                    } else {
                        // echo "Telefon Numarası Zaten Kayıtlı Lütfen Farklı Bir Telefon Numarası Giriniz.";
                        $this->methodresult = [
                            "success" => false,
                            "message" => "Telefon Numarası Zaten Kayıtlı Lütfen Farklı Bir Telefon Numarası Giriniz."
                        ];
                    }
                } else {
                    //echo "Mail Adresi Zaten Kayıtlı Lütfen Farklı Bir Mail Adresi Giriniz.";
                    $this->methodresult = [
                        "success" => false,
                        "message" => "Mail Adresi Zaten Kayıtlı Lütfen Farklı Bir Mail Adresi Giriniz."
                    ];
                }
            } else {
                //echo "Kullanıcı Adı Zaten Kayıtlı Lütfen Farklı Bir Kullanıcı Adı Giriniz.";
                $this->methodresult = [
                    "success" => false,
                    "message" => "Kullanıcı Adı Zaten Kayıtlı Lütfen Farklı Bir Kullanıcı Adı Giriniz."
                ];
            }
        } else {
            //echo "Boş Kalamaz";
            $this->methodresult = [
                "success" => false,
                "message" => "Boş Kalamaz."
            ];

        }*/
        return json_encode($this->methodresult);

    }

    public function login()
    {
        $_POST = json_decode(file_get_contents("php://input"), true);
        $mail = $_POST["mail"];
        $password = $_POST["password"];
        $usersModel = $this->model('user');
        $getquerystring = "select * from users where mail='$mail' and password='$password'; ";
        $getresult = $usersModel->getdata($getquerystring);

        if ($getresult["success"] == true && sizeof($getresult["result"]) == 1) {

            echo "giriş başarılı";
            echo json_encode($getresult);
            exit;

        } else {
            //echo "giriş başarısız";
            $getresult = [
                "success" => false,
                "message" => "Giriş Başarısız."
            ];
            echo json_encode($getresult);
            exit;
        }

    }

    public function post()
    {
        print_r($_POST);
    }


}