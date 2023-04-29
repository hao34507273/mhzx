/*    */ package mzm.gsp.zhenfa.event;
/*    */ 
/*    */ 
/*    */ public class ZhenfaLevelUpArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int zhenfaId;
/*    */   public final int oldLevel;
/*    */   public final int newLevel;
/*    */   
/*    */   public ZhenfaLevelUpArg(long roleId, int zhenfaId, int oldLevel, int newLevel)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.zhenfaId = zhenfaId;
/* 15 */     this.oldLevel = oldLevel;
/* 16 */     this.newLevel = newLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\event\ZhenfaLevelUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */