/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadeConstCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeDoSingFailed;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapItemGatherHandler;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleFlowerParadeRecord;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2flowerparaderecord;
/*     */ 
/*     */ public class FlowerParadeMapItemHandler implements MapItemGatherHandler
/*     */ {
/*     */   static volatile FlowerParadeMapItemHandler instance;
/*     */   
/*     */   static FlowerParadeMapItemHandler getInstance()
/*     */   {
/*  27 */     if (instance == null)
/*     */     {
/*  29 */       synchronized (FlowerParadeMapItemHandler.class)
/*     */       {
/*  31 */         if (instance == null)
/*     */         {
/*  33 */           instance = new FlowerParadeMapItemHandler();
/*     */         }
/*     */       }
/*     */     }
/*  37 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  44 */     Set<Lockey> lockeys = new java.util.HashSet();
/*  45 */     lockeys.add(Lockeys.get(xtable.User.getTable(), RoleInterface.getUserId(roleid)));
/*  46 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*  47 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean gatherCheck(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  54 */     int activityId = FlowerParadeConstCfg.getInstance().activityId;
/*  55 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(activityId);
/*  56 */     if (cfg == null)
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  63 */     ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(RoleInterface.getUserId(roleid), roleid, activityId);
/*     */     
/*  65 */     if (!res.isCanJoin())
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[flowerparade]FlowerParadeMapItemHandler.gatherCheck@ can not join activity!|roleId=%d|resCode=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     RoleFlowerParadeRecord xRoleRecord = Role2flowerparaderecord.get(Long.valueOf(roleid));
/*  76 */     SFlowerParadeRedbagCfg redBagCfg = SFlowerParadeRedbagCfg.get(cfg.redbagGroupId);
/*  77 */     if (xRoleRecord != null)
/*     */     {
/*  79 */       if (redBagCfg.roleMaxGot > 0)
/*     */       {
/*  81 */         if (xRoleRecord.getRedbagawardcount() >= redBagCfg.roleMaxGot)
/*     */         {
/*  83 */           GameServer.logger().error(String.format("[flowerparade]FlowerParadeMapItemHandler.gatherCheck@ edbagawardcount bigger than danceAwardCount|roleId=%d|awardcount=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(xRoleRecord.getRedbagawardcount()) }));
/*     */           
/*     */ 
/*     */ 
/*  87 */           SFlowerParadeDoSingFailed protocol = new SFlowerParadeDoSingFailed(1);
/*  88 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  89 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  95 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onGather(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, int itemCfgid, int itemNum, MapItemGatherContext context)
/*     */   {
/* 102 */     RoleFlowerParadeRecord xRoleRecord = Role2flowerparaderecord.get(Long.valueOf(roleid));
/* 103 */     if (xRoleRecord == null)
/*     */     {
/* 105 */       xRoleRecord = xbean.Pod.newRoleFlowerParadeRecord();
/* 106 */       Role2flowerparaderecord.add(Long.valueOf(roleid), xRoleRecord);
/*     */     }
/* 108 */     int taketimes = xRoleRecord.getRedbagawardcount() + 1;
/* 109 */     xRoleRecord.setRedbagawardcount(taketimes);
/*     */     
/* 111 */     GameServer.logger().info(String.format("[flowerparade]FlowerParadeMapItemHandler.onGather@redbag|roleid=%d|worldid=%d|mapcfgid=%d|mapItemCfgid=%d|itemCfgid=%d|taketimes=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Integer.valueOf(itemCfgid), Integer.valueOf(taketimes) }));
/*     */     
/*     */ 
/*     */ 
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeMapItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */