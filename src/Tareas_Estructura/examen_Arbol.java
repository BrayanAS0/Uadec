//Brayan Arias Sanchez
//Matricula:16586095
//exxmane impar
package Tareas_Estructura;


import javax.swing.*;
import java.util.LinkedList;

public class examen_Arbol {
    //arbol
     public class nodoab{
        int numart;
        String nomart;
        int existencia;
        char estatus;
        nodoab izq;
        nodoab  der;
    }

nodoab raiz=null;
  //  examen_Arbol izq, raiz = null, der;
    int contador_arbol = 0;

    //simple circular
   public class nodoles{
        int numart;
        String nomart;
        int existencia;
        nodoles next;
    }

    examen_Arbol siguiente;
    examen_Arbol nc, anterior, temp;
    int contador_circular = 0;
    static LinkedList<Integer> cola = new LinkedList<>();


    //atributos
    int numero_De_articulo;
    String nombre_del_articulo;
    int existencia;
    char estatus;
    static String com = "";

    public examen_Arbol(int numart, String nomart, int existencia, char estatus) {
        this.numero_De_articulo = numart;
        this.nombre_del_articulo = nomart;
        this.existencia = existencia;
        this.estatus = estatus;
    }

    public examen_Arbol() {

    }

    public void insertar_en_arbol() {
        contador_arbol++;
        nodoab nodo_nuevo = new nodoab();
       nodo_nuevo.nomart=JOptionPane.showInputDialog(null, "Inserte el nombre del articulo");
        nodo_nuevo.numart=  Integer.parseInt(JOptionPane.showInputDialog(null, "Numero del articulo:"));
      nodo_nuevo.existencia= Integer.parseInt(JOptionPane.showInputDialog(null, "exitsnecia:"));

        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            nodoab aux = raiz;
            nodoab padre;
            while (true) {
                padre = aux;
                if (nodo_nuevo.numart < aux.numart) {
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }

    public void eliminar_De_manera_logica(nodoab n, int mat) {

        if (n != null) {
            if (n.numart == mat) {
                n.estatus = 'b';
                contador_arbol--;
                return;
            }
            eliminar_De_manera_logica(n.izq, mat);
            //  com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";
            eliminar_De_manera_logica(n.der, mat);
        }
    }


    public void pasar_de_arbol_a_lista_parte_2(nodoab n) {
        if (n != null && n.estatus != 'b') {

            pasar_de_arbol_a_lista_parte_2(n.izq);
            //aqui va donde pasa  a lista

            pasar_de_arbol_a_lista_parte_3(n);
            pasar_de_arbol_a_lista_parte_2(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_de_arbol_a_lista_parte_2(n.izq);
            pasar_de_arbol_a_lista_parte_2(n.der);
        }
    }

    public void pasar_de_arbol_a_lista_parte_3(nodoab nuevo_nodo) {
//aqui es donde se agregan  a lista
       /* nodoab a= new nodoab();

   if (nc == null) {
            nc = new examen_Arbol();
            nc.siguiente = nc;


        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_De_articulo < nuevo_nodo.numart)) {
            anterior = temp;
            temp = temp.siguiente;

        }
        contador_circular++;
        nuevo_nodo.siguiente = anterior.siguiente;
        anterior.siguiente = nodoab;
*/

    }


    public void post_orden(nodoab n) {
        if (n != null && n.estatus != 'b') {
            post_orden(n.izq);
            post_orden(n.der);
            com = com + "Numero de articulo: " + n.numart + "\nNombre del articulo: " + n.nomart + "\nExistencia: " + n.existencia + "\n----------------------------------------------------------------------------------------\n";

        }
        if (n != null && n.estatus == 'b') {
            post_orden(n.izq);
            post_orden(n.der);
        }
    }

    public void pre_orden(nodoab n) {
        if (n != null && n.estatus != 'b') {
            com = com + "Numero de articulo: " + n.numart + "\nNombre del articulo: " + n.nomart + "\nExistencia: " + n.existencia + "\n----------------------------------------------------------------------------------------\n";
            pre_orden(n.izq);
            pre_orden(n.der);

        }
        if (n != null && n.estatus == 'b') {
            pre_orden(n.izq);
            pre_orden(n.der);
        }

    }

    public void orden(nodoab n) {
        if (n != null && n.estatus != 'b') {

            orden(n.izq);
            com = com + "Numero de articulo: " + n.numart + "\nNombre del articulo: " + n.nomart + "\nExistencia: " + n.existencia + "\n----------------------------------------------------------------------------------------\n";

            orden(n.der);
        }
        if (n != null && n.estatus == 'b') {
            orden(n.izq);
            orden(n.der);
        }
    }

    public void consultar_nodo_arbol(nodoab n, int numero_De_articulo__pa_borrar) {
        if (n != null && n.estatus != 'b') {
            if (numero_De_articulo__pa_borrar == n.numart) {
                JOptionPane.showMessageDialog(null, "Numero de articulo: " + n.numart + "\nNombre del articulo: " + n.nomart + "\nExistencia: " + n.existencia + "\n----------------------------------------------------------------------------------------\n");
                return; // Detiene la recursión si encuentra el nodo deseado
            }
            consultar_nodo_arbol(n.izq, numero_De_articulo__pa_borrar);
            consultar_nodo_arbol(n.der, numero_De_articulo__pa_borrar);
        }
    }

    public void numero_De_nodos_arbol() {

        JOptionPane.showMessageDialog(null, "Numero de nodos que tine la lista son :" + contador_arbol);
    }

    public int profundidad(nodoab nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int profundidadIzquierda = profundidad(nodo.izq);
            int profundidadDerecha = profundidad(nodo.der);
            return 1 + Math.max(profundidadIzquierda, profundidadDerecha);//para irme al que mas se acerque
        }
    }

    public void pasar_de_arbol_a_lista_linkedList(nodoab n) {
        if (n != null && n.estatus != 'b') {

            pasar_de_arbol_a_lista_linkedList(n.izq);
            //aqui va donde pasa  a lista

            cola.add(n.numart);
            pasar_de_arbol_a_lista_linkedList(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_de_arbol_a_lista_linkedList(n.izq);
            pasar_de_arbol_a_lista_linkedList(n.der);
        }
    }

    public void imprimir_lista(examen_Arbol n) {
        examen_Arbol temp = nc.siguiente;
        String datos = "";
        while (temp != nc) {
            datos = datos + "Numero de articulo: " + temp.numero_De_articulo + "\nNombre del articulo: " + temp.nombre_del_articulo + "\nExistencia: " + temp.existencia + "\n----------------------------------------------------------------------------------------\n";
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, datos);
    }

    public void imprimir_likedlist() {
        JOptionPane.showMessageDialog(null, cola);
    }

    public static void main(String[] args) {
        examen_Arbol a = new examen_Arbol();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Brayan Arias Sanchez\nInserte una opcion:\n" +"0. para salir del programa\n"+

                    "2)	Insertar un dato en el Arbol Binario, cargando a la izquierda los menores y a la derecha los mayores, por el campo de numart.\n" +
                    "3)	Eliminar lógicamente un nodo del Arbol Binario buscándolo por numart= X.\n" +
                    "4)	Copiar los datos del Arbol Binario basándose en el recorrido Inorder, a la lista encadenada simple circular clase nodoles de manera que en la lista encadenada simple circular el primer nodo sea el menor por el campo de numart y así sucesivamente hasta dejar en el último nodo el mayor de numart. (manejar la les clase nodo como COLA)\n" +
                    "5)	Recorridos de Arbol Binario que imprima los campos de : numart,nomart, existencia; siempre y cuando el nodo no este dado de baja lógica.\n" +
                    "       o	Preorder\n" +
                    "o	Inorder\n" +
                    "o	Postorder\n" +
                    "6)	Consultar un nodo del Arbol Binario buscándolo por numart=X.\n" +
                    "7)	Contar el número de nodos activos del árbol binario.\n" +
                    "8)	Encontrar la profundidad del árbol binario.\n" +
                    "9)	Copiar los datos del árbol binario a la otra  Lista Encadenada Simple (linkedlist) manejando la lista tipo PILA, siendo el elemento del tope el mayor de numart y el último el menor de numart. Basarse en el recorrido inorder.\n" +
                    "10)	Imprimir el contenido de la Lista Encadenada Simple Circular clase nodo con todos los campos.\n" +
                    "11)	Imprimir el contenido de la Lista Encadenada Simple de linkedlist.\n"));


            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;

                case 2:
                    a.insertar_en_arbol();

                    break;
                case 3:

                        int num_de_art = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el numero de articulo para borrar"));
                        a.eliminar_De_manera_logica(a.raiz, num_de_art);


                    break;
                case 4:
                    if (a.raiz != null)
                        a.pasar_de_arbol_a_lista_parte_2(a.raiz);
                    else
                        JOptionPane.showMessageDialog(null, "el arbol no tiene nodos");
                    break;
                case 5:
                    if (a.raiz != null) {
                        com = "In-Orden\n\n";
                        a.orden(a.raiz);
                        JOptionPane.showMessageDialog(null, com);

                        com = "Post-Orden\n\n";
                        a.post_orden(a.raiz);
                        JOptionPane.showMessageDialog(null, com);
                        com = "Pre-Orden\n\n";
                        a.pre_orden(a.raiz);
                        JOptionPane.showMessageDialog(null, com);
                    } else
                        JOptionPane.showMessageDialog(null, "el arbol no tiene nodos");
                    break;
                case 6:

                    int nn = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulo que quieres buscar"));
                    a.consultar_nodo_arbol(a.raiz, nn);
                    break;
                case 7:
                    a.numero_De_nodos_arbol();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, a.profundidad(a.raiz));
                    break;
                case 9:
                    a.pasar_de_arbol_a_lista_linkedList(a.raiz);
                    break;
                case 10:
                    a.imprimir_lista(a.nc);
                    break;
                case 11:
                    JOptionPane.showMessageDialog(null, cola);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");


            }

        } while (op != 0);

    }
}

