/*     */ package mzm.gsp.musicgame;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SStopMusicGame
/*     */   extends __SStopMusicGame__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609794;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int GAME_IS_NOT_START = -4;
/*     */   public static final int AWARD_FAIL = -5;
/*     */   public static final int RIGHT_SUN_AWARD_FAIL = -6;
/*     */   public static final int POINT_TO_UPPER_LINIT = -7;
/*     */   public static final int GAME_OVER = 1;
/*     */   public static final int GAME_PAUSE = 2;
/*     */   public int game_id;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609794;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStopMusicGame() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStopMusicGame(int _game_id_, int _res_)
/*     */   {
/*  47 */     this.game_id = _game_id_;
/*  48 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.game_id);
/*  57 */     _os_.marshal(this.res);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.game_id = _os_.unmarshal_int();
/*  63 */     this.res = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SStopMusicGame)) {
/*  73 */       SStopMusicGame _o_ = (SStopMusicGame)_o1_;
/*  74 */       if (this.game_id != _o_.game_id) return false;
/*  75 */       if (this.res != _o_.res) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.game_id;
/*  84 */     _h_ += this.res;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.game_id).append(",");
/*  92 */     _sb_.append(this.res).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStopMusicGame _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.game_id - _o_.game_id;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.res - _o_.res;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\SStopMusicGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */