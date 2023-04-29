/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRefreshOpponent
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PRefreshOpponent(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!JingjiManager.isJingjiSwitchOpenForRole(this.roleid))
/*    */     {
/* 30 */       String logstr = String.format("[jingji]PRefreshOpponent.processImp@Jingji switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 32 */       JingjiManager.logger.info(logstr);
/*    */       
/* 34 */       return false;
/*    */     }
/* 36 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*    */     {
/* 38 */       String logStr = String.format("[jingji]PRefreshOpponent.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 40 */       JingjiManager.logger.info(logStr);
/* 41 */       return false;
/*    */     }
/* 43 */     if (!JingjiManager.canFresh(this.roleid))
/*    */     {
/*    */ 
/* 46 */       JingjiManager.sendErrorInfo(this.roleid, 8);
/* 47 */       return false;
/*    */     }
/* 49 */     int winpoint = JingjiManager.getWinpoint(this.roleid, false);
/* 50 */     if (winpoint == 0)
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     JingjiManager.asynRefreshMatchOpponent(this.roleid, RoleInterface.getLevel(this.roleid), RoleInterface.getRoleMFValue(this.roleid), winpoint, -1L, DateTimeUtils.getCurrTimeInMillis());
/*    */     
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PRefreshOpponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */