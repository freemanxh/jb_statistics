var newUsers = function() {




    return {
        //main function to initiate the module
        initData: function(start, end, projectId) {

            if(!start) start = moment().subtract('days', 7).format('YYYY-MM-DD');
            if(!end) end  = moment().format('YYYY-MM-DD');
            if(!projectId) projectId = "0";
            var postData = {
                "startDate": start,//开始日期
                "endDate": end,//结束日期
                "pid": projectId//项目ID
            };
            $.ajax({
                "url": basicPath + "/userlogsjson/newUsersJson.do",
                "type": "post",
                "contentType": "application/json",
                "dataType": "json",
                "beforeSend": function(){
                    $('#site_statistics_loading').show();
                    $('#site_statistics_content').hide();
                },
                "data":JSON.stringify(postData),
                "success":function(data){

                    if(data.state == '1') {
                        var visitors = data.result;


                        newUsers.initCharts(visitors);
                    }
                }
            })

        },

        initCharts: function(visitors) {
            if (!jQuery.plot) {
                return;
            }

            $('#site_statistics_table tbody').html('');
            $(visitors.detail).each(function(i ,e) {
                var tr_str = '<tr><td>'+this.name+'</td><td>'+this.newUser+'</td><td>'+this.active+'</td><td>'+this.users+'</td></tr>';
                $('#site_statistics_table tbody').append(tr_str);
            });

            $('.number.newusers > span').text(visitors.allEntities.newUser).attr('data-value',visitors.allEntities.newUser);
            $('.number.actives > span').text(visitors.allEntities.active).attr('data-value',visitors.allEntities.active);
            $('.number.users > span').text(visitors.allEntities.users).attr('data-value',visitors.allEntities.users);


            $("[data-counter='counterup']").counterUp({
                delay: 10,
                time: 1000
            });


            $('#site_statistics_table > table').dataTable({
                "bStateSave": false,
                "bFilter": false,
                "bPaginate": false,
                "bInfo": false,
                "order": [
                    [0, "asc"]
                ]
            });





            $('#site_statistics_loading').hide();
            $('#site_statistics_content').show();



        },
        initDashboardDaterange: function() {
            if (!jQuery().daterangepicker) {
                return;
            }

            $('#dashboard-report-range').daterangepicker({
                "ranges": {
                    '今日': [moment(), moment()],
                    '昨日': [moment().subtract('days', 1), moment().subtract('days', 1)],
                    '最近七天': [moment().subtract('days', 6), moment()],
                    '最近30天': [moment().subtract('days', 29), moment()],
                    '本月': [moment().startOf('month'), moment().endOf('month')],
                    '最近一月': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                },
                "locale": {
                    "format": "YYYY-MM-DD",
                    "separator": " - ",
                    "applyLabel": "确定",
                    "cancelLabel": "取消",
                    "fromLabel": "从",
                    "toLabel": "到",
                    "customRangeLabel": "自定义",
                    "daysOfWeek": [
                        "日",
                        "一",
                        "二",
                        "三",
                        "四",
                        "五",
                        "六"
                    ],
                    "monthNames": [
                        "一月",
                        "二月",
                        "三月",
                        "四月",
                        "五月",
                        "六月",
                        "七月",
                        "八月",
                        "九月",
                        "十月",
                        "十一月",
                        "十二月"
                    ],
                    "firstDay": 1
                },
                //"startDate": "11/08/2015",
                //"endDate": "11/14/2015",
                opens: (App.isRTL() ? 'right' : 'left'),
            }, function(start, end, label) {
                start = start.format('YYYY-MM-DD');
                end = end.format('YYYY-MM-DD');
                $('#dashboard-report-range span').html(start + ' - ' + end);
                $('#dashboard-report-range span').data('start', start);
                $('#dashboard-report-range span').data('end', end);
                var projectId = $('#projectId option:selected').val();
                newUsers.initData(start, end, projectId);

            });

            $('#dashboard-report-range span').html(moment().subtract('days', 7).format('YYYY-MM-DD') + ' - ' + moment().format('YYYY-MM-DD'));
            $('#dashboard-report-range').show();
        },
        initSelect2: function() {
            // @see https://github.com/select2/select2/issues/2927
            $.fn.select2.defaults.set("theme", "bootstrap");

            var placeholder = "选择项目";

            $(".select2").select2({
                placeholder: placeholder,
                width: null
            });

            $(".select2").on("select2:select", function (e) {

                var start = $('#dashboard-report-range span').data('start'),
                    end = $('#dashboard-report-range span').data('end'),
                    projectId = e.params.data.id;
                newUsers.initData(start, end, projectId);
            });
        },
        init: function() {

            this.initData();
            this.initDashboardDaterange();
            this.initSelect2();
        }

    };

}();

jQuery(document).ready(function() {
    newUsers.init();
});