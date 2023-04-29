/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetRealtimeRecordReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long recordid;
/*    */   
/*    */   public PCGetRealtimeRecordReq(long roleid, long recordid)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.recordid = recordid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (this.roleid < 0L)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     FightRecordManager.getRoamFightRecord(this.roleid, this.recordid);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCGetRealtimeRecordReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */