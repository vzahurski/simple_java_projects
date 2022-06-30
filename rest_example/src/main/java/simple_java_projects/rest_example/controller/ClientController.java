package simple_java_projects.rest_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple_java_projects.rest_example.model.Client;
import simple_java_projects.rest_example.service.ClientService;

import java.sql.SQLException;
import java.util.List;

// @RestController — говорит спрингу, что данный класс является REST контроллером.
// Т.е. в данном классе будет реализована логика обработки клиентских запросов
@RestController
public class ClientController {

    private final ClientService clientService;

    // @Autowired — говорит спрингу, что в этом месте необходимо внедрить зависимость.
    // В конструктор мы передаем интерфейс ClientService. Реализацию данного сервиса мы пометили аннотацией @Service
    // ранее, и теперь спринг сможет передать экземпляр этой реализации в конструктор контроллера.
    // Spring будет предоставлять нам экземпляр класса, помеченного @Service в местах, где это, нужно с помощью
    // Dependency Injection. Контроль над созданием экземпляра зависимости передан Dependency Injection контейнеру
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Далее в классе мы реализуем логику обработки клиентских запросов на эндпоинты (URI).
    // Если пришел http-запрос с таким http-методом и таким URI, то вызываем такой-то метод объекта контроллера

    // Разберем следующий метод:
    // @PostMapping(value = "/clients") — здесь мы обозначаем, что данный метод обрабатывает POST запросы на адрес /clients
    // Метод возвращает ResponseEntity<?>. ResponseEntity — специальный класс для возврата ответов.
    //                                           С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
    // Метод принимает параметр @RequestBody Client client, значение этого параметра подставляется из тела запроса.
    // Об этом говорит аннотация  @RequestBody.
    // Внутри тела метода мы вызываем метод create у ранее созданного сервиса и передаем ему принятого в параметрах
    // контроллера клиента. После чего возвращаем статус 201 Created, создав новый объект ResponseEntity и передав в
    // него нужное значение кода возврата HttpStatus.
    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) throws SQLException {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // @GetMapping(value = "/clients") — все аналогично аннотации @PostMapping, только теперь мы обрабатываем GET запросы.
    // На этот раз мы возвращаем ResponseEntity<List<Client>>, только в этот раз, помимо HTTP статуса, мы вернем еще и
    //  тело ответа, которым будет список клиентов.
    // В REST контроллерах спринга все POJO объекты, а также коллекции POJO объектов, которые возвращаются в качестве
    // тел ответов, автоматически сериализуются в JSON, если явно не указано иное. Нас это вполне устраивает.
    // Внутри метода, с помощью нашего сервиса мы получаем список всех клиентов. Далее, в случае если список не null и
    // не пуст, мы возвращаем c помощью класса ResponseEntity сам список клиентов и HTTP статус 200 OK.
    // Иначе мы возвращаем просто HTTP статус 404 Not Found.
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() throws SQLException {
        final List<Client> clients = clientService.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Из нового, у нас тут появилась переменная пути. Переменная, которая определена в URI. value = "/clients/{id}".
    // Мы указали ее в фигурных скобках. А в параметрах метода принимаем её в качестве int переменной, с помощью
    // аннотации @PathVariable(name = "id").
    // Данный метод будет принимать запросы на uri вида /clients/{id}, где вместо {id} может быть любое численное значение.
    // Данное значение, впоследствии, передается переменной int id — параметру метода.
    // В теле мы получаем объект Client с помощью нашего сервиса и принятого id. И далее, по аналогии со списком,
    // возвращаем либо статус 200 OK и сам объект Client, либо просто статус 404 Not Found,
    // если клиента с таким id не оказалось в системе.
    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) throws SQLException {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) throws SQLException {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) throws SQLException {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
