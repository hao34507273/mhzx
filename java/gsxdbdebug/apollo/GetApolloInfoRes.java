/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class GetApolloInfoRes implements Marshal
/*     */ {
/*     */   public int retcode;
/*     */   public int businessid;
/*     */   public HashMap<Integer, GlobalRoomInfo> global_room_infos;
/*     */   public HashMap<Integer, GlobalSpeakerInfoList> global_room_to_speaker_info_list;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GetApolloInfoRes()
/*     */   {
/*  19 */     this.retcode = 9;
/*  20 */     this.global_room_infos = new HashMap();
/*  21 */     this.global_room_to_speaker_info_list = new HashMap();
/*  22 */     this.reserved1 = 0;
/*  23 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GetApolloInfoRes(int _retcode_, int _businessid_, HashMap<Integer, GlobalRoomInfo> _global_room_infos_, HashMap<Integer, GlobalSpeakerInfoList> _global_room_to_speaker_info_list_, int _reserved1_, int _reserved2_) {
/*  27 */     this.retcode = _retcode_;
/*  28 */     this.businessid = _businessid_;
/*  29 */     this.global_room_infos = _global_room_infos_;
/*  30 */     this.global_room_to_speaker_info_list = _global_room_to_speaker_info_list_;
/*  31 */     this.reserved1 = _reserved1_;
/*  32 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     for (Map.Entry<Integer, GlobalRoomInfo> _e_ : this.global_room_infos.entrySet()) {
/*  37 */       if (!((GlobalRoomInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  39 */     for (Map.Entry<Integer, GlobalSpeakerInfoList> _e_ : this.global_room_to_speaker_info_list.entrySet()) {
/*  40 */       if (!((GlobalSpeakerInfoList)_e_.getValue())._validator_()) return false;
/*     */     }
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.retcode);
/*  47 */     _os_.marshal(this.businessid);
/*  48 */     _os_.compact_uint32(this.global_room_infos.size());
/*  49 */     for (Map.Entry<Integer, GlobalRoomInfo> _e_ : this.global_room_infos.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  53 */     _os_.compact_uint32(this.global_room_to_speaker_info_list.size());
/*  54 */     for (Map.Entry<Integer, GlobalSpeakerInfoList> _e_ : this.global_room_to_speaker_info_list.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  58 */     _os_.marshal(this.reserved1);
/*  59 */     _os_.marshal(this.reserved2);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  64 */     this.retcode = _os_.unmarshal_int();
/*  65 */     this.businessid = _os_.unmarshal_int();
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*  69 */       GlobalRoomInfo _v_ = new GlobalRoomInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.global_room_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  73 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  75 */       int _k_ = _os_.unmarshal_int();
/*  76 */       GlobalSpeakerInfoList _v_ = new GlobalSpeakerInfoList();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.global_room_to_speaker_info_list.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  80 */     this.reserved1 = _os_.unmarshal_int();
/*  81 */     this.reserved2 = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof GetApolloInfoRes)) {
/*  88 */       GetApolloInfoRes _o_ = (GetApolloInfoRes)_o1_;
/*  89 */       if (this.retcode != _o_.retcode) return false;
/*  90 */       if (this.businessid != _o_.businessid) return false;
/*  91 */       if (!this.global_room_infos.equals(_o_.global_room_infos)) return false;
/*  92 */       if (!this.global_room_to_speaker_info_list.equals(_o_.global_room_to_speaker_info_list)) return false;
/*  93 */       if (this.reserved1 != _o_.reserved1) return false;
/*  94 */       if (this.reserved2 != _o_.reserved2) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += this.retcode;
/* 103 */     _h_ += this.businessid;
/* 104 */     _h_ += this.global_room_infos.hashCode();
/* 105 */     _h_ += this.global_room_to_speaker_info_list.hashCode();
/* 106 */     _h_ += this.reserved1;
/* 107 */     _h_ += this.reserved2;
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append(this.retcode).append(",");
/* 115 */     _sb_.append(this.businessid).append(",");
/* 116 */     _sb_.append(this.global_room_infos).append(",");
/* 117 */     _sb_.append(this.global_room_to_speaker_info_list).append(",");
/* 118 */     _sb_.append(this.reserved1).append(",");
/* 119 */     _sb_.append(this.reserved2).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\GetApolloInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */