/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fabao.SLongjingUpLevelErrorRes;
/*     */ import mzm.gsp.fabao.SLongjingUpLevelRes;
/*     */ import mzm.gsp.item.confbean.SLongJingCompose;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.Item;
/*     */ import xbean.LongJing;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ public class PLongjingUpLevel extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int fabaotype;
/*     */   private final int pos;
/*     */   
/*     */   public PLongjingUpLevel(long roleid, int fabaotype, int pos)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.fabaotype = fabaotype;
/*  32 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*     */     {
/*  39 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/*  40 */       return false;
/*     */     }
/*  42 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  43 */       sendError(5);
/*  44 */       return false;
/*     */     }
/*  46 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/*  47 */     LongJing xLongJing = (LongJing)xRoleFabaoSysInfo.getLongjingmap().get(Integer.valueOf(this.fabaotype));
/*  48 */     if (xLongJing == null) {
/*  49 */       sendError(1);
/*  50 */       return false;
/*     */     }
/*  52 */     Item xItem = (Item)xLongJing.getLongjingitems().get(Integer.valueOf(this.pos));
/*  53 */     if (xItem == null) {
/*  54 */       sendError(1);
/*  55 */       return false;
/*     */     }
/*  57 */     BasicItem basicItem = new BasicItem(xItem);
/*  58 */     SLongJingItem longJingItem = SLongJingItem.get(basicItem.getCfgId());
/*  59 */     if (longJingItem == null) {
/*  60 */       sendError(1);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     SLongJingItem nextLongjingItem = SLongJingItem.get(longJingItem.nextId);
/*  65 */     if (nextLongjingItem == null) {
/*  66 */       sendError(3);
/*  67 */       return false;
/*     */     }
/*  69 */     int maxLongjingLv = FabaoManager.getLongjingMaxLevel(mzm.gsp.role.main.RoleInterface.getLevel(this.roleid));
/*  70 */     if (nextLongjingItem.lv > maxLongjingLv) {
/*  71 */       sendError(4);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     int needNum = longJingItem.complexNextCount - 1;
/*  76 */     Map<Integer, Integer> costItemid2Num = new HashMap();
/*  77 */     int retNum = addCostNum(longJingItem.id, needNum, costItemid2Num);
/*  78 */     SLongJingCompose longJingCompose = SLongJingCompose.get(basicItem.getCfgId());
/*     */     
/*  80 */     Set<Integer> judgeItems = new HashSet();
/*  81 */     judgeItems.add(Integer.valueOf(longJingItem.id));
/*  82 */     while (retNum > 0) {
/*  83 */       if (longJingCompose == null) {
/*  84 */         sendError(2);
/*  85 */         return false;
/*     */       }
/*  87 */       SLongJingItem tempLongJingItem = SLongJingItem.get(longJingCompose.beforeLongjingid);
/*  88 */       if (tempLongJingItem == null) {
/*  89 */         sendError(2);
/*  90 */         return false;
/*     */       }
/*     */       
/*  93 */       if (judgeItems.contains(Integer.valueOf(tempLongJingItem.id))) {
/*  94 */         sendError(2);
/*  95 */         GameServer.logger().error(String.format("[Fabao]PLongjingUpLevel.processImp@longjing item cfg up level circle error|id=%d", new Object[] { Integer.valueOf(longJingItem.id) }));
/*     */         
/*     */ 
/*     */ 
/*  99 */         return false;
/*     */       }
/*     */       
/* 102 */       judgeItems.add(Integer.valueOf(tempLongJingItem.id));
/*     */       
/* 104 */       int tempNeedNum = retNum * tempLongJingItem.complexNextCount;
/*     */       
/* 106 */       retNum = addCostNum(tempLongJingItem.id, tempNeedNum, costItemid2Num);
/* 107 */       longJingCompose = SLongJingCompose.get(tempLongJingItem.id);
/*     */     }
/* 109 */     ItemOperateResult operateResult = ItemInterface.removeItemById(this.roleid, costItemid2Num, new TLogArg(mzm.gsp.tlog.LogReason.FABAO_LONGJING_UP_LEVEL_REM));
/*     */     
/* 111 */     if (!operateResult.success()) {
/* 112 */       sendError(0);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     xItem.setCfgid(nextLongjingItem.id);
/* 117 */     basicItem.removeShanghuiProperty();
/*     */     
/* 119 */     SLongjingUpLevelRes sLongjingUpLevelRes = new SLongjingUpLevelRes();
/* 120 */     sLongjingUpLevelRes.curitemid = longJingItem.id;
/* 121 */     sLongjingUpLevelRes.nextitemid = nextLongjingItem.id;
/* 122 */     OnlineManager.getInstance().send(this.roleid, sLongjingUpLevelRes);
/*     */     
/*     */ 
/* 125 */     FabaoManager.onEquipLongjingChanged(this.roleid, this.fabaotype, this.pos, basicItem);
/*     */     
/* 127 */     FabaoManager.tlogEquipLongJingUpLevel(this.roleid, basicItem.getFirstUuid().longValue(), longJingItem.id, nextLongjingItem.id);
/* 128 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int addCostNum(int itemid, int needNum, Map<Integer, Integer> costItemid2Num)
/*     */   {
/* 140 */     int nowNum = ItemInterface.getItemNumberById(this.roleid, itemid);
/* 141 */     if (needNum > nowNum) {
/* 142 */       if (nowNum > 0) {
/* 143 */         costItemid2Num.put(Integer.valueOf(itemid), Integer.valueOf(nowNum));
/*     */       }
/* 145 */       return needNum - nowNum;
/*     */     }
/* 147 */     costItemid2Num.put(Integer.valueOf(itemid), Integer.valueOf(needNum));
/* 148 */     return 0;
/*     */   }
/*     */   
/*     */   private void sendError(int error)
/*     */   {
/* 153 */     SLongjingUpLevelErrorRes longjingUpLevelErrorRes = new SLongjingUpLevelErrorRes();
/* 154 */     longjingUpLevelErrorRes.resultcode = error;
/* 155 */     OnlineManager.getInstance().sendAtOnce(this.roleid, longjingUpLevelErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongjingUpLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */