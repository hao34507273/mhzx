/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*     */ public class SCheckTeamMemberNum
/*     */   extends __SCheckTeamMemberNum__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588312;
/*     */   public long rolebecheckedid;
/*     */   public long team;
/*     */   public int teammembernum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588312;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SCheckTeamMemberNum() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SCheckTeamMemberNum(long _rolebecheckedid_, long _team_, int _teammembernum_)
/*     */   {
/*  38 */     this.rolebecheckedid = _rolebecheckedid_;
/*  39 */     this.team = _team_;
/*  40 */     this.teammembernum = _teammembernum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.rolebecheckedid);
/*  49 */     _os_.marshal(this.team);
/*  50 */     _os_.marshal(this.teammembernum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.rolebecheckedid = _os_.unmarshal_long();
/*  56 */     this.team = _os_.unmarshal_long();
/*  57 */     this.teammembernum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SCheckTeamMemberNum)) {
/*  67 */       SCheckTeamMemberNum _o_ = (SCheckTeamMemberNum)_o1_;
/*  68 */       if (this.rolebecheckedid != _o_.rolebecheckedid) return false;
/*  69 */       if (this.team != _o_.team) return false;
/*  70 */       if (this.teammembernum != _o_.teammembernum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.rolebecheckedid;
/*  79 */     _h_ += (int)this.team;
/*  80 */     _h_ += this.teammembernum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.rolebecheckedid).append(",");
/*  88 */     _sb_.append(this.team).append(",");
/*  89 */     _sb_.append(this.teammembernum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCheckTeamMemberNum _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.rolebecheckedid - _o_.rolebecheckedid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.team - _o_.team);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.teammembernum - _o_.teammembernum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SCheckTeamMemberNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */