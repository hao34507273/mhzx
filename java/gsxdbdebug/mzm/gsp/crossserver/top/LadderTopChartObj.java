/*     */ package mzm.gsp.crossserver.top;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.ladder.LadderRankRoleData;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LadderTopChartObj
/*     */   implements TopChartObj
/*     */ {
/*     */   private static final int VERSION = 1;
/*     */   private long roleid;
/*     */   private int occupation;
/*     */   private String roleName;
/*     */   private int displayRanking;
/*     */   private int ranking;
/*     */   private long recordTime;
/*     */   
/*     */   public LadderTopChartObj() {}
/*     */   
/*     */   public LadderTopChartObj(long roleid, int occupation, String roleName, int displayRanking, int ranking)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.occupation = occupation;
/*  32 */     this.roleName = roleName;
/*  33 */     this.displayRanking = displayRanking;
/*  34 */     this.ranking = ranking;
/*  35 */     this.recordTime = DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */   public LadderRankRoleData getRankRoleData()
/*     */   {
/*  40 */     LadderRankRoleData ladderRankRoleData = new LadderRankRoleData();
/*  41 */     ladderRankRoleData.roleid = this.roleid;
/*  42 */     ladderRankRoleData.occupation = this.occupation;
/*  43 */     ladderRankRoleData.rolename = (this.roleName == null ? "" : this.roleName);
/*  44 */     ladderRankRoleData.stage = this.displayRanking;
/*  45 */     ladderRankRoleData.score = this.ranking;
/*  46 */     return ladderRankRoleData;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getScore()
/*     */   {
/*  52 */     return (this.displayRanking << 46) + (this.ranking << 32) + this.recordTime / 1000L;
/*     */   }
/*     */   
/*     */ 
/*     */   public OctetsStream marshal(OctetsStream os)
/*     */   {
/*  58 */     os.marshal(1);
/*  59 */     os.marshal(this.roleid);
/*  60 */     os.marshal(this.occupation);
/*     */     try
/*     */     {
/*  63 */       os.marshal(this.roleName.getBytes("UTF-8"));
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*  69 */     os.marshal(this.displayRanking);
/*  70 */     os.marshal(this.ranking);
/*  71 */     os.marshal(this.recordTime);
/*  72 */     os.marshal(0);
/*  73 */     os.marshal(0);
/*     */     
/*  75 */     return os;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream os)
/*     */     throws MarshalException
/*     */   {
/*  81 */     os.unmarshal_int();
/*  82 */     this.roleid = os.unmarshal_long();
/*  83 */     this.occupation = os.unmarshal_int();
/*     */     try
/*     */     {
/*  86 */       this.roleName = new String(os.unmarshal_bytes(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*  92 */     this.displayRanking = os.unmarshal_int();
/*  93 */     this.ranking = os.unmarshal_int();
/*  94 */     this.recordTime = os.unmarshal_long();
/*  95 */     os.unmarshal_int();
/*  96 */     os.unmarshal_int();
/*     */     
/*  98 */     return os;
/*     */   }
/*     */   
/*     */   public int getOccupation()
/*     */   {
/* 103 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public String getRoleName()
/*     */   {
/* 108 */     return this.roleName;
/*     */   }
/*     */   
/*     */   public int getDisplayRanking()
/*     */   {
/* 113 */     return this.displayRanking;
/*     */   }
/*     */   
/*     */   public int getRanking()
/*     */   {
/* 118 */     return this.ranking;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\top\LadderTopChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */