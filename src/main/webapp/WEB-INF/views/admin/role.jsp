<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp" %>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',fit:true,border:false">
        <table id="roleDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>
<div id="roleToolbar" style="display: none;">
    <%--<shiro:hasPermission name="/role/add">--%>
    <a onclick="addRoleFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    <%--</shiro:hasPermission>--%>
</div>
<script type="text/javascript" charset="UTF-8">
    var roleDataGrid;
    $(function () {

        roleDataGrid = $('#roleDataGrid').datagrid({
            url: '${path }/role/dataGrid',
            striped: true, //是否显示斑马线效果
            rownumbers: true, //是否显示行号列
            pagination: true, //是否显示分页工具栏
            singleSelect: true, //是否只允许选择一行
            //fitColumns: true, //列 适应网格宽度

            idField: 'id',
            sortName: 'id',
            sortOrder: 'asc',
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            frozenColumns: [[{
                title: '编号',
                field: 'id',
                width: 80
            },
                {
                    width: '80',
                    title: '名称',
                    field: 'name',
                    sortable: true
                }, {
                    width: '80',
                    title: '排序号',
                    field: 'seq',
                    sortable: true
                }, {
                    width: '200',
                    title: '描述',
                    field: 'description'
                }, {
                    width: '60',
                    title: '状态',
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
                    title: '操作',
                    width: 200,
                    formatter: function (value, row, index) {
                        var str = '';
                        <%--<shiro:hasPermission name="/role/grant">--%>
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'fi-check icon-green\'" onclick="grantRoleFun(\'{0}\');" >授权</a>', row.id);
                        <%--</shiro:hasPermission>--%>

                        <%--<shiro:hasPermission name="/role/edit">--%>
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editRoleFun(\'{0}\');" >编辑</a>', row.id);
                        <%--</shiro:hasPermission>--%>

                        <%--<shiro:hasPermission name="/role/delete">--%>

                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteRoleFun(\'{0}\');" >删除</a>', row.id);
                        <%--</shiro:hasPermission>--%>
                        return str;
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $('.role-easyui-linkbutton-ok').linkbutton({text: '授权'});
                $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.role-easyui-linkbutton-del').linkbutton({text: '删除'});
            },
            toolbar: '#roleToolbar'
        });
    });
</script>

