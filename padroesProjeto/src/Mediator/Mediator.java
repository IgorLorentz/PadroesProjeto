package Mediator;
import java.util.ArrayList;
import java.util.List;


// Interface Mediator
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator
class Chat implements ChatMediator {
    private List<User> users;

    public Chat() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMesage(String message);

    public abstract void receiveMessage(String message);
}

class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMesage(String message) {
        System.out.println(this.name + " enviou a mensagem: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.name + " chegou mensagem para você: " + message);
    }
}

public class Mediator{
    public static void main(String[] args) {
        ChatMediator chat = new Chat();

        System.out.println("Sala de criada com sucesso.\n");

        User user1 = new ChatUser(chat, "Cléber");

        System.out.println(user1.name + " adicionado na sala.\n");

        User user2 = new ChatUser(chat, "João");

        System.out.println(user2.name + " adicionado na sala.\n");

        User user3 = new ChatUser(chat, "Zé");

        System.out.println(user3.name + " adicionado na sala.\n");

        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);

        user1.sendMesage("Olá galerinha.");
        user2.sendMesage("Tudo bem Cléber?");
        user1.sendMesage("Tudo certo João.");
        user3.sendMesage("E aí, pessoal!");
        user1.sendMesage("Oi Zé como vai?");
        user3.sendMesage("Oi Cléber");
        user2.sendMesage("Oi Zé");
        user3.sendMesage("Oi João");
    }
}