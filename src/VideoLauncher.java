import java.util.Scanner;
class VideoLauncher{
   
    public static void main(String[] args) {
       
        VideoStore object = new VideoStore();
        int value;
        String videoName;
        int rating;
        boolean flag = true;
        while(flag)
        {
        System.out.println("MAIN MENU");
        System.out.println("=========");
        System.out.println("1.Add Videos:");
        System.out.println("2.Check Out Videos:");
        System.out.println("3.Return Videos:");
        System.out.println("4.Receive Rating:");
        System.out.println("5.List Inventory:");
        System.out.println("6.Exit");
        System.out.println("Enter your choice(1.6):");
        Scanner obj = new Scanner(System.in);
        value = obj.nextInt();
        switch(value)
        {
        case 1:
            {
                System.out.println("Please enter the name of Video");
                videoName = obj.nextLine();
                object.addVideo(videoName);
                break;
              
            }
           
        case 2:
        {
           
            System.out.println("Please enter the name of Video");
            videoName = obj.nextLine();
            object.doCheckOut(videoName);
            break;
        }
        case 3:
        {
            System.out.println("Please enter the name of Video");
            videoName = obj.nextLine();
            object.doReturn(videoName);
            break;
        }
        case 4:
        {
            System.out.println("Please enter the rating value for the Video");
            rating = obj.nextInt();
            System.out.println("Please enter the name of Video");
            videoName = obj.nextLine();
            object.receiveRating(videoName, rating);
            break;
        }
        case 5:
        {
            object.listInventory();
            break;
        }
        case 6:
        {
            flag = false;
            break;
        }
        default:
        {
            System.out.println("no such item exits");
        }
               
        }
    }
  }
}
class Video
{
    String videoName;
    boolean checkOut;
    int rating;
   
    String getName()
    {
        return videoName;
       
    }
   
    void doCheckOut()
    {
        checkOut = true;
       
    }
   
    void doReturn()
    {
        checkOut = false;
    }
   
    void receiveRating(int rating)
    {
        this.rating = rating;
    }
   
    int getRating()
    {
        return rating;
    }
   
    boolean getCheckOut()
    {
        return checkOut;
    }
   
    public Video (String videoName)
    {
        this.videoName = videoName;
    }
}
class VideoStore
{
    Video store[]= new Video[10];
    static int i=0;
    void addVideo(String name)
    {
        store[i] = new Video(name);
        store[i].checkOut = false;
        store[i].receiveRating(0);
        System.out.println("video added sucessfully");
        System.out.println(store[i].getName()+ " " + i);
        i++;
    }
   void doCheckOut(String name)
    {
        int j;
        for(j = 0; j<i;j++)
        {
            if(store[j].getName().equals(name))
            store[j].doCheckOut();
        }
    }
    void doReturn(String name)
    {
        int j;
        for(j = 0; j<i;j++)
        {
            if(store[j].getName().equals(name))
            store[j].doReturn();
        }
    }
   
    void receiveRating(String name, int rating)
    {
        int j;
        for(j = 0; j<i;j++)
        {
            if(store[j].getName().equals(name))
            {
                store[j].receiveRating(rating);
            }
        }
    }
    void  listInventory()
    {
        int j ;
        for(j = 0; j<i;j++)
        {
            if(!store[j].getCheckOut())
            {
                System.out.print(store[j].videoName+" ");
                System.out.print(store[j].getCheckOut()+" ");
                System.out.print(store[j].getRating());
                System.out.println();
            }
        }
    }
}