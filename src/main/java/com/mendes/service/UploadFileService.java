package com.mendes.service;

import com.mendes.model.Organization;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mendesmustafa on 11.03.2021.
 */

@Service
public class UploadFileService {


    public List<Organization> readFile(InputStream inputStream) {

        List<Organization> list = new ArrayList<Organization>();

        try {

            Workbook workbook = new HSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = (Row) rows.next();

                //head okunmadı
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator cellsInRow = currentRow.iterator();
                Organization organization = new Organization();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = (Cell) cellsInRow.next();
                    if (cellIndex == 0) {
                        organization.setType(currentCell.getStringCellValue());
                    } else if (cellIndex == 1) {
                        organization.setData(currentCell.getStringCellValue());
                    } else {
                        System.out.println("index bulunamadı: " + currentCell.getStringCellValue());
                    }
                    cellIndex++;
                }
                list.add(organization);
            }
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}