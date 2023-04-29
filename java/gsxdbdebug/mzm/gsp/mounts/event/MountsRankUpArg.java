/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ 
/*    */ public class MountsRankUpArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final long mountsId;
/*    */   
/*    */   public final int mountsCfgId;
/*    */   public final int nowRank;
/*    */   
/*    */   public MountsRankUpArg(long roleId, long mountsId, int mountsCfgId, int nowRank)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.mountsId = mountsId;
/* 17 */     this.mountsCfgId = mountsCfgId;
/* 18 */     this.nowRank = nowRank;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MountsRankUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */