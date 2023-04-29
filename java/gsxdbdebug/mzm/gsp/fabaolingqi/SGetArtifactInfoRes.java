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
/*    */ public class SGetArtifactInfoRes
/*    */   extends __SGetArtifactInfoRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618259;
/*    */   public long role_id;
/*    */   public int class_id;
/*    */   public FabaoArtifactInfo info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12618259;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetArtifactInfoRes()
/*    */   {
/* 33 */     this.info = new FabaoArtifactInfo();
/*    */   }
/*    */   
/*    */   public SGetArtifactInfoRes(long _role_id_, int _class_id_, FabaoArtifactInfo _info_) {
/* 37 */     this.role_id = _role_id_;
/* 38 */     this.class_id = _class_id_;
/* 39 */     this.info = _info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.role_id);
/* 49 */     _os_.marshal(this.class_id);
/* 50 */     _os_.marshal(this.info);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.role_id = _os_.unmarshal_long();
/* 56 */     this.class_id = _os_.unmarshal_int();
/* 57 */     this.info.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SGetArtifactInfoRes)) {
/* 67 */       SGetArtifactInfoRes _o_ = (SGetArtifactInfoRes)_o1_;
/* 68 */       if (this.role_id != _o_.role_id) return false;
/* 69 */       if (this.class_id != _o_.class_id) return false;
/* 70 */       if (!this.info.equals(_o_.info)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.role_id;
/* 79 */     _h_ += this.class_id;
/* 80 */     _h_ += this.info.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.role_id).append(",");
/* 88 */     _sb_.append(this.class_id).append(",");
/* 89 */     _sb_.append(this.info).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\SGetArtifactInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */