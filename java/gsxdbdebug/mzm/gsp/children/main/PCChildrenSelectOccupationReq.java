/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenSelectOccupationRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.OccupationManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCChildrenSelectOccupationReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int occupation;
/*     */   
/*     */   public PCChildrenSelectOccupationReq(long roleid, long childrenid, int occupation)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.childrenid = childrenid;
/*  25 */     this.occupation = occupation;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  31 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  35 */       return false;
/*     */     }
/*  37 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  38 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  45 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  58 */     if (xChildInfo == null) {
/*  59 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int period = xChildInfo.getChild_period();
/*  73 */     if (period != 2) {
/*  74 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     boolean open = OccupationManager.isOccupationOpen(this.occupation, xChildInfo.getChild_gender());
/*  83 */     if (!open) {
/*  84 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@occupation error|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     boolean occupationSwitchOpen = RoleInterface.isOccupationOpen(this.occupation);
/*  92 */     if (!occupationSwitchOpen) {
/*  93 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@occupation switch is not open|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/* 100 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 101 */     int oldOccupation = xAdulthoodInfo.getOccupation();
/* 102 */     if (OccupationManager.isExistOccupation(oldOccupation)) {
/* 103 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@occupation exist|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 108 */       return false;
/*     */     }
/* 110 */     xAdulthoodInfo.setOccupation(this.occupation);
/* 111 */     SChildrenSelectOccupationRes childrenSelectOccupationRes = new SChildrenSelectOccupationRes();
/* 112 */     childrenSelectOccupationRes.childrenid = this.childrenid;
/* 113 */     childrenSelectOccupationRes.occupation = this.occupation;
/* 114 */     OnlineManager.getInstance().send(this.roleid, childrenSelectOccupationRes);
/*     */     
/* 116 */     ChildrenManager.tlogAdultSelectOccupation(this.roleid, this.childrenid, this.occupation);
/*     */     
/* 118 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 119 */     intParameterMap.put(Integer.valueOf(0), Integer.valueOf(this.occupation));
/* 120 */     ChildrenInterface.fillChildGrowthDiary(this.childrenid, intParameterMap, null, 20);
/*     */     
/*     */ 
/* 123 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenSelectOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */