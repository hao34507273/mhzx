/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.CorpsDetailInfo;
/*    */ import mzm.gsp.corps.CorpsMemberDetailInfo;
/*    */ import mzm.gsp.corps.SGetCorpsDetailInfoRep;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CorpsDutyMembers;
/*    */ 
/*    */ public class PCGetCorpsDetailInfoReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long corpsId;
/*    */   
/*    */   public PCGetCorpsDetailInfoReq(long roleId, long corpsId)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.corpsId = corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(this.corpsId));
/* 35 */     if (xCorps == null)
/*    */     {
/* 37 */       GameServer.logger().error(String.format("[corps]PCGetXCorpsInfoReq.processImp@ not have this corps,may be cross server req!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.corpsId) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 42 */       GrcInterface.getCrossBattleCorpsInfo(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID, this.corpsId, this.roleId);
/* 43 */       return true;
/*    */     }
/*    */     
/* 46 */     SGetCorpsDetailInfoRep p = new SGetCorpsDetailInfoRep();
/* 47 */     CorpsManager.fillCorpsBriefInfo(xCorps, p.corpsdetailinfo.corpsbriefinfo);
/* 48 */     for (Map.Entry<Integer, CorpsDutyMembers> entry : xCorps.getDuty2members().entrySet())
/*    */     {
/* 50 */       for (i$ = ((CorpsDutyMembers)entry.getValue()).getMembers().iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*    */         
/* 52 */         CorpsMemberDetailInfo detailInfo = new CorpsMemberDetailInfo();
/* 53 */         CorpsManager.fillPCorpsMember(xCorps, member, detailInfo.baseinfo);
/* 54 */         CorpsManager.fillPCorpsMemberOtherInfo(member, detailInfo.otherinfo);
/* 55 */         p.corpsdetailinfo.members.put(Long.valueOf(member), detailInfo);
/*    */       } }
/*    */     Iterator i$;
/* 58 */     OnlineManager.getInstance().send(this.roleId, p);
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCGetCorpsDetailInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */