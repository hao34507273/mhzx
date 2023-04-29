/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AccountRecallInfo
/*    */   implements Marshal
/*    */ {
/*    */   public long loginTime;
/*    */   public int maxLevel;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 15 */     os.marshal(this.loginTime);
/* 16 */     os.marshal(this.maxLevel);
/* 17 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 23 */     this.loginTime = os.unmarshal_long();
/* 24 */     this.maxLevel = os.unmarshal_int();
/* 25 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\AccountRecallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */