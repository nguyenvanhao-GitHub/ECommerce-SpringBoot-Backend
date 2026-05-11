# Hệ Thống REST API Quản Lý Thương Mại Điện Tử (Java Spring Boot)

* Tôi đã nghiên cứu và phát triển hệ thống REST API này cho một ứng dụng thương mại điện tử hoàn chỉnh. API thực hiện tất cả các thao tác CRUD (Thêm, Đọc, Sửa, Xóa) nền tảng của một website bán hàng chuyên nghiệp với cơ chế xác thực và phân quyền người dùng chặt chẽ tại mọi bước xử lý.
* Dự án được xây dựng tập trung vào việc tối ưu hóa quy trình quản trị kho hàng cho Người bán và mang lại trải nghiệm mua sắm an toàn, minh bạch cho Khách hàng.


## Sơ đồ Thực thể (E-R Diagram)

Hệ thống được thiết kế dựa trên mối quan hệ chặt chẽ giữa các thực thể chính như Khách hàng, Người bán, Sản phẩm, Giỏ hàng và Đơn hàng.

![E-R Diagram](./ER%20Diagram/E-Commerce%20API%20ER%20Diagram.jpeg)

## Công Nghệ Sử Dụng (Tech Stack)

* **Ngôn ngữ:** Java 17.
* **Framework chính:** Spring Boot 3.x.
* **ORM:** Spring Data JPA / Hibernate.
* **Cơ sở dữ liệu:** MySQL.
* **Công cụ hỗ trợ:** Maven, Lombok, Jakarta Validation, Swagger UI.

## Các Module Chính

* **Module Đăng ký & Đăng nhập:** Quản lý bảo mật tài khoản cho cả Khách hàng và Người bán.
* **Module Người bán (Seller):** Quản trị gian hàng, danh mục hàng hóa và thông tin doanh nghiệp.
* **Module Khách hàng (Customer):** Quản lý hồ sơ cá nhân, địa chỉ và theo dõi lịch sử mua hàng.
* **Module Sản phẩm (Product):** Phân loại sản phẩm theo danh mục và kiểm soát số lượng tồn kho.
* **Module Giỏ hàng (Cart):** Xử lý logic chọn hàng và lưu trữ trạng thái mua hàng tạm thời.
* **Module Đơn hàng (Order):** Quy trình xử lý thanh toán và đặt hàng từ giỏ hàng.

## Tính Năng Nổi Bật

* **Xác thực an toàn:** Hệ thống sử dụng Session Token có thời hạn hiệu lực 1 giờ để đảm bảo tính bảo mật cho mọi phiên truy cập.
* **Quyền hạn Người bán:**
  * Đóng vai trò quản trị viên toàn bộ gian hàng cá nhân.
  * Chỉ người bán có Token hợp lệ mới được thực hiện các thao tác thay đổi dữ liệu sản phẩm.
  * Truy cập chi tiết danh sách khách hàng và lịch sử đơn hàng phát sinh từ cửa hàng.
* **Quyền hạn Khách hàng:**
  * Đăng ký tài khoản và nhận Session Token sau khi xác thực thành công.
  * Xem danh mục sản phẩm, quản lý giỏ hàng cá nhân và thực hiện đặt hàng trực tuyến.

## Hướng Dẫn Cài Đặt & Chạy

* Trước khi chạy ứng dụng, vui lòng cập nhật cấu hình database trong file [application.properties](ecommerce-backend\src\main\resources\application.properties).
* Cập nhật số cổng, tên người dùng và mật khẩu theo cấu hình MySQL trên máy tính của bạn.

```
    server.port=8080
    
    spring.datasource.url=jdbc:mysql://localhost:3307/ecommercedb?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=

```

## Địa Chỉ Truy Cập API

`Root Endpoint: http://localhost:8080/`

`Swagger UI Documentation: http://localhost:8080/swagger-ui/index.html`


## Danh Sách API Theo Module

### Login & Logout Module

* `POST /register/customer` : Đăng ký khách hàng mới
* `POST /login/customer` : Đăng nhập khách hàng bằng số điện thoại và mật khẩu hợp lệ.
* `POST /logout/customer` : Đăng xuất khách hàng dựa trên mã thông báo phiên.
* `POST /register/seller` : Đăng ký người bán mới
* `POST /login/seller` : Đăng nhập người bán
* `POST /logout/seller` : Đăng xuất người bán dựa trên mã thông báo phiên.


### Customer Module

* `GET /customer/current` : Lấy thông tin khách hàng hiện đang đăng nhập
* `GET /customer/orders` : Lấy lịch sử đơn hàng của khách hàng đã đăng nhập.
* `GET /customers` : Thu hút tất cả khách hàng
* `PUT /customer` : Thông tin cập nhật đã được ghi lại trong tài khoản khách hàng
* `PUT /customer/update/password` : Cập nhật mật khẩu khách hàng
* `PUT /customer/update/card` : Cập nhật thông tin thẻ tín dụng
* `PUT /customer/update/address?type=home` : Cập nhật địa chỉ nhà của khách hàng
* `PUT /customer/update/credentials` : Cập nhật địa chỉ email và số điện thoại di động.
* `DELETE /customer` : Xóa người dùng đã đăng nhập có mã thông báo phiên hợp lệ
* `DELETE /customer/delete/address?type=home` : Xóa địa chỉ nhà của khách hàng


### Seller Module

* `GET /seller/{sellerid}` : Lấy người bán có ID người bán đã được chuyển tiếp
* `GET /seller/current` : Lấy thông tin chi tiết của người bán hiện đang đăng nhập.
* `GET /sellers` : Tìm tất cả người bán
* `POST /addseller` : Thêm người bán mới
* `PUT /seller` : Cập nhật thông tin người bán
* `PUT /seller/update/password` : Cập nhật mật khẩu người bán
* `PUT /seller/update/mobile` : Cập nhật số điện thoại di động của người bán.
* `DELETE /seller/{sellerid}` : Xóa người bán có ID được truyền vào.


### Product Module

* `GET /product/{id}` : Lấy sản phẩm với ID sản phẩm đã cho
* `GET /products` : Nhận tất cả sản phẩm
* `GET /products/{category}` : Lấy sản phẩm thuộc danh mục đã cho
* `GET /products/seller/{id}` : Lấy sản phẩm của người bán có ID đã cho
* `POST /products` : Thêm sản phẩm mới vào cơ sở dữ liệu.
* `PUT /products` : Cập nhật sản phẩm với ID sản phẩm được cung cấp.
* `PUT /products/{id}` : Cập nhật số lượng sản phẩm
* `DELETE /product/{id}` : Xóa sản phẩm có ID đã cho


### Cart Module

* `GET /cart` : Lấy tất cả các mặt hàng trong Giỏ hàng của khách hàng
* `POST /cart/add` : Thêm sản phẩm vào giỏ hàng
* `DELETE /cart` : Xóa sản phẩm khỏi giỏ hàng
* `DELETE /cart/clear` : Xóa toàn bộ giỏ hàng


### Order Module

* `GET /orders/{id}` : Lấy thông tin chi tiết đơn hàng với mã đơn hàng đã cho
* `GET /orders` : Nhận tất cả đơn hàng
* `GET /orders/by/date` : Lấy các đơn đặt hàng được đặt vào ngày đã cho (DD-MM-YYYY)
* `POST /order/place` : Đặt đơn hàng mới dựa trên các mặt hàng trong giỏ hàng.
* `PUT /orders/{id}` : Cập nhật đơn hàng đang chờ xử lý
* `DELETE /orders/{id}` : Hủy đơn hàng


### Ví dụ về phản hồi API cho việc đăng nhập của khách hàng

`POST   localhost:8080/login/customer`

* Request Body

```
    {
        "mobileId": "9999999999",
        "password": "hao123456"
    }
```

* Response

```
    {
        "sessionId": 23,
        "token": "customer_0ad57094",
        "userId": 19,
        "userType": "customer",
        "sessionStartTime": "2025-09-10T10:48:20.0109626",
        "sessionEndTime": "2025-09-10T11:48:20.0109626"
    }
```
