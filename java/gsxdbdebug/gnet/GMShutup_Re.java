/*    */ package gnet;
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
/*    */ public class GMShutup_Re
/*    */   extends __GMShutup_Re__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 357;
/*    */   public int retcode;
/*    */   public Octets dstuserid;
/*    */   public int forbid_time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 357;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public GMShutup_Re()
/*    */   {
/* 33 */     this.dstuserid = new Octets();
/*    */   }
/*    */   
/*    */   public GMShutup_Re(int _retcode_, Octets _dstuserid_, int _forbid_time_) {
/* 37 */     this.retcode = _retcode_;
/* 38 */     this.dstuserid = _dstuserid_;
/* 39 */     this.forbid_time = _forbid_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.retcode);
/* 48 */     _os_.marshal(this.dstuserid);
/* 49 */     _os_.marshal(this.forbid_time);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.retcode = _os_.unmarshal_int();
/* 55 */     this.dstuserid = _os_.unmarshal_Octets();
/* 56 */     this.forbid_time = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof GMShutup_Re)) {
/* 66 */       GMShutup_Re _o_ = (GMShutup_Re)_o1_;
/* 67 */       if (this.retcode != _o_.retcode) return false;
/* 68 */       if (!this.dstuserid.equals(_o_.dstuserid)) return false;
/* 69 */       if (this.forbid_time != _o_.forbid_time) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.retcode;
/* 78 */     _h_ += this.dstuserid.hashCode();
/* 79 */     _h_ += this.forbid_time;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append("B").append(this.dstuserid.size()).append(",");
/* 88 */     _sb_.append(this.forbid_time).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GMShutup_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */