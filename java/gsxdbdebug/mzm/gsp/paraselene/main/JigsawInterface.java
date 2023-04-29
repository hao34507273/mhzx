/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.paraselene.event.JigsawContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JigsawInterface
/*    */ {
/*    */   public static void startJigsaw(List<Long> roleids, int jigsawcfgid, JigsawContext context)
/*    */   {
/* 18 */     JigsawManager.startJigsaw(roleids, jigsawcfgid, context);
/*    */   }
/*    */   
/*    */   public static void stopJigsaw(long roleid, boolean issuccess)
/*    */   {
/* 23 */     JigsawManager.stopJigsaw(roleid, issuccess);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\JigsawInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */