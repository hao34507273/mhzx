/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.bounding.BoxBounding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MarriageParadeZoneForm
/*    */   extends BoxBounding
/*    */ {
/*    */   private final int seq;
/*    */   private final long roleid1;
/*    */   private final int sceneid;
/*    */   private int eventid;
/*    */   private final long paradeMil;
/*    */   
/*    */   public MarriageParadeZoneForm(int x, int y, int seq, long roleid1, int sceneid, long paradeMil, int pathPointScale)
/*    */   {
/* 23 */     super(x + pathPointScale, y + pathPointScale, 0, x - pathPointScale, y - pathPointScale, 0);
/* 24 */     this.seq = seq;
/* 25 */     this.roleid1 = roleid1;
/* 26 */     this.sceneid = sceneid;
/* 27 */     this.paradeMil = paradeMil;
/*    */   }
/*    */   
/*    */   public int getSeq() {
/* 31 */     return this.seq;
/*    */   }
/*    */   
/*    */   public long getRoleid1() {
/* 35 */     return this.roleid1;
/*    */   }
/*    */   
/*    */   public int getSceneid() {
/* 39 */     return this.sceneid;
/*    */   }
/*    */   
/*    */   public void setEventid(int eventid) {
/* 43 */     this.eventid = eventid;
/*    */   }
/*    */   
/*    */   public int getEventid() {
/* 47 */     return this.eventid;
/*    */   }
/*    */   
/*    */   public long getParadeMil() {
/* 51 */     return this.paradeMil;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageParadeZoneForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */