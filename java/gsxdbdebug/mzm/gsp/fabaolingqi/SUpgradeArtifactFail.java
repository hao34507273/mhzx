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
/*    */ public class SUpgradeArtifactFail
/*    */   extends __SUpgradeArtifactFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618249;
/*    */   public static final int NOT_UPGRADABLE = 1;
/*    */   public static final int REACH_MAXIMUM = 2;
/*    */   public static final int ITEM_NOT_EXISTS = 3;
/*    */   public static final int MANUAL_OPERATION_INSTEAD = 4;
/*    */   public int retcode;
/*    */   public int class_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618249;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUpgradeArtifactFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUpgradeArtifactFail(int _retcode_, int _class_id_)
/*    */   {
/* 42 */     this.retcode = _retcode_;
/* 43 */     this.class_id = _class_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     _os_.marshal(this.class_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     this.class_id = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SUpgradeArtifactFail)) {
/* 68 */       SUpgradeArtifactFail _o_ = (SUpgradeArtifactFail)_o1_;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       if (this.class_id != _o_.class_id) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.retcode;
/* 79 */     _h_ += this.class_id;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append(this.class_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUpgradeArtifactFail _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.retcode - _o_.retcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.class_id - _o_.class_id;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SUpgradeArtifactFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */