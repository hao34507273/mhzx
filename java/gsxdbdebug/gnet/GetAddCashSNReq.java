/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetAddCashSNReq
/*    */   extends __GetAddCashSNReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 200;
/*    */   public int xid;
/*    */   public Octets userid;
/*    */   public int zoneid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     GdeliveryHelper.getRetSN(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 200;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public GetAddCashSNReq()
/*    */   {
/* 35 */     this.xid = -1;
/* 36 */     this.userid = new Octets();
/* 37 */     this.zoneid = -1;
/*    */   }
/*    */   
/*    */   public GetAddCashSNReq(int _xid_, Octets _userid_, int _zoneid_) {
/* 41 */     this.xid = _xid_;
/* 42 */     this.userid = _userid_;
/* 43 */     this.zoneid = _zoneid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.xid);
/* 52 */     _os_.marshal(this.userid);
/* 53 */     _os_.marshal(this.zoneid);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.xid = _os_.unmarshal_int();
/* 59 */     this.userid = _os_.unmarshal_Octets();
/* 60 */     this.zoneid = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof GetAddCashSNReq)) {
/* 70 */       GetAddCashSNReq _o_ = (GetAddCashSNReq)_o1_;
/* 71 */       if (this.xid != _o_.xid) return false;
/* 72 */       if (!this.userid.equals(_o_.userid)) return false;
/* 73 */       if (this.zoneid != _o_.zoneid) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.xid;
/* 82 */     _h_ += this.userid.hashCode();
/* 83 */     _h_ += this.zoneid;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.xid).append(",");
/* 91 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 92 */     _sb_.append(this.zoneid).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GetAddCashSNReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */