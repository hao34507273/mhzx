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
/*    */ public class SEquipArtifactFail
/*    */   extends __SEquipArtifactFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618245;
/*    */   public static final int NOT_OWN = 1;
/*    */   public int retcode;
/*    */   public int class_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618245;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEquipArtifactFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SEquipArtifactFail(int _retcode_, int _class_id_)
/*    */   {
/* 39 */     this.retcode = _retcode_;
/* 40 */     this.class_id = _class_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.retcode);
/* 49 */     _os_.marshal(this.class_id);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.retcode = _os_.unmarshal_int();
/* 55 */     this.class_id = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SEquipArtifactFail)) {
/* 65 */       SEquipArtifactFail _o_ = (SEquipArtifactFail)_o1_;
/* 66 */       if (this.retcode != _o_.retcode) return false;
/* 67 */       if (this.class_id != _o_.class_id) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.retcode;
/* 76 */     _h_ += this.class_id;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.retcode).append(",");
/* 84 */     _sb_.append(this.class_id).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEquipArtifactFail _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.retcode - _o_.retcode;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.class_id - _o_.class_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SEquipArtifactFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */