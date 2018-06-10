package dragon.worldadventure.Objects;

import dragon.worldadventure.Objects.Hero;
import dragon.worldadventure.Objects.Level;
import dragon.worldadventure.Objects.User;
import dragon.worldadventure.Objects.UserHero;

public class AppData {


    public static User user = null;
    public static Hero hero = null;
    public static Level level = null;
    public static Stats stats = null;
    public static Villan villan=null;
    //----------------------------------------------------------------------seleção de heroi
    public static UserHero userHero1=null;
    public static UserHero userHero2=null;
    public static UserHero userHero3=null;
    public static Hero herotab1=null;
    public static Hero herotab2=null;
    public static Hero herotab3=null;
    public static Level leveltab1=null;
    public static Level leveltab2=null;
    public static Level leveltab3=null;
    public static Stats stats1=null;
    public static Stats stats2=null;
    public static Stats stats3=null;
    public static boolean existstab1=false;
    public static boolean existstab2=false;
    public static boolean existstab3=false;
    public static boolean createtab1=false;
    public static boolean createtab2=false;
    public static boolean createtab3=false;
    public static boolean selectedherotab1=false;
    public static boolean selectedherotab2=false;
    public static boolean selectedherotab3=false;
    //--------------------------------------------------------------------------criação de herois
    public static  Hero warrior=null;
    public static  Hero priest=null;
    public static  Hero mage=null;
    public static  Hero paladin=null;
    public static  Hero archer=null;
    //--------------------------------------------------------------------------------travel
    public static  double stepxp=0;
    public static boolean enemy=false;

}
