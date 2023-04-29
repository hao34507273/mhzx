/*    */ package mzm.gsp.avatar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.avatar.frame.PSetAvatarFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSetAvatarFrameReq
/*    */   extends __CSetAvatarFrameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615186;
/*    */   public int avatar_frame_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PSetAvatarFrame(roleId, this.avatar_frame_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12615186;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSetAvatarFrameReq() {}
/*    */   
/*    */ 
/*    */   public CSetAvatarFrameReq(int _avatar_frame_id_)
/*    */   {
/* 37 */     this.avatar_frame_id = _avatar_frame_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.avatar_frame_id);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.avatar_frame_id = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CSetAvatarFrameReq)) {
/* 60 */       CSetAvatarFrameReq _o_ = (CSetAvatarFrameReq)_o1_;
/* 61 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.avatar_frame_id;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.avatar_frame_id).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSetAvatarFrameReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.avatar_frame_id - _o_.avatar_frame_id;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\CSetAvatarFrameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */