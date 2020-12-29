import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author zfilippos
 */
public class CountDown extends javax.swing.JFrame {

    //My variables:
    int counter = 5;
    Boolean isIt = false;
    public static long begin;
    public static long end;

    public CountDown() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        timerName = new javax.swing.JLabel();
        timeLeft = new javax.swing.JLabel();
        btnStop = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        timerName.setText("Timer : ");

        timeLeft.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        timeLeft.setText("00:00");

        btnStop.setText("Stop");
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.setActionCommand("Start");
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStartMouseClicked(evt);
                begin = System.currentTimeMillis();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnStart)
                                                .addGap(47, 47, 47)
                                                .addComponent(btnStop))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(timerName)
                                                .addGap(18, 18, 18)
                                                .addComponent(timeLeft)))
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(timerName)
                                        .addComponent(timeLeft))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnStart)
                                        .addComponent(btnStop))
                                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnStartMouseClicked(java.awt.event.MouseEvent evt) {//event_btnStartMouseClicked
        Timer timer = new Timer(); //new timer
        counter = 5; //setting the counter to 5 sec
        TimerTask task = new TimerTask() {
            public void run() {
                timeLeft.setText(Integer.toString(counter)); //the timer lable to counter.
                counter --;
                if (counter == -1){
                    timer.cancel();
                } else if(isIt){
                    timer.cancel();
                    isIt = false;
                    System.out.printf("Won %.0f"+" points",((5000-(end-begin))*0.2));
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000); // =  timer.scheduleAtFixedRate(task, delay, period);
    }

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {//event_btnStopMouseClicked
        isIt = true;// changing the boolian isIt to true, which will stop the timer.
        end = System.currentTimeMillis();
    }


    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(CountDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountDown().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel timeLeft;
    private javax.swing.JLabel timerName;
    // End of variables declaration//GEN-END:variables
}

