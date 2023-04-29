/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class GrcGetUserReceiveGiftInfoListRes implements Marshal
/*     */ {
/*     */   public int retcode;
/*     */   public int page_index;
/*     */   public int receive_gift_total_count;
/*     */   public ArrayList<GrcUserReceiveGiftTimesInfo> user_receive_gift_times_infos;
/*     */   public ArrayList<GrcUserReceiveGiftMetaInfo> user_receive_gift_meta_infos;
/*     */   public ArrayList<GrcReceiveGiftInfo> receive_gift_infos;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcGetUserReceiveGiftInfoListRes()
/*     */   {
/*  21 */     this.retcode = 9;
/*  22 */     this.user_receive_gift_times_infos = new ArrayList();
/*  23 */     this.user_receive_gift_meta_infos = new ArrayList();
/*  24 */     this.receive_gift_infos = new ArrayList();
/*  25 */     this.reserved1 = 0;
/*  26 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcGetUserReceiveGiftInfoListRes(int _retcode_, int _page_index_, int _receive_gift_total_count_, ArrayList<GrcUserReceiveGiftTimesInfo> _user_receive_gift_times_infos_, ArrayList<GrcUserReceiveGiftMetaInfo> _user_receive_gift_meta_infos_, ArrayList<GrcReceiveGiftInfo> _receive_gift_infos_, int _reserved1_, int _reserved2_) {
/*  30 */     this.retcode = _retcode_;
/*  31 */     this.page_index = _page_index_;
/*  32 */     this.receive_gift_total_count = _receive_gift_total_count_;
/*  33 */     this.user_receive_gift_times_infos = _user_receive_gift_times_infos_;
/*  34 */     this.user_receive_gift_meta_infos = _user_receive_gift_meta_infos_;
/*  35 */     this.receive_gift_infos = _receive_gift_infos_;
/*  36 */     this.reserved1 = _reserved1_;
/*  37 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     for (GrcUserReceiveGiftTimesInfo _v_ : this.user_receive_gift_times_infos)
/*  42 */       if (!_v_._validator_()) return false;
/*  43 */     for (GrcUserReceiveGiftMetaInfo _v_ : this.user_receive_gift_meta_infos)
/*  44 */       if (!_v_._validator_()) return false;
/*  45 */     for (GrcReceiveGiftInfo _v_ : this.receive_gift_infos)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.retcode);
/*  52 */     _os_.marshal(this.page_index);
/*  53 */     _os_.marshal(this.receive_gift_total_count);
/*  54 */     _os_.compact_uint32(this.user_receive_gift_times_infos.size());
/*  55 */     for (GrcUserReceiveGiftTimesInfo _v_ : this.user_receive_gift_times_infos) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.compact_uint32(this.user_receive_gift_meta_infos.size());
/*  59 */     for (GrcUserReceiveGiftMetaInfo _v_ : this.user_receive_gift_meta_infos) {
/*  60 */       _os_.marshal(_v_);
/*     */     }
/*  62 */     _os_.compact_uint32(this.receive_gift_infos.size());
/*  63 */     for (GrcReceiveGiftInfo _v_ : this.receive_gift_infos) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     _os_.marshal(this.reserved1);
/*  67 */     _os_.marshal(this.reserved2);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.retcode = _os_.unmarshal_int();
/*  73 */     this.page_index = _os_.unmarshal_int();
/*  74 */     this.receive_gift_total_count = _os_.unmarshal_int();
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  76 */       GrcUserReceiveGiftTimesInfo _v_ = new GrcUserReceiveGiftTimesInfo();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.user_receive_gift_times_infos.add(_v_);
/*     */     }
/*  80 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  81 */       GrcUserReceiveGiftMetaInfo _v_ = new GrcUserReceiveGiftMetaInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.user_receive_gift_meta_infos.add(_v_);
/*     */     }
/*  85 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  86 */       GrcReceiveGiftInfo _v_ = new GrcReceiveGiftInfo();
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.receive_gift_infos.add(_v_);
/*     */     }
/*  90 */     this.reserved1 = _os_.unmarshal_int();
/*  91 */     this.reserved2 = _os_.unmarshal_int();
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  96 */     if (_o1_ == this) return true;
/*  97 */     if ((_o1_ instanceof GrcGetUserReceiveGiftInfoListRes)) {
/*  98 */       GrcGetUserReceiveGiftInfoListRes _o_ = (GrcGetUserReceiveGiftInfoListRes)_o1_;
/*  99 */       if (this.retcode != _o_.retcode) return false;
/* 100 */       if (this.page_index != _o_.page_index) return false;
/* 101 */       if (this.receive_gift_total_count != _o_.receive_gift_total_count) return false;
/* 102 */       if (!this.user_receive_gift_times_infos.equals(_o_.user_receive_gift_times_infos)) return false;
/* 103 */       if (!this.user_receive_gift_meta_infos.equals(_o_.user_receive_gift_meta_infos)) return false;
/* 104 */       if (!this.receive_gift_infos.equals(_o_.receive_gift_infos)) return false;
/* 105 */       if (this.reserved1 != _o_.reserved1) return false;
/* 106 */       if (this.reserved2 != _o_.reserved2) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += this.retcode;
/* 115 */     _h_ += this.page_index;
/* 116 */     _h_ += this.receive_gift_total_count;
/* 117 */     _h_ += this.user_receive_gift_times_infos.hashCode();
/* 118 */     _h_ += this.user_receive_gift_meta_infos.hashCode();
/* 119 */     _h_ += this.receive_gift_infos.hashCode();
/* 120 */     _h_ += this.reserved1;
/* 121 */     _h_ += this.reserved2;
/* 122 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 126 */     StringBuilder _sb_ = new StringBuilder();
/* 127 */     _sb_.append("(");
/* 128 */     _sb_.append(this.retcode).append(",");
/* 129 */     _sb_.append(this.page_index).append(",");
/* 130 */     _sb_.append(this.receive_gift_total_count).append(",");
/* 131 */     _sb_.append(this.user_receive_gift_times_infos).append(",");
/* 132 */     _sb_.append(this.user_receive_gift_meta_infos).append(",");
/* 133 */     _sb_.append(this.receive_gift_infos).append(",");
/* 134 */     _sb_.append(this.reserved1).append(",");
/* 135 */     _sb_.append(this.reserved2).append(",");
/* 136 */     _sb_.append(")");
/* 137 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetUserReceiveGiftInfoListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */