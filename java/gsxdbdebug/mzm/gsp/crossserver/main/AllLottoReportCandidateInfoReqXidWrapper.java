/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllLottoReportCandidateInfoReqXidWrapper
/*    */   extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   private final long roleid;
/*    */   private final String roleName;
/*    */   private final int occupation;
/*    */   private final int gender;
/*    */   private final int level;
/*    */   private final int avatarid;
/*    */   private final int avatarFrameid;
/*    */   
/*    */   public AllLottoReportCandidateInfoReqXidWrapper(DataTransferReq proto, int activityCfgid, int turn, long roleid, String roleName, int occupation, int gender, int level, int avatarid, int avatarFrameid)
/*    */   {
/* 26 */     super(proto);
/* 27 */     this.activityCfgid = activityCfgid;
/* 28 */     this.turn = turn;
/* 29 */     this.roleid = roleid;
/* 30 */     this.roleName = roleName;
/* 31 */     this.occupation = occupation;
/* 32 */     this.gender = gender;
/* 33 */     this.level = level;
/* 34 */     this.avatarid = avatarid;
/* 35 */     this.avatarFrameid = avatarFrameid;
/*    */   }
/*    */   
/*    */   public int getActivityCfgid()
/*    */   {
/* 40 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */   public int getTurn()
/*    */   {
/* 45 */     return this.turn;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 50 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public String getRoleName()
/*    */   {
/* 55 */     return this.roleName;
/*    */   }
/*    */   
/*    */   public int getOccupation()
/*    */   {
/* 60 */     return this.occupation;
/*    */   }
/*    */   
/*    */   public int getGender()
/*    */   {
/* 65 */     return this.gender;
/*    */   }
/*    */   
/*    */   public int getLevel()
/*    */   {
/* 70 */     return this.level;
/*    */   }
/*    */   
/*    */   public int getAvatarid()
/*    */   {
/* 75 */     return this.avatarid;
/*    */   }
/*    */   
/*    */   public int getAvatarFrameid()
/*    */   {
/* 80 */     return this.avatarFrameid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\AllLottoReportCandidateInfoReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */