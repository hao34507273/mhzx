/*     */ package mzm.gsp.crossfield;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossfield.main.PCGetCrossFieldRank;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGetCrossFieldRankReq
/*     */   extends __CGetCrossFieldRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619532;
/*     */   public int ranktype;
/*     */   public int startpos;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PCGetCrossFieldRank(roleid, this.ranktype, this.startpos, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12619532;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossFieldRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossFieldRankReq(int _ranktype_, int _startpos_, int _num_)
/*     */   {
/*  42 */     this.ranktype = _ranktype_;
/*  43 */     this.startpos = _startpos_;
/*  44 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.ranktype);
/*  53 */     _os_.marshal(this.startpos);
/*  54 */     _os_.marshal(this.num);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.ranktype = _os_.unmarshal_int();
/*  60 */     this.startpos = _os_.unmarshal_int();
/*  61 */     this.num = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CGetCrossFieldRankReq)) {
/*  71 */       CGetCrossFieldRankReq _o_ = (CGetCrossFieldRankReq)_o1_;
/*  72 */       if (this.ranktype != _o_.ranktype) return false;
/*  73 */       if (this.startpos != _o_.startpos) return false;
/*  74 */       if (this.num != _o_.num) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.ranktype;
/*  83 */     _h_ += this.startpos;
/*  84 */     _h_ += this.num;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.ranktype).append(",");
/*  92 */     _sb_.append(this.startpos).append(",");
/*  93 */     _sb_.append(this.num).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetCrossFieldRankReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.ranktype - _o_.ranktype;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.startpos - _o_.startpos;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.num - _o_.num;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\CGetCrossFieldRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */