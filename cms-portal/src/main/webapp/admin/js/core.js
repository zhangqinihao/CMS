let core = {

    //节流 限流工具类 方法 参数 作用域
    throttle:function(method,args,context){
        clearTimeout(method.tId);

        //设置时间
        method.tId=setTimeout(function () {
            method.call(context,args)
        },300);
    },


    //自己封装的ajax
    http: function (option) {
        this.cancel && this.cancel.abort();
        //需要时候自己封装
        let opt={load:true},loadHandler,options = {
            url: "",
            method: "post",
            //请求类型
            contentType: "application/x-www-form-urlencoded",
            //数据类型
            dataType:"json",
            beforeSend:function(){
                this.load && (loadHandler=LayUtil.layer.init(function(inner,layer){
                    inner.loading(0,{shade:0.1})
                }))
            },
            success:function (res) {
                if(res.code===CONSTANT.HTTP.SUCCESS){
                    loadHandler.closeLoading();
                    console.log("密码错误!") ;
                }
            }
        };

        // 把相同的值覆盖掉，保持option的动态值  ***新增特性
        Object.assign(opt,options,option);
       this.cancel=$.ajax(opt);
    }
};

    const CONSTANT={
     //HTTP相关
       HTTP:{
           SUCCESS:200,
           ERROR:500
       }

    };


//layui工具类  名称不能改变
function LayUtil() {

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
            },

            //显示loading加载
            loading:function (config={}) {
                console.log(this);
                this.layer.load(config);
            },
            closeLoading:function () {
                this.layer.closeAll('loading');
            }
        }

            LayUtil.layer=new Inner();

        })(LayUtil),
    //form表单
    form:(function (LayUtil) {
        function Inner() {

        }
        Inner.prototype={
            construct:Inner,
            init:function (callback) {
                let  that=this;
                layui.use('form',function () {
                    that.form=layui.form;
                    that.form.render();
                    if(callback instanceof Function){
                        callback(that,that.form);
                    }
                });
                return this;
            },

            //提交表单
            submit:function(callback,name,type="submit"){
                this.form.on(type+"("+(name===undefined?'go':name)+")",function (obj) {
                       if(callback instanceof  Function){

                           callback(obj);
                           return false;
                       }

                       return  true;
                })

            },

            //验证
            verify:function (validator) {
                this.form.verify(validator)
            }

        }
        LayUtil.form=new Inner();

    })(LayUtil)

}


