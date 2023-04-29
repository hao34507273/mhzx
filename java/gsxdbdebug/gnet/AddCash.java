/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class AddCash extends __AddCash__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 515;
/*     */   public Octets userid;
/*     */   public int zoneid;
/*     */   public int sn;
/*     */   public int cash;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     GdeliveryHelper.addCash(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  25 */     return 515;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AddCash()
/*     */   {
/*  34 */     this.userid = new Octets();
/*  35 */     this.zoneid = -1;
/*  36 */     this.sn = 0;
/*  37 */     this.cash = 0;
/*     */   }
/*     */   
/*     */   public AddCash(Octets _userid_, int _zoneid_, int _sn_, int _cash_) {
/*  41 */     this.userid = _userid_;
/*  42 */     this.zoneid = _zoneid_;
/*  43 */     this.sn = _sn_;
/*  44 */     this.cash = _cash_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.userid);
/*  53 */     _os_.marshal(this.zoneid);
/*  54 */     _os_.marshal(this.sn);
/*  55 */     _os_.marshal(this.cash);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.userid = _os_.unmarshal_Octets();
/*  61 */     this.zoneid = _os_.unmarshal_int();
/*  62 */     this.sn = _os_.unmarshal_int();
/*  63 */     this.cash = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof AddCash)) {
/*  73 */       AddCash _o_ = (AddCash)_o1_;
/*  74 */       if (!this.userid.equals(_o_.userid)) return false;
/*  75 */       if (this.zoneid != _o_.zoneid) return false;
/*  76 */       if (this.sn != _o_.sn) return false;
/*  77 */       if (this.cash != _o_.cash) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.userid.hashCode();
/*  86 */     _h_ += this.zoneid;
/*  87 */     _h_ += this.sn;
/*  88 */     _h_ += this.cash;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append("B").append(this.userid.size()).append(",");
/*  96 */     _sb_.append(this.zoneid).append(",");
/*  97 */     _sb_.append(this.sn).append(",");
/*  98 */     _sb_.append(this.cash).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\AddCash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */