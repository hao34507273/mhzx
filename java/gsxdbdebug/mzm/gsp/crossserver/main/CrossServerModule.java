/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ 
/*    */ public class CrossServerModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 12 */     String roamServerDefaultMapCfgidValue = (String)envs.get("roam_server_default_map_cfgid");
/* 13 */     if (roamServerDefaultMapCfgidValue != null)
/*    */     {
/* 15 */       CrossServerManager.roamServerDefaultMapCfgid = Integer.parseInt(roamServerDefaultMapCfgidValue);
/*    */     }
/*    */     
/* 18 */     String matcheridValue = (String)envs.get("ladder_matcherid");
/* 19 */     if (matcheridValue != null)
/*    */     {
/* 21 */       CrossServerManager.ladderMatcherid = Integer.parseInt(matcheridValue);
/*    */     }
/*    */     
/* 24 */     matcheridValue = (String)envs.get("cross_compete_matcherid");
/* 25 */     if (matcheridValue != null)
/*    */     {
/* 27 */       CrossServerManager.crossCompeteMatcherid = Integer.parseInt(matcheridValue);
/*    */     }
/*    */     
/* 30 */     matcheridValue = (String)envs.get("cross_battle_point_matcherid");
/* 31 */     if (matcheridValue != null)
/*    */     {
/* 33 */       CrossServerManager.crossBattlePointMatcherid = Integer.parseInt(matcheridValue);
/*    */     }
/*    */     
/* 36 */     matcheridValue = (String)envs.get("cross_battle_knockout_matcherid");
/* 37 */     if (matcheridValue != null)
/*    */     {
/* 39 */       CrossServerManager.crossBattleKnockoutMatcherid = Integer.parseInt(matcheridValue);
/*    */     }
/*    */     
/* 42 */     matcheridValue = (String)envs.get("single_cross_field_matcherid");
/* 43 */     if (matcheridValue != null)
/*    */     {
/* 45 */       CrossServerManager.singleCrossFieldMatcherid = Integer.parseInt(matcheridValue);
/*    */     }
/*    */     
/* 48 */     matcheridValue = (String)envs.get("all_lotto_matcherid");
/* 49 */     if (matcheridValue != null)
/*    */     {
/* 51 */       CrossServerManager.allLottoMatcherid = Integer.parseInt(matcheridValue);
/*    */     }
/*    */     
/* 54 */     CrossServerManager.init();
/*    */     
/* 56 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 62 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 68 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 74 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\CrossServerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */