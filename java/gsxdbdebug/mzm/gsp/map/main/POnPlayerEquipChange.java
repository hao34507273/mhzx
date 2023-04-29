/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.event.PlayerEquipChangeProcedure;
/*    */ import mzm.gsp.item.main.EquipChangeArg;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnPlayerEquipChange extends PlayerEquipChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((EquipChangeArg)this.arg).roleId;
/*    */     
/* 18 */     if (((EquipChangeArg)this.arg).changedWearPos.contains(Integer.valueOf(0)))
/*    */     {
/* 20 */       Map<Integer, Object> changeProps = new HashMap();
/* 21 */       EquipmentItem weapon = ItemInterface.getRoleEquipByWearPos(roleid, 0, true);
/* 22 */       if (weapon != null)
/*    */       {
/* 24 */         changeProps.put(Integer.valueOf(7), Integer.valueOf(weapon.getCfgId()));
/* 25 */         changeProps.put(Integer.valueOf(6), Integer.valueOf(weapon.getStrengthLevel()));
/*    */       }
/* 27 */       int level = ItemInterface.getWholeBodyMinQilinLevel(roleid, true);
/* 28 */       changeProps.put(Integer.valueOf(14), Integer.valueOf(level));
/* 29 */       new MMH_OnRoleAppearanceChanged(roleid, 3, changeProps).execute();
/*    */     }
/*    */     else
/*    */     {
/* 33 */       Map<Integer, Object> changeProps = new HashMap();
/* 34 */       int level = ItemInterface.getWholeBodyMinQilinLevel(roleid, true);
/* 35 */       changeProps.put(Integer.valueOf(14), Integer.valueOf(level));
/* 36 */       new MMH_OnRoleAppearanceChanged(roleid, 12, changeProps).execute();
/*    */     }
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */