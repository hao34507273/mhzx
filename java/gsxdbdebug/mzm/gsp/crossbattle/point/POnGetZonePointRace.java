/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.SyncPointRacePromotion;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnGetZonePointRace
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int zone;
/*    */   private List<CorpsPointRaceInfo> corpsPointRaceInfos;
/*    */   
/*    */   public POnGetZonePointRace(int activityCfgid, int zone, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*    */   {
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.zone = zone;
/* 25 */     this.corpsPointRaceInfos = corpsPointRaceInfos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/* 32 */     if (cfg == null)
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[crossbattlepoint]POnGetZonePointRace.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */       
/*    */ 
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*    */     {
/* 43 */       GameServer.logger().error(String.format("[crossbattlepoint]POnGetZonePointRace.processImp@fun not open|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */       
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     List<CorpsPointRaceInfo> promotions = new ArrayList();
/* 50 */     int promotionNum = cfg.promotionCorpsNum;
/* 51 */     for (CorpsPointRaceInfo corpsPointRaceInfo : this.corpsPointRaceInfos)
/*    */     {
/* 53 */       long corpsid = corpsPointRaceInfo.getCorpsid();
/* 54 */       int rank = corpsPointRaceInfo.getRank();
/* 55 */       if ((rank >= 0) && (rank < promotionNum))
/*    */       {
/* 57 */         promotions.add(corpsPointRaceInfo);
/*    */       }
/* 59 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PPointRaceResult(this.activityCfgid, corpsid, corpsPointRaceInfo));
/*    */     }
/*    */     
/*    */ 
/* 63 */     if (promotions.isEmpty())
/*    */     {
/* 65 */       return true;
/*    */     }
/*    */     
/* 68 */     SyncPointRacePromotion msg = new SyncPointRacePromotion();
/* 69 */     msg.activity_cfgid = this.activityCfgid;
/* 70 */     msg.zone = this.zone;
/* 71 */     for (CorpsPointRaceInfo corpsPointRaceInfo : promotions)
/*    */     {
/* 73 */       OctetsStream os = new OctetsStream();
/* 74 */       os.setString(corpsPointRaceInfo.getCorpsName(), "UTF-8");
/* 75 */       msg.promotions.add(os);
/*    */     }
/* 77 */     OnlineManager.getInstance().sendAll(msg);
/*    */     
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnGetZonePointRace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */