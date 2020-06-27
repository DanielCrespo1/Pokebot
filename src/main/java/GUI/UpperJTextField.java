package GUI;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class UpperJTextField extends JTextField {

	private static final long serialVersionUID = 6389977136645515919L;

	protected Document createDefaultModel() {
		return new UpperCaseDocument();
	}

	static class UpperCaseDocument extends PlainDocument {

		private static final long serialVersionUID = 6436542413684783662L;

		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {

			if (str == null) {
				return;
			}
			char[] upper = str.toCharArray();
			for (int i = 0; i < upper.length; i++) {
				upper[i] = Character.toUpperCase(upper[i]);
			}
			super.insertString(offs, new String(upper), a);
		}
	}
}