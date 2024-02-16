package task.test.start;

import task.test.controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        String request;
        StringBuilder response = new StringBuilder();

        request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
        response.append(controller.doAction(request));
        System.out.println(response);

        request = "ADD\ntitle=Книга\nсоntent=Гарри Поттер";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "SORT\nid";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "SORT\ncontent";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "SORT\ntitle";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "SORT\ndate";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "UPDATE\nid=2\ntitle=Книга\ncontent=Гарри Поттер 2часть\ndate=2024-01-29";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "DELETE\nid=2";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "DELETE\nnumber=1";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "FIND\ntitle=Книга";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "FIND\nid=7";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

        request = "CLEAR\n";
        response.replace(0, response.length(), controller.doAction(request));
        System.out.println(response);

    }

}
