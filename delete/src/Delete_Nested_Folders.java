import java.io.File;
import java.util.Scanner;  
public class Delete_Nested_Folders {  
    static int times = 0;
    public static void main(String[] args) {  
        Scanner rd = new Scanner(System.in);
        
        System.out.println("please enter the path u want to delete");
        String dPath = rd.nextLine();
        dPath.trim();
        char[] aim = new char[dPath.length()-2];
        for(int i =0;i<dPath.length()-2;i++){
            aim[i] = dPath.charAt(i+1); 
        }
        String ans = new String(aim);
        File directory = new File(ans);  
        
        if (directory.exists() && directory.isDirectory()||directory.exists()&& directory.isFile()) {  
            deleteDirectory(directory);  
            System.out.println("success");  
        } else {  
            System.out.println("-1");  
        }  
    }  
  
    static void deleteDirectory(File dir) { 
        
        System.out.println("searching,depth:"+times);
        times++; 
        File[] files = dir.listFiles();  
        if (files != null) {  
            for (File file : files) {  
                if (file.isDirectory()) { 
                     
                    deleteDirectory(file);  

                } else {  
                    file.delete();  
                }  
            }  
        }  
        dir.delete();  
    }  
}