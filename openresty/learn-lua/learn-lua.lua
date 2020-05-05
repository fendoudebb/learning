local num = 1
-- type(): 打印类型
print(type(num))
local t = {
    [1] = "123",
    id = 456,
    name = "name-789",
    city = {102.1, 96.5}
}
-- #(): 获取表长度, 当索引不连续时（不以1开始时）中断计数
print(#(t))
-- table.getn(): 获取表长度，表现同#()
print(table.getn(t))

-- for key, value in iparis(t) do 遍历表
for i, v in ipairs(t) do
    print(i)
end

