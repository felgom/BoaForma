package br.senai.sp.jandira.app;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

import br.senai.sp.jandira.view.FrmAcademia;
import br.senai.sp.jandira.view.FrmTela;

public class App {

	public static void main(String[] args) {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		}
		

		FrmAcademia cadastro = new FrmAcademia();
		cadastro.setVisible(true);
	}
}
