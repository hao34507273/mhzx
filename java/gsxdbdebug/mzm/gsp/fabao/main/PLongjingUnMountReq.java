/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fabao.LongJingChangeInfo;
/*    */ import mzm.gsp.fabao.SLongjingUnMountErrorRes;
/*    */ import mzm.gsp.fabao.SLongjingUnMountSucRes;
/*    */ import mzm.gsp.fabao.SSynLongJingChangeInfo;
/*    */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*    */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*    */ import mzm.gsp.item.confbean.SLongJingItem;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.Item;
/*    */ import xbean.LongJing;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class PLongjingUnMountReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int fabaotype;
/*    */   private final int pos;
/*    */   
/*    */   public PLongjingUnMountReq(long roleid, int fabaotype, int pos)
/*    */   {
/* 31 */     this.roleId = roleid;
/* 32 */     this.fabaotype = fabaotype;
/* 33 */     this.pos = pos;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 38 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleId, 97)))
/*    */     {
/* 40 */       OpenInterface.sendBanPlayMsg(this.roleId, 97);
/* 41 */       return false;
/*    */     }
/* 43 */     if (FabaoManager.checkInCross(this.roleId)) {
/* 44 */       sendError(3);
/* 45 */       return false;
/*    */     }
/* 47 */     if ((this.pos > SFabaoConstants.getInstance().FABAO_MAX_HOLE) || (this.pos <= 0)) {
/* 48 */       sendError(1);
/* 49 */       return false;
/*    */     }
/* 51 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleId);
/* 52 */     LongJing xLongJing = (LongJing)xRoleFabaoSysInfo.getLongjingmap().get(Integer.valueOf(this.fabaotype));
/* 53 */     if (xLongJing == null) {
/* 54 */       sendError(1);
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     Item xItem = (Item)xLongJing.getLongjingitems().remove(Integer.valueOf(this.pos));
/* 59 */     if (xItem == null) {
/* 60 */       sendError(1);
/* 61 */       return false;
/*    */     }
/* 63 */     BasicItem basicItem = new BasicItem(xItem);
/* 64 */     int itemcfgid = basicItem.getCfgId();
/* 65 */     long itemUuid = basicItem.getFirstUuid().longValue();
/* 66 */     boolean ret = mzm.gsp.item.main.ItemInterface.moveItemInBag(this.roleId, basicItem, true);
/* 67 */     if (!ret) {
/* 68 */       sendError(2);
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     SLongjingUnMountSucRes longjingUnMountSucRes = new SLongjingUnMountSucRes();
/* 73 */     longjingUnMountSucRes.itemids.add(Integer.valueOf(itemcfgid));
/* 74 */     OnlineManager.getInstance().send(this.roleId, longjingUnMountSucRes);
/*    */     
/*    */ 
/* 77 */     SSynLongJingChangeInfo synLongJingChangeInfo = new SSynLongJingChangeInfo();
/* 78 */     LongJingChangeInfo longJingChangeInfo = new LongJingChangeInfo();
/* 79 */     longJingChangeInfo.rempositions.add(Integer.valueOf(this.pos));
/* 80 */     synLongJingChangeInfo.longjingchangeinfo.changed.put(Integer.valueOf(this.fabaotype), longJingChangeInfo);
/* 81 */     OnlineManager.getInstance().send(this.roleId, synLongJingChangeInfo);
/*    */     
/* 83 */     Map<Integer, List<Integer>> fabaoTypeToPos = new HashMap();
/* 84 */     List<Integer> posList = new ArrayList();
/* 85 */     posList.add(Integer.valueOf(this.pos));
/* 86 */     fabaoTypeToPos.put(Integer.valueOf(this.fabaotype), posList);
/* 87 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(this.roleId, fabaoTypeToPos);
/* 88 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fabao.event.FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*    */     
/* 90 */     SLongJingItem sLongJingItem = SLongJingItem.get(itemcfgid);
/* 91 */     FabaoManager.tlogEquipLongJing(this.roleId, 2, itemcfgid, itemUuid, this.pos, sLongJingItem.longjingtype, sLongJingItem.lv);
/*    */     
/* 93 */     return true;
/*    */   }
/*    */   
/*    */   private void sendError(int error) {
/* 97 */     SLongjingUnMountErrorRes longjingUnMountErrorRes = new SLongjingUnMountErrorRes();
/* 98 */     longjingUnMountErrorRes.resultcode = error;
/* 99 */     OnlineManager.getInstance().sendAtOnce(this.roleId, longjingUnMountErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongjingUnMountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */