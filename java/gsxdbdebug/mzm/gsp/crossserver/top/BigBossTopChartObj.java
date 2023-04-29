/*    */ package mzm.gsp.crossserver.top;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.bigboss.BigbossRankData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BigBossTopChartObj
/*    */   implements TopChartObj
/*    */ {
/*    */   private long roleid;
/*    */   private String name;
/*    */   private int occupation;
/*    */   private int damagePoint;
/*    */   
/*    */   public BigBossTopChartObj() {}
/*    */   
/*    */   public BigBossTopChartObj(long roleid, String name, int occupation, int damagePoint)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.name = name;
/* 28 */     this.occupation = occupation;
/* 29 */     this.damagePoint = damagePoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public double getScore()
/*    */   {
/* 35 */     double base = 9.223372036854776E18D;
/* 36 */     return this.damagePoint * 9.223372036854776E18D - this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 42 */     os.marshal(this.roleid);
/* 43 */     os.marshal(this.name, "UTF-8");
/* 44 */     os.marshal(this.occupation);
/* 45 */     os.marshal(this.damagePoint);
/* 46 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 52 */     this.roleid = os.unmarshal_long();
/* 53 */     this.name = os.unmarshal_String("UTF-8");
/* 54 */     this.occupation = os.unmarshal_int();
/* 55 */     this.damagePoint = os.unmarshal_int();
/* 56 */     return os;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 61 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 66 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getOccupation()
/*    */   {
/* 71 */     return this.occupation;
/*    */   }
/*    */   
/*    */   public int getDamagePoint()
/*    */   {
/* 76 */     return this.damagePoint;
/*    */   }
/*    */   
/*    */   public BigbossRankData getRankData()
/*    */   {
/* 81 */     BigbossRankData rankData = new BigbossRankData();
/* 82 */     rankData.roleid = this.roleid;
/* 83 */     rankData.name = (this.name == null ? "" : this.name);
/* 84 */     rankData.occupationid = this.occupation;
/* 85 */     rankData.damagepoint = this.damagePoint;
/* 86 */     return rankData;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\top\BigBossTopChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */