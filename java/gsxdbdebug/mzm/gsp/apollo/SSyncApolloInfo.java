/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncApolloInfo
/*    */   extends __SSyncApolloInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602629;
/*    */   public int business_id;
/*    */   public LinkedList<GlobalRoomSpeakerInfoList> global_room_speaker_info_lists;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602629;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncApolloInfo()
/*    */   {
/* 34 */     this.global_room_speaker_info_lists = new LinkedList();
/*    */   }
/*    */   
/*    */   public SSyncApolloInfo(int _business_id_, LinkedList<GlobalRoomSpeakerInfoList> _global_room_speaker_info_lists_) {
/* 38 */     this.business_id = _business_id_;
/* 39 */     this.global_room_speaker_info_lists = _global_room_speaker_info_lists_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (GlobalRoomSpeakerInfoList _v_ : this.global_room_speaker_info_lists)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.business_id);
/* 50 */     _os_.compact_uint32(this.global_room_speaker_info_lists.size());
/* 51 */     for (GlobalRoomSpeakerInfoList _v_ : this.global_room_speaker_info_lists) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.business_id = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       GlobalRoomSpeakerInfoList _v_ = new GlobalRoomSpeakerInfoList();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.global_room_speaker_info_lists.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSyncApolloInfo)) {
/* 73 */       SSyncApolloInfo _o_ = (SSyncApolloInfo)_o1_;
/* 74 */       if (this.business_id != _o_.business_id) return false;
/* 75 */       if (!this.global_room_speaker_info_lists.equals(_o_.global_room_speaker_info_lists)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.business_id;
/* 84 */     _h_ += this.global_room_speaker_info_lists.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.business_id).append(",");
/* 92 */     _sb_.append(this.global_room_speaker_info_lists).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SSyncApolloInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */