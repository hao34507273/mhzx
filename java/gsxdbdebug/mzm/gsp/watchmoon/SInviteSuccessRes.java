/*    */ package mzm.gsp.watchmoon;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SInviteSuccessRes
/*    */   extends __SInviteSuccessRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600838;
/*    */   public long roleid1;
/*    */   public long roleid2;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600838;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SInviteSuccessRes() {}
/*    */   
/*    */ 
/*    */   public SInviteSuccessRes(long _roleid1_, long _roleid2_)
/*    */   {
/* 37 */     this.roleid1 = _roleid1_;
/* 38 */     this.roleid2 = _roleid2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.roleid1);
/* 47 */     _os_.marshal(this.roleid2);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.roleid1 = _os_.unmarshal_long();
/* 53 */     this.roleid2 = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SInviteSuccessRes)) {
/* 63 */       SInviteSuccessRes _o_ = (SInviteSuccessRes)_o1_;
/* 64 */       if (this.roleid1 != _o_.roleid1) return false;
/* 65 */       if (this.roleid2 != _o_.roleid2) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.roleid1;
/* 74 */     _h_ += (int)this.roleid2;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.roleid1).append(",");
/* 82 */     _sb_.append(this.roleid2).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SInviteSuccessRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.roleid1 - _o_.roleid1);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.roleid2 - _o_.roleid2);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SInviteSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */