/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.activity.confbean.SActiveAwardBean;
/*    */ import mzm.gsp.activity.confbean.SActiviteAwardCfg;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.Active;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActiveInterface
/*    */ {
/*    */   public static int getTotalActiveValue(long roleid)
/*    */   {
/* 24 */     Active xActive = ActiveManager.checkAndInitActive(roleid, DateTimeUtils.getCurrTimeInMillis());
/* 25 */     return ActiveManager.getTotalActiveValue(xActive);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isActiveAward(long roleId, int itemid)
/*    */   {
/* 36 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 37 */     TreeMap<Integer, SActiviteAwardCfg> sActiviteAwardCfgMap = (TreeMap)SActiviteAwardCfg.getAll();
/*    */     
/* 39 */     Map.Entry<Integer, SActiviteAwardCfg> entry = sActiviteAwardCfgMap.floorEntry(Integer.valueOf(roleLevel));
/* 40 */     if (entry == null)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     SActiviteAwardCfg sActiviteAwardCfg = (SActiviteAwardCfg)entry.getValue();
/* 46 */     Set<Integer> awardItemSet = new HashSet();
/*    */     
/* 48 */     for (Map.Entry<Integer, SActiveAwardBean> activeAwardBeanEntry : sActiviteAwardCfg.active_award_map.entrySet())
/*    */     {
/* 50 */       awardItemSet.addAll(AwardInterface.getFixAwardItems(roleId, ((SActiveAwardBean)activeAwardBeanEntry.getValue()).award_id));
/*    */     }
/*    */     
/* 53 */     if (awardItemSet.contains(Integer.valueOf(itemid)))
/*    */     {
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\ActiveInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */