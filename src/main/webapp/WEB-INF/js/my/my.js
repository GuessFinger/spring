var vm = new Vue({
    el:'#app',
    data:{
        loginMessage:'123456',
        loginPassword:'',
        errorControl:false,
    },
    methods:{
        login:function () {
            var json = {
                "loginMessage":vm.loginMessage,
                "loginPassword":vm.loginPassword,
            }
            axios.get('check',{params:json}).then(function (value) {
                console.log(value);
            });
             // console.log(vm.data.loginMessage);
             console.log();
             console.log(vm.loginPassword);
        },

    }
});
