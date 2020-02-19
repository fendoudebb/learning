-- topics数组中是否包含aaa
select * from post where 'aaa'=ANY(topics);

-- 在数组末尾追加元素
-- {1,2,3}
SELECT array_append(ARRAY[1,2], 3);

-- 返回数组指定维度的长度
-- 3
SELECT array_length(array[1,2,3], 1);

-- 返回元素在数组的位置（默认为1）开始第一次出现在数组中的位置，数组必须是一维的
-- 2
SELECT array_position(ARRAY['sun','mon','tue','wed','thu','fri','sat'], 'mon');

-- 连接两个数组
-- {1,2,3,4,5}
SELECT array_cat(ARRAY[1,2,3], ARRAY[4,5]);

-- 返回数组指定维度的长度
SELECT array_length(array[1,2,3], 1);

-- 返回数组维数
-- 2
SELECT array_ndims(ARRAY[[1,2,3], [4,5,6]]);


SELECT string_to_array('text1', 'text2');
