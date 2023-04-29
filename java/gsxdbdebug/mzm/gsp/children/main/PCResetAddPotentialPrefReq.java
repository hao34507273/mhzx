/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SResetAddPotentialPrefErrorRes;
/*     */ import mzm.gsp.children.SResetAddPotentialPrefRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ 
/*     */ public class PCResetAddPotentialPrefReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final long moneyNum;
/*     */   
/*     */   public PCResetAddPotentialPrefReq(long roleid, long childrenid, long nowmoneynum)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.childrenid = childrenid;
/*  25 */     this.moneyNum = nowmoneynum;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  31 */       GameServer.logger().error(String.format("[Children]PCResetAddPotentialPrefReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  35 */       return false;
/*     */     }
/*  37 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  38 */       GameServer.logger().error(String.format("[Children]PCResetAddPotentialPrefReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  47 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  48 */       GameServer.logger().error(String.format("[Children]PCResetAddPotentialPrefReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  61 */     if (xChildInfo == null) {
/*  62 */       GameServer.logger().error(String.format("[Children]PCResetAddPotentialPrefReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     int period = xChildInfo.getChild_period();
/*  75 */     if (period != 2) {
/*  76 */       GameServer.logger().error(String.format("[Children]PCResetAddPotentialPrefReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*  83 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  84 */     if (xAdulthoodInfo.getOccupation() <= 0) {
/*  85 */       sendError(1);
/*  86 */       return false;
/*     */     }
/*  88 */     if (xAdulthoodInfo.getBasepropset().size() <= 0) {
/*  89 */       sendError(2);
/*  90 */       return false;
/*     */     }
/*  92 */     long hasGold = RoleInterface.getGold(this.roleid);
/*  93 */     if (hasGold != this.moneyNum) {
/*  94 */       GameServer.logger().info(String.format("[Children]PCResetAddPotentialPrefReq.processImp@gold num error|roleid=%d|childid=%d|goldNum=%d|hasNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Long.valueOf(this.moneyNum), Long.valueOf(hasGold) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/* 101 */     boolean ret = RoleInterface.cutGold(this.roleid, SChildrenConsts.getInstance().resetPrefCost, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_ADULT_RESET_AOTU_SET_COST));
/*     */     
/* 103 */     if (!ret) {
/* 104 */       sendError(3);
/* 105 */       return false;
/*     */     }
/* 107 */     xAdulthoodInfo.getBasepropset().clear();
/*     */     
/*     */ 
/* 110 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 112 */     xAdulthoodInfo.getBasepropmap().clear();
/* 113 */     xAdulthoodInfo.setPotentialpoint(SChildrenConsts.getInstance().child_level_up_add_potential_num * RoleInterface.getLevel(this.roleid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 118 */     childrenOutFightObj.updateOutFightProperty();
/* 119 */     childrenOutFightObj.synPropertyChange(this.roleid);
/* 120 */     SResetAddPotentialPrefRes prefRes = new SResetAddPotentialPrefRes();
/* 121 */     prefRes.childrenid = this.childrenid;
/*     */     
/* 123 */     OnlineManager.getInstance().send(this.roleid, prefRes);
/*     */     
/* 125 */     ChildrenManager.tlogAdultPropPref(this.roleid, this.childrenid, new HashMap());
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 130 */     SResetAddPotentialPrefErrorRes resetAddPotentialPrefErrorRes = new SResetAddPotentialPrefErrorRes();
/* 131 */     resetAddPotentialPrefErrorRes.ret = error;
/* 132 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resetAddPotentialPrefErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCResetAddPotentialPrefReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */