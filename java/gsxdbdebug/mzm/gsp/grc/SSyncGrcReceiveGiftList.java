/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncGrcReceiveGiftList
/*     */   extends __SSyncGrcReceiveGiftList__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600335;
/*     */   public int total_count;
/*     */   public int page_index;
/*     */   public ArrayList<GrcUserReceiveGiftTimesInfo> user_receive_gift_times_infos;
/*     */   public ArrayList<GrcReceiveGiftInfo> receive_gift_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600335;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGrcReceiveGiftList()
/*     */   {
/*  36 */     this.user_receive_gift_times_infos = new ArrayList();
/*  37 */     this.receive_gift_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncGrcReceiveGiftList(int _total_count_, int _page_index_, ArrayList<GrcUserReceiveGiftTimesInfo> _user_receive_gift_times_infos_, ArrayList<GrcReceiveGiftInfo> _receive_gift_infos_) {
/*  41 */     this.total_count = _total_count_;
/*  42 */     this.page_index = _page_index_;
/*  43 */     this.user_receive_gift_times_infos = _user_receive_gift_times_infos_;
/*  44 */     this.receive_gift_infos = _receive_gift_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     for (GrcUserReceiveGiftTimesInfo _v_ : this.user_receive_gift_times_infos)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     for (GrcReceiveGiftInfo _v_ : this.receive_gift_infos)
/*  51 */       if (!_v_._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.total_count);
/*  57 */     _os_.marshal(this.page_index);
/*  58 */     _os_.compact_uint32(this.user_receive_gift_times_infos.size());
/*  59 */     for (GrcUserReceiveGiftTimesInfo _v_ : this.user_receive_gift_times_infos) {
/*  60 */       _os_.marshal(_v_);
/*     */     }
/*  62 */     _os_.compact_uint32(this.receive_gift_infos.size());
/*  63 */     for (GrcReceiveGiftInfo _v_ : this.receive_gift_infos) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.total_count = _os_.unmarshal_int();
/*  71 */     this.page_index = _os_.unmarshal_int();
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  73 */       GrcUserReceiveGiftTimesInfo _v_ = new GrcUserReceiveGiftTimesInfo();
/*  74 */       _v_.unmarshal(_os_);
/*  75 */       this.user_receive_gift_times_infos.add(_v_);
/*     */     }
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  78 */       GrcReceiveGiftInfo _v_ = new GrcReceiveGiftInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.receive_gift_infos.add(_v_);
/*     */     }
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SSyncGrcReceiveGiftList)) {
/*  91 */       SSyncGrcReceiveGiftList _o_ = (SSyncGrcReceiveGiftList)_o1_;
/*  92 */       if (this.total_count != _o_.total_count) return false;
/*  93 */       if (this.page_index != _o_.page_index) return false;
/*  94 */       if (!this.user_receive_gift_times_infos.equals(_o_.user_receive_gift_times_infos)) return false;
/*  95 */       if (!this.receive_gift_infos.equals(_o_.receive_gift_infos)) return false;
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 102 */     int _h_ = 0;
/* 103 */     _h_ += this.total_count;
/* 104 */     _h_ += this.page_index;
/* 105 */     _h_ += this.user_receive_gift_times_infos.hashCode();
/* 106 */     _h_ += this.receive_gift_infos.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.total_count).append(",");
/* 114 */     _sb_.append(this.page_index).append(",");
/* 115 */     _sb_.append(this.user_receive_gift_times_infos).append(",");
/* 116 */     _sb_.append(this.receive_gift_infos).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SSyncGrcReceiveGiftList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */