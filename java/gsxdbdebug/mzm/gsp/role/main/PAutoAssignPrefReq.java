/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SAutoAssignPrefRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BasicPropertiesSystem;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ public class PAutoAssignPrefReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int BPSIndex;
/*    */   private final Map<Integer, Integer> assignProp;
/*    */   
/*    */   public PAutoAssignPrefReq(long roleId, int BPSIndex, Map<Integer, Integer> assignProp)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.BPSIndex = BPSIndex;
/* 26 */     this.assignProp = assignProp;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 33 */     BasicPropertiesSystem xBPSys = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(this.BPSIndex));
/* 34 */     if (xBPSys == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (xProperties.getLevel() < OccupationManager.getInstance().getOpenResetFuncLevel())
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     int[] mainPropArr = { 25, 27, 28, 26, 29 };
/*    */     
/* 45 */     int totalAssign = 0;
/* 46 */     for (int propType : mainPropArr)
/*    */     {
/* 48 */       Integer propValue = (Integer)this.assignProp.get(Integer.valueOf(propType));
/* 49 */       if ((propValue == null) || (propValue.intValue() < 0))
/*    */       {
/* 51 */         GameServer.logger().error(String.format("[role]PAutoAssignPrefReq.processImp@ propValue is null!|roleId=%d|BPSIndex=%d|assignProp=%s|propType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.BPSIndex), this.assignProp.toString(), Integer.valueOf(propType) }));
/*    */         
/*    */ 
/*    */ 
/* 55 */         return false;
/*    */       }
/* 57 */       xBPSys.getAutoassignpointpref().put(Integer.valueOf(propType), Integer.valueOf(propValue.intValue()));
/* 58 */       totalAssign += propValue.intValue();
/*    */     }
/*    */     
/* 61 */     if (totalAssign != 10)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     SAutoAssignPrefRes res = new SAutoAssignPrefRes();
/* 66 */     for (Integer propType : this.assignProp.keySet())
/*    */     {
/* 68 */       res.assignpropmap.put(propType, this.assignProp.get(propType));
/*    */     }
/* 70 */     res.propsys = this.BPSIndex;
/* 71 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 73 */     LogRolePropertySystemManager.tlogRolePropertySystem(RoleInterface.getUserId(this.roleId), this.roleId, xProperties, 1, this.BPSIndex);
/*    */     
/*    */ 
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PAutoAssignPrefReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */