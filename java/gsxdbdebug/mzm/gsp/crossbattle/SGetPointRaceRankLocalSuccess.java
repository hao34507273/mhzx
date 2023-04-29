/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetPointRaceRankLocalSuccess
/*     */   extends __SGetPointRaceRankLocalSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617066;
/*     */   public int time_point_cfgid;
/*     */   public int activity_cfgid;
/*     */   public int zone;
/*     */   public int from;
/*     */   public int to;
/*     */   public ArrayList<PointRaceRankData> point_race_ranks;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617066;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetPointRaceRankLocalSuccess()
/*     */   {
/*  38 */     this.point_race_ranks = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetPointRaceRankLocalSuccess(int _time_point_cfgid_, int _activity_cfgid_, int _zone_, int _from_, int _to_, ArrayList<PointRaceRankData> _point_race_ranks_) {
/*  42 */     this.time_point_cfgid = _time_point_cfgid_;
/*  43 */     this.activity_cfgid = _activity_cfgid_;
/*  44 */     this.zone = _zone_;
/*  45 */     this.from = _from_;
/*  46 */     this.to = _to_;
/*  47 */     this.point_race_ranks = _point_race_ranks_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (PointRaceRankData _v_ : this.point_race_ranks)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.time_point_cfgid);
/*  58 */     _os_.marshal(this.activity_cfgid);
/*  59 */     _os_.marshal(this.zone);
/*  60 */     _os_.marshal(this.from);
/*  61 */     _os_.marshal(this.to);
/*  62 */     _os_.compact_uint32(this.point_race_ranks.size());
/*  63 */     for (PointRaceRankData _v_ : this.point_race_ranks) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.time_point_cfgid = _os_.unmarshal_int();
/*  71 */     this.activity_cfgid = _os_.unmarshal_int();
/*  72 */     this.zone = _os_.unmarshal_int();
/*  73 */     this.from = _os_.unmarshal_int();
/*  74 */     this.to = _os_.unmarshal_int();
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  76 */       PointRaceRankData _v_ = new PointRaceRankData();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.point_race_ranks.add(_v_);
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SGetPointRaceRankLocalSuccess)) {
/*  89 */       SGetPointRaceRankLocalSuccess _o_ = (SGetPointRaceRankLocalSuccess)_o1_;
/*  90 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/*  91 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  92 */       if (this.zone != _o_.zone) return false;
/*  93 */       if (this.from != _o_.from) return false;
/*  94 */       if (this.to != _o_.to) return false;
/*  95 */       if (!this.point_race_ranks.equals(_o_.point_race_ranks)) return false;
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 102 */     int _h_ = 0;
/* 103 */     _h_ += this.time_point_cfgid;
/* 104 */     _h_ += this.activity_cfgid;
/* 105 */     _h_ += this.zone;
/* 106 */     _h_ += this.from;
/* 107 */     _h_ += this.to;
/* 108 */     _h_ += this.point_race_ranks.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.time_point_cfgid).append(",");
/* 116 */     _sb_.append(this.activity_cfgid).append(",");
/* 117 */     _sb_.append(this.zone).append(",");
/* 118 */     _sb_.append(this.from).append(",");
/* 119 */     _sb_.append(this.to).append(",");
/* 120 */     _sb_.append(this.point_race_ranks).append(",");
/* 121 */     _sb_.append(")");
/* 122 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetPointRaceRankLocalSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */