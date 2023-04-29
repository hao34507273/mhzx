/*     */ package mzm.gsp.musicgame;
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
/*     */ public class SStartMusicGame
/*     */   extends __SStartMusicGame__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609796;
/*     */   public int game_id;
/*     */   public int complete_turn_index;
/*     */   public int current_point;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609796;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SStartMusicGame() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SStartMusicGame(int _game_id_, int _complete_turn_index_, int _current_point_)
/*     */   {
/*  38 */     this.game_id = _game_id_;
/*  39 */     this.complete_turn_index = _complete_turn_index_;
/*  40 */     this.current_point = _current_point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.game_id);
/*  49 */     _os_.marshal(this.complete_turn_index);
/*  50 */     _os_.marshal(this.current_point);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.game_id = _os_.unmarshal_int();
/*  56 */     this.complete_turn_index = _os_.unmarshal_int();
/*  57 */     this.current_point = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SStartMusicGame)) {
/*  67 */       SStartMusicGame _o_ = (SStartMusicGame)_o1_;
/*  68 */       if (this.game_id != _o_.game_id) return false;
/*  69 */       if (this.complete_turn_index != _o_.complete_turn_index) return false;
/*  70 */       if (this.current_point != _o_.current_point) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.game_id;
/*  79 */     _h_ += this.complete_turn_index;
/*  80 */     _h_ += this.current_point;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.game_id).append(",");
/*  88 */     _sb_.append(this.complete_turn_index).append(",");
/*  89 */     _sb_.append(this.current_point).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStartMusicGame _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.game_id - _o_.game_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.complete_turn_index - _o_.complete_turn_index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.current_point - _o_.current_point;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\SStartMusicGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */