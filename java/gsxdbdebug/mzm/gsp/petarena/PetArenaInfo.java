/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class PetArenaInfo
/*     */   implements Marshal, Comparable<PetArenaInfo>
/*     */ {
/*     */   public int rank;
/*     */   public int point;
/*     */   public int today_point;
/*     */   public int challenge_count;
/*     */   public int buy_count;
/*     */   public int refresh_time;
/*     */   
/*     */   public PetArenaInfo() {}
/*     */   
/*     */   public PetArenaInfo(int _rank_, int _point_, int _today_point_, int _challenge_count_, int _buy_count_, int _refresh_time_)
/*     */   {
/*  22 */     this.rank = _rank_;
/*  23 */     this.point = _point_;
/*  24 */     this.today_point = _today_point_;
/*  25 */     this.challenge_count = _challenge_count_;
/*  26 */     this.buy_count = _buy_count_;
/*  27 */     this.refresh_time = _refresh_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  35 */     _os_.marshal(this.rank);
/*  36 */     _os_.marshal(this.point);
/*  37 */     _os_.marshal(this.today_point);
/*  38 */     _os_.marshal(this.challenge_count);
/*  39 */     _os_.marshal(this.buy_count);
/*  40 */     _os_.marshal(this.refresh_time);
/*  41 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  45 */     this.rank = _os_.unmarshal_int();
/*  46 */     this.point = _os_.unmarshal_int();
/*  47 */     this.today_point = _os_.unmarshal_int();
/*  48 */     this.challenge_count = _os_.unmarshal_int();
/*  49 */     this.buy_count = _os_.unmarshal_int();
/*  50 */     this.refresh_time = _os_.unmarshal_int();
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  55 */     if (_o1_ == this) return true;
/*  56 */     if ((_o1_ instanceof PetArenaInfo)) {
/*  57 */       PetArenaInfo _o_ = (PetArenaInfo)_o1_;
/*  58 */       if (this.rank != _o_.rank) return false;
/*  59 */       if (this.point != _o_.point) return false;
/*  60 */       if (this.today_point != _o_.today_point) return false;
/*  61 */       if (this.challenge_count != _o_.challenge_count) return false;
/*  62 */       if (this.buy_count != _o_.buy_count) return false;
/*  63 */       if (this.refresh_time != _o_.refresh_time) return false;
/*  64 */       return true;
/*     */     }
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  70 */     int _h_ = 0;
/*  71 */     _h_ += this.rank;
/*  72 */     _h_ += this.point;
/*  73 */     _h_ += this.today_point;
/*  74 */     _h_ += this.challenge_count;
/*  75 */     _h_ += this.buy_count;
/*  76 */     _h_ += this.refresh_time;
/*  77 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  81 */     StringBuilder _sb_ = new StringBuilder();
/*  82 */     _sb_.append("(");
/*  83 */     _sb_.append(this.rank).append(",");
/*  84 */     _sb_.append(this.point).append(",");
/*  85 */     _sb_.append(this.today_point).append(",");
/*  86 */     _sb_.append(this.challenge_count).append(",");
/*  87 */     _sb_.append(this.buy_count).append(",");
/*  88 */     _sb_.append(this.refresh_time).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(PetArenaInfo _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.rank - _o_.rank;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.point - _o_.point;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.today_point - _o_.today_point;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.challenge_count - _o_.challenge_count;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.buy_count - _o_.buy_count;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.refresh_time - _o_.refresh_time;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\PetArenaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */