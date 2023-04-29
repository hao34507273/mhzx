/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetVitalityRewardResponse
/*    */   implements Marshal
/*    */ {
/*    */   public long startTime;
/*    */   public long rewardTime;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 15 */     os.marshal(this.startTime);
/* 16 */     os.marshal(this.rewardTime);
/* 17 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 23 */     this.startTime = os.unmarshal_long();
/* 24 */     this.rewardTime = os.unmarshal_long();
/* 25 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GetVitalityRewardResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */