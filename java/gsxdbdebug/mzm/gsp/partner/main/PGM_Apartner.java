/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PartnerBag;
/*    */ import xtable.Role2partnerbag;
/*    */ 
/*    */ public class PGM_Apartner extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int partnerId;
/*    */   
/*    */   public PGM_Apartner(long roleId, int partnerId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.partnerId = partnerId;
/*    */   }
/*    */   
/* 21 */   private static final Logger logger = Logger.getLogger(PGM_Apartner.class);
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(this.partnerId));
/* 28 */     if (partnerCfg == null)
/*    */     {
/* 30 */       logger.debug("不存在的仙侣id" + this.partnerId);
/* 31 */       return false;
/*    */     }
/* 33 */     RolePartner rolePartner = PartnerManager.getRolePartner(this.roleId, true);
/*    */     
/*    */ 
/* 36 */     if (rolePartner.getPartnerBag() == null)
/*    */     {
/* 38 */       PartnerBag partnerBag = PartnerManager.creatPartnerBagBean(rolePartner);
/* 39 */       Role2partnerbag.insert(Long.valueOf(this.roleId), partnerBag);
/*    */     }
/* 41 */     if (rolePartner.getPartnerBag() == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(this.partnerId)))
/*    */     {
/* 48 */       logger.debug("已经拥有仙侣id" + this.partnerId);
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     rolePartner.getPartnerBag().getOwnpartnerids().add(Integer.valueOf(this.partnerId));
/*    */     
/* 54 */     if (!PartnerManager.afterActivePartner(this.roleId, this.partnerId, partnerCfg, rolePartner))
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     logger.debug("#########################——[GM指令]激活——#################################");
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PGM_Apartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */