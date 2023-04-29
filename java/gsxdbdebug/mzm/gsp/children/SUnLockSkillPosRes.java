/*    */ package mzm.gsp.children;
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
/*    */ public class SUnLockSkillPosRes
/*    */   extends __SUnLockSkillPosRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609381;
/*    */   public long childrenid;
/*    */   public int nownum;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609381;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnLockSkillPosRes() {}
/*    */   
/*    */ 
/*    */   public SUnLockSkillPosRes(long _childrenid_, int _nownum_)
/*    */   {
/* 37 */     this.childrenid = _childrenid_;
/* 38 */     this.nownum = _nownum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.childrenid);
/* 47 */     _os_.marshal(this.nownum);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.childrenid = _os_.unmarshal_long();
/* 53 */     this.nownum = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SUnLockSkillPosRes)) {
/* 63 */       SUnLockSkillPosRes _o_ = (SUnLockSkillPosRes)_o1_;
/* 64 */       if (this.childrenid != _o_.childrenid) return false;
/* 65 */       if (this.nownum != _o_.nownum) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.childrenid;
/* 74 */     _h_ += this.nownum;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.childrenid).append(",");
/* 82 */     _sb_.append(this.nownum).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUnLockSkillPosRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.nownum - _o_.nownum;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SUnLockSkillPosRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */