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
/*    */ public class AddCash_Re
/*    */   extends __AddCash_Re__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 516;
/*    */   public int retcode;
/*    */   public Octets userid;
/*    */   public int zoneid;
/*    */   public int sn;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 516;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public AddCash_Re()
/*    */   {
/* 34 */     this.userid = new Octets();
/* 35 */     this.zoneid = -1;
/* 36 */     this.sn = 0;
/*    */   }
/*    */   
/*    */   public AddCash_Re(int _retcode_, Octets _userid_, int _zoneid_, int _sn_) {
/* 40 */     this.retcode = _retcode_;
/* 41 */     this.userid = _userid_;
/* 42 */     this.zoneid = _zoneid_;
/* 43 */     this.sn = _sn_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     _os_.marshal(this.userid);
/* 53 */     _os_.marshal(this.zoneid);
/* 54 */     _os_.marshal(this.sn);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.retcode = _os_.unmarshal_int();
/* 60 */     this.userid = _os_.unmarshal_Octets();
/* 61 */     this.zoneid = _os_.unmarshal_int();
/* 62 */     this.sn = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof AddCash_Re)) {
/* 72 */       AddCash_Re _o_ = (AddCash_Re)_o1_;
/* 73 */       if (this.retcode != _o_.retcode) return false;
/* 74 */       if (!this.userid.equals(_o_.userid)) return false;
/* 75 */       if (this.zoneid != _o_.zoneid) return false;
/* 76 */       if (this.sn != _o_.sn) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.retcode;
/* 85 */     _h_ += this.userid.hashCode();
/* 86 */     _h_ += this.zoneid;
/* 87 */     _h_ += this.sn;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.retcode).append(",");
/* 95 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 96 */     _sb_.append(this.zoneid).append(",");
/* 97 */     _sb_.append(this.sn).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\AddCash_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */