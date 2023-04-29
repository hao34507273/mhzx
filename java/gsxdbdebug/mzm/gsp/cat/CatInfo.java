/*     */ package mzm.gsp.cat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class CatInfo
/*     */   implements Marshal
/*     */ {
/*     */   public static final int STATE_NORMAL = 1;
/*     */   public static final int STATE_EXPLORE = 2;
/*     */   public static final int STATE_RESET = 3;
/*     */   public long id;
/*     */   public int item_cfgid;
/*     */   public Octets name;
/*     */   public int explore_num;
/*     */   public int total_explore_num;
/*     */   public int vigor;
/*     */   public byte state;
/*     */   public byte is_award;
/*     */   public int explore_end_timestamp;
/*     */   public int partner_cfgid;
/*     */   
/*     */   public CatInfo()
/*     */   {
/*  27 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public CatInfo(long _id_, int _item_cfgid_, Octets _name_, int _explore_num_, int _total_explore_num_, int _vigor_, byte _state_, byte _is_award_, int _explore_end_timestamp_, int _partner_cfgid_) {
/*  31 */     this.id = _id_;
/*  32 */     this.item_cfgid = _item_cfgid_;
/*  33 */     this.name = _name_;
/*  34 */     this.explore_num = _explore_num_;
/*  35 */     this.total_explore_num = _total_explore_num_;
/*  36 */     this.vigor = _vigor_;
/*  37 */     this.state = _state_;
/*  38 */     this.is_award = _is_award_;
/*  39 */     this.explore_end_timestamp = _explore_end_timestamp_;
/*  40 */     this.partner_cfgid = _partner_cfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.id);
/*  49 */     _os_.marshal(this.item_cfgid);
/*  50 */     _os_.marshal(this.name);
/*  51 */     _os_.marshal(this.explore_num);
/*  52 */     _os_.marshal(this.total_explore_num);
/*  53 */     _os_.marshal(this.vigor);
/*  54 */     _os_.marshal(this.state);
/*  55 */     _os_.marshal(this.is_award);
/*  56 */     _os_.marshal(this.explore_end_timestamp);
/*  57 */     _os_.marshal(this.partner_cfgid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.id = _os_.unmarshal_long();
/*  63 */     this.item_cfgid = _os_.unmarshal_int();
/*  64 */     this.name = _os_.unmarshal_Octets();
/*  65 */     this.explore_num = _os_.unmarshal_int();
/*  66 */     this.total_explore_num = _os_.unmarshal_int();
/*  67 */     this.vigor = _os_.unmarshal_int();
/*  68 */     this.state = _os_.unmarshal_byte();
/*  69 */     this.is_award = _os_.unmarshal_byte();
/*  70 */     this.explore_end_timestamp = _os_.unmarshal_int();
/*  71 */     this.partner_cfgid = _os_.unmarshal_int();
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CatInfo)) {
/*  78 */       CatInfo _o_ = (CatInfo)_o1_;
/*  79 */       if (this.id != _o_.id) return false;
/*  80 */       if (this.item_cfgid != _o_.item_cfgid) return false;
/*  81 */       if (!this.name.equals(_o_.name)) return false;
/*  82 */       if (this.explore_num != _o_.explore_num) return false;
/*  83 */       if (this.total_explore_num != _o_.total_explore_num) return false;
/*  84 */       if (this.vigor != _o_.vigor) return false;
/*  85 */       if (this.state != _o_.state) return false;
/*  86 */       if (this.is_award != _o_.is_award) return false;
/*  87 */       if (this.explore_end_timestamp != _o_.explore_end_timestamp) return false;
/*  88 */       if (this.partner_cfgid != _o_.partner_cfgid) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += (int)this.id;
/*  97 */     _h_ += this.item_cfgid;
/*  98 */     _h_ += this.name.hashCode();
/*  99 */     _h_ += this.explore_num;
/* 100 */     _h_ += this.total_explore_num;
/* 101 */     _h_ += this.vigor;
/* 102 */     _h_ += this.state;
/* 103 */     _h_ += this.is_award;
/* 104 */     _h_ += this.explore_end_timestamp;
/* 105 */     _h_ += this.partner_cfgid;
/* 106 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder _sb_ = new StringBuilder();
/* 111 */     _sb_.append("(");
/* 112 */     _sb_.append(this.id).append(",");
/* 113 */     _sb_.append(this.item_cfgid).append(",");
/* 114 */     _sb_.append("B").append(this.name.size()).append(",");
/* 115 */     _sb_.append(this.explore_num).append(",");
/* 116 */     _sb_.append(this.total_explore_num).append(",");
/* 117 */     _sb_.append(this.vigor).append(",");
/* 118 */     _sb_.append(this.state).append(",");
/* 119 */     _sb_.append(this.is_award).append(",");
/* 120 */     _sb_.append(this.explore_end_timestamp).append(",");
/* 121 */     _sb_.append(this.partner_cfgid).append(",");
/* 122 */     _sb_.append(")");
/* 123 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\CatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */