/*     */ package mzm.gsp.magicmark.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.magicmark.SExtendMagicMarkTimeErrorRes;
/*     */ import mzm.gsp.magicmark.SExtendMagicMarkTimeRes;
/*     */ import mzm.gsp.magicmark.event.MagicMarkPassiveSkillChangeEvent;
/*     */ import mzm.gsp.magicmark.event.MagicMarkTypeUpdateEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MagicMarkInfo;
/*     */ import xbean.MagicMarkSys;
/*     */ 
/*     */ public class PCExtendMagicMarkTimeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final List<Integer> magicMarkItems;
/*     */   
/*     */   public PCExtendMagicMarkTimeReq(long roleid, List<Integer> magicmarkitems)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.magicMarkItems = magicmarkitems;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if (!OpenInterface.getOpenStatus(206)) {
/*  33 */       GameServer.logger().info(String.format("[MagicMark]PCExtendMagicMarkTimeReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  36 */       return false;
/*     */     }
/*  38 */     if (OpenInterface.isBanPlay(this.roleid, 206)) {
/*  39 */       OpenInterface.sendBanPlayMsg(this.roleid, 206);
/*  40 */       return false;
/*     */     }
/*  42 */     if (!MagicMarkManager.isOpenLevel(this.roleid)) {
/*  43 */       sendError(3);
/*  44 */       return false;
/*     */     }
/*  46 */     if (!MagicMarkManager.checkMutexStatus(this.roleid)) {
/*  47 */       return false;
/*     */     }
/*  49 */     if (this.magicMarkItems.size() <= 0) {
/*  50 */       GameServer.logger().info(String.format("[MagicMark]PCExtendMagicMarkTimeReq.processImp@client data error,do not has items|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*  57 */     MagicMarkExtendResult magicMarkExtendResult = MagicMarkManager.checkAndGetMagicMarkExtendOrUnLockResult(this.magicMarkItems);
/*     */     
/*  59 */     if (!magicMarkExtendResult.isSuccess()) {
/*  60 */       sendError(1);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if ((magicMarkExtendResult.foreverItemid == 0) && (magicMarkExtendResult.hours == 0)) {
/*  65 */       GameServer.logger().info(String.format("[MagicMark]PCExtendMagicMarkTimeReq.processImp@do not has forever item and do not has extend hours|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     if (magicMarkExtendResult.magicMarkType == 0) {
/*  73 */       GameServer.logger().info(String.format("[MagicMark]PCExtendMagicMarkTimeReq.processImp@magicMarkType error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSysCreateIfNotExist(this.roleid);
/*  80 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(magicMarkExtendResult.magicMarkType));
/*     */     
/*  82 */     if (xMagicMarkInfo == null) {
/*  83 */       xMagicMarkInfo = xbean.Pod.newMagicMarkInfo();
/*  84 */       xMagicMarkSys.getMagicmarkinfos().put(Integer.valueOf(magicMarkExtendResult.magicMarkType), xMagicMarkInfo);
/*     */     }
/*  86 */     if (xMagicMarkInfo.getExpiredtime() < 0L) {
/*  87 */       sendError(4);
/*  88 */       return false;
/*     */     }
/*  90 */     boolean ret = MagicMarkManager.handleExtendOrUnLockResult(this.roleid, magicMarkExtendResult, xMagicMarkInfo, this.magicMarkItems, new TLogArg(mzm.gsp.tlog.LogReason.MAGIC_MARK_EXTEND_COST, magicMarkExtendResult.magicMarkType));
/*     */     
/*  92 */     if (!ret) {
/*  93 */       sendError(2);
/*  94 */       return false;
/*     */     }
/*  96 */     SExtendMagicMarkTimeRes extendMagicMarkTimeRes = new SExtendMagicMarkTimeRes();
/*  97 */     extendMagicMarkTimeRes.magicmarktype = magicMarkExtendResult.magicMarkType;
/*  98 */     extendMagicMarkTimeRes.expiredtime = xMagicMarkInfo.getExpiredtime();
/*  99 */     OnlineManager.getInstance().send(this.roleid, extendMagicMarkTimeRes);
/*     */     
/* 101 */     MagicMarkManager.tlogMagicMark(this.roleid, magicMarkExtendResult.magicMarkType, 4, xMagicMarkInfo.getExpiredtime());
/*     */     
/*     */ 
/*     */ 
/* 105 */     MagicMarkTypeUpdateEvent updateEvent = new MagicMarkTypeUpdateEvent();
/* 106 */     TriggerEventsManger.getInstance().triggerEvent(updateEvent, new mzm.gsp.magicmark.event.MagicMarkTypeUpdateArg(this.roleid, magicMarkExtendResult.magicMarkType, 2));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 111 */     MagicMarkPassiveSkillChangeEvent magicMarkPassiveSkillChangeEvent = new MagicMarkPassiveSkillChangeEvent();
/* 112 */     TriggerEventsManger.getInstance().triggerEvent(magicMarkPassiveSkillChangeEvent, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int ret) {
/* 118 */     SExtendMagicMarkTimeErrorRes extendMagicMarkTimeErrorRes = new SExtendMagicMarkTimeErrorRes();
/* 119 */     extendMagicMarkTimeErrorRes.ret = ret;
/* 120 */     OnlineManager.getInstance().sendAtOnce(this.roleid, extendMagicMarkTimeErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PCExtendMagicMarkTimeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */