<?php

class Database
{

//    protected $db;
//
//    public function __construct()
//    {
//        try {
//                $this->db = new PDO('mysql:host=167.172.58.190;dbname=weider', 'root', 'sevket190512');
//        } catch (PDOException $e) {
//            echo $e->getMessage();
//        }
//    }
    private $_HOST = "localhost";
    private $_USERNAME = "root";
    private $_PASSWORD = "";
    private $_DATABASE_NAME = "product";

    /*

    private $_HOST = '46.101.146.148';
    private $_USERNAME = "weider";
    private $_PASSWORD = "sevket190512";
    private $_DATABASE_NAME = "weider";

    private $_HOST = '167.172.58.190';
    private $_USERNAME = "root";
    private $_PASSWORD = "sevket190512";
    private $_DATABASE_NAME = "weider"; */
    protected $db;
    function __construct()
    {
        $MYSQL_CONNECTION_STRING = "mysql:host=$this->_HOST;dbname=$this->_DATABASE_NAME;charset=utf8";
        $this->db = new PDO($MYSQL_CONNECTION_STRING, $this->_USERNAME, $this->_PASSWORD);
    }
    function connection()
    {
        try {
            if ($this->db == null) {
                $this->db->query("SET NAMES utf8");
                $this->db->query("SET CHARACTER SET 'utf8_general_ci'");
                $this->db->query("SET COLLATION_CONNECTION = 'utf8_general_ci'");
                $this->db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            }
            return $this->db;
        } catch (PDOException $e) {

            echo "Bağlantı Hatası: " . $e->getMessage() . "<br />";
        }
    }
    function lastID()
    {
        try {
            return $this->connection()->lastInsertId();
        } catch (PDOException $e) {
            return array('err' => true, 'msg' => $e->getMessage());
        }
    }

}