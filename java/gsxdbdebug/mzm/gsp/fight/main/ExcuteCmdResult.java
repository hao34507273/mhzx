/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.Play;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ExcuteCmdResult
/*    */ {
/* 10 */   private int playTime = 0;
/*    */   
/*    */ 
/* 13 */   private boolean needReexcute = false;
/*    */   
/*    */ 
/* 16 */   private List<Play> activePlayList = new LinkedList();
/*    */   
/* 18 */   private List<Play> passivePlayList = new LinkedList();
/*    */   
/* 20 */   private List<Play> recordPlayList = new LinkedList();
/*    */   
/* 22 */   public Skill skill = null;
/*    */   
/*    */   int getPlayTime() {
/* 25 */     return this.playTime;
/*    */   }
/*    */   
/*    */   public void addPlayTime(int playTime) {
/* 29 */     this.playTime += playTime;
/*    */   }
/*    */   
/*    */   boolean isNeedReexcute() {
/* 33 */     return this.needReexcute;
/*    */   }
/*    */   
/*    */   void setNeedReexcute(boolean needReexcute) {
/* 37 */     this.needReexcute = needReexcute;
/*    */   }
/*    */   
/*    */   List<Play> getPlayList(boolean active) {
/* 41 */     if (active) {
/* 42 */       return this.activePlayList;
/*    */     }
/* 44 */     return this.passivePlayList;
/*    */   }
/*    */   
/*    */   public void addPlay(Play play, boolean active)
/*    */   {
/* 49 */     if (active) {
/* 50 */       this.activePlayList.add(play);
/*    */     } else {
/* 52 */       this.passivePlayList.add(play);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addAllPlay(List<Play> plays, boolean active) {
/* 57 */     if (active) {
/* 58 */       this.activePlayList.addAll(plays);
/*    */     } else {
/* 60 */       this.passivePlayList.addAll(plays);
/*    */     }
/*    */   }
/*    */   
/*    */   List<Play> getPlayList() {
/* 65 */     return this.recordPlayList;
/*    */   }
/*    */   
/*    */   public void addPlay(Play play) {
/* 69 */     this.recordPlayList.add(play);
/*    */   }
/*    */   
/*    */   public void addAllPlay(List<Play> plays) {
/* 73 */     this.recordPlayList.addAll(plays);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\ExcuteCmdResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */