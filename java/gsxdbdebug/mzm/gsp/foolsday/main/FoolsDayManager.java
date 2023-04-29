/*    */ package mzm.gsp.foolsday.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Random;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*    */ import mzm.gsp.foolsday.confbean.SFoolsDayBuffCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FoolsDayManager
/*    */ {
/* 22 */   static final Logger logger = Logger.getLogger("foolsday");
/*    */   static final String ENCODING = "UTF-8";
/*    */   
/*    */   static void init()
/*    */   {
/* 27 */     ActivityInterface.registerActivityByLogicType(78, new FoolsDayActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFoolsDaySwitchOpenForRole(long roleid)
/*    */   {
/* 38 */     if (!OpenInterface.getOpenStatus(269))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (OpenInterface.isBanPlay(roleid, 269))
/*    */     {
/* 44 */       OpenInterface.sendBanPlayMsg(roleid, 269);
/* 45 */       return false;
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static List<Integer> getAlternativeBuffCfgids()
/*    */   {
/* 57 */     List<Integer> alternativeBuffCfgids = new ArrayList();
/* 58 */     TreeMap<Integer, Integer> remainBuffCfgids = new TreeMap();
/* 59 */     for (int i = 0; i < FoolsDayConsts.getInstance().REFRESH_BUFF_NUM; i++)
/*    */     {
/* 61 */       remainBuffCfgids.clear();
/* 62 */       int probability_sum = 0;
/* 63 */       for (SFoolsDayBuffCfg cfg : SFoolsDayBuffCfg.getAll().values())
/*    */       {
/* 65 */         if (!alternativeBuffCfgids.contains(Integer.valueOf(cfg.buff_id)))
/*    */         {
/*    */ 
/*    */ 
/* 69 */           probability_sum += cfg.probability;
/* 70 */           remainBuffCfgids.put(Integer.valueOf(probability_sum), Integer.valueOf(cfg.id));
/*    */         } }
/* 72 */       alternativeBuffCfgids.add(remainBuffCfgids.ceilingEntry(Integer.valueOf(Xdb.random().nextInt(((Integer)remainBuffCfgids.lastKey()).intValue()) + 1)).getValue());
/*    */     }
/* 74 */     return alternativeBuffCfgids;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\FoolsDayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */