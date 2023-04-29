/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.ExchangeDataHandlerInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointRaceUserBackData
/*    */ {
/*    */   public final String userid;
/*    */   public final long roleid;
/*    */   public final Octets token;
/*    */   public final ExchangeDataHandlerInfo exchangeDataDandlerInfo;
/* 15 */   private volatile boolean logined = false;
/* 16 */   private volatile boolean teamRestore = false;
/*    */   
/*    */ 
/*    */   public PointRaceUserBackData(String userid, long roleid, Octets token, ExchangeDataHandlerInfo exchangeDataDandlerInfo)
/*    */   {
/* 21 */     this.userid = userid;
/* 22 */     this.roleid = roleid;
/* 23 */     this.token = token;
/* 24 */     this.exchangeDataDandlerInfo = exchangeDataDandlerInfo;
/*    */   }
/*    */   
/*    */   public boolean setLogined()
/*    */   {
/* 29 */     if (this.logined)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     this.logined = true;
/*    */     
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isLogined()
/*    */   {
/* 41 */     return this.logined;
/*    */   }
/*    */   
/*    */   public boolean setTeamRestore()
/*    */   {
/* 46 */     if (this.teamRestore)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     this.teamRestore = true;
/*    */     
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isTeamRestore()
/*    */   {
/* 58 */     return this.teamRestore;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceUserBackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */