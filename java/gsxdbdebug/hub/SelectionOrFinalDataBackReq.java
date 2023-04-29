/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SelectionOrFinalDataBackReq implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int WIN = 1;
/*     */   public static final int LOSE = 0;
/*     */   public int fight_type;
/*     */   public int fight_stage;
/*     */   public int fight_index_id;
/*     */   public int win_or_lose;
/*     */   public long own_corps_id;
/*     */   public Octets own_corps_name;
/*     */   public long opponent_corps_id;
/*     */   public Octets opponent_corps_name;
/*     */   public ArrayList<Long> team_role_list;
/*     */   public ArrayList<Octets> team_user_list;
/*     */   public HashMap<Long, ExchangeDataHandlerInfo> exchange_data_handler_info_map;
/*     */   
/*     */   public SelectionOrFinalDataBackReq()
/*     */   {
/*  27 */     this.own_corps_name = new Octets();
/*  28 */     this.opponent_corps_name = new Octets();
/*  29 */     this.team_role_list = new ArrayList();
/*  30 */     this.team_user_list = new ArrayList();
/*  31 */     this.exchange_data_handler_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SelectionOrFinalDataBackReq(int _fight_type_, int _fight_stage_, int _fight_index_id_, int _win_or_lose_, long _own_corps_id_, Octets _own_corps_name_, long _opponent_corps_id_, Octets _opponent_corps_name_, ArrayList<Long> _team_role_list_, ArrayList<Octets> _team_user_list_, HashMap<Long, ExchangeDataHandlerInfo> _exchange_data_handler_info_map_) {
/*  35 */     this.fight_type = _fight_type_;
/*  36 */     this.fight_stage = _fight_stage_;
/*  37 */     this.fight_index_id = _fight_index_id_;
/*  38 */     this.win_or_lose = _win_or_lose_;
/*  39 */     this.own_corps_id = _own_corps_id_;
/*  40 */     this.own_corps_name = _own_corps_name_;
/*  41 */     this.opponent_corps_id = _opponent_corps_id_;
/*  42 */     this.opponent_corps_name = _opponent_corps_name_;
/*  43 */     this.team_role_list = _team_role_list_;
/*  44 */     this.team_user_list = _team_user_list_;
/*  45 */     this.exchange_data_handler_info_map = _exchange_data_handler_info_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (Map.Entry<Long, ExchangeDataHandlerInfo> _e_ : this.exchange_data_handler_info_map.entrySet()) {
/*  50 */       if (!((ExchangeDataHandlerInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.fight_type);
/*  57 */     _os_.marshal(this.fight_stage);
/*  58 */     _os_.marshal(this.fight_index_id);
/*  59 */     _os_.marshal(this.win_or_lose);
/*  60 */     _os_.marshal(this.own_corps_id);
/*  61 */     _os_.marshal(this.own_corps_name);
/*  62 */     _os_.marshal(this.opponent_corps_id);
/*  63 */     _os_.marshal(this.opponent_corps_name);
/*  64 */     _os_.compact_uint32(this.team_role_list.size());
/*  65 */     for (Long _v_ : this.team_role_list) {
/*  66 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  68 */     _os_.compact_uint32(this.team_user_list.size());
/*  69 */     for (Octets _v_ : this.team_user_list) {
/*  70 */       _os_.marshal(_v_);
/*     */     }
/*  72 */     _os_.compact_uint32(this.exchange_data_handler_info_map.size());
/*  73 */     for (Map.Entry<Long, ExchangeDataHandlerInfo> _e_ : this.exchange_data_handler_info_map.entrySet()) {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  81 */     this.fight_type = _os_.unmarshal_int();
/*  82 */     this.fight_stage = _os_.unmarshal_int();
/*  83 */     this.fight_index_id = _os_.unmarshal_int();
/*  84 */     this.win_or_lose = _os_.unmarshal_int();
/*  85 */     this.own_corps_id = _os_.unmarshal_long();
/*  86 */     this.own_corps_name = _os_.unmarshal_Octets();
/*  87 */     this.opponent_corps_id = _os_.unmarshal_long();
/*  88 */     this.opponent_corps_name = _os_.unmarshal_Octets();
/*  89 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  91 */       long _v_ = _os_.unmarshal_long();
/*  92 */       this.team_role_list.add(Long.valueOf(_v_));
/*     */     }
/*  94 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  96 */       Octets _v_ = _os_.unmarshal_Octets();
/*  97 */       this.team_user_list.add(_v_);
/*     */     }
/*  99 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 101 */       long _k_ = _os_.unmarshal_long();
/* 102 */       ExchangeDataHandlerInfo _v_ = new ExchangeDataHandlerInfo();
/* 103 */       _v_.unmarshal(_os_);
/* 104 */       this.exchange_data_handler_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 110 */     if (_o1_ == this) return true;
/* 111 */     if ((_o1_ instanceof SelectionOrFinalDataBackReq)) {
/* 112 */       SelectionOrFinalDataBackReq _o_ = (SelectionOrFinalDataBackReq)_o1_;
/* 113 */       if (this.fight_type != _o_.fight_type) return false;
/* 114 */       if (this.fight_stage != _o_.fight_stage) return false;
/* 115 */       if (this.fight_index_id != _o_.fight_index_id) return false;
/* 116 */       if (this.win_or_lose != _o_.win_or_lose) return false;
/* 117 */       if (this.own_corps_id != _o_.own_corps_id) return false;
/* 118 */       if (!this.own_corps_name.equals(_o_.own_corps_name)) return false;
/* 119 */       if (this.opponent_corps_id != _o_.opponent_corps_id) return false;
/* 120 */       if (!this.opponent_corps_name.equals(_o_.opponent_corps_name)) return false;
/* 121 */       if (!this.team_role_list.equals(_o_.team_role_list)) return false;
/* 122 */       if (!this.team_user_list.equals(_o_.team_user_list)) return false;
/* 123 */       if (!this.exchange_data_handler_info_map.equals(_o_.exchange_data_handler_info_map)) return false;
/* 124 */       return true;
/*     */     }
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 130 */     int _h_ = 0;
/* 131 */     _h_ += this.fight_type;
/* 132 */     _h_ += this.fight_stage;
/* 133 */     _h_ += this.fight_index_id;
/* 134 */     _h_ += this.win_or_lose;
/* 135 */     _h_ += (int)this.own_corps_id;
/* 136 */     _h_ += this.own_corps_name.hashCode();
/* 137 */     _h_ += (int)this.opponent_corps_id;
/* 138 */     _h_ += this.opponent_corps_name.hashCode();
/* 139 */     _h_ += this.team_role_list.hashCode();
/* 140 */     _h_ += this.team_user_list.hashCode();
/* 141 */     _h_ += this.exchange_data_handler_info_map.hashCode();
/* 142 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder _sb_ = new StringBuilder();
/* 147 */     _sb_.append("(");
/* 148 */     _sb_.append(this.fight_type).append(",");
/* 149 */     _sb_.append(this.fight_stage).append(",");
/* 150 */     _sb_.append(this.fight_index_id).append(",");
/* 151 */     _sb_.append(this.win_or_lose).append(",");
/* 152 */     _sb_.append(this.own_corps_id).append(",");
/* 153 */     _sb_.append("B").append(this.own_corps_name.size()).append(",");
/* 154 */     _sb_.append(this.opponent_corps_id).append(",");
/* 155 */     _sb_.append("B").append(this.opponent_corps_name.size()).append(",");
/* 156 */     _sb_.append(this.team_role_list).append(",");
/* 157 */     _sb_.append(this.team_user_list).append(",");
/* 158 */     _sb_.append(this.exchange_data_handler_info_map).append(",");
/* 159 */     _sb_.append(")");
/* 160 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SelectionOrFinalDataBackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */