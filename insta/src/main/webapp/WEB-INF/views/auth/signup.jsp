<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>

<body>
<div class="container">
    <main class="loginMain">
        <!--회원가입섹션-->
        <section class="login">
            <article class="login__form__container">

                <div class="login__form">
                    <h1><img src="/images/logo.jpg" alt=""></h1>

                    <form class="login__input"  action="/auth/signup" method="post">
                        <input type="text" name="username" placeholder="username" required="required"  maxlength="25"/>
                        <input type="password" name="password" placeholder="password" required="required" />
                        <input type="email" name="email" placeholder="email" required="required" />
                        <input type="text" name="name" placeholder="name" required="required" />
                        <button>회원가입</button>
                    </form>
                </div>
                <div class="login__register">
                    <span>계정이 있으신가요?</span>
                    <a href="/auth/signin">로그인</a>
                </div>
                <!--계정이 있으신가요?end-->

            </article>
        </section>
    </main>
</div>
</body>

</html>