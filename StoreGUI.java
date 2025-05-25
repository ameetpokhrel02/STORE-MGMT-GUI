import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
public class StoreGUI {
    // TextFields
    private JTextField storeIdAp, storeNameAp1, locationAp2, openingHourAp3, totalSalesAp4, totalDiscountAp5, productNameAp6;
    private JTextField storeIdAp1, storeNameAp2, locationAp3, openingHourAp4, totalSalesAp5, totalDiscountAp6, markedPriceAp, vatPriceAp, loyaltyPointAp,  storeNameAp9,totalDiscountAp12;
    private JTextField storeIdTf2, markedPriceTf, storeIdTf3, vatPriceTf1;
    
    // ComboBoxes
    private JCheckBox isPaymentOnlineBox;
    private JComboBox<String> isPaymentOnlineBox1;
    private JComboBox<String> purchasedYearCB;
    private JComboBox<String> isInSales1;

    // Store list and frame
    private ArrayList<Store> storeList;
    private JFrame store;

    public StoreGUI() {
        store = new JFrame("Store GUI");
        store.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        store.setLayout(new BorderLayout());
        store.setSize(800, 650);
        store.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Store Record Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("impact", Font.BOLD, 24));
        store.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        store.add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(createDepartmentPanel());
        mainPanel.add(createRetailerPanel());

        JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        store.add(bottomPanel, BorderLayout.SOUTH);

        bottomPanel.add(createDiscountPanel());
        bottomPanel.add(createLoyaltyPanel());
        bottomPanel.add(createRemoveDisplayPanel());

        // Initialize storeList
        storeList = new ArrayList<>();

        // Set colors
        store.getContentPane().setBackground(Color.GREEN);
        bottomPanel.setBackground(Color.WHITE);

        store.setVisible(true);
    }

    private JPanel createDepartmentPanel() {
        JPanel departmentPanel = new JPanel(new GridBagLayout());
        
        departmentPanel.setBorder(BorderFactory.createLineBorder(Color.PINK));
        departmentPanel.setBorder(BorderFactory.createTitledBorder("Department Info"));
        departmentPanel.setBackground(Color.PINK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        

        gbc.gridx = 0;
        gbc.gridy = 0;
        departmentPanel.add(new JLabel("Store Id:"), gbc);
        storeIdAp = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(storeIdAp, gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 1;
        departmentPanel.add(new JLabel("Store Name:"), gbc);
        storeNameAp1 = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(storeNameAp1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        departmentPanel.add(new JLabel("Location:"), gbc);
        locationAp2 = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(locationAp2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        departmentPanel.add(new JLabel("Opening Hour:"), gbc);
        openingHourAp3 = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(openingHourAp3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        departmentPanel.add(new JLabel("Total Sales:"), gbc);
        totalSalesAp4 = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(totalSalesAp4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        departmentPanel.add(new JLabel("Total Discount:"), gbc);
        totalDiscountAp12 = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(totalDiscountAp12, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        departmentPanel.add(new JLabel("Product Name:"), gbc);
        productNameAp6 = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(productNameAp6, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        departmentPanel.add(new JLabel("Marked Price:"), gbc);
        markedPriceAp = new JTextField(10);
        gbc.gridx = 1;
        departmentPanel.add(markedPriceAp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton addDepartment = new JButton("Add Department");
        addDepartment.setBackground(Color.RED);
        addDepartment.addActionListener(new addDepartmentAction());
        departmentPanel.add(addDepartment, gbc);

        return departmentPanel;
    }

    private JPanel createRetailerPanel() {
        JPanel retailerPanel = new JPanel(new GridBagLayout());
       
    
        // To add color in Panel for retailerPanel
        retailerPanel.setBorder(BorderFactory.createLineBorder(Color.PINK));   
        retailerPanel.setBackground(Color.PINK);
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        retailerPanel.setBorder(BorderFactory.createTitledBorder("Retailer Info"));
    
        // Add JLabel for Retailer Info at the top
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the label
       
    
        // Reset gridwidth for other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST; // Align other components to the left
    
        // To add Button for Storeid
        gbc.gridx = 0;
        gbc.gridy = 1;
        retailerPanel.add(new JLabel("Store Id:"), gbc);
        storeIdAp1 = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(storeIdAp1, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        retailerPanel.add(new JLabel("Store Name:"), gbc);
        storeNameAp9 = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(storeNameAp9, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 3;
        retailerPanel.add(new JLabel("Location:"), gbc);
        locationAp3 = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(locationAp3, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 4;
        retailerPanel.add(new JLabel("Opening Hour:"), gbc);
        openingHourAp4 = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(openingHourAp4, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 5;
        retailerPanel.add(new JLabel("Total Sales:"), gbc);
        totalSalesAp5 = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(totalSalesAp5, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 6;
        retailerPanel.add(new JLabel("Total Discount:"), gbc);
        totalDiscountAp5 = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(totalDiscountAp5, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 7;
        retailerPanel.add(new JLabel("Vat Inclusive Price:"), gbc);
        vatPriceAp = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(vatPriceAp, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 8;
        retailerPanel.add(new JLabel("Loyalty Point:"), gbc);
        loyaltyPointAp = new JTextField(10);
        gbc.gridx = 1;
        retailerPanel.add(loyaltyPointAp, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 9;
        retailerPanel.add(new JLabel("Is Payment Online?"), gbc);
        isPaymentOnlineBox = new JCheckBox();
        gbc.gridx = 1;
        retailerPanel.add(isPaymentOnlineBox, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 10;
        retailerPanel.add(new JLabel("Purchased Year:"), gbc);
        purchasedYearCB = new JComboBox<>(new String[]{"2020", "2021", "2022", "2023", "2024"});
        gbc.gridx = 1;
        retailerPanel.add(purchasedYearCB, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton addRetailer = new JButton("Add Retailer");
    
        // To add color in Add Retailer button 
        addRetailer.setBackground(Color.RED);
        addRetailer.addActionListener(new addRetailerAction());
        retailerPanel.add(addRetailer, gbc);
    
        return retailerPanel;
    }


    private JPanel createDiscountPanel() {
        JPanel discountPanel = new JPanel(new GridBagLayout());
        discountPanel.setBorder(BorderFactory.createTitledBorder("Calculate Discount Price Info"));
        discountPanel.setBackground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        discountPanel.add(new JLabel("Store Id:"), gbc);
        storeIdTf2 = new JTextField(10);
        gbc.gridx = 1;
        discountPanel.add(storeIdTf2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        discountPanel.add(new JLabel("Is In Sales:"), gbc);
        isInSales1 = new JComboBox<>(new String[]{"True", "False"});
        gbc.gridx = 1;
        discountPanel.add(isInSales1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        discountPanel.add(new JLabel("Marked Price:"), gbc);
        markedPriceTf = new JTextField(10); // Fixed variable name
        gbc.gridx = 1;
        discountPanel.add(markedPriceTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton calculateDiscountPrice = new JButton("Calculate Discount Price");
        calculateDiscountPrice.addActionListener(new calculateDiscountPriceAction());
        discountPanel.add(calculateDiscountPrice, gbc);
        calculateDiscountPrice.setBackground(Color.ORANGE);

        return discountPanel;
    }

    private JPanel createLoyaltyPanel() {
        JPanel loyaltyPanel = new JPanel(new GridBagLayout());
        loyaltyPanel.setBorder(BorderFactory.createTitledBorder("Calculate Loyalty Point Info"));
        loyaltyPanel.setBackground(Color.CYAN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow components to expand horizontally

        gbc.gridx = 0;
        gbc.gridy = 0;
        loyaltyPanel.add(new JLabel("Store Id:"), gbc);
        storeIdTf3 = new JTextField(10); // Ensured uniqueness
        gbc.gridx = 1;
        gbc.weightx = 1.0; // Allow text field to expand
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow text field to expand horizontally
        loyaltyPanel.add(storeIdTf3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0; // Reset weight for the next row
        loyaltyPanel.add(new JLabel("Is Payment Online:"), gbc);
        isPaymentOnlineBox1 = new JComboBox<>(new String[]{"Yes", "No"});
        gbc.gridx = 1;
        loyaltyPanel.add(isPaymentOnlineBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loyaltyPanel.add(new JLabel("Vat Inclusive Price:"), gbc);
        vatPriceTf1 = new JTextField(10); 
        gbc.gridx = 1;
        gbc.weightx = 1.0; // Allow text field to expand
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow text field to expand horizontally
        loyaltyPanel.add(vatPriceTf1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton calculateLoyaltyPoint = new JButton("Set Loyalty Point");
        calculateLoyaltyPoint.addActionListener(new calculateLoyaltyPointAction());
        loyaltyPanel.add(calculateLoyaltyPoint, gbc);
        calculateLoyaltyPoint.setBackground(Color.ORANGE);

        return loyaltyPanel;
    }

    private JPanel createRemoveDisplayPanel() {
        JPanel removeDisplayPanel = new JPanel(new GridBagLayout());
        removeDisplayPanel.setBorder(BorderFactory.createTitledBorder("Remove and Display Store Info"));
        removeDisplayPanel.setBackground(Color.GREEN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton removeStore = new JButton("Remove Store");
        removeStore.setBackground(Color.ORANGE);
        removeStore.addActionListener(new removeStoreAction());
        removeDisplayPanel.add(removeStore, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton displayStore = new JButton("Display Store");
        displayStore.setBackground(Color.LIGHT_GRAY);
        displayStore.addActionListener(new displayStoreAction());
        removeDisplayPanel.add(displayStore, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton clear = new JButton("Clear");
        clear.setBackground(Color.ORANGE);
        // clear.addActionListener(new clearAction());
        removeDisplayPanel.add(clear, gbc);
        

        return removeDisplayPanel;
    }

    // Action listeners
    private class addDepartmentAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int storeId = Integer.parseInt(storeIdAp.getText());
                String storeName =  storeNameAp9.getText();
                String location = locationAp2.getText();
                String openingHour = openingHourAp3.getText();
                double totalSales = Double.parseDouble(totalSalesAp4.getText());
                double totalDiscount = Double.parseDouble(totalDiscountAp12.getText());
                String productName = productNameAp6.getText();
                double markedPrice = Double.parseDouble(markedPriceAp.getText());

                Department department = new Department(storeId, storeName, location, openingHour, totalSales, totalDiscount, productName, markedPrice);
                storeList.add(department);
                JOptionPane.showMessageDialog(store, "Department added successfully!");
                clearDepartmentFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(store, "Invalid input! Please enter the correct values.");
            }
        }

        private void clearDepartmentFields() {
            storeIdAp.setText("");
            storeNameAp1.setText("");
            locationAp2.setText("");
            openingHourAp3.setText("");
            totalSalesAp4.setText("");
            totalDiscountAp5.setText("");
            productNameAp6.setText("");
            markedPriceAp.setText("");
        }
    }


    private class addRetailerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int storeId = Integer.parseInt(storeIdAp1.getText());
                String storeName =  storeNameAp9.getText();
                String location = locationAp3.getText();
                String openingHour = openingHourAp4.getText();
                double totalSales = Double.parseDouble(totalSalesAp5.getText());
                double totalDiscount = Double.parseDouble(totalDiscountAp5.getText());
                double vatPrice = Double.parseDouble(vatPriceAp.getText());
                int loyaltyPoint = Integer.parseInt(loyaltyPointAp.getText());
                boolean isPaymentOnline = isPaymentOnlineBox.isSelected();
                int purchasedYear = Integer.parseInt((String) purchasedYearCB.getSelectedItem());

                Retailer retailer = new Retailer(storeId, storeName, location, openingHour, totalSales, totalDiscount, vatPrice, loyaltyPoint, isPaymentOnline, purchasedYear);
                storeList.add(retailer);
                JOptionPane.showMessageDialog(store, "Retailer added successfully!");
                clearRetailerFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(store, "Invalid input! Please enter the correct values.");
            }
        }

        private void clearRetailerFields() {
            storeIdAp1.setText("");
            storeNameAp1.setText("");
            locationAp3.setText("");
            openingHourAp4.setText("");
            totalSalesAp5.setText("");
            totalDiscountAp5.setText("");
            vatPriceAp.setText("");
            loyaltyPointAp.setText("");
            isPaymentOnlineBox.setSelected(false);
            purchasedYearCB.setSelectedIndex(0);
        }
    }

    private class calculateDiscountPriceAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int storeId = Integer.parseInt(storeIdTf2.getText());
                boolean isInSales = Boolean.parseBoolean((String) isInSales1.getSelectedItem());
                double markedPrice = Double.parseDouble(markedPriceTf.getText());

                double discountPrice = markedPrice;
                if (isInSales) {
                    discountPrice *= 0.9; // 10% discount
                }

                JOptionPane.showMessageDialog(store, "Discount Price: " + discountPrice);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(store, "Invalid input! Please enter the correct values.");
    
            }



            
        }
    }


    private class calculateLoyaltyPointAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int storeId = Integer.parseInt(storeNameAp9.getText());
                boolean isPaymentOnline = "Yes".equals(isPaymentOnlineBox1.getSelectedItem());
                double vatPrice = Double.parseDouble(vatPriceTf1.getText());

                int loyaltyPoints = (int) (vatPrice / 10);
                if (isPaymentOnline) {
                    loyaltyPoints *= 2;
                }

                JOptionPane.showMessageDialog(store, "Loyalty Points: " + loyaltyPoints);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(store, "Invalid input! Please enter the correct values.");
            }
        }
    }

  
    private class removeStoreAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int storeId = Integer.parseInt(JOptionPane.showInputDialog(store, "Enter Store ID to remove:"));
                boolean removed = false;

                for (Store store : storeList) {
                    if (store.getStoreId() == storeId) {
                        storeList.remove(store);
                        removed = true;
                        JOptionPane.showMessageDialog(StoreGUI.this.store, "Store removed successfully!");
                        break;
                    }
                }

                if (!removed) {
                    JOptionPane.showMessageDialog(StoreGUI.this.store, "Store not found!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(StoreGUI.this.store, "Invalid input! Please enter the correct values.");
            }
        }
    }


    private class displayStoreAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        
                    if(storeList.isEmpty()){
                        JOptionPane.showMessageDialog(store,"No Store has been to the list", "null", 0); 
                        return; 
                    }
                    String message="";
                    for(Store store:storeList)
                    {
                        store.display();
                        message+="Store Id: " +store.getStoreId()+"\n";
                        message+="StoreName: " +store.getStoreName()+"\n";
                        message+="Location: " +store.getLocation()+"\n";
                        message+="openingHour: " +store.getOpeningHour()+"\n";
                        
                     }
                   
                    
                    JOptionPane.showMessageDialog(store,message,null, JOptionPane.INFORMATION_MESSAGE);
                }
            }
    



    // private class clearAction implements ActionListener {
    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         storeIdAp.setText("");
    //         storeNameAp1.setText("");
    //         locationAp2.setText("");
    //         openingHourAp3.setText("");
    //         totalSalesAp4.setText("");
    //         totalDiscountAp5.setText("");
    //         productNameAp6.setText("");
    //         markedPriceAp.setText("");
    //         storeIdAp1.setText("");
    //         storeNameAp1.setText("");
    //         locationAp3.setText("");
    //         openingHourAp4.setText("");
    //         totalSalesAp5.setText("");
    //         totalDiscountAp5.setText("");
    //         vatPriceAp.setText("");
    //         loyaltyPointAp.setText("");
    //         isPaymentOnlineBox.setSelected(false);
    //         purchasedYearCB.setSelectedIndex(0);
    //         storeIdTf2.setText("");
    //         markedPriceTf.setText("");
    //         storeIdTf3.setText("");
    //         vatPriceTf1.setText("");
    //         isPaymentOnlineBox1.setSelectedIndex(0);
    //         isInSales1.setSelectedIndex(0);
    //     }



    public static void main(String[] args) {
        new StoreGUI(); 
    }
}

