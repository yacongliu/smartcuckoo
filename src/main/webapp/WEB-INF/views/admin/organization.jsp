<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp" %>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" style="overflow: hidden;">
        <table id="organizationTreeGrid"></table>
    </div>
    <div id="orgToolbar" style="display: none;">
        <%--<shiro:hasPermission name="/organization/add">--%>
        <a onclick="addOrganizationFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
        <%--</shiro:hasPermission>--%>
    </div>
</div>
<script type="text/javascript" charset="UTF-8">
    var organizationTreeGrid;
    $(function () {
        organizationTreeGrid = $('#organizationTreeGrid').treegrid({
            url: '${path }/organization/treeGrid',
            idField: 'id',
            treeField: 'name',
            parentField: 'pid',
            fit: true,
            fitColumns: false,
            border: false,
            frozenColumns: [[{
                title: 'id',
                field: 'id',
                width: 40,
                hidden: true
            }]],
            columns: [[{
                field: 'code',
                title: '编号',
                width: 40
            }, {
                field: 'name',
                title: '部门名称',
                width: 180
            }, {
                field: 'seq',
                title: '排序',
                width: 40
            }, {
                field: 'iconCls',
                title: '图标',
                width: 120
            }, {
                width: '130',
                title: '创建时间',
                field: 'createTime',
                formatter: formatDateTime
            }, {
                field: 'pid',
                title: '上级资源ID',
                width: 150,
                hidden: true
            }, {
                field: 'address',
                title: '地址',
                width: 120
            }, {
                field: 'action',
                title: '操作',
                width: 130,
                formatter: function (value, row, index) {
                    var str = '';
                    <%--<shiro:hasPermission name="/organization/edit">--%>
                    str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editOrganizationFun(\'{0}\');" >编辑</a>', row.id);
                    <%--</shiro:hasPermission>--%>

                    <%--<shiro:hasPermission name="/organization/delete">--%>
                    str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteOrganizationFun(\'{0}\');" >删除</a>', row.id);
                    <%--</shiro:hasPermission>--%>
                    return str;
                }
            }]],
            onLoadSuccess: function (data) {
                $('.organization-easyui-linkbutton-edit').linkbutton({text: '编辑'});
                $('.organization-easyui-linkbutton-del').linkbutton({text: '删除'});
            },
            toolbar: '#orgToolbar'
        });
    });
</script>