/*     */ package mzm.gsp.lonngboatrace;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class SCommandResults extends __SCommandResults__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619270;
/*     */   public static final int CORRECT = 0;
/*     */   public static final int WRONG = 1;
/*     */   public static final int RANDOM = 2;
/*     */   public static final int NON_RANDOM = 3;
/*     */   public static final int CALC_SPEED = 4;
/*     */   public static final int NON_CALC_SPEED = 5;
/*     */   public int phaseid;
/*     */   public HashMap<Long, Integer> teamid2isallright;
/*     */   public HashMap<Long, Integer> roleid2isright;
/*     */   public int israndom;
/*     */   public long endtimestamp;
/*     */   public long currtimestamp;
/*     */   public int calcspeed;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619270;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCommandResults()
/*     */   {
/*  46 */     this.teamid2isallright = new HashMap();
/*  47 */     this.roleid2isright = new HashMap();
/*     */   }
/*     */   
/*     */   public SCommandResults(int _phaseid_, HashMap<Long, Integer> _teamid2isallright_, HashMap<Long, Integer> _roleid2isright_, int _israndom_, long _endtimestamp_, long _currtimestamp_, int _calcspeed_) {
/*  51 */     this.phaseid = _phaseid_;
/*  52 */     this.teamid2isallright = _teamid2isallright_;
/*  53 */     this.roleid2isright = _roleid2isright_;
/*  54 */     this.israndom = _israndom_;
/*  55 */     this.endtimestamp = _endtimestamp_;
/*  56 */     this.currtimestamp = _currtimestamp_;
/*  57 */     this.calcspeed = _calcspeed_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.phaseid);
/*  66 */     _os_.compact_uint32(this.teamid2isallright.size());
/*  67 */     for (java.util.Map.Entry<Long, Integer> _e_ : this.teamid2isallright.entrySet()) {
/*  68 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  69 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  71 */     _os_.compact_uint32(this.roleid2isright.size());
/*  72 */     for (java.util.Map.Entry<Long, Integer> _e_ : this.roleid2isright.entrySet()) {
/*  73 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  74 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  76 */     _os_.marshal(this.israndom);
/*  77 */     _os_.marshal(this.endtimestamp);
/*  78 */     _os_.marshal(this.currtimestamp);
/*  79 */     _os_.marshal(this.calcspeed);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  84 */     this.phaseid = _os_.unmarshal_int();
/*  85 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  87 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  89 */       int _v_ = _os_.unmarshal_int();
/*  90 */       this.teamid2isallright.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  92 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  94 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  96 */       int _v_ = _os_.unmarshal_int();
/*  97 */       this.roleid2isright.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  99 */     this.israndom = _os_.unmarshal_int();
/* 100 */     this.endtimestamp = _os_.unmarshal_long();
/* 101 */     this.currtimestamp = _os_.unmarshal_long();
/* 102 */     this.calcspeed = _os_.unmarshal_int();
/* 103 */     if (!_validator_()) {
/* 104 */       throw new VerifyError("validator failed");
/*     */     }
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 110 */     if (_o1_ == this) return true;
/* 111 */     if ((_o1_ instanceof SCommandResults)) {
/* 112 */       SCommandResults _o_ = (SCommandResults)_o1_;
/* 113 */       if (this.phaseid != _o_.phaseid) return false;
/* 114 */       if (!this.teamid2isallright.equals(_o_.teamid2isallright)) return false;
/* 115 */       if (!this.roleid2isright.equals(_o_.roleid2isright)) return false;
/* 116 */       if (this.israndom != _o_.israndom) return false;
/* 117 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/* 118 */       if (this.currtimestamp != _o_.currtimestamp) return false;
/* 119 */       if (this.calcspeed != _o_.calcspeed) return false;
/* 120 */       return true;
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 126 */     int _h_ = 0;
/* 127 */     _h_ += this.phaseid;
/* 128 */     _h_ += this.teamid2isallright.hashCode();
/* 129 */     _h_ += this.roleid2isright.hashCode();
/* 130 */     _h_ += this.israndom;
/* 131 */     _h_ += (int)this.endtimestamp;
/* 132 */     _h_ += (int)this.currtimestamp;
/* 133 */     _h_ += this.calcspeed;
/* 134 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 138 */     StringBuilder _sb_ = new StringBuilder();
/* 139 */     _sb_.append("(");
/* 140 */     _sb_.append(this.phaseid).append(",");
/* 141 */     _sb_.append(this.teamid2isallright).append(",");
/* 142 */     _sb_.append(this.roleid2isright).append(",");
/* 143 */     _sb_.append(this.israndom).append(",");
/* 144 */     _sb_.append(this.endtimestamp).append(",");
/* 145 */     _sb_.append(this.currtimestamp).append(",");
/* 146 */     _sb_.append(this.calcspeed).append(",");
/* 147 */     _sb_.append(")");
/* 148 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SCommandResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */