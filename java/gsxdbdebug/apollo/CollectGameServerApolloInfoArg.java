/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class CollectGameServerApolloInfoArg implements Marshal
/*    */ {
/*    */   public HashMap<Integer, GlobalRoomInfo> global_room_infos;
/*    */   public HashMap<Integer, GlobalSpeakerInfoList> global_room_to_speaker_info_list;
/*    */   
/*    */   public CollectGameServerApolloInfoArg()
/*    */   {
/* 15 */     this.global_room_infos = new HashMap();
/* 16 */     this.global_room_to_speaker_info_list = new HashMap();
/*    */   }
/*    */   
/*    */   public CollectGameServerApolloInfoArg(HashMap<Integer, GlobalRoomInfo> _global_room_infos_, HashMap<Integer, GlobalSpeakerInfoList> _global_room_to_speaker_info_list_) {
/* 20 */     this.global_room_infos = _global_room_infos_;
/* 21 */     this.global_room_to_speaker_info_list = _global_room_to_speaker_info_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     for (Map.Entry<Integer, GlobalRoomInfo> _e_ : this.global_room_infos.entrySet()) {
/* 26 */       if (!((GlobalRoomInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 28 */     for (Map.Entry<Integer, GlobalSpeakerInfoList> _e_ : this.global_room_to_speaker_info_list.entrySet()) {
/* 29 */       if (!((GlobalSpeakerInfoList)_e_.getValue())._validator_()) return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.compact_uint32(this.global_room_infos.size());
/* 36 */     for (Map.Entry<Integer, GlobalRoomInfo> _e_ : this.global_room_infos.entrySet()) {
/* 37 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 38 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 40 */     _os_.compact_uint32(this.global_room_to_speaker_info_list.size());
/* 41 */     for (Map.Entry<Integer, GlobalSpeakerInfoList> _e_ : this.global_room_to_speaker_info_list.entrySet()) {
/* 42 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 43 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 49 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 51 */       int _k_ = _os_.unmarshal_int();
/* 52 */       GlobalRoomInfo _v_ = new GlobalRoomInfo();
/* 53 */       _v_.unmarshal(_os_);
/* 54 */       this.global_room_infos.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 56 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       int _k_ = _os_.unmarshal_int();
/* 59 */       GlobalSpeakerInfoList _v_ = new GlobalSpeakerInfoList();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.global_room_to_speaker_info_list.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CollectGameServerApolloInfoArg)) {
/* 69 */       CollectGameServerApolloInfoArg _o_ = (CollectGameServerApolloInfoArg)_o1_;
/* 70 */       if (!this.global_room_infos.equals(_o_.global_room_infos)) return false;
/* 71 */       if (!this.global_room_to_speaker_info_list.equals(_o_.global_room_to_speaker_info_list)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.global_room_infos.hashCode();
/* 80 */     _h_ += this.global_room_to_speaker_info_list.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.global_room_infos).append(",");
/* 88 */     _sb_.append(this.global_room_to_speaker_info_list).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\CollectGameServerApolloInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */