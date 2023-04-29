/*     */ package mzm.gsp.bubblegame;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SStartBubbleGame
/*     */   extends __SStartBubbleGame__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12610050;
/*     */   public static final int RESTART_GAME = 0;
/*     */   public static final int RESUME_GAME = 1;
/*     */   public int game_id;
/*     */   public int complete_turn_index;
/*     */   public int current_point;
/*     */   public int start_timestamp;
/*     */   public int is_resume_game;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12610050;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartBubbleGame() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartBubbleGame(int _game_id_, int _complete_turn_index_, int _current_point_, int _start_timestamp_, int _is_resume_game_)
/*     */   {
/*  43 */     this.game_id = _game_id_;
/*  44 */     this.complete_turn_index = _complete_turn_index_;
/*  45 */     this.current_point = _current_point_;
/*  46 */     this.start_timestamp = _start_timestamp_;
/*  47 */     this.is_resume_game = _is_resume_game_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.game_id);
/*  56 */     _os_.marshal(this.complete_turn_index);
/*  57 */     _os_.marshal(this.current_point);
/*  58 */     _os_.marshal(this.start_timestamp);
/*  59 */     _os_.marshal(this.is_resume_game);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.game_id = _os_.unmarshal_int();
/*  65 */     this.complete_turn_index = _os_.unmarshal_int();
/*  66 */     this.current_point = _os_.unmarshal_int();
/*  67 */     this.start_timestamp = _os_.unmarshal_int();
/*  68 */     this.is_resume_game = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SStartBubbleGame)) {
/*  78 */       SStartBubbleGame _o_ = (SStartBubbleGame)_o1_;
/*  79 */       if (this.game_id != _o_.game_id) return false;
/*  80 */       if (this.complete_turn_index != _o_.complete_turn_index) return false;
/*  81 */       if (this.current_point != _o_.current_point) return false;
/*  82 */       if (this.start_timestamp != _o_.start_timestamp) return false;
/*  83 */       if (this.is_resume_game != _o_.is_resume_game) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.game_id;
/*  92 */     _h_ += this.complete_turn_index;
/*  93 */     _h_ += this.current_point;
/*  94 */     _h_ += this.start_timestamp;
/*  95 */     _h_ += this.is_resume_game;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.game_id).append(",");
/* 103 */     _sb_.append(this.complete_turn_index).append(",");
/* 104 */     _sb_.append(this.current_point).append(",");
/* 105 */     _sb_.append(this.start_timestamp).append(",");
/* 106 */     _sb_.append(this.is_resume_game).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStartBubbleGame _o_) {
/* 112 */     if (_o_ == this) return 0;
/* 113 */     int _c_ = 0;
/* 114 */     _c_ = this.game_id - _o_.game_id;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.complete_turn_index - _o_.complete_turn_index;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.current_point - _o_.current_point;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.start_timestamp - _o_.start_timestamp;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.is_resume_game - _o_.is_resume_game;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\SStartBubbleGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */