package start;

import controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        String request;
        String response;

        request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
        response = controller.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Книга\nсоntent=Гарри Поттер";
        response = controller.doAction(request);
        System.out.println(response);

        request = "UPDATE\nid=2\ntitle=Книга\ncontent=Гарри Поттер 2часть\ndate=2024-01-29";
        response = controller.doAction(request);
        System.out.println(response);

        request = "DELETE\nid=1";
        response = controller.doAction(request);
        System.out.println(response);

        request = "DELETE\nnumber=1";
        response = controller.doAction(request);
        System.out.println(response);

        request = "FIND\ntitle=Книга";
        response = controller.doAction(request);
        System.out.println(response);

        request = "FIND\nid=1";
        response = controller.doAction(request);
        System.out.println(response);

        request = "CLEAR\n";
        response = controller.doAction(request);
        System.out.println(response);

    }

}
