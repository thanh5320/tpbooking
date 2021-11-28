Nếu đã có index 'hotel' trong elasticsearch xóa nó đi:
	curl -X DELETE 'localhost:9200/hotel'
	
chạy câu lệnh để thêm dữ liệu mới vào es, dữ liệu mới ở /resources/static
	curl -X POST 'localhost:9200/hotel/_bulk?pretty' -H 'Content-type: application/json' --data-binary @output.jl
