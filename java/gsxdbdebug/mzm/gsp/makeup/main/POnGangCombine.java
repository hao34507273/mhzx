/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gang.event.GangCombineArg;
/*    */ import mzm.gsp.gang.event.GangCombineProcedure;
/*    */ import xbean.FactionMakeUpInfo;
/*    */ import xbean.FactionMakeUpRecord;
/*    */ import xtable.Gang;
/*    */ import xtable.Gangmakeup;
/*    */ 
/*    */ public class POnGangCombine
/*    */   extends GangCombineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(((GangCombineArg)this.arg).mainGangid), Long.valueOf(((GangCombineArg)this.arg).viceGangid) }));
/* 20 */     FactionMakeUpInfo xMainFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(((GangCombineArg)this.arg).mainGangid));
/* 21 */     FactionMakeUpInfo xViceFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(((GangCombineArg)this.arg).viceGangid));
/* 22 */     if (xViceFactionMakeUpInfo == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     for (Map.Entry<Integer, FactionMakeUpRecord> entry : xMainFactionMakeUpInfo.getActivityid2record().entrySet())
/*    */     {
/* 28 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 29 */       FactionMakeUpRecord xViceFactionMakeUpRecord = (FactionMakeUpRecord)xViceFactionMakeUpInfo.getActivityid2record().get(Integer.valueOf(activityId));
/* 30 */       if (xViceFactionMakeUpRecord != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 35 */         FactionMakeUpRecord xMainFactionMakeUpRecord = (FactionMakeUpRecord)entry.getValue();
/* 36 */         if (xMainFactionMakeUpRecord.getCurturn() == xViceFactionMakeUpRecord.getCurturn())
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 41 */           xMainFactionMakeUpRecord.setRightnum(xMainFactionMakeUpRecord.getRightnum() + xViceFactionMakeUpRecord.getRightnum());
/*    */           
/*    */ 
/* 44 */           xMainFactionMakeUpRecord.getJoinroleids().addAll(xViceFactionMakeUpRecord.getJoinroleids());
/*    */         }
/*    */       } }
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\POnGangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */