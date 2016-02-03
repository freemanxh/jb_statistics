var Dashboard = function() {



    return {


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
                "url": basicPath + "/userlogsjson/clickJson.do",
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
                        var result = data.result,visitors = [];

                        $(result).each(function(i ,e) {
                            visitors.push([this.time,this.data]);
                        });

                        Dashboard.initCharts(visitors);
                    }
                }
            })

        },

        initCharts: function(visitors) {
            if (!jQuery.plot) {
                return;
            }

            function showChartTooltip(x, y, xValue, yValue) {
                $('<div id="tooltip" class="chart-tooltip">' + yValue + '<\/div>').css({
                    position: 'absolute',
                    display: 'none',
                    top: y - 40,
                    left: x - 40,
                    border: '0px solid #ccc',
                    padding: '2px 6px',
                    'background-color': '#fff'
                }).appendTo("body").fadeIn(200);
            }

            var data = [];
            var totalPoints = 250;

            // random data generator for plot charts



            if ($('#site_statistics').size() != 0) {

                $('#site_statistics_loading').hide();
                $('#site_statistics_content').show();

                $('#site_statistics_table tbody').html('');
                $(visitors).each(function(i ,e) {

                    var tr_str = '<tr><td>'+this[0]+'</td><td>'+this[1]+'</td></tr>';
                    $('#site_statistics_table tbody').append(tr_str);

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



                var plot_statistics = $.plot($("#site_statistics"), [{
                        data: visitors,
                        lines: {
                            fill: 0.6,
                            lineWidth: 0
                        },
                        color: ['#f89f9f']
                    }, {
                        data: visitors,
                        points: {
                            show: true,
                            fill: true,
                            radius: 5,
                            fillColor: "#f89f9f",
                            lineWidth: 3
                        },
                        color: '#fff',
                        shadowSize: 0
                    }],

                    {
                        xaxis: {
                            tickLength: 0,
                            tickDecimals: 0,
                            mode: "categories",
                            min: 0,
                            font: {
                                lineHeight: 14,
                                style: "normal",
                                variant: "small-caps",
                                color: "#6F7B8A"
                            }
                        },
                        yaxis: {
                            ticks: 5,
                            tickDecimals: 0,
                            tickColor: "#eee",
                            font: {
                                lineHeight: 14,
                                style: "normal",
                                variant: "small-caps",
                                color: "#6F7B8A"
                            }
                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            tickColor: "#eee",
                            borderColor: "#eee",
                            borderWidth: 1
                        }
                    });

                var previousPoint = null;
                $("#site_statistics").bind("plothover", function(event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPoint != item.dataIndex) {
                            previousPoint = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showChartTooltip(item.pageX, item.pageY, item.datapoint[0], item.datapoint[1] + ' 次');
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPoint = null;
                    }
                });
            }

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
                Dashboard.initData(start, end, projectId);

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
                Dashboard.initData(start, end, projectId);
            });
        },


        init: function() {

            this.initData();
            this.initDashboardDaterange();
            this.initSelect2();

        }
    };

}();

if (App.isAngularJsApp() === false) {
    jQuery(document).ready(function() {
        Dashboard.init(); // init metronic core componets
    });
}