/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.bounding.BoxBounding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MassWeddingZoneForm
/*    */   extends BoxBounding
/*    */ {
/*    */   private final int seq;
/*    */   private final long roleid1;
/*    */   private final long roleid2;
/*    */   private final int sceneid;
/*    */   private int eventid;
/*    */   
/*    */   public MassWeddingZoneForm(int x, int y, int seq, long roleid1, long roleid2, int sceneid, int pathPointScale)
/*    */   {
/* 19 */     super(x + pathPointScale, y + pathPointScale, 0, x - pathPointScale, y - pathPointScale, 0);
/* 20 */     this.seq = seq;
/* 21 */     this.roleid1 = roleid1;
/* 22 */     this.roleid2 = roleid2;
/* 23 */     this.sceneid = sceneid;
/*    */   }
/*    */   
/*    */   public int getSeq() {
/* 27 */     return this.seq;
/*    */   }
/*    */   
/*    */   public long getRoleid1() {
/* 31 */     return this.roleid1;
/*    */   }
/*    */   
/*    */   public long getRoleid2() {
/* 35 */     return this.roleid2;
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
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingZoneForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */