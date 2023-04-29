/*    */ package mzm.gsp.avatar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.avatar.main.PActivateAvatar;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CActivateAvatarReq
/*    */   extends __CActivateAvatarReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615169;
/*    */   public int avatar;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     if (roleId < 0L) {
/* 20 */       return;
/*    */     }
/* 22 */     Role.addRoleProcedure(roleId, new PActivateAvatar(roleId, this.avatar));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12615169;
/*    */   }
/*    */   
/*    */ 
/*    */   public CActivateAvatarReq() {}
/*    */   
/*    */ 
/*    */   public CActivateAvatarReq(int _avatar_)
/*    */   {
/* 39 */     this.avatar = _avatar_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.avatar);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.avatar = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CActivateAvatarReq)) {
/* 62 */       CActivateAvatarReq _o_ = (CActivateAvatarReq)_o1_;
/* 63 */       if (this.avatar != _o_.avatar) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.avatar;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.avatar).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CActivateAvatarReq _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.avatar - _o_.avatar;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\CActivateAvatarReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */