package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import Utility.Status;
import Utility.StatusObserver;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnAddVertex;
	private JRadioButton rdbtnAddEdge;
	private JRadioButton rdbtnRemoveVertex;
	private JRadioButton rdbtnRemoveEdge;
	private JButton btnAllEdges;
	private JButton btnConectedComponents;
	private JButton btnShowCutVertices;
	private JButton btnHelp;
	private GraphArea graphArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnAddVertex = new JRadioButton("Add Vertex");
		rdbtnAddVertex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatusObserver.getStatus().setCurrentStatus( Status.AddVertex);
			}
		});
		rdbtnAddVertex.setBounds(8, 9, 173, 45);
		contentPane.add(rdbtnAddVertex);
		
		rdbtnAddEdge = new JRadioButton("Add Edge");
		rdbtnAddEdge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatusObserver.getStatus().setCurrentStatus( Status.AddEdge);
			}
		});
		rdbtnAddEdge.setBounds(8, 59, 173, 45);
		contentPane.add(rdbtnAddEdge);
		
		rdbtnRemoveVertex = new JRadioButton("Remove Vertex");
		rdbtnRemoveVertex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatusObserver.getStatus().setCurrentStatus( Status.RemoveVertex);
			}
		});
		rdbtnRemoveVertex.setBounds(8, 109, 173, 45);
		contentPane.add(rdbtnRemoveVertex);
		
		rdbtnRemoveEdge = new JRadioButton("Remove Edge");
		rdbtnRemoveEdge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatusObserver.getStatus().setCurrentStatus( Status.RemoveEdge);
			}
		});
		rdbtnRemoveEdge.setBounds(8, 156, 173, 45);
		contentPane.add(rdbtnRemoveEdge);
		
		btnAllEdges = new JButton("Add All Edges");
		btnAllEdges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphArea.AddAllEdges();
			}
		});
		btnAllEdges.setBounds(8, 210, 173, 36);
		contentPane.add(btnAllEdges);
		
		btnConectedComponents = new JButton("Conected Components");
		btnConectedComponents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphArea.showConectedComponents();
			}
		});
		btnConectedComponents.setBounds(8, 244, 173, 36);
		contentPane.add(btnConectedComponents);
		
		btnShowCutVertices = new JButton("Show Cut Vertices");
		btnShowCutVertices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusObserver.getStatus().setShowCutVerticesIsOn(true);
				graphArea.showCutVertices();
			}
		});
		btnShowCutVertices.setBounds(8, 276, 173, 36);
		contentPane.add(btnShowCutVertices);
		
		btnHelp = new JButton("Help");
		btnHelp.setBounds(8, 310, 173, 36);
		contentPane.add(btnHelp);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnAddEdge);
		radioGroup.add(rdbtnAddVertex);
		radioGroup.add(rdbtnRemoveEdge);
		radioGroup.add(rdbtnRemoveVertex);
		graphArea = new GraphArea ();
		contentPane.add(graphArea);
		
	}
}
