/*    */ package mzm.gsp.crossserver.top;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.ladder.LadderRankRoleData;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossLadderTopChartObj
/*    */   implements TopChartObj
/*    */ {
/*    */   private long roleid;
/*    */   private String roleName;
/*    */   private int occupation;
/*    */   private int displayRanking;
/*    */   private int ranking;
/*    */   private long recordTime;
/*    */   
/*    */   public CrossLadderTopChartObj() {}
/*    */   
/*    */   public CrossLadderTopChartObj(long roleid, String roleName, int occupation, int displayRanking, int ranking)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.roleName = roleName;
/* 28 */     this.occupation = occupation;
/* 29 */     this.displayRanking = displayRanking;
/* 30 */     this.ranking = ranking;
/* 31 */     this.recordTime = DateTimeUtils.getCurrTimeInMillis();
/*    */   }
/*    */   
/*    */   public LadderRankRoleData getRankRoleData()
/*    */   {
/* 36 */     LadderRankRoleData ladderRankRoleData = new LadderRankRoleData();
/* 37 */     ladderRankRoleData.roleid = this.roleid;
/* 38 */     ladderRankRoleData.occupation = this.occupation;
/* 39 */     ladderRankRoleData.rolename = (this.roleName == null ? "" : this.roleName);
/* 40 */     ladderRankRoleData.stage = this.displayRanking;
/* 41 */     ladderRankRoleData.score = this.ranking;
/* 42 */     return ladderRankRoleData;
/*    */   }
/*    */   
/*    */ 
/*    */   public double getScore()
/*    */   {
/* 48 */     return (this.displayRanking << 46) + (this.ranking << 32) + this.recordTime / 1000L;
/*    */   }
/*    */   
/*    */ 
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 54 */     os.marshal(this.roleid);
/* 55 */     os.marshal(this.roleName, "UTF-8");
/* 56 */     os.marshal(this.occupation);
/* 57 */     os.marshal(this.displayRanking);
/* 58 */     os.marshal(this.ranking);
/* 59 */     os.marshal(this.recordTime);
/*    */     
/* 61 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 67 */     this.roleid = os.unmarshal_long();
/* 68 */     this.roleName = os.unmarshal_String("UTF-8");
/* 69 */     this.occupation = os.unmarshal_int();
/* 70 */     this.displayRanking = os.unmarshal_int();
/* 71 */     this.ranking = os.unmarshal_int();
/* 72 */     this.recordTime = os.unmarshal_long();
/* 73 */     return os;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 78 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public String getRoleName()
/*    */   {
/* 83 */     return this.roleName;
/*    */   }
/*    */   
/*    */   public int getOccupation()
/*    */   {
/* 88 */     return this.occupation;
/*    */   }
/*    */   
/*    */   public int getDisplayRanking()
/*    */   {
/* 93 */     return this.displayRanking;
/*    */   }
/*    */   
/*    */   public int getRanking()
/*    */   {
/* 98 */     return this.ranking;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\top\CrossLadderTopChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */