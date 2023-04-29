/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SAgreeOrRefuseDrawAndGuessFailRep
/*     */   extends __SAgreeOrRefuseDrawAndGuessFailRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617250;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_MEMBER_IN_DRAW_AND_GUESS = -4;
/*     */   public static final int ERROR_LEADER_CANNOT_CHOOSE = -5;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -6;
/*     */   public static final int ERROR_NOT_IN_TEAM = -7;
/*     */   public static final int ERROR_TIME_OUT = -8;
/*     */   public static final int ERROR_CHOOSED_ALREADY = -9;
/*     */   public int error_code;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617250;
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
/*     */ 
/*     */   public SAgreeOrRefuseDrawAndGuessFailRep()
/*     */   {
/*  44 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAgreeOrRefuseDrawAndGuessFailRep(int _error_code_, ArrayList<String> _params_) {
/*  48 */     this.error_code = _error_code_;
/*  49 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.error_code);
/*  58 */     _os_.compact_uint32(this.params.size());
/*  59 */     for (String _v_ : this.params) {
/*  60 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.error_code = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  69 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  70 */       this.params.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SAgreeOrRefuseDrawAndGuessFailRep)) {
/*  81 */       SAgreeOrRefuseDrawAndGuessFailRep _o_ = (SAgreeOrRefuseDrawAndGuessFailRep)_o1_;
/*  82 */       if (this.error_code != _o_.error_code) return false;
/*  83 */       if (!this.params.equals(_o_.params)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.error_code;
/*  92 */     _h_ += this.params.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.error_code).append(",");
/* 100 */     _sb_.append(this.params).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SAgreeOrRefuseDrawAndGuessFailRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */