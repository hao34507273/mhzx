/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.marriage.main.PCCanSendGiftToFriend;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCanSendGiftToFriend
/*    */   extends __CCanSendGiftToFriend__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599836;
/*    */   public long roleid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long operid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(operid, new PCCanSendGiftToFriend(operid, this.roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12599836;
/*    */   }
/*    */   
/*    */ 
/*    */   public CCanSendGiftToFriend() {}
/*    */   
/*    */ 
/*    */   public CCanSendGiftToFriend(long _roleid_)
/*    */   {
/* 38 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.roleid);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.roleid = _os_.unmarshal_long();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CCanSendGiftToFriend)) {
/* 61 */       CCanSendGiftToFriend _o_ = (CCanSendGiftToFriend)_o1_;
/* 62 */       if (this.roleid != _o_.roleid) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += (int)this.roleid;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.roleid).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCanSendGiftToFriend _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\CCanSendGiftToFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */