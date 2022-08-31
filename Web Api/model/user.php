<?php

class User extends Model{

    public function Add($sqlstring)
    {
        $insertresult = parent::Insert($sqlstring);
        return $insertresult;
    }

    public function getdata($query)
    {
        $getresult=parent::get($query);
        return $getresult;
    }
}
