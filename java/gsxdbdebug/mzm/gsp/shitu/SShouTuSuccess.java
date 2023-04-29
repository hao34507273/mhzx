/*    */ package mzm.gsp.shitu;
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
/*    */ public class SShouTuSuccess
/*    */   extends __SShouTuSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601605;
/*    */   public long masterroleid;
/*    */   public String masterrolename;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601605;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SShouTuSuccess()
/*    */   {
/* 35 */     this.masterrolename = "";
/*    */   }
/*    */   
/*    */   public SShouTuSuccess(long _masterroleid_, String _masterrolename_, long _sessionid_) {
/* 39 */     this.masterroleid = _masterroleid_;
/* 40 */     this.masterrolename = _masterrolename_;
/* 41 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.masterroleid);
/* 50 */     _os_.marshal(this.masterrolename, "UTF-16LE");
/* 51 */     _os_.marshal(this.sessionid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.masterroleid = _os_.unmarshal_long();
/* 57 */     this.masterrolename = _os_.unmarshal_String("UTF-16LE");
/* 58 */     this.sessionid = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SShouTuSuccess)) {
/* 68 */       SShouTuSuccess _o_ = (SShouTuSuccess)_o1_;
/* 69 */       if (this.masterroleid != _o_.masterroleid) return false;
/* 70 */       if (!this.masterrolename.equals(_o_.masterrolename)) return false;
/* 71 */       if (this.sessionid != _o_.sessionid) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.masterroleid;
/* 80 */     _h_ += this.masterrolename.hashCode();
/* 81 */     _h_ += (int)this.sessionid;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.masterroleid).append(",");
/* 89 */     _sb_.append("T").append(this.masterrolename.length()).append(",");
/* 90 */     _sb_.append(this.sessionid).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SShouTuSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */