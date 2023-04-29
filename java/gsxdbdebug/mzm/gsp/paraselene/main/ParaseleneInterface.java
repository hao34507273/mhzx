/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Paraselene;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParaseleneInterface
/*    */ {
/*    */   public static int getRoleFinishtime(long roleid)
/*    */   {
/* 20 */     return ParaseleneManager.getRoleFinishtime(roleid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long getParaseleneStartTime()
/*    */   {
/* 30 */     return ActivityInterface.getActivityStartTime(SParaseleneCfgConsts.getInstance().ActivityId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void insertIntoRankForIdip(long roleid, int seconds)
/*    */   {
/* 45 */     new InsertIntoRankPro(roleid, seconds).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class InsertIntoRankPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final int seconds;
/*    */     
/*    */     public InsertIntoRankPro(long roleid, int seconds)
/*    */     {
/* 57 */       this.roleid = roleid;
/* 58 */       this.seconds = seconds;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 64 */       long starttime = ParaseleneManager.getActivityStartTime();
/* 65 */       Paraselene xParaselene = Role2paraselene.get(Long.valueOf(this.roleid));
/* 66 */       if (xParaselene == null)
/*    */       {
/* 68 */         return false;
/*    */       }
/* 70 */       xParaselene.setStarttime(starttime);
/* 71 */       xParaselene.setFinishtime(starttime + TimeUnit.SECONDS.toMillis(this.seconds));
/* 72 */       ParaseleneRankManager.getInstance().rank(new ParaseleneRankObj(this.roleid, this.seconds));
/* 73 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */