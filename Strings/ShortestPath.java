package Strings;

public class ShortestPath {
    public static int getShortestPath(String path){
        float x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            //south
            if(dir=='S'){
                y--;
            }
            //North
            else if(dir=='N'){
                y++;
            }
            //West
            else if(dir=='W'){
                x--;
            }
            //East
            else{
                x++;
            }
        }
        float x2=x*x;
        float y2=y*y;
        return (int)(Math.sqrt(x2+y2));
    }
    public static void main(String[] args) {
        String str="WNEENESENNN";
        System.out.println(getShortestPath(str));
    }
}
