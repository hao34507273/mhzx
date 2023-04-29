/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetRecallRebateResponse
/*    */   implements Marshal
/*    */ {
/*    */   public int totalNum;
/*    */   public long receiveTime;
/*    */   public int receiveNum;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 16 */     os.marshal(this.totalNum);
/* 17 */     os.marshal(this.receiveTime);
/* 18 */     os.marshal(this.receiveNum);
/* 19 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 25 */     this.totalNum = os.unmarshal_int();
/* 26 */     this.receiveTime = os.unmarshal_long();
/* 27 */     this.receiveNum = os.unmarshal_int();
/* 28 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GetRecallRebateResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */