/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class LadderUserDataBack implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public Octets userid;
/*     */   public long roleid;
/*     */   public long ladderscore;
/*     */   public HashMap<String, Octets> usertokenmap;
/*     */   public int changescore;
/*     */   public ArrayList<Long> petids;
/*     */   public HashMap<Long, Integer> childrenmap;
/*     */   public ArrayList<ExchangeDataHandlerInfo> exchange_data_handler_info;
/*     */   
/*     */   public LadderUserDataBack()
/*     */   {
/*  21 */     this.userid = new Octets();
/*  22 */     this.roleid = 0L;
/*  23 */     this.usertokenmap = new HashMap();
/*  24 */     this.petids = new ArrayList();
/*  25 */     this.childrenmap = new HashMap();
/*  26 */     this.exchange_data_handler_info = new ArrayList();
/*     */   }
/*     */   
/*     */   public LadderUserDataBack(Octets _userid_, long _roleid_, long _ladderscore_, HashMap<String, Octets> _usertokenmap_, int _changescore_, ArrayList<Long> _petids_, HashMap<Long, Integer> _childrenmap_, ArrayList<ExchangeDataHandlerInfo> _exchange_data_handler_info_) {
/*  30 */     this.userid = _userid_;
/*  31 */     this.roleid = _roleid_;
/*  32 */     this.ladderscore = _ladderscore_;
/*  33 */     this.usertokenmap = _usertokenmap_;
/*  34 */     this.changescore = _changescore_;
/*  35 */     this.petids = _petids_;
/*  36 */     this.childrenmap = _childrenmap_;
/*  37 */     this.exchange_data_handler_info = _exchange_data_handler_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info)
/*  42 */       if (!_v_._validator_()) return false;
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  47 */     _os_.marshal(this.userid);
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.ladderscore);
/*  50 */     _os_.compact_uint32(this.usertokenmap.size());
/*  51 */     for (java.util.Map.Entry<String, Octets> _e_ : this.usertokenmap.entrySet()) {
/*  52 */       _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/*  53 */       _os_.marshal((Octets)_e_.getValue());
/*     */     }
/*  55 */     _os_.marshal(this.changescore);
/*  56 */     _os_.compact_uint32(this.petids.size());
/*  57 */     for (Long _v_ : this.petids) {
/*  58 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  60 */     _os_.compact_uint32(this.childrenmap.size());
/*  61 */     for (java.util.Map.Entry<Long, Integer> _e_ : this.childrenmap.entrySet()) {
/*  62 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  63 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  65 */     _os_.compact_uint32(this.exchange_data_handler_info.size());
/*  66 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info) {
/*  67 */       _os_.marshal(_v_);
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  73 */     this.userid = _os_.unmarshal_Octets();
/*  74 */     this.roleid = _os_.unmarshal_long();
/*  75 */     this.ladderscore = _os_.unmarshal_long();
/*  76 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  78 */       String _k_ = _os_.unmarshal_String("UTF-16LE");
/*     */       
/*  80 */       Octets _v_ = _os_.unmarshal_Octets();
/*  81 */       this.usertokenmap.put(_k_, _v_);
/*     */     }
/*  83 */     this.changescore = _os_.unmarshal_int();
/*  84 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  86 */       long _v_ = _os_.unmarshal_long();
/*  87 */       this.petids.add(Long.valueOf(_v_));
/*     */     }
/*  89 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  91 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  93 */       int _v_ = _os_.unmarshal_int();
/*  94 */       this.childrenmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  96 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  97 */       ExchangeDataHandlerInfo _v_ = new ExchangeDataHandlerInfo();
/*  98 */       _v_.unmarshal(_os_);
/*  99 */       this.exchange_data_handler_info.add(_v_);
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 105 */     if (_o1_ == this) return true;
/* 106 */     if ((_o1_ instanceof LadderUserDataBack)) {
/* 107 */       LadderUserDataBack _o_ = (LadderUserDataBack)_o1_;
/* 108 */       if (!this.userid.equals(_o_.userid)) return false;
/* 109 */       if (this.roleid != _o_.roleid) return false;
/* 110 */       if (this.ladderscore != _o_.ladderscore) return false;
/* 111 */       if (!this.usertokenmap.equals(_o_.usertokenmap)) return false;
/* 112 */       if (this.changescore != _o_.changescore) return false;
/* 113 */       if (!this.petids.equals(_o_.petids)) return false;
/* 114 */       if (!this.childrenmap.equals(_o_.childrenmap)) return false;
/* 115 */       if (!this.exchange_data_handler_info.equals(_o_.exchange_data_handler_info)) return false;
/* 116 */       return true;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 122 */     int _h_ = 0;
/* 123 */     _h_ += this.userid.hashCode();
/* 124 */     _h_ += (int)this.roleid;
/* 125 */     _h_ += (int)this.ladderscore;
/* 126 */     _h_ += this.usertokenmap.hashCode();
/* 127 */     _h_ += this.changescore;
/* 128 */     _h_ += this.petids.hashCode();
/* 129 */     _h_ += this.childrenmap.hashCode();
/* 130 */     _h_ += this.exchange_data_handler_info.hashCode();
/* 131 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder _sb_ = new StringBuilder();
/* 136 */     _sb_.append("(");
/* 137 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 138 */     _sb_.append(this.roleid).append(",");
/* 139 */     _sb_.append(this.ladderscore).append(",");
/* 140 */     _sb_.append(this.usertokenmap).append(",");
/* 141 */     _sb_.append(this.changescore).append(",");
/* 142 */     _sb_.append(this.petids).append(",");
/* 143 */     _sb_.append(this.childrenmap).append(",");
/* 144 */     _sb_.append(this.exchange_data_handler_info).append(",");
/* 145 */     _sb_.append(")");
/* 146 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\LadderUserDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */