alert("wa");
$(document).ready(function () {
    
var data = "${CompPercentage}";
var bioMaterial = "${fields}";
var dataset = new Array();
dataset.push({name: "ACC", data: data});
document.getElementById("demo").innerHTML = dataset[0].name;
    var chartdata = {
        chart: {type: 'column'},
        title: {text: 'ACC Biomaterial Completeness'},
        xAxis: {
            categories: ["whole_blood", "spot_urine", "normal_tissue", "tumor_tissue_paraffin", "tumor_tissue_frozen", "plasma", "serum"]
        },
        yAxis: {
            min: 0,
            title: {text: 'Percentage'}
        },
        series: [
            {
                name: 'ACC',
                data: [9.667597056584624, 17.153006851053032, 1.4970819588936817, 5.683836589698046, 9.109363105810708, 35.52397868561279, 41.309312357269725]
            }]
    };
    chartdata.series = dataset;
    chartdata.xAxis.categories = bioMaterial;

//                var series = [
//                    {
//                        name: 'ACC',
//                        data: [9.667597056584624, 17.153006851053032, 1.4970819588936817, 5.683836589698046, 9.109363105810708, 35.52397868561279, 41.309312357269725]
//                    }];
    var dataset = new Array();
    dataset.push({
        name: 'ACC',
        data: [9.667597056584624, 17.153006851053032, 1.4970819588936817, 5.683836589698046, 9.109363105810708, 35.52397868561279, 41.309312357269725]
    });
    var bioMaterial = ["whole_blood", "spot_urine", "normal_tissue", "tumor_tissue_paraffin", "tumor_tissue_frozen", "plasma", "serum"];
    var chartdata = {
        chart: {type: 'column'},
        title: {text: 'ACC Biomaterial Completeness'},
        xAxis: {
            categories: []
        },
        yAxis: {
            min: 0,
            title: {text: 'Percentage'}
        },
        series: []
    };
    chartdata.series = dataset;
    chartdata.xAxis.categories = bioMaterial;
    $('#container').highcharts(chartdata);
});

