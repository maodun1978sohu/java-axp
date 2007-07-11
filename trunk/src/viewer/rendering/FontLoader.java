package viewer.rendering;

import java.awt.Font;
import java.io.ByteArrayInputStream;

import xps.api.util.CachingResourceLoader;
import xps.impl.zipfileaccess.XPSZipFileAccess;
import xps.model.document.IDocumentReference;

public class FontLoader extends CachingResourceLoader<Font>{
	public FontLoader(IDocumentReference docRef, XPSZipFileAccess access){
		super(docRef, access);
	}

	@Override
	protected Font loadData(String uri) throws Exception {
		byte fontData[] = getFileAccess().getFontData(uri, getDocument());
		return Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(fontData));
	}
}
