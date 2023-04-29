/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import xbean.Role2MiBaoInfo;
/*    */ import xtable.Role2mibao;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MiBaoInterface
/*    */ {
/*    */   public static int getMiBaoScore(long roleId, boolean isRemainRoleLock)
/*    */   {
/* 15 */     Role2MiBaoInfo xRole2MiBaoInfo = null;
/* 16 */     if (isRemainRoleLock)
/*    */     {
/* 18 */       xRole2MiBaoInfo = Role2mibao.get(Long.valueOf(roleId));
/*    */     }
/*    */     else
/*    */     {
/* 22 */       xRole2MiBaoInfo = Role2mibao.select(Long.valueOf(roleId));
/*    */     }
/*    */     
/* 25 */     if (xRole2MiBaoInfo == null)
/*    */     {
/* 27 */       return 0;
/*    */     }
/*    */     
/* 30 */     return xRole2MiBaoInfo.getCurrent_score();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\MiBaoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */