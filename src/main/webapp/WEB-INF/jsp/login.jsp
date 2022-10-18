<html>
    <head>
        <title>Login Page</title>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
            .login-form{
                width: 400px;
                height: 200px;
                position: absolute;
                background-color: #5B5EA6;
                border-radius: 20px;
                top: 50px;
                left: 50%;
                margin-right: 50%;
                transform: translate(-50%, -50%);
            }
        </style>
    </head>
    <body>
        <h2>${errorMsg}</h2>
        <div class="login.form">
            <div class="container-fluid">
                <form method="post">
                    <input type="text" name="userId" class="form-control mt-m" placeholder="User Id"/><br>
                    <br>
                    <input type="password" name="password" class="form-control mt-3" placeholder="Password"/><br>
                    <br>
                    <button class="btn btn-dark btn-black mt-3">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>