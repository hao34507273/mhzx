/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2opponent;
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     new PRemoveFightCache(((Long)this.arg).longValue()).execute();
/*    */     
/* 17 */     Role2opponent.remove((Long)this.arg);
/*    */     
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   private class PRemoveFightCache extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public PRemoveFightCache(long roleId)
/*    */     {
/* 28 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 34 */       String userId = RoleInterface.getUserId(this.roleId);
/*    */       
/* 36 */       if (ActivityInterface.isInActivityLevel(userId, this.roleId, JingjiActivityCfgConsts.getInstance().ACTIVITYID))
/*    */       {
/* 38 */         FightMatchManager.removeFightingCapacity(this.roleId);
/*    */       }
/*    */       
/* 41 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */