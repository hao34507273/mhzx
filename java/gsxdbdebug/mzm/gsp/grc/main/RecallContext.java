/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RecallContext
/*    */   implements Marshal
/*    */ {
/*    */   public int count;
/*    */   public long roleid;
/*    */   public long friendRoleid;
/*    */   public int friendZoneid;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 17 */     os.marshal(this.count);
/* 18 */     os.marshal(this.roleid);
/* 19 */     os.marshal(this.friendRoleid);
/* 20 */     os.marshal(this.friendZoneid);
/* 21 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 27 */     this.count = os.unmarshal_int();
/* 28 */     this.roleid = os.unmarshal_long();
/* 29 */     this.friendRoleid = os.unmarshal_long();
/* 30 */     this.friendZoneid = os.unmarshal_int();
/* 31 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\RecallContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */