/*     */ package mzm.gsp.bigboss;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.bigboss.main.PCGetBigBossRemoteRank;
/*     */ 
/*     */ 
/*     */ public class CGetBigBossRemoteRankReq
/*     */   extends __CGetBigBossRemoteRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598030;
/*     */   public int occupation;
/*     */   public int startpos;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleid, new PCGetBigBossRemoteRank(roleid, this.occupation, this.startpos, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12598030;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetBigBossRemoteRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetBigBossRemoteRankReq(int _occupation_, int _startpos_, int _num_)
/*     */   {
/*  44 */     this.occupation = _occupation_;
/*  45 */     this.startpos = _startpos_;
/*  46 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.occupation);
/*  55 */     _os_.marshal(this.startpos);
/*  56 */     _os_.marshal(this.num);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.occupation = _os_.unmarshal_int();
/*  62 */     this.startpos = _os_.unmarshal_int();
/*  63 */     this.num = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CGetBigBossRemoteRankReq)) {
/*  73 */       CGetBigBossRemoteRankReq _o_ = (CGetBigBossRemoteRankReq)_o1_;
/*  74 */       if (this.occupation != _o_.occupation) return false;
/*  75 */       if (this.startpos != _o_.startpos) return false;
/*  76 */       if (this.num != _o_.num) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.occupation;
/*  85 */     _h_ += this.startpos;
/*  86 */     _h_ += this.num;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.occupation).append(",");
/*  94 */     _sb_.append(this.startpos).append(",");
/*  95 */     _sb_.append(this.num).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetBigBossRemoteRankReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.occupation - _o_.occupation;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.startpos - _o_.startpos;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.num - _o_.num;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\CGetBigBossRemoteRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */