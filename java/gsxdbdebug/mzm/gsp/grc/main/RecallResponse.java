/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecallResponse
/*    */   implements Marshal
/*    */ {
/*    */   public long updateTime;
/*    */   public int todayNum;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 22 */     os.marshal(this.updateTime);
/* 23 */     os.marshal(this.todayNum);
/* 24 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 30 */     this.updateTime = os.unmarshal_long();
/* 31 */     this.todayNum = os.unmarshal_int();
/* 32 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\RecallResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */