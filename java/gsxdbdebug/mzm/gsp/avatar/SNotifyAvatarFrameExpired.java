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
/*    */ public class SNotifyAvatarFrameExpired
/*    */   extends __SNotifyAvatarFrameExpired__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615188;
/*    */   public int current_avatar_frame_id;
/*    */   public LinkedList<Integer> expired_avatar_frame_ids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615188;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyAvatarFrameExpired()
/*    */   {
/* 34 */     this.expired_avatar_frame_ids = new LinkedList();
/*    */   }
/*    */   
/*    */   public SNotifyAvatarFrameExpired(int _current_avatar_frame_id_, LinkedList<Integer> _expired_avatar_frame_ids_) {
/* 38 */     this.current_avatar_frame_id = _current_avatar_frame_id_;
/* 39 */     this.expired_avatar_frame_ids = _expired_avatar_frame_ids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.current_avatar_frame_id);
/* 48 */     _os_.compact_uint32(this.expired_avatar_frame_ids.size());
/* 49 */     for (Integer _v_ : this.expired_avatar_frame_ids) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.current_avatar_frame_id = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.expired_avatar_frame_ids.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SNotifyAvatarFrameExpired)) {
/* 71 */       SNotifyAvatarFrameExpired _o_ = (SNotifyAvatarFrameExpired)_o1_;
/* 72 */       if (this.current_avatar_frame_id != _o_.current_avatar_frame_id) return false;
/* 73 */       if (!this.expired_avatar_frame_ids.equals(_o_.expired_avatar_frame_ids)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.current_avatar_frame_id;
/* 82 */     _h_ += this.expired_avatar_frame_ids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.current_avatar_frame_id).append(",");
/* 90 */     _sb_.append(this.expired_avatar_frame_ids).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\SNotifyAvatarFrameExpired.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */