/*     */ package mzm.gsp.multioccupation.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.multioccupation.confbean.SMultiOccupConsts;
/*     */ import mzm.gsp.multioccupation.event.SwitchOccup;
/*     */ import mzm.gsp.multioccupation.event.SwitchOccupArg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
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
/*     */ public class PSwitchOccupationReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int newOccupation;
/*     */   private final int oldOccupation;
/*     */   private final long currentGold;
/*     */   private final int npcid;
/*     */   
/*     */   public PSwitchOccupationReq(long roleid, int newOccupation, int oldOccupation, long currentGold, int npcid)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.newOccupation = newOccupation;
/*  38 */     this.oldOccupation = oldOccupation;
/*  39 */     this.currentGold = currentGold;
/*  40 */     this.npcid = npcid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!OpenInterface.getOpenStatus(184)) {
/*  47 */       MultiOccupManager.logInfo("PSwitchOccupationReq.processImp@not open|roleid=%d|new_occup=%d|old_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if ((!OpenInterface.getOpenStatus(278)) && 
/*  57 */       (this.newOccupation == 7)) {
/*  58 */       MultiOccupManager.logInfo("PSwitchOccupationReq.processImp@cang yu ge not open|roleid=%d|new_occup=%d|old_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  68 */     if ((!OpenInterface.getOpenStatus(425)) && 
/*  69 */       (this.newOccupation == 8)) {
/*  70 */       MultiOccupManager.logInfo("PSwitchOccupationReq.processImp@ling yin dian not open|roleid=%d|new_occup=%d|old_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  80 */     if (!NpcInterface.checkNpcService(this.npcid, SMultiOccupConsts.getInstance().SwitchService, this.roleid)) {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*     */ 
/*  88 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*     */ 
/*  91 */     MultiOccupation xMultiOccup = MultiOccupManager.getXMultiOccup(this.roleid, true);
/*  92 */     if (xMultiOccup == null) {
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     if (!MultiOccupManager.hasOccup(xMultiOccup, this.newOccupation)) {
/*  98 */       MultiOccupManager.logWarn("PSwitchOccupationReq.processImp@not have occupation|roleid=%d|new_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.newOccupation) });
/*     */       
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     int occup = RoleInterface.getOccupationId(this.roleid);
/* 106 */     if (occup != this.oldOccupation) {
/* 107 */       MultiOccupManager.logWarn("PSwitchOccupationReq.processImp@current occupation not match|roleid=%d|server_occup=%d|client_occup=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(occup), Integer.valueOf(this.oldOccupation) });
/*     */       
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 67, true))
/*     */     {
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     long gold = RoleInterface.getGold(this.roleid);
/*     */     
/* 122 */     if (this.currentGold != gold) {
/* 123 */       MultiOccupManager.logWarn("PSwitchOccupationReq.processImp@current gold not match|roleid=%d|server_gold=%d|client_gold=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(gold), Long.valueOf(this.currentGold) });
/*     */       
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 131 */     if (now < xMultiOccup.getSwitch_time() + MultiOccupConfigManager.getSwitchIntervalMillis()) {
/* 132 */       MultiOccupManager.sendNormalResult(this.roleid, 13);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     int costGold = SMultiOccupConsts.getInstance().SwitchNeedGold;
/* 137 */     TLogArg tlogArg = new TLogArg(LogReason.MULTI_OCCUP_SWITCH);
/*     */     
/*     */ 
/* 140 */     if (!RoleInterface.cutGold(this.roleid, costGold, tlogArg)) {
/* 141 */       MultiOccupManager.sendNormalResult(this.roleid, 11);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     int occupCount = xMultiOccup.getOccupations().size();
/*     */     
/*     */ 
/* 148 */     LinkedList<MultiOccupHandler> handlers = MultiOccupHandlerManager.getHandlers();
/* 149 */     for (MultiOccupHandler handler : handlers) {
/* 150 */       if (!handler.onSwitchOccupation(this.roleid, this.newOccupation, this.oldOccupation)) {
/* 151 */         MultiOccupManager.logError("PSwitchOccupationReq.processImp@handle failed|roleid=%d|current_occup=%d|new_occup=%d|activated_count=%d|class=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.oldOccupation), Integer.valueOf(this.newOccupation), Integer.valueOf(occupCount), handler.getClass().toString() });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 158 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 163 */     RoleInterface.setOccupationid(this.roleid, this.newOccupation);
/*     */     
/*     */ 
/* 166 */     MultiOccupManager.sendSwitchOccup(this.roleid, this.newOccupation);
/*     */     
/*     */ 
/* 169 */     RoleInterface.removeRoleOutFightObj(this.roleid);
/*     */     
/*     */ 
/* 172 */     xMultiOccup.setSwitch_time(now);
/*     */     
/*     */ 
/* 175 */     SwitchOccupArg arg = new SwitchOccupArg(this.roleid, this.newOccupation, this.oldOccupation);
/* 176 */     TriggerEventsManger.getInstance().triggerEvent(new SwitchOccup(), arg);
/*     */     
/* 178 */     int level = RoleInterface.getLevel(this.roleid);
/*     */     
/*     */ 
/* 181 */     TLogManager.getInstance().addLog(userid, "SwitchOccupation", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(level), Integer.valueOf(this.oldOccupation), Integer.valueOf(this.newOccupation), Integer.valueOf(costGold), GameServerInfoManager.getHostIP() });
/*     */     
/*     */ 
/*     */ 
/* 185 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\PSwitchOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */