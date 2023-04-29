/*     */ package mzm.gsp.multioccupation.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.multioccupation.confbean.SActivateNewOccupCostCfg;
/*     */ import mzm.gsp.multioccupation.confbean.SMultiOccupConsts;
/*     */ import mzm.gsp.multioccupation.event.ActivateNewOccup;
/*     */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.OccupationManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MultiOccupation;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PActivateNewOccupationReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int newOccupation;
/*     */   private final int oldOccupation;
/*     */   private final long currentCurrency;
/*     */   private final int npcid;
/*     */   
/*     */   public PActivateNewOccupationReq(long roleid, int newOccupation, int oldOccupation, long currentCurrency, int npcid)
/*     */   {
/*  39 */     this.roleid = roleid;
/*  40 */     this.newOccupation = newOccupation;
/*  41 */     this.oldOccupation = oldOccupation;
/*  42 */     this.currentCurrency = currentCurrency;
/*  43 */     this.npcid = npcid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!OpenInterface.getOpenStatus(184)) {
/*  50 */       MultiOccupManager.logInfo("PActivateNewOccupationReq.processImp@not open|roleid=%d|new_occup=%d|old_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if ((!OpenInterface.getOpenStatus(278)) && 
/*  60 */       (this.newOccupation == 7)) {
/*  61 */       MultiOccupManager.logInfo("PActivateNewOccupationReq.processImp@cang yu ge not open|roleid=%d|new_occup=%d|old_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  71 */     if ((!OpenInterface.getOpenStatus(425)) && 
/*  72 */       (this.newOccupation == 8)) {
/*  73 */       MultiOccupManager.logInfo("PActivateNewOccupationReq.processImp@ling yin dian not open|roleid=%d|new_occup=%d|old_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  83 */     if (!NpcInterface.checkNpcService(this.npcid, SMultiOccupConsts.getInstance().ActiveService, this.roleid)) {
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     String userid = RoleInterface.getUserId(this.roleid);
/*  89 */     if (userid == null) {
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  96 */     int currentOccup = RoleInterface.getOccupationId(this.roleid);
/*  97 */     if (this.oldOccupation != currentOccup) {
/*  98 */       MultiOccupManager.logWarn("PActivateNewOccupationReq.processImp@current occupation not match|roleid=%d|server_occup=%d|client_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(currentOccup), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     if (!OccupationManager.isExistOccupation(this.newOccupation)) {
/* 108 */       MultiOccupManager.logError("PActivateNewOccupationReq.processImp@invalid new occupation|new_occup=%d", new Object[] { Integer.valueOf(this.newOccupation) });
/*     */       
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (this.oldOccupation == this.newOccupation) {
/* 115 */       MultiOccupManager.logError("PActivateNewOccupationReq.processImp@invalid new occupation|roleid=%d|new_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation) });
/*     */       
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     int level = RoleInterface.getLevel(this.roleid);
/* 123 */     if (level < SMultiOccupConsts.getInstance().LevelLimit) {
/* 124 */       MultiOccupManager.sendNormalResult(this.roleid, 1);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 66, true))
/*     */     {
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     MultiOccupation xMultiOccup = MultiOccupManager.getAndCreateXMultiOccup(this.roleid, currentOccup);
/* 136 */     if (MultiOccupManager.hasOccup(xMultiOccup, this.newOccupation)) {
/* 137 */       MultiOccupManager.logError("PActivateNewOccupationReq.processImp@already has occupation|roleid=%d|new_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation) });
/*     */       
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 144 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 145 */     if (now < xMultiOccup.getActivate_time() + MultiOccupConfigManager.getActivateIntervalMillis()) {
/* 146 */       MultiOccupManager.sendNormalResult(this.roleid, 4);
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     int occupCount = xMultiOccup.getOccupations().size();
/*     */     
/* 152 */     if (occupCount <= 0) {
/* 153 */       MultiOccupManager.logError("PActivateNewOccupationReq.processImp@occup count error|roleid=%d|occup_count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(occupCount) });
/*     */       
/*     */ 
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     TLogArg tLogArg = new TLogArg(LogReason.MULTI_OCCUP_ACTIVE, this.newOccupation);
/*     */     
/* 161 */     SActivateNewOccupCostCfg costCfg = SActivateNewOccupCostCfg.get(occupCount);
/* 162 */     if (costCfg == null) {
/* 163 */       MultiOccupManager.logError("PActivateNewOccupationReq.processImp@cost cfg null|roleid=%d|occup_count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(occupCount) });
/*     */       
/*     */ 
/*     */ 
/* 167 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 171 */     int itemNumber = ItemInterface.getItemNumberById(this.roleid, costCfg.itemid);
/* 172 */     if (itemNumber >= costCfg.itemNumber)
/*     */     {
/* 174 */       if (!ItemInterface.removeItemById(this.roleid, costCfg.itemid, costCfg.itemNumber, tLogArg)) {
/* 175 */         MultiOccupManager.logError("PActivateNewOccupationReq.processImp@remove item err|roleid=%d|occup_count=%d|cost_itemid=%d|cost_item_number=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(occupCount), Integer.valueOf(costCfg.itemid), Integer.valueOf(costCfg.itemNumber) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 181 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 187 */       long gold = RoleInterface.getGold(this.roleid);
/* 188 */       if (this.currentCurrency != gold) {
/* 189 */         MultiOccupManager.logError("PActivateNewOccupationReq.processImp@current gold not match|roleid=%d|server_gold=%d|client_gold=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(gold), Long.valueOf(this.currentCurrency) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 194 */         return false;
/*     */       }
/*     */       
/* 197 */       if (costCfg.gold <= 0) {
/* 198 */         MultiOccupManager.logError("PActivateNewOccupationReq.processImp@need gold error|roleid=%d|need_gold=%d|current_gold=%d|occup_count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(costCfg.gold), Long.valueOf(gold), Integer.valueOf(occupCount) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 204 */         return false;
/*     */       }
/* 206 */       if (!RoleInterface.cutGold(this.roleid, costCfg.gold, tLogArg)) {
/* 207 */         MultiOccupManager.logError("PActivateNewOccupationReq.processImp@lack gold when first activate|roleid=%d|need_gold=%d|current_gold=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(costCfg.gold), Long.valueOf(gold) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 212 */         MultiOccupManager.sendNormalResult(this.roleid, 5);
/* 213 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 218 */     xMultiOccup.getOccupations().add(Integer.valueOf(this.newOccupation));
/*     */     
/*     */ 
/* 221 */     LinkedList<MultiOccupHandler> handlers = MultiOccupHandlerManager.getHandlers();
/* 222 */     for (MultiOccupHandler handler : handlers) {
/* 223 */       if (!handler.onActivateNewOccupation(this.roleid, this.newOccupation, this.oldOccupation)) {
/* 224 */         MultiOccupManager.logError("PActivateNewOccupationReq.processImp@handle failed|roleid=%d|current_occup=%d|new_occup=%d|activated_count=%d|class=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(currentOccup), Integer.valueOf(this.newOccupation), Integer.valueOf(occupCount), handler.getClass().toString() });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 231 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 235 */     RoleInterface.setOccupationid(this.roleid, this.newOccupation);
/*     */     
/*     */ 
/* 238 */     MultiOccupManager.notifyActiveNewOccup(this.roleid, this.newOccupation);
/*     */     
/*     */ 
/* 241 */     RoleInterface.removeRoleOutFightObj(this.roleid);
/*     */     
/*     */ 
/* 244 */     xMultiOccup.setActivate_time(now);
/*     */     
/*     */ 
/* 247 */     ActivateNewOccupArg arg = new ActivateNewOccupArg(this.roleid, this.newOccupation, this.oldOccupation);
/* 248 */     TriggerEventsManger.getInstance().triggerEvent(new ActivateNewOccup(), arg);
/*     */     
/*     */ 
/* 251 */     TLogManager.getInstance().addLog(userid, "ActivateNewOccupation", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(this.roleid), Integer.valueOf(level), Integer.valueOf(this.oldOccupation), Integer.valueOf(this.newOccupation), Integer.valueOf(xMultiOccup.getOccupations().size()) });
/*     */     
/*     */ 
/*     */ 
/* 255 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\PActivateNewOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */