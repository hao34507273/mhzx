/*     */ package mzm.gsp.singlebattle.grab;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.PositionData;
/*     */ import mzm.gsp.singlebattle.SSynPositionChangeBro;
/*     */ import mzm.gsp.singlebattle.SSynTotalPositionInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import xbean.BattleGrabData;
/*     */ import xbean.GrabPositionData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GrabPositionManager
/*     */ {
/*     */   static void synBattlePositionInfo(BattleGrabData xBattleGrabData, long roleId)
/*     */   {
/*  23 */     SSynTotalPositionInfo syn = new SSynTotalPositionInfo();
/*     */     
/*  25 */     Map<Long, Integer> role2GrabCount = new HashMap();
/*     */     
/*  27 */     for (Map.Entry<Integer, GrabPositionData> entry : xBattleGrabData.getPositiondatas().entrySet())
/*     */     {
/*  29 */       int positionId = ((Integer)entry.getKey()).intValue();
/*  30 */       GrabPositionData xGrabPositionData = (GrabPositionData)entry.getValue();
/*     */       
/*     */ 
/*  33 */       syn.positioninfos.put(Integer.valueOf(positionId), getPositionData(xGrabPositionData));
/*     */       
/*  35 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> grabEntry : xGrabPositionData.getRole2grabdata().entrySet())
/*     */       {
/*  37 */         xbean.RoleGrabPositionData xRoleGrabPositionData = (xbean.RoleGrabPositionData)grabEntry.getValue();
/*  38 */         addRoleGrabCount(((Long)grabEntry.getKey()).longValue(), xRoleGrabPositionData.getGrabtime().size(), role2GrabCount);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  43 */     for (Map.Entry<Long, Integer> entry : role2GrabCount.entrySet())
/*     */     {
/*  45 */       syn.rolegrabinfo.put(entry.getKey(), new mzm.gsp.singlebattle.RoleGrabPositionData(((Integer)entry.getValue()).intValue()));
/*     */     }
/*     */     
/*  48 */     OnlineManager.getInstance().send(roleId, syn);
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
/*     */   static void setPositionState(long battleId, GrabPositionData xGrabPositionData, int state, int positionId)
/*     */   {
/*  63 */     setPositionState(battleId, xGrabPositionData, -1, state, positionId);
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
/*     */ 
/*     */ 
/*     */   static void setPositionState(long battleId, GrabPositionData xGrabPositionData, int campId, int state, int positionId)
/*     */   {
/*  81 */     if (campId > 0)
/*     */     {
/*  83 */       xGrabPositionData.setCampid(campId);
/*     */     }
/*  85 */     xGrabPositionData.setState(state);
/*     */     
/*  87 */     SSynPositionChangeBro bro = new SSynPositionChangeBro();
/*  88 */     bro.positionid = positionId;
/*  89 */     bro.positiondata.campid = xGrabPositionData.getCampid();
/*  90 */     bro.positiondata.positionstate = xGrabPositionData.getState();
/*     */     
/*  92 */     SingleBattleInterface.battleBro(battleId, bro, false);
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
/*     */   private static void addRoleGrabCount(long roleId, int addCount, Map<Long, Integer> role2GrabCount)
/*     */   {
/* 107 */     if (addCount <= 0)
/*     */     {
/* 109 */       return;
/*     */     }
/* 111 */     Integer orgCount = (Integer)role2GrabCount.get(Long.valueOf(roleId));
/* 112 */     if (orgCount == null)
/*     */     {
/* 114 */       orgCount = Integer.valueOf(0);
/*     */     }
/* 116 */     role2GrabCount.put(Long.valueOf(roleId), Integer.valueOf(orgCount.intValue() + addCount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static PositionData getPositionData(GrabPositionData xGrabPositionData)
/*     */   {
/* 127 */     return new PositionData(xGrabPositionData.getCampid(), xGrabPositionData.getState());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\GrabPositionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */