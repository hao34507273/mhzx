/*    */ package mzm.gsp.qingyunzhi.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingFightContext
/*    */   implements FightContext
/*    */ {
/*    */   private final int outPostType;
/*    */   private final int chapter;
/*    */   private final int section;
/*    */   private final List<Long> roleList;
/*    */   private final long curTime;
/*    */   
/*    */   public QingFightContext(int outPostType, int chapter, int section, List<Long> roleList, long curTime)
/*    */   {
/* 22 */     this.outPostType = outPostType;
/* 23 */     this.chapter = chapter;
/* 24 */     this.section = section;
/* 25 */     this.roleList = roleList;
/* 26 */     this.curTime = curTime;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 31 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderIdEnterFight()
/*    */   {
/* 40 */     return ((Long)this.roleList.get(0)).longValue();
/*    */   }
/*    */   
/*    */   public int getOutPostType() {
/* 44 */     return this.outPostType;
/*    */   }
/*    */   
/*    */   public int getChapter() {
/* 48 */     return this.chapter;
/*    */   }
/*    */   
/*    */   public int getSection() {
/* 52 */     return this.section;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleList() {
/* 56 */     return this.roleList;
/*    */   }
/*    */   
/*    */   public long getCurTime() {
/* 60 */     return this.curTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\QingFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */