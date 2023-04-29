/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.superequipment.SPutOnWuShiSuccess;
/*    */ import mzm.gsp.superequipment.SWuShiError;
/*    */ import mzm.gsp.superequipment.wushi.confbean.WuShiCfg;
/*    */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShi;
/*    */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShiArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WuShiInfo;
/*    */ import xbean.WuShiInfoMap;
/*    */ import xtable.Role2wushiinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCPutOnWuShi
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int wushicfgid;
/*    */   
/*    */   public PCPutOnWuShi(long roleId, int wushicfgid)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.wushicfgid = wushicfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     boolean ret = WuShiManager.checkSwitchAndCross(this.roleId, 1611);
/* 38 */     if (!ret)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     WuShiCfg wuShiCfg = WuShiCfg.get(this.wushicfgid);
/* 44 */     if (wuShiCfg == null)
/*    */     {
/* 46 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(1));
/* 47 */       return false;
/*    */     }
/* 49 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(this.roleId));
/* 50 */     if (xWuShiInfoMap == null)
/*    */     {
/* 52 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(2));
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     Map<Integer, WuShiInfo> xWuShiCfgId2wuShiInfoMap = xWuShiInfoMap.getWushicfgid2wushiinfo();
/* 57 */     if (!xWuShiCfgId2wuShiInfoMap.containsKey(Integer.valueOf(this.wushicfgid)))
/*    */     {
/* 59 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(2));
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     WuShiInfo xWuShiInfo = (WuShiInfo)xWuShiCfgId2wuShiInfoMap.get(Integer.valueOf(this.wushicfgid));
/* 64 */     if (xWuShiInfo.getIsactivate() == 4)
/*    */     {
/* 66 */       return false;
/*    */     }
/* 68 */     if (xWuShiInfoMap.getOnwushicfgid() == this.wushicfgid)
/*    */     {
/* 70 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 74 */     EquipmentItem equipmentItem = ItemInterface.getRoleEquipByWearPos(this.roleId, 0);
/* 75 */     if ((equipmentItem == null) || (equipmentItem.getSuperEquipmentStage() <= 0))
/*    */     {
/* 77 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SWuShiError(5));
/* 78 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 82 */     xWuShiInfoMap.setOnwushicfgid(this.wushicfgid);
/*    */     
/*    */ 
/* 85 */     TriggerEventsManger.getInstance().triggerEvent(new PutOnSuperEquipmentWuShi(), new PutOnSuperEquipmentWuShiArg(this.roleId, this.wushicfgid));
/*    */     
/*    */ 
/* 88 */     OnlineManager.getInstance().send(this.roleId, new SPutOnWuShiSuccess(this.wushicfgid));
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PCPutOnWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */