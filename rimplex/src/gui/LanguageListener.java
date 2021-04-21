package gui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LanguageListener implements ListSelectionListener
{
  
  private JList<String> languageList;
  private DefaultListModel<String> model;
  private JButton close;
  private JLabel settings;
  private JLabel language;
  private JButton about;
  
  public LanguageListener(JList<String> languageList, DefaultListModel<String> model, JButton close, JLabel settings, JLabel language, JButton about)
  {
    this.languageList = languageList;
    this.model = model;
    this.close = close;
    this.settings = settings;
    this.language = language;
    this.about = about;
  }

  @Override
  public void valueChanged(ListSelectionEvent e)
  {
    if (!e.getValueIsAdjusting())
    {
      if (languageList.getSelectedValue().equals("Spanish") || languageList.getSelectedValue().equals("Espa�ol") || languageList.getSelectedValue().equals("L'espagnol"))
      {
        model.setElementAt("Ingl�s", 0);
        model.setElementAt("Espa�ol", 1);
        model.setElementAt("Franc�s", 2);
        close.setText("Cerrar");
        settings.setText("Configuraci�n");
        language.setText("Idioma:");
        about.setText("acerca de");
      }
      else if (languageList.getSelectedValue().equals("English") || languageList.getSelectedValue().equals("Ingl�s") || languageList.getSelectedValue().equals("Anglais"))
      {
        model.setElementAt("English", 0);
        model.setElementAt("Spanish", 1);
        model.setElementAt("French", 2);
        close.setText("Close");
        settings.setText("Settings");
        language.setText("Language:");
        about.setText("about");
      }
      else
      {
        model.setElementAt("Anglais", 0);
        model.setElementAt("L'espagnol", 1);
        model.setElementAt("Fran�ais", 2);
        close.setText("Fermer");
        settings.setText("Param�tres");
        language.setText("Langue:");
        about.setText("� propos de");
      }
    }
  }

}