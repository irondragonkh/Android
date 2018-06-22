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
    //----------------------------------------------------------------------para usar durante o jogo
    public static UserHero selectedusedhero=null;
    public static Hero  selectedhero=null;
    public static Stats selectedstats=null;
    public static Level selectedlevel=null;
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
    //--------------------------------------------------------------------------criação de herois
    public static  Hero warrior=null;
    public static  Hero priest=null;
    public static  Hero mage=null;
    public static  Hero paladin=null;
    public static  Hero archer=null;
    //--------------------------------------------------------------------------------travel
    public static  double stepxp=0;
    public static boolean enemy=false;
    public static boolean levelup=false;
    public static double expparanextlevel=0;
    //-------------------------------------------------------------------------------battle
    public static double currenthp=0;//variavel de batalha da vida do heroi
    public static double currenthpvillan=0;//variavel de batalha da vida do vilao
    public static double heromaxhealth=0,villanmaxhealth=0;
    public static double herodefense=0;
    public static double villandefense=0;
    public static double herolosedefence=0,villanlosedefence=0,heroregainhealth=0,villanregainhealth=0,herodmg=0,villandmg=0;
    public static boolean herocrit=false,villancrit=false;
}
