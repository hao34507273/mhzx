/*     */ package mzm.gsp.firework.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.firework.SFindFireworkSuc;
/*     */ import mzm.gsp.firework.SPlayFindFireworkSucEffectBro;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapItemGatherHandler;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import xbean.FireworkInfo;
/*     */ import xbean.FireworkRecord;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Globalfirework;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FireWorkGatherItemHandler implements MapItemGatherHandler
/*     */ {
/*     */   private final int activityId;
/*     */   
/*     */   public FireWorkGatherItemHandler(int activityId)
/*     */   {
/*  34 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  41 */     Set<Lockey> lockeys = new HashSet();
/*  42 */     lockeys.add(Lockeys.get(User.getTable(), RoleInterface.getUserId(roleid)));
/*  43 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*  44 */     lockeys.add(Lockeys.get(Globalfirework.getTable(), Long.valueOf(GameServerInfoManager.getLocalId())));
/*  45 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean gatherCheck(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  52 */     if (RoleInterface.getLevel(roleid) < ActivityInterface.getActivityLevelMin(this.activityId))
/*     */     {
/*     */ 
/*  55 */       return false;
/*     */     }
/*  57 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onGather(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, int itemCfgid, int itemNum, MapItemGatherContext context)
/*     */   {
/*  64 */     SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/*  65 */     if (cfg == null)
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     FireworkInfo xFireworkInfo = Globalfirework.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  71 */     if (xFireworkInfo == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     FireworkRecord xFireworkRecord = (FireworkRecord)xFireworkInfo.getActivityid2record().get(Integer.valueOf(this.activityId));
/*  76 */     if (xFireworkRecord == null)
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */     {
/*  82 */       FireworkManager.loggerInfo("FireWorkGatherItemHandler.onGather@ forbid!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*  83 */       return false;
/*     */     }
/*  85 */     if (!ActivityInterface.isActivityOpen(this.activityId))
/*     */     {
/*  87 */       FireworkManager.loggerInfo("FireWorkGatherItemHandler.onGather@ activity closed!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*  88 */       return false;
/*     */     }
/*  90 */     if (xFireworkRecord.getCleansessionid() <= 0L)
/*     */     {
/*     */ 
/*  93 */       return false;
/*     */     }
/*  95 */     if (xFireworkRecord.getAlreadygetnum() >= FireworkGmDataCache.getInstance().getTriggerShowNeedCount(cfg))
/*     */     {
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     xFireworkRecord.setAlreadygetnum(xFireworkRecord.getAlreadygetnum() + 1);
/*     */     
/* 103 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(cfg.findSucFixAwardId, userid, roleid, false, true, new AwardReason(mzm.gsp.tlog.LogReason.FIREWORK_FIND_AWARD, this.activityId));
/*     */     
/* 105 */     if (awardModel == null)
/*     */     {
/* 107 */       FireworkManager.loggerError("FireWorkGatherItemHandler.onGather@ award err!|roleId=%d|fixAwardId=%d|activityId=%d|count=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfg.findSucFixAwardId), Integer.valueOf(this.activityId), Integer.valueOf(xFireworkRecord.getAlreadygetnum()) });
/*     */       
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     findFireworkBro(roleid, xFireworkRecord.getAlreadygetnum());
/*     */     
/* 115 */     checkStartFirework(cfg, xFireworkRecord);
/*     */     
/* 117 */     playFindSucEffectBro(roleid, context, worldid, mapCfgid);
/*     */     
/* 119 */     FireworkManager.tlogFindFirework(userid, roleid, this.activityId, xFireworkRecord.getAlreadygetnum());
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   private void playFindSucEffectBro(long roleId, MapItemGatherContext context, long worldid, int mapCfgid)
/*     */   {
/* 125 */     if (!(context instanceof PCCollectFireworkReq.CollectFireworkContext))
/*     */     {
/* 127 */       return;
/*     */     }
/* 129 */     Position p = ((PCCollectFireworkReq.CollectFireworkContext)context).getPos();
/* 130 */     if (p == null)
/*     */     {
/* 132 */       return;
/*     */     }
/* 134 */     if (MapInterface.getRoleWorldInstanceId(roleId) != worldid)
/*     */     {
/* 136 */       return;
/*     */     }
/* 138 */     if (MapInterface.getRoleMapId(roleId) != mapCfgid)
/*     */     {
/* 140 */       return;
/*     */     }
/* 142 */     SPlayFindFireworkSucEffectBro bro = new SPlayFindFireworkSucEffectBro();
/* 143 */     bro.location.x = p.getX();
/* 144 */     bro.location.y = p.getY();
/* 145 */     bro.mapid = mapCfgid;
/*     */     
/* 147 */     MapInterface.asyncBroadcastInSight(roleId, bro, true);
/*     */   }
/*     */   
/*     */   private void checkStartFirework(SFireworkCfg cfg, FireworkRecord xFireworkRecord)
/*     */   {
/* 152 */     if (xFireworkRecord.getAlreadygetnum() != FireworkGmDataCache.getInstance().getTriggerShowNeedCount(cfg))
/*     */     {
/* 154 */       return;
/*     */     }
/*     */     
/* 157 */     Session.removeSession(xFireworkRecord.getCleansessionid());
/*     */     
/* 159 */     xFireworkRecord.setCleansessionid(0L);
/*     */     
/* 161 */     FireworkManager.startFirework(this.activityId, OperFireorkReason.TIG_FINISH_COLLECT, xFireworkRecord);
/*     */   }
/*     */   
/*     */   private void findFireworkBro(long roleid, int alreadyGetNum)
/*     */   {
/* 166 */     SFindFireworkSuc p = new SFindFireworkSuc();
/* 167 */     p.activityid = this.activityId;
/* 168 */     p.num = alreadyGetNum;
/*     */     try
/*     */     {
/* 171 */       p.name.setString(RoleInterface.getName(roleid), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 177 */     OnlineManager.getInstance().sendAll(p);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireWorkGatherItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */