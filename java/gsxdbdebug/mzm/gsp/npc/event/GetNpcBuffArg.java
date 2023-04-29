/*    */ package mzm.gsp.npc.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class GetNpcBuffArg
/*    */ {
/*  7 */   public final List<Long> roleIds = new java.util.ArrayList();
/*    */   public final int npcId;
/*  9 */   public final List<Integer> buffids = new java.util.ArrayList();
/*    */   
/*    */   public GetNpcBuffArg(List<Long> roleids, int npcid, List<Integer> buffids) {
/* 12 */     this.roleIds.addAll(roleids);
/* 13 */     this.npcId = npcid;
/* 14 */     this.buffids.addAll(buffids);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\event\GetNpcBuffArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */