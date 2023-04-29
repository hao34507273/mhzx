/*     */ package mzm.gsp.crossserver.top;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.crossfield.CrossFieldRankData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleCrossFieldTopChartObj
/*     */   implements TopChartObj
/*     */ {
/*     */   private long roleid;
/*     */   private String name;
/*     */   private int occupation;
/*     */   private int starNum;
/*     */   private long timestamp;
/*     */   
/*     */   public SingleCrossFieldTopChartObj() {}
/*     */   
/*     */   public SingleCrossFieldTopChartObj(long roleid, String name, int occupation, int starNum, long timestamp)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.name = name;
/*  32 */     this.occupation = occupation;
/*  33 */     this.starNum = starNum;
/*  34 */     this.timestamp = timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getScore()
/*     */   {
/*  40 */     int tmpTimestamp = 0;
/*  41 */     if (this.timestamp == 0L)
/*     */     {
/*  43 */       tmpTimestamp = Integer.MAX_VALUE;
/*     */     }
/*     */     else
/*     */     {
/*  47 */       tmpTimestamp = (int)Math.min(this.timestamp / 1000L, 2147483647L);
/*     */     }
/*  49 */     double base = 9.223372036854776E18D;
/*  50 */     return this.starNum * 9.223372036854776E18D * 9.223372036854776E18D - tmpTimestamp * 9.223372036854776E18D - this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public OctetsStream marshal(OctetsStream os)
/*     */   {
/*  56 */     os.marshal(this.roleid);
/*  57 */     os.marshal(this.name, "UTF-8");
/*  58 */     os.marshal(this.occupation);
/*  59 */     os.marshal(this.starNum);
/*  60 */     os.marshal(this.timestamp);
/*  61 */     return os;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream os)
/*     */     throws MarshalException
/*     */   {
/*  67 */     this.roleid = os.unmarshal_long();
/*  68 */     this.name = os.unmarshal_String("UTF-8");
/*  69 */     this.occupation = os.unmarshal_int();
/*  70 */     this.starNum = os.unmarshal_int();
/*  71 */     this.timestamp = os.unmarshal_long();
/*  72 */     return os;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  77 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  82 */     return this.name;
/*     */   }
/*     */   
/*     */   public int getOccupation()
/*     */   {
/*  87 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public int getStarNum()
/*     */   {
/*  92 */     return this.starNum;
/*     */   }
/*     */   
/*     */   public long getTimestamp()
/*     */   {
/*  97 */     return this.timestamp;
/*     */   }
/*     */   
/*     */   public CrossFieldRankData getRankData()
/*     */   {
/* 102 */     CrossFieldRankData rankData = new CrossFieldRankData();
/* 103 */     rankData.roleid = this.roleid;
/*     */     try
/*     */     {
/* 106 */       rankData.name.setString(this.name == null ? "" : this.name, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 112 */     rankData.occupation = this.occupation;
/* 113 */     rankData.star_num = this.starNum;
/* 114 */     rankData.timestamp = ((int)(this.timestamp / 1000L));
/* 115 */     return rankData;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\top\SingleCrossFieldTopChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */