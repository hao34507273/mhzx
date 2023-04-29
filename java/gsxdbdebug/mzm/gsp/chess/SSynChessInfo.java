/*     */ package mzm.gsp.chess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SSynChessInfo extends __SSynChessInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619032;
/*     */   public static final int SIDE_RED = 1;
/*     */   public static final int SIDE_BLUE = 2;
/*     */   public int cfg_id;
/*     */   public long enemy_id;
/*     */   public String enemy_name;
/*     */   public int enemy_occupation;
/*     */   public int enemy_gender;
/*     */   public int enemy_level;
/*     */   public int enemy_avatar;
/*     */   public int current_player;
/*     */   public int self_side;
/*     */   public int round;
/*     */   public long round_start_time;
/*     */   public java.util.ArrayList<ChessPieceInfo> chess_piece_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619032;
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
/*     */ 
/*     */   public SSynChessInfo()
/*     */   {
/*  47 */     this.enemy_name = "";
/*  48 */     this.chess_piece_infos = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SSynChessInfo(int _cfg_id_, long _enemy_id_, String _enemy_name_, int _enemy_occupation_, int _enemy_gender_, int _enemy_level_, int _enemy_avatar_, int _current_player_, int _self_side_, int _round_, long _round_start_time_, java.util.ArrayList<ChessPieceInfo> _chess_piece_infos_) {
/*  52 */     this.cfg_id = _cfg_id_;
/*  53 */     this.enemy_id = _enemy_id_;
/*  54 */     this.enemy_name = _enemy_name_;
/*  55 */     this.enemy_occupation = _enemy_occupation_;
/*  56 */     this.enemy_gender = _enemy_gender_;
/*  57 */     this.enemy_level = _enemy_level_;
/*  58 */     this.enemy_avatar = _enemy_avatar_;
/*  59 */     this.current_player = _current_player_;
/*  60 */     this.self_side = _self_side_;
/*  61 */     this.round = _round_;
/*  62 */     this.round_start_time = _round_start_time_;
/*  63 */     this.chess_piece_infos = _chess_piece_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  67 */     for (ChessPieceInfo _v_ : this.chess_piece_infos)
/*  68 */       if (!_v_._validator_()) return false;
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  73 */     _os_.marshal(this.cfg_id);
/*  74 */     _os_.marshal(this.enemy_id);
/*  75 */     _os_.marshal(this.enemy_name, "UTF-16LE");
/*  76 */     _os_.marshal(this.enemy_occupation);
/*  77 */     _os_.marshal(this.enemy_gender);
/*  78 */     _os_.marshal(this.enemy_level);
/*  79 */     _os_.marshal(this.enemy_avatar);
/*  80 */     _os_.marshal(this.current_player);
/*  81 */     _os_.marshal(this.self_side);
/*  82 */     _os_.marshal(this.round);
/*  83 */     _os_.marshal(this.round_start_time);
/*  84 */     _os_.compact_uint32(this.chess_piece_infos.size());
/*  85 */     for (ChessPieceInfo _v_ : this.chess_piece_infos) {
/*  86 */       _os_.marshal(_v_);
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  92 */     this.cfg_id = _os_.unmarshal_int();
/*  93 */     this.enemy_id = _os_.unmarshal_long();
/*  94 */     this.enemy_name = _os_.unmarshal_String("UTF-16LE");
/*  95 */     this.enemy_occupation = _os_.unmarshal_int();
/*  96 */     this.enemy_gender = _os_.unmarshal_int();
/*  97 */     this.enemy_level = _os_.unmarshal_int();
/*  98 */     this.enemy_avatar = _os_.unmarshal_int();
/*  99 */     this.current_player = _os_.unmarshal_int();
/* 100 */     this.self_side = _os_.unmarshal_int();
/* 101 */     this.round = _os_.unmarshal_int();
/* 102 */     this.round_start_time = _os_.unmarshal_long();
/* 103 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 104 */       ChessPieceInfo _v_ = new ChessPieceInfo();
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.chess_piece_infos.add(_v_);
/*     */     }
/* 108 */     if (!_validator_()) {
/* 109 */       throw new VerifyError("validator failed");
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 115 */     if (_o1_ == this) return true;
/* 116 */     if ((_o1_ instanceof SSynChessInfo)) {
/* 117 */       SSynChessInfo _o_ = (SSynChessInfo)_o1_;
/* 118 */       if (this.cfg_id != _o_.cfg_id) return false;
/* 119 */       if (this.enemy_id != _o_.enemy_id) return false;
/* 120 */       if (!this.enemy_name.equals(_o_.enemy_name)) return false;
/* 121 */       if (this.enemy_occupation != _o_.enemy_occupation) return false;
/* 122 */       if (this.enemy_gender != _o_.enemy_gender) return false;
/* 123 */       if (this.enemy_level != _o_.enemy_level) return false;
/* 124 */       if (this.enemy_avatar != _o_.enemy_avatar) return false;
/* 125 */       if (this.current_player != _o_.current_player) return false;
/* 126 */       if (this.self_side != _o_.self_side) return false;
/* 127 */       if (this.round != _o_.round) return false;
/* 128 */       if (this.round_start_time != _o_.round_start_time) return false;
/* 129 */       if (!this.chess_piece_infos.equals(_o_.chess_piece_infos)) return false;
/* 130 */       return true;
/*     */     }
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 136 */     int _h_ = 0;
/* 137 */     _h_ += this.cfg_id;
/* 138 */     _h_ += (int)this.enemy_id;
/* 139 */     _h_ += this.enemy_name.hashCode();
/* 140 */     _h_ += this.enemy_occupation;
/* 141 */     _h_ += this.enemy_gender;
/* 142 */     _h_ += this.enemy_level;
/* 143 */     _h_ += this.enemy_avatar;
/* 144 */     _h_ += this.current_player;
/* 145 */     _h_ += this.self_side;
/* 146 */     _h_ += this.round;
/* 147 */     _h_ += (int)this.round_start_time;
/* 148 */     _h_ += this.chess_piece_infos.hashCode();
/* 149 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder _sb_ = new StringBuilder();
/* 154 */     _sb_.append("(");
/* 155 */     _sb_.append(this.cfg_id).append(",");
/* 156 */     _sb_.append(this.enemy_id).append(",");
/* 157 */     _sb_.append("T").append(this.enemy_name.length()).append(",");
/* 158 */     _sb_.append(this.enemy_occupation).append(",");
/* 159 */     _sb_.append(this.enemy_gender).append(",");
/* 160 */     _sb_.append(this.enemy_level).append(",");
/* 161 */     _sb_.append(this.enemy_avatar).append(",");
/* 162 */     _sb_.append(this.current_player).append(",");
/* 163 */     _sb_.append(this.self_side).append(",");
/* 164 */     _sb_.append(this.round).append(",");
/* 165 */     _sb_.append(this.round_start_time).append(",");
/* 166 */     _sb_.append(this.chess_piece_infos).append(",");
/* 167 */     _sb_.append(")");
/* 168 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\SSynChessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */