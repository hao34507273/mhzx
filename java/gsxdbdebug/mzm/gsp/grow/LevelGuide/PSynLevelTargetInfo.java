/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.grow.SSynLevelGuideInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xtable.Role2levelguide;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynLevelTargetInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PSynLevelTargetInfo(long roleId)
/*    */   {
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 31 */     if (xGuidesInfo == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     Map<Integer, xbean.LevelGuideInfo> xMap = xGuidesInfo.getTargets();
/* 36 */     if ((xMap == null) || (xMap.size() == 0))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     SSynLevelGuideInfo pro = new SSynLevelGuideInfo();
/* 42 */     fillPro(xMap, pro);
/* 43 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void fillPro(Map<Integer, xbean.LevelGuideInfo> xMap, SSynLevelGuideInfo pro)
/*    */   {
/* 56 */     Iterator<Map.Entry<Integer, xbean.LevelGuideInfo>> it = xMap.entrySet().iterator();
/* 57 */     while (it.hasNext())
/*    */     {
/* 59 */       Map.Entry<Integer, xbean.LevelGuideInfo> entry = (Map.Entry)it.next();
/* 60 */       int goalId = ((Integer)entry.getKey()).intValue();
/* 61 */       xbean.LevelGuideInfo xLevelGuideInfo = (xbean.LevelGuideInfo)entry.getValue();
/* 62 */       mzm.gsp.grow.LevelGuideInfo pInfo = new mzm.gsp.grow.LevelGuideInfo();
/* 63 */       pInfo.targetid = goalId;
/* 64 */       pInfo.targetstate = xLevelGuideInfo.getTargetstate();
/* 65 */       pro.targets.put(Integer.valueOf(goalId), pInfo);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PSynLevelTargetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */