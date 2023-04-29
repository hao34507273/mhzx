/*    */ package mzm.gsp.grow;
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
/*    */ public class SSynLevelGuideSchedule
/*    */   extends __SSynLevelGuideSchedule__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596998;
/*    */   public int targetid;
/*    */   public int targetstate;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596998;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynLevelGuideSchedule() {}
/*    */   
/*    */ 
/*    */   public SSynLevelGuideSchedule(int _targetid_, int _targetstate_)
/*    */   {
/* 37 */     this.targetid = _targetid_;
/* 38 */     this.targetstate = _targetstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.targetid);
/* 47 */     _os_.marshal(this.targetstate);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.targetid = _os_.unmarshal_int();
/* 53 */     this.targetstate = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynLevelGuideSchedule)) {
/* 63 */       SSynLevelGuideSchedule _o_ = (SSynLevelGuideSchedule)_o1_;
/* 64 */       if (this.targetid != _o_.targetid) return false;
/* 65 */       if (this.targetstate != _o_.targetstate) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.targetid;
/* 74 */     _h_ += this.targetstate;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.targetid).append(",");
/* 82 */     _sb_.append(this.targetstate).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynLevelGuideSchedule _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.targetid - _o_.targetid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.targetstate - _o_.targetstate;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\SSynLevelGuideSchedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */