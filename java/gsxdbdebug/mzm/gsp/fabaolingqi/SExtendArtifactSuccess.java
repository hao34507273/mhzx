/*    */ package mzm.gsp.fabaolingqi;
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
/*    */ public class SExtendArtifactSuccess
/*    */   extends __SExtendArtifactSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618254;
/*    */   public int class_id;
/*    */   public int expire_time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618254;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SExtendArtifactSuccess() {}
/*    */   
/*    */ 
/*    */   public SExtendArtifactSuccess(int _class_id_, int _expire_time_)
/*    */   {
/* 37 */     this.class_id = _class_id_;
/* 38 */     this.expire_time = _expire_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.class_id);
/* 47 */     _os_.marshal(this.expire_time);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.class_id = _os_.unmarshal_int();
/* 53 */     this.expire_time = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SExtendArtifactSuccess)) {
/* 63 */       SExtendArtifactSuccess _o_ = (SExtendArtifactSuccess)_o1_;
/* 64 */       if (this.class_id != _o_.class_id) return false;
/* 65 */       if (this.expire_time != _o_.expire_time) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.class_id;
/* 74 */     _h_ += this.expire_time;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.class_id).append(",");
/* 82 */     _sb_.append(this.expire_time).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SExtendArtifactSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.class_id - _o_.class_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.expire_time - _o_.expire_time;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SExtendArtifactSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */