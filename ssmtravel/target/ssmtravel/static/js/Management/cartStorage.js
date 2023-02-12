function save()
{
    let storage = window.localStorage["Cart"];
    let _storage = "{";
    for (var key in storage)
    {
        _storage = key + ":" + this.storage[key] + ",";
    }
    _storage = _storage.replace(/,$/g,"") + "}";
    storage.setItem(_storage);
}
function add(id,number)
{
    let storage = window.localStorage["Cart"];
    if (number)
    {
        storage[id] = number;
    }
    else
    {
        if (storage[id] = id)
        {
            storage[id]++;
        }
        else
        {
            storage[id] = 1;
        }
    }
    this.save();
}
function detale(id)
{
    if (this.comn)
    {
        delete this.storage[id]
    }
    this.save()
}
function clear()
{
    window.localStorage["Cart"].clear();
}
function postCart()
{

    var xhr = new XMLHttpRequest();
    var url = "/cart/selectCart";
    var tableId = document.getElementById("tab");
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            document.getElementById("cgname").innerHTML = json.goodsList.get();
            document.getElementById("total").innerHTML = json.total;
            //如何将url获取的结果放在json中
            //请求获得List<Map<String, Object>>, 如何一一对应显示，即一条条数据显示，json.该如何使用
            // console.log(json.Goods_Name + ", " + json.Goods_Price);
        }
    };
    for (var i = 1; i < tableId.rows.length; i++)
    {
        var content1 = tableId.rows[i].ceil(1).innerHTML;
        var content2 = tableId.rows[i].ceil(2).innerHTML;
        var content3 = tableId.rows[i].ceil(3).innerHTML;
        var data = JSON.stringify({"goodsList":content1,"total":content2});
    }
    xhr.send(data);
}

