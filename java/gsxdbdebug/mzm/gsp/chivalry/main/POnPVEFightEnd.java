/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.ChivalryAddInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2chivalryaddinfo;
/*    */ 
/*    */ public class POnPVEFightEnd
/*    */   extends PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 21 */     if (!OpenInterface.getOpenStatus(437))
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 27 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     lock(Basic.getTable(), ((PVEFightEndArg)this.arg).roleList);
/*    */     
/* 35 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 38 */       if (OpenInterface.isBanPlay(roleId, 437))
/*    */       {
/* 40 */         OpenInterface.sendBanPlayMsg(roleId, 437);
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 45 */         ChivalryAddInfo xChivalryAddInfo = Role2chivalryaddinfo.get(Long.valueOf(roleId));
/* 46 */         if (null != xChivalryAddInfo)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 51 */           for (Map.Entry<Integer, Integer> entry : xChivalryAddInfo.getGaintype2addnumonpveend().entrySet())
/*    */           {
/* 53 */             int addType = ((Integer)entry.getKey()).intValue();
/* 54 */             int addNum = ((Integer)entry.getValue()).intValue();
/* 55 */             if (addNum != 0)
/*    */             {
/*    */ 
/*    */ 
/* 59 */               TLogArg logArg = new TLogArg(LogReason.AWARD_CHIVALRY_ON_PVE_END, addType);
/* 60 */               ChivalryInterface.addRoleChivalry(roleId, addNum, addType, logArg, true);
/*    */             }
/*    */           } } } }
/*    */     long roleId;
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */