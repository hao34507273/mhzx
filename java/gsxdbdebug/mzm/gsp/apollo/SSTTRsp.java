/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSTTRsp
/*    */   extends __SSTTRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602639;
/*    */   public int retcode;
/*    */   public Octets file_id;
/*    */   public Octets file_text;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602639;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSTTRsp()
/*    */   {
/* 35 */     this.retcode = 9;
/* 36 */     this.file_id = new Octets();
/* 37 */     this.file_text = new Octets();
/*    */   }
/*    */   
/*    */   public SSTTRsp(int _retcode_, Octets _file_id_, Octets _file_text_) {
/* 41 */     this.retcode = _retcode_;
/* 42 */     this.file_id = _file_id_;
/* 43 */     this.file_text = _file_text_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     _os_.marshal(this.file_id);
/* 53 */     _os_.marshal(this.file_text);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.retcode = _os_.unmarshal_int();
/* 59 */     this.file_id = _os_.unmarshal_Octets();
/* 60 */     this.file_text = _os_.unmarshal_Octets();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSTTRsp)) {
/* 70 */       SSTTRsp _o_ = (SSTTRsp)_o1_;
/* 71 */       if (this.retcode != _o_.retcode) return false;
/* 72 */       if (!this.file_id.equals(_o_.file_id)) return false;
/* 73 */       if (!this.file_text.equals(_o_.file_text)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.retcode;
/* 82 */     _h_ += this.file_id.hashCode();
/* 83 */     _h_ += this.file_text.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.retcode).append(",");
/* 91 */     _sb_.append("B").append(this.file_id.size()).append(",");
/* 92 */     _sb_.append("B").append(this.file_text.size()).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SSTTRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */