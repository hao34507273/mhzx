/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGetCorpsZoneDone
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long corpsid;
/*    */   private final int activityCfgid;
/*    */   private final Map<Long, Integer> data;
/*    */   
/*    */   public PGetCorpsZoneDone(long roleid, long corpsid, int activityCfgid, Map<Long, Integer> data)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.corpsid = corpsid;
/* 18 */     this.activityCfgid = activityCfgid;
/* 19 */     this.data = data;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     CrossBattlePointManager.onGetCorpsZoneDone(this.roleid, this.corpsid, this.activityCfgid, this.data);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PGetCorpsZoneDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */