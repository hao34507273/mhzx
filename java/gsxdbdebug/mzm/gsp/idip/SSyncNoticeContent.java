/*    */ package mzm.gsp.idip;
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
/*    */ 
/*    */ public class SSyncNoticeContent
/*    */   extends __SSyncNoticeContent__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601103;
/*    */   public long noticeid;
/*    */   public Octets noticecontent;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601103;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncNoticeContent()
/*    */   {
/* 34 */     this.noticecontent = new Octets();
/*    */   }
/*    */   
/*    */   public SSyncNoticeContent(long _noticeid_, Octets _noticecontent_) {
/* 38 */     this.noticeid = _noticeid_;
/* 39 */     this.noticecontent = _noticecontent_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.noticeid);
/* 48 */     _os_.marshal(this.noticecontent);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.noticeid = _os_.unmarshal_long();
/* 54 */     this.noticecontent = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSyncNoticeContent)) {
/* 64 */       SSyncNoticeContent _o_ = (SSyncNoticeContent)_o1_;
/* 65 */       if (this.noticeid != _o_.noticeid) return false;
/* 66 */       if (!this.noticecontent.equals(_o_.noticecontent)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.noticeid;
/* 75 */     _h_ += this.noticecontent.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.noticeid).append(",");
/* 83 */     _sb_.append("B").append(this.noticecontent.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\SSyncNoticeContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */