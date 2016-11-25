<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--%@ include file="/webresources/common/header.jspf"%-->
<html>
<head>
</head>
<body>


<img src="http://autopoi.ru/images/zoombox.png" width="100%" height="111">

<aside id="aside1" style="padding: 4px; border: 0px;">
    <div style="background: none 0% 0% / auto repeat scroll padding-box border-box rgb(204, 221, 204); overflow: visible; padding: 0px; box-sizing: border-box; width: 100%;" class="">
			<pre>
				Здесь будут выпадающие списки
				пару строк для толщины
			</pre>
    </div>
</aside>



<img src="http://autopoi.ru/images/zoombox.png" width="100%" height="111">


<div>
<pre>
1
2
3
    ${q}




























































	Hi, World!
</pre>

</div>


<!--div id="header">
    <nav>
        <ul>
            <li id="login">
                <a id="login-trigger" href="#">
                    Войти <span>&#x25BC;</span>
                </a>
                <div id="login-content">
                    <form>
                        <fieldset id="inputs">
                            <input id="username" type="email" name="Email" placeholder="Ваш email адрес" required>
                            <input id="password" type="password" name="Password" placeholder="Пароль" required>
                        </fieldset>
                        <fieldset id="actions">
                            <input type="submit" id="submit" value="Войти">
                            <label><input type="checkbox" checked="checked"> Запомнить меня</label>
                        </fieldset>
                    </form>
                </div>
            </li>
            <li id="signup">
                <a href="">Регистрация</a>
            </li>
        </ul>
    </nav>

</div-->

<style>
    .sticky {
        position: fixed;
        top: 0px;  /* если ноль заменить на число (и в скрипте тоже), то блок будет прилипать до того, как верхний край окна браузера дойдёт до верхнего края элемента. Может быть отрицательным числом. Применим, например, при фиксированном сверху меню */
        z-index: 101;
    }
</style>

<script>
    (function(){  // анонимная функция (function(){ })(), чтобы переменные "a" и "b" не стали глобальными
        var a = document.querySelector('#aside1'), b = null;  // селектор блока, который нужно закрепить
        window.addEventListener('scroll', Ascroll, false);
        document.body.addEventListener('scroll', Ascroll, false);  // если у html и body высота равна 100%
        function Ascroll() {
            if (b == null) {  // добавить потомка-обёртку, чтобы убрать зависимость с соседями
                var Sa = getComputedStyle(a, ''), s = '';
                for (var i = 0; i < Sa.length; i++) {  // перечислить стили CSS, которые нужно скопировать с родителя
                    if (Sa[i].indexOf('overflow') == 0 || Sa[i].indexOf('padding') == 0 || Sa[i].indexOf('border') == 0 || Sa[i].indexOf('outline') == 0 || Sa[i].indexOf('box-shadow') == 0 || Sa[i].indexOf('background') == 0) {
                        s += Sa[i] + ': ' +Sa.getPropertyValue(Sa[i]) + '; '
                    }
                }
                b = document.createElement('div');  // создать потомка
                b.style.cssText = s + ' box-sizing: border-box; width: ' + a.offsetWidth + 'px;';
                a.insertBefore(b, a.firstChild);  // поместить потомка в цепляющийся блок
                var l = a.childNodes.length;
                for (var i = 1; i < l; i++) {  // переместить во вновь созданного потомка всех остальных потомков плавающего блока (итого: создан потомок-обёртка)
                    b.appendChild(a.childNodes[1]);
                }
                a.style.height = b.getBoundingClientRect().height + 'px';  // если под скользящим элементом есть другие блоки, можно своё значение
                a.style.padding = '0';
                a.style.border = '0';  // если элементу присвоен padding или border
            }
            if (a.getBoundingClientRect().top <= 0) { // elem.getBoundingClientRect() возвращает в px координаты элемента относительно верхнего левого угла области просмотра окна браузера
                b.className = 'sticky';
            } else {
                b.className = '';
            }
            window.addEventListener('resize', function() {
                a.children[0].style.width = getComputedStyle(a, '').width
            }, false);  // если изменить размер окна браузера, измениться ширина элемента
        }
    })()
</script><div style="clear:both; padding-bottom:0.25em"></div>


</body>
</html>

<%--end content--%>
<%@ include file="/webresources/common/footer.jspf"%>
