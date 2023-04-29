/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface.RideAircraftObj;
/*    */ import mzm.gsp.fabao.main.FabaoInterface;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ import mzm.gsp.item.SQueryRoleEquipInfoRes;
/*    */ import mzm.gsp.item.SRoleEquipInfoNotAllowed;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.systemsetting.main.SystemSettingInterface;
/*    */ import mzm.gsp.wing.WingSimpleData;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ 
/*    */ public class PQueryRoleEquipInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long desroleid;
/*    */   
/*    */   public PQueryRoleEquipInfo(long roleid, long desroleid)
/*    */   {
/* 27 */     this.roleid = roleid;
/* 28 */     this.desroleid = desroleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (this.roleid == this.desroleid)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (SystemSettingInterface.getSetting(this.desroleid, 3).intValue() != 0)
/*    */     {
/*    */ 
/* 41 */       SRoleEquipInfoNotAllowed re = new SRoleEquipInfoNotAllowed();
/* 42 */       OnlineManager.getInstance().send(this.roleid, re);
/* 43 */       return true;
/*    */     }
/* 45 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(this.desroleid);
/* 46 */     if (equipBag == null)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     SQueryRoleEquipInfoRes res = new SQueryRoleEquipInfoRes();
/*    */     
/* 53 */     for (Map.Entry<Integer, BasicItem> entry : equipBag.getAllItems(true).entrySet())
/*    */     {
/* 55 */       ItemInfo iteminfo = new ItemInfo();
/* 56 */       ItemManager.fillInItemInfoBean(iteminfo, ((BasicItem)entry.getValue()).getItem());
/* 57 */       res.items.put(entry.getKey(), iteminfo);
/*    */     }
/* 59 */     WingSimpleData wingSimpleData = WingInterface.getWingSimpleData(this.desroleid);
/* 60 */     if (wingSimpleData != null)
/*    */     {
/* 62 */       res.winginfos.add(wingSimpleData);
/*    */     }
/*    */     
/* 65 */     ItemInfo itemInfo = FabaoInterface.getDisPlayFabaoItemInfo(this.desroleid, false);
/* 66 */     if (itemInfo != null)
/*    */     {
/* 68 */       res.fabaoinfos.add(itemInfo);
/*    */     }
/*    */     
/* 71 */     AircraftInterface.RideAircraftObj rideAircraftObj = AircraftInterface.getRideAircraftObj(this.desroleid, false);
/* 72 */     if (rideAircraftObj != null)
/*    */     {
/* 74 */       res.aircraft.aircraft_cfg_id = rideAircraftObj.aircraftCfgId;
/* 75 */       res.aircraft.dye_color_id = rideAircraftObj.aircraftDyeColorId;
/*    */     }
/*    */     
/* 78 */     Role role = RoleInterface.getRole(this.desroleid, false);
/* 79 */     RoleInterface.fillModelInfo(this.desroleid, res.modelinfo);
/* 80 */     res.roleid = this.desroleid;
/* 81 */     res.level = role.getLevel();
/* 82 */     res.ocpid = role.getOccupationId();
/* 83 */     res.rolename = role.getName();
/* 84 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PQueryRoleEquipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */