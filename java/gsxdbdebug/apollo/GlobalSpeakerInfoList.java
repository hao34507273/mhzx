/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class GlobalSpeakerInfoList implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public LinkedList<GlobalSpeakerInfo> speaker_info_list;
/*    */   
/*    */   public GlobalSpeakerInfoList()
/*    */   {
/* 12 */     this.speaker_info_list = new LinkedList();
/*    */   }
/*    */   
/*    */   public GlobalSpeakerInfoList(LinkedList<GlobalSpeakerInfo> _speaker_info_list_) {
/* 16 */     this.speaker_info_list = _speaker_info_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (GlobalSpeakerInfo _v_ : this.speaker_info_list)
/* 21 */       if (!_v_._validator_()) return false;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.speaker_info_list.size());
/* 27 */     for (GlobalSpeakerInfo _v_ : this.speaker_info_list) {
/* 28 */       _os_.marshal(_v_);
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 35 */       GlobalSpeakerInfo _v_ = new GlobalSpeakerInfo();
/* 36 */       _v_.unmarshal(_os_);
/* 37 */       this.speaker_info_list.add(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof GlobalSpeakerInfoList)) {
/* 45 */       GlobalSpeakerInfoList _o_ = (GlobalSpeakerInfoList)_o1_;
/* 46 */       if (!this.speaker_info_list.equals(_o_.speaker_info_list)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.speaker_info_list.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.speaker_info_list).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\GlobalSpeakerInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */