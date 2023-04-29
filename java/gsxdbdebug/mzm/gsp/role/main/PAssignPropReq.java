/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.event.RoleAddPointArg;
/*     */ import mzm.gsp.role.event.RoleAddPointEvent;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BasicPropertiesSystem;
/*     */ import xbean.Properties;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAssignPropReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int BPSysIndex;
/*     */   private final Map<Integer, Integer> assignPropMap;
/*  28 */   int totalAssign = 0;
/*     */   
/*     */   public PAssignPropReq(long roleId, int BPSysIndex, Map<Integer, Integer> assignPropMap)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.assignPropMap = assignPropMap;
/*  34 */     this.BPSysIndex = BPSysIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!canActiveAssignPropInStatus(this.roleId))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/*  45 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/*  46 */     BasicPropertiesSystem xBPSys = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(this.BPSysIndex));
/*  47 */     if (xBPSys == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     int xTotalPoint = xBPSys.getPotentialpoint();
/*     */     
/*  53 */     Map<Integer, Integer> changedFinalProps = getChangedProps(xBPSys.getBasicpropertymap(), xTotalPoint);
/*  54 */     if (changedFinalProps == null)
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     xBPSys.getBasicpropertymap().putAll(changedFinalProps);
/*  59 */     xBPSys.setPotentialpoint(xTotalPoint - this.totalAssign);
/*  60 */     role.setMP(role.getFinalMaxMP());
/*  61 */     role.setHP(role.getFinalMaxHP());
/*  62 */     role.syncClientRoleProperty();
/*     */     
/*  64 */     TriggerEventsManger.getInstance().triggerEvent(new RoleAddPointEvent(), new RoleAddPointArg(this.roleId, false));
/*     */     
/*  66 */     LogRolePropertySystemManager.tlogRolePropertySystem(RoleInterface.getUserId(this.roleId), this.roleId, xProperties, 2, this.BPSysIndex);
/*     */     
/*  68 */     return true;
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
/*     */   private Map<Integer, Integer> getChangedProps(Map<Integer, Integer> propMap, int xTotalPoint)
/*     */   {
/*  82 */     if (xTotalPoint <= 0)
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[role]PAssignPropReq.getFinalPropInfo@ no xTotalPoint!|roleId=%d|assignPropMap=%s|xTotalPoint=%d", new Object[] { Long.valueOf(this.roleId), this.assignPropMap.toString(), Integer.valueOf(xTotalPoint) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       return null;
/*     */     }
/*  90 */     Set<Integer> mainProps = RoleManager.getPropSet();
/*  91 */     if ((this.assignPropMap.size() == 0) || (this.assignPropMap.size() > mainProps.size()))
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[role]PAssignPropReq.getFinalPropInfo@ assignPropMap size err!|roleId=%d|assignPropMap=%s", new Object[] { Long.valueOf(this.roleId), this.assignPropMap.toString() }));
/*     */       
/*     */ 
/*  96 */       return null;
/*     */     }
/*  98 */     Map<Integer, Integer> changedProps = new HashMap();
/*  99 */     Iterator<Map.Entry<Integer, Integer>> it = this.assignPropMap.entrySet().iterator();
/* 100 */     while (it.hasNext())
/*     */     {
/* 102 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 103 */       int propType = ((Integer)entry.getKey()).intValue();
/* 104 */       int propValue = ((Integer)entry.getValue()).intValue();
/*     */       
/* 106 */       if (!mainProps.contains(Integer.valueOf(propType)))
/*     */       {
/* 108 */         GameServer.logger().error(String.format("[role]PAssignPropReq.getFinalPropInfo@ client propType illegal!|roleId=%d|assignPropMap=%s|propType=%d", new Object[] { Long.valueOf(this.roleId), this.assignPropMap.toString(), Integer.valueOf(propType) }));
/*     */         
/*     */ 
/*     */ 
/* 112 */         return null;
/*     */       }
/* 114 */       if ((propValue > xTotalPoint) || (propValue < 0))
/*     */       {
/* 116 */         GameServer.logger().error(String.format("[role]PAssignPropReq.getFinalPropInfo@ client propValue illegal!|roleId=%d|assignPropMap=%s|xTotalPoint=%d|propType=%d", new Object[] { Long.valueOf(this.roleId), this.assignPropMap.toString(), Integer.valueOf(xTotalPoint), Integer.valueOf(propType) }));
/*     */         
/*     */ 
/*     */ 
/* 120 */         return null;
/*     */       }
/* 122 */       if (propValue != 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 127 */         Integer oldPropValue = (Integer)propMap.get(Integer.valueOf(propType));
/* 128 */         if (oldPropValue == null)
/*     */         {
/* 130 */           oldPropValue = Integer.valueOf(0);
/*     */         }
/* 132 */         changedProps.put(Integer.valueOf(propType), Integer.valueOf(propValue + oldPropValue.intValue()));
/*     */         
/* 134 */         this.totalAssign += propValue;
/*     */       }
/*     */     }
/* 137 */     if (this.totalAssign > xTotalPoint)
/*     */     {
/* 139 */       GameServer.logger().error(String.format("[role]PAssignPropReq.getFinalPropInfo@ client totalAssign illegal!|roleId=%d|assignPropMap=%s|xTotalPoint=%d", new Object[] { Long.valueOf(this.roleId), this.assignPropMap.toString(), Integer.valueOf(xTotalPoint) }));
/*     */       
/*     */ 
/*     */ 
/* 143 */       return null;
/*     */     }
/*     */     
/* 146 */     return changedProps;
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
/*     */   private boolean canActiveAssignPropInStatus(long roleId)
/*     */   {
/* 160 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 62, true))
/*     */     {
/* 162 */       GameServer.logger().error(String.format("[role]PAssignPropReq.canActiveAssignPropInStatus@ active AssignProp is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 166 */       return false;
/*     */     }
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PAssignPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */