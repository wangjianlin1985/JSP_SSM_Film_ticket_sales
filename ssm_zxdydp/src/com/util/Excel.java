// 
// 
// 

package com.util;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WritableCell;
import jxl.write.Label;
import jxl.Workbook;
import java.io.File;
import java.util.List;

public class Excel
{
    public String getExcel(final List<String[]> strList, final String[] strTitle, final String banner, final String paths) {
        final String fp = "upfiles\\" + VeDate.getStringDatex() + ".xls";
        final String filepath = String.valueOf(paths) + fp;
        try {
            final WritableWorkbook book = Workbook.createWorkbook(new File(filepath));
            final WritableSheet sheet = book.createSheet(banner, 0);
            for (int i = 0; i < strTitle.length; ++i) {
                sheet.addCell((WritableCell)new Label(i, 0, strTitle[i]));
            }
            for (int i = 0; i < strList.size(); ++i) {
                final String[] str = strList.get(i);
                for (int j = 0; j < str.length; ++j) {
                    try {
                        final Label label = new Label(j, i + 1, str[j]);
                        sheet.addCell((WritableCell)label);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            book.write();
            book.close();
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return fp;
    }
}
