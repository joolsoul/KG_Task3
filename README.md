# Задача 3
  Во всех вариантах должна быть предусмотрена возможность управления областью просмотра(параметрами камеры). В идеале с помощью мыши и дополнительно с помощью клавиатуры. В простом случае будет достаточно соответствующего UI. Также, вероятно, стоит добавить вывод координатных осей, для ориентирования.
  Основные объекты задачи должны быть вынесены в классы (модели).
  Для рисования примитивов можно использовать возможности graphics'а.
  Нельзя использовать готовые инструменты, например, возможности graphics'а по повороту, масштабированию или перемещению экранной системы координат.
  При разработке программы использовать подходы и архитектуру, рассмотренные на занятиях (классы и интерфейсы Screen, Camera, Model, Scene, Vector*, Matrix* и др.).  Около каждой задачи указана ориентировочная сложность задачи. В целом, это число равно оценке при приемлемой реализации задачи.
____
  Написать программу построения тени от платонова тела, освещенного точечным источником. Пользователь выбирает, какое именно платоново тело использовать, местоположение точечного источника света (просто точка в пространстве) и плоскость, на которой выводить тень (параметры A, B, C и D из канонического уравнения). Платоновы тела должны быть реализованы в виде отдельных классов, унаследованных от интерфейса IModel. Возможно, было бы удобно использовать один из порождающих паттернов проектирования для создания выбранного платонового тела.
____
![image](https://user-images.githubusercontent.com/71376506/185755447-251dc0e6-7882-4734-84f4-0ef3e5087342.png)
