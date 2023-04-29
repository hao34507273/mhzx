/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoArg;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnKillLuanShiYaoMo
/*    */   extends KillLuanShiYaoMoProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Iterator<Map.Entry<Long, Integer>> it = ((KillLuanShiYaoMoArg)this.arg).role2FinishCountMap.entrySet().iterator();
/* 22 */     while (it.hasNext())
/*    */     {
/* 24 */       Map.Entry<Long, Integer> entry = (Map.Entry)it.next();
/* 25 */       final long roleId = ((Long)entry.getKey()).longValue();
/* 26 */       int count = ((Integer)entry.getValue()).intValue();
/*    */       
/* 28 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 33 */           return LostAwardManager.onActivityCountAdd(roleId, SLuanShiYaoMoConsts.getInstance().ACTIVITYID, this.val$count);
/*    */         }
/*    */       });
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnKillLuanShiYaoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */