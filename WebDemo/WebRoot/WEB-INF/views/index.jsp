<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<%@ include file="/WEB-INF/views/head.jsp" %>
<%@ include file="/WEB-INF/views/cssHelper.jsp" %>
<%@ include file="/WEB-INF/views/jsHelper.jsp" %>
<script type="text/javascript">

	function onClick(){
	$.ajax({
		url:"${basePath}/sysResource/remove.do",
		type:"POST",
		data:{
			'id':453,
			'name':'name04',
			'code':'4号'
		},
		success:function(data){
			console.log(data);
		},	
		error:function(){
		console.log("error");
		}
	})
	}

</script>
</head>
<body >
<div id="dic" class="">
<div class="panel ">
<div class="panel-heading">
	<form class="form-inline ">
  <div class="form-group ">
    <label for="dicName"> 字典名：</label>
    <input type="text" class="form-control  input-sm" id="dicName" >
  </div>
  <div class="form-group ">
    <label for="dicCode"> 字典代码：</label>
    <input type="text" class="form-control  input-sm"  id="dicCode"  >
  </div>
   <div class="form-group ">
   <shiro:hasPermission name="dic:select">
  	<button type="submit" class="btn btn-primary btn-sm">查询</button>
  </shiro:hasPermission>
   <shiro:hasPermission name="dic:delete">
  	<button type="button" class="btn btn-primary btn-sm">删除</button>
  </shiro:hasPermission>
     	<button onclick="onClick()" type="button" class="btn btn-primary btn-sm">合同</button>
   
  </div>
</form>
</div>
<div class="panel-body">
<div class="row">
  <table id="dg" class="table table-condensed  table-bordered table-hover col-sm-12">
                <thead  >
                <tr class="">
                	<th class="text-center" width=30px ></th>
                	<th width=30px></th>
                  <th>字典代码</th>
                  <th>字典名</th>
                  <th>字典类型</th>
                  <th>是否有效</th>
                  <th>备注</th>
                </tr>
                </thead>
                <tbody>
                 <tr  :class="{'active':curr_dic==dic}"
                  v-on:click="setCurrDic(dic)" v-for="(dic,index) in  dicPager.rows">
                  <td class="text-center">{{index+1}}</td>
                  <td class="text-center"><input type="checkbox" name="dic"  v-bind:checked="curr_dic==dic" /></td>
                  <td>{{dic.code}}</td>
                  <td>{{dic.name}}</td>
                  <td>{{dic.type}}</td>
                  <td>{{dic.isValid==1?'有效':'无效'}}</td>
                   <td><a v-if="dic.isValid==1" class="btn btn-warning btn-xs">
                   <span class="fa fa-wrench"></span>修改</a></td>
                </tr>
                </tbody>
                </table>
                </div>
                <div class="row">
                <div class="col-sm-7" >
                	第  <span class="text-primary">{{dicPager.pageNum}}</span>  页,每页显示<select v-on:change="fetchDicList(1,dicPager.pageSize)" v-model="dicPager.pageSize">
                	<option value="2" >2</option>
                	<option value="5" >5</option>
                	<option value="10" >10</option>
                	<option value="15" selected>15</option>
                	<option value="30">30</option>
                	<option value="50">50</option>
                	</select>
                	,共  <span class="text-primary">{{dicPager.total}}</span> 
                	条数据,当前显示 <span class="text-primary">{{dicPager.beginNum}}~{{dicPager.endNum>dicPager.total?dicPager.total:dicPager.endNum}}</span>
                	
                </div>
                  <ul class="pagination pagination-sm  col-sm-5">
                 <li  >
				      <button class="btn btn-default btn-sm" v-bind:disabled="dicPager.pageNum<=dicPager.beginPageNum"  v-on:click="fetchDicList(dicPager.pageNum-1,dicPager.pageSize)">
				        <span ><<</span>
				      </button>
				    </li>
				     <li >
				      <button class="btn btn-default btn-sm" v-on:click="fetchDicList(1,dicPager.pageSize)" 
				      v-bind:disabled="dicPager.pageNum<=dicPager.beginPageNum">
				        <span >首页</span>
				      </button>
				    </li>
				    <li  v-for="num in dicPager.endPageNum" v-if="num >= dicPager.beginPageNum">
				     <button :class="{'active':num==dicPager.pageNum}" class="btn btn-default btn-sm" v-on:click="fetchDicList(num,dicPager.pageSize)" >{{num}}</button></li>
				    <li>
				     <li >
				      <button class="btn btn-default btn-sm" v-bind:disabled="dicPager.pageNum>=dicPager.endPageNum"  v-on:click="fetchAppList(dicPager.facPageLength,dicPager.pageSize)" >
				        <span >尾页</span>
				      </button>
				    </li>
				    <li >
				      <button class="btn btn-default btn-sm" v-bind:disabled="dicPager.pageNum>=dicPager.endPageNum" v-on:click="fetchAppList(dicPager.pageNum+1,dicPager.pageSize)">
				        <span>>></span>
				      </button>
   			 </li>
                </ul>
                </div>
              </div>
          <!-- / pane-body -->
             </div>
               
               </div>
</body>
<script type="text/javascript">
var vm = new Vue({
	el:"#dic",
	data:{
		curr_dic:[],
		dicPager:{
			pageNum:1,
			pageSize:15,
			total:0,
			rows:[],
			beginNum:0,
			endNum:0,
			beginPageNum:0,
			endPageNum:0,
			facPageLength:1
		}
	},
	methods:{
		fetchDicList:function(num,size){
			this.$http.post('${basePath}/dic/findDicPager.do',{pageNum:num,pageSize:size},{emulateJSON:true}).then(
			function(res){
				this.dicPager=res.data;
			}, function(res){
			
			});
		},
		setCurrDic:function(dic){
			this.curr_dic=dic;
		}
	},
	computed:{
	},
	watch:{
	
	},
	mounted:function() {
        this.fetchDicList(1,this.dicPager.pageSize);
      }

});
</script>
</html>