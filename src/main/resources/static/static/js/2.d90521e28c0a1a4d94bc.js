webpackJsonp([2],{HliK:function(t,e,s){t.exports=s.p+"static/img/ldxh.10d35ec.jpg"},KjMB:function(t,e,s){t.exports=s.p+"static/img/ldzt.c691960.jpg"},Q3pf:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var o=s("mvHQ"),n=s.n(o),a=s("7+uW").default.extend({name:"newLogIn",data:function(){var t=window.sessionStorage.getItem("studentInfo");null!=t&&(this.$store.dispatch("setLogInFlag",!0),this.logInFlag=!0),console.log(t),console.log("参数"+this.$route.params.type);var e="/api/exam/getExamResultInfo",s="/exam",o="研究生招生成绩查询打印系统";return"stu"==this.$route.params.type&&(e="/api/student/login",s="/student",o="研究生招生录取通知书邮寄地址查询修改系统"),{appName:o,msg:"",title:"",url:e,jmpRoute:s,accountInfo:{username:"",password:""},logInFlag:this.$store.getters.isLogIn}},mounted:function(){null!=window.sessionStorage.getItem("studentInfo")&&this.$router.push({path:this.jmpRoute})},methods:{logIn:function(){var t=this;console.log(this.url),this.$axios.post(this.url+"/"+this.accountInfo.username+"/"+this.accountInfo.password).then(function(e){if(""==e.data)t.msg="姓名或者身份证错误查无此人。";else{window.sessionStorage.setItem("studentInfo",n()(e.data)),console.log(t.$route.params.type),t.$store.dispatch("setLogInUrl",t.$route.params.type),console.log("sessionStorage");var s=window.sessionStorage.getItem("studentInfo"),o=JSON.parse(s);console.log(o),t.logInFlag=!0,t.$store.commit("setLogInFlag",!0),t.$store.dispatch("setLogInFlag",!0),console.log("this.$store.logInFlag"),console.log(t.$store.getters.isLogIn),console.log(e),console.log(e.data),t.$router.push({path:t.jmpRoute})}}).catch(function(t){console.log(t)})}}}),l={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return 0==t.logInFlag?o("div",[o("p",{staticClass:"MsoNormal",staticStyle:{"text-align":"center"},attrs:{align:"center"}},[o("span",{staticStyle:{color:"blue"}},[o("font",{attrs:{size:"6",face:"黑体"}},[o("img",{attrs:{src:s("HliK"),width:"101",height:"79"}}),t._v(" "),o("img",{attrs:{src:s("KjMB"),width:"220",height:"75"}})])],1)]),t._v(" "),o("p",{staticClass:"MsoNormal",staticStyle:{"text-align":"center"},attrs:{align:"center"}},[o("span",{staticStyle:{color:"blue"}},[o("font",{attrs:{size:"6",face:"黑体"}},[t._v(t._s(t.appName))])],1)]),t._v(" "),o("br"),t._v(" "),o("br"),t._v(" "),o("div",{attrs:{align:"center"}},[o("span",{staticStyle:{color:"red"}},[t._v(t._s(t.msg))]),t._v(" "),o("el-form",{ref:"logForm",attrs:{model:t.accountInfo,"label-position":"right","label-width":"80px"}},[o("el-row",{attrs:{type:"flex",justify:"center"}},[o("el-col",{attrs:{span:16}},[o("el-form-item",{attrs:{label:"考生姓名",prop:"username"}},[o("el-input",{attrs:{size:"small"},model:{value:t.accountInfo.username,callback:function(e){t.$set(t.accountInfo,"username",e)},expression:"accountInfo.username"}})],1)],1)],1),t._v(" "),o("el-row",{attrs:{type:"flex",justify:"center"}},[o("el-col",{attrs:{span:16}},[o("el-form-item",{attrs:{label:"身份证号",prop:"password"}},[o("el-input",{attrs:{size:"small"},model:{value:t.accountInfo.password,callback:function(e){t.$set(t.accountInfo,"password",e)},expression:"accountInfo.password"}})],1)],1)],1),t._v(" "),o("el-row",{attrs:{type:"flex",justify:"center"}},[o("el-col",[o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:t.logIn}},[t._v("登录")])],1)],1)],1)],1)],1)]):t._e()},staticRenderFns:[]},r=s("VU/8")(a,l,!1,null,null,null);e.default=r.exports}});
//# sourceMappingURL=2.d90521e28c0a1a4d94bc.js.map