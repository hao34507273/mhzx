/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ public class CorpsPointRaceInfo
/*     */   implements Marshal
/*     */ {
/*     */   private long corpsid;
/*     */   private int zoneid;
/*     */   private String corpsName;
/*     */   private int icon;
/*     */   private int point;
/*     */   private int rank;
/*     */   
/*     */   public CorpsPointRaceInfo(long corpsid, int zoneid, String corpsName, int icon, int point, int rank)
/*     */   {
/*  21 */     this.corpsid = corpsid;
/*  22 */     this.zoneid = zoneid;
/*  23 */     this.corpsName = corpsName;
/*  24 */     this.icon = icon;
/*  25 */     this.point = point;
/*  26 */     this.rank = rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CorpsPointRaceInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public OctetsStream marshal(OctetsStream os)
/*     */   {
/*  37 */     os.marshal(this.corpsid);
/*  38 */     os.marshal(this.zoneid);
/*     */     try
/*     */     {
/*  41 */       os.marshal(this.corpsName.getBytes("UTF-8"));
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*  47 */     os.marshal(this.icon);
/*  48 */     os.marshal(this.point);
/*  49 */     os.marshal(this.rank);
/*     */     
/*  51 */     return os;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream os)
/*     */     throws MarshalException
/*     */   {
/*  57 */     this.corpsid = os.unmarshal_long();
/*  58 */     this.zoneid = os.unmarshal_int();
/*     */     try
/*     */     {
/*  61 */       this.corpsName = new String(os.unmarshal_bytes(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*  67 */     this.icon = os.unmarshal_int();
/*  68 */     this.point = os.unmarshal_int();
/*  69 */     this.rank = os.unmarshal_int();
/*     */     
/*  71 */     return os;
/*     */   }
/*     */   
/*     */   public long getCorpsid()
/*     */   {
/*  76 */     return this.corpsid;
/*     */   }
/*     */   
/*     */   public void setCorpsid(long corpsid)
/*     */   {
/*  81 */     this.corpsid = corpsid;
/*     */   }
/*     */   
/*     */   public int getZoneid()
/*     */   {
/*  86 */     return this.zoneid;
/*     */   }
/*     */   
/*     */   public void setZoneid(int zoneid)
/*     */   {
/*  91 */     this.zoneid = zoneid;
/*     */   }
/*     */   
/*     */   public String getCorpsName()
/*     */   {
/*  96 */     return this.corpsName;
/*     */   }
/*     */   
/*     */   public void setCorpsName(String corpsName)
/*     */   {
/* 101 */     this.corpsName = corpsName;
/*     */   }
/*     */   
/*     */   public int getIcon()
/*     */   {
/* 106 */     return this.icon;
/*     */   }
/*     */   
/*     */   public void setIcon(int icon)
/*     */   {
/* 111 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public int getPoint()
/*     */   {
/* 116 */     return this.point;
/*     */   }
/*     */   
/*     */   public void setPoint(int point)
/*     */   {
/* 121 */     this.point = point;
/*     */   }
/*     */   
/*     */   public int getRank()
/*     */   {
/* 126 */     return this.rank;
/*     */   }
/*     */   
/*     */   public void setRank(int rank)
/*     */   {
/* 131 */     this.rank = rank;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\CorpsPointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */