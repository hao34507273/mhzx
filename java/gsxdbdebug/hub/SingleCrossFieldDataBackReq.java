/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SingleCrossFieldDataBackReq implements Marshal
/*     */ {
/*     */   public static final int BACK_REASON_ACTIVE_LEAVE = 0;
/*     */   public static final int BACK_REASON_OVER_CLEAN = 1;
/*     */   public static final int RESULT_WIN = 0;
/*     */   public static final int RESULT_LOSE = 1;
/*     */   public static final int RESULT_TIE = 2;
/*     */   public Octets userid;
/*     */   public long roleid;
/*     */   public byte back_reason;
/*     */   public int season;
/*     */   public byte result;
/*     */   public int change_point;
/*     */   public byte is_mvp;
/*     */   public long start_timestamp;
/*     */   public int pvp_fight_times;
/*     */   public ArrayList<ExchangeDataHandlerInfo> exchange_data_handler_info;
/*     */   
/*     */   public SingleCrossFieldDataBackReq()
/*     */   {
/*  29 */     this.userid = new Octets();
/*  30 */     this.roleid = 0L;
/*  31 */     this.exchange_data_handler_info = new ArrayList();
/*     */   }
/*     */   
/*     */   public SingleCrossFieldDataBackReq(Octets _userid_, long _roleid_, byte _back_reason_, int _season_, byte _result_, int _change_point_, byte _is_mvp_, long _start_timestamp_, int _pvp_fight_times_, ArrayList<ExchangeDataHandlerInfo> _exchange_data_handler_info_) {
/*  35 */     this.userid = _userid_;
/*  36 */     this.roleid = _roleid_;
/*  37 */     this.back_reason = _back_reason_;
/*  38 */     this.season = _season_;
/*  39 */     this.result = _result_;
/*  40 */     this.change_point = _change_point_;
/*  41 */     this.is_mvp = _is_mvp_;
/*  42 */     this.start_timestamp = _start_timestamp_;
/*  43 */     this.pvp_fight_times = _pvp_fight_times_;
/*  44 */     this.exchange_data_handler_info = _exchange_data_handler_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.userid);
/*  55 */     _os_.marshal(this.roleid);
/*  56 */     _os_.marshal(this.back_reason);
/*  57 */     _os_.marshal(this.season);
/*  58 */     _os_.marshal(this.result);
/*  59 */     _os_.marshal(this.change_point);
/*  60 */     _os_.marshal(this.is_mvp);
/*  61 */     _os_.marshal(this.start_timestamp);
/*  62 */     _os_.marshal(this.pvp_fight_times);
/*  63 */     _os_.compact_uint32(this.exchange_data_handler_info.size());
/*  64 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info) {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.userid = _os_.unmarshal_Octets();
/*  72 */     this.roleid = _os_.unmarshal_long();
/*  73 */     this.back_reason = _os_.unmarshal_byte();
/*  74 */     this.season = _os_.unmarshal_int();
/*  75 */     this.result = _os_.unmarshal_byte();
/*  76 */     this.change_point = _os_.unmarshal_int();
/*  77 */     this.is_mvp = _os_.unmarshal_byte();
/*  78 */     this.start_timestamp = _os_.unmarshal_long();
/*  79 */     this.pvp_fight_times = _os_.unmarshal_int();
/*  80 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  81 */       ExchangeDataHandlerInfo _v_ = new ExchangeDataHandlerInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.exchange_data_handler_info.add(_v_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SingleCrossFieldDataBackReq)) {
/*  91 */       SingleCrossFieldDataBackReq _o_ = (SingleCrossFieldDataBackReq)_o1_;
/*  92 */       if (!this.userid.equals(_o_.userid)) return false;
/*  93 */       if (this.roleid != _o_.roleid) return false;
/*  94 */       if (this.back_reason != _o_.back_reason) return false;
/*  95 */       if (this.season != _o_.season) return false;
/*  96 */       if (this.result != _o_.result) return false;
/*  97 */       if (this.change_point != _o_.change_point) return false;
/*  98 */       if (this.is_mvp != _o_.is_mvp) return false;
/*  99 */       if (this.start_timestamp != _o_.start_timestamp) return false;
/* 100 */       if (this.pvp_fight_times != _o_.pvp_fight_times) return false;
/* 101 */       if (!this.exchange_data_handler_info.equals(_o_.exchange_data_handler_info)) return false;
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 108 */     int _h_ = 0;
/* 109 */     _h_ += this.userid.hashCode();
/* 110 */     _h_ += (int)this.roleid;
/* 111 */     _h_ += this.back_reason;
/* 112 */     _h_ += this.season;
/* 113 */     _h_ += this.result;
/* 114 */     _h_ += this.change_point;
/* 115 */     _h_ += this.is_mvp;
/* 116 */     _h_ += (int)this.start_timestamp;
/* 117 */     _h_ += this.pvp_fight_times;
/* 118 */     _h_ += this.exchange_data_handler_info.hashCode();
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 126 */     _sb_.append(this.roleid).append(",");
/* 127 */     _sb_.append(this.back_reason).append(",");
/* 128 */     _sb_.append(this.season).append(",");
/* 129 */     _sb_.append(this.result).append(",");
/* 130 */     _sb_.append(this.change_point).append(",");
/* 131 */     _sb_.append(this.is_mvp).append(",");
/* 132 */     _sb_.append(this.start_timestamp).append(",");
/* 133 */     _sb_.append(this.pvp_fight_times).append(",");
/* 134 */     _sb_.append(this.exchange_data_handler_info).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SingleCrossFieldDataBackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */