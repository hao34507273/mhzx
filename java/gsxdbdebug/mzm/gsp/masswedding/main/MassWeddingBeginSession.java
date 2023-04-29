/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class MassWeddingBeginSession extends Session
/*    */ {
/*    */   private final List<Location> pathList;
/*    */   
/*    */   public MassWeddingBeginSession(long interval, long roleIdA, List<Location> pathList)
/*    */   {
/* 16 */     super(interval, roleIdA);
/* 17 */     this.pathList = pathList;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 26 */         MapInterface.groupMove(mzm.gsp.map.main.group.MapGroupType.MGT_GROUP_WEDDING, MassWeddingBeginSession.this.getOwerId(), MassWeddingBeginSession.this.pathList);
/* 27 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingBeginSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */