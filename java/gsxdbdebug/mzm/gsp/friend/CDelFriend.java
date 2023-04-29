/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PCDelFriend;
/*    */ 
/*    */ 
/*    */ public class CDelFriend
/*    */   extends __CDelFriend__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587011;
/*    */   public long friendid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     Role.addRoleProcedure(roleId, new PCDelFriend(roleId, this.friendid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 26 */     return 12587011;
/*    */   }
/*    */   
/*    */ 
/*    */   public CDelFriend() {}
/*    */   
/*    */ 
/*    */   public CDelFriend(long _friendid_)
/*    */   {
/* 35 */     this.friendid = _friendid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.marshal(this.friendid);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.friendid = _os_.unmarshal_long();
/* 49 */     if (!_validator_()) {
/* 50 */       throw new VerifyError("validator failed");
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof CDelFriend)) {
/* 58 */       CDelFriend _o_ = (CDelFriend)_o1_;
/* 59 */       if (this.friendid != _o_.friendid) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += (int)this.friendid;
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.friendid).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDelFriend _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\CDelFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */