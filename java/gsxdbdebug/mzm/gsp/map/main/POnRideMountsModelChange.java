/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeProcedure;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ import mzm.gsp.mounts.main.MountsInterface.RideMountsObj;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRideMountsModelChange
/*    */   extends RideMountsModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((RideMountsModelChangeArg)this.arg).getRoleId();
/* 19 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(roleid, true);
/* 20 */     if (((RideMountsModelChangeArg)this.arg).getChangeReson() == 0)
/*    */     {
/* 22 */       if (rideMountsObj != null)
/*    */       {
/* 24 */         Map<Integer, Object> changeProps = new HashMap();
/* 25 */         changeProps.put(Integer.valueOf(11), Integer.valueOf(rideMountsObj.getColorId()));
/* 26 */         new MMH_OnRoleAppearanceChanged(roleid, 10, changeProps).execute();
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 31 */       Map<Integer, Object> changeProps = new HashMap();
/* 32 */       if (rideMountsObj != null)
/*    */       {
/* 34 */         changeProps.put(Integer.valueOf(10), Integer.valueOf(rideMountsObj.getMountsCfgId()));
/* 35 */         changeProps.put(Integer.valueOf(11), Integer.valueOf(rideMountsObj.getColorId()));
/* 36 */         changeProps.put(Integer.valueOf(15), Integer.valueOf(rideMountsObj.getMountsRank()));
/* 37 */         int mountsSpeed = rideMountsObj.getMountsSpeed();
/* 38 */         if (mountsSpeed > 0)
/*    */         {
/* 40 */           changeProps.put(Integer.valueOf(12), Integer.valueOf(rideMountsObj.getMountsSpeed()));
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 45 */           Role role = RoleInterface.getRole(roleid, true);
/* 46 */           changeProps.put(Integer.valueOf(12), Integer.valueOf(role.getVelocity()));
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 51 */         Role role = RoleInterface.getRole(roleid, true);
/* 52 */         changeProps.put(Integer.valueOf(12), Integer.valueOf(role.getVelocity()));
/*    */       }
/* 54 */       new MMH_OnRoleAppearanceChanged(roleid, 9, changeProps).execute();
/*    */     }
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRideMountsModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */