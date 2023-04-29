/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fabao.LongJingChangeInfo;
/*     */ import mzm.gsp.fabao.SLongjingUnMountErrorRes;
/*     */ import mzm.gsp.fabao.SLongjingUnMountSucRes;
/*     */ import mzm.gsp.fabao.SSynLongJingChangeInfo;
/*     */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import xbean.Item;
/*     */ import xbean.LongJing;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ public class PLongJingUnMountAll extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fabaotype;
/*     */   
/*     */   public PLongJingUnMountAll(long roleid, int fabaoType)
/*     */   {
/*  31 */     this.roleId = roleid;
/*  32 */     this.fabaotype = fabaoType;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleId, 97)))
/*     */     {
/*  39 */       OpenInterface.sendBanPlayMsg(this.roleId, 97);
/*  40 */       return false;
/*     */     }
/*  42 */     if (FabaoManager.checkInCross(this.roleId)) {
/*  43 */       sendError(3);
/*  44 */       return false;
/*     */     }
/*  46 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleId);
/*  47 */     LongJing xLongJing = (LongJing)xRoleFabaoSysInfo.getLongjingmap().get(Integer.valueOf(this.fabaotype));
/*  48 */     if (xLongJing == null) {
/*  49 */       sendError(1);
/*  50 */       return false;
/*     */     }
/*  52 */     if (xLongJing.getLongjingitems().size() <= 0) {
/*  53 */       sendError(1);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     SLongjingUnMountSucRes longjingUnMountSucRes = new SLongjingUnMountSucRes();
/*     */     
/*  59 */     Iterator<Map.Entry<Integer, Item>> iterator = xLongJing.getLongjingitems().entrySet().iterator();
/*     */     
/*  61 */     List<Integer> remPosList = new ArrayList();
/*     */     
/*  63 */     while (iterator.hasNext()) {
/*  64 */       Map.Entry<Integer, Item> entry = (Map.Entry)iterator.next();
/*     */       
/*  66 */       iterator.remove();
/*  67 */       BasicItem basicItem = new BasicItem((Item)entry.getValue());
/*  68 */       long uuid = basicItem.getFirstUuid().longValue();
/*  69 */       boolean ret = mzm.gsp.item.main.ItemInterface.moveItemInBag(this.roleId, basicItem, true);
/*  70 */       if (!ret) {
/*  71 */         sendError(2);
/*  72 */         return false;
/*     */       }
/*  74 */       int itemcfgid = basicItem.getCfgId();
/*  75 */       longjingUnMountSucRes.itemids.add(Integer.valueOf(itemcfgid));
/*  76 */       int pos = ((Integer)entry.getKey()).intValue();
/*  77 */       remPosList.add(Integer.valueOf(pos));
/*  78 */       SLongJingItem equipedLongJingItem = SLongJingItem.get(itemcfgid);
/*  79 */       FabaoManager.tlogEquipLongJing(this.roleId, 2, itemcfgid, uuid, pos, equipedLongJingItem.longjingtype, equipedLongJingItem.lv);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  84 */     OnlineManager.getInstance().send(this.roleId, longjingUnMountSucRes);
/*     */     
/*     */ 
/*  87 */     SSynLongJingChangeInfo synLongJingChangeInfo = new SSynLongJingChangeInfo();
/*  88 */     LongJingChangeInfo longJingChangeInfo = new LongJingChangeInfo();
/*  89 */     longJingChangeInfo.rempositions.addAll(remPosList);
/*  90 */     synLongJingChangeInfo.longjingchangeinfo.changed.put(Integer.valueOf(this.fabaotype), longJingChangeInfo);
/*  91 */     OnlineManager.getInstance().send(this.roleId, synLongJingChangeInfo);
/*     */     
/*  93 */     Map<Integer, List<Integer>> fabaoTypeToPos = new HashMap();
/*  94 */     List<Integer> posList = new ArrayList();
/*  95 */     posList.addAll(remPosList);
/*  96 */     fabaoTypeToPos.put(Integer.valueOf(this.fabaotype), posList);
/*  97 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(this.roleId, fabaoTypeToPos);
/*  98 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fabao.event.FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 105 */     SLongjingUnMountErrorRes longjingUnMountErrorRes = new SLongjingUnMountErrorRes();
/* 106 */     longjingUnMountErrorRes.resultcode = error;
/* 107 */     OnlineManager.getInstance().sendAtOnce(this.roleId, longjingUnMountErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongJingUnMountAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */