<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>首页</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="${staticPath }/assets/img/favicon.ico">
    <link rel="stylesheet" type="text/css"
          href="${staticPath }/assets/js/jquery-easyui-1.5/themes/gray/easyui.css"/>
    <link rel="stylesheet" type="text/css"
          href="${staticPath }/assets/js/jquery-easyui-1.5/themes/icon.css"/>
    <link rel="stylesheet" href="${staticPath }/assets/css/foundation-icons/foundation-icons.css">
    <link rel="stylesheet" href="${staticPath }/assets/css/dreamlu.css">
    <link rel="stylesheet" href="${staticPath }/assets/css/icons-view.css">
</head>
<body class="easyui-layout">

<!--north start-->
<div data-options="region:'north',border:false" style="overflow: hidden">
    <div>
        <span style="float: right; padding-right: 20px; margin-top: 15px; color: #333">
            <i class="fi-torso"></i>
            <b>username</b>&nbsp;&nbsp;
            <i class="fi-x"></i>
            <a href="javascript:void(0)" class="easyui_linkbutton" onclick="logout()">安全退出</a>
        </span>
        <span class="header"></span>
    </div>
</div>
<!--north end-->
<!--south start-->
<div data-options="region:'south',split:true,border:false"
     style="height: 30px;line-height:30px; overflow: hidden;text-align: center;background-color: #eee">
    <span>Copyright © 2015 power by <b>yacongliu</b></span>
</div>
<!--south end-->
<!--west start-->
<div data-options="region:'west',title:'菜单',split:true"
     style="width: 160px; overflow: hidden;overflow-y:auto; padding:0px">
    <div class="well well-small" style="padding: 5px 5px 5px 5px;">
        <ul id="layout_west_tree"></ul>
    </div>
</div>
<!--south end-->
<!--center start-->
<div data-options="region:'center',border:false">
    <div id="index_tabs" class="easyui-tabs" style="overflow: hidden;">
        <div title="首页" data-options="iconCls:'fi-home',border:false" style="overflow: hidden;">
            <script src='https://git.oschina.net/wangzhixuan/spring-shiro-training/widget_preview'></script>
        </div>
    </div>
</div>
<!--center end-->

<div id="tabsMenu">
    <div data-options="iconCls:'fi-loop'" type="refresh" style="font-size: 12px;">刷新</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'fi-x'" type="close" style="font-size: 12px;">关闭</div>
    <div data-options="iconCls:''" type="closeOther">关闭其他</div>
    <div data-options="iconCls:''" type="closeAll">关闭所有</div>
</div>


<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="${staticPath }/assets/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script src="${staticPath }/assets/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" charset="UTF-8"></script>
<script src="${staticPath }/assets/js/extJs.js"></script>
<script type="text/javascript">
    var index_tabs;
    var indexTabsMenu;
    var layout_west_tree;
    $(function () {
        index_tabs = $('#index_tabs').tabs({
            fit: true,
            border: false,
            onContextMenu: function (e, title) {
                e.preventDefault();
                indexTabsMenu.menu('show', {
                    left: e.pageX,
                    top: e.pageY
                }).data('tabTitle', title);
            },
            tools: [{
                iconCls: 'fi-home',
                handler: function () {
                    index_tabs.tabs('select', 0);
                }
            }, {
                iconCls: 'fi-loop',
                handler: function () {
                    refreshTab();
                }
            }, {
                iconCls: 'fi-x',
                handler: function () {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    var tab = index_tabs.tabs('getTab', index);
                    if (tab.panel('options').closable) {
                        index_tabs.tabs('close', index);
                    }
                }
            }]
        });
        // 选项卡菜单
        indexTabsMenu = $('#tabsMenu').menu({
            onClick: function (item) {
                var curTabTitle = $(this).data('tabTitle');
                var type = $(item.target).attr('type');
                if (type === 'refresh') {
                    refreshTab();
                    return;
                }
                if (type === 'close') {
                    var t = index_tabs.tabs('getTab', curTabTitle);
                    if (t.panel('options').closable) {
                        index_tabs.tabs('close', curTabTitle);
                    }
                    return;
                }
                var allTabs = index_tabs.tabs('tabs');
                var closeTabsTitle = [];
                $.each(allTabs, function () {
                    var opt = $(this).panel('options');
                    if (opt.closable && opt.title != curTabTitle
                        && type === 'closeOther') {
                        closeTabsTitle.push(opt.title);
                    } else if (opt.closable && type === 'closeAll') {
                        closeTabsTitle.push(opt.title);
                    }
                });
                for (var i = 0; i < closeTabsTitle.length; i++) {
                    index_tabs.tabs('close', closeTabsTitle[i]);
                }
            }
        });

        layout_west_tree = $('#layout_west_tree').tree({
            url: '${path }/resource/tree',
            parentField: 'pid',
            lines: true,
            onClick: function (node) {
                var opts = {
                    title: node.text,
                    border: false,
                    closable: true,
                    fit: true,
                    iconCls: node.iconCls
                };
                var url = node.attributes;
                if (url && url.indexOf("http") == -1) {
                    url = '${path }' + url;
                }
                if (node.openMode == 'iframe') {
                    opts.content = '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
                    addTab(opts);
                } else if (url) {
                    opts.href = url;
                    addTab(opts);
                }
            }
        });
    });

    function addTab(opts) {
        var t = $('#index_tabs');
        if (t.tabs('exists', opts.title)) {
            t.tabs('select', opts.title);
        } else {
            t.tabs('add', opts);
        }
    }

    function refreshTab() {
        var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
        var tab = index_tabs.tabs('getTab', index);
        var options = tab.panel('options');
        if (options.content) {
            index_tabs.tabs('update', {
                tab: tab,
                options: {
                    content: options.content
                }
            });
        } else {
            tab.panel('refresh', options.href);
        }
    }

    function logout() {
        $.messager.confirm('提示', '确定要退出?', function (r) {
            if (r) {
                progressLoad();
                $.post('${path }/logout', function (result) {
                    if (result.success) {
                        progressClose();
                        window.location.href = '${path }';
                    }
                }, 'json');
            }
        });
    }

    function editUserPwd() {
        parent.$.modalDialog({
            title: '修改密码',
            width: 300,
            height: 250,
            href: '${path }/user/editPwdPage',
            buttons: [{
                text: '确定',
                handler: function () {
                    var f = parent.$.modalDialog.handler.find('#editUserPwdForm');
                    f.submit();
                }
            }]
        });
    }

</script>
</body>
</html>
