class Cart
{
    constructor()
    {
        this.storage = {};
    }
    //检测浏览器是否支持locastorage和变量的初始化
    comn()
    {
        let _storage;
        if (window.localStorage)
        {
            if (window.localStorage["Cart"])
            {
                _storage = window.localStorage["Cart"];
                _storage = eval("("+_storage+")");
                for (let key in _storage)
                {
                    _storage[key] = this.storage[key];
                }
            }
            return true;
        }
        return false;
    }
    //保存
    save()
    {
        let _storage = "{";
        for (var key in this.storage)
        {
            _storage = key + ":" + this.storage[key] + ",";
        }
        _storage = _storage.replace(/,$/g,"") + "}";
        window.localStorage.setItem(_storage);
    }
    //添加数量
    add(id,number)
    {
        if (this.comn())
        {
            if (number)
            {
                this.storage[id] = number;
            }
            else
            {
                if (this.storage[id] = id)
                {
                    this.storage[id]++;
                }
                else
                {
                    this.storage[id] = 1;
                }
            }
        }
        this.save();
    }
    // 删除指定的商品
    detale(id)
    {
        if (this.comn)
        {
            delete this.storage[id]
        }
        this.save()
    }
    // 统计所有的数量
    count()
    {
        if (this.comn())
        {
            var sum = 0;
            let _storage;
            _storage = eval("("+this.storage+")");
            for (var key in _storage)
            {
                sum += _storage[key]
            }
            return sum
        }
        this.save()
    }
    // 减少商品的数量
    reduce(id,number)
    {
        if (this.comn())
        {
            if (this.storage[id]>number)
            {
                this.storage[id] = this.storage[id] - number;
            }else
            {
                delete this.storage[id];
            }
            this.save()
        }
    }
}