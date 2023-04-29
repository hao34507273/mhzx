/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.corps.confbean.CorpsConsts;
/*    */ import xbean.Corps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PJoinCorpsByIDIP
/*    */   extends PJoinCorps
/*    */ {
/*    */   PJoinCorpsByIDIP(long roleId, Corps xCorps, long inviter)
/*    */   {
/* 17 */     super(roleId, xCorps, inviter);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   void addJoinHistory() {}
/*    */   
/*    */ 
/*    */ 
/*    */   boolean isCorpsFull()
/*    */   {
/* 28 */     return CorpsManager.getCorpsMemberSet(this.xCorps).size() >= CorpsConsts.getInstance().SAFE_CAPACITY;
/*    */   }
/*    */   
/*    */ 
/*    */   PJoinCorps.JoinCorpsReason getJoinCorpsReason()
/*    */   {
/* 34 */     return PJoinCorps.JoinCorpsReason.IDIP;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PJoinCorpsByIDIP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */