/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ 
/*     */ public class CGetCrossBattleVoteRankReq extends __CGetCrossBattleVoteRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616971;
/*     */   public static final int ACCESS_TYPE_POSITION = 0;
/*     */   public static final int ACCESS_TYPE_CORPS_ID = 1;
/*     */   public int activity_cfg_id;
/*     */   public int rank_type;
/*     */   public int access_type;
/*     */   public int startpos;
/*     */   public long corps_id;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = mzm.gsp.Role.getRoleId(this);
/*  21 */     if ((roleid < 0L) || (!mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new mzm.gsp.crossbattle.own.PCGetCrossBattleVoteRank(roleid, this.activity_cfg_id, this.rank_type, this.access_type, this.startpos, this.corps_id, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12616971;
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
/*     */   public CGetCrossBattleVoteRankReq()
/*     */   {
/*  50 */     this.rank_type = 0;
/*     */   }
/*     */   
/*     */   public CGetCrossBattleVoteRankReq(int _activity_cfg_id_, int _rank_type_, int _access_type_, int _startpos_, long _corps_id_, int _num_) {
/*  54 */     this.activity_cfg_id = _activity_cfg_id_;
/*  55 */     this.rank_type = _rank_type_;
/*  56 */     this.access_type = _access_type_;
/*  57 */     this.startpos = _startpos_;
/*  58 */     this.corps_id = _corps_id_;
/*  59 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.activity_cfg_id);
/*  68 */     _os_.marshal(this.rank_type);
/*  69 */     _os_.marshal(this.access_type);
/*  70 */     _os_.marshal(this.startpos);
/*  71 */     _os_.marshal(this.corps_id);
/*  72 */     _os_.marshal(this.num);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  77 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  78 */     this.rank_type = _os_.unmarshal_int();
/*  79 */     this.access_type = _os_.unmarshal_int();
/*  80 */     this.startpos = _os_.unmarshal_int();
/*  81 */     this.corps_id = _os_.unmarshal_long();
/*  82 */     this.num = _os_.unmarshal_int();
/*  83 */     if (!_validator_()) {
/*  84 */       throw new VerifyError("validator failed");
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  90 */     if (_o1_ == this) return true;
/*  91 */     if ((_o1_ instanceof CGetCrossBattleVoteRankReq)) {
/*  92 */       CGetCrossBattleVoteRankReq _o_ = (CGetCrossBattleVoteRankReq)_o1_;
/*  93 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  94 */       if (this.rank_type != _o_.rank_type) return false;
/*  95 */       if (this.access_type != _o_.access_type) return false;
/*  96 */       if (this.startpos != _o_.startpos) return false;
/*  97 */       if (this.corps_id != _o_.corps_id) return false;
/*  98 */       if (this.num != _o_.num) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.activity_cfg_id;
/* 107 */     _h_ += this.rank_type;
/* 108 */     _h_ += this.access_type;
/* 109 */     _h_ += this.startpos;
/* 110 */     _h_ += (int)this.corps_id;
/* 111 */     _h_ += this.num;
/* 112 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuilder _sb_ = new StringBuilder();
/* 117 */     _sb_.append("(");
/* 118 */     _sb_.append(this.activity_cfg_id).append(",");
/* 119 */     _sb_.append(this.rank_type).append(",");
/* 120 */     _sb_.append(this.access_type).append(",");
/* 121 */     _sb_.append(this.startpos).append(",");
/* 122 */     _sb_.append(this.corps_id).append(",");
/* 123 */     _sb_.append(this.num).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetCrossBattleVoteRankReq _o_) {
/* 129 */     if (_o_ == this) return 0;
/* 130 */     int _c_ = 0;
/* 131 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = this.rank_type - _o_.rank_type;
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     _c_ = this.access_type - _o_.access_type;
/* 136 */     if (0 != _c_) return _c_;
/* 137 */     _c_ = this.startpos - _o_.startpos;
/* 138 */     if (0 != _c_) return _c_;
/* 139 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 140 */     if (0 != _c_) return _c_;
/* 141 */     _c_ = this.num - _o_.num;
/* 142 */     if (0 != _c_) return _c_;
/* 143 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetCrossBattleVoteRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */