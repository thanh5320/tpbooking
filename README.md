Nếu đã có index 'hotel' trong elasticsearch xóa nó đi:
	curl -X DELETE 'localhost:9200/hotel'
	
chạy câu lệnh để thêm dữ liệu mới vào es, dữ liệu mới ở /resources/static
	curl -X POST 'localhost:9200/hotel/_bulk?pretty' -H 'Content-type: application/json' --data-binary @output.jl

endpoint
/home
GET localhost:8080/home -> trả về 9 hotel nổi bật nhất ở HÀ NỘI, HCM, ĐÀ NẴNG

/home/search
POST localhost:8080/home/search
{
	"page": 0,
	"text": "KHÁCH SẠN HÀ NỘI ROYAL PALACE 2"
}
-> endpoint này nhận đầu vào là số thứ tự trang và text search, số trang bắt đầu từ 0, mỗi trang có 10 hotel

/hotel/{id}
GET localhost:8080/hotel/{id}
-> trả về 1 hotel tương ứng với id

=================================
ngày 18/12/21

chạy lại file sql để thêm dữ liệu vào db: file nằm ở resources/static

endpoint : Đặt phòng
POST /booking/add/room
{
    "user_id": 10,
    "room_id": "0ebad8383bb94068d794f62b40f264e0",
    "start_day": "2021/12/17 00:00:00",
    "end_day": "2021/12/18 00:00:00"
}

endpoint : hủy phòng
POST /booking/cancel/room
{
    "reservation_id": 1 // id đơn phòng đã đặt
}

endpoint : tất cả các phòng 1 user đã đặt
POST /booking/list/room
{
    "user_id": 10
}


endpoint : comment
POST /hotel/comment/add
{
    "user_id": 10,
    "hotel_id": "590e451b376f68e7cb4deb9d0ea61c4b",
    "title": "Tuyệt vời",
    "content": "Sạch sẽ, rất thoải mái"
}


endpoint : list comment của 1 khách sạn
GET         127.0.0.1:8080/hotel/comment/590e451b376f68e7cb4deb9d0ea61c4b


