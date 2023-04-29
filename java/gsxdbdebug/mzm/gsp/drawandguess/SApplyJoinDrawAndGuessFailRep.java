/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SApplyJoinDrawAndGuessFailRep extends __SApplyJoinDrawAndGuessFailRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617232;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_PARAM = -4;
/*     */   public static final int ERROR_NPC_SERVER = -5;
/*     */   public static final int ERROR_MEMBER_IN_DRAW_AND_GUESS = -6;
/*     */   public static final int ERROR_TEAM_MEMBER_ERROR = -7;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -8;
/*     */   public static final int ERROR_NO_TEAM = -9;
/*     */   public static final int ERROR_NOT_TEAM_LEADER = -10;
/*     */   public int error_code;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617232;
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
/*     */ 
/*     */   public SApplyJoinDrawAndGuessFailRep()
/*     */   {
/*  45 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SApplyJoinDrawAndGuessFailRep(int _error_code_, ArrayList<String> _params_) {
/*  49 */     this.error_code = _error_code_;
/*  50 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.error_code);
/*  59 */     _os_.compact_uint32(this.params.size());
/*  60 */     for (String _v_ : this.params) {
/*  61 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.error_code = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  70 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  71 */       this.params.add(_v_);
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SApplyJoinDrawAndGuessFailRep)) {
/*  82 */       SApplyJoinDrawAndGuessFailRep _o_ = (SApplyJoinDrawAndGuessFailRep)_o1_;
/*  83 */       if (this.error_code != _o_.error_code) return false;
/*  84 */       if (!this.params.equals(_o_.params)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.error_code;
/*  93 */     _h_ += this.params.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.error_code).append(",");
/* 101 */     _sb_.append(this.params).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SApplyJoinDrawAndGuessFailRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */