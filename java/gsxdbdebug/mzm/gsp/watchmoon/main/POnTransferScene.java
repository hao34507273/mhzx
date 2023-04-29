/*     */ package mzm.gsp.watchmoon.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.group.MapGroupType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonMapCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Watchmoon;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2watchmoon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnTransferScene
/*     */   extends PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     SWatchmoonMapCfg watchmoonMapCfg = SWatchmoonMapCfg.get(((MapTransferArg)this.arg).newMapCfgId);
/*  32 */     if (watchmoonMapCfg == null)
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     long roleid = ((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue();
/*     */     
/*  38 */     Watchmoon xWatchmoon = Role2watchmoon.select(Long.valueOf(roleid));
/*  39 */     if (xWatchmoon == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     List<Long> roleids = new ArrayList();
/*  44 */     roleids.add(Long.valueOf(roleid));
/*  45 */     roleids.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/*     */     
/*  47 */     Lockeys.lock(Role2watchmoon.getTable(), roleids);
/*  48 */     if (!RoleStatusInterface.containsStatus(roleid, 28))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (xWatchmoon.getMapid() != ((MapTransferArg)this.arg).newMapCfgId)
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     Session session = Session.getSession(xWatchmoon.getSessionid());
/*  57 */     if ((session == null) || (!(session instanceof FlySession)))
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     FlySession flySession = (FlySession)session;
/*     */     
/*  63 */     if (flySession.addAndGet() != roleids.size())
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     watchmoonMapCfg = SWatchmoonMapCfg.get(xWatchmoon.getMapid());
/*     */     
/*  71 */     List<Location> keyPathList = new ArrayList();
/*  72 */     keyPathList.add(new Location(watchmoonMapCfg.startposX, watchmoonMapCfg.startposY));
/*  73 */     keyPathList.add(new Location(watchmoonMapCfg.endposX, watchmoonMapCfg.endposY));
/*     */     
/*  75 */     int feijian = SWatchmoonConsts.getInstance().DEFAULT_FEIJIAN_CFG_ID;
/*     */     
/*  77 */     SFeiJianCfg cfg = SFeiJianCfg.get(feijian);
/*  78 */     if (cfg == null)
/*     */     {
/*  80 */       String logstr = String.format("[watchmoon]POnTransferScene.processImp@warch moon error SFeiJianCfg null|invitorRoleid=%d|inviteeRoleid=%d|feijian=%d", new Object[] { roleids.get(0), roleids.get(1), Integer.valueOf(feijian) });
/*     */       
/*     */ 
/*  83 */       WatchmoonManager.logger.info(logstr);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (xWatchmoon.getIscouple())
/*     */     {
/*  89 */       List<Long> list = new ArrayList();
/*  90 */       if (RoleInterface.getGender(roleid) == 1)
/*     */       {
/*  92 */         list.add(Long.valueOf(roleid));
/*  93 */         list.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  98 */         list.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/*  99 */         list.add(Long.valueOf(roleid));
/*     */       }
/*     */       
/*     */ 
/* 103 */       MapInterface.addMapGroup(MapGroupType.MGT_WATCH_MOON_XYXW_FLY, xWatchmoon.getGroupid(), list, cfg.velocity);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 108 */       MapInterface.addMapGroup(MapGroupType.MGT_WATCH_MOON_SIDE_BY_SIDE_FLY, xWatchmoon.getGroupid(), roleids, cfg.velocity);
/*     */     }
/*     */     
/*     */ 
/* 112 */     new PrepareToFlySession(SWatchmoonConsts.getInstance().PREPARE_FLY_TIME, roleids);
/*     */     
/*     */ 
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */