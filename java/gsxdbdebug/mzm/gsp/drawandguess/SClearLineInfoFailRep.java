/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SClearLineInfoFailRep
/*     */   extends __SClearLineInfoFailRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617254;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_ANSWERER_CANNOT_CLEAR = -4;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -5;
/*     */   public static final int ERROR_NOT_IN_TEAM = -6;
/*     */   public static final int ERROR_TIME_OUT = -7;
/*     */   public static final int ERROR_NOT_IN_GAME = -8;
/*     */   public int error_code;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617254;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SClearLineInfoFailRep()
/*     */   {
/*  43 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SClearLineInfoFailRep(int _error_code_, ArrayList<String> _params_) {
/*  47 */     this.error_code = _error_code_;
/*  48 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.error_code);
/*  57 */     _os_.compact_uint32(this.params.size());
/*  58 */     for (String _v_ : this.params) {
/*  59 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.error_code = _os_.unmarshal_int();
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  68 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  69 */       this.params.add(_v_);
/*     */     }
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SClearLineInfoFailRep)) {
/*  80 */       SClearLineInfoFailRep _o_ = (SClearLineInfoFailRep)_o1_;
/*  81 */       if (this.error_code != _o_.error_code) return false;
/*  82 */       if (!this.params.equals(_o_.params)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.error_code;
/*  91 */     _h_ += this.params.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.error_code).append(",");
/*  99 */     _sb_.append(this.params).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SClearLineInfoFailRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */