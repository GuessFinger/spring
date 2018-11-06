var vm = new Vue({
    el:'#app',
    data:{
        loginMessage:'',
        loginPassword:'',
        errorControl:false,
    },
    methods:{
        login:function () {
            $.ajax({
                type:"GET",
                url:'check.do?loginMessage='+vm.loginMessage+'&loginPassword='+vm.loginPassword,
                success:function (data) {
                    console.log(data);
                }
            });
             // console.log(vm.data.loginMessage);
             console.log();
             console.log(vm.loginPassword);
        },

    }
});
