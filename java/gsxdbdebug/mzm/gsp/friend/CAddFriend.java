/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PCAddFriend;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAddFriend
/*    */   extends __CAddFriend__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587033;
/*    */   public long roleid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long reqRoleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(reqRoleid, new PCAddFriend(reqRoleid, this.roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12587033;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAddFriend() {}
/*    */   
/*    */ 
/*    */   public CAddFriend(long _roleid_)
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
/* 60 */     if ((_o1_ instanceof CAddFriend)) {
/* 61 */       CAddFriend _o_ = (CAddFriend)_o1_;
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
/*    */   public int compareTo(CAddFriend _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\CAddFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */