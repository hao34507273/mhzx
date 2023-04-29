/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardCfgValueBean;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.resourcecheck.confbean.SAwardRoleExpBark;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AwardTotalData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleExpWatchDog
/*    */   extends AbsAwardWatchDog
/*    */ {
/*    */   public RoleExpWatchDog(long roleId, int roleLv, AwardTotalData xTotalData, AwardModel awardModel)
/*    */   {
/* 20 */     super(roleId, roleLv, xTotalData, awardModel);
/*    */   }
/*    */   
/*    */ 
/*    */   long getAddValue()
/*    */   {
/* 26 */     AwardCfgValueBean awardCfgBean = this._awardModel.getOriginalValue();
/* 27 */     if (awardCfgBean == null)
/*    */     {
/* 29 */       return 0L;
/*    */     }
/* 31 */     return super.getAddValue(this._awardModel.getRoleExp(), awardCfgBean.getRoleExp());
/*    */   }
/*    */   
/*    */ 
/*    */   long getXValue()
/*    */   {
/* 37 */     return this._xTotalData.getRoleexp();
/*    */   }
/*    */   
/*    */ 
/*    */   void setXValue(long value)
/*    */   {
/* 43 */     this._xTotalData.setRoleexp(value);
/*    */   }
/*    */   
/*    */ 
/*    */   long getUplimit(int roleOrgLv)
/*    */   {
/* 49 */     SAwardRoleExpBark cfg = SAwardRoleExpBark.get(roleOrgLv);
/* 50 */     if (cfg == null)
/*    */     {
/* 52 */       GameServer.logger().info(String.format("[awardWatchDog]RoleExpWatchDog.getUplimit@ no SAwardRoleExpBark!|roleId=%d|roleOrgLv=%d|roleLv=%d", new Object[] { Long.valueOf(this._roleId), Integer.valueOf(roleOrgLv), Integer.valueOf(this._roleLv) }));
/*    */       
/*    */ 
/*    */ 
/* 56 */       return 0L;
/*    */     }
/* 58 */     return cfg.upline;
/*    */   }
/*    */   
/*    */ 
/*    */   AwardWatchType getType()
/*    */   {
/* 64 */     return AwardWatchType.ROLE_EXP;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\RoleExpWatchDog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */