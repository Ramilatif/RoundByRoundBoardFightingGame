public class ExceptionOverlayplayer extends Exception{
    public static final long serialVersionUID = 1L;

    public  ExceptionOverlayplayer(){
        super("Il y a deja un joueur sur cette case");
    }
}
