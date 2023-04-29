/*     */ package mzm.gsp.jiuxiao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.jiuxiao.main.PCJiuXiaoRankReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CJiuXiaoRankReq
/*     */   extends __CJiuXiaoRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595471;
/*     */   public int ranktype;
/*     */   public int fromno;
/*     */   public int tono;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCJiuXiaoRankReq(this.ranktype, this.fromno, this.tono, roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12595471;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CJiuXiaoRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CJiuXiaoRankReq(int _ranktype_, int _fromno_, int _tono_)
/*     */   {
/*  40 */     this.ranktype = _ranktype_;
/*  41 */     this.fromno = _fromno_;
/*  42 */     this.tono = _tono_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.ranktype);
/*  51 */     _os_.marshal(this.fromno);
/*  52 */     _os_.marshal(this.tono);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.ranktype = _os_.unmarshal_int();
/*  58 */     this.fromno = _os_.unmarshal_int();
/*  59 */     this.tono = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CJiuXiaoRankReq)) {
/*  69 */       CJiuXiaoRankReq _o_ = (CJiuXiaoRankReq)_o1_;
/*  70 */       if (this.ranktype != _o_.ranktype) return false;
/*  71 */       if (this.fromno != _o_.fromno) return false;
/*  72 */       if (this.tono != _o_.tono) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.ranktype;
/*  81 */     _h_ += this.fromno;
/*  82 */     _h_ += this.tono;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.ranktype).append(",");
/*  90 */     _sb_.append(this.fromno).append(",");
/*  91 */     _sb_.append(this.tono).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CJiuXiaoRankReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.ranktype - _o_.ranktype;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.fromno - _o_.fromno;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.tono - _o_.tono;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\CJiuXiaoRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */