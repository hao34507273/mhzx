/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class GlobalRoomSpeakerInfoList implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int room_type;
/*    */   public LinkedList<GlobalSpeakerInfo> speaker_infos;
/*    */   
/*    */   public GlobalRoomSpeakerInfoList()
/*    */   {
/* 13 */     this.room_type = 1;
/* 14 */     this.speaker_infos = new LinkedList();
/*    */   }
/*    */   
/*    */   public GlobalRoomSpeakerInfoList(int _room_type_, LinkedList<GlobalSpeakerInfo> _speaker_infos_) {
/* 18 */     this.room_type = _room_type_;
/* 19 */     this.speaker_infos = _speaker_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     for (GlobalSpeakerInfo _v_ : this.speaker_infos)
/* 24 */       if (!_v_._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.room_type);
/* 30 */     _os_.compact_uint32(this.speaker_infos.size());
/* 31 */     for (GlobalSpeakerInfo _v_ : this.speaker_infos) {
/* 32 */       _os_.marshal(_v_);
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.room_type = _os_.unmarshal_int();
/* 39 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 40 */       GlobalSpeakerInfo _v_ = new GlobalSpeakerInfo();
/* 41 */       _v_.unmarshal(_os_);
/* 42 */       this.speaker_infos.add(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof GlobalRoomSpeakerInfoList)) {
/* 50 */       GlobalRoomSpeakerInfoList _o_ = (GlobalRoomSpeakerInfoList)_o1_;
/* 51 */       if (this.room_type != _o_.room_type) return false;
/* 52 */       if (!this.speaker_infos.equals(_o_.speaker_infos)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.room_type;
/* 61 */     _h_ += this.speaker_infos.hashCode();
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.room_type).append(",");
/* 69 */     _sb_.append(this.speaker_infos).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\GlobalRoomSpeakerInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */