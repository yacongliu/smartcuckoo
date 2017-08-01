<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/global.jsp" %>

<div class="easyui-layout" data-options="fit:true,border:false">
    <!--filter start-->
    <div data-options="region:'north'"
         style="height:35px; overflow: hidden;background-color: #fff">
        <form id="searchUserForm">
            <table>
                <tr>
                    <th>姓名:</th>
                    <td><input name="name" placeholder="请输入用户姓名"/></td>
                    <th>创建时间:</th>
                    <td>
                        <input name="createdateStart" placeholder="点击选择时间"
                               onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                               readonly="readonly"/>至
                        <input name="createdateEnd" placeholder="点击选择时间"
                               onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                               readonly="readonly"/>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true" onclick="searchUserFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="cleanUserFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--filter end-->
    <!--userGrid start-->
    <div data-options="region:'center',border:true,title:'用户列表'">
        <table id="userDataGrid" data-options="fit:true,border:false"></table>
    </div>
    <!--userGrid end-->
    <!--org start-->
    <div data-options="region:'west',border:true,split:false,title:'组织机构'"
         style="width:150px;overflow: hidden; ">
        <ul id="organizationTree" style="width:160px;margin: 10px 10px 10px 10px"></ul>
    </div>
    <!--org end-->
</div>
<div id="userToolbar" style="display: none;">
    <%--<shiro:hasPermission name="/user/add">--%>
    <a onclick="addUserFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    <%--</shiro:hasPermission>--%>
</div>
<script type="text/javascript" charset="UTF-8">
    var userDataGrid;
    var organizationTree;
    $(function () {
        /*
        organizationTree = $('#organizationTree').tree({
            url: '
        ${path }/organization/tree',
            parentField: 'pid',
            lines: true,
            onClick: function (node) {
                userDataGrid.datagrid('load', {
                    organizationId: node.id
                });
            }
        }); */

        userDataGrid = $('#userDataGrid').datagrid({
            url: '${path }/user/dataGrid',
            fit: true,
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            idField: 'id',
            sortName: 'createTime',
            sortOrder: 'asc',
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            columns: [[
                {
                    width: '80',
                    title: '姓名',
                    field: 'userName',
                    align:'center',
                    sortable: true
                }, {
                    width: '80',
                    title: '部门ID',
                    field: 'organizationId',
                    align:'center',
                    hidden: true
                }, {
                    width: '80',
                    title: '所属部门',
                    align:'center',
                    field: 'organizationName'
                }, {
                    width: '130',
                    title: '创建时间',
                    field: 'createTime',
                    align:'center',
                    formatter: formatDateTime,
                    sortable: true
                }, {
                    width: '200',
                    title: '角色',
                    align:'center',
                    field: 'rolesList'
                }, {
                    width: '100',
                    title: '用户类型',
                    align:'center',
                    field: 'userType',
                    sortable: true,
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "管理员";
                        } else if (value == 1) {
                            return "用户";
                        }
                        return "未知类型";
                    }
                }, {
                    width: '60',
                    title: '状态',
                    align:'center',
                    field: 'status',
                    sortable: true,
                    formatter: function (value, row, index) {
                        switch (value) {
                            case 0:
                                return '正常';
                            case 1:
                                return '停用';
                        }
                    }
                }, {
                    field: 'action',
                    align:'center',
                    title: '操作',
                    width: 130,
                    formatter: function (value, row, index) {
                        var str = '';
                        <%--<shiro:hasPermission name="/user/edit">--%>
                        str += $.formatString('<a href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editUserFun(\'{0}\');" >编辑</a>', row.id);
                        <%--</shiro:hasPermission>--%>

                        <%--<shiro:hasPermission name="/user/delete">--%>
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteUserFun(\'{0}\');" >删除</a>', row.id);
                        <%--</shiro:hasPermission>--%>
                        return str;
                    }
                }]],
            onLoadSuccess: function (data) {
                $('.user-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.user-easyui-linkbutton-del').linkbutton({text: '删除'});
            },
            toolbar: '#userToolbar'
        });
    });


</script>

