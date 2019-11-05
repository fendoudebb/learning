# -*- coding:utf-8 -*-

# pip install tornado
import tornado.ioloop
import tornado.web


class MainHandler(tornado.web.RequestHandler):
    def get(self):
        self.write("Hello, world")


class ChildHandler(tornado.web.RequestHandler):
    def get(self):
        self.write("<h1>Hello, world, abc</h1>")


def make_app():
    return tornado.web.Application([
        (r"/", MainHandler),
        (r"/abc", ChildHandler),
    ])


if __name__ == "__main__":
    app = make_app()
    app.listen(8888)
    tornado.ioloop.IOLoop.current().start()
