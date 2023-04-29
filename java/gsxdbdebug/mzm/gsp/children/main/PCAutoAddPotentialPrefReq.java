/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SAutoAddPotentialPrefErrorRes;
/*     */ import mzm.gsp.children.SAutoAddPotentialPrefRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCAutoAddPotentialPrefReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*  19 */   private final Map<Integer, Integer> propMap = new HashMap();
/*     */   
/*     */   public PCAutoAddPotentialPrefReq(long roleid, long childrenid, Map<Integer, Integer> propmap) {
/*  22 */     this.roleid = roleid;
/*  23 */     this.childrenid = childrenid;
/*  24 */     this.propMap.putAll(propmap);
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  30 */       GameServer.logger().error(String.format("[Children]PCAutoAddPotentialPrefReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  34 */       return false;
/*     */     }
/*  36 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  37 */       GameServer.logger().error(String.format("[Children]PCAutoAddPotentialPrefReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  40 */       return false;
/*     */     }
/*  42 */     if (!ChildrenManager.checkPrefPoint(this.roleid, this.propMap)) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  47 */       GameServer.logger().error(String.format("[Children]PCAutoAddPotentialPrefReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  60 */     if (xChildInfo == null) {
/*  61 */       GameServer.logger().error(String.format("[Children]PCAutoAddPotentialPrefReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     int period = xChildInfo.getChild_period();
/*  74 */     if (period != 2) {
/*  75 */       GameServer.logger().error(String.format("[Children]PCAutoAddPotentialPrefReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  80 */       return false;
/*     */     }
/*  82 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  83 */     if (xAdulthoodInfo.getOccupation() <= 0) {
/*  84 */       sendError(1);
/*  85 */       return false;
/*     */     }
/*  87 */     if (xAdulthoodInfo.getBasepropset().size() > 0) {
/*  88 */       sendError(2);
/*  89 */       return false;
/*     */     }
/*  91 */     xAdulthoodInfo.getBasepropset().clear();
/*  92 */     xAdulthoodInfo.getBasepropset().putAll(this.propMap);
/*  93 */     xAdulthoodInfo.getBasepropmap().clear();
/*  94 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/*  96 */     xAdulthoodInfo.setPotentialpoint(SChildrenConsts.getInstance().child_level_up_add_potential_num * mzm.gsp.role.main.RoleInterface.getLevel(this.roleid));
/*     */     
/*     */ 
/*  99 */     childrenOutFightObj.autoSetPotentialPoint();
/*     */     
/* 101 */     childrenOutFightObj.updateOutFightProperty();
/* 102 */     childrenOutFightObj.synPropertyChange(this.roleid);
/* 103 */     SAutoAddPotentialPrefRes autoAddPotentialPrefRes = new SAutoAddPotentialPrefRes();
/* 104 */     autoAddPotentialPrefRes.childrenid = this.childrenid;
/* 105 */     autoAddPotentialPrefRes.propmap.putAll(this.propMap);
/* 106 */     OnlineManager.getInstance().send(this.roleid, autoAddPotentialPrefRes);
/*     */     
/* 108 */     ChildrenManager.tlogAdultPropPref(this.roleid, this.childrenid, this.propMap);
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int ret) {
/* 113 */     SAutoAddPotentialPrefErrorRes autoAddPotentialPrefErrorRes = new SAutoAddPotentialPrefErrorRes();
/* 114 */     autoAddPotentialPrefErrorRes.ret = ret;
/* 115 */     OnlineManager.getInstance().sendAtOnce(this.roleid, autoAddPotentialPrefErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCAutoAddPotentialPrefReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */