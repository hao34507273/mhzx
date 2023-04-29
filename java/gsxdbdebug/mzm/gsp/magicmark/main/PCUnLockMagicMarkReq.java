/*     */ package mzm.gsp.magicmark.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.magicmark.SUnLockMagicMarkRes;
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
/*     */ public class PCUnLockMagicMarkReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final List<Integer> magicMarkItems;
/*     */   
/*     */   public PCUnLockMagicMarkReq(long roleid, List<Integer> magicmarkitems)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.magicMarkItems = magicmarkitems;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if (!OpenInterface.getOpenStatus(206)) {
/*  32 */       GameServer.logger().info(String.format("[MagicMark]PCUnLockMagicMarkReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  34 */       return false;
/*     */     }
/*  36 */     if (OpenInterface.isBanPlay(this.roleid, 206)) {
/*  37 */       OpenInterface.sendBanPlayMsg(this.roleid, 206);
/*  38 */       return false;
/*     */     }
/*  40 */     if (!MagicMarkManager.isOpenLevel(this.roleid)) {
/*  41 */       sendError(5);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!MagicMarkManager.checkMutexStatus(this.roleid)) {
/*  45 */       return false;
/*     */     }
/*  47 */     if (this.magicMarkItems.size() <= 0) {
/*  48 */       GameServer.logger().info(String.format("[MagicMark]PCUnLockMagicMarkReq.processImp@client data error,do not has items|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     MagicMarkExtendResult magicMarkExtendResult = MagicMarkManager.checkAndGetMagicMarkExtendOrUnLockResult(this.magicMarkItems);
/*     */     
/*  56 */     if (!magicMarkExtendResult.isSuccess()) {
/*  57 */       sendError(3);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if ((magicMarkExtendResult.foreverItemid == 0) && (magicMarkExtendResult.hours == 0)) {
/*  62 */       GameServer.logger().info(String.format("[MagicMark]PCUnLockMagicMarkReq.processImp@do not has forever item and do not has extend hours|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     if (magicMarkExtendResult.magicMarkType == 0) {
/*  70 */       GameServer.logger().info(String.format("[MagicMark]PCUnLockMagicMarkReq.processImp@magicMarkType error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSysCreateIfNotExist(this.roleid);
/*  76 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(magicMarkExtendResult.magicMarkType));
/*  77 */     if (xMagicMarkInfo == null) {
/*  78 */       xMagicMarkInfo = xbean.Pod.newMagicMarkInfo();
/*  79 */       xMagicMarkSys.getMagicmarkinfos().put(Integer.valueOf(magicMarkExtendResult.magicMarkType), xMagicMarkInfo);
/*     */     }
/*  81 */     if (xMagicMarkInfo.getExpiredtime() < 0L) {
/*  82 */       sendError(4);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     boolean ret = MagicMarkManager.handleExtendOrUnLockResult(this.roleid, magicMarkExtendResult, xMagicMarkInfo, this.magicMarkItems, new TLogArg(mzm.gsp.tlog.LogReason.MAGIC_MARK_UNLOCK_COST, magicMarkExtendResult.magicMarkType));
/*     */     
/*  88 */     if (!ret) {
/*  89 */       sendError(2);
/*  90 */       return false;
/*     */     }
/*  92 */     SUnLockMagicMarkRes unLockMagicMarkRes = new SUnLockMagicMarkRes();
/*  93 */     unLockMagicMarkRes.ret = 1;
/*  94 */     unLockMagicMarkRes.magicmarktype = magicMarkExtendResult.magicMarkType;
/*  95 */     unLockMagicMarkRes.expiredtime = xMagicMarkInfo.getExpiredtime();
/*  96 */     OnlineManager.getInstance().send(this.roleid, unLockMagicMarkRes);
/*     */     
/*  98 */     MagicMarkManager.tlogMagicMark(this.roleid, magicMarkExtendResult.magicMarkType, 1, xMagicMarkInfo.getExpiredtime());
/*     */     
/*     */ 
/*     */ 
/* 102 */     MagicMarkTypeUpdateEvent updateEvent = new MagicMarkTypeUpdateEvent();
/* 103 */     TriggerEventsManger.getInstance().triggerEvent(updateEvent, new mzm.gsp.magicmark.event.MagicMarkTypeUpdateArg(this.roleid, magicMarkExtendResult.magicMarkType, 2));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     MagicMarkPassiveSkillChangeEvent magicMarkPassiveSkillChangeEvent = new MagicMarkPassiveSkillChangeEvent();
/* 109 */     TriggerEventsManger.getInstance().triggerEvent(magicMarkPassiveSkillChangeEvent, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int ret) {
/* 115 */     SUnLockMagicMarkRes unLockMagicMarkRes = new SUnLockMagicMarkRes();
/* 116 */     unLockMagicMarkRes.ret = ret;
/* 117 */     OnlineManager.getInstance().sendAtOnce(this.roleid, unLockMagicMarkRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PCUnLockMagicMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */