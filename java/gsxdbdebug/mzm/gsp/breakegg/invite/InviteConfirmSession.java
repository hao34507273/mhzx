/*    */ package mzm.gsp.breakegg.invite;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.nationalholiday.confbean.SInviteConfirmCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.InviteConfirmBean;
/*    */ 
/*    */ public class InviteConfirmSession extends Session
/*    */ {
/*    */   public InviteConfirmSession(long interval, long roleId)
/*    */   {
/* 13 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     new InviteConfirmTimeOut(super.getOwerId()).execute();
/*    */   }
/*    */   
/*    */   class InviteConfirmTimeOut extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public InviteConfirmTimeOut(long roleId)
/*    */     {
/* 28 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 34 */       InviteConfirmBean xInviteConfirmBean = InviteManager.destroyInviteInfo(this.roleId);
/* 35 */       if (xInviteConfirmBean == null)
/*    */       {
/* 37 */         return false;
/*    */       }
/* 39 */       SInviteConfirmCfg cfg = SInviteConfirmCfg.get(xInviteConfirmBean.getInvitetype());
/* 40 */       if (cfg == null)
/*    */       {
/* 42 */         GameServer.logger().error(String.format("[invite]InviteConfirmSession.onTimeOut@ SInviteConfirmCfg is null!|inviteType=%d|roleIds=%s", new Object[] { Integer.valueOf(xInviteConfirmBean.getInvitetype()), xInviteConfirmBean.getAllroles() }));
/*    */ 
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/*    */ 
/* 49 */         InviteManager.synDoFailAction(xInviteConfirmBean);
/*    */       }
/* 51 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\invite\InviteConfirmSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */