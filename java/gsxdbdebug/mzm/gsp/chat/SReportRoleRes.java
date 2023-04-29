/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SReportRoleRes
/*     */   extends __SReportRoleRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585246;
/*     */   public static final int SUCCESS = 0;
/*     */   public static final int ERROR_TARGET_ROLE_NOT_EXIST = 1;
/*     */   public static final int ERROR_ROLE_LEVEL_INVALID = 2;
/*     */   public static final int ERROR_ROLE_VIGOR_NOT_ENOUGH = 3;
/*     */   public static final int ERROR_UNKNOW = 4;
/*     */   public static final int ERROR_REPORTED_ROLE = 5;
/*     */   public static final int ERROR_BASIS_EMPTY = 6;
/*     */   public int resultcode;
/*     */   public long targetroleid;
/*     */   public String targetrolename;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585246;
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
/*     */   public SReportRoleRes()
/*     */   {
/*  43 */     this.targetrolename = "";
/*     */   }
/*     */   
/*     */   public SReportRoleRes(int _resultcode_, long _targetroleid_, String _targetrolename_) {
/*  47 */     this.resultcode = _resultcode_;
/*  48 */     this.targetroleid = _targetroleid_;
/*  49 */     this.targetrolename = _targetrolename_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.resultcode);
/*  58 */     _os_.marshal(this.targetroleid);
/*  59 */     _os_.marshal(this.targetrolename, "UTF-16LE");
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.resultcode = _os_.unmarshal_int();
/*  65 */     this.targetroleid = _os_.unmarshal_long();
/*  66 */     this.targetrolename = _os_.unmarshal_String("UTF-16LE");
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SReportRoleRes)) {
/*  76 */       SReportRoleRes _o_ = (SReportRoleRes)_o1_;
/*  77 */       if (this.resultcode != _o_.resultcode) return false;
/*  78 */       if (this.targetroleid != _o_.targetroleid) return false;
/*  79 */       if (!this.targetrolename.equals(_o_.targetrolename)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.resultcode;
/*  88 */     _h_ += (int)this.targetroleid;
/*  89 */     _h_ += this.targetrolename.hashCode();
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.resultcode).append(",");
/*  97 */     _sb_.append(this.targetroleid).append(",");
/*  98 */     _sb_.append("T").append(this.targetrolename.length()).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SReportRoleRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */