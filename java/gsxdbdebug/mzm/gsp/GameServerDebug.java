/*    */ package mzm.gsp;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class GameServerDebug {
/*    */   public static void main(String[] args) {
/*  7 */     try { File f = new File("xdb\\xdb.inuse");
/*  8 */       if (f.exists()) {
/*  9 */         f.delete();
/*    */       }
/*    */     }
/*    */     catch (SecurityException e) {}
/*    */     
/* 14 */     GameServer.main(args);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\GameServerDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */