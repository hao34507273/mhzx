/*    */ package mzm.gsp.notice;
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
/*    */ public class SSyncNotice
/*    */   extends __SSyncNotice__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583937;
/*    */   public String title;
/*    */   public String content;
/*    */   public long timestamp;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583937;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncNotice()
/*    */   {
/* 35 */     this.title = "";
/* 36 */     this.content = "";
/*    */   }
/*    */   
/*    */   public SSyncNotice(String _title_, String _content_, long _timestamp_) {
/* 40 */     this.title = _title_;
/* 41 */     this.content = _content_;
/* 42 */     this.timestamp = _timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.title, "UTF-16LE");
/* 51 */     _os_.marshal(this.content, "UTF-16LE");
/* 52 */     _os_.marshal(this.timestamp);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.title = _os_.unmarshal_String("UTF-16LE");
/* 58 */     this.content = _os_.unmarshal_String("UTF-16LE");
/* 59 */     this.timestamp = _os_.unmarshal_long();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSyncNotice)) {
/* 69 */       SSyncNotice _o_ = (SSyncNotice)_o1_;
/* 70 */       if (!this.title.equals(_o_.title)) return false;
/* 71 */       if (!this.content.equals(_o_.content)) return false;
/* 72 */       if (this.timestamp != _o_.timestamp) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.title.hashCode();
/* 81 */     _h_ += this.content.hashCode();
/* 82 */     _h_ += (int)this.timestamp;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append("T").append(this.title.length()).append(",");
/* 90 */     _sb_.append("T").append(this.content.length()).append(",");
/* 91 */     _sb_.append(this.timestamp).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\notice\SSyncNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */