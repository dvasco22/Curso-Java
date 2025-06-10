
import java.text.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.*;

public class ipcalc128 extends JFrame implements ActionListener, KeyListener, ItemListener /* , ValueChangeListener */ {

   private static final int BYTE = 8;
   private static final int MAX = 255;
   private static final String YES = "YES";
   private static final String POS1 = "1";
   private static final String BLANK = " ";
   private static final String NETIP = "Network IP";
   private static final String BDCIP = "BroadCast IP";
   private static final char POINT = '.';
   private static final char ZERO = '0';
   private static final char SPACE = ' ';
   private static final char ENTER = '\n';
   private static final char SLASH = '/';
   private static final char X = 850;
   private static final char Y = 400;

   private static int MAX_BASE = 85;
   private static int NBYTES = 4; // 4,8,16,32 BYTES
   private static int type = 1; // none=0, binary=1, Hexa=2
   private static int mType = 1; // w/Mask=0, w/o/Mask=1
   private static int base = 2; // Binary=2, Oct=8, Hex=16 none=0
   private static int TOP = 8; // Binary=8 Oct=3 Hex=2 none=0

   private int cdir;
   private char[] digit = new char[MAX_BASE + 1];
   private int[] subNetworkMask = new int[BYTE + 1];
   private JTextArea area;
   private JScrollPane scroll;
   private JButton calc_button;
   private JButton clear_button;
   private JTextField textIP;
   private JTextField textCDIR;

   private JRadioButton bytes_04;
   private JRadioButton bytes_08;
   private JRadioButton bytes_16;
   private JRadioButton bytes_32;
   private ButtonGroup group1;

   private JRadioButton none;
   private JRadioButton bin;
   private JRadioButton oct;
   private JRadioButton hex;
   private ButtonGroup group2;

   private JTextField textBinary;
   private JRadioButton cdirRB;
   private JRadioButton binaryRB;
   private ButtonGroup group3;

   JLabel labelIP;
   JLabel labelCDIR;

   public static void main(String[] args) {
      ipcalc128 ipc = new ipcalc128();

   }

   /***********************************************************************/

   public ipcalc128() {
      super("IP CALCULATOR");
      this.setDefaultLookAndFeelDecorated(true);
      this.defineWindow();
      this.setSize(X, Y);
      this.setLocation(250, 250);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   /***********************************************************************/

   public void defineWindow() {

      initChar();

      int c0 = 0,
            c1 = c0 + 1, c2 = c0 + 2, c3 = c0 + 3, c4 = c0 + 4, c5 = c0 + 5, c6 = c0 + 6, c7 = c0 + 7, c8 = c0 + 8,
            c9 = c0 + 9;

      int r0 = 0,
            // r1=r0+1,r2=r0+2,r3=r0+3,r4=r0+4;
            r1 = r0 + 2, r2 = r0 + 3, r3 = r0 + 4, r4 = r0 + 5;

      area = new JTextArea();

      area.setFont(new Font("Monospaced", Font.BOLD, 12));
      area.setWrapStyleWord(true);
      // area.setLineWrap(true);

      scroll = new JScrollPane(area);
      textIP = new JTextField("192.168.1.1");
      textCDIR = new JTextField("24");
      textBinary = new JTextField("255.255.255.0");

      calc_button = new JButton(" calculate ");
      clear_button = new JButton(" Clear ");

      bytes_04 = new JRadioButton("4  bytes", true);
      bytes_08 = new JRadioButton("8  bytes", false);
      bytes_16 = new JRadioButton("16 bytes", false);
      bytes_32 = new JRadioButton("32 bytes", false);
      group1 = new ButtonGroup();
      group1.add(bytes_04);
      group1.add(bytes_08);
      group1.add(bytes_16);
      group1.add(bytes_32);

      none = new JRadioButton("None", false);
      bin = new JRadioButton("Bin", true);
      oct = new JRadioButton("Oct", false);
      hex = new JRadioButton("Hex", false);
      group2 = new ButtonGroup();
      group2.add(none);
      group2.add(bin);
      group2.add(oct);
      group2.add(hex);

      cdirRB = new JRadioButton("CDIR Mask  ", true);
      binaryRB = new JRadioButton("Binary Mask", false);
      group3 = new ButtonGroup();
      group3.add(cdirRB);
      group3.add(binaryRB);

      labelIP = new JLabel("  IP Address  ", JLabel.CENTER);
      labelCDIR = new JLabel(" / ", JLabel.CENTER);

      this.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();

      gbc.gridx = 0;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(labelIP, gbc);

      gbc.gridx = c1;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(textIP, gbc);

      gbc.gridx = c2;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(labelCDIR, gbc);

      gbc.gridx = c3;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(textCDIR, gbc);

      gbc.gridx = c4;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(bytes_04, gbc);

      gbc.gridx = c5;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(bytes_08, gbc);

      gbc.gridx = c6;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.BOTH;
      this.add(bytes_16, gbc);

      gbc.gridx = c7;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(bytes_32, gbc);

      gbc.gridx = c8;
      gbc.gridy = r0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(calc_button, gbc);

      gbc.gridx = c4;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(cdirRB, gbc);

      gbc.gridx = c5;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(binaryRB, gbc);

      // gbc.gridx=c3;gbc.gridy=r1;
      gbc.gridx = c1;
      gbc.gridy = 1;
      gbc.gridwidth = 3;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(textBinary, gbc);

      gbc.gridx = c4;
      gbc.gridy = r1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.BOTH;
      this.add(none, gbc);

      gbc.gridx = c5;
      gbc.gridy = r1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(bin, gbc);

      gbc.gridx = c6;
      gbc.gridy = r1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(oct, gbc);

      gbc.gridx = c7;
      gbc.gridy = r1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(hex, gbc);

      gbc.gridx = c8;
      gbc.gridy = r1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      this.add(clear_button, gbc);

      gbc.gridx = c0;
      gbc.gridy = r2;
      gbc.gridwidth = 9;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      this.add(scroll, gbc);

      bytes_04.addItemListener(this);
      bytes_08.addItemListener(this);
      bytes_16.addItemListener(this);
      bytes_32.addItemListener(this);

      bytes_04.setEnabled(true);
      bytes_08.setEnabled(true);
      bytes_16.setEnabled(false);
      bytes_32.setEnabled(false);

      none.addItemListener(this);
      bin.addItemListener(this);
      oct.addItemListener(this);
      hex.addItemListener(this);

      textIP.addKeyListener(this);
      textCDIR.addKeyListener(this);
      calc_button.addActionListener(this);
      clear_button.addActionListener(this);

      cdirRB.addKeyListener(this);
      binaryRB.addKeyListener(this);
      textBinary.addKeyListener(this);
      this.textBinary.setEnabled(false);
   }

   /* =================================================================== */

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == calc_button)
         start();

      if (e.getSource() == clear_button)
         area.setText(null);
   }

   public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
         case KeyEvent.VK_ENTER:
            start();
            break;
      }
   }

   public void keyReleased(KeyEvent e) {
   }

   public void keyTyped(KeyEvent e) {
   }

   /*-----------------------------------------------*/

   public void itemStateChanged(ItemEvent e) {

      if (bytes_04.isSelected()) {
         NBYTES = 4;
         start();
      }

      if (bytes_08.isSelected()) {
         NBYTES = 8;
         start();
      }

      if (bytes_16.isSelected()) {
         NBYTES = 16;
         start();
      }

      if (bytes_32.isSelected()) {
         NBYTES = 32;
         start();
      }

      if (none.isSelected()) {
         base = 0;
         TOP = 0;
         start();
      }

      if (bin.isSelected()) {
         base = 2;
         TOP = 8;
         start();
      }

      if (oct.isSelected()) {
         base = 8;
         TOP = 3;
         start();
      }

      if (hex.isSelected()) {
         base = 16;
         TOP = 2;
         start();
      }

      if (cdirRB.isSelected()) {

         // cdirRB_processValueChange(e);

         // this.remove(textBinary);
         // this.add(textCDIR);
         textBinary.setEnabled(false);
         textCDIR.setEnabled(true);
         // textBinary.updateUI();
         // textCDIR.updateUI();
      }

      if (binaryRB.isSelected()) {

         // binaryRB_processValueChange(e);

         // this.remove(textCDIR);
         // this.add(textBinary);
         textBinary.setEnabled(true);
         textCDIR.setEnabled(false);
         // textBinary.updateUI();
         // textCDIR.updateUI();
      }

   }

   /*
    * 
    * public void cdirRB_processValueChange(ItemEvent event) {
    * if(cdirRB.isSelected()) {
    * this.add(textCDIR);
    * textCDIR.updateUI();
    * }
    * }
    * 
    * 
    * public void binaryRB_processValueChange(ValueChangeEvent event) {
    * if(binaryRB.isChecked()) {
    * //if(binaryRB.isSelected()) {
    * this.add(textBinary);
    * textBinary.updateUI();
    * }
    * }
    * 
    */

   /* =================================================================== */

   public void start() {

      int[] ip = new int[NBYTES + 1];
      int[] broadCastIp = new int[NBYTES + 1];
      int[] binaryIpMask = new int[NBYTES];
      int[] wildCardIpMask = new int[NBYTES];
      int[] subNetIp = new int[NBYTES + 1];

      int magicNumber, interestOctect;

      ip = stringIpToIntegerIp(textIP.getText() + " ", textCDIR.getText(), ip, 0);

      if (binaryRB.isSelected()) {
         binaryIpMask = stringIpToIntegerIp(textBinary.getText() + " ", " ", binaryIpMask, 1);

         int smio = subNetIO(binaryIpMask);
         int smioVal = binaryIpMask[smio];
         int MN = 256 - smioVal;
         int log = (int) LOG(2, MN);
         int zeros = (((NBYTES - 1) - smio) * 8) + log;
         cdir = (NBYTES * BYTE) - zeros;
         ip[NBYTES] = cdir;
      } else {
         binaryIpMask = initBinaryIpMask(binaryIpMask);
         cdir = ip[NBYTES];
      }

      subNetIp = assignIp(subNetIp, ip);
      broadCastIp = assignIp(broadCastIp, ip);
      wildCardIpMask = initBinaryIpMask(wildCardIpMask);

      if (cdir == NBYTES * BYTE)
         printTemplate(0, POS1, 1, ip, subNetIp, broadCastIp, binaryIpMask, wildCardIpMask);
      else {
         magicNumber = getMagicNumber(cdir);
         interestOctect = getInterestOctect(cdir);
         ipType(interestOctect, magicNumber, ip, subNetIp, broadCastIp, binaryIpMask, wildCardIpMask);
      }
   }

   /**************************************/
   /* Algorithm depevolep by Diego Vasco */

   public void ipType(int interestOctect, int magicNumber, int[] ip, int[] subNetIp, int[] broadCastIp,
         int[] binaryIpMask, int[] wildCardIpMask) {

      int cdir = ip[NBYTES];
      int pe = ip[interestOctect] / magicNumber;
      int hostPos = ip[interestOctect] % magicNumber;
      int zeros = ((NBYTES * 8) - cdir);
      double HOSTs = hostbyNet(zeros);
      double position = 0;
      String pos = BLANK;
      int[] sNet = new int[NBYTES + 1];
      int[] bCast = new int[NBYTES + 1];
      int[] bMask = new int[NBYTES];
      assignIp(sNet, subNetIp);
      assignIp(bCast, broadCastIp);

      if ((hostPos == 0) && (netORbcast(interestOctect, 0, ip))) { /* AND CDIRMASK!=31 */
         bCast = setBroadCastIp(broadCastIp, pe, interestOctect, magicNumber);
         pos = NETIP;
      } else if (hostPos != 0 && hostPos + 1 == magicNumber && netORbcast(interestOctect, MAX, ip)) { /*
                                                                                                       * AND
                                                                                                       * CDIRMASK!=31
                                                                                                       */
         sNet = setSubNetIp(subNetIp, pe, interestOctect, magicNumber);
         pos = BDCIP;
      } else {
         sNet = setSubNetIp(subNetIp, pe, interestOctect, magicNumber);
         bCast = setBroadCastIp(broadCastIp, pe, interestOctect, magicNumber);
         position = POS(interestOctect, magicNumber, ip);
      }

      bMask = setBinaryIpMask(interestOctect, magicNumber, binaryIpMask);
      wildCardIpMask = setWildCardIpMask(wildCardIpMask, bMask);
      printTemplate(position, pos, HOSTs, ip, sNet, bCast, bMask, wildCardIpMask);
   }

   /***********************************************************************/

   public double logOfBase(int base, int num) {
      return Math.log(num) / Math.log(base);
   }

   public double LOG(int b, int a) {
      int log = 0;
      int m = a;

      while (m >= b) {
         m = a / b;
         a = m;
         log++;
      }
      return log;
   }

   /***********************************************************************/

   public int subNetIO(int[] binaryIpMask) {
      int i = 0;
      while (binaryIpMask[i] == MAX && i < NBYTES - 1)
         i++;
      return i;
   }

   /***********************************************************************/

   public int[] stringIpToIntegerIp(String source, String CDIR, int[] ip, int flag) {

      char c;
      int i = 0, j = 0, len = source.length();
      StringBuffer dest = new StringBuffer(len);

      while ((j < NBYTES) && (i < len)) {
         do {
            c = source.charAt(i);
            if (Character.isDigit(c))
               dest.append(c);
            i++;
         } while (Character.isDigit(c));

         ip[j] = Integer.parseInt(dest.toString());
         j++;
         dest.delete(0, dest.length());
      }
      if (flag == 0)
         ip[NBYTES] = Integer.parseInt(CDIR);
      ;
      return ip;
   }

   /***********************************************************************/

   public String intToXBase(int decimal, int base) {

      // char[] digit =
      // {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

      StringBuffer str = new StringBuffer();

      for (int i = 0; i < TOP; i++) {
         if (decimal > 0) {
            str.insert(0, digit[decimal % base]);
            decimal /= base;
         } else
            str.insert(0, ZERO);
      }
      return str.toString();
   }

   /***********************************************************************/

   public String ipToBinHexa(int[] ip) {

      StringBuffer binHexa = new StringBuffer();

      if (base > 0) {
         int i;

         for (i = 0; i <= (NBYTES - 2); i++)
            binHexa.append(intToXBase(ip[i], base) + POINT);

         binHexa.append(intToXBase(ip[i], base));
      }
      return binHexa.toString();
   }

   /***********************************************************************/

   public String IntegerIpToStringIP(int[] ip, int Mtype) {

      StringBuffer str = new StringBuffer();

      int i;
      for (i = 0; i <= (NBYTES - 2); i++)
         str.append(Integer.toString(ip[i]) + POINT);

      str.append(Integer.toString(ip[i]));

      if (Mtype == 0)
         str.append(SLASH + Integer.toString(ip[i + 1]));

      return str.toString();
   }

   /***********************************************************************/

   public int getInterestOctect(int cdir) {
      return cdir / BYTE;
   }

   /***********************************************************************/

   public int getN(int zeros) {

      int div = zeros / BYTE, mod = zeros % BYTE;

      if (mod == 0)
         return div - 1;
      else
         return div;
   }

   /***********************************************************************/

   public int getMagicNumber(int cdir) {

      int zeros, magicNumber, n;

      zeros = (NBYTES * BYTE) - cdir;

      n = getN(zeros);
      magicNumber = (int) Math.pow(2, (zeros - BYTE * n));

      return magicNumber;
   }

   /***********************************************************************/

   public double POS(int interestOctect, int magicNumber, int[] ip) {

      double pos = ip[interestOctect] % magicNumber;

      for (int i = interestOctect + 1; i <= (NBYTES - 1); i++)
         pos = pos * (MAX + 1) + ip[i];

      return pos;
   }

   /***********************************************************************/

   public double hostbyNet(int zeros) {

      double nHost = (double) Math.pow(2, zeros) - 2;

      return nHost;
   }

   /***********************************************************************/

   public boolean netORbcast(int interestOctect, int nORb, int[] ip) {

      boolean netbcd = true;
      int i = interestOctect + 1;

      while ((i <= (NBYTES - 1)) && (netbcd)) {
         if (ip[i] == nORb)
            netbcd = true;
         else
            netbcd = false;
         i++;
      }
      return netbcd;
   }

   /***********************************************************************/

   public int[] initBinaryIpMask(int[] binaryIpMask) {

      for (int i = 0; i <= NBYTES - 1; i++)
         binaryIpMask[i] = MAX;
      return binaryIpMask;
   }

   /***********************************************************************/

   public int[] setLastIp(int[] lastIp) {

      lastIp[NBYTES - 1] = lastIp[NBYTES - 1] - 1;
      return lastIp;
   }

   /***********************************************************************/

   public int[] setFirstIp(int[] firstIp) {

      firstIp[NBYTES - 1] = firstIp[NBYTES - 1] + 1;
      return firstIp;
   }

   /***********************************************************************/

   public int[] setBinaryIpMask(int interestOctect, int magicNumber, int[] binaryIpMask) {

      binaryIpMask[interestOctect] = MAX + 1 - magicNumber;
      interestOctect++;

      for (int i = interestOctect; i <= (NBYTES - 1); i++)
         binaryIpMask[i] = 0;

      return binaryIpMask;
   }

   /***********************************************************************/

   public int[] setSubNetIp(int[] subNetIp, int pe, int interestOctect, int magicNumber) {

      int i = interestOctect;
      subNetIp[i] = pe * magicNumber;

      i++;
      while (i <= (NBYTES - 1)) {
         subNetIp[i] = 0;
         i++;
      }
      return subNetIp;
   }

   /***********************************************************************/

   public int[] setBroadCastIp(int[] broadCastIp, int pe, int interestOctect, int magicNumber) {

      int i = interestOctect;
      pe++;
      broadCastIp[i] = (pe * magicNumber) - 1;

      i++;
      while (i <= (NBYTES - 1)) {
         broadCastIp[i] = MAX;
         i++;
      }
      return broadCastIp;
   }

   /***********************************************************************/

   public int[] setWildCardIpMask(int[] wildCardIpMask, int[] binaryMask) {

      for (int i = 0; i <= NBYTES - 1; i++)
         wildCardIpMask[i] = wildCardIpMask[i] - binaryMask[i];

      return wildCardIpMask;
   }

   /***********************************************************************/

   public int[] assignIp(int[] ipDest, int[] ipSource) {

      for (int i = 0; i <= NBYTES; i++)
         ipDest[i] = ipSource[i];
      return ipDest;
   }

   /***********************************************************************/

   public void printTemplate(double position, String pos, double HOSTs, int[] ip, int[] sNet, int[] bCast, int[] bMask,
         int[] wMask) {

      DecimalFormat df = new DecimalFormat(
            "###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");

      int[] firstIp = new int[NBYTES + 1];
      int[] lastIp = new int[NBYTES + 1];

      double THOSTs;

      assignIp(firstIp, sNet);
      assignIp(lastIp, bCast);

      if (sNet[NBYTES] <= (NBYTES * BYTE) - 2) {
         firstIp = setFirstIp(firstIp);
         lastIp = setLastIp(lastIp);
      }

      textIP.setText(IntegerIpToStringIP(ip, 1));

      if (HOSTs == 1)
         THOSTs = 1;
      else
         THOSTs = HOSTs + 2;

      area.append("\n\n");
      String fs1;
      fs1 = String.format("  IP Address             :: %-35s %s %n", IntegerIpToStringIP(ip, 0), ipToBinHexa(ip));
      area.append(fs1);
      String fs2;
      fs2 = String.format("  Network Ip address     :: %-35s %s %n", IntegerIpToStringIP(sNet, 0), ipToBinHexa(sNet));
      area.append(fs2);
      String fs3;
      fs3 = String.format("  Broadcast Ip address   :: %-35s %s %n", IntegerIpToStringIP(bCast, 0), ipToBinHexa(bCast));
      area.append(fs3);
      String fs4;
      fs4 = String.format("  Subnet Mask            :: %-35s %s %n", IntegerIpToStringIP(bMask, 1), ipToBinHexa(bMask));
      area.append(fs4);

      textCDIR.setText(Integer.toString(cdir));
      textBinary.setText(IntegerIpToStringIP(bMask, 1));

      area.append("\n");
      String fs5;
      fs5 = String.format("  Wilcard Mask           :: %-35s %s %n", IntegerIpToStringIP(wMask, 1), ipToBinHexa(wMask));
      area.append(fs5);
      area.append("\n");
      String fs6;
      fs6 = String.format("  Host Min address       :: %-35s %s %n", IntegerIpToStringIP(firstIp, 0),
            ipToBinHexa(firstIp));
      area.append(fs6);
      String fs7;
      fs7 = String.format("  Host Max address       :: %-35s %s %n", IntegerIpToStringIP(lastIp, 0),
            ipToBinHexa(lastIp));
      area.append(fs7);
      area.append("\n");
      area.append("  Total  Ip's            :: ");
      area.append(df.format(THOSTs));
      area.append("\n");
      area.append("  Usable Ip's            :: ");
      area.append(df.format(HOSTs));
      area.append("\n");

      if (position != 0) {
         area.append("  Host Position          :: ");
         area.append(df.format(position));
      } else {
         String fs8;
         fs8 = String.format("  Host Position          :: %s", pos);
         area.append(fs8);
      }
      area.append("\n\n\n");

   }

   /***********************************************************************/

   public void initChar() {

      int index = 0;

      for (int i = 48; i <= 57; i++)
         digit[index++] = (char) i;

      for (int i = 65; i <= 125; i++)
         digit[index++] = (char) i;

      for (int i = 33; i <= 47; i++)
         digit[index++] = (char) i;

      int[] subNetworkMask = { 255, 254, 252, 248, 240, 224, 192, 128, 0 };

   }

   /***********************************************************************/

   public void pause(int flag) {

      char c = ' ';
      try {
         c = (char) System.in.read();
      } catch (IOException ex) {
      }

      System.out.printf("   %d%n", flag);
   }

   public void pause(boolean flag) {

      char c = ' ';
      try {
         c = (char) System.in.read();
      } catch (IOException ex) {
      }

      System.out.printf("   %b%n", flag);
   }

   public void pause(String flag) {

      char c = ' ';
      try {
         c = (char) System.in.read();
      } catch (IOException ex) {
      }

      System.out.printf("   %s%n", flag);
   }

   public void pause(char flag) {

      char c = ' ';
      try {
         c = (char) System.in.read();
      } catch (IOException ex) {
      }

      System.out.printf("   %s%n", flag);
   }

   public void pause(int[] ip, int flag) {
      int top = NBYTES - flag;

      char c = ' ';
      try {
         c = (char) System.in.read();
      } catch (IOException ex) {
      }

      for (int i = 0; i <= top; i++)
         System.out.printf(" %d", ip[i]);
      System.out.printf("%n");
   }

   public void pause(StringBuffer flag) {
      char c = ' ';
      try {
         c = (char) System.in.read();
      } catch (IOException ex) {
      }

      System.out.printf("   %s%n", flag);
   }

   /***********************************************************************/

}

/*
 * 
 * JAVA Installation
 * =================
 * cd C:\Program Files\Java\jdk1.8.0_25\bin
 * http://webtools.live2support.com/nt_subnet.php?host=92.56.4.201
 * 
 * IPV4
 * ====
 * http://jodies.de/ipcalc
 * 
 * IPV4-IPV6
 * =========
 * Calculadora IPV6
 * http://www.gestioip.net/cgi-bin/subnet_calculator.cgi
 * 
 * 
 * main
 * ====
 * calc128.java
 * 
 * to do
 * =====
 * Table component.
 * setBorder
 * 
 */

/*
 * 
 * private void txtNombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {
 * int k=(int)evt.getKeyChar();
 * if (k > 47 && k < 58) {
 * evt.setKeyChar((char)KeyEvent.VK_CLEAR);
 * JOptionPane.showMessageDialog(null,"No puede ingresar numeros!!!"
 * ,"Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
 * }
 * if(k==10){
 * //Telca enter transfiere el foco
 * txtNombreEmpleado.transferFocus();
 * }
 * }
 * 
 * 
 * 
 * private void txtTelefonoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) { int
 * k=(int)evt.getKeyChar();
 * if (k >= 97 && k <= 122 || k>=65 && k<=90){
 * evt.setKeyChar((char)KeyEvent.VK_CLEAR);
 * JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!"
 * ,"Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
 * }
 * if(k==241 || k==209){
 * evt.setKeyChar((char)KeyEvent.VK_CLEAR);
 * JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!"
 * ,"Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
 * }
 * if(k==10){
 * txtTelefonoEmpleado.transferFocus();
 * }
 * }
 * 
 * Hola, esto lo puedes hacer facilmente con una clase llamada Document.
 * 
 * Si te fijas en tu JTextField tienes un metodo llamado setDocument(), si mal
 * no recuerdo la clase document se encuentra en el paquete javax.swing.text
 * 
 * Lo que tienes que hacer es crear una clase extendida de la clase
 * PlainDocument y sobre escribir el metodo abstracto insertString que se
 * ejecuta cada vez que se teclea un caracter sobre el JTextField. Alli en el
 * metodo insertString puedes vaildar el caracter y funciona en tiempo real.
 * 
 * Una vez creada e instanciada tu clase Document solo tienes que decirle al
 * JTextField cual va ser el documento valido que mostrara.
 * 
 * Lastima no puedo postear el codigo fuente, ya que me encuentro conectado
 * desde el telefono celular, pero estoy seguro que si googleas un poco vas a
 * conseguir el codigo al cual hago referencia.
 * 
 * Para hacer visible el JTextField debes a�adirlo al contenedor y luego llamar
 * al m�todo updateUI().
 * 
 * En general, si un componente ya est� a�adido a un contenedor, no sirve de
 * nada hacerle setVisible(true) o setVisible(false), ya que el contenedor
 * tambi�n llamar� a estos m�todos cuando le interese. Si quieres que deje de
 * verse, haz un contenedor.remove(elComponente). Si quieres que vuelva a verse
 * contenedor.add(elComponente) y ambos casos, para obligar al repintado de la
 * ventana, llama al m�todo updateUI() del panel o del componente.
 * 
 * 
 * package com.pretech;
 * import javax.faces.context.FacesContext;
 * import javax.faces.event.AbortProcessingException;
 * import javax.faces.event.ValueChangeEvent;
 * import javax.faces.event.ValueChangeListener;
 * 
 * public class PretechChangeListener implements ValueChangeListener {
 * 
 * @Override
 * public void processValueChange(ValueChangeEvent event) throws
 * AbortProcessingException {
 * ChangeListenerBean changeListenerBean = (ChangeListenerBean)
 * FacesContext.getCurrentInstance().
 * getExternalContext().getRequestMap().get("changeListenerBean");
 * System.out.println(changeListenerBean);
 * changeListenerBean.setUpdatedCountry("You Selected " +event.getNewValue());
 * }
 * }
 * 
 * 
 * public void radioButton1_processValueChange(ValueChangeEvent event) {
 * if(radioButton1.isChecked()) {
 * elContenedorQueSea.add(textField1);
 * textField1.updateUI();
 * 
 * 
 */

/*
 * import java.io.Serializable;
 * import java.util.List;
 * 
 * import javax.annotation.PostConstruct;
 * import javax.faces.application.FacesMessage;
 * import javax.faces.bean.ManagedBean;
 * import javax.faces.bean.ViewScoped;
 * import javax.faces.context.FacesContext;
 * import javax.faces.event.ValueChangeEvent;
 * 
 * import org.apache.log4j.Logger;
 * 
 * import com.autentia.jsf.showcase.core.AddSampleData;
 * import com.autentia.jsf.showcase.core.HumanResourcesService;
 * import com.autentia.jsf.showcase.core.MetadataService;
 * import com.autentia.jsf.showcase.core.entities.Client;
 * import com.autentia.jsf.showcase.core.metadata.City;
 * import com.autentia.jsf.showcase.core.metadata.Country;
 * 
 * @ManagedBean
 * 
 * @ViewScoped
 * public class ClientView implements Serializable{
 * 
 * private static final long serialVersionUID = -2377612760546575078L;
 * 
 * private static final Logger log =
 * Logger.getLogger(ClientView.class.getName());
 * 
 * private Client client;
 * 
 * private Country country;
 * 
 * @PostConstruct
 * protected void init(){
 * log.debug("init...");
 * AddSampleData.initializeMetadata();
 * client = new Client("");
 * }
 * 
 * public void setClient(Client client) {
 * log.debug("setClient:" + client);
 * this.client = client;
 * }
 * 
 * public Client getClient() {
 * log.debug("getClient:" + client);
 * return client;
 * }
 * 
 * public void setCountry(Country country) {
 * log.debug("setCountry:" + country);
 * this.country = country;
 * }
 * 
 * public Country getCountry() {
 * log.debug("getCountry:" + country);
 * return country;
 * }
 * 
 * public void save(){
 * log.debug("saving client:" + client);
 * try{
 * HumanResourcesService.getInstance().addClient(client);
 * FacesContext.getCurrentInstance().addMessage("", new
 * FacesMessage("Informaci�n almacenada correctamente."));
 * }
 * catch(Exception e){
 * log.error("Exception saving the client",e);
 * FacesContext.getCurrentInstance().addMessage("", new
 * FacesMessage(e.getMessage()));
 * }
 * }
 * 
 * public List<Country> getCountries(){
 * log.debug("getCountries");
 * return MetadataService.getInstance().getAllCountries();
 * }
 * 
 * public List<City> getCities(){
 * log.debug("getCities");
 * return MetadataService.getInstance().getCityByCountry(country);
 * }
 * 
 * public void vipChangeListener(ValueChangeEvent event){
 * log.debug("vipChangeListener");
 * // do nothing
 * }
 * 
 * public void countryChangeListener(ValueChangeEvent event){
 * log.debug("countryChangeListener");
 * country = ( (Country) event.getNewValue());
 * City city = null;
 * if (!getCities().isEmpty()){
 * city = getCities().get(0);
 * }
 * client.setCity(city);
 * FacesContext.getCurrentInstance().renderResponse();
 * }
 * 
 * }
 * 
 */