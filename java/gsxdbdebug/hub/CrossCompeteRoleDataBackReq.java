/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class CrossCompeteRoleDataBackReq implements Marshal
/*     */ {
/*     */   public static final int REASON_ACTIVE = 0;
/*     */   public static final int REASON_LACK_ACTION_POINT = 1;
/*     */   public static final int REASON_MAP_ROLE_DESTROY = 2;
/*     */   public static final int REASON_LOSE = 3;
/*     */   public static final int REASON_TREASURE = 4;
/*     */   public static final int REASON_FORCE_END = 5;
/*     */   public static final int REASON_WINNER_ACTIVE = 6;
/*     */   public long roleid;
/*     */   public String userid;
/*     */   public Octets user_token;
/*     */   public int win_times;
/*     */   public int lose_times;
/*     */   public int escape_times;
/*     */   public int win_streak_award_times;
/*     */   public int treasure_award;
/*     */   public int reason;
/*     */   public long win_factionid;
/*     */   public long lose_factionid;
/*     */   public ArrayList<ExchangeDataHandlerInfo> exchange_data_handler_info;
/*     */   
/*     */   public CrossCompeteRoleDataBackReq()
/*     */   {
/*  33 */     this.userid = "";
/*  34 */     this.user_token = new Octets();
/*  35 */     this.win_factionid = 0L;
/*  36 */     this.lose_factionid = 0L;
/*  37 */     this.exchange_data_handler_info = new ArrayList();
/*     */   }
/*     */   
/*     */   public CrossCompeteRoleDataBackReq(long _roleid_, String _userid_, Octets _user_token_, int _win_times_, int _lose_times_, int _escape_times_, int _win_streak_award_times_, int _treasure_award_, int _reason_, long _win_factionid_, long _lose_factionid_, ArrayList<ExchangeDataHandlerInfo> _exchange_data_handler_info_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.userid = _userid_;
/*  43 */     this.user_token = _user_token_;
/*  44 */     this.win_times = _win_times_;
/*  45 */     this.lose_times = _lose_times_;
/*  46 */     this.escape_times = _escape_times_;
/*  47 */     this.win_streak_award_times = _win_streak_award_times_;
/*  48 */     this.treasure_award = _treasure_award_;
/*  49 */     this.reason = _reason_;
/*  50 */     this.win_factionid = _win_factionid_;
/*  51 */     this.lose_factionid = _lose_factionid_;
/*  52 */     this.exchange_data_handler_info = _exchange_data_handler_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info)
/*  57 */       if (!_v_._validator_()) return false;
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.roleid);
/*  63 */     _os_.marshal(this.userid, "UTF-16LE");
/*  64 */     _os_.marshal(this.user_token);
/*  65 */     _os_.marshal(this.win_times);
/*  66 */     _os_.marshal(this.lose_times);
/*  67 */     _os_.marshal(this.escape_times);
/*  68 */     _os_.marshal(this.win_streak_award_times);
/*  69 */     _os_.marshal(this.treasure_award);
/*  70 */     _os_.marshal(this.reason);
/*  71 */     _os_.marshal(this.win_factionid);
/*  72 */     _os_.marshal(this.lose_factionid);
/*  73 */     _os_.compact_uint32(this.exchange_data_handler_info.size());
/*  74 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info) {
/*  75 */       _os_.marshal(_v_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  81 */     this.roleid = _os_.unmarshal_long();
/*  82 */     this.userid = _os_.unmarshal_String("UTF-16LE");
/*  83 */     this.user_token = _os_.unmarshal_Octets();
/*  84 */     this.win_times = _os_.unmarshal_int();
/*  85 */     this.lose_times = _os_.unmarshal_int();
/*  86 */     this.escape_times = _os_.unmarshal_int();
/*  87 */     this.win_streak_award_times = _os_.unmarshal_int();
/*  88 */     this.treasure_award = _os_.unmarshal_int();
/*  89 */     this.reason = _os_.unmarshal_int();
/*  90 */     this.win_factionid = _os_.unmarshal_long();
/*  91 */     this.lose_factionid = _os_.unmarshal_long();
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  93 */       ExchangeDataHandlerInfo _v_ = new ExchangeDataHandlerInfo();
/*  94 */       _v_.unmarshal(_os_);
/*  95 */       this.exchange_data_handler_info.add(_v_);
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 101 */     if (_o1_ == this) return true;
/* 102 */     if ((_o1_ instanceof CrossCompeteRoleDataBackReq)) {
/* 103 */       CrossCompeteRoleDataBackReq _o_ = (CrossCompeteRoleDataBackReq)_o1_;
/* 104 */       if (this.roleid != _o_.roleid) return false;
/* 105 */       if (!this.userid.equals(_o_.userid)) return false;
/* 106 */       if (!this.user_token.equals(_o_.user_token)) return false;
/* 107 */       if (this.win_times != _o_.win_times) return false;
/* 108 */       if (this.lose_times != _o_.lose_times) return false;
/* 109 */       if (this.escape_times != _o_.escape_times) return false;
/* 110 */       if (this.win_streak_award_times != _o_.win_streak_award_times) return false;
/* 111 */       if (this.treasure_award != _o_.treasure_award) return false;
/* 112 */       if (this.reason != _o_.reason) return false;
/* 113 */       if (this.win_factionid != _o_.win_factionid) return false;
/* 114 */       if (this.lose_factionid != _o_.lose_factionid) return false;
/* 115 */       if (!this.exchange_data_handler_info.equals(_o_.exchange_data_handler_info)) return false;
/* 116 */       return true;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 122 */     int _h_ = 0;
/* 123 */     _h_ += (int)this.roleid;
/* 124 */     _h_ += this.userid.hashCode();
/* 125 */     _h_ += this.user_token.hashCode();
/* 126 */     _h_ += this.win_times;
/* 127 */     _h_ += this.lose_times;
/* 128 */     _h_ += this.escape_times;
/* 129 */     _h_ += this.win_streak_award_times;
/* 130 */     _h_ += this.treasure_award;
/* 131 */     _h_ += this.reason;
/* 132 */     _h_ += (int)this.win_factionid;
/* 133 */     _h_ += (int)this.lose_factionid;
/* 134 */     _h_ += this.exchange_data_handler_info.hashCode();
/* 135 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder _sb_ = new StringBuilder();
/* 140 */     _sb_.append("(");
/* 141 */     _sb_.append(this.roleid).append(",");
/* 142 */     _sb_.append("T").append(this.userid.length()).append(",");
/* 143 */     _sb_.append("B").append(this.user_token.size()).append(",");
/* 144 */     _sb_.append(this.win_times).append(",");
/* 145 */     _sb_.append(this.lose_times).append(",");
/* 146 */     _sb_.append(this.escape_times).append(",");
/* 147 */     _sb_.append(this.win_streak_award_times).append(",");
/* 148 */     _sb_.append(this.treasure_award).append(",");
/* 149 */     _sb_.append(this.reason).append(",");
/* 150 */     _sb_.append(this.win_factionid).append(",");
/* 151 */     _sb_.append(this.lose_factionid).append(",");
/* 152 */     _sb_.append(this.exchange_data_handler_info).append(",");
/* 153 */     _sb_.append(")");
/* 154 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteRoleDataBackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */