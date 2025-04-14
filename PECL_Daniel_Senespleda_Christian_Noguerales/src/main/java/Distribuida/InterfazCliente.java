package Distribuida;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author christian
 */
public class InterfazCliente extends javax.swing.JFrame {

    private final Cliente cliente;

    private boolean botonCerrarPista1Madrid, botonCerrarPista2Madrid, botonCerrarPista3Madrid, botonCerrarPista4Madrid,
            botonCerrarPista1Barcelona, botonCerrarPista2Barcelona, botonCerrarPista3Barcelona, botonCerrarPista4Barcelona = false;

    private boolean botonLiberarPista1Madrid, botonLiberarPista2Madrid, botonLiberarPista3Madrid, botonLiberarPista4Madrid,
            botonLiberarPista1Barcelona, botonLiberarPista2Barcelona, botonLiberarPista3Barcelona, botonLiberarPista4Barcelona = false;
        
    public InterfazCliente() throws IOException {
        initComponents();
        BotonAbrirPista1Madrid.setEnabled(false);
        BotonAbrirPista2Madrid.setEnabled(false);
        BotonAbrirPista3Madrid.setEnabled(false);
        BotonAbrirPista4Madrid.setEnabled(false);
        BotonAbrirPista1Barcelona.setEnabled(false);
        BotonAbrirPista2Barcelona.setEnabled(false);
        BotonAbrirPista3Barcelona.setEnabled(false);
        BotonAbrirPista4Barcelona.setEnabled(false);

        cliente = new Cliente(this);
        Thread t = new Thread(cliente);
        t.start();
    }

    public void actualizar(int numPasajerosMadrid, int numPasajerosBarcelona, int numAvionesHangarMadrid, int numAvionesHangarBarcelona, int numAvionesTallerMadrid, int numAvionesTallerBarcelona, int numAvionesAreaEstacionamientoMadrid,
            int numAvionesAreaEstacionamientoBarcelona, int numAvionesAreaRodajeMadrid, int numAvionesAreaRodajeBarcelona, List<String> aeroviaMadrid, List<String> aeroviaBarcelona) {

        TxtPasajerosMadrid.setText(Integer.toString(numPasajerosMadrid));
        TxtPasajerosBarcelona.setText(Integer.toString(numPasajerosBarcelona));

        TxtAvionesHangarMadrid.setText(Integer.toString(numAvionesHangarMadrid));
        TxtAvionesHangarBarcelona.setText(Integer.toString(numAvionesHangarBarcelona));

        TxtAvionesTallarMadrid.setText(Integer.toString(numAvionesTallerMadrid));
        TxtAvionesTallarBarcelona.setText(Integer.toString(numAvionesTallerBarcelona));

        TxtAvionesAreaEstacionamientoMadrid.setText(Integer.toString(numAvionesAreaEstacionamientoMadrid));
        TxtAvionesAreaEstacionamientoBarcelona.setText(Integer.toString(numAvionesAreaEstacionamientoBarcelona));

        TxtAvionesAreaRodajeMadrid.setText(String.format("%s", numAvionesAreaRodajeMadrid));
        TxtAvionesAreaRodajeBarcelona.setText(String.format("%s", numAvionesAreaRodajeBarcelona));

        TxtAeroviaMadrid.setText(String.join(", ", aeroviaMadrid));
        TxtAeroviaBarcelona.setText(String.join(", ", aeroviaBarcelona));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        BotonCerrarPista1Barcelona = new javax.swing.JButton();
        BotonCerrarPista2Barcelona = new javax.swing.JButton();
        BotonCerrarPista3Barcelona = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BotonCerrarPista4Barcelona = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BotonCerrarPista1Madrid = new javax.swing.JButton();
        BotonCerrarPista2Madrid = new javax.swing.JButton();
        BotonCerrarPista3Madrid = new javax.swing.JButton();
        BotonCerrarPista4Madrid = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TxtAeroviaMadrid = new javax.swing.JTextField();
        TxtAeroviaBarcelona = new javax.swing.JTextField();
        BotonAbrirPista1Madrid = new javax.swing.JButton();
        BotonAbrirPista2Madrid = new javax.swing.JButton();
        BotonAbrirPista3Madrid = new javax.swing.JButton();
        BotonAbrirPista4Madrid = new javax.swing.JButton();
        TxtPasajerosMadrid = new javax.swing.JTextField();
        TxtAvionesTallarMadrid = new javax.swing.JTextField();
        TxtAvionesAreaEstacionamientoMadrid = new javax.swing.JTextField();
        TxtAvionesAreaRodajeMadrid = new javax.swing.JTextField();
        TxtAvionesHangarMadrid = new javax.swing.JTextField();
        BotonAbrirPista1Barcelona = new javax.swing.JButton();
        BotonAbrirPista2Barcelona = new javax.swing.JButton();
        BotonAbrirPista3Barcelona = new javax.swing.JButton();
        BotonAbrirPista4Barcelona = new javax.swing.JButton();
        TxtPasajerosBarcelona = new javax.swing.JTextField();
        TxtAvionesTallarBarcelona = new javax.swing.JTextField();
        TxtAvionesAreaEstacionamientoBarcelona = new javax.swing.JTextField();
        TxtAvionesAreaRodajeBarcelona = new javax.swing.JTextField();
        TxtAvionesHangarBarcelona = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel18.setText("Pista 4");

        BotonCerrarPista1Barcelona.setText("Cerrar");
        BotonCerrarPista1Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista1BarcelonaActionPerformed(evt);
            }
        });

        BotonCerrarPista2Barcelona.setText("Cerrar");
        BotonCerrarPista2Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista2BarcelonaActionPerformed(evt);
            }
        });

        BotonCerrarPista3Barcelona.setText("Cerrar");
        BotonCerrarPista3Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista3BarcelonaActionPerformed(evt);
            }
        });

        jLabel2.setText("Aeropuerto Barcelona");

        BotonCerrarPista4Barcelona.setText("Cerrar");
        BotonCerrarPista4Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista4BarcelonaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nº de Pasajeros en Aeropuerto:");

        jLabel19.setText("Nº de Pasajeros en Aeropuerto:");

        jLabel4.setText("Nº Aviones en Hangar:");

        jLabel20.setText("Nº Aviones en Hangar:");

        jLabel5.setText("Nº Aviones en Taller:");

        jLabel21.setText("Nº Aviones en Taller:");

        jLabel6.setText("Nº Aviones en Área Estacionamiento:");

        jLabel22.setText("Nº Aviones en Área Estacionamiento:");

        jLabel7.setText("Nº Aviones en Área Rodaje:");

        jLabel8.setText("Pista 3");

        jLabel9.setText("Pista 2");

        jLabel10.setText("Pista 1");

        jLabel11.setText("Pista 4");

        BotonCerrarPista1Madrid.setText("Cerrar");
        BotonCerrarPista1Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista1MadridActionPerformed(evt);
            }
        });

        BotonCerrarPista2Madrid.setText("Cerrar");
        BotonCerrarPista2Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista2MadridActionPerformed(evt);
            }
        });

        BotonCerrarPista3Madrid.setText("Cerrar");
        BotonCerrarPista3Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista3MadridActionPerformed(evt);
            }
        });

        BotonCerrarPista4Madrid.setText("Cerrar");
        BotonCerrarPista4Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarPista4MadridActionPerformed(evt);
            }
        });

        jLabel12.setText("Aerovía Madrid-Barcelona");

        jLabel13.setText("Aerovía Barcelona-Madrid");

        BotonAbrirPista1Madrid.setText("Abrir");
        BotonAbrirPista1Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista1MadridActionPerformed(evt);
            }
        });

        BotonAbrirPista2Madrid.setText("Abrir");
        BotonAbrirPista2Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista2MadridActionPerformed(evt);
            }
        });

        BotonAbrirPista3Madrid.setText("Abrir");
        BotonAbrirPista3Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista3MadridActionPerformed(evt);
            }
        });

        BotonAbrirPista4Madrid.setText("Abrir");
        BotonAbrirPista4Madrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista4MadridActionPerformed(evt);
            }
        });

        BotonAbrirPista1Barcelona.setText("Abrir");
        BotonAbrirPista1Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista1BarcelonaActionPerformed(evt);
            }
        });

        BotonAbrirPista2Barcelona.setText("Abrir");
        BotonAbrirPista2Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista2BarcelonaActionPerformed(evt);
            }
        });

        BotonAbrirPista3Barcelona.setText("Abrir");
        BotonAbrirPista3Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista3BarcelonaActionPerformed(evt);
            }
        });

        BotonAbrirPista4Barcelona.setText("Abrir");
        BotonAbrirPista4Barcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirPista4BarcelonaActionPerformed(evt);
            }
        });

        jLabel14.setText("Nº Aviones en Área Rodaje:");

        jLabel15.setText("Pista 3");

        jLabel16.setText("Pista 2");

        jLabel17.setText("Pista 1");

        jLabel1.setText("Aeropuerto Madrid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtPasajerosMadrid))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesHangarMadrid))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesTallarMadrid))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesAreaEstacionamientoMadrid))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesAreaRodajeMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotonCerrarPista1Madrid, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotonCerrarPista2Madrid, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BotonAbrirPista1Madrid, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonAbrirPista2Madrid, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonCerrarPista3Madrid)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonAbrirPista3Madrid))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonCerrarPista4Madrid)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonAbrirPista4Madrid)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtPasajerosBarcelona))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesHangarBarcelona))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesTallarBarcelona))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesAreaEstacionamientoBarcelona))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtAvionesAreaRodajeBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotonCerrarPista1Barcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BotonCerrarPista2Barcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BotonAbrirPista1Barcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonAbrirPista2Barcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonCerrarPista3Barcelona)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonAbrirPista3Barcelona))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonCerrarPista4Barcelona)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonAbrirPista4Barcelona))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtAeroviaMadrid, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                            .addComponent(TxtAeroviaBarcelona))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtPasajerosMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtAvionesHangarMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtAvionesTallarMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtAvionesAreaEstacionamientoMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtAvionesAreaRodajeMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonCerrarPista3Madrid)
                                .addComponent(BotonAbrirPista3Madrid))
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonAbrirPista1Madrid)
                                .addComponent(BotonCerrarPista1Madrid)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonCerrarPista2Madrid)
                                .addComponent(BotonAbrirPista2Madrid)
                                .addComponent(jLabel11)
                                .addComponent(BotonCerrarPista4Madrid)
                                .addComponent(BotonAbrirPista4Madrid))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(TxtPasajerosBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(TxtAvionesHangarBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(TxtAvionesTallarBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(TxtAvionesAreaEstacionamientoBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TxtAvionesAreaRodajeBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonCerrarPista3Barcelona)
                                .addComponent(BotonAbrirPista3Barcelona))
                            .addComponent(jLabel15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonAbrirPista1Barcelona)
                                .addComponent(BotonCerrarPista1Barcelona)
                                .addComponent(jLabel17)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonCerrarPista2Barcelona)
                                .addComponent(BotonAbrirPista2Barcelona)
                                .addComponent(jLabel18)
                                .addComponent(BotonCerrarPista4Barcelona)
                                .addComponent(BotonAbrirPista4Barcelona)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(TxtAeroviaMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtAeroviaBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCerrarPista1MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista1MadridActionPerformed
        botonCerrarPista1Madrid = true;
        botonLiberarPista1Madrid = false;
        BotonAbrirPista1Madrid.setEnabled(true);
        BotonCerrarPista1Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista1MadridActionPerformed

    private void BotonCerrarPista2MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista2MadridActionPerformed
        botonCerrarPista2Madrid = true;
        botonLiberarPista2Madrid = false;
        BotonAbrirPista2Madrid.setEnabled(true);
        BotonCerrarPista2Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista2MadridActionPerformed

    private void BotonCerrarPista3MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista3MadridActionPerformed
        botonCerrarPista3Madrid = true;
        botonLiberarPista3Madrid = false;
        BotonAbrirPista3Madrid.setEnabled(true);
        BotonCerrarPista3Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista3MadridActionPerformed

    private void BotonCerrarPista4MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista4MadridActionPerformed
        botonCerrarPista4Madrid = true;
        botonLiberarPista4Madrid = false;
        BotonAbrirPista4Madrid.setEnabled(true);
        BotonCerrarPista4Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista4MadridActionPerformed

    private void BotonCerrarPista1BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista1BarcelonaActionPerformed
        botonCerrarPista1Barcelona = true;
        botonLiberarPista1Barcelona = false;
        BotonAbrirPista1Barcelona.setEnabled(true);
        BotonCerrarPista1Barcelona.setEnabled(false);

    }//GEN-LAST:event_BotonCerrarPista1BarcelonaActionPerformed

    private void BotonCerrarPista2BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista2BarcelonaActionPerformed
        botonCerrarPista2Barcelona = true;
        botonLiberarPista2Barcelona = false;        
        BotonAbrirPista2Barcelona.setEnabled(true);
        BotonCerrarPista2Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista2BarcelonaActionPerformed

    private void BotonCerrarPista3BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista3BarcelonaActionPerformed
        botonCerrarPista3Barcelona = true;
        botonLiberarPista3Barcelona = false;
        BotonAbrirPista3Barcelona.setEnabled(true);
        BotonCerrarPista3Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista3BarcelonaActionPerformed

    private void BotonCerrarPista4BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarPista4BarcelonaActionPerformed
        botonCerrarPista4Barcelona = true;
        botonLiberarPista4Barcelona = false;
        BotonAbrirPista4Barcelona.setEnabled(true);
        BotonCerrarPista4Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonCerrarPista4BarcelonaActionPerformed

    private void BotonAbrirPista1MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista1MadridActionPerformed
        botonLiberarPista1Madrid = true;
        botonCerrarPista1Madrid = false;
        BotonCerrarPista1Madrid.setEnabled(true);
        BotonAbrirPista1Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista1MadridActionPerformed

    private void BotonAbrirPista2MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista2MadridActionPerformed
        botonLiberarPista2Madrid = true;
        botonCerrarPista2Madrid = false;
        BotonCerrarPista2Madrid.setEnabled(true);
        BotonAbrirPista2Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista2MadridActionPerformed

    private void BotonAbrirPista3MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista3MadridActionPerformed
        botonLiberarPista3Madrid = true;
        botonCerrarPista3Madrid = false;
        BotonCerrarPista3Madrid.setEnabled(true);
        BotonAbrirPista3Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista3MadridActionPerformed

    private void BotonAbrirPista4MadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista4MadridActionPerformed
        botonLiberarPista4Madrid = true;
        botonCerrarPista4Madrid = false;
        BotonCerrarPista4Madrid.setEnabled(true);
        BotonAbrirPista4Madrid.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista4MadridActionPerformed

    private void BotonAbrirPista1BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista1BarcelonaActionPerformed
        botonLiberarPista1Barcelona = true;
        botonCerrarPista1Barcelona = false;
        BotonCerrarPista1Barcelona.setEnabled(true);
        BotonAbrirPista1Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista1BarcelonaActionPerformed

    private void BotonAbrirPista2BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista2BarcelonaActionPerformed
        botonLiberarPista2Barcelona = true;
        botonCerrarPista2Barcelona = false;
        BotonCerrarPista2Barcelona.setEnabled(true);
        BotonAbrirPista2Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista2BarcelonaActionPerformed

    private void BotonAbrirPista3BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista3BarcelonaActionPerformed
        botonLiberarPista3Barcelona = true;
        botonCerrarPista3Barcelona = false;
        BotonCerrarPista3Barcelona.setEnabled(true);
        BotonAbrirPista3Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista3BarcelonaActionPerformed

    private void BotonAbrirPista4BarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirPista4BarcelonaActionPerformed
        botonLiberarPista4Barcelona = true;
        botonCerrarPista4Barcelona = false;
        BotonCerrarPista4Barcelona.setEnabled(true);
        BotonAbrirPista4Barcelona.setEnabled(false);
    }//GEN-LAST:event_BotonAbrirPista4BarcelonaActionPerformed

    public boolean isBotonCerrarPista1Madrid() {
        return botonCerrarPista1Madrid;
    }

    public void setBotonCerrarPista1Madrid(boolean botonCerrarPista1Madrid) {
        this.botonCerrarPista1Madrid = botonCerrarPista1Madrid;
    }

    public boolean isBotonCerrarPista2Madrid() {
        return botonCerrarPista2Madrid;
    }

    public void setBotonCerrarPista2Madrid(boolean botonCerrarPista2Madrid) {
        this.botonCerrarPista2Madrid = botonCerrarPista2Madrid;
    }

    public boolean isBotonCerrarPista3Madrid() {
        return botonCerrarPista3Madrid;
    }

    public void setBotonCerrarPista3Madrid(boolean botonCerrarPista3Madrid) {
        this.botonCerrarPista3Madrid = botonCerrarPista3Madrid;
    }

    public boolean isBotonCerrarPista4Madrid() {
        return botonCerrarPista4Madrid;
    }

    public void setBotonCerrarPista4Madrid(boolean botonCerrarPista4Madrid) {
        this.botonCerrarPista4Madrid = botonCerrarPista4Madrid;
    }

    public boolean isBotonCerrarPista1Barcelona() {
        return botonCerrarPista1Barcelona;
    }

    public void setBotonCerrarPista1Barcelona(boolean botonCerrarPista1Barcelona) {
        this.botonCerrarPista1Barcelona = botonCerrarPista1Barcelona;
    }

    public boolean isBotonCerrarPista2Barcelona() {
        return botonCerrarPista2Barcelona;
    }

    public void setBotonCerrarPista2Barcelona(boolean botonCerrarPista2Barcelona) {
        this.botonCerrarPista2Barcelona = botonCerrarPista2Barcelona;
    }

    public boolean isBotonCerrarPista3Barcelona() {
        return botonCerrarPista3Barcelona;
    }

    public void setBotonCerrarPista3Barcelona(boolean botonCerrarPista3Barcelona) {
        this.botonCerrarPista3Barcelona = botonCerrarPista3Barcelona;
    }

    public boolean isBotonCerrarPista4Barcelona() {
        return botonCerrarPista4Barcelona;
    }

    public void setBotonCerrarPista4Barcelona(boolean botonCerrarPista4Barcelona) {
        this.botonCerrarPista4Barcelona = botonCerrarPista4Barcelona;
    }

    public boolean isBotonLiberarPista1Madrid() {
        return botonLiberarPista1Madrid;
    }

    public void setBotonLiberarPista1Madrid(boolean botonLiberarPista1Madrid) {
        this.botonLiberarPista1Madrid = botonLiberarPista1Madrid;
    }

    public boolean isBotonLiberarPista2Madrid() {
        return botonLiberarPista2Madrid;
    }

    public void setBotonLiberarPista2Madrid(boolean botonLiberarPista2Madrid) {
        this.botonLiberarPista2Madrid = botonLiberarPista2Madrid;
    }

    public boolean isBotonLiberarPista3Madrid() {
        return botonLiberarPista3Madrid;
    }

    public void setBotonLiberarPista3Madrid(boolean botonLiberarPista3Madrid) {
        this.botonLiberarPista3Madrid = botonLiberarPista3Madrid;
    }

    public boolean isBotonLiberarPista4Madrid() {
        return botonLiberarPista4Madrid;
    }

    public void setBotonLiberarPista4Madrid(boolean botonLiberarPista4Madrid) {
        this.botonLiberarPista4Madrid = botonLiberarPista4Madrid;
    }

    public boolean isBotonLiberarPista1Barcelona() {
        return botonLiberarPista1Barcelona;
    }

    public void setBotonLiberarPista1Barcelona(boolean botonLiberarPista1Barcelona) {
        this.botonLiberarPista1Barcelona = botonLiberarPista1Barcelona;
    }

    public boolean isBotonLiberarPista2Barcelona() {
        return botonLiberarPista2Barcelona;
    }

    public void setBotonLiberarPista2Barcelona(boolean botonLiberarPista2Barcelona) {
        this.botonLiberarPista2Barcelona = botonLiberarPista2Barcelona;
    }

    public boolean isBotonLiberarPista3Barcelona() {
        return botonLiberarPista3Barcelona;
    }

    public void setBotonLiberarPista3Barcelona(boolean botonLiberarPista3Barcelona) {
        this.botonLiberarPista3Barcelona = botonLiberarPista3Barcelona;
    }

    public boolean isBotonLiberarPista4Barcelona() {
        return botonLiberarPista4Barcelona;
    }

    public void setBotonLiberarPista4Barcelona(boolean botonLiberarPista4Barcelona) {
        this.botonLiberarPista4Barcelona = botonLiberarPista4Barcelona;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfazCliente().setVisible(true);
                } catch (IOException ex) {
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAbrirPista1Barcelona;
    private javax.swing.JButton BotonAbrirPista1Madrid;
    private javax.swing.JButton BotonAbrirPista2Barcelona;
    private javax.swing.JButton BotonAbrirPista2Madrid;
    private javax.swing.JButton BotonAbrirPista3Barcelona;
    private javax.swing.JButton BotonAbrirPista3Madrid;
    private javax.swing.JButton BotonAbrirPista4Barcelona;
    private javax.swing.JButton BotonAbrirPista4Madrid;
    private javax.swing.JButton BotonCerrarPista1Barcelona;
    private javax.swing.JButton BotonCerrarPista1Madrid;
    private javax.swing.JButton BotonCerrarPista2Barcelona;
    private javax.swing.JButton BotonCerrarPista2Madrid;
    private javax.swing.JButton BotonCerrarPista3Barcelona;
    private javax.swing.JButton BotonCerrarPista3Madrid;
    private javax.swing.JButton BotonCerrarPista4Barcelona;
    private javax.swing.JButton BotonCerrarPista4Madrid;
    private javax.swing.JTextField TxtAeroviaBarcelona;
    private javax.swing.JTextField TxtAeroviaMadrid;
    private javax.swing.JTextField TxtAvionesAreaEstacionamientoBarcelona;
    private javax.swing.JTextField TxtAvionesAreaEstacionamientoMadrid;
    private javax.swing.JTextField TxtAvionesAreaRodajeBarcelona;
    private javax.swing.JTextField TxtAvionesAreaRodajeMadrid;
    private javax.swing.JTextField TxtAvionesHangarBarcelona;
    private javax.swing.JTextField TxtAvionesHangarMadrid;
    private javax.swing.JTextField TxtAvionesTallarBarcelona;
    private javax.swing.JTextField TxtAvionesTallarMadrid;
    private javax.swing.JTextField TxtPasajerosBarcelona;
    private javax.swing.JTextField TxtPasajerosMadrid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
