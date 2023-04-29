/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2pk_info;
/*    */ 
/*    */ public class PGM_PKForceProtection extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final boolean justQuery;
/*    */   private final boolean enable;
/*    */   
/*    */   public PGM_PKForceProtection(long gmRoleId, long roleId, int enable)
/*    */   {
/* 18 */     this.gmRoleId = gmRoleId;
/* 19 */     this.roleId = roleId;
/* 20 */     this.justQuery = (enable == -1);
/* 21 */     this.enable = (enable != 0);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (this.justQuery)
/*    */     {
/* 29 */       if (RoleStatusInterface.containsStatus(this.roleId, 1623))
/*    */       {
/* 31 */         int expireTime = Role2pk_info.selectPk_mode_expire_time(Long.valueOf(this.roleId)).intValue();
/* 32 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d已处于PK强制保护状态 (%s)", new Object[] { Long.valueOf(this.roleId), DateTimeUtils.formatTimestamp(expireTime * 1000L) }));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 37 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d不处于PK强制保护状态", new Object[] { Long.valueOf(this.roleId) }));
/*    */       }
/*    */       
/*    */ 
/*    */     }
/* 42 */     else if (this.enable)
/*    */     {
/* 44 */       int expireTime = PKStatusManager.setForceProtection(this.roleId);
/* 45 */       if (expireTime == 0)
/*    */       {
/* 47 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("为%d设置PK强制保护状态失败", new Object[] { Long.valueOf(this.roleId) }));
/* 48 */         PKLogManager.error(String.format("PGM_PKForceProtection.processImp()@set status failed|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       }
/*    */       else
/*    */       {
/* 52 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("为%d设置PK强制保护状态成功 (%s)", new Object[] { Long.valueOf(this.roleId), DateTimeUtils.formatTimestamp(expireTime * 1000L) }));
/*    */         
/* 54 */         PKLogManager.info(String.format("PGM_PKForceProtection.processImp()@set status success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 59 */       PKStatusManager.unsetForceProtection(this.roleId);
/* 60 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("已为%d清除PK强制保护状态", new Object[] { Long.valueOf(this.roleId) }));
/* 61 */       PKLogManager.info(String.format("PGM_PKForceProtection.processImp()@unset status|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */     }
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PGM_PKForceProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */