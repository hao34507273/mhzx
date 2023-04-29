/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.grow.SSynLevelGuideInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xtable.Role2levelguide;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetLevelGuideInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetLevelGuideInfoReq(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 29 */     if (xGuidesInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     SSynLevelGuideInfo levelGuidePro = new SSynLevelGuideInfo();
/* 34 */     fillLevelGuidePro(xGuidesInfo, levelGuidePro);
/* 35 */     OnlineManager.getInstance().send(this.roleId, levelGuidePro);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void fillLevelGuidePro(RoleLevelGuidesInfo xGuidesInfo, SSynLevelGuideInfo levelGuidePro)
/*    */   {
/* 47 */     for (xbean.LevelGuideInfo xInfo : xGuidesInfo.getTargets().values())
/*    */     {
/* 49 */       int moduleType = LevelGuideManager.getGoalType(xInfo.getTargetid());
/* 50 */       if (moduleType == 1)
/*    */       {
/*    */ 
/*    */ 
/* 54 */         int targetId = xInfo.getTargetid();
/* 55 */         int targetState = xInfo.getTargetstate();
/* 56 */         mzm.gsp.grow.LevelGuideInfo pInfo = new mzm.gsp.grow.LevelGuideInfo();
/* 57 */         pInfo.targetid = targetId;
/* 58 */         pInfo.targetstate = targetState;
/*    */         
/* 60 */         switch (targetState)
/*    */         {
/*    */         case 2: 
/* 63 */           levelGuidePro.notawardtargets.add(Integer.valueOf(targetId));
/* 64 */           break;
/*    */         case 3: 
/* 66 */           levelGuidePro.handuptargets.add(Integer.valueOf(targetId));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PCGetLevelGuideInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */