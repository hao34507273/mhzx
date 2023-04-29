/*     */ package mzm.gsp.bigboss;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.bigboss.main.PBigbossChartReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBigbossChartReq
/*     */   extends __CBigbossChartReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598026;
/*     */   public int startpos;
/*     */   public int num;
/*     */   public int ocp;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleId, new PBigbossChartReq(roleId, this.startpos, this.num, this.ocp));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12598026;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBigbossChartReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBigbossChartReq(int _startpos_, int _num_, int _ocp_)
/*     */   {
/*  41 */     this.startpos = _startpos_;
/*  42 */     this.num = _num_;
/*  43 */     this.ocp = _ocp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.startpos);
/*  52 */     _os_.marshal(this.num);
/*  53 */     _os_.marshal(this.ocp);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.startpos = _os_.unmarshal_int();
/*  59 */     this.num = _os_.unmarshal_int();
/*  60 */     this.ocp = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CBigbossChartReq)) {
/*  70 */       CBigbossChartReq _o_ = (CBigbossChartReq)_o1_;
/*  71 */       if (this.startpos != _o_.startpos) return false;
/*  72 */       if (this.num != _o_.num) return false;
/*  73 */       if (this.ocp != _o_.ocp) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.startpos;
/*  82 */     _h_ += this.num;
/*  83 */     _h_ += this.ocp;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.startpos).append(",");
/*  91 */     _sb_.append(this.num).append(",");
/*  92 */     _sb_.append(this.ocp).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBigbossChartReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.startpos - _o_.startpos;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.num - _o_.num;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.ocp - _o_.ocp;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\CBigbossChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */