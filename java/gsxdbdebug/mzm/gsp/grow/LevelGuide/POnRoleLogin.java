/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.grow.FunctionOpenInfo;
/*     */ import mzm.gsp.grow.SSynFunctionOpenInfo;
/*     */ import mzm.gsp.grow.SSynLevelGuideInfo;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleLevelGuidesInfo;
/*     */ import xtable.Role2levelguide;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     RoleLevelGuidesInfo xGuidesInfo = getRoleXData();
/*  29 */     synClientData(xGuidesInfo);
/*  30 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   RoleLevelGuidesInfo getRoleXData()
/*     */   {
/*  38 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get((Long)this.arg);
/*  39 */     if (xGuidesInfo == null)
/*     */     {
/*  41 */       xGuidesInfo = Pod.newRoleLevelGuidesInfo();
/*  42 */       LevelGuideManager.createRoleXData(xGuidesInfo);
/*  43 */       Role2levelguide.add((Long)this.arg, xGuidesInfo);
/*     */     }
/*     */     else
/*     */     {
/*  47 */       checkNewFunction(xGuidesInfo);
/*     */     }
/*  49 */     return xGuidesInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void synClientData(RoleLevelGuidesInfo xGuidesInfo)
/*     */   {
/*  59 */     SSynLevelGuideInfo LevelGuidePro = new SSynLevelGuideInfo();
/*     */     
/*  61 */     SSynFunctionOpenInfo functionPro = new SSynFunctionOpenInfo();
/*  62 */     fillTargetPro(xGuidesInfo, LevelGuidePro, functionPro);
/*  63 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), LevelGuidePro);
/*  64 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), functionPro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void fillTargetPro(RoleLevelGuidesInfo xGuidesInfo, SSynLevelGuideInfo levelGuidePro, SSynFunctionOpenInfo functionPro)
/*     */   {
/*  76 */     for (xbean.LevelGuideInfo xInfo : xGuidesInfo.getTargets().values())
/*     */     {
/*  78 */       int moduleType = LevelGuideManager.getGoalType(xInfo.getTargetid());
/*  79 */       int targetId = xInfo.getTargetid();
/*  80 */       int targetState = xInfo.getTargetstate();
/*  81 */       switch (moduleType)
/*     */       {
/*     */       case 1: 
/*  84 */         mzm.gsp.grow.LevelGuideInfo pInfo = new mzm.gsp.grow.LevelGuideInfo();
/*  85 */         pInfo.targetid = targetId;
/*  86 */         pInfo.targetstate = targetState;
/*     */         
/*     */ 
/*  89 */         switch (targetState)
/*     */         {
/*     */         case 2: 
/*  92 */           levelGuidePro.notawardtargets.add(Integer.valueOf(targetId));
/*  93 */           break;
/*     */         case 3: 
/*  95 */           levelGuidePro.handuptargets.add(Integer.valueOf(targetId));
/*     */         }
/*     */         
/*     */         
/*  99 */         break;
/*     */       
/*     */ 
/*     */ 
/*     */       case 2: 
/* 104 */         FunctionOpenInfo fInfo = new FunctionOpenInfo();
/* 105 */         fInfo.targetid = targetId;
/* 106 */         fInfo.targetstate = targetState;
/* 107 */         functionPro.targets.put(Integer.valueOf(fInfo.targetid), fInfo);
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkNewFunction(RoleLevelGuidesInfo xRoleLevelGuidesInfo)
/*     */   {
/* 126 */     Map<Integer, xbean.LevelGuideInfo> targets = xRoleLevelGuidesInfo.getTargets();
/* 127 */     Set<Integer> functionCfgIdSet = LevelGuideManager.getFunctionIds();
/* 128 */     for (Iterator i$ = functionCfgIdSet.iterator(); i$.hasNext();) { int functionCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 130 */       xbean.LevelGuideInfo xLevelGuideInfo = (xbean.LevelGuideInfo)targets.get(Integer.valueOf(functionCfgId));
/* 131 */       if (xLevelGuideInfo == null)
/*     */       {
/* 133 */         xLevelGuideInfo = Pod.newLevelGuideInfo();
/* 134 */         xLevelGuideInfo.setTargetid(functionCfgId);
/* 135 */         xLevelGuideInfo.setTargetparam(0);
/* 136 */         xLevelGuideInfo.setTargetstate(1);
/*     */         
/* 138 */         targets.put(Integer.valueOf(functionCfgId), xLevelGuideInfo);
/*     */       }
/*     */       
/*     */ 
/* 142 */       long roleId = ((Long)this.arg).longValue();
/* 143 */       int roleLevel = RoleInterface.getLevel(roleId);
/* 144 */       SLevelTargetCfg sLevelTargetCfg = SLevelTargetCfg.get(functionCfgId);
/* 145 */       int xTargetState = xLevelGuideInfo.getTargetstate();
/* 146 */       if (xTargetState != 3)
/*     */       {
/*     */ 
/*     */ 
/* 150 */         if ((sLevelTargetCfg.openLevel <= roleLevel) && (xTargetState != 2))
/*     */         {
/* 152 */           xLevelGuideInfo.setTargetstate(2);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */