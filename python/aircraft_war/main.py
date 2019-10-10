import pygame
from pygame.locals import *
import time

window_x = 480
window_y = 500


class Hero:
    def __init__(self, screen):
        self.screen = screen
        self.image = pygame.image.load("./file/hero1.png")
        self.width = self.image.get_width()
        self.height = self.image.get_height()
        self.x = (window_x - self.width) / 2
        self.y = window_y - self.height
        self.bullet_list = []

    def display(self):
        self.screen.blit(self.image, (self.x, self.y))
        for bullet in self.bullet_list:
            bullet.display()
            bullet.move()

    def move_left(self):
        self.x -= 5

    def move_right(self):
        self.x += 5

    def move_up(self):
        self.y -= 5

    def move_down(self):
        self.y += 5

    def fire(self):
        self.bullet_list.append(Bullet(self.screen, self.x, self.y))


class Enemy:
    def __init__(self, screen):
        self.screen = screen
        self.image = pygame.image.load("./file/enemy0.png")
        self.width = self.image.get_width()
        self.height = self.image.get_height()
        self.x = (window_x - self.width) / 2
        self.y = 0
        self.bullet_list = []
        self.direction = 'right'

    def display(self):
        self.screen.blit(self.image, (self.x, self.y))

    def move(self):
        if self.direction == 'right':
            self.x += 5
        elif self.direction == 'left':
            self.x -= 5

        if self.x > 200:
            self.direction = 'left'
        elif self.x <0:
            self.direction = 'right'


    def fire(self):
        self.bullet_list.append(Bullet(self.screen, self.x, self.y))


class Bullet:
    def __init__(self, screen, x, y):
        self.screen = screen
        self.x = x + 40
        self.y = y - 20
        self.image = pygame.image.load("./file/bullet.png")

    def display(self):
        self.screen.blit(self.image, (self.x, self.y))

    def move(self):
        self.y -= 10


def keyboard_control(hero):
    # 获取事件，比如按键等
    for event in pygame.event.get():

        # 判断是否是点击了退出按钮
        if event.type == QUIT:
            print("exit")
            exit()
        # 判断是否是按下了键
        elif event.type == KEYDOWN:
            # 检测按键是否是a或者left
            if event.key == K_a or event.key == K_LEFT:
                print('left')
                hero.move_left()

            # 检测按键是否是d或者right
            elif event.key == K_d or event.key == K_RIGHT:
                print('right')
                hero.move_right()
            # 检测按键是否是w或者up
            elif event.key == K_w or event.key == K_UP:
                print('up')
                hero.move_up()
            # 检测按键是否是s或者down
            elif event.key == K_w or event.key == K_DOWN:
                print('down')
                hero.move_down()

            # 检测按键是否是空格键
            elif event.key == K_SPACE:
                print('space')
                hero.fire()


def main():
    # 1. 创建一个窗口，用来显示内容
    screen = pygame.display.set_mode((window_x, window_y), 0, 32)

    # 2. 创建一个和窗口大小的图片，用来充当背景
    background = pygame.image.load("./file/background.png")

    hero = Hero(screen)
    enemy = Enemy(screen)

    # 3. 把背景图片放到窗口中显示
    while True:
        # 设定需要显示的背景图
        screen.blit(background, (0, 0))
        hero.display()
        enemy.display()
        keyboard_control(hero)
        # 更新需要显示的内容
        pygame.display.update()
        time.sleep(0.01)


if __name__ == '__main__':
    main()
