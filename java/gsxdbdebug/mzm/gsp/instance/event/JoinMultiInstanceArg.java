/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class JoinMultiInstanceArg
/*    */ {
/*  8 */   public final List<Long> joinRoles = new ArrayList();
/*    */   
/*    */   public final long endTime;
/*    */   public final int instanceid;
/*    */   
/*    */   public JoinMultiInstanceArg(List<Long> joinRoles, long endTime, int instanceid)
/*    */   {
/* 15 */     this.joinRoles.addAll(joinRoles);
/* 16 */     this.endTime = endTime;
/* 17 */     this.instanceid = instanceid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\JoinMultiInstanceArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */