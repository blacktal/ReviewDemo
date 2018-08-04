package ch22;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: FileDemo 
 * @Description: TODO 
 * @author Lulu
 * @date 2018年7月31日 下午7:23:12 
 */
public class FileDemo {
    public static void main(String[] args) {
        // 递归遍历全目录
//        File file = new File("d:\\test");
//        String[] fileNames = file.list();
//        for (String fileName : fileNames) {
//            System.out.print(fileName + " ");
//        }
//        System.out.println();
//        System.out.println("============递归遍历============");
//        fileTraverse(file, 0);
//        System.out.println("============找到.java文件============");
//        fileFilter(file);
//        System.out.println("============复制文件=============");
        // 把a.txt中的内容复制到b.txt中
        File fromFile = new File("d:\\test\\a.txt");
        File toFile = new File("d:\\test\\b.txt");
        FileInput(fromFile);
        FileOutput(toFile);
        
        
    }
    
    /**   
     * @Title: FileOutput   
     * @Description: 将byte[]字节数组中的内容输出到文件中
     * @param: @param file      
     * @return: void      
     * @throws   
     */  
    public static void FileOutput(File file) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            byte[] b = {'a','b','c', 106, 107};
            fos.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // 没有继续执行的必要了，所以抛一个运行时异常终止程序
            throw new RuntimeException("文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("I/O出错！");
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    /**   
     * @Title: FileInput   
     * @Description: 读取文件中的内容，打印到控制台   
     * @param: @param inFile      
     * @return: void      
     * @throws   
     */  
    public static void FileInput(File file) {
        if (file.exists() && file.isFile()) {
            byte[] in = new byte[1024];
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                int len = 0;
                while ((len  = fis.read(in)) != -1) {
                    System.out.print(new String(in, 0, len));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // 找不到文件，没有往下执行程序的必要，直接抛运行时异常终止程序
                throw new RuntimeException("找不到指定文件！");
            } catch (IOException e) {
                e.printStackTrace();
                // io失败，没有往下执行的必要
                throw new RuntimeException("I/O操作失败！");
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    
    /**   
     * @Title: fileFilter   
     * @Description: 自定义file过滤器   
     * @param: @param file      
     * @return: void      
     * @throws   
     */  
    public static void fileFilter(File file) {
        if (!file.exists()) {
            System.out.println("目录不存在！");
        } else {
            MyFileFilter filter = new MyFileFilter();
            if (file.isDirectory()) {
                // 如果是文件夹，打印该文件夹下的.java文件
                File[] filteredFiles = file.listFiles(filter);
                for (File result : filteredFiles) {
                    System.out.println(result.getAbsolutePath());
                }
                // 继续扫描文件夹下的全部文件，找到文件夹进行递归
                File[] files = file.listFiles();
                for (File aFile : files) {
                    if (aFile.isDirectory()) {
                        fileFilter(aFile);
                    }
                }
            }
        }
    }
    
    
    /**   
     * @Title: fileTraverse   
     * @Description: 递归遍历文件夹中的全部文件和子文件夹   
     * @param: @param file
     * @param: @param depth      
     * @return: void      
     * @throws   
     */  
    public static void fileTraverse(File file, int depth) {
        // 定义depth变量，用于记录当前文件夹是第几层
        int currentDepth = depth;
        if (file.exists()) {
            for (int i = 0; i < currentDepth; i++) {
                System.out.print("  ");
            }
            System.out.print("|--");
            System.out.println(file.getName());
            File[] files = file.listFiles();
            currentDepth ++;
            for (File listedFile : files) {
                if (listedFile.isFile()) {
                    for (int i = 0; i < currentDepth; i++) {
                        System.out.print("  ");
                    }
                    System.out.print("|--");
                    System.out.println(listedFile.getName());
                } else if (listedFile.isDirectory()) {
                    fileTraverse(listedFile, currentDepth);
            }
            }
        }
    }

}
