/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleGetJifenInfo implements Marshal, Comparable<RoleGetJifenInfo>
/*    */ {
/*    */   public long member_roleid;
/*    */   public int jifen;
/*    */   
/*    */   public RoleGetJifenInfo() {}
/*    */   
/*    */   public RoleGetJifenInfo(long _member_roleid_, int _jifen_)
/*    */   {
/* 16 */     this.member_roleid = _member_roleid_;
/* 17 */     this.jifen = _jifen_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.member_roleid);
/* 26 */     _os_.marshal(this.jifen);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.member_roleid = _os_.unmarshal_long();
/* 32 */     this.jifen = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof RoleGetJifenInfo)) {
/* 39 */       RoleGetJifenInfo _o_ = (RoleGetJifenInfo)_o1_;
/* 40 */       if (this.member_roleid != _o_.member_roleid) return false;
/* 41 */       if (this.jifen != _o_.jifen) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += (int)this.member_roleid;
/* 50 */     _h_ += this.jifen;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.member_roleid).append(",");
/* 58 */     _sb_.append(this.jifen).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoleGetJifenInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = Long.signum(this.member_roleid - _o_.member_roleid);
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.jifen - _o_.jifen;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\RoleGetJifenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */