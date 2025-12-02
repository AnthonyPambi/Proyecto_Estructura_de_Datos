package vista;

//import Inicio.Menu;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import Arboles.Arboles_Binarios.Nodo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;


public class ArbolesAVLVista extends javax.swing.JFrame {
    public ArbolesAVLVista() {
        initComponents();
        setTitle("---Arbol Binario---");
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnInsertarIzq = new javax.swing.JButton();
        btnInorden = new javax.swing.JButton();
        btnPreorden = new javax.swing.JButton();
        btnPostorden = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jbtnNiveles = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnInsertarDer = new javax.swing.JButton();
        btnRaiz = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblReferencia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel1.setText("Valor");

        txtValor.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        btnInsertarIzq.setBackground(new java.awt.Color(77, 119, 181));
        btnInsertarIzq.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnInsertarIzq.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarIzq.setText("Insertar Izquierda");
        btnInsertarIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarIzqActionPerformed(evt);
            }
        });

        btnInorden.setBackground(new java.awt.Color(77, 119, 181));
        btnInorden.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnInorden.setForeground(new java.awt.Color(255, 255, 255));
        btnInorden.setText("IDR (P)");
        btnInorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInordenActionPerformed(evt);
            }
        });

        btnPreorden.setBackground(new java.awt.Color(77, 119, 181));
        btnPreorden.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnPreorden.setForeground(new java.awt.Color(255, 255, 255));
        btnPreorden.setText("RID\n(Preorden)");
        btnPreorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreordenActionPerformed(evt);
            }
        });

        btnPostorden.setBackground(new java.awt.Color(77, 119, 181));
        btnPostorden.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnPostorden.setForeground(new java.awt.Color(255, 255, 255));
        btnPostorden.setText("IRD (Postorden)");
        btnPostorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostordenActionPerformed(evt);
            }
        });

        jbtnSalir.setBackground(new java.awt.Color(77, 119, 181));
        jbtnSalir.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jbtnSalir.setForeground(new java.awt.Color(255, 255, 255));
        //jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Exit-Page_icon-icons.com_53732 (1).png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arboles Binarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Black", 3, 14))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbtnNiveles.setBackground(new java.awt.Color(77, 119, 181));
        jbtnNiveles.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jbtnNiveles.setForeground(new java.awt.Color(255, 255, 255));
        jbtnNiveles.setText("Por Nivel");
        jbtnNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNivelesActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(77, 119, 181));
        btnVisualizar.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnVisualizarStateChanged(evt);
            }
        });
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnInsertarDer.setBackground(new java.awt.Color(77, 119, 181));
        btnInsertarDer.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnInsertarDer.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarDer.setText("Insertar Derecha");
        btnInsertarDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarDerActionPerformed(evt);
            }
        });

        btnRaiz.setBackground(new java.awt.Color(77, 119, 181));
        btnRaiz.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnRaiz.setForeground(new java.awt.Color(255, 255, 255));
        btnRaiz.setText("Raiz Padre");
        btnRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaizActionPerformed(evt);
            }
        });

        lblReferencia.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        lblReferencia.setText("Referencia");

        txtReferencia.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N

        btnLimpiar.setBackground(new java.awt.Color(77, 119, 181));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(77, 119, 181));
        btnBuscar.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInorden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPreorden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPostorden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jbtnNiveles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jbtnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblReferencia)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValor)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRaiz)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertarDer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertarIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRaiz)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarDer)
                    .addComponent(btnInsertarIzq)
                    .addComponent(lblReferencia)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInorden)
                        .addGap(16, 16, 16)
                        .addComponent(btnPreorden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPostorden)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnNiveles)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalir)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
        setVisible(true);
    }// </editor-fold>                        

    private void btnInsertarIzqActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            int valor = Integer.parseInt(txtValor.getText());
            int referencia = Integer.parseInt(txtReferencia.getText());

            if (raiz == null) {
                raiz = new Nodo(valor); // Establecer la raíz si está vacía
                txtArea.append("Raíz establecida: " + valor + "\n");
            } else {
                // Intentar insertar a la izquierda
                boolean inserted = insertarIzquierda(raiz, valor, referencia);
                if (!inserted) {
                    JOptionPane.showMessageDialog(this, "Referencia no encontrada: " + referencia, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            txtValor.setText("");
            txtReferencia.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    private void btnInordenActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        recorridoInorden(raiz, sb);
        txtArea.append("Recorrido Inorden (Izquierda - Raíz - Derecha): " + sb.toString() + "\n");
    }                                          

    private void btnPreordenActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        recorridoPreorden(raiz, sb);
        txtArea.append("Recorrido Preorden(Raíz - Izquierda - Derecha): " + sb.toString() + "\n");

    }                                           

    private void btnPostordenActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        recorridoPostorden(raiz, sb);
        txtArea.append("Recorrido Postorden (Izquierda - Derecha - Raíz): " + sb.toString() + "\n");
    }                                            

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        //Inicio.Menu menu = new Menu();
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);

        this.setVisible(false);
        
    }                                         

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jbtnNivelesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        txtArea.append("Recorrido BFS (Niveles): " + bfs(raiz) + "\n");

    }                                           

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFrame ventanaArbol = new JFrame("Visualización del Árbol Binario");
        ventanaArbol.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaArbol.add(new PanelArbol(raiz));
        ventanaArbol.pack();
        ventanaArbol.setLocationRelativeTo(this);
        ventanaArbol.setVisible(true);
    }                                             


    private void btnVisualizarStateChanged(javax.swing.event.ChangeEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnRaizActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        try {
            int valor = Integer.parseInt(txtValor.getText());
            if (raiz == null) {
                raiz = new Nodo(valor); // Establecer la raíz
                txtArea.append("Raíz establecida: " + valor + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "La raíz ya está establecida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            txtValor.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                       

    private void btnInsertarDerActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        try {
            int valor = Integer.parseInt(txtValor.getText());
            int referencia = Integer.parseInt(txtReferencia.getText());

            if (raiz == null) {
                raiz = new Nodo(valor); // Establecer la raíz si está vacía
                txtArea.append("Raíz establecida: " + valor + "\n");
            } else {
                // Intentar insertar a la derecha
                boolean inserted = insertarDerecha(raiz, valor, referencia);
                if (!inserted) {
                    JOptionPane.showMessageDialog(this, "Referencia no encontrada: " + referencia, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            txtValor.setText("");
            txtReferencia.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        // Limpiar el área de texto
        txtArea.setText("");
        // Limpiar los campos de entrada
        txtValor.setText("");
        txtReferencia.setText("");
        raiz = null; // Esto asegura que el árbol se considere vacío
    }                                          

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try {
        int valorABuscar = Integer.parseInt(txtValor.getText());
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean encontrado = buscar(raiz, valorABuscar);
        if (encontrado) {
            JOptionPane.showMessageDialog(this, "Valor " + valorABuscar + " encontrado en el árbol.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Valor " + valorABuscar + " no encontrado en el árbol.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        txtValor.setText(""); // Limpiar el campo de texto
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }                                         

    // Clase Nodo
     private static class Nodo {

        int dato;
        Nodo izquierda, derecha;

        public Nodo(int dato) {
            this.dato = dato;
            this.izquierda = null;
            this.derecha = null;
        }
    }
    // Árbol Binario
    Nodo raiz = null;

// Método para insertar
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }
        if (dato < nodo.dato) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, dato);
        } else if (dato > nodo.dato) {
            nodo.derecha = insertarRecursivo(nodo.derecha, dato);
        }
        return nodo;
        // Agrega esto junto a tus otros botones

    }

    // Recorrido Inorden (IRD)
    // Recorrido Inorden  Izquierda - Raíz - Derecha
    private void recorridoInorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            // Primero, recorrer el subárbol izquierdo
            recorridoInorden(nodo.izquierda, sb);
            // Luego, visitar el nodo actual (raíz)
            sb.append(nodo.dato).append(" ");
            // Finalmente, recorrer el subárbol derecho
            recorridoInorden(nodo.derecha, sb);
        }
    }
    // Recorrido Preorden  Raíz - Izquierda - Derecha

    private void recorridoPreorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            // Primero, visitar el nodo actual (raíz)
            sb.append(nodo.dato).append(" ");
            // Luego, recorrer el subárbol izquierdo
            recorridoPreorden(nodo.izquierda, sb);
            // Finalmente, recorrer el subárbol derecho
            recorridoPreorden(nodo.derecha, sb);
        }
    }
    // Recorrido Postorden  Izquierda - Derecha - Raíz

    private void recorridoPostorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            // Primero, recorrer el subárbol izquierdo
            recorridoPostorden(nodo.izquierda, sb);
            // Luego, recorrer el subárbol derecho
            recorridoPostorden(nodo.derecha, sb);
            // Finalmente, visitar el nodo actual (raíz)
            sb.append(nodo.dato).append(" ");
        }
    }

    private String bfs(Nodo nodo) {
        if (nodo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(nodo);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            sb.append(actual.dato).append(" ");
            if (actual.izquierda != null) {
                cola.add(actual.izquierda);
            }
            if (actual.derecha != null) {
                cola.add(actual.derecha);
            }
        }
        return sb.toString();
    }

    // Método para visualizar el árbol
    public String imprimirArbol() {
        StringBuilder sb = new StringBuilder();
        imprimirArbol(raiz, 0, sb);
        return sb.toString();
    }

    private void imprimirArbol(Nodo nodo, int nivel, StringBuilder sb) {
        if (nodo != null) {
            imprimirArbol(nodo.derecha, nivel + 1, sb);
            sb.append("    ".repeat(Math.max(0, nivel)));
            sb.append(nodo.dato).append("\n");
            imprimirArbol(nodo.izquierda, nivel + 1, sb);
        }
    }

    private boolean insertarIzquierda(Nodo nodo, int valor, int referencia) {
        if (nodo == null) {
            return false; // Si el nodo es nulo, no se puede insertar
        }

        if (nodo.dato == referencia) {
            // Si encontramos la referencia, insertamos a la izquierda
            if (nodo.izquierda == null) {
                nodo.izquierda = new Nodo(valor);
                return true; // Inserción exitosa
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un nodo a la izquierda de " + referencia, "Error", JOptionPane.ERROR_MESSAGE);
                return false; // No se puede insertar porque ya existe un nodo a la izquierda
            }
        } else {
            // Recursivamente buscar en el subárbol izquierdo y derecho
            boolean inserted = insertarIzquierda(nodo.izquierda, valor, referencia);
            if (!inserted) {
                inserted = insertarIzquierda(nodo.derecha, valor, referencia);
            }
            return inserted; // Retornar si se insertó en algún lugar
        }
    }

    private boolean buscar(Nodo nodo, int valor) {
        if (nodo == null) {
            return false; // Si el nodo es nulo, el valor no se encuentra
        }
        if (nodo.dato == valor) {
            return true; // Valor encontrado
        }
        // Buscar en el subárbol izquierdo y derecho
        return buscar(nodo.izquierda, valor) || buscar(nodo.derecha, valor);
    }

    private boolean insertarDerecha(Nodo nodo, int valor, int referencia) {
        if (nodo == null) {
            return false; // Si el nodo es nulo, no se puede insertar
        }

        if (nodo.dato == referencia) {
            // Si encontramos la referencia, insertamos a la derecha
            if (nodo.derecha == null) {
                nodo.derecha = new Nodo(valor);
                return true; // Inserción exitosa
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un nodo a la derecha de " + referencia, "Error", JOptionPane.ERROR_MESSAGE);
                return false; // No se puede insertar porque ya existe un nodo a la derecha
            }
        } else {
            // Recursivamente buscar en el subárbol izquierdo y derecho
            boolean inserted = insertarDerecha(nodo.izquierda, valor, referencia);
            if (!inserted) {
                inserted = insertarDerecha(nodo.derecha, valor, referencia);
            }
            return inserted; // Retornar si se insertó en algún lugar
        }
    }

    class PanelArbol extends JPanel {

        private final Nodo raiz;
        private final int radio = 20; // Tamaño de los nodos
        private final int espacioVertical = 60; // Distancia entre niveles

        public PanelArbol(Nodo raiz) {
            this.raiz = raiz;
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(800, 600)); // Tamaño del panel
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Arial", Font.BOLD, 14));

            if (raiz != null) {
                dibujarNodo(g2d, raiz, getWidth() / 2, 30, getWidth() / 4);
            }
        }

        private void dibujarNodo(Graphics2D g2d, Nodo nodo, int x, int y, int espacioHorizontal) {
            // Dibuja el nodo (círculo azul)
            g2d.setColor(new Color(70, 130, 180)); // Color acero
            g2d.fill(new Ellipse2D.Double(x - radio, y - radio, radio * 2, radio * 2));

            // Texto del nodo (blanco)
            g2d.setColor(Color.WHITE);
            String texto = String.valueOf(nodo.dato);
            int anchoTexto = g2d.getFontMetrics().stringWidth(texto);
            g2d.drawString(texto, x - anchoTexto / 2, y + 5);

            // Conexiones con hijos
            g2d.setColor(Color.DARK_GRAY);
            if (nodo.izquierda != null) {
                int xIzq = x - espacioHorizontal;
                int yIzq = y + espacioVertical;
                g2d.drawLine(x, y + radio, xIzq, yIzq - radio);
                dibujarNodo(g2d, nodo.izquierda, xIzq, yIzq, espacioHorizontal / 2);
            }

            if (nodo.derecha != null) {
                int xDer = x + espacioHorizontal;
                int yDer = y + espacioVertical;
                g2d.drawLine(x, y + radio, xDer, yDer - radio);
                dibujarNodo(g2d, nodo.derecha, xDer, yDer, espacioHorizontal / 2);
            }
        }
    }

    
    
    private void mostrarVisualizacionArbol() {
        JFrame ventanaGrafica = new JFrame("Árbol Binario Visual");
        ventanaGrafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaGrafica.add(new PanelArbol(raiz));
        ventanaGrafica.pack();
        ventanaGrafica.setLocationRelativeTo(this); // Centrar respecto a la ventana principal
        ventanaGrafica.setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInorden;
    private javax.swing.JButton btnInsertarDer;
    private javax.swing.JButton btnInsertarIzq;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPostorden;
    private javax.swing.JButton btnPreorden;
    private javax.swing.JButton btnRaiz;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnNiveles;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtValor;
    // End of variables declaration                   

}