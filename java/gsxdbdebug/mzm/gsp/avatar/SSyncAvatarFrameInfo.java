/*    */ package mzm.gsp.avatar;
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
/*    */ public class SSyncAvatarFrameInfo
/*    */   extends __SSyncAvatarFrameInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615181;
/*    */   public int current_avatar_frame_id;
/*    */   public LinkedList<AvatarFrameInfo> unlocked_avatar_frame;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615181;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncAvatarFrameInfo()
/*    */   {
/* 34 */     this.unlocked_avatar_frame = new LinkedList();
/*    */   }
/*    */   
/*    */   public SSyncAvatarFrameInfo(int _current_avatar_frame_id_, LinkedList<AvatarFrameInfo> _unlocked_avatar_frame_) {
/* 38 */     this.current_avatar_frame_id = _current_avatar_frame_id_;
/* 39 */     this.unlocked_avatar_frame = _unlocked_avatar_frame_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (AvatarFrameInfo _v_ : this.unlocked_avatar_frame)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.current_avatar_frame_id);
/* 50 */     _os_.compact_uint32(this.unlocked_avatar_frame.size());
/* 51 */     for (AvatarFrameInfo _v_ : this.unlocked_avatar_frame) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.current_avatar_frame_id = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       AvatarFrameInfo _v_ = new AvatarFrameInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.unlocked_avatar_frame.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSyncAvatarFrameInfo)) {
/* 73 */       SSyncAvatarFrameInfo _o_ = (SSyncAvatarFrameInfo)_o1_;
/* 74 */       if (this.current_avatar_frame_id != _o_.current_avatar_frame_id) return false;
/* 75 */       if (!this.unlocked_avatar_frame.equals(_o_.unlocked_avatar_frame)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.current_avatar_frame_id;
/* 84 */     _h_ += this.unlocked_avatar_frame.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.current_avatar_frame_id).append(",");
/* 92 */     _sb_.append(this.unlocked_avatar_frame).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\SSyncAvatarFrameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */