/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PActivePartnerReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int partnerId;
/*    */   
/*    */   public PActivePartnerReq(long roleId, int partnerId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.partnerId = partnerId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleId);
/* 29 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 31 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 32 */     if (!canActiveActivePartnerInStatus(this.roleId))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!canActiveThisPartner(this.partnerId))
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     return PartnerManager.onActivePartnerRep(userid, this.roleId, this.partnerId);
/*    */   }
/*    */   
/*    */   private boolean canActiveThisPartner(int partnerId)
/*    */   {
/* 45 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/* 46 */     if (partnerCfg == null)
/*    */     {
/* 48 */       GameServer.logger().error(String.format("[partner]PActivePartnerReq.canActiveThisPartner@ no partner cfg!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(partnerId) }));
/*    */       
/*    */ 
/* 51 */       return false;
/*    */     }
/* 53 */     if (!partnerCfg.isOccReadyForActive())
/*    */     {
/* 55 */       GameServer.logger().error(String.format("[partner]PActivePartnerReq.canActiveThisPartner@ partner's occupation is not alowed to active!|roleId=%d|partnerId=%d|occId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(partnerId), Integer.valueOf(partnerCfg.getsPartnerCfg().faction) }));
/*    */       
/*    */ 
/*    */ 
/* 59 */       return false;
/*    */     }
/* 61 */     return true;
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
/*    */   private boolean canActiveActivePartnerInStatus(long roleId)
/*    */   {
/* 75 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleId, 56, true))
/*    */     {
/* 77 */       GameServer.logger().error(String.format("[parnter]PActivePartnerReq.canActiveActivePartnerInStatus@ active own partner is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 81 */       return false;
/*    */     }
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PActivePartnerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */