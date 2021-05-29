package dadThing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class driver {
	
	static List<subdivision> accountsList = new ArrayList();
	
	static int accountsNumber = 0;

	public static void main(String args[])
	{
		
		final String fileName = "dadNumbers.txt";
		
		if(ifFileExists(fileName))
		{
			readAccountsFromFile(fileName);
		}
		else {
			
			try {
				new PrintWriter(fileName, "UTF-8");
			} catch(Exception e)
			{
				System.err.println("An error occurred.");
				System.err.println(e);
			}
			
		}
		

		Scanner keyboard = new Scanner(System.in);
		
//		Integer choice = -1;
		int choice2 = -1;
		
		JFrame f = new JFrame("Dad program");		
		f.setSize(500,750);
		f.setLocation(300,200);
		
		JPanel panelMainMenu = new JPanel();	
		panelMainMenu.setBackground(Color.gray);
		
		//Grid layout
		GridLayout experimentLayout = new GridLayout(9,1);		
		panelMainMenu.setLayout(experimentLayout);
		
		//adds box to give user selection
//		JTextArea textAreaMenuChoice = new JTextArea(0,2);
//		JButton buttonMenuChoice = new JButton("Choose Option");
		
		//Menu Options
//		JLabel label1 = new JLabel("1. Set up accounts");
//		JLabel label2 = new JLabel("2. Read Accounts in from file");
//		JLabel label3 = new JLabel("2. Check account balances");
//		JLabel label4 = new JLabel("4. Write accounts to file");
//		JLabel label5 = new JLabel("5. Clear list");
//		JLabel label6 = new JLabel("6. Total Balance");
//		JLabel label7 = new JLabel("7. Disperse Interest");
//		JLabel label8 = new JLabel("8. Save Changes");
		JButton button1 = new JButton("1. Set up accounts");
		JButton button2 = new JButton("2. Check account balances");
		JButton button3 = new JButton("3. Add Weekly Amounts");
//		JButton button4 = new JButton("4. Write accounts to file");
//		JButton button4 = new JButton("4. Clear list");
		JButton button4 = new JButton("4. Total Balance");
		JButton button5 = new JButton("5. Disperse Interest");
		JButton button6 = new JButton("6. Update Account Weekly Amount");
		JButton button7 = new JButton("7. Update Account Balance");
		JButton button8 = new JButton("8. Save Changes");
		JButton button9 = new JButton("9. Reload file");

		
		
		
		panelMainMenu.add(button1);
		panelMainMenu.add(button2);
		panelMainMenu.add(button3);
		panelMainMenu.add(button4);
		panelMainMenu.add(button5);
		panelMainMenu.add(button6);
		panelMainMenu.add(button7);
		panelMainMenu.add(button8);
		panelMainMenu.add(button9);

		
		f.add(panelMainMenu);
		
		f.setVisible(true);
		
		//1. Set up accounts
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);
				
				JPanel panelChoice1 = new JPanel();
				panelChoice1.setBackground(Color.gray);
				
				//Grid layout
				GridLayout gridChoice1 = new GridLayout(8,1);		
				panelChoice1.setLayout(gridChoice1);
				
				
				//components
				JLabel labelAccountName = new JLabel("Account Name");
				JTextArea textAccountName = new JTextArea();
				
				JLabel labelAccountBalance = new JLabel("Account Balance");
				JTextArea textAccountBalance = new JTextArea();
				
				JLabel labelAccountWeekly = new JLabel("Account Weekly Addition");
				JTextArea textAccountWeekly = new JTextArea();
				
				JButton buttonAddAccount = new JButton("Add Account");
				JButton buttonReturn1 = new JButton("Back");
				
				
				//Add components to panel
				panelChoice1.add(labelAccountName);
				panelChoice1.add(textAccountName);
				
				panelChoice1.add(labelAccountBalance);
				panelChoice1.add(textAccountBalance);
				
				panelChoice1.add(labelAccountWeekly);
				panelChoice1.add(textAccountWeekly);
				
				
				panelChoice1.add(buttonAddAccount);
				panelChoice1.add(buttonReturn1);
				
				//Add panel to the frame
				f.add(panelChoice1);
				
				//add new account
				buttonAddAccount.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String name = textAccountName.getText();
						double balance = Double.parseDouble(textAccountBalance.getText());
						double weeklyAmount = Double.parseDouble(textAccountWeekly.getText());
						
						//Checks to see if the name already exists
						boolean nameCheck = false;
						
						for(subdivision account : accountsList)
						{
							if(account.getName().equals(name))
							{
								System.err.println("NAME ALREADY EXISTS");
								nameCheck = true;
							}
							else {
								
							}
						}
						
						//If the name is already in the list...
						if(nameCheck)
						{
							//...don't add the account. throw an error.							
							System.err.println("Account not added.");
						}
						
						//otherwise add the account to the list...
						else {
							subdivision newAccount = new subdivision(balance, weeklyAmount, name);
							accountsList.add(newAccount);
							
							textAccountName.setText("NAME ALREADY EXISTS");
							
							panelChoice1.setVisible(false);
							panelMainMenu.setVisible(true);
							
						}						

					}
					
				});
				
				//return to main menu
				buttonReturn1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						panelChoice1.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
					
					
				});
				
			}
			
		});
		
		//2. Check account balances
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);
				
				
				JPanel panelChoice3 = new JPanel();
				panelChoice3.setBackground(Color.gray);

				
				//Grid layout
				GridLayout gridChoice3 = new GridLayout(2,1);		
				panelChoice3.setLayout(gridChoice3);
				
				JTextArea accountsLabel = new JTextArea();
				
				JButton buttonReturn3 = new JButton("Back");
				
				
				
				String accountsString = grabAccountsList(fileName);
				
				accountsLabel.setText(accountsString);
				
				JScrollPane scrollAccountsLabel = new JScrollPane(accountsLabel);
				
				panelChoice3.add(scrollAccountsLabel);
				
				panelChoice3.add(buttonReturn3);
				
				f.add(panelChoice3);
				
				
				//return to main menu
				buttonReturn3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						panelChoice3.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
					
					
				});
				
			}


			
		});
		
		//3. Add Weekly Amounts
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);
				
				
				JPanel panelChoice3 = new JPanel();
				panelChoice3.setBackground(Color.gray);

				
				//Grid layout
				GridLayout gridChoice3 = new GridLayout(4,1);		
				panelChoice3.setLayout(gridChoice3);
				
				JLabel labelThing = new JLabel("Balance after weekly addition");
				JTextArea accountsLabel = new JTextArea();
				
				JButton buttonSave = new JButton("Add Weekly Amount");
				JButton buttonReturn3 = new JButton("Back");
				
				String accountsString = "Name\tBalance\tWeekly Addition\n\n";
				
				List<subdivision> newAccountsList = new ArrayList();
				
				double newTotalBalance = 0; 
				
				for(subdivision account : accountsList)
				{
					String name = account.getName();
					double balance = account.getPrincipleBalance();
					double weekly = account.getWeeklyAddition();
					
					subdivision newAccount = new subdivision((balance + weekly), weekly, name);
					
					newAccountsList.add(newAccount);
					
					double newBalance = Math.round((balance + weekly) * 100.0) / 100.0;
					
					weekly = Math.round(weekly * 100.0) / 100.0;

					
					accountsString += (name + ":\t$" + newBalance + "\t$" + weekly + "\n");
					
					newTotalBalance += newBalance;
				}
				
				newTotalBalance = Math.round(newTotalBalance * 100.0) / 100.0;
				
				accountsString += "\nNEW TOTAL BALANCE:\t$" + newTotalBalance;
				
				
				
				accountsLabel.setText(accountsString);
				
				panelChoice3.add(labelThing);
				JScrollPane scrollAccountsLabel = new JScrollPane(accountsLabel);
//				panelChoice3.add(accountsLabel);
				panelChoice3.add(scrollAccountsLabel);

				
				panelChoice3.add(buttonSave);
				
				panelChoice3.add(buttonReturn3);
				
				f.add(panelChoice3);
				
				buttonSave.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						accountsList = newAccountsList;
						
						panelChoice3.setVisible(false);
						panelMainMenu.setVisible(true);
					}
					
				});
				
				//return to main menu
				buttonReturn3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						panelChoice3.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
					
					
				});
				
			}
			
		});
			
		//4. Total Balance
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);
				
				JPanel panelChoice6 = new JPanel();
				panelChoice6.setBackground(Color.gray);

				
				//Grid layout
				GridLayout gridChoice3 = new GridLayout(3,1);		
				panelChoice6.setLayout(gridChoice3);
				
				JTextArea accountsLabel = new JTextArea();
				
				JButton buttonReturn6 = new JButton("Back");
				
				//Reads total balance from all accounts
				String accountsString = "Total balance across all accounts:\n\n$";	
				
//			    DecimalFormat df = new DecimalFormat("0.00");
				
//				double totalThing = Double.parseDouble(df.format(readTotalBalance(accountsList)));
				double totalThing = Math.round(readTotalBalance(accountsList) * 100.0) / 100.0;
				
				accountsString += totalThing;					
				accountsLabel.setText(accountsString);
				
				panelChoice6.add(accountsLabel);
				
				panelChoice6.add(buttonReturn6);
				
				f.add(panelChoice6);
				
				
				//return to main menu
				buttonReturn6.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						panelChoice6.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
					
					
				});
				
			}
			
		});
		
		//5. Disperse Interest
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);

				JPanel panelChoice7 = new JPanel();
				panelChoice7.setBackground(Color.gray);
				
				//Grid layout
				GridLayout gridChoice7 = new GridLayout(6,1);		
				panelChoice7.setLayout(gridChoice7);
				
				//Text Areas
				JTextArea interestAmount = new JTextArea();
				JTextArea accountsLabel = new JTextArea();

				
				//Buttons
				JButton buttonDisperseInterest = new JButton("Disperse Interest");
				JButton buttonReturn7 = new JButton("Back");
				
				double totalBalance = readTotalBalance(accountsList);
				
				String accountsString = "Name\tBalance\tWeekly\tPercentage\n\n";
				
				for(subdivision account : accountsList)
				{
					String name = account.getName();
					double balance = Math.round(account.getPrincipleBalance() * 100.0) / 100.0;
					double weekly = Math.round(account.getWeeklyAddition() * 100.0) / 100.0;					
					double percent = Math.round((account.getPrincipleBalance() / totalBalance) * 10000.0) / 100.0;
//							account.getPrincipleBalance() / totalBalance;
//					percent = Math.round(percent * 10000.0) / 100.0;
					
					accountsString += (name + ":\t$" + balance + "\t$" + weekly + "\t" + percent + "%\n");
				}			
				
				accountsString += "\nTOTAL BALANCE:\t\t$" + totalBalance;

				accountsLabel.setText(accountsString);
				JScrollPane scrollAccountsLabel = new JScrollPane(accountsLabel);

				
				panelChoice7.add(new JLabel("Enter Interest Amount"));
				panelChoice7.add(interestAmount);
				
				panelChoice7.add(new JLabel("Accounts List"));
				panelChoice7.add(scrollAccountsLabel);
				
				panelChoice7.add(buttonDisperseInterest);
				panelChoice7.add(buttonReturn7);
				
				
				f.add(panelChoice7);


				
				
				//Disperse Interest
				buttonDisperseInterest.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						double interestAmountVar = Double.parseDouble(interestAmount.getText());								
						
						panelChoice7.setVisible(false);
						
						JPanel panelChoiceSubMenu = new JPanel();
						panelChoiceSubMenu.setBackground(Color.gray);
						
						//Grid layout
						GridLayout gridChoice7_1 = new GridLayout(3,1);		
						panelChoiceSubMenu.setLayout(gridChoice7_1);
						
						//Text Areas
//						JTextArea interestAmount = new JTextArea();
						JTextArea accountsLabel = new JTextArea();

						//Buttons
						JButton buttonReturn7_1 = new JButton("Back");
						
						String accountsString = "Name\tBalance\tWeekly\tAdded\tPercentage\n\n";
						
						double totalBalance = readTotalBalance(accountsList);
						
//						double totalPercent = 0;
						
						List<subdivision> newAccountList = new ArrayList();
						
						double newTotalBalance = 0;
						
						for(subdivision account : accountsList)
						{
							
							double principle = account.getPrincipleBalance();
							double percentage = (principle / totalBalance);
							double percentShow = (principle / totalBalance * 100);
							
//							totalPercent += percentage;
							
							System.out.println("Percent: " + percentage);
							
//						    DecimalFormat df = new DecimalFormat("0.00");
							
//							double amountAdded = Double.parseDouble(df.format(percentage * interestAmountVar));
							double amountAdded = percentage * interestAmountVar;
							amountAdded = Math.round(amountAdded * 100.0) / 100.0;
//							amountAdded = Math.round(amountAdded * 100) / 100;
							
							System.out.println("amount added: " + amountAdded);
							
							double newBalance = principle + amountAdded;
							
//							percentShow = Double.parseDouble(df.format(percentShow));
							
							percentShow = Math.round(percentShow * 100.0) / 100.0;
							
//							newBalance = Double.parseDouble(df.format(newBalance));
							
							newBalance = Math.round(newBalance * 100.0) / 100.0;
							
							accountsString += (account.getName() + ":\t$" + newBalance + "\t$" + account.getWeeklyAddition() + "\t$" + amountAdded + "\t" + percentShow + "%\n");
							
							subdivision newAccount = new subdivision(newBalance, account.getWeeklyAddition(), account.getName());
							
							newAccountList.add(newAccount);
							
							newTotalBalance += newBalance;

						}
						
						newTotalBalance = Math.round(newTotalBalance * 100.0) / 100.0;
						
						accountsString += "\nNEW TOTAL BALANCE:\t$" + newTotalBalance;
						
						accountsList = newAccountList;
						
//						System.out.println("Total percent: " + totalPercent);

						accountsLabel.setText(accountsString);
						JScrollPane scrollAccountsLabel = new JScrollPane(accountsLabel);

						
//						panelChoice7_1.add(new JLabel("Enter Interest Amount"));
//						panelChoice7_1.add(interestAmount);
						
						panelChoiceSubMenu.add(new JLabel("Accounts List"));
						panelChoiceSubMenu.add(scrollAccountsLabel);
						
						panelChoiceSubMenu.add(buttonReturn7_1);
						
						panelChoiceSubMenu.setVisible(true);
						
						f.add(panelChoiceSubMenu);
						
						//return to main menu
						buttonReturn7_1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
								panelChoiceSubMenu.setVisible(false);
								panelMainMenu.setVisible(true);
								
							}
							
							
							
						});
					}
					
					
					
				});					
				
				//return to main menu
				buttonReturn7.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						panelChoice7.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
					
					
				});
				
			}
			
		});
						
		//6. Update Account Weekly Amount
		button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panelMainMenu.setVisible(false);
				
				JPanel panelChoice6 = new JPanel();
				panelChoice6.setBackground(Color.gray);
				
				
				//Grid layout
				GridLayout gridChoice3 = new GridLayout(8,1);		
				panelChoice6.setLayout(gridChoice3);
				
				JLabel labelAccountName = new JLabel("Enter account name");
				JTextArea textAccountName = new JTextArea();
				
//				JLabel labelAccountBalance = new JLabel("Enter new account balance(enter nothing to leave balance alone)");
//				JTextArea textAccountBalance = new JTextArea();
				
				JLabel labelAccountWeekly = new JLabel("Enter new account weekly addition");
				JTextArea textAccountWeekly = new JTextArea();
				
				JButton buttonUpdateAccount = new JButton("Update Account");
				JButton buttonReturn6 = new JButton("Back");		
				
				
				panelChoice6.add(labelAccountName);
				panelChoice6.add(textAccountName);
				
//				panelChoice6.add(labelAccountBalance);
//				panelChoice6.add(textAccountBalance);
				
				panelChoice6.add(labelAccountWeekly);
				panelChoice6.add(textAccountWeekly);
				
				panelChoice6.add(buttonUpdateAccount);
				panelChoice6.add(buttonReturn6);
				
				f.add(panelChoice6);
				
				buttonUpdateAccount.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						String name = textAccountName.getText();
						double balance, weekly;					
						
						
						
						List<subdivision> newAccountsList = new ArrayList();
						
						for(subdivision account : accountsList)
						{							
							if(account.getName().equals(name))
							{
								balance = account.getPrincipleBalance();
								
								weekly = Double.parseDouble(textAccountWeekly.getText());
								
								subdivision newAccount = new subdivision(balance, weekly, name);
								
								newAccountsList.add(newAccount);
								/*
								//Checks to see if the user entered anything for balance.
								if(textAccountBalance.getText() == null)
								{
									//If they didn't, it leaves the accounts balance as it was.
									balance = account.getPrincipleBalance();
								}
								//If the user did enter something for balance...
								else {
									//it saves that value
									balance = Double.parseDouble(textAccountBalance.getText());
								}*/
								
//								//Does the same as above, but with weekly
//								if(textAccountWeekly.getText() == null)
//								{
//									weekly = account.getWeeklyAddition();
//								}								
//								else {
//									weekly = Double.parseDouble(textAccountWeekly.getText());
//								}	
										
							}
							else {
								newAccountsList.add(account);
							}
						}
						
						accountsList = newAccountsList;
						
						panelChoice6.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
				});
				
				buttonReturn6.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						panelChoice6.setVisible(false);
						panelMainMenu.setVisible(true);						
						
					}					
					
					
				});
			}
			
		});
		
		//7. Update Account Balance
		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);
				
				JPanel panelChoice6 = new JPanel();
				panelChoice6.setBackground(Color.gray);
				
				
				//Grid layout
				GridLayout gridChoice3 = new GridLayout(8,1);		
				panelChoice6.setLayout(gridChoice3);
				
				JLabel labelAccountName = new JLabel("Enter account name");
				JTextArea textAccountName = new JTextArea();
				
				JLabel labelAccountBalance = new JLabel("Enter new account balance");
				JTextArea textAccountBalance = new JTextArea();
				
//				JLabel labelAccountWeekly = new JLabel("Enter new account weekly addition(enter nothing to leave weekly alone)");
//				JTextArea textAccountWeekly = new JTextArea();
				
				JButton buttonUpdateAccount = new JButton("Update Account");
				JButton buttonReturn6 = new JButton("Back");		
				
				
				panelChoice6.add(labelAccountName);
				panelChoice6.add(textAccountName);
				
				panelChoice6.add(labelAccountBalance);
				panelChoice6.add(textAccountBalance);
				
//				panelChoice6.add(labelAccountWeekly);
//				panelChoice6.add(textAccountWeekly);
				
				panelChoice6.add(buttonUpdateAccount);
				panelChoice6.add(buttonReturn6);
				
				f.add(panelChoice6);
				
				buttonUpdateAccount.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						String name = textAccountName.getText();
						double balance, weekly;					
						
						
						
						List<subdivision> newAccountsList = new ArrayList();
						
						for(subdivision account : accountsList)
						{							
							if(account.getName().equals(name))
							{
								weekly = account.getWeeklyAddition();
								
								balance = Double.parseDouble(textAccountBalance.getText());
								
								subdivision newAccount = new subdivision(balance, weekly, name);
								
								newAccountsList.add(newAccount);
								/*
								//Checks to see if the user entered anything for balance.
								if(textAccountBalance.getText() == null)
								{
									//If they didn't, it leaves the accounts balance as it was.
									balance = account.getPrincipleBalance();
								}
								//If the user did enter something for balance...
								else {
									//it saves that value
									balance = Double.parseDouble(textAccountBalance.getText());
								}*/
								
//								//Does the same as above, but with weekly
//								if(textAccountWeekly.getText() == null)
//								{
//									weekly = account.getWeeklyAddition();
//								}								
//								else {
//									weekly = Double.parseDouble(textAccountWeekly.getText());
//								}	
										
							}
							else {
								newAccountsList.add(account);
							}
						}
						
						accountsList = newAccountsList;
						
						panelChoice6.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
				});
				
				buttonReturn6.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						panelChoice6.setVisible(false);
						panelMainMenu.setVisible(true);						
						
					}					
					
					
				});
			}
			
			
			
		});

		//8. Save Changes
		button8.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenu.setVisible(false);

				JPanel panelChoice8 = new JPanel();
				panelChoice8.setBackground(Color.gray);

				
				//Grid layout
				GridLayout gridChoice3 = new GridLayout(6,1);		
				panelChoice8.setLayout(gridChoice3);
				
				JTextArea oldAccounts = new JTextArea();
				JTextArea newAccounts = new JTextArea();
				
				JButton buttonSave = new JButton("Save");
				JButton buttonReturn8 = new JButton("Back");
				
				
				//Load in accounts from the file
				List<subdivision> oldAccountsThing = new ArrayList();
				oldAccountsThing = readAccountsFromFileToList("dadNumbers.txt");
				
				String accountsString = "Name\tBalance\tWeekly Addition\n\n";
				
				for(subdivision account : oldAccountsThing)
				{						
					accountsString += (account.getName() + ":\t$" + account.getPrincipleBalance() + "\t$" + account.getWeeklyAddition() + "\n");
				}
				
				oldAccounts.setText(accountsString);
				JScrollPane scrollOldAccounts = new JScrollPane(oldAccounts);

				
				
				//display accounts to save
				accountsString = "Name\tBalance\tWeekly Addition\n\n";
				
				for(subdivision account : accountsList)
				{						
					accountsString += (account.getName() + ":\t$" + account.getPrincipleBalance() + "\t$" + account.getWeeklyAddition() + "\n");
				}
				
				newAccounts.setText(accountsString);
				JScrollPane scrollNewAccounts = new JScrollPane(newAccounts);
				
				

				
				
				
				panelChoice8.add(new JLabel("Accounts currently on file"));
				panelChoice8.add(scrollOldAccounts);
				
				panelChoice8.add(new JLabel("Accounts to be saved"));
				panelChoice8.add(scrollNewAccounts);
				
				panelChoice8.add(buttonSave);
				panelChoice8.add(buttonReturn8);
				
				f.add(panelChoice8);
				
				//Saves the changes to the file
				buttonSave.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						writeFile(accountsList);
						
						panelChoice8.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
				});
				
				
				//return to main menu
				buttonReturn8.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						panelChoice8.setVisible(false);
						panelMainMenu.setVisible(true);
						
					}
					
					
					
				});
				
			}
			
		});
			
		//Reload the file
		button9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				readAccountsFromFile("dadNumbers.txt");
				
			}
			
			
			
		});
		
	}
	
	
	
	
	//check if a file exists
	public static boolean ifFileExists(String fileName) {
		try {
			
			String path = System.getProperty("user.dir");
			
			System.out.println("Working directory = " + path);
			
			File file = new File(path + "\\" + fileName);
			
			if(file.exists())
			{
				return true;
			}
			else {
				return false;
			}

			
		}catch(Exception e)
		{
			System.err.println("Error occurred.");
			System.err.println(e);
			return false;
		}
	}
	
	//write accounts to the file
	public static void writeFile(List<subdivision> accounts)
	{
		try {
			
			FileWriter fstream = new FileWriter("dadNumbers.txt");
			
			BufferedWriter out = new BufferedWriter(fstream);
			
			for(subdivision account : accounts)
			{
				out.write(account.getName());
				out.write(":");
				out.write(Double.toString(account.getPrincipleBalance()));
				out.write("-");
				out.write(Double.toString(account.getWeeklyAddition()));
				out.write("\n");
			}
			
//			for(int i = 0; i < accounts.size(); i++)
//			{
//				String balanceThing = Double.toString(accounts[i].getPrincipleBalance());
//				out.write(accounts[i].getName());
//				out.write(":");
//				out.write(balanceThing);
//				out.write("\n");
//				
//			}
			
			out.close();
			
		}catch(Exception e)
		{
			System.out.println("There was an error.");
			System.out.println(e);
		}
	}
	
	//read accounts from file
	public static void readFile(String fileName)
	{
		try {
			
			String path = System.getProperty("user.dir");
			
			System.out.println("Working directory = " + path);
			
			File file = new File(path + "\\" + fileName);
						
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			
			String st;
			System.out.println("\n\nFile contents: \n");
			while((st = br.readLine()) != null)
			{
				int indexThing = st.indexOf(":");
				int indexThing2 = st.indexOf("-");
				
//				System.out.println(indexThing + " : " + indexThing2);
				
				String name = st.substring(0, indexThing);
				String balance = st.substring(indexThing+1, indexThing2);
				String weeklyAddition = st.substring(indexThing2+1);
//				double balance = Double.parseDouble();
				
				
//				double balance = Double.parseDouble((st.substring(indexThing+2)));
				
				
				System.out.println(name + " - " + balance + " - " + weeklyAddition);
				
			}
			
		}catch(Exception e)
		{
			System.out.println("There was an error reading the file.");
			System.out.println(e);
		}
	}

	//read accounts to accounts list from file
	public static void readAccountsFromFile(String fileName)
	{
		try {
			
			accountsList.clear();
			
			String path = System.getProperty("user.dir");
			
//			System.out.println("Working directory = " + path);
			
			File file = new File(path + "\\" + fileName);
						
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			
			String st;
//			System.out.println("\n\nFile contents: \n");
			while((st = br.readLine()) != null)
			{
				int indexThing = st.indexOf(":");
				int indexThing2 = st.indexOf("-");
								
				String name = st.substring(0, indexThing);
				double balance = Double.parseDouble(st.substring(indexThing+1, indexThing2));
				double weeklyAddition = Double.parseDouble(st.substring(indexThing2+1));
				
				subdivision account = new subdivision(balance, weeklyAddition, name);
				
				accountsList.add(account);
				
			}
			
		}catch(Exception e)
		{
			System.out.println("There was an error reading the file.");
			System.out.println(e);
		}
	}

	//read accounts from file to a list
	public static List<subdivision> readAccountsFromFileToList(String fileName)
	{
		List<subdivision> newAccountsThing = new ArrayList();
		
		try {
						
			String path = System.getProperty("user.dir");
			
//			System.out.println("Working directory = " + path);
			
			File file = new File(path + "\\" + fileName);
						
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			
			String st;
//			System.out.println("\n\nFile contents: \n");
			while((st = br.readLine()) != null)
			{
				int indexThing = st.indexOf(":");
				int indexThing2 = st.indexOf("-");
								
				String name = st.substring(0, indexThing);
				double balance = Double.parseDouble(st.substring(indexThing+1, indexThing2));
				double weeklyAddition = Double.parseDouble(st.substring(indexThing2+1));
				
				subdivision account = new subdivision(balance, weeklyAddition, name);
				
				newAccountsThing.add(account);
								
				
			}
			
			return newAccountsThing;
			
		}catch(Exception e)
		{
			System.out.println("There was an error reading the file.");
			System.out.println(e);
		}
		
		
		return newAccountsThing;
	}
	
	//read total balance
	public static double readTotalBalance(List<subdivision> accounts)
	{
		double total = 0;
		
		for(subdivision account : accounts)
		{
			total += account.getPrincipleBalance();
		}
		
		return total;
	}

	//Grab the list of accounts as a string
	public static String grabAccountsList(String fileName) {
		
		String accountsString = "Name\tBalance\tWeekly\tPercentage\n\n";
		
		double totalBalance = readTotalBalance(accountsList);
		
		for(subdivision account : accountsList)
		{
			String name = account.getName();
			double balance = account.getPrincipleBalance();
			double weekly = account.getWeeklyAddition();
			double percentage = Math.round((balance / totalBalance) * 10000.0) / 100.0;
							    
		    balance = Math.round(balance * 100.0) / 100.0;
		    weekly = Math.round(weekly * 100.0) / 100.0;
			
			accountsString += (name + ":\t$" + balance + "\t$" + weekly + "\t" + percentage + "%\n");
		}
		
		totalBalance = Math.round(totalBalance * 100.0) / 100.0;
		
		accountsString += "\n\nTOTAL BALANCE:\t\t$" + totalBalance;
		
		
		return accountsString;
	}
	
	//Grab the list of accounts as a string
	public static String grabAccountsListWithWeekly(String fileName) {
		
		String accountsString = "Name\tBalance\tWeekly\tPercentage\n\n";
		
		double totalBalance = readTotalBalance(accountsList);
		
		for(subdivision account : accountsList)
		{
			String name = account.getName();
			double balance = account.getPrincipleBalance();
			double weekly = account.getWeeklyAddition();
			double percentage = Math.round((balance / totalBalance) * 10000.0) / 100.0;
							    
		    balance = Math.round(balance * 100.0) / 100.0;
		    weekly = Math.round(weekly * 100.0) / 100.0;
			
			accountsString += (name + ":\t$" + balance + "\t$" + weekly + "\t" + percentage + "%\n");
		}
		
		accountsString += "\n\nTOTAL BALANCE:\t\t$" + totalBalance;
		
		
		return accountsString;
	}



}
