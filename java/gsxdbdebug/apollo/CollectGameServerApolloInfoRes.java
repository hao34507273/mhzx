/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class CollectGameServerApolloInfoRes implements Marshal
/*    */ {
/*    */   public int retcode;
/*    */   public LinkedList<SpeakerStatusInfo> speaker_status_infos;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public CollectGameServerApolloInfoRes()
/*    */   {
/* 17 */     this.retcode = 9;
/* 18 */     this.speaker_status_infos = new LinkedList();
/* 19 */     this.reserved1 = 0;
/* 20 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public CollectGameServerApolloInfoRes(int _retcode_, LinkedList<SpeakerStatusInfo> _speaker_status_infos_, int _reserved1_, int _reserved2_) {
/* 24 */     this.retcode = _retcode_;
/* 25 */     this.speaker_status_infos = _speaker_status_infos_;
/* 26 */     this.reserved1 = _reserved1_;
/* 27 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     for (SpeakerStatusInfo _v_ : this.speaker_status_infos)
/* 32 */       if (!_v_._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.retcode);
/* 38 */     _os_.compact_uint32(this.speaker_status_infos.size());
/* 39 */     for (SpeakerStatusInfo _v_ : this.speaker_status_infos) {
/* 40 */       _os_.marshal(_v_);
/*    */     }
/* 42 */     _os_.marshal(this.reserved1);
/* 43 */     _os_.marshal(this.reserved2);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.retcode = _os_.unmarshal_int();
/* 49 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 50 */       SpeakerStatusInfo _v_ = new SpeakerStatusInfo();
/* 51 */       _v_.unmarshal(_os_);
/* 52 */       this.speaker_status_infos.add(_v_);
/*    */     }
/* 54 */     this.reserved1 = _os_.unmarshal_int();
/* 55 */     this.reserved2 = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CollectGameServerApolloInfoRes)) {
/* 62 */       CollectGameServerApolloInfoRes _o_ = (CollectGameServerApolloInfoRes)_o1_;
/* 63 */       if (this.retcode != _o_.retcode) return false;
/* 64 */       if (!this.speaker_status_infos.equals(_o_.speaker_status_infos)) return false;
/* 65 */       if (this.reserved1 != _o_.reserved1) return false;
/* 66 */       if (this.reserved2 != _o_.reserved2) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.retcode;
/* 75 */     _h_ += this.speaker_status_infos.hashCode();
/* 76 */     _h_ += this.reserved1;
/* 77 */     _h_ += this.reserved2;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.retcode).append(",");
/* 85 */     _sb_.append(this.speaker_status_infos).append(",");
/* 86 */     _sb_.append(this.reserved1).append(",");
/* 87 */     _sb_.append(this.reserved2).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\CollectGameServerApolloInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */