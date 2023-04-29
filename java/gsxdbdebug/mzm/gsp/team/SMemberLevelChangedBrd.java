/*    */ package mzm.gsp.team;
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
/*    */ public class SMemberLevelChangedBrd
/*    */   extends __SMemberLevelChangedBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588308;
/*    */   public long member;
/*    */   public int level;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588308;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMemberLevelChangedBrd() {}
/*    */   
/*    */ 
/*    */   public SMemberLevelChangedBrd(long _member_, int _level_)
/*    */   {
/* 37 */     this.member = _member_;
/* 38 */     this.level = _level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.member);
/* 47 */     _os_.marshal(this.level);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.member = _os_.unmarshal_long();
/* 53 */     this.level = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SMemberLevelChangedBrd)) {
/* 63 */       SMemberLevelChangedBrd _o_ = (SMemberLevelChangedBrd)_o1_;
/* 64 */       if (this.member != _o_.member) return false;
/* 65 */       if (this.level != _o_.level) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.member;
/* 74 */     _h_ += this.level;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.member).append(",");
/* 82 */     _sb_.append(this.level).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMemberLevelChangedBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.member - _o_.member);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.level - _o_.level;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SMemberLevelChangedBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */