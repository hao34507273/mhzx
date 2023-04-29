/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleWorshipInfo;
/*    */ import xtable.Role2worship;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_InitWorship
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final boolean allReset;
/*    */   
/*    */   public PGM_InitWorship(long roleId, boolean allReset)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.allReset = allReset;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (this.allReset)
/*    */     {
/* 28 */       new RClearAllFactionData().execute();
/*    */     }
/*    */     
/* 31 */     WorshipManager.setDebugMode(true);
/*    */     
/* 33 */     RoleWorshipInfo xRoleWorshipInfo = Role2worship.get(Long.valueOf(this.roleId));
/* 34 */     if (xRoleWorshipInfo == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     xRoleWorshipInfo.setWorshipid(0);
/* 39 */     xRoleWorshipInfo.getLastcycledata().clear();
/* 40 */     xRoleWorshipInfo.getLastcycledata().putAll(xRoleWorshipInfo.getThiscycledata());
/* 41 */     xRoleWorshipInfo.getThiscycledata().clear();
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\PGM_InitWorship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */