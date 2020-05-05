--{"id":1,"title":"this is title","content":"this is content","topics":["aaa","bbb"]}
select row_to_json(post) from post;

--{"f1":"aaa","f2":["aaa","bbb"]}
select row_to_json(row(title, topics)) from post;