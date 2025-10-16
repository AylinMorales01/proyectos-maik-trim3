import java.util.Scanner;

import model.Usuario;
import repository.UsuarioRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        /* Pedir nombre */
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        /* Pedir edad */
        System.out.print("Ingrese edad: ");
        Long edad = scanner.nextLong();

        Usuario usuario = new Usuario(nombre, edad);
        usuarioRepository.insertarUsuario(usuario);

        System.out.println("Lista de usuarios:");

        for(Usuario u: usuarioRepository.listarUsuarios()) {
            System.out.println("Id: " + u.getId() + 
                                " Nombre: " + u.getNombre() +
                                " Edad: " + u.getEdad());
                                System.out.println("---------------------------------");
        }

        // Consultar usuario por ID
        System.out.print("Ingrese ID de usuario a consultar: ");
        Integer id = scanner.nextInt();
        Usuario usuarioConsultado = usuarioRepository.consultarUsuarioPorId(id);
        if (usuarioConsultado != null) {
            System.out.println("Usuario encontrado: ");
            System.out.println("---------------------------------");
            System.out.println("Id: " + usuarioConsultado.getId()+ 
                                " Nombre: " + usuarioConsultado.getNombre() +
                                " Edad: " + usuarioConsultado.getEdad());
        } else {
            System.out.println("Usuario no encontrado.");
        }

        System.out.print("Ingrese ID de usuario a eliminar: ");
        Long idEliminar = scanner.nextLong();

        boolean resultado = usuarioRepository.eliminarUsuarioPorId(idEliminar);

        if (resultado) {
            System.out.println("Usuario fue eliminado.");
        } else {
            System.out.println("No se pudo eliminar el usuario (puede que no exista).");
        }

        System.out.print("Ingrese ID del usuario a actualizar: ");
            Long idActualizar = scanner.nextLong();
            scanner.nextLine(); // Limpia el buffer del scanner

            System.out.print("Ingrese nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese nueva edad: ");
            Long nuevaEdad = scanner.nextLong();

            // Crear objeto Usuario con los nuevos datos
            Usuario usuarioActualizado = new Usuario(idActualizar, nuevoNombre, nuevaEdad);

            // Llamar al método del repositorio
            boolean resultadoActualizar = usuarioRepository.actualizarUsuario(usuarioActualizado);

            if (resultado) {
                System.out.println("Usuario actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el usuario (verifique el ID).");
            }


        scanner.close();
    } 
}