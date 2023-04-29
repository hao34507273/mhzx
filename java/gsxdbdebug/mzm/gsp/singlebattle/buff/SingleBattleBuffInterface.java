/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.singlebattle.confbean.SBuffInfoCfg;
/*    */ import mzm.gsp.singlebattle.confbean.SLeaderBuffInfoCfg;
/*    */ import mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleBattleBuffInterface
/*    */ {
/*    */   public static void init()
/*    */   {
/* 22 */     SingleBattleInterface.registerPlayHandler(5, new BuffPlayTypeHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getOccupyCostTime(long roleid)
/*    */   {
/* 36 */     for (SBuffInfoCfg cfg : SOccupyBuffInfoCfg.getAll().values())
/*    */     {
/* 38 */       if (cfg.type == 2)
/*    */       {
/*    */ 
/*    */ 
/* 42 */         SOccupyBuffInfoCfg occupyBuffInfoCfg = (SOccupyBuffInfoCfg)cfg;
/* 43 */         if (BuffInterface.isContainBuff(roleid, occupyBuffInfoCfg.buff_cfg_id))
/*    */         {
/* 45 */           return occupyBuffInfoCfg.occupy_cost_time_in_second; }
/*    */       }
/*    */     }
/* 48 */     return -1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getResourceMultiple(long roleid)
/*    */   {
/* 62 */     for (SBuffInfoCfg cfg : SLeaderBuffInfoCfg.getAll().values())
/*    */     {
/* 64 */       if (cfg.type == 3)
/*    */       {
/*    */ 
/*    */ 
/* 68 */         SLeaderBuffInfoCfg leaderBuffInfoCfg = (SLeaderBuffInfoCfg)cfg;
/* 69 */         if (BuffInterface.isContainBuff(roleid, leaderBuffInfoCfg.buff_cfg_id))
/*    */         {
/* 71 */           return leaderBuffInfoCfg.resource_multiple; }
/*    */       }
/*    */     }
/* 74 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\SingleBattleBuffInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */