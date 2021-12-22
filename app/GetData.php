<?php 
//dinh nghia class Employee
class Employee {
	var $id;
	var $name;
	var $address;
	var $salary;
	function Employee($ma, $hoten, $diachi, $luong) {
		$this->id = $ma;
		$this->name = $hoten;
		$this->address = $diachi;
		$this->salary = $luong;
	}
}

//khoi tao mang chua cac doi tuong Employee
$array = array();
array_push($array, new Employee(1, 'Tieu Vy', 'Hoi An', 50000));
array_push($array, new Employee(2, 'Nguyen Tran Khanh Van', 'TP.HCM', 60000));
array_push($array, new Employee(3, 'Mai Phương Thúy', 'Hà Nội', 25000));
array_push($array, new Employee(4, 'Ngọc Hân', 'Hà Nội', 40000));
array_push($array, new Employee(7, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(8, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(9, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(10, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(11, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(12, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(13, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(14, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(15, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(16, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(17, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(18, 'Diễm My 9x', 'Vũng Tàu', 30000));
array_push($array, new Employee(19, 'Diễm My 9x', 'Vũng Tàu', 30000));

//chuyen mang object PHP thanh JSON
header('Content-Type: application/json; charset=utf-8');
echo json_encode($array);
?>




