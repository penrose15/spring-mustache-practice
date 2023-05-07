var main = {
    init : function () {
        var _this = this;
        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    update : function () {
        var data = {
            name: $('#name').val(),
            price: $('#price').val(),
            quantity: $('#quantity').val()
        };
        var id = $('#id').val();
        console.log(id);

        $.ajax({
            type: 'PATCH',
            url: '/v1/stock/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('상품이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();