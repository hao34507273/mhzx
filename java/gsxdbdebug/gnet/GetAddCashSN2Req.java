/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GetAddCashSN2Req extends __GetAddCashSN2Req__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 202;
/*     */   public int xid;
/*     */   public Octets userid;
/*     */   public int zoneid;
/*     */   public byte force;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     GdeliveryHelper.getRetSN2(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  25 */     return 202;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GetAddCashSN2Req()
/*     */   {
/*  34 */     this.xid = -1;
/*  35 */     this.userid = new Octets();
/*  36 */     this.zoneid = -1;
/*  37 */     this.force = -1;
/*     */   }
/*     */   
/*     */   public GetAddCashSN2Req(int _xid_, Octets _userid_, int _zoneid_, byte _force_) {
/*  41 */     this.xid = _xid_;
/*  42 */     this.userid = _userid_;
/*  43 */     this.zoneid = _zoneid_;
/*  44 */     this.force = _force_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.xid);
/*  53 */     _os_.marshal(this.userid);
/*  54 */     _os_.marshal(this.zoneid);
/*  55 */     _os_.marshal(this.force);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.xid = _os_.unmarshal_int();
/*  61 */     this.userid = _os_.unmarshal_Octets();
/*  62 */     this.zoneid = _os_.unmarshal_int();
/*  63 */     this.force = _os_.unmarshal_byte();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof GetAddCashSN2Req)) {
/*  73 */       GetAddCashSN2Req _o_ = (GetAddCashSN2Req)_o1_;
/*  74 */       if (this.xid != _o_.xid) return false;
/*  75 */       if (!this.userid.equals(_o_.userid)) return false;
/*  76 */       if (this.zoneid != _o_.zoneid) return false;
/*  77 */       if (this.force != _o_.force) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.xid;
/*  86 */     _h_ += this.userid.hashCode();
/*  87 */     _h_ += this.zoneid;
/*  88 */     _h_ += this.force;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.xid).append(",");
/*  96 */     _sb_.append("B").append(this.userid.size()).append(",");
/*  97 */     _sb_.append(this.zoneid).append(",");
/*  98 */     _sb_.append(this.force).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GetAddCashSN2Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */