/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.friendscircle.main.PCWeekPopularityChartReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CWeekPopularityChartReq
/*     */   extends __CWeekPopularityChartReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625421;
/*     */   public int start_pos;
/*     */   public int end_pos;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCWeekPopularityChartReq(roleId, this.start_pos, this.end_pos));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12625421;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CWeekPopularityChartReq() {}
/*     */   
/*     */ 
/*     */   public CWeekPopularityChartReq(int _start_pos_, int _end_pos_)
/*     */   {
/*  43 */     this.start_pos = _start_pos_;
/*  44 */     this.end_pos = _end_pos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.start_pos);
/*  53 */     _os_.marshal(this.end_pos);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.start_pos = _os_.unmarshal_int();
/*  59 */     this.end_pos = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CWeekPopularityChartReq)) {
/*  69 */       CWeekPopularityChartReq _o_ = (CWeekPopularityChartReq)_o1_;
/*  70 */       if (this.start_pos != _o_.start_pos) return false;
/*  71 */       if (this.end_pos != _o_.end_pos) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.start_pos;
/*  80 */     _h_ += this.end_pos;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.start_pos).append(",");
/*  88 */     _sb_.append(this.end_pos).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CWeekPopularityChartReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.start_pos - _o_.start_pos;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.end_pos - _o_.end_pos;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\CWeekPopularityChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */