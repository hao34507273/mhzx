/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.SDeleteAdvertFailed;
/*     */ import mzm.gsp.personal.SDeleteAdvertSuccess;
/*     */ import mzm.gsp.personal.confbean.SNSConsts;
/*     */ import mzm.gsp.personal.confbean.SNSSubTypeCfg;
/*     */ import mzm.gsp.personal.event.DeleteAdvert;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdvertObserver;
/*     */ import xbean.PersonalInfo;
/*     */ import xtable.Advert;
/*     */ import xtable.Advertobservers;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class PCDeleteAdvert extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int advertType;
/*     */   
/*     */   public PCDeleteAdvert(long roleId, int advertType)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.advertType = advertType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!SNSManager.isFunOpen(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (!SNSManager.checkRoleStatus(this.roleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (this.advertType == SNSConsts.getInstance().ALL_SUB_TYPE_ID)
/*     */     {
/*     */ 
/*  50 */       onFailed(0);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!SNSSubTypeCfg.getAll().containsKey(Integer.valueOf(this.advertType)))
/*     */     {
/*     */ 
/*  57 */       onFailed(0);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (mzm.gsp.role.main.RoleInterface.getLevel(this.roleId) < SNSConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*     */ 
/*  64 */       onFailed(13);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/*  70 */     if (xPersonalInfo == null)
/*     */     {
/*     */ 
/*  73 */       onFailed(6);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     Long advertId = (Long)xPersonalInfo.getAdverts().get(Integer.valueOf(this.advertType));
/*  79 */     if (advertId == null)
/*     */     {
/*     */ 
/*  82 */       onFailed(7);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     Advert.remove(advertId);
/*  88 */     xPersonalInfo.getAdverts().remove(Integer.valueOf(this.advertType));
/*  89 */     xPersonalInfo.getDeletetimestamps().put(Integer.valueOf(this.advertType), Long.valueOf(DateTimeUtils.getCurrTimeInMillis()));
/*     */     
/*  91 */     AdvertObserver xAdvertObserver = Advertobservers.get(advertId);
/*  92 */     if (xAdvertObserver != null)
/*     */     {
/*  94 */       if (xAdvertObserver.getObserver() != null)
/*     */       {
/*  96 */         xAdvertObserver.getObserver().stopTimer();
/*     */       }
/*     */     }
/*  99 */     Advertobservers.remove(advertId);
/*     */     
/*     */ 
/* 102 */     int advertNum = xPersonalInfo.getAdverts().size();
/* 103 */     DeleteAdvert deleteAdvertEvent = new DeleteAdvert();
/* 104 */     deleteAdvertEvent.setSequential(true);
/* 105 */     TriggerEventsManger.getInstance().triggerEvent(deleteAdvertEvent, new mzm.gsp.personal.event.DeleteAdvertArg(this.advertType, this.roleId, advertId.longValue(), advertNum), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 110 */     SNSManager.tlogDeleteAdvert(this.roleId, advertId.longValue(), this.advertType, 0);
/*     */     
/* 112 */     SDeleteAdvertSuccess resp = new SDeleteAdvertSuccess();
/* 113 */     resp.adverttype = this.advertType;
/* 114 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/* 116 */     GameServer.logger().info(String.format("[personal]PCDeleteAdvert.processImp@delete advert success|roleid=%d|advert_type=%d|advertid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), advertId }));
/*     */     
/*     */ 
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retCode)
/*     */   {
/* 124 */     SDeleteAdvertFailed resp = new SDeleteAdvertFailed();
/* 125 */     resp.retcode = retCode;
/* 126 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */     
/* 128 */     GameServer.logger().error(String.format("[personal]PCDeleteAdvert.onFailed@delete advert failed|roleid=%d|advert_type=%d|ret=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), Integer.valueOf(retCode) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCDeleteAdvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */