
jQuery(document).ready(function() {

    $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        var validcode = $(this).find('.validcode').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        if(validcode == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '156px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.validcode').focus();
            });
            return false;
        }
    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });
    
});

function keyLogin(){
 if (event.keyCode==13) {  //回车键的键值为13
   $(".button").click(); //调用登录按钮的登录事件
  }
}

