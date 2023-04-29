/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PReCheckSkills
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PReCheckSkills(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/* 29 */     RolePartner rolePartner = PartnerManager.getRolePartner(this.roleId, true);
/* 30 */     if (!rolePartner.hasXPartnerData())
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     Set<Integer> allPartners = rolePartner.getAllPartners();
/*    */     
/* 37 */     for (Integer partnerId : allPartners)
/*    */     {
/* 39 */       Partner xPartner = rolePartner.getXPartner(partnerId.intValue());
/* 40 */       if (xPartner == null)
/*    */       {
/* 42 */         GameServer.logger().error(String.format("[partner]PCImproveYuanShenReq.processImp@ not own this partner!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(this.roleId), partnerId }));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       }
/* 48 */       else if (xPartner.onYuanLevelChange(false))
/*    */       {
/*    */ 
/* 51 */         PartnerOutFightObj obj = new PartnerOutFightObj(this.roleId, xPartner.xProperty);
/* 52 */         obj.updateOutFightProperty();
/*    */       }
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PReCheckSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */