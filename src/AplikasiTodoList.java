public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     *  Menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for(var i=0 ; i < model.length ; i++){
            String todo = model[i];
            var nomor = i+1;

            if(todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }
    }

    /**
     * Menambah todo list
     */
    public static void addTodoList(String todo){
        // cek apakah model penuh?
        var isFull = true;
        for(var i=0 ;  i< model.length ; i++){
            if(model[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        // jika penuh, kita resize 2xlipat
        if(isFull){
            var temp = model;
            model = new String[model.length*2];

            for(var i=0 ; i<temp.length ; i++){
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data array nya null
        for (var i=0 ; i<model.length ; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * Menghapus todo list
     */
    public static boolean removeTodoList(Integer number){
        if(number - 1 >= model.length){
            return false;
        }

        if(model[number - 1] == null){
            return false;
        }else{
            for (int i = number-1 ; i< model.length ; i++){
                if(i == model.length - 1){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }

            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);
        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");

        String data = scanner.nextLine();

        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan Todo List
     */
    public static void viewShowTodoList(){
        while(true){
            showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */

    public static void viewAddTodoList(){
        System.out.println("Menambah TODO List");

        var todo = input("Todo (x jika batal)");

        if(todo.equals("x")){

        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view menghapus todo list
     */

    public static void viewRemoveTodoList(){
        System.out.println("Menghapus Todo List");

        var number = input("Nomor yang dihapus (x jika batal)");

        if(number.equals("x")){

        }else{
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
