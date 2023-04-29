/*     */ package mzm.gsp.chart;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.chart.main.PGetRankReq;
/*     */ 
/*     */ 
/*     */ public class CGetRankList
/*     */   extends __CGetRankList__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587780;
/*     */   public int charttype;
/*     */   public int fromno;
/*     */   public int tono;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PGetRankReq(roleId, this.charttype, this.fromno, this.tono));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12587780;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetRankList() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetRankList(int _charttype_, int _fromno_, int _tono_)
/*     */   {
/*  42 */     this.charttype = _charttype_;
/*  43 */     this.fromno = _fromno_;
/*  44 */     this.tono = _tono_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.charttype);
/*  53 */     _os_.marshal(this.fromno);
/*  54 */     _os_.marshal(this.tono);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.charttype = _os_.unmarshal_int();
/*  60 */     this.fromno = _os_.unmarshal_int();
/*  61 */     this.tono = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CGetRankList)) {
/*  71 */       CGetRankList _o_ = (CGetRankList)_o1_;
/*  72 */       if (this.charttype != _o_.charttype) return false;
/*  73 */       if (this.fromno != _o_.fromno) return false;
/*  74 */       if (this.tono != _o_.tono) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.charttype;
/*  83 */     _h_ += this.fromno;
/*  84 */     _h_ += this.tono;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.charttype).append(",");
/*  92 */     _sb_.append(this.fromno).append(",");
/*  93 */     _sb_.append(this.tono).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetRankList _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.charttype - _o_.charttype;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.fromno - _o_.fromno;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.tono - _o_.tono;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\CGetRankList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */