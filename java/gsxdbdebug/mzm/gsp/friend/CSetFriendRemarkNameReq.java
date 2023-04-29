/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PSetFriendRemarkName;
/*    */ 
/*    */ 
/*    */ public class CSetFriendRemarkNameReq
/*    */   extends __CSetFriendRemarkNameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587044;
/*    */   public long friendid;
/*    */   public Octets remarkname;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PSetFriendRemarkName(roleId, this.friendid, this.remarkname.getString("UTF-8")));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12587044;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSetFriendRemarkNameReq()
/*    */   {
/* 36 */     this.remarkname = new Octets();
/*    */   }
/*    */   
/*    */   public CSetFriendRemarkNameReq(long _friendid_, Octets _remarkname_) {
/* 40 */     this.friendid = _friendid_;
/* 41 */     this.remarkname = _remarkname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.friendid);
/* 50 */     _os_.marshal(this.remarkname);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.friendid = _os_.unmarshal_long();
/* 56 */     this.remarkname = _os_.unmarshal_Octets();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CSetFriendRemarkNameReq)) {
/* 66 */       CSetFriendRemarkNameReq _o_ = (CSetFriendRemarkNameReq)_o1_;
/* 67 */       if (this.friendid != _o_.friendid) return false;
/* 68 */       if (!this.remarkname.equals(_o_.remarkname)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.friendid;
/* 77 */     _h_ += this.remarkname.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.friendid).append(",");
/* 85 */     _sb_.append("B").append(this.remarkname.size()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\CSetFriendRemarkNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */