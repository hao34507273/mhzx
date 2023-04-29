/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.marriage.SBroadCastMarriage;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.marriage.confbean.SMarriageLevelCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Ceremony;
/*    */ import xbean.Ceremonys;
/*    */ 
/*    */ public class WeddingPlaySession extends Session
/*    */ {
/*    */   private int step;
/*    */   
/*    */   public WeddingPlaySession(long interval, long level, int step)
/*    */   {
/* 22 */     super(interval, level);
/* 23 */     this.step = step;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 32 */         int nextStep = WeddingPlaySession.access$004(WeddingPlaySession.this);
/* 33 */         Ceremonys xSelectCeremonys = xtable.Weddingceremony.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 34 */         if ((xSelectCeremonys == null) || (xSelectCeremonys.getCeremonys().size() == 0)) {
/* 35 */           return false;
/*    */         }
/* 37 */         Ceremony xCeremony = (Ceremony)xSelectCeremonys.getCeremonys().get(0);
/* 38 */         long roleidA = xCeremony.getRoleid1();
/* 39 */         long roleidB = xCeremony.getRoleid2();
/* 40 */         lock(xtable.Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/* 41 */         int level = xCeremony.getLevel();
/*    */         
/* 43 */         Integer time = MarriageManager.getWeddingPlayCfg(level, nextStep);
/* 44 */         Ceremonys xCeremonys = xtable.Weddingceremony.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 45 */         if (xCeremonys == null) {
/* 46 */           return false;
/*    */         }
/* 48 */         if (xCeremonys.getCeremonys().size() <= 0) {
/* 49 */           return false;
/*    */         }
/* 51 */         if (time == null)
/*    */         {
/* 53 */           xCeremonys.getCeremonys().remove(0);
/* 54 */           SMarriageLevelCfg marriageLevelCfg = SMarriageLevelCfg.get(level);
/* 55 */           if (marriageLevelCfg != null) {
/* 56 */             mzm.gsp.map.main.ControllerInterface.triggerWorldControllerWithMaxSpawnNum(MapInterface.getBigWorldid(), SMarriageConsts.getInstance().sugerControlerid, marriageLevelCfg.triggerSugerCount);
/*    */           }
/*    */           else {
/* 59 */             GameServer.logger().error(String.format("[Marriage]WeddingPlaySession$1.processImp@marriage level config is not exist|level=%d|roleidA=%d|roleidB=%d", new Object[] { Integer.valueOf(level), Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/*    */             
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 66 */             mzm.gsp.map.main.ControllerInterface.triggerController(SMarriageConsts.getInstance().sugerControlerid);
/*    */           }
/* 68 */           if (xCeremonys.getCeremonys().size() > 0) {
/* 69 */             Ceremony xNextCeremony = (Ceremony)xCeremonys.getCeremonys().get(0);
/* 70 */             final long nextRoleidA = xNextCeremony.getRoleid1();
/* 71 */             long nextRoleidB = xNextCeremony.getRoleid2();
/* 72 */             final int levelCfgid = xNextCeremony.getLevel();
/*    */             
/* 74 */             NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */             {
/*    */               protected boolean processImp() throws Exception
/*    */               {
/* 78 */                 lock(xtable.Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(nextRoleidA), Long.valueOf(levelCfgid) }));
/* 79 */                 Integer time = MarriageManager.getWeddingPlayCfg(this.val$levelCfgid, 1);
/* 80 */                 if (time == null) {
/* 81 */                   time = Integer.valueOf(10);
/* 82 */                   GameServer.logger().error(String.format("[Marriage]WeddingPlaySession.processImp@do not have marriage level config|level=%d|step=%d", new Object[] { Integer.valueOf(this.val$levelCfgid), Integer.valueOf(1) }));
/*    */                 }
/*    */                 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 90 */                 new WeddingPlaySession(time.intValue(), this.val$levelCfgid, 1);
/*    */                 
/* 92 */                 SBroadCastMarriage sBroadCastMarriage = new SBroadCastMarriage();
/* 93 */                 sBroadCastMarriage.level = this.val$levelCfgid;
/* 94 */                 sBroadCastMarriage.roleida = nextRoleidA;
/* 95 */                 sBroadCastMarriage.roleidaname = RoleInterface.getName(nextRoleidA);
/* 96 */                 sBroadCastMarriage.roleidb = levelCfgid;
/* 97 */                 sBroadCastMarriage.roleidbname = RoleInterface.getName(levelCfgid);
/* 98 */                 sBroadCastMarriage.stage = 1;
/* 99 */                 MapInterface.brocadCastInWorldMap(MapInterface.getBigWorldid(), SMarriageConsts.getInstance().marriageMapid, sBroadCastMarriage, true);
/*    */                 
/* :1 */                 return true;
/*    */               }
/*    */             });
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* :8 */           new WeddingPlaySession(time.intValue(), WeddingPlaySession.this.getOwerId(), nextStep);
/* :9 */           ((Ceremony)xCeremonys.getCeremonys().get(0)).setStage(nextStep);
/* ;0 */           SBroadCastMarriage sBroadCastMarriage = new SBroadCastMarriage();
/* ;1 */           sBroadCastMarriage.level = level;
/* ;2 */           sBroadCastMarriage.roleida = roleidA;
/* ;3 */           sBroadCastMarriage.roleidaname = RoleInterface.getName(roleidA);
/* ;4 */           sBroadCastMarriage.roleidb = roleidB;
/* ;5 */           sBroadCastMarriage.roleidbname = RoleInterface.getName(roleidB);
/* ;6 */           sBroadCastMarriage.stage = nextStep;
/* ;7 */           MapInterface.brocadCastInWorldMap(MapInterface.getBigWorldid(), SMarriageConsts.getInstance().marriageMapid, sBroadCastMarriage, true);
/*    */         }
/*    */         
/* <0 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\WeddingPlaySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */