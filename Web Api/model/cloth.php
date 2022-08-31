<?php

class Cloth extends Model {

    public function Add($sqlstring)
    {
        $insertresult = parent::Insert($sqlstring);
        return $insertresult;
    }

    public function getquery($query)
    {
        $getresult=parent::get($query);
        return $getresult;
    }

}