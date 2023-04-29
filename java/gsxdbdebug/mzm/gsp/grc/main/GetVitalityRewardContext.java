/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetVitalityRewardContext
/*    */   implements Marshal
/*    */ {
/*    */   public int count;
/*    */   public long roleid;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 15 */     os.marshal(this.count);
/* 16 */     os.marshal(this.roleid);
/* 17 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 23 */     this.count = os.unmarshal_int();
/* 24 */     this.roleid = os.unmarshal_long();
/* 25 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GetVitalityRewardContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */