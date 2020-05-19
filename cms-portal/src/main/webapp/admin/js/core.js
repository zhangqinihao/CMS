let core = {
    //自己封装的ajax
    http: function (option) {
        //需要时候自己封装
        let opt={load:true},options = {
            url: "",
            method: "post",
            //请求类型
            contentType: "application/x-www-form-urlencoded",
            //数据类型
            dataType:"json",
            beforeSend:function(){
                this.load && LayUtil.layer.init(function(inner,layer){
                    layer.load()
                })
            },
            success:function (res) {
                if(res==="验证码错误!"){
                    //alert("验证码错误!");
                    console.log("验证码错误!");
                }
            }
        };

        // 把相同的值覆盖掉，保持option的动态值  ***新增特性
        Object.assign(opt,options,option);
        $.ajax(opt);
    }
};

//layui工具类
function LayUtil() {
    this.run=function () {

    }
}



//原型骨架
LayUtil.prototype={
    construct:LayUtil,
    //匿名函数
    layer:(function(LayUtil) {

        function Inner() {

        }
        Inner.prototype={
            construct:Inner,
            init:function (callback) {
                let that =this;
                layui.use('layer',function () {
                    that.layer=layui.layer;
                    if (callback instanceof Function){
                        callback(that,that.layer);
                    }

                })
                return this;
            }
        }

        LayUtil.layer=new Inner();

        })(LayUtil)

}
