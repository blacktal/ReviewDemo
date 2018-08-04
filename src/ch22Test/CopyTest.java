package ch22Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTest {
    public static void main(String[] args) {
        File fromFile = new File("d:\\test\\from.txt");
        File toFile = new File("d:\\test\\to.txt");
//        copy(fromFile, toFile);
//        copyByArray(fromFile, toFile);
//        copyByChar(fromFile, toFile);
//        bufferedCopy(fromFile, toFile);
        bufferedCopyByChar(fromFile, toFile);
    }
    
    
    /**   
     * @Title: bufferedCopy   
     * @Description: 使用缓冲字节流进行文件复制
     * @param: @param fromFile      
     * @return: void      
     * @throws   
     */  
    public static void bufferedCopy(File fromFile, File toFile) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(fromFile));
            bos = new BufferedOutputStream(new FileOutputStream(toFile));
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bos != null) {
                        try {
                            bos.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    /**   
     * @Title: bufferedCopyByChar   
     * @Description: 缓冲字符流实现文件复制
     * @param: @param fromFile
     * @param: @param toFile      
     * @return: void      
     * @throws   
     */  
    public static void bufferedCopyByChar(File fromFile, File toFile) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
             br = new BufferedReader(new FileReader(fromFile));
             bw = new BufferedWriter(new FileWriter(toFile));
             String line = null;
             while((line = br.readLine()) != null) {
                 // 写入读出的一行，不包括换行符标志
                 bw.write(line);
                 // 写入换行！！！
                 bw.newLine();
             }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    /**   
     * @Title: copyByChar   
     * @Description: 通过字符流复制文本文件   
     * @param: @param fromFile
     * @param: @param toFile      
     * @return: void      
     * @throws   
     */  
    public static void copyByChar(File fromFile, File toFile) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(fromFile);
            fw = new FileWriter(toFile);
            char[] cbuf = new char[1024];
//            fw.write("你好");
            int len = 0;
            while ((len = fr.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, len));
                fw.write(cbuf, 0, len);
                // 必须flush()一下
                fw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("复制文件失败！");
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    /**   
     * @Title: copy   
     * @Description: 字节流读取单个字节复制文件   
     * @param: @param fromFile
     * @param: @param toFile      
     * @return: void      
     * @throws   
     */  
    public static void copy(File fromFile, File toFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fromFile);
            fos = new FileOutputStream(toFile);
            int len = 0;
            while ((len = fis.read()) != -1) {
                // fromFile中读出来的数据立刻写入toFile
                fos.write(len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    /**   
     * @Title: copyByArray   
     * @Description: 字节流读取字节数组来复制文件   
     * @param: @param fromFile
     * @param: @param toFile      
     * @return: void      
     * @throws   
     */  
    public static void copyByArray (File fromFile, File toFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fromFile);
            fos = new FileOutputStream(toFile);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                // 从0开始，写每次读到的字节个数len
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("复制文件失败！");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // finally里嵌套finally，保证两个finally关流操作都执行到
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } 
        }
    }

}
