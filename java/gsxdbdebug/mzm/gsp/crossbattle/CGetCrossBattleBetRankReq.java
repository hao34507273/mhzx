/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.bet.PCGetCrossBattleBetRank;
/*     */ 
/*     */ public class CGetCrossBattleBetRankReq
/*     */   extends __CGetCrossBattleBetRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617095;
/*     */   public int ranktype;
/*     */   public int activity_cfg_id;
/*     */   public int startpos;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L)
/*  21 */       return;
/*  22 */     Role.addRoleProcedure(roleid, new PCGetCrossBattleBetRank(roleid, this.ranktype, this.activity_cfg_id, this.startpos, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12617095;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetCrossBattleBetRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetCrossBattleBetRankReq(int _ranktype_, int _activity_cfg_id_, int _startpos_, int _num_)
/*     */   {
/*  44 */     this.ranktype = _ranktype_;
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.startpos = _startpos_;
/*  47 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.ranktype);
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.startpos);
/*  58 */     _os_.marshal(this.num);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.ranktype = _os_.unmarshal_int();
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.startpos = _os_.unmarshal_int();
/*  66 */     this.num = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CGetCrossBattleBetRankReq)) {
/*  76 */       CGetCrossBattleBetRankReq _o_ = (CGetCrossBattleBetRankReq)_o1_;
/*  77 */       if (this.ranktype != _o_.ranktype) return false;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.startpos != _o_.startpos) return false;
/*  80 */       if (this.num != _o_.num) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.ranktype;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.startpos;
/*  91 */     _h_ += this.num;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.ranktype).append(",");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.startpos).append(",");
/* 101 */     _sb_.append(this.num).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetCrossBattleBetRankReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.ranktype - _o_.ranktype;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.startpos - _o_.startpos;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.num - _o_.num;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetCrossBattleBetRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */