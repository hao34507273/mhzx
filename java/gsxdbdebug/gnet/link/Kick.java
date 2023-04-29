/*     */ package gnet.link;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class Kick
/*     */   extends __Kick__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 1048579;
/*     */   public static final int E_PROTOCOL_UNKOWN = 1;
/*     */   public static final int E_MARSHAL_EXCEPTION = 2;
/*     */   public static final int E_PROTOCOL_EXCEPTION = 3;
/*     */   public static final int A_QUICK_CLOSE = 1;
/*     */   public static final int A_DELAY_CLOSE = 2;
/*     */   public static final int A_ACKICKOUT = 3;
/*     */   public int linksid;
/*     */   public int action;
/*     */   public int error;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 1048579;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Kick() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Kick(int _linksid_, int _action_, int _error_)
/*     */   {
/*  43 */     this.linksid = _linksid_;
/*  44 */     this.action = _action_;
/*  45 */     this.error = _error_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.linksid);
/*  54 */     _os_.marshal(this.action);
/*  55 */     _os_.marshal(this.error);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.linksid = _os_.unmarshal_int();
/*  61 */     this.action = _os_.unmarshal_int();
/*  62 */     this.error = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof Kick)) {
/*  72 */       Kick _o_ = (Kick)_o1_;
/*  73 */       if (this.linksid != _o_.linksid) return false;
/*  74 */       if (this.action != _o_.action) return false;
/*  75 */       if (this.error != _o_.error) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.linksid;
/*  84 */     _h_ += this.action;
/*  85 */     _h_ += this.error;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.linksid).append(",");
/*  93 */     _sb_.append(this.action).append(",");
/*  94 */     _sb_.append(this.error).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(Kick _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.linksid - _o_.linksid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.action - _o_.action;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.error - _o_.error;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Kick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */