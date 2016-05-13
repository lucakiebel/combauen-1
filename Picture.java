import greenfoot.*;
import java.awt.Color;
/**
 * This class helps to handle with Images
 * 
 * @author (Moritz L.) 
 * @version (11.02.2012)
 */
public class Picture  
{
    public static GreenfootImage drawColorOverImage(Color Col,String Image)
    {
        return drawColorOverImage(Col,new GreenfootImage(Image));
    }

    public static GreenfootImage drawColorOverImage(Color Col,GreenfootImage i)
    {
        GreenfootImage i2 = new GreenfootImage(i);
        i=new GreenfootImage(i2);
        i.setColor(Col);
        i.fill();
        for(int x=0; x<i.getWidth(); x++)
            for(int y=0;y<i.getHeight();y++)
            {
                Color
                C2 = i2.getColorAt(x,y),
                C  = i.getColorAt(x,y);
                i2.setColorAt(x,y, new Color(C.getRed(),C.getGreen(),C.getBlue(),C2.getAlpha()));
        }
        return i2;
    }

    public static GreenfootImage getTextWithMaxWidthInMiddle(String Text,int MaxWidth,int FontSize,Color FrontCol, Color BackCol)
    {
        Color[] Colors = {FrontCol,BackCol};
        String[] TArr = Text.split(" ");
        if(TArr.length==0)
        {
            return new GreenfootImage("",FontSize,Colors[0],Colors[1]);
        }
        GreenfootImage Image1 = new GreenfootImage(TArr[0],FontSize,Colors[0],Colors[1]);
        if(TArr.length==1)
        {
            return Image1;
        }
        GreenfootImage Image2;
        GreenfootImage Image = new GreenfootImage(MaxWidth,1);
        Text=TArr[0];
        for(int i=1; i<TArr.length;i++)
        {
            Image2=new GreenfootImage(Text+" "+TArr[i],FontSize,Colors[0],Colors[1]);
            if(Image2.getWidth()>=MaxWidth)
            {
                int h = Image.getHeight();
                if(h==1)
                    h=0;
                GreenfootImage i2 = Image;
                Image=new GreenfootImage(MaxWidth,h+Image1.getHeight());
                Image.drawImage(i2,0,0);
                Image.drawImage(Image1,Image.getWidth()/2-Image1.getWidth()/2,h);
                Text=TArr[i];
                Image1=new GreenfootImage(Text,FontSize,Colors[0],Colors[1]);
            }
            else
            {
                Text+=" "+TArr[i];
                Image1=Image2;
            }
        }
        Image2=new GreenfootImage(Text,FontSize,Colors[0],Colors[1]);
        int h = Image.getHeight();
        if(h==1)
            h=0;
        GreenfootImage i2 = Image;
        Image=new GreenfootImage(MaxWidth,h+Image1.getHeight());
        Image.drawImage(i2,0,0);
        Image.drawImage(Image1,Image.getWidth()/2-Image1.getWidth()/2,h);
        return Image;
    }

    public static GreenfootImage getTextWithMaxWidth(String Text,int MaxWidth,int FontSize,Color FrontCol, Color BackCol)
    {
        Color[] Colors = {FrontCol,BackCol};
        String[] TArr = Text.split(" ");
        if(TArr.length==0)
        {
            return new GreenfootImage("",FontSize,Colors[0],Colors[1]);
        }
        GreenfootImage Image1 = new GreenfootImage(TArr[0],FontSize,Colors[0],Colors[1]);
        if(TArr.length==1)
        {
            return Image1;
        }
        GreenfootImage Image2;
        GreenfootImage Image = new GreenfootImage(MaxWidth,1);
        Text=TArr[0];
        for(int i=1; i<TArr.length;i++)
        {
            Image2=new GreenfootImage(Text+" "+TArr[i],FontSize,Colors[0],Colors[1]);
            if(Image2.getWidth()>=MaxWidth)
            {
                int h = Image.getHeight();
                if(h==1)
                    h=0;
                GreenfootImage i2 = Image;
                Image=new GreenfootImage(MaxWidth,h+Image1.getHeight());
                Image.drawImage(i2,0,0);
                Image.drawImage(Image1,0,h);
                Text=TArr[i];
                Image1=new GreenfootImage(Text,FontSize,Colors[0],Colors[1]);
            }
            else
            {
                Text+=" "+TArr[i];
                Image1=Image2;
            }
        }
        Image2=new GreenfootImage(Text,FontSize,Colors[0],Colors[1]);
        int h = Image.getHeight();
        if(h==1)
            h=0;
        GreenfootImage i2 = Image;
        Image=new GreenfootImage(MaxWidth,h+Image1.getHeight());
        Image.drawImage(i2,0,0);
        Image.drawImage(Image1,0,h);
        return Image;
    }

    public static GreenfootImage fillWithImage(int width, int height, String Image)
    {
        return drawInVerticallyLine(drawInHorizontallyLine(new GreenfootImage(Image),width),height);
    }

    public static GreenfootImage fillWithImage(int width, int height, GreenfootImage Image)
    {
        return drawInVerticallyLine(drawInHorizontallyLine(Image,width),height);
    }

    public static int[] getSizeForTextInField(String []Text,int BoardPartSize,int TextSize)
    {
        GreenfootImage[] i = new GreenfootImage[Text.length]; 
        i[0] = new GreenfootImage(Text[0],TextSize,Color.black,new Color(0,0,0,0));
        int w = i[0].getWidth();
        for(int a=1;a<i.length;a++)
        {
            i[a] = new GreenfootImage(Text[a]+"",TextSize,Color.black,new Color(0,0,0,0));
            int w2=i[a].getWidth();
            if(w2>w)
                w=w2;
        }
        int h = 0;
        for(int a = 0; a<i.length; a++)
        {
            h+=i[a].getHeight();
        }
        return new int[]{w+BoardPartSize*2,h+BoardPartSize*2};
    }

    public static GreenfootImage getTextInField(String BoardParts,String []Text,int TextSize)
    {
        return getTextInField(new GreenfootImage(BoardParts),10,Text,TextSize);
    }

    public static GreenfootImage getTextInField(String BoardParts,int BoardPastSize,String []Text,int TextSize)
    {
        return getTextInField(new GreenfootImage(BoardParts),BoardPastSize,Text,TextSize);
    }

    public static GreenfootImage getTextInField(GreenfootImage BoardParts,int BoardPartSize,String []Text,int TextSize)
    {
        return getTextInField(BoardParts,BoardPartSize,Text,TextSize,Color.black);
    }

    public static GreenfootImage getTextInField(String BoardParts,int BoardPartSize,String []Text,int TextSize,Color StringColor)
    {
        return getTextInField(new GreenfootImage(BoardParts),BoardPartSize,Text,TextSize,StringColor);
    }

    public static GreenfootImage getTextInField(GreenfootImage BoardParts,int BoardPartSize,String []Text,int TextSize,Color StringColor)
    {
        GreenfootImage[] i = new GreenfootImage[Text.length]; 
        i[0] = new GreenfootImage(Text[0],TextSize,StringColor,new Color(0,0,0,0));
        int w = i[0].getWidth();
        for(int a=1;a<i.length;a++)
        {
            i[a] = new GreenfootImage(Text[a]+"",TextSize,StringColor,new Color(0,0,0,0));
            int w2=i[a].getWidth();
            if(w2>w)
                w=w2;
        }
        int h = 0;
        for(int a = 0; a<i.length; a++)
        {
            h+=i[a].getHeight();
        }
        GreenfootImage b = Board(BoardParts,BoardPartSize,w+BoardPartSize*2,h+BoardPartSize*2);
        h=0;
        for(int a = 0; a<i.length; a++)
        {
            b.drawImage(i[a],w/2+BoardPartSize-i[a].getWidth()/2,BoardPartSize+h);
            h+=i[a].getHeight();
        }
        return b;
    }

    public static GreenfootImage Board(String BoardParts,int BoardPartSize,int width,int height)
    {
        return Board(new GreenfootImage(BoardParts),BoardPartSize,width,height);
    }

    public static GreenfootImage Board(GreenfootImage BoardParts,int BoardPartSize,int width,int height)
    {
        if(width<BoardPartSize*2)
            width=BoardPartSize*2;
        int a=width;
        width = width%BoardPartSize;
        if(width>0)
        {
            a+=(BoardPartSize-width);
        }
        if(height<BoardPartSize*2)
            height=BoardPartSize*2;
        int b=height;
        height=height%BoardPartSize;
        if(height>0)
        {
            b+=(BoardPartSize-height);
        }
        GreenfootImage i = new GreenfootImage(a,b);
        i.drawImage(TopLine(BoardParts,BoardPartSize,a),0,0);
        i.drawImage(DownLine(BoardParts,BoardPartSize,a),0,b-BoardPartSize);
        b-=BoardPartSize*2;
        GreenfootImage c = MiddleLine(BoardParts,BoardPartSize,a);
        while(b>0)
        {
            i.drawImage(c,0,b);
            b-=BoardPartSize;
        }
        return i;
    }

    private static GreenfootImage TopLine(GreenfootImage BoardParts,int BoardPartSize,int width)
    {
        GreenfootImage []Parts = {BoardParts};
        GreenfootImage []Boardparts = 
            {
                Picture.ShowPartOf(Parts[0], 0, 0,BoardPartSize,BoardPartSize),
                Picture.ShowPartOf(Parts[0],BoardPartSize*2, 0,BoardPartSize,BoardPartSize),
                Picture.ShowPartOf(Parts[0],BoardPartSize, 0,BoardPartSize,BoardPartSize),
            };
        if(width<BoardPartSize*2)
            width=BoardPartSize*2;
        int a=width;
        width=width%BoardPartSize;
        if(width>0)
        {
            a+=(BoardPartSize-width);
        }
        GreenfootImage i = new GreenfootImage(a,BoardPartSize);
        i.drawImage(Boardparts[0],0,0);
        i.drawImage(Boardparts[1],a-BoardPartSize,0);
        a-=BoardPartSize*2;
        while(a>0)
        {
            i.drawImage(Boardparts[2],a,0);
            a-=BoardPartSize;
        }
        return i;
    }

    private static GreenfootImage MiddleLine(GreenfootImage BoardParts,int BoardPartSize,int width)
    {
        GreenfootImage []Parts = {BoardParts};
        GreenfootImage []Boardparts = 
            {
                Picture.ShowPartOf(Parts[0], 0,BoardPartSize,BoardPartSize,BoardPartSize),
                Picture.ShowPartOf(Parts[0],BoardPartSize*2,BoardPartSize,BoardPartSize,BoardPartSize),
                Picture.ShowPartOf(Parts[0],BoardPartSize,BoardPartSize,BoardPartSize,BoardPartSize),
            };
        if(width<BoardPartSize*2)
            width=BoardPartSize*2;
        int a=width;
        width = width%BoardPartSize;
        if(width>0)
        {
            a+=(BoardPartSize-width);
        }
        GreenfootImage i = new GreenfootImage(a,BoardPartSize);
        i.drawImage(Boardparts[0],0,0);
        i.drawImage(Boardparts[1],a-BoardPartSize,0);
        a-=BoardPartSize*2;
        while(a>0)
        {
            i.drawImage(Boardparts[2],a,0);
            a-=BoardPartSize;
        }
        return i;
    }

    private static GreenfootImage DownLine(GreenfootImage BoardParts,int BoardPartSize,int width)
    {
        GreenfootImage []Parts = {BoardParts};
        GreenfootImage []Boardparts = 
            {
                Picture.ShowPartOf(Parts[0], 0,BoardPartSize*2,BoardPartSize,BoardPartSize),
                Picture.ShowPartOf(Parts[0],BoardPartSize*2,BoardPartSize*2,BoardPartSize,BoardPartSize),
                Picture.ShowPartOf(Parts[0],BoardPartSize,BoardPartSize*2,BoardPartSize,BoardPartSize),
            };
        if(width<BoardPartSize*2)
            width=BoardPartSize*2;
        int a=width;
        width=width%BoardPartSize;
        if(width>0)
        {
            a+=(BoardPartSize-width);
        }
        GreenfootImage i = new GreenfootImage(a,BoardPartSize);
        i.drawImage(Boardparts[0],0,0);
        i.drawImage(Boardparts[1],a-BoardPartSize,0);
        a-=BoardPartSize*2;
        while(a>0)
        {
            i.drawImage(Boardparts[2],a,0);
            a-=BoardPartSize;
        }
        return i;
    }

    public static void PrintCodeOf(String Image)
    {
        GreenfootImage i = new GreenfootImage(Image);
        System.out.println("GreenfootImage I = new GreenfootImage("+i.getWidth()+","+i.getHeight()+");");
        for(int x=0;x<i.getWidth();x++)
            for(int y=0;y<i.getHeight();y++)
                if(i.getColorAt(x,y).getAlpha()!=0)
                    System.out.println("I.setColorAt("+x+","+y+",new Color("+i.getColorAt(x,y).getRed()+","+i.getColorAt(x,y).getGreen()+","+i.getColorAt(x,y).getBlue()+","+i.getColorAt(x,y).getAlpha()+"));");
    }

    public static GreenfootImage ShowPartOf(String i, int x, int y, int width, int height)
    {
        return ShowPartOf(new GreenfootImage(i),x,y,width,height);
    }

    public static GreenfootImage ShowPartOf(GreenfootImage i, int x, int y, int width, int height)
    {
        GreenfootImage b = new GreenfootImage(width,height);
        b.drawImage(i,-x,-y);
        return b;
    }

    public static GreenfootImage getGermanFlag(int width, int height)
    {
        if(width<1 || height<3)
            return null;
        GreenfootImage Flag= new GreenfootImage(width,height);
        Flag.setColor(Color.black);
        Flag.fillRect(0,0,width,height/3);
        Flag.setColor(Color.red);
        Flag.fillRect(0,height/3,width,height/3);
        Flag.setColor(Color.yellow);
        Flag.fillRect(0,height/3*2,width,height/3);
        return Flag;
    }

    public static GreenfootImage getEnglandFlag(int width, int height)
    {
        if(width<5 || height<5)
            return null;
        GreenfootImage Flag= new GreenfootImage(width,height);
        Flag.setColor(Color.blue);
        Flag.fill();
        Flag.setColor(Color.white);
        int h=-(width+height)/18;
        while(h<=(width+height)/18)
        {
            Flag.drawLine(h,0,width+h,height);
            Flag.drawLine(h,height,width+h,0);
            h++;
        }
        Flag.setColor(Color.red);
        h=-(width+height)/45;
        while(h<=(width+height)/45)
        {
            Flag.drawLine(h,0,width+h,height);
            Flag.drawLine(h,height,width+h,0);
            h++;
        }
        Flag.setColor(Color.white);
        h=-(int)(0.5+(6.0/75.0)*height);
        while(h<=(int)(0.5+(6.0/75.0)*height))
        {
            Flag.drawLine(0,height/2-h,width,height/2-h);
            h++;
        }
        h=-(int)(0.5+(12.0/300)*width);
        while(h<=(int)(0.5+(12.0/300)*width))
        {
            Flag.drawLine(width/2-h,0,width/2-h,height);
            h++;
        }
        Flag.setColor(Color.red);
        h=-(int)(0.5+(7.0/150.0)*height);
        while(h<=(int)(0.5+(7.0/150.0)*height))
        {
            Flag.drawLine(0,height/2-h,width,height/2-h);
            h++;
        }
        h=-(int)(0.5+(7.0/300.0)*width);
        while(h<=(int)(0.5+(7.0/300.0)*width))
        {
            Flag.drawLine(width/2-h,0,width/2-h,height);
            h++;
        }
        return Flag;
    }

    public static GreenfootImage SetAlpha(GreenfootImage Image, int Alpha)
    {
        int red=0;
        int green=0;
        int blue=0;
        GreenfootImage img = new GreenfootImage(Image);
        for(int x=0; x<img.getWidth();x++){
            for(int y=0; y<img.getHeight();y++){
                Color pixel = img.getColorAt(x,y);
                int alpha=(int)(((double)pixel.getAlpha()/255*(double)Alpha/255)*255);
                if(alpha!=0)
                {
                    red = pixel.getRed();
                    green = pixel.getGreen();
                    blue = pixel.getBlue();
                }
                img.setColorAt(x,y,new Color(red,green,blue,alpha));
            }
        }
        return img;
    }

    public static GreenfootImage drawInVerticallyLine(GreenfootImage i,int width)
    {
        GreenfootImage i2 = new GreenfootImage(width,i.getHeight());
        for(int x = 0; x<width; x+=i.getWidth())
        {
            i2.drawImage(i,x,0);
        }
        return i2;
    }

    public static GreenfootImage drawInHorizontallyLine(GreenfootImage i,int height)
    {
        GreenfootImage i2 = new GreenfootImage(i.getWidth(),height);
        for(int y = 0; y<height; y+=i.getHeight())
        {
            i2.drawImage(i,0,y);
        }
        return i2;
    }

    public static GreenfootImage drawInMiddle(GreenfootImage i,GreenfootImage b)
    {
        return DrawInMiddle(i,b);
    }

    public static GreenfootImage DrawInMiddle(GreenfootImage i,GreenfootImage b)
    {
        b = new GreenfootImage(b);
        b.drawImage(i,b.getWidth()/2-i.getWidth()/2,b.getHeight()/2-i.getHeight()/2);
        return new GreenfootImage(b);
    }

    public static GreenfootImage BlackText(String s, int size)
    {
        return new GreenfootImage(s,size,Color.black,new Color(0,0,0,0));
    }

    public static GreenfootImage BlackText(int s, int size)
    {
        return BlackText(""+s,size);
    }

    public static GreenfootImage BlackText(double s, int size)
    {
        return BlackText(""+s,size);
    }

    private static boolean AllValuesSame(double [] s)
    {
        if(s.length<=0)
        {return true;}
        double c=s[0];
        for(int a=1;a<s.length;a++)
        {
            if(c!=s[a])
            {
                return false;
            }
        }
        return true;
    }

    public static GreenfootImage drawImageOn(GreenfootImage i,GreenfootImage b,int x, int y)
    {
        i.drawImage(b,x,y);
        return i;
    }

    public static GreenfootImage drawTogether(GreenfootImage i,GreenfootImage b)
    {
        b = new GreenfootImage(b);
        b.drawImage(i,0,0);
        return new GreenfootImage(b);
    }

    public static GreenfootImage scale(GreenfootImage i, int x, int y)
    {
        i=new GreenfootImage(i);
        i.scale(x,y);
        return i;
    }

    public static GreenfootImage scaleToMax(GreenfootImage i, int width)
    {
        return scaleToMax(i, width, width);
    }

    public static GreenfootImage scaleToMax(GreenfootImage i, int width,int height)
    {
        i=new GreenfootImage(i);
        int w = i.getWidth(),h = i.getHeight();
        if(w<width && h<height)
        {
            return i;
        }
        double precent;
        if(w>h)
            precent = (double)w/(double)width;
        else
            precent = (double)h/(double)height;
        i.scale((int)(precent*w),(int)(precent*h));
        return i;
    }

    public static GreenfootImage changeColor(String Image, Color newCol)
    {
        return ChangeColor(Image,newCol);
    }

    public static GreenfootImage changeColor(GreenfootImage Image, Color newCol)
    {
        return ChangeColor(Image,newCol);
    }

    public static GreenfootImage ChangeColor(String Image, Color newCol)
    {
        return ChangeColor(new GreenfootImage(Image),newCol);
    }

    public static GreenfootImage ChangeColor(GreenfootImage Image, Color newCol)
    {
        int red=0;
        int green=0;
        int blue=0;
        GreenfootImage img = new GreenfootImage(Image);
        for(int x=0; x<img.getWidth();x++){
            for(int y=0; y<img.getHeight();y++){
                Color pixel = img.getColorAt(x,y);
                int alpha=(int)(((double)pixel.getAlpha()/255*(double)newCol.getAlpha()/255)*255);
                if(alpha!=0){
                    double intensity = ((double)(pixel.getGreen()) + (double)(pixel.getRed()) + (double)(pixel.getBlue())) / (3*255);
                    red = (int)(newCol.getRed()*intensity);
                    if(red > 255) red = 255;
                    green = (int)(newCol.getGreen()*intensity);
                    if(green > 255) green = 255;
                    blue = (int)(newCol.getBlue()*intensity);
                    if(blue > 255) blue = 255;}
                img.setColorAt(x,y,new Color(red,green,blue,alpha));
            }
        }
        return img;
    }

    public static GreenfootImage ChangeCompleteColor(GreenfootImage Image, Color newCol)
    {
        GreenfootImage img = new GreenfootImage(Image.getWidth(),Image.getHeight());
        for(int x=0; x<img.getWidth();x++){
            for(int y=0; y<img.getHeight();y++){
                int alpha=Image.getColorAt(x,y).getAlpha();
                if(alpha!=0){
                    img.setColorAt(x,y,new Color(newCol.getRed(),newCol.getGreen(),newCol.getBlue(),alpha));
                }
            }
        }
        return img;
    }
}
