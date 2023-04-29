/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import mzm.gsp.chivalry.confbean.ChivalryConsts;
/*    */ import mzm.gsp.tlog.TLogArg;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChivalryInterface
/*    */ {
/*    */   public static int addRoleChivalry(long roleId, int num, int activityType, TLogArg logArg, boolean isSend)
/*    */   {
/* 25 */     PRoleAddChivalryPro pro = new PRoleAddChivalryPro(roleId, num, activityType, logArg, isSend);
/* 26 */     if (!pro.call())
/*    */     {
/* 28 */       return 0;
/*    */     }
/* 30 */     return pro.getAddNumLast();
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
/*    */   public static boolean cutRoleChivalry(long roleId, int num, TLogArg logArg)
/*    */   {
/* 45 */     return ChivalryManager.rmRoleChivalry(roleId, num, logArg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getMainCountPerTime()
/*    */   {
/* 56 */     return ChivalryConsts.getInstance().MAIN_ADD_COUNT_PER_TIME_UPPER;
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
/*    */   public static void addPVEChivalryAddInfo(long roleId, int gainType, int addNum)
/*    */   {
/* 69 */     ChivalryManager.addPVEChivalryAddInfo(roleId, gainType, addNum);
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
/*    */   public static void removePVEChivalryAddInfo(long roleId, int gainType, int addNum)
/*    */   {
/* 82 */     ChivalryManager.removePVEChivalryAddInfo(roleId, gainType, addNum);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\ChivalryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */