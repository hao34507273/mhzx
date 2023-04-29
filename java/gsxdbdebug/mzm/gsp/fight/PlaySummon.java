/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class PlaySummon implements Marshal
/*     */ {
/*     */   public static final int SUMMON_BACK = 0;
/*     */   public static final int SUMMON = 1;
/*     */   public static final int ACTIVE_TEAM = 2;
/*     */   public static final int PASSIVE_TEAM = 3;
/*     */   public int result;
/*     */   public int fighterid;
/*     */   public HashMap<Integer, Fighter> fighters;
/*     */   public int groupid;
/*     */   public int team;
/*     */   
/*     */   public PlaySummon()
/*     */   {
/*  23 */     this.fighters = new HashMap();
/*     */   }
/*     */   
/*     */   public PlaySummon(int _result_, int _fighterid_, HashMap<Integer, Fighter> _fighters_, int _groupid_, int _team_) {
/*  27 */     this.result = _result_;
/*  28 */     this.fighterid = _fighterid_;
/*  29 */     this.fighters = _fighters_;
/*  30 */     this.groupid = _groupid_;
/*  31 */     this.team = _team_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     for (Map.Entry<Integer, Fighter> _e_ : this.fighters.entrySet()) {
/*  36 */       if (!((Fighter)_e_.getValue())._validator_()) return false;
/*     */     }
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.result);
/*  43 */     _os_.marshal(this.fighterid);
/*  44 */     _os_.compact_uint32(this.fighters.size());
/*  45 */     for (Map.Entry<Integer, Fighter> _e_ : this.fighters.entrySet()) {
/*  46 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  47 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  49 */     _os_.marshal(this.groupid);
/*  50 */     _os_.marshal(this.team);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.result = _os_.unmarshal_int();
/*  56 */     this.fighterid = _os_.unmarshal_int();
/*  57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  59 */       int _k_ = _os_.unmarshal_int();
/*  60 */       Fighter _v_ = new Fighter();
/*  61 */       _v_.unmarshal(_os_);
/*  62 */       this.fighters.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  64 */     this.groupid = _os_.unmarshal_int();
/*  65 */     this.team = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof PlaySummon)) {
/*  72 */       PlaySummon _o_ = (PlaySummon)_o1_;
/*  73 */       if (this.result != _o_.result) return false;
/*  74 */       if (this.fighterid != _o_.fighterid) return false;
/*  75 */       if (!this.fighters.equals(_o_.fighters)) return false;
/*  76 */       if (this.groupid != _o_.groupid) return false;
/*  77 */       if (this.team != _o_.team) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.result;
/*  86 */     _h_ += this.fighterid;
/*  87 */     _h_ += this.fighters.hashCode();
/*  88 */     _h_ += this.groupid;
/*  89 */     _h_ += this.team;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.result).append(",");
/*  97 */     _sb_.append(this.fighterid).append(",");
/*  98 */     _sb_.append(this.fighters).append(",");
/*  99 */     _sb_.append(this.groupid).append(",");
/* 100 */     _sb_.append(this.team).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlaySummon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */