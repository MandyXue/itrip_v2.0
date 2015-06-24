/**
 * Created by mandyxue on 15/6/11.
 */

$(document).ready(function () {
    $('#thumbs').click(
        function (event) {
            //获取url中的参数foodName
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            var foodName = theRequest['foodName'];
            var data = 'foodName=' + encodeURIComponent(foodName);
            $.ajax({
                url: "foodThumbs",
                data: data,
                type: "GET",
                success: function (response) {
                    $('#number').replaceWith('<span id="number">' + response + '</span>');
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
            return false;
        });
    $('#package').click(
        function (event) {
            //获取url中的参数foodName
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            var spotName = theRequest['spotName'];
            var type = "1";
            var data = 'spotName=' + encodeURIComponent(spotName) + '&type=' + encodeURIComponent(type);
            $.ajax({
                url: "spotThumbs",
                data: data,
                type: "GET",
                success: function (response) {
                    $('#package_number').replaceWith('<span id="package_number">' + response + '</span>');
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
            return false;
        });
    $('#couple').click(
        function (event) {
            //获取url中的参数foodName
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            var spotName = theRequest['spotName'];
            var type = "2";
            var data = 'spotName=' + encodeURIComponent(spotName) + '&type=' + encodeURIComponent(type);
            $.ajax({
                url: "spotThumbs",
                data: data,
                type: "GET",
                success: function (response) {
                    $('#couple_number').replaceWith('<span id="couple_number">' + response + '</span>');
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
            return false;
        });
    $('#family').click(
        function (event) {
            //获取url中的参数foodName
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            var spotName = theRequest['spotName'];
            var type = "3";
            var data = 'spotName=' + encodeURIComponent(spotName) + '&type=' + encodeURIComponent(type);
            $.ajax({
                url: "spotThumbs",
                data: data,
                type: "GET",
                success: function (response) {
                    $('#family_number').replaceWith('<span id="family_number">' + response + '</span>');
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
            return false;
        });
    $('.thumb-up-img').click(function (e) {
        $(this).toggleClass('selected');
    });
});