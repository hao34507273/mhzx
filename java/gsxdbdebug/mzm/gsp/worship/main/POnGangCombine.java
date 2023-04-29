/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.event.GangCombineArg;
/*    */ import mzm.gsp.gang.event.GangCombineProcedure;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xtable.Faction2worship;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangCombine
/*    */   extends GangCombineProcedure
/*    */ {
/*    */   long factionId;
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 29 */         Faction2worship.remove(Long.valueOf(((GangCombineArg)POnGangCombine.this.arg).viceGangid));
/*    */         
/* 31 */         WorshipManager.rmFactionMasterNpc(((GangCombineArg)POnGangCombine.this.arg).viceGangid);
/* 32 */         return true;
/*    */       }
/*    */       
/* 35 */     }.execute();
/* 36 */     Set<Long> gangMembers = GangInterface.getGangMemberList(((GangCombineArg)this.arg).mainGangid);
/* 37 */     if ((gangMembers == null) || (gangMembers.size() == 0))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     for (Iterator i$ = gangMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 43 */       NoneRealTimeTaskManager.getInstance().addTask(new PRoleOnCombine(roleId));
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnGangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */