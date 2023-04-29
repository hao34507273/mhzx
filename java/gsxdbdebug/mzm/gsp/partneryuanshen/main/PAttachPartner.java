/*     */ package mzm.gsp.partneryuanshen.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import mzm.gsp.partneryuanshen.SAttachPartnerSuccess;
/*     */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveCfg;
/*     */ import mzm.gsp.partneryuanshen.event.AttachedPartnerChanged;
/*     */ import mzm.gsp.partneryuanshen.event.AttachedPartnerChangedArg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.PartnerYuanshenPositionInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAttachPartner
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int position;
/*     */   private final int partnerId;
/*     */   
/*     */   public PAttachPartner(long roleId, int position, int partnerId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.position = position;
/*  30 */     this.partnerId = partnerId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (PartnerYuanshenManager.isNotEnable())
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (PartnerYuanshenManager.notMeetOpenLevel(this.roleId))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1691, true))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     SPartnerYuanshenImproveCfg cfg = SPartnerYuanshenImproveCfg.get(this.position);
/*  50 */     if (cfg == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (this.partnerId != 0)
/*     */     {
/*  57 */       return attachPartner();
/*     */     }
/*     */     
/*     */ 
/*  61 */     return detachPartner();
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean attachPartner()
/*     */   {
/*  67 */     if (!PartnerInterface.ownPartner(this.roleId, this.partnerId))
/*     */     {
/*  69 */       PartnerYuanshenLogger.error("PAttachPartner.attachPartner()@invalid partner|roleid=%d|position=%d|partner_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(this.partnerId) });
/*     */       
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  77 */     Map<Integer, PartnerYuanshenPositionInfo> map = PartnerYuanshenManager.getOrCreatePartnerYuanshenPositionInfoMap(this.roleId);
/*     */     
/*  79 */     PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo = PartnerYuanshenManager.getOrCreatePartnerYuanshenPositionInfo(this.roleId, this.position);
/*     */     
/*  81 */     int oldAttachedPartnerId = xPartnerYuanshenPositionInfo.getAttached_partner_id();
/*  82 */     if (oldAttachedPartnerId == this.partnerId)
/*     */     {
/*  84 */       PartnerYuanshenLogger.error("PAttachPartner.attachPartner()@already attached|roleid=%d|position=%d|partner_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(this.partnerId) });
/*     */       
/*  86 */       return false;
/*     */     }
/*  88 */     for (Map.Entry<Integer, PartnerYuanshenPositionInfo> entry : map.entrySet())
/*     */     {
/*  90 */       if ((((Integer)entry.getKey()).intValue() != this.position) && (((PartnerYuanshenPositionInfo)entry.getValue()).getAttached_partner_id() == this.partnerId))
/*     */       {
/*  92 */         PartnerYuanshenLogger.error("PAttachPartner.attachPartner()@already attached to other position|roleid=%d|current_position=%d|partner_cfgid=%d", new Object[] { Long.valueOf(this.roleId), entry.getKey(), Integer.valueOf(this.partnerId) });
/*     */         
/*     */ 
/*  95 */         return false;
/*     */       }
/*     */     }
/*  98 */     xPartnerYuanshenPositionInfo.setAttached_partner_id(this.partnerId);
/*  99 */     notifySuccess();
/* 100 */     triggerEvent(oldAttachedPartnerId);
/* 101 */     PartnerYuanshenLogger.tlogAttachPartner(this.roleId, this.position, ((PartnerYuanshenPositionInfo)map.get(Integer.valueOf(this.position))).getLevel(), ((PartnerYuanshenPositionInfo)map.get(Integer.valueOf(this.position))).getProperty_num(), this.partnerId);
/*     */     
/* 103 */     PartnerYuanshenLogger.info("PAttachPartner.attachPartner()@done|roleid=%d|position=%d|partner_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(this.partnerId) });
/*     */     
/* 105 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean detachPartner()
/*     */   {
/* 111 */     PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo = PartnerYuanshenManager.getPartnerYuanshenPositionInfo(this.roleId, this.position, true);
/*     */     
/* 113 */     if (xPartnerYuanshenPositionInfo != null)
/*     */     {
/* 115 */       int oldAttachedPartnerId = xPartnerYuanshenPositionInfo.getAttached_partner_id();
/* 116 */       xPartnerYuanshenPositionInfo.setAttached_partner_id(0);
/* 117 */       notifySuccess();
/* 118 */       triggerEvent(oldAttachedPartnerId);
/* 119 */       PartnerYuanshenLogger.tlogAttachPartner(this.roleId, this.position, xPartnerYuanshenPositionInfo.getLevel(), xPartnerYuanshenPositionInfo.getProperty_num(), 0);
/*     */       
/* 121 */       PartnerYuanshenLogger.info("PAttachPartner.detachPartner()@done|roleid=%d|position=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position) });
/* 122 */       return true;
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   private void notifySuccess()
/*     */   {
/* 129 */     SAttachPartnerSuccess sAttachPartnerSuccess = new SAttachPartnerSuccess();
/* 130 */     sAttachPartnerSuccess.position = this.position;
/* 131 */     sAttachPartnerSuccess.partner_id = this.partnerId;
/* 132 */     OnlineManager.getInstance().send(this.roleId, sAttachPartnerSuccess);
/*     */   }
/*     */   
/*     */   private void triggerEvent(int oldPartnerId)
/*     */   {
/* 137 */     AttachedPartnerChangedArg arg = new AttachedPartnerChangedArg(this.roleId, this.position, oldPartnerId, this.partnerId);
/* 138 */     TriggerEventsManger.getInstance().triggerEvent(new AttachedPartnerChanged(), arg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\PAttachPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */