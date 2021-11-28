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
